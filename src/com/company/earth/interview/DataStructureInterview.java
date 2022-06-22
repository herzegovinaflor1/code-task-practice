package com.company.earth.interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataStructureInterview {

    public static void main(String[] args) {
        DataStructureInterview dataStructureInterview = new DataStructureInterview();
        dataStructureInterview.findWinner(Collections.emptyList());
    }

    /**
         Input
         votes = [
             {
                "teamName": ["A", "B"]
             },
             {
                "teamName": ["C", "B"]
             },
             {
                "teamName":  ["B"]
             },
             {
                "teamName": ["A"]
             }
         ]

         Output
         {
             B: 7
             A: 6
             C: 3
         }

     Corner case:
     If scores are the same, the winner is comes from number of 1st place

     [A, B, C]
     [D, B, A]
     Winner: A

     */
    /**
     * For a list of votes, return an ordered set of candidate in descending order of their votes.
     */
    List<String> findWinner(List<Vote> votes) {
        if (votes != null && !votes.isEmpty()) {
            Map<String, Integer> teamToVote = new HashMap<>();
            votes.forEach(vote -> {
                List<String> votedTeams = vote.votedTeams;
                validateVotes(votedTeams);
                determineTheVoteGrade(votedTeams, teamToVote);
            });

            return teamToVote.entrySet().stream()
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    static class Vote {
        List<String> votedTeams;

        public Vote(List<String> votedTeams) {
            this.votedTeams = votedTeams;
        }
    }

    private void determineTheVoteGrade(List<String> votedTeams, Map<String, Integer> teamToVote) {
        int accum = 3;
        // float coeff = 1.5f;
        for (int i = 0; i < votedTeams.size(); i++) {
            //int teamCoeff *=coeff; //
            int rate = accum - i; // 2
            String team = votedTeams.get(i); //
            teamToVote.computeIfPresent(team, (k, v) -> v + rate);
            teamToVote.putIfAbsent(team, rate);
            // coeff -= 0.5f;
        }
    }

    private void validateVotes(List<String> votedTeams) {
        if (votedTeams == null || votedTeams.isEmpty()) {
            throw new RuntimeException("The votes are invalid: " + votedTeams);
        }
        if (votedTeams.size() > 3) {
            throw new RuntimeException("Votes should be from 1 to 3");
        }
    }

}

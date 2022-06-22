package com.company.mars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<Set<String>> merchants = new ArrayList<>();
        merchants.add(new HashSet<>(Arrays.asList("C", "P", "W")));
        merchants.add(new HashSet<>(Arrays.asList("P", "W", "T")));
        merchants.add(new HashSet<>(Arrays.asList("W", "T", "P")));

        Map<String, List<String>> outcome = new HashMap<>();

        Set<String> uniqueMerchants = merchants.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        for(Set<String> row: merchants) {
            uniqueMerchants.addAll(row);
        }
        // uniqueMerchants => [Casper, ...]


        Map<String, Long> merchantToCount = new HashMap<>(); //
        for(String uniqMerch: uniqueMerchants) {
            AtomicLong maxOccurrenceForUniqueRow = new AtomicLong(1);
            for(Set<String> row: merchants) {
                if (row.contains(uniqMerch)) {
                    for(String merchant: row) {
                        if (!uniqMerch.equals(merchant)) {
                            merchantToCount.computeIfPresent(merchant, (key, val) -> {
                                long newVal = val + 1;
                                if (newVal > maxOccurrenceForUniqueRow.get()) {
                                    maxOccurrenceForUniqueRow.set(newVal);
                                }
                                return newVal;
                            });
                            merchantToCount.putIfAbsent(merchant, 1L);
                        }
                    }
                }
            }

            List<String> suggestedMerchants = merchantToCount.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maxOccurrenceForUniqueRow.get()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            outcome.put(uniqMerch, suggestedMerchants);
            merchantToCount = new HashMap<>();
        }

        System.out.print(outcome);
    }

}

/**

 #  Some partners with a lot of merchants today and many users will make purchases at more than one merchant. We'd like to analyze that cross purchasing behavior to make recommendations to new user about where else they might like to shop. Imagine we have a list where each entry is an individual user's history of purchases, i.e., the list of merchants that the user has made a purchase at. We want to take that list and find, for any merchant with at least one purchase, what other merchant(s) are most frequently seen in users' shopping behavior. e.g. [['Casper', 'Purple', 'Wayfair'],['Purple', 'Wayfair', 'Tradesy'],['Wayfair', 'Tradesy', 'Peloton']]

 # [['Casper', 'Purple', 'Wayfair'],['Purple', 'Wayfair', 'Tradesy'],['Wayfair', 'Tradesy', 'Peloton']] =>
 #  {
 #    'Casper': ['Purple', 'Wayfair'],
 #    'Purple': ['Wayfair'],
 #    'Wayfair': ['Purple', 'Tradesy'],
 #    'Tradesy': ['Wayfair'],
 #    'Peloton': ['Wayfair', 'Tradesy']
 #  }

 */



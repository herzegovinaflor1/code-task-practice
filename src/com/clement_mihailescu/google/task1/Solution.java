package com.clement_mihailescu.google.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

//    public static void main(String[] args) {
//        List<Block> blockList = new ArrayList<>() {{
//            add(new Block(false, true, false));
//            add(new Block(true, false, false));
//            add(new Block(true, true, false));
//            add(new Block(false, true, false));
//            add(new Block(false, true, true));
//        }};
//
//        searchTheShortestDistanceBLocks(Arrays.asList("gym", "school", "store"), blockList);
//    }
//
//    public static void searchTheShortestDistanceBLocks(List<String> reqs, List<Block> blockList) {
//        List<Integer> gymIndexes = new ArrayList<>();
//        IntStream.range(0, blockList.size())
//                .forEach(value -> {
//                    Block block = blockList.get(value);
//                    if (block.gym) {
//                        gymIndexes.add(value);
//                    }
//                });
//
//        List<Integer> schoolIndexes = new ArrayList<>();
//        IntStream.range(0, blockList.size())
//                .forEach(value -> {
//                    Block block = blockList.get(value);
//                    if (block.school) {
//                        schoolIndexes.add(value);
//                    }
//                });
//
//        List<Integer> storeIndexes = new ArrayList<>();
//        IntStream.range(0, blockList.size())
//                .forEach(value -> {
//                    Block block = blockList.get(value);
//                    if (block.store) {
//                        storeIndexes.add(value);
//                    }
//                });
//
//        int minPath = Integer.MAX_VALUE;
//
//        for (Integer gymIndex : gymIndexes) {
//            for (Integer schoolIndex : schoolIndexes) {
//                for (Integer storeIndex : storeIndexes) {
//                    if (gymIndex.equals(schoolIndex)
//                            || schoolIndex.equals(storeIndex)
//                            || gymIndex.equals(storeIndex)) {
//                        continue;
//                    }
//                    int gymAndSchool = Math.abs(gymIndex - schoolIndex);
//                    int schoolAndStore = Math.abs(schoolIndex - storeIndex);
//                    int gymAndStore = Math.abs(gymIndex - storeIndex);
//
//                    int res = gymAndSchool + schoolAndStore + gymAndStore;
//
//                    if (res < minPath) {
//                        minPath = res;
//                        System.out.println("===================");
//                        System.out.println(gymIndex);
//                        System.out.println(schoolIndex);
//                        System.out.println(storeIndex);
//                    }
//                }
//            }
//        }
//    }

//    record Block(boolean gym, boolean school, boolean store) {
//    }

}

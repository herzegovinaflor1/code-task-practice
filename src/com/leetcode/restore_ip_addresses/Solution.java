package com.leetcode.restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // https://leetcode.com/problems/restore-ip-addresses/
    public static void main(String[] args) {
//        System.out.println(
//                new Main13().restoreIpAddresses("25525511135")
//                // 2.5.5.2... [0:1 , 1:2; 2:3, 3:4]
//                // 2.5.5.25... [0:1 , 1:2; 2:3, 3:5]
//                // 2.5.5.255... [0:1 , 1:2; 2:3, 3:6]
//
//                // 2.5.52.5.. [0:1 , 1:2; 2:4, 4:5]
//                // 2.5.52.55.. [0:1 , 1:2; 2:4, 4:6]
//                // 2.5.52.551..[0:1 , 1:2; 2:4, 4:7]
//
//                // 2.5.52.255..
//        );

//        System.out.println(
//                new Main13().restoreIpAddresses("0000")
//        );

        System.out.println(
                new Solution().restoreIpAddresses("101023")
        );
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = i + 1; j <= i + 1 + 2; j++) {
                for (int k = j + 1; k <= j + 1 + 2; k++) {
                    for (int l = k + 1; l <= k + 1 + 2; l++) {
                        if (l == s.length()) {
                            String first = s.substring(0, i);
                            String second = s.substring(i, j);
                            String third = s.substring(j, k);
                            String fourth = s.substring(k, l);

                            if (
                                    (first.length() > 1 && first.startsWith("0")) ||
                                            (second.length() > 1 && second.startsWith("0")) ||
                                            (third.length() > 1 && third.startsWith("0")) ||
                                            (fourth.length() > 1 && fourth.startsWith("0"))
                            ) {
                                continue;
                            }

                            if (
                                    Integer.parseInt(first) <= 255 &&
                                    Integer.parseInt(second) <= 255 &&
                                    Integer.parseInt(third) <= 255 &&
                                    Integer.parseInt(fourth) <= 255
                            ) {
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}

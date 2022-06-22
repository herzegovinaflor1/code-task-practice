package com.company.earth.task3;

public class ConvertToBinary {

    public static void main(String[] args) {
        int decimalNumber = 30;

        String convertedToBinary = getBinary(decimalNumber);
        System.out.println(convertedToBinary);
        String stripZeros = stripZeros(convertedToBinary);
        System.out.println(stripZeros);
        String reversed = reverse(stripZeros);
        System.out.println(reversed);
    }

    private static String reverse(String stripZeros) {
        String result = "";
        for (char r : stripZeros.toCharArray()) {
            if (r == '0') {
                result += '1';
            }
            if (r == '1') {
                result += '0';
            }
        }
        return result;
    }

    private static String stripZeros(String convertedToBinary) {
        int i = convertedToBinary.indexOf('1');
        return convertedToBinary.substring(i);
    }

    private static String getBinary(int decimalNumber) {
        StringBuilder res = new StringBuilder();
        while (decimalNumber != 0) {
            res.insert(0, decimalNumber % 2 + "");
            decimalNumber = decimalNumber / 2;
        }
        return res.toString();
    }

}

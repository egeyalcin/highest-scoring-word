package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println(high("b aa"));
    }

    public static String high(String s) {
        String[] split = s.split(" ");
        int sum = 0;
        List<Integer> allSum = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            char[] charArray = split[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                sum+=Character.getNumericValue(charArray[j]) - 9;
            }
            allSum.add(sum);
            sum = 0;
        }
        int i = allSum.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        return split[allSum.indexOf(i)];
    }

}
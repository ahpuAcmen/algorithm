package leetcode;

import java.util.*;

public class LongestStringWithoutRepeating {


    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        int[] repeatSite = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])) {
                int last = list.lastIndexOf(chars[i]);
                repeatSite[i] = last;
                integers.add(i);
            } else {
                repeatSite[i] = -1;
            }
            list.add(chars[i]);
        }

        if (integers.isEmpty()) {
            return s.length();
        }
        int longestLength = 0;
        int start = 0;
        for (Integer site : integers) {
            if (longestLength == 0) {
                longestLength = site;
            } else {
                int last = repeatSite[site];
                int length = site - last;
                if (length > longestLength && site - start + 1 > longestLength) {
                    if (last >= start) {
                        longestLength = length;
                    } else {
                        longestLength = site - start + 1;
                    }
                }
            }
            start = repeatSite[site];
        }

        int maxRepeatSite = 0;
        for (int i = 0; i < repeatSite.length; i++) {
            maxRepeatSite = Math.max(repeatSite[i], maxRepeatSite);
        }
        int lastLength = s.length() - maxRepeatSite - 1;
        if (lastLength > longestLength) {
            longestLength = lastLength;
        }
        return longestLength;
    }

    int lengthOfLongestSubstringAns(String s) {
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}

package math.roman_to_integer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Roman to Integer
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/
class Solution {

    private Map<Character, Integer> digitValue;
    private List<Character> subtractors;

    public Solution() {
        digitValue = new HashMap<>();
        digitValue.put('I', 1);
        digitValue.put('V', 5);
        digitValue.put('X', 10);
        digitValue.put('L', 50);
        digitValue.put('C', 100);
        digitValue.put('D', 500);
        digitValue.put('M', 1000);
        digitValue.put('.', 0);
        subtractors = new ArrayList<>();
        subtractors.add('I');
        subtractors.add('X');
        subtractors.add('C');
    }

    public int romanToInt(String s) {
        int number = 0;
        int i = 0;
        while (i < s.length()) {
            char curChar = s.charAt(i);
            char nextChar = i + 1 == s.length() ? '.' : s.charAt(i + 1);
            int curVal = digitValue.get(curChar);
            int nextVal = digitValue.get(nextChar);
            int ratio = nextVal / curVal;
            if (subtractors.contains(curChar) && (ratio == 5 || ratio == 10)) {
                number += nextVal - curVal;
                i += 2;
            } else {
                number += curVal;
                i++;
            }
        }
        return number;
    }
}
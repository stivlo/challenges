package strings.valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqS = computeFreq(s);
        Map<Character, Integer> freqT = computeFreq(t);
        return freqS.equals(freqT);
    }

    private Map<Character, Integer> computeFreq(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = freq.get(c);
            if (count == null) count = 1;
            else count++;
            freq.put(c, count);
        }
        return freq;
    }

}

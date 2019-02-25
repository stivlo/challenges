package arrays.wave_array;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.swap;

public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i = 0; i < a.size() - 1; i += 2) {
            Collections.swap(a, i, i + 1);
        }
        return a;
    }
}

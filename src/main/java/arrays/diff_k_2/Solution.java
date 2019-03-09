package arrays.diff_k_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.interviewbit.com/problems/diffk-ii/
public class Solution {
    // x - y = b -> y = x - b
    public int diffPossible(final List<Integer> a, int b) {
        Map<Integer, List<Integer>> valToIndices = buildValToIndicesMap(a);
        for (Map.Entry<Integer, List<Integer>> entry : valToIndices.entrySet()) {
            int x = entry.getKey();
            int y = x - b;
            List<Integer> positions = valToIndices.get(y);
            if (positions != null && positions.size() > 1) return 1;
            if (x != y && positions != null) return 1;
        }
        return 0;
    }

    private Map<Integer, List<Integer>> buildValToIndicesMap(List<Integer> a) {
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i);
            List<Integer> indices = valToIndices.get(val);
            if (indices == null) indices = new ArrayList<>();
            indices.add(i);
            valToIndices.put(val, indices);
        }
        return valToIndices;
    }
}

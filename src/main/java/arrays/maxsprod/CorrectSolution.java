package arrays.maxsprod;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CorrectSolution {

    public int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        for (int i = 1; i < n; i++) {
            processItem(A, left, q, i);
        }
        q = new ArrayDeque<>();
        q.addLast(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            processItem(A, right, q, i);
        }
        long maxProd = -1;
        for (int i = 0; i < n; i++) {
            maxProd = Long.max(maxProd, (long) left[i] * right[i]);
        }
        return (int) (maxProd % 1000000007);
    }

    private void processItem(ArrayList<Integer> A, int[] left, Deque<Integer> q, int i) {
        while (!q.isEmpty()) {
            if (A.get(q.getLast()) > A.get(i)) break;
            q.removeLast();
        }
        left[i] = (q.isEmpty()) ? 0 : q.getLast();
        q.addLast(i);
    }

}

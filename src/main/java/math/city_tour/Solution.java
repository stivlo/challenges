package math.city_tour;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/city-tour/
public class Solution {

    private static final int MOD = 1000000007;
    private long[][] comb = new long[1001][1001];
    private long[] exp = new long[1001];

    public Solution() {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
                }
            }
        }
        exp[0] = 1;
        for (int i = 1; i < 1001; i++) {
            exp[i] = (exp[i - 1] * 2) % MOD;
        }
    }

    public int solve(int A, ArrayList<Integer> B) {
        Collections.sort(B);
        long ans = 1;
        int count = B.get(0) - 1;
        for (int i = 1; i < B.size(); i++) {
            int t = B.get(i) - B.get(i - 1) - 1;
            if (t > 0) {
                ans = ((ans * exp[t - 1]) % MOD * comb[count + t][t]) % MOD;
                count += t;
            }
            // System.out.print(i + " " + t + " ");
        }
        int t = A - B.get(B.size() - 1);
        ans = (ans * comb[count + t][t]) % MOD;
        return (int) ans;
    }

    @Test
    void editorialExample() {
        assertThat(new Solution().solve(5, Lists.newArrayList(2, 5)), is(6));
    }

}

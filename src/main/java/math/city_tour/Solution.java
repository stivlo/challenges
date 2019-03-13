package math.city_tour;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/city-tour/
public class Solution {

    private static final int MAX_SIZE = 1000;
    private static final int MOD = 1000000007;
    private long[][] comb = new long[MAX_SIZE + 1][MAX_SIZE + 1];
    private long[] exp = new long[MAX_SIZE + 1];

    public Solution() {
        // comb -> Pascal's triangle: encodes n choose k (binomial coefficient) (n k)
        // coefficients of a binomial expansion. e.g. (x + y)^2 = (x + y) * (x + y) = x^2 + 2xy + y^2 (row 2)
        //         0  1  2  3  4  5
        // row 0:  1  0  0  0  0  0  sum = 1
        // row 1:  1  1  0  0  0  0  sum = 2
        // row 2:  1  2  1  0  0  0  sum = 4
        // row 3:  1  3  3  1  0  0  sum = 8
        // row 4:  1  4  6  4  1  0  sum = 16
        // row 5:  1  5 10 10  5  1  sum = 32
        // If I have 4 things and I want to choose one, I go to row 4 and column 1 and I find out that I
        // have 4 ways in which I can do that.
        for (int i = 0; i <= MAX_SIZE; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
                }
            }
        }
        // exp -> Powers of 2 (2^0 = 1, 2^1 = 2, 2^2 = 4, ...) = n! / (k! (n - k)!
        exp[0] = 1;
        for (int i = 1; i <= MAX_SIZE; i++) {
            exp[i] = (exp[i - 1] * 2) % MOD;
        }
        // Arrays.stream(comb).forEach(row -> System.out.println(Arrays.toString(row)));
        // System.out.println(Arrays.toString(exp));
    }

    // cities are numbered 1..N
    public int solve(int cities, ArrayList<Integer> visited) {
        Collections.sort(visited);
        long ans = 1;
        int totalUnseen = visited.get(0) - 1; // how many not visited cities at the beginning
        for (int i = 1; i < visited.size(); i++) {
            int unseenMiddle = visited.get(i) - visited.get(i - 1) - 1;
            if (unseenMiddle > 0) {
                ans = ((ans * exp[unseenMiddle - 1]) % MOD * comb[totalUnseen + unseenMiddle][unseenMiddle]) % MOD;
                totalUnseen += unseenMiddle;
            }
            // System.out.print(i + " " + t + " ");
        }
        int unseenEnd = cities - visited.get(visited.size() - 1); // how many not visited at the end
        totalUnseen += unseenEnd;
        ans = (ans * comb[totalUnseen][unseenEnd]) % MOD;
        return (int) ans;
    }

    @Test
    void editorialExample() {
        assertThat(solve(5, Lists.newArrayList(2, 5)), is(6));
    }

}

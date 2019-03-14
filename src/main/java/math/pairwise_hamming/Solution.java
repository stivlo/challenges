package math.pairwise_hamming;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

// https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
public class Solution {

    private static final int MOD = 1_000_000_007;

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> a) {
        long hamming = 0L;
        int mask = 1;
        for (int bit = 0; bit < 32; bit++) {
            long[] countOf = countZeroesAndOnes(a, mask);
            long distance = (2L * countOf[0] * countOf[1]) % MOD;
            hamming = (hamming + distance) % MOD;
            mask <<= 1;
        }
        return (int) (hamming % MOD);
    }

    private long[] countZeroesAndOnes(List<Integer> a, int mask) {
        long[] countOf = new long[2];
        for (int num : a) {
            boolean isSet = (num & mask) != 0;
            if (isSet) countOf[1]++;
            else  countOf[0]++;
        }
        return countOf;
    }

    @Test
    void exampleTestCase() {
        assertThat(hammingDistance(ImmutableList.of(2, 4, 6)), is(8));
    }

}

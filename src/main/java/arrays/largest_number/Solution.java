package arrays.largest_number;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/largest-number/
public class Solution {

    public String largestNumber(final List<Integer> nums) {
        List<Integer> numCopy = new ArrayList<>(nums);
        numCopy.sort((numA, numB) -> {
            String a = Integer.toString(numA);
            String b = Integer.toString(numB);
            String aFirst = a + b;
            String bFirst = b + a;
            return bFirst.compareTo(aFirst);
        });
        StringBuilder sb = new StringBuilder();
        for (int num : numCopy) {
            if (sb.length() == 0 || sb.charAt(0) != '0') sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.largestNumber(Lists.newArrayList(9, 5, 34, 3, 30));
        assertThat(res, is("9534330"));
        assertThat(solution.largestNumber(Lists.newArrayList(0, 0, 0)), is("0"));
        assertThat(solution.largestNumber(Lists.newArrayList(29, 292, 298)), is("29829292"));
        assertThat(solution.largestNumber(Lists.newArrayList(782, 240, 409, 678, 940, 502, 113, 686,
                6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363,
                298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905)),
                is("991974940930905895877872868825799798791782780772735709686686678675664653350247040" +
                        "93953663633573372982927126124019124113"));
    }
}

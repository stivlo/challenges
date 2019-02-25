package arrays.maxsprod;

import com.google.common.collect.ImmutableList;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/maxspprod/
// https://www.geeksforgeeks.org/maximum-product-of-indexes-of-next-greater-on-left-and-right/
public class Solution {

    public int maxSpecialProduct(ArrayList<Integer> a) {
        long maxProd = 0;
        if (a.isEmpty()) return 0;
        int[] leftSpecialValues = computeLeftSpecialValues(a);
        int[] rightSpecialValues = computeRightSpecialValues(a);
        for (int i = 0; i < a.size(); i++) {
            long prod = (((long) leftSpecialValues[i]) * ((long) rightSpecialValues[i]));
            if (prod > maxProd) maxProd = (int) prod;
        }
        long modulo = 1000000007L;
        return (int) (maxProd % modulo);
    }

    private int[] computeRightSpecialValues(List<Integer> a) {
        int[] values = new int[a.size()];
        Deque<Pair> q = new LinkedList<>();
        for (int i = 0; i < a.size(); i++) {
            processElement(values, q, a, i);
        }
        return values;
    }

    private int[] computeLeftSpecialValues(List<Integer> a) {
        int[] values = new int[a.size()];
        Deque<Pair> q = new LinkedList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            processElement(values, q, a, i);
        }
        return values;
    }

    private void processElement(int[] values, Deque<Pair> q, List<Integer> a, int i) {
        if (!q.isEmpty() && a.get(i) > q.peekFirst().value) {
            while (q.peekFirst() != null && q.peekFirst().value < a.get(i)) {
                Pair curPair = q.pop();
                values[curPair.index] = i;
            }
        }
        q.addFirst(new Pair(i, a.get(i)));
    }

    private class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", "{", "}")
                    .add("index:" + index)
                    .add("value:" + value)
                    .toString();
        }
    }

//    private long leftSpecialValue(ArrayList<Integer> a, int i) {
//        for (int j = i - 1; j >= 0; j--) {
//            if (a.get(j) > a.get(i)) return j;
//        }
//        return 0;
//    }
//
//    private long rightSpecialValue(ArrayList<Integer> a, int i) {
//        for (int j = i+ 1; j < a.size(); j++) {
//            if (a.get(j) > a.get(i)) return j;
//        }
//        return 0;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of())), is(0));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(1))), is(0));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9))), is(80));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(7, 5, 7, 9, 8, 7))), is(0));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(1, 1, 1, 1, 0, 1, 1, 1, 1, 1))), is(15));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(0, 5, 8, 5, 0))), is(0));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(6, 5, 4, 9, 9, 6, 5, 4, 5, 9, 9))), is(48));
        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9))), is(80));

        assertThat(solution.maxSpecialProduct(
                new ArrayList<>(ImmutableList.of(5250, 74, 3659, 8931, 1273, 7545, 879, 7924, 7710, 4441, 8166,
                        4493, 3043, 7988, 2504, 2328, 1730, 8841, 2613, 4304, 3170, 7710, 7158, 9561, 934, 3100,
                        279, 1817, 5336, 9098, 7827, 3513, 9268, 3811, 7634, 980, 9150, 6580, 8822, 1968, 673,
                        1394, 9337, 5486, 1746, 5229, 4092, 195, 6358, 5002, 1154, 6709, 7945, 5669, 1491, 8125,
                        2197, 9531, 904, 7723, 4667, 8550, 8025, 7802, 6854, 978, 7409, 8229, 4934, 299, 8982,
                        8636, 8014, 3866, 9815, 9064, 4537, 9426, 1670, 4116, 95, 5630, 6502, 6518, 4196, 106,
                        405, 9452, 4299, 2189, 1124, 9506, 6883, 6753, 1567, 6717, 338, 4439, 3145, 1502, 4898,
                        3872, 5829, 1138, 9359, 3178, 2398, 2295, 7905, 1610, 6232, 9746, 4176, 3636, 6299, 8143,
                        400, 7969, 413, 261, 3558, 1595, 8009, 6396, 5969, 9114, 4531, 1007, 963, 7943, 5366,
                        2083, 9853, 768, 3822, 5696, 4713, 3672, 9902, 8591, 4832, 4739, 3058, 1617, 9791, 5641,
                        680, 7336, 7007, 7973, 6099, 9096, 5320, 3455, 5224, 2290, 6761, 8906, 6127, 6124, 9507,
                        5814, 6771, 5239, 9095, 6221, 7845, 2367, 535, 5227, 5395, 1364, 8739, 7845, 9591, 6551,
                        5160, 8624, 4948, 7386, 7218, 5273, 5540, 9248, 2386, 3497, 4886, 624, 2421, 8145, 1969,
                        5736, 9916, 1626, 3535, 6043, 6012, 4680, 4153, 5245, 7296, 8819, 397, 7693, 1816, 2992,
                        34, 2670, 9398, 9554, 548, 5826, 1211, 9663, 212, 3809, 3378, 2762, 626, 7336, 1869,
                        7996, 2777, 2768, 7440, 9875, 9332, 557, 6302, 8873, 561, 95, 8985, 3756, 9790, 1408,
                        8016, 194, 2770, 5681, 3456, 6856, 7507, 964, 3503, 6677, 3109, 3250, 2332, 7845, 7639,
                        809, 9998, 8652, 4850, 5204, 5732, 6532, 8015, 5420, 6776, 2010, 181, 7930, 5224, 4055,
                        8261, 6738, 1546, 7318, 7526, 4201, 4257, 1565, 598, 6649, 7705, 5551, 5151, 1977, 1413,
                        8555, 2798, 2505, 8382, 4749, 7066, 9379, 7700, 8210, 5130, 8554, 5484, 448, 4608, 774,
                        5323, 4306, 5177, 54, 7225, 4631, 367, 5401, 445, 5371, 286, 3017, 3899, 8156, 1134, 5558,
                        6577, 3179, 8267, 7358, 1712, 7879, 615, 4820, 5738, 3134, 592, 3721, 8763, 6634, 6198,
                        6032, 8589, 590, 4874, 8878, 7305, 9359, 1201, 7255, 8961, 4916, 3948, 5481, 7731, 9956,
                        4547, 7108, 1239, 1, 4927, 5036, 4858, 1114, 115, 9594, 1361, 8355, 8419, 5358, 2586,
                        3730, 1016, 6564, 6103, 918, 6644, 9420, 2968, 7748, 5270, 5396, 3304, 4474, 9104, 1749,
                        4386, 5659, 3460, 5407, 3931, 9825, 5133, 974, 9604, 6898, 7921, 3951, 5232, 8481, 204,
                        3901, 4521, 2534, 1259, 7004, 8677, 951, 3935, 8781, 9880, 1833, 2575, 3550, 4543, 6250,
                        2772, 6311, 5880, 984, 9971, 2041, 2724, 3651, 2972, 3230, 319, 7747, 300, 7231, 5622,
                        777, 125, 8245, 6959, 7697, 6772, 9065, 1561, 6599, 8752, 9941, 4504, 9552, 2802, 7206,
                        5081, 419, 9275, 9650, 414, 3321, 9026, 2013, 1784, 4789, 4118, 4009, 1551, 5325, 9196,
                        1258, 4512, 5691, 8667, 2411, 594, 554, 9566, 961, 8743, 1404, 4353, 7308, 6142, 4911,
                        3201, 2800, 3128, 172, 7788, 4415, 1626, 6642, 9518, 5349, 1843, 4316, 5975, 1446, 1374,
                        2221, 9912, 9240, 5055, 1306, 6930, 2254, 4190, 5167, 4357, 9305, 9861, 5899, 5593, 1721,
                        6117, 1581, 8868, 9353, 6940, 8699, 4902, 812, 6617, 6892, 8672, 1729, 6672, 1662, 7046,
                        3121, 241, 7159, 9454, 9628, 5351, 3712, 5564, 9595, 7534, 1728, 7828, 8796, 9532, 7443,
                        1517, 5007, 8516, 6925, 2602, 7098, 8662, 7104, 4325, 109, 4937, 2282, 7016, 3711, 3217,
                        1906, 5974, 7782, 2721, 792, 1170, 7866, 5828, 9537, 6729, 7126, 385, 168, 9950, 477,
                        6047, 1577, 8667, 7468, 521, 7385, 1992, 5211, 3259, 8212, 8745, 9519, 5719, 1935, 6826,
                        768, 8690, 9819, 3015, 1826, 2919, 8029, 3030, 8035, 6728, 1241, 3755, 6541, 8397, 936,
                        3084, 8049, 6866, 7012, 5253, 3065, 7877, 7238, 2676, 246, 2711, 416, 8193, 4711, 4748,
                        3038, 1300, 8448, 9716, 1694, 9580, 7130, 5165, 3980, 3502, 5526, 290, 4959, 4034, 1801,
                        5090, 7671, 5218, 847, 1039, 9544, 339, 5937, 3322, 7720, 6497, 1248, 3789, 8360, 5988,
                        5036, 5236, 3913, 5685, 5990, 3785, 3735, 2668, 520, 2616, 7046, 5977, 6662, 5826, 2820,
                        1632, 2904, 2699, 6799, 2640, 4005, 9504, 680, 8766, 7392, 4108, 4925, 4366, 7122, 4455,
                        7107, 7451, 1704, 833, 1033, 2142, 1655, 1978, 2218, 3901, 7290, 3466, 4748, 3623, 9880,
                        9318, 1517, 4049, 2763, 1030, 9040, 2709, 5904, 2658, 762, 5753, 1467, 8622, 4558, 6997,
                        6956, 6931, 1495, 5556, 2222, 9313, 2294, 1428, 2233, 7445, 4792, 2199, 9153, 4857, 3571,
                        4304, 7440, 2915, 5800, 6767, 1836, 1922, 6044, 2753, 4087, 9720, 9151, 8411, 8624, 4670,
                        9606, 9944, 7312, 2432, 7993, 9817, 8700, 6972, 640, 1371, 5837, 9892, 2858, 4834, 3329,
                        8178, 4411, 7684, 5177, 3490, 2092, 435, 4712, 6905, 1027, 4892, 791, 523, 9365, 6891,
                        4885, 6814, 1442, 7128, 6180, 5785, 4538, 9871, 7562, 2582, 4166, 5803, 7733, 7333, 7855,
                        9760, 9848, 2378, 463, 9011, 3820, 8151, 3378, 942, 3837, 6721, 2300, 6113, 4760, 9957,
                        4391, 6153, 49, 5015, 9045, 4919, 151, 102, 1296, 9822, 5732, 4502, 8246, 4962, 6058, 3511,
                        3929, 806, 2174, 2138, 9670, 9097, 4504, 7422, 8676, 8519, 4301, 6490, 263, 2055, 8264))),
                is(648828));
    }

}

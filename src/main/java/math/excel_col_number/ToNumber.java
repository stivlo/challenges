package math.excel_col_number;

// https://www.interviewbit.com/problems/excel-column-number/
public class ToNumber {

    public int titleToNumber(String a) {
        int base = 26;
        int mult = 1;
        int result = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int digit = ((a.charAt(i) - 'A') + 1);
            result += digit * mult;
            mult *= base;
        }
        return result;
    }

}

package math.excel_col_number;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ToTitle {

    public String convertToTitle(int a) {
        StringBuilder sb = new StringBuilder();
        do {
            char lsd = (char) ((a - 1) % 26);
            char letter = (char) (lsd + 'A');
            sb.append(letter);
            a = (a - 1) / 26;
        } while (a > 0);
        return sb.reverse().toString();
    }

    @Test
    void oneConvertsToA() {
        assertThat(convertToTitle(1), is("A"));
    }

    @Test
    void twentySixConvertsToZ() {
        assertThat(convertToTitle(26), is("Z"));
    }

    @Test
    void twentySevenConvertsToAA() {
        assertThat(convertToTitle(27), is("AA"));
    }

    @Test
    void xx() {
        assertThat(convertToTitle(943566), is("BAQTZ"));
    }

}

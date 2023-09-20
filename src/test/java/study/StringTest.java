package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitToComma(){
        //given
        String commaNumber="1,2";
        String onlyNumber="1";
        //when
        String[] commaSplit = commaNumber.split(",");
        String[] numberSplit = onlyNumber.split(",");
        //then
        assertThat(commaSplit).contains("1","2");
        assertThat(numberSplit).containsExactly("1");
    }
}

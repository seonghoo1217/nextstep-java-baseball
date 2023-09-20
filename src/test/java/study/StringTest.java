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
    void splitToCommaAndNumber(){
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

    @Test
    void substringToNumberTuple(){
        //given
        String tupleNumber="(1,2)";
        //when
        String substringTuple = tupleNumber.substring(1, tupleNumber.length() - 1);
        //then
        assertThat(substringTuple).contains("1","2");
    }
}

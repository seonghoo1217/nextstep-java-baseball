package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("charAt() 메소드를 활용하여 특정 위치의 문자 가져오기")
    void takeCharacterPositionByCharAt(){
        //given
        String target="abc";
        int position=3;
        //when
        if (position>=target.length())throw new StringIndexOutOfBoundsException("Index: "+position+", Size: "+target.length());
    }

    @Test
    @DisplayName("charAt()을 통한 범위가 벗어날경우")
    void invalidRangeOfCharAt(){
        //then
        assertThatThrownBy(()->{
            takeCharacterPositionByCharAt();
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3");
    }
}

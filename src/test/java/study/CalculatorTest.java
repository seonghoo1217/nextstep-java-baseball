package study;

import config.InputImport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.CalculateService;
import validate.InputValidate;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private CalculateService calculateService;
    private InputValidate inputValidate;

    @BeforeEach
    void testInitialize(){
        calculateService=new CalculateService();
        inputValidate=new InputValidate();
    }

    @Test
    void calculateByInputValueTest(){
        Scanner scanner = new InputImport().scannerImport();
        String value = scanner.nextLine();
    }

    @ParameterizedTest
    @ValueSource(strings = {""," 123"," 1+2+3","1a23","+++++"})
    void validateInputValueTest(String value) {
        assertThatThrownBy(() -> {
            calculateService.inputValueValidateForm(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void extractNumberToString(){
        //given
        String numberString="123";
        String comString="1+2-3";
        //when
        boolean numValidate = inputValidate.validateValueIsNumberType(numberString);
        boolean comValidate = inputValidate.validateValueIsNumberType(comString);

        //then
        assertThat(numValidate).isFalse();
        assertThat(comValidate).isTrue();
    }

    @Test
    void validateFormRunExactlyTest(){
        //given
        String targetValue="1 + 2 - 3";
        //when
        calculateService.inputValueValidateForm(targetValue);
    }


    @Test
    void calculateSingleDigitTest(){
        //given
        String inputValue= "2 + 3 * 4 / 2";
        //when
        int testResult = calculateService.inputValueValidateForm(inputValue);
        //then
        assertThat(testResult).isEqualTo(10);
    }

    @Test
    void calculateDoubleDigitTest(){
        //given
        String inputValue= "12 + 13 * 4 - 5 / 9";
        //when
        int testResult = calculateService.inputValueValidateForm(inputValue);
        //then
        assertThat(testResult).isEqualTo(10);
    }
}

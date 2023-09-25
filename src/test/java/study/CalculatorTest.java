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
    @ValueSource(strings = {""})
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
        assertThat(numValidate).isTrue();
        assertThat(comValidate).isFalse();
    }
}

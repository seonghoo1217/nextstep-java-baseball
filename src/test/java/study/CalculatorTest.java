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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private CalculateService calculateService;

    @BeforeEach
    void testInitialize(){
        calculateService=new CalculateService();
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
            calculateService.calculate(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

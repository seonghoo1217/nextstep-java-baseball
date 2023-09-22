package study;

import config.InputImport;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CalculatorTest {
    @Test
    void calculateByInputValueTest(){
        Scanner scanner = new InputImport().scannerImport();
        String value = scanner.nextLine();
        String[] values = value.split(" ");
    }
}

package service;

import validate.InputValidate;

import java.util.LinkedList;
import java.util.Queue;

public class CalculateService {

    public static int result=0;

    public static Queue<String> queue=new LinkedList<>();
    public InputValidate inputValidate=new InputValidate();

    public void inputValueValidateForm(String values){
        for (String value : values.split(" ")){
            if (inputValidate.validateValue(value))
        }
    }

    private void operationRegister(String value){
    }

    public void calculate(String value){

    }
}

package service;

import validate.InputValidate;

public class CalculateService {
    public InputValidate inputValidate=new InputValidate();
    public void calculate(String values){
        for (String value : values.split(" ")){
            if (inputValidate.validateEmptyOrSpaceValue(value)) throw new IllegalArgumentException("Input value is empty");
        }
    }
}

package service;

import validate.InputValidate;

import java.util.LinkedList;
import java.util.Queue;

public class CalculateService {
    public static Queue<String> op =new LinkedList<>();
    public static Queue<Integer> num =new LinkedList<>();

    public static String numberTemp="";

    public InputValidate inputValidate=new InputValidate();

    public int inputValueValidateForm(String values){
        for (String value : values.split(" ")){
            if (inputValidate.validateValue(value)){
                operationAndNumRegister(value);
            }
        }
        return calculate();
    }

    public void operationAndNumRegister(String value){
        if (!inputValidate.validateValueIsOperationType(value)){
            op.offer(value);
            num.offer(Integer.parseInt(numberTemp));
            numberTemp="";
            return;
        }
        numberTemp+=value;
    }

    public int calculate(){
        int result= num.poll();
        if (numberTemp.isEmpty()) {
            throw new IllegalArgumentException("마지막 자리 수가 없습니다");
        }
        num.offer(Integer.parseInt(numberTemp));
        while (!op.isEmpty()&&!num.isEmpty()){
            result=conductOperation(result,num.poll(),op.poll());
        }
        return result;
    }

    private int conductOperation(int result,int target,String opType){
        switch (opType){
            case "+": return add(result,target);
            case "-": return minus(result,target);
            case "*": return multiply(result,target);
            case "/": return divide(result,target);

        }
        throw new IllegalArgumentException("규격 외의 OperationType:"+opType);
    }

    private int add(int result,int target){
        return result+target;
    }

    private int minus(int result,int target){
        return result-target;
    }

    private int multiply(int result,int target){
        return result*target;
    }

    private int divide(int result,int target){
        return result/target;
    }
}

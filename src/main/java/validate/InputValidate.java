package validate;

public class InputValidate {

    public boolean validateEmptyOrSpaceValue(String value){
        return value.matches("^\\s*$");
    }
}

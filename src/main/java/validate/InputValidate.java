package validate;

public class InputValidate {

    public boolean validateEmptyOrSpaceValue(String value){
        return value.matches("^\\s*$");
    }

    public boolean validateValueIsNumberType(String value){
        return !value.matches(".*[^0-9 ].*");
    }
}

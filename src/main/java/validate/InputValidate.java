package validate;

public class InputValidate {

    public boolean validateEmptyOrSpaceValue(String value){
        if (value.matches("^\\s*$")) throw new IllegalArgumentException("Input Value is Empty");
        return true;
    }

    public boolean validateValueIsNumberType(String value){
        return value.matches(".*[^0-9 ].*");
    }

    public boolean validateValueIsOperationType(String value){
        return !("+-*/".contains(value) && value.length() == 1);
    }

    public boolean validateValueType(String value){
        if (validateValueIsNumberType(value)||validateValueIsOperationType(value)) {
            throw new IllegalArgumentException("Input Value is Not OP or Numeric Type");
        }
        return true;
    }

    public boolean validateValue(String value){
        if (validateEmptyOrSpaceValue(value)){
            if (validateValueType(value)){
                return true;
            }
        }
        return false;
    }
}

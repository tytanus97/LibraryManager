package mainpack.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorImpl implements ConstraintValidator<EmailValidator,String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        if(s == null) return false;
        matcher = pattern.matcher(s);

        return matcher.matches();
    }
}

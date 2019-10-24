package spring.exercise.common;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public final class ValidatorExtensions {
    private static Validator validator;

    static
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static <T> String getViolationMessages(T object){
        var violations = validator.validate(object);

        var areThereViolations = violations.size() > 0;
        if (!areThereViolations){
            return null;
        }

        var builder = new StringBuilder();
        for (var violation : violations) {
            builder.append(violation.getMessage());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}
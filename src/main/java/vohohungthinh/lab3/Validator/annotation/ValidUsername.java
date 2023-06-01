package vohohungthinh.lab3.Validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import vohohungthinh.lab3.Validator.ValidUsernameValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
@Documented
public @interface ValidUsername {
    String message() default "Username already exists";
    Class<?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}

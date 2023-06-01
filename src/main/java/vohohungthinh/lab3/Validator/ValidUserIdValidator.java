package vohohungthinh.lab3.Validator;

import vohohungthinh.lab3.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vohohungthinh.lab3.Validator.annotation.ValidUserId;

public class ValidUserIdValidator implements ConstraintValidator <ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if (user == null)
            return true;
        return  user.getId() != null;
    }
}

package vohohungthinh.lab3.Validator;

import vohohungthinh.lab3.entity.Category;
import vohohungthinh.lab3.Validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public  boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;
    }

}

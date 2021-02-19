package br.com.api.casadocodigo.Validador;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {

    String message() default "{_duplicated_field}";
    String fieldName();
    Class<?> domainClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
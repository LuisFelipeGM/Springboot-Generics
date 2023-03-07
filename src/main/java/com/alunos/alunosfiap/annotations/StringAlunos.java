package com.alunos.alunosfiap.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

@NotBlank(message = "Campo não deve estar em branco")
@Size(max = 20)
public @interface StringAlunos {
    String message() default "Campo deve ter no máximo 20 caracteres e não deve estar em branco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

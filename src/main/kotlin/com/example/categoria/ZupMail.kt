package com.example.categoria

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint

@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [TestandoValidador::class])
annotation class ZupMail(
        val message: String = "Não é um email Zup válido"
)
@Singleton
class TestandoValidador: ConstraintValidator<ZupMail, String > {
    override fun isValid(value: String?,
                         annotationMetadata: AnnotationValue<ZupMail>,
                         context: ConstraintValidatorContext): Boolean {
        if(value == null){
            return true
        }
        return value?.endsWith("@zup.com.br")
    }

}

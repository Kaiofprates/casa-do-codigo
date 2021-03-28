package com.example.autor

import com.example.categoria.ZupMail
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.exceptions.EmptyResultException
import org.slf4j.LoggerFactory
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class AutorRequest(@field:NotBlank @field:ZupMail val email: String,
                        @field:NotBlank var nome: String,
                        @field:NotBlank @field:Size(max = 400) val descricao: String) {

    fun toModel(repository: AutorRepository): Autor {
        val logger = LoggerFactory.getLogger("AutorRequest")
        try {
            val autor = repository.findByEmail(this.email)
            if (autor != null) {
                throw DuplicateAutorException("Não foi possível completar o cadastro, verifique os dados")
            }
        } catch (e: EmptyResultException) {
            logger.info("Sem resultados no banco de dados")
        }
        return Autor(email, nome, descricao)
    }
}
package com.example.categoria

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class CategoriaRequest(@field:NotBlank val nome: String) {
    fun toModel(repository: CategoriaRepository): Categoria {
        val categoria: Boolean = repository.existsByNome(this.nome)
        if(categoria){
            throw BadRequestException("Falha ao cadastrar categoria, tente outro nome")
        }
        return Categoria(nome)
    }
}

class BadRequestException(s: String): Exception() {
    override val message: String?
        get() = super.message
}

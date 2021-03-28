package com.example.autor

import com.example.autor.Autor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository: JpaRepository<Autor, Long> {
    fun findByEmail(email: String): Autor
}

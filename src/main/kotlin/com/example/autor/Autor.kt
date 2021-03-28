package com.example.autor

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Autor(val email: String, val nome: String, val descricao: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val criadoEm: LocalDate = LocalDate.now()
}
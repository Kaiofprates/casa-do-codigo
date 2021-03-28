package com.example.categoria

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Categoria (val nome: String){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

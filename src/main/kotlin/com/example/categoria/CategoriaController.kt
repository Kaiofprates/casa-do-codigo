package com.example.categoria

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid
@Validated
@Controller("/api")
class CategoriaController(val repository: CategoriaRepository) {

    @Post("/categorias")
    fun novaCategoria(@Body @Valid request: CategoriaRequest){
    val categoria = repository.save(request.toModel(repository))
    }

    @Get("/categorias")
    fun listaCategorias(): HttpResponse<Any>{
        val categorias = repository.findAll()
        return ok(categorias)
    }

}
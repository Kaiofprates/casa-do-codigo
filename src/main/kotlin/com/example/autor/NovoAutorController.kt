package com.example.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.notFound
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid


@Validated
@Controller("/api")
class NovoAutorController(val repository: AutorRepository) {

    @Post("/autores")
    fun novoAutor(@Body @Valid request: AutorRequest){
        repository.save(request.toModel(repository))
    }

    @Get("/autores")
    fun listaAutores(): HttpResponse<Any>{ 
        val autores = repository.findAll() 
        val response: List<AutorResponse> = autores.map { it -> AutorResponse(it.email,it.nome,it.descricao) }
        return HttpResponse.ok(response)
    }

    @Get("/autores/{email}")
    fun buscaAutor(email: String): HttpResponse<Any>{
        var autor = repository.findByEmail(email)
        if(autor != null ){
            var response = AutorResponse(autor.email,autor.nome,autor.descricao)
            return ok(response)
        }else{
            return notFound()
        }
    }


}
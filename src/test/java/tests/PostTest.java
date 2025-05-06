package tests;

import base.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import models.Post;
import org.junit.jupiter.api.Test;
import services.PostService;

import static org.hamcrest.Matchers.*;

@Epic("Testes de API - Posts")
@Feature("GET /posts")
@Owner("Larissa Macedo")
public class PostTest extends BaseTest {

    PostService postService = new PostService();

    @Test
    @Story("Buscar todos os posts")
    @Description("Este teste valida se a API retorna uma lista de posts não vazia.")
    public void testGetAllPosts() {
        postService.getAllPosts()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Story("Buscar post por ID")
    @Description("Este teste valida se a API retorna corretamente um post pelo seu ID.")
    public void testGetPostById() {
        postService.getPostById(1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", notNullValue());
    }

    @Test
    @Story("Criar um post")
    @Description("Valida que um post é criado com sucesso ao enviar dados válidos.")
    public void testCriarPostValido() {

        Post novoPost = new Post(1, "Novo post", "Conteúdo");

        postService.createPost(novoPost)
                .then()
                .statusCode(201)
                .body("userId", equalTo(novoPost.getUserId()))
                .body("id", notNullValue())
                .body("title", equalTo(novoPost.getTitle()))
                .body("body", equalTo(novoPost.getBody()));
//                .body("body", equalTo("testes"));
    }

    @Test
    @Story("Imprimindo retorno")
    @Description("Só pra teste do retorno")
    public void imprimirResposta() {
        Post novoPost = new Post(1, "Novo post", "Conteúdo");

        Response response = postService.createPost(novoPost);

        response.then().statusCode(201);

        Post postCriado = response.as(Post.class);

        System.out.println("Post criado");
        System.out.println(postCriado);
    }
};

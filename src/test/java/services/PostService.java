package services;

import config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Post;

import static io.restassured.RestAssured.given;

public class PostService {

    private static final String BASE_URI = TestConfig.BASE_URI;
    private static final String BASE_PATH = TestConfig.BASE_PATH;
    public Response getAllPosts() {
        return given()
                .log().all()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .when()
                .get();
    }

    public Response getPostById(int id) {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .pathParam("id", id)
                .when()
                .get("/{id}");
    }

    public Response createPost(Post post) {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .contentType(ContentType.JSON)
                .body(post)
                .when()
                .post();
    }
}

package Services;

import dto.CreateUserRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class UserApi {
private static final String BASE_URI="https://petstore.swagger.io/v2";
private static final String PATH = "/user";
    public static final String PATH_GET_USER_BY_USERNAME = "/user/{username}";


    private final RequestSpecification spec;

    public UserApi () {
         spec = given()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON)
            .log().all();
}
    public Response createUser (CreateUserRequest user) {
        return
                given(spec)
                        .basePath(PATH)
                        .body(user)
                        .when()
                        .post();

    }
    public Response getUserByUsername (String username) {
        return
                given(spec)
                        .pathParams("username",username)
                        .basePath(PATH_GET_USER_BY_USERNAME)
                        //.spec(spec)
                        .when()
                        .get();

    }
}

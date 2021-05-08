package tests;

import dto.CreateUserRequest;
import dto.CreateUserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewUserTest extends UserBaseTest {
    CreateUserRequest user;
    //Тест отправляет запрос со всеми заполненными полями и проверяет,
    // что поле code в ответе будет равно "200", а поле message будет равно 777
    @Test
    public void checkCreateUserAE () {
        user = CreateUserRequest.builder()
                .userStatus(10)
                .email("a@a.ru")
                .firstName("Albert")
                .id(777)
                .lastName("Einstein")
                .password("e=mc2")
                .phone("+31415926535")
                .username("AlStein")
                .build();

        String message = String.valueOf(userApi.createUser(user)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(CreateUserResponse.class).getMessage());
        Assertions.assertEquals("777", message, "Alarm!");
    }

    //Тест отправляет запрос со всеми заполненными полями, кроме id, и проверяет,
    // что поле code в ответе будет равно "200", а поле message не будет равно 0

    @Test
    public void checkCreateUserNT () {
        user = CreateUserRequest.builder()
                .userStatus(10)
                .email("nikt@yahoo.com")
                .firstName("Nikola")
                .lastName("Tesla")
                .password("F=gvBsina")
                .phone("+6054071015540")
                .username("Tungus")
                .build();

        String message = String.valueOf(userApi.createUser(user)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(CreateUserResponse.class).getMessage());
        Assertions.assertNotEquals("0", message, "Alarm!");
    }

}

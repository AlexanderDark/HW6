package tests;

import dto.CreateUserRequest;
import dto.CreateUserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetUserByUsernameTest extends UserBaseTest {
    CreateUserRequest getUser;
    //Тест отправляет запрос c юзернеймом AlStein и проверяет ранее созданную карточку на существованиес,
    // проверяет все поля на соответствие значениям
    @Test
    public void checkGetUserByUsernameAE () {

        int userStatus = 10;
        String email = "a@a.ru";
        String firstName = "Albert";
        int id = 777;
        String lastName = "Einstein";
        String password = "e=mc2";
        String phone = "+31415926535";
        String username = "AlStein";

        userApi.getUserByUsername(username)
                .then()
                .body("email", equalTo(email))
                .body("firstName", equalTo(firstName))
                .body("id", equalTo(id))
                .body("lastName", equalTo(lastName))
                .body("password", equalTo(password))
                .body("phone", equalTo(phone))
                .body("username", equalTo(username));
    }

    //Тест отправляет запрос c юзернеймом Tungus и проверяет ранее созданную карточку на существованиес,
    // проверяет все поля на соответствие значениям
        @Test
        public void checkGetUserByUsernameNT () {

            int userStatus = 10;
            String email = "nikt@yahoo.com";
            String firstName = "Nikola";
            int id = 95839869;
            String lastName = "Tesla";
            String password = "F=gvBsina";
            String phone = "+6054071015540";
            String username = "Tungus";

            userApi.getUserByUsername(username)
                    .then()
                    .body("email", equalTo(email))
                    .body("firstName", equalTo(firstName))
                    .body("id", equalTo(id))
                    .body("lastName", equalTo(lastName))
                    .body("password", equalTo(password))
                    .body("phone", equalTo(phone))
                    .body("username", equalTo(username));
        }

}

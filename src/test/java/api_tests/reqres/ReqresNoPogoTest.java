package api_tests.reqres;

import api.Specifications;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.constant.Urls.REQRES_PAGE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ReqresNoPogoTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void CheckAvatarContainsText() {
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecOK200());
        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> avatars = jsonPath.get("data.avatar");
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        for(int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }

        Assert.assertTrue(emails.stream().allMatch(email->email.endsWith("@reqres.in")));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void userRegNoPogo() {
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecOK200());
        Map<String,String> userData = new HashMap<>();
        userData.put("email","eve.holt@reqres.in");
        userData.put("password","pistol");
        Response response = given()
                .body(userData)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assert.assertEquals(4,id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4",token);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void userRegUnsuccessfulNoPogo() {
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecERROR400());
        Map<String,String> userData = new HashMap<>();
        userData.put("email","sydney@fife");
        userData.put("password","");
        given()
                .body(userData)
                .when()
                .post("api/register")
                .then().log().all()
                .body("error", equalTo("Missing password"));
    }
}

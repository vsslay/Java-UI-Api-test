package api_tests;

import api.*;
import api.pogo_classes.ColorsData;
import api.pogo_classes.registration.Registration;
import api.pogo_classes.registration.RegistrationSuccess;
import api.pogo_classes.registration.RegistrationUnsuccessful;
import api.pogo_classes.user_time.UserData;
import api.pogo_classes.user_time.UserTime;
import api.pogo_classes.user_time.UserTimeResponse;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.List;

import static constants.constant.Urls.REQRES_PAGE;
import static io.restassured.RestAssured.given;

public class ReqresTest {

    @Test
    public void checkAvatarAndIdTest(){
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(user-> Assert.assertTrue(user.getAvatar().contains(user.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(user->user.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).toList();
        List<String> ids = users.stream().map(user->user.getId().toString()).toList();
        for (int i =0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void successRegistration(){
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Registration user = new Registration("eve.holt@reqres.in","pistol");
        RegistrationSuccess success = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(RegistrationSuccess.class);
        Assert.assertNotNull(success.getId());
        Assert.assertNotNull(success.getToken());
        Assert.assertEquals(id, success.getId());
        Assert.assertEquals(token, success.getToken());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void unSuccessRegistration(){
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecERROR400());
        Registration user = new Registration("sydney@fife","");
        RegistrationUnsuccessful unsuccessfulReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(RegistrationUnsuccessful.class);
        Assert.assertEquals("Missing password", unsuccessfulReg.error());
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void sortedYears() {
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecOK200());
        List<ColorsData> sorted = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = sorted.stream().map(ColorsData::getYear).toList();
        List<Integer> sortedYears = years.stream().sorted().toList();
        Assert.assertEquals(sortedYears, years);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void deleteRequest() {
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE),
                Specifications.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void timeTest() {
        Specifications.installSpecifications(Specifications.requestSpec(REQRES_PAGE), Specifications.responseSpecOK200());
        UserTime user = new UserTime("morpheus","zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex = "(.{8})$";
        String regexLocal = "(.{14})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regexLocal,"");
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex,""));
    }
}

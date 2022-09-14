package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.*;
import io.restassured.specification.*;

import static constants.constant.Urls.REQRES_PAGE;

public class Specifications {
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(REQRES_PAGE)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    public static ResponseSpecification responseSpecERROR400() {
        return new ResponseSpecBuilder().expectStatusCode(400).build();
    }

    public static ResponseSpecification responseSpecUnique(int status) {
        return new ResponseSpecBuilder().expectStatusCode(status).build();
    }

    public static void installSpecifications(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}

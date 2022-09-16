package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.*;
import io.restassured.specification.*;

public class Specifications {
    public static RequestSpecification requestSpec(String page) {
        return new RequestSpecBuilder()
                .setBaseUri(page)
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

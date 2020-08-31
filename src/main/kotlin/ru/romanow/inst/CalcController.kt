package ru.romanow.inst

import io.qameta.allure.Step
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.parsing.Parser
import io.restassured.specification.RequestSpecification
import org.hamcrest.Matchers

class CalcController(private val a: Int, private val b: Int) {
    private val requestSpecification: RequestSpecification = RequestSpecBuilder()
        .setBaseUri("https://rsoi-web-calc.herokuapp.com")
        .setBasePath("/calc")
        .setAccept(ContentType.JSON)
        .log(LogDetail.ALL)
        .build()

    init {
        RestAssured.defaultParser = Parser.JSON
        RestAssured.responseSpecification = ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(Matchers.lessThan(15000L))
            .build()
    }

    @Step("Plus operation")
    fun plus() = given(requestSpecification)
        .queryParam("a", a)
        .queryParam("b", b)
        .get()
        .then()
        .statusCode(200)
        .extract()
        .body()
        .asString()
}
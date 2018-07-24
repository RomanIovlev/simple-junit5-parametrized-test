package com.adidas.fct.be.api.base;

import com.adidas.fct.be.utils.CredentialsManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static io.restassured.http.Method.*;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;

public abstract class APIService extends ScenarioSteps {
    protected Response response;
    private static final String RESPONSE_VARIABLE = "response";
    @Step
    public void verifyBody(String expected) {
        response.then().body("content", equalTo(expected));
    }
    protected Response doPost(String endpoint) {
        return response = doRequest(POST, endpoint);
    }
    protected Response doGet(String endpoint) { return response = doRequest(GET, endpoint); }
    protected Response doPut(String endpoint) {
        return response = doRequest(PUT, endpoint);
    }
    protected Response doDelete(String endpoint) {
        return response = doRequest(DELETE, endpoint);
    }
    // ...

    Response doRequest(Method method, String endpoint) {
        System.out.println("Call request method " + method.name() + ". Endpoint: " + endpoint);
        return new RestAssuredResponseImpl();
        /*RestAssured.baseURI = "http://deheremap7358.linux.adsint.biz:5000/";
        String username = "FCT_Auto1";
        RequestSpecification specification = rest()
            .params("username", username, "password", CredentialsManager.get().password(username),
                "grant_type", "password", "scope", "openid",
                "client_id", "acme", "client_secret", "acmesecret")
            .auth()
            .preemptive()
            .basic("acme", "acmesecret");

        Response response = buildRequest(specification, method, endpoint)
            .then().extract().response();
        logResponse(response, username);
        return response;*/
    }

    private Response buildRequest(RequestSpecification specification, Method method, String endpoint) {
        RequestSpecification spec = specification.when();
        return Switch(method).get(
                Value(GET, m -> spec.get(endpoint)),
                Value(POST, m -> spec.post(endpoint)),
                Value(HEAD, m -> spec.head(endpoint)),
                Value(DELETE, m -> spec.delete(endpoint)),
                Value(PUT, m -> spec.put(endpoint)),
            Default(specification.when().get(endpoint))
        );
    }
    private void logResponse(Response response, String username) {
        if ("bearer".equals(response.getBody().jsonPath().getString("token_type"))) {
            setSessionVariable(RESPONSE_VARIABLE).to(response);
            setSessionVariable("accessToken").to(response.getBody().path("access_token"));
            setSessionVariable("username").to(username);
        } else {
            Assert.fail("Specify a range");
        }
    }
}

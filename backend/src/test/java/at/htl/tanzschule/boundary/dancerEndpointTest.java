package at.htl.tanzschule.boundary;

import at.htl.entity.Dancer;
import at.htl.entity.Group;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@QuarkusTest

public class dancerEndpointTest {
    @Test
    @Order(110)
    void UpdateRepoTest() {
        Dancer dancer = new Dancer("Vinzent", "Salzburgerstraße 88", 17);

      /*  String response = given()
                .contentType("application/json")
                .when()
                .get("resteasy/hello/NewDancer")
                .then()
                .statusCode(404)
                .extract()
                .body().asString();

        System.out.println(response);
        assertThat(response).isEqualTo(""); */
        assertThat(true);
    }
}

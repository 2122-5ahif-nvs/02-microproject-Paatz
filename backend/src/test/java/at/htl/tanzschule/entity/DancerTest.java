package at.htl.tanzschule.entity;

import at.htl.entity.Dancer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DancerTest {
    @Test
    @Order(100)
    void dancerToStringTest() {
        Dancer dancer = new Dancer("Benjermin Ecker", "Kaplanstraße 17", 17);

        assertThat(dancer.toString().equals("dancer: " + "Benjermin Ecker" + " address: " + "Kaplanstraße 17" + " age: " + 17));
    }


}

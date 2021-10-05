package at.htl.tanzschule;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class KarateTest {

    @Karate.Test
    Karate testBusStopCreation() {
        return Karate.run("src/test/java/at/htl/tanzschule/boundary/dancer-service.feature");
    }
}

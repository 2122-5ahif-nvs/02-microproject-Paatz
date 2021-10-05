package at.htl.tanzschule.entity;

import at.htl.entity.Dancer;
import at.htl.entity.Group;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupTest {
    @Test
    @Order(100)
    void groupToStringTest() {
        Group group = new Group("FlyingMoves");

        assertThat(group.toString().equals("id: " + 1 + " groupName: " + "FlyingMoves"));
    }
}

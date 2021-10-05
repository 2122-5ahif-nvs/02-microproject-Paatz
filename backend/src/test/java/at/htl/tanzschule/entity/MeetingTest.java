package at.htl.tanzschule.entity;

import at.htl.entity.Dancer;
import at.htl.entity.Meeting;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeetingTest {
    @Test
    @Order(100)
    void dancerToStringTest() {
        Meeting meeting = new Meeting("Saturday");

        assertThat(meeting.toString().equals("day: Staturday"));
    }
}

package at.htl.tanzschule.repository;

import at.htl.repository.RepositoryMeeting;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@QuarkusTest

public class RepositoryMeetingTest {

    @Inject
    RepositoryMeeting repositoryMeeting;

    @Test
    @Order(100)
    void repoExistsTest() {
        assertThat(repositoryMeeting).isNotNull();
    }



    /**
     * https://dzone.com/articles/assertj-and-collections-introduction
     * https://gist.github.com/mhaligowski/a902ed35910b223633c0f187a0cd0947
     */

    @Test
    @Order(110)
    void addInRepoTest() {
        repositoryMeeting.addMeeting("Saturday");

        assertThat(repositoryMeeting.getMeetings().size()).isEqualTo(6);


        assertThat(repositoryMeeting.getMeetings().get(5).getDay().equals("Saturday"));
    }
}

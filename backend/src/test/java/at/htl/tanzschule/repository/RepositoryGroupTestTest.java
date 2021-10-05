package at.htl.tanzschule.repository;

import at.htl.repository.RepositoryGroup;
import at.htl.entity.Group;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@QuarkusTest

public class RepositoryGroupTestTest {

    @Inject
    RepositoryGroup repositoryGroup;

    @Test
    @Order(100)
    void repoExistsTest() {
        assertThat(repositoryGroup).isNotNull();
    }



    /**
     * https://dzone.com/articles/assertj-and-collections-introduction
     * https://gist.github.com/mhaligowski/a902ed35910b223633c0f187a0cd0947
     */

    @Test
    @Order(110)
    void UpdateRepoTest() {
        Group findGroup = repositoryGroup.getGroups().stream().filter(group -> group.getGroupName().equals("HipHopEnergy")).findAny().get();
        repositoryGroup.UpdateGroup( findGroup,"TheHipHopEnergy");

        assertThat(repositoryGroup.getGroups().size()).isEqualTo(3);
        assertThat(repositoryGroup.getGroups().get(2).getGroupName().equals("TheHipHopEnergy"));
    }


}

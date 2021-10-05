package at.htl.tanzschule.repository;

import at.htl.repository.RepositoryDancer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


import javax.inject.Inject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@QuarkusTest

public class RepositoryDanceTest {

    @Inject
    RepositoryDancer repositoryDancer;

    @Test
    @Order(100)
    void repoExistsTest() {
        assertThat(repositoryDancer).isNotNull();
    }



    /**
     * https://dzone.com/articles/assertj-and-collections-introduction
     * https://gist.github.com/mhaligowski/a902ed35910b223633c0f187a0cd0947
     */

    @Test
    @Order(110)
    void addInRepoTest() {
        repositoryDancer.addDancer("Benjermin Ecker", "Kaplanstraße 17", 17);
        repositoryDancer.addDancer("Moritz Polleichtner", "Feldweg 3", 17);
        repositoryDancer.addDancer("Marcel Plakolb", "Feldweg 7", 17);


        assertThat(repositoryDancer.getDancers().size()).isEqualTo(6);


        assertThat(repositoryDancer.getDancers().get(3).getName().equals("Benjermin Ecker"));
        assertThat(repositoryDancer.getDancers().get(4).getName().equals("Moritz Polleichtner"));
        assertThat(repositoryDancer.getDancers().get(5).getName().equals("Marcel Plakolb"));

    }


    @Test
    @Order(120)
    void deleteDancerTest() {

        repositoryDancer.addDancer("Vinzent","Salzburgerstraße 88", 17);
        assertThat(repositoryDancer.getDancers().get(6).getName().equals("Vinzent"));

        repositoryDancer.removeDancer("Vinzent");
        assertThat(!repositoryDancer.searchDancer("Vinzent"));
    }

}

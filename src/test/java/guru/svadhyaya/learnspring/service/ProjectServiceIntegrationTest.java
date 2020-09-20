package guru.svadhyaya.learnspring.service;

import guru.svadhyaya.learnspring.persistence.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceIntegrationTest {

    @Autowired
    IProjectService projectService;

    @Test
    public void whenSavingProject_thenOk() {
        assertThat(projectService).isNotNull();
        Project savedProject = projectService.save(new Project(randomAlphabetic(4), LocalDate.now()));
        assertThat(savedProject).isNotNull();
    }
}

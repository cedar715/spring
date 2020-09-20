package guru.svadhyaya.learnspring.repository;

import guru.svadhyaya.learnspring.persistence.model.Project;
import guru.svadhyaya.learnspring.persistence.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository repository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        assertNotNull(repository.save(newProject));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        repository.save(newProject);

        Optional<Project> retrievedProject = repository.findById(newProject.getId());
        assertEquals(retrievedProject.get().getId(), newProject.getId());

    }

    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        repository.save(newProject);

        Optional<Project> retrievedProject = repository.findByName(newProject.getName());
        assertEquals(retrievedProject.get().getName(), newProject.getName());

    }

    @Test
    public void givenProject_whenFindByDateCreatedBetween_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        repository.save(oldProject);

        Project newProj1 = new Project(randomAlphabetic(6), LocalDate.now().minusDays(2));
        repository.save(newProj1);

        Project newProj2 = new Project(randomAlphabetic(6), LocalDate.now().minusDays(2));
        repository.save(newProj2);

        List<Project> retrievedProjs = repository.findByDateCreatedBetween(LocalDate.now().minusDays(3), LocalDate.now().minusDays(1));
        assertEquals(2, retrievedProjs.size());

    }


}

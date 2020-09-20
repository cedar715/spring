package guru.svadhyaya.learnspring.service;

import guru.svadhyaya.learnspring.persistence.model.Project;
import guru.svadhyaya.learnspring.persistence.repository.IProjectRepository;
import guru.svadhyaya.learnspring.service.impl.ProjectServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

// No annotations coz we don't want the application context to be initialized
@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceUnitTest {

    @Mock
    IProjectRepository repository;

    //Mockito provides a convenient @InjectMock annotation that creates the target object
    //and injects the @Mock marked dependencies into it
    @InjectMocks
    ProjectServiceImpl service;

    @Test
    public void whenSavingProject_thenOk() {
        Project project = new Project(6L, "UT", LocalDate.now());
        Mockito.when(repository.save(project)).thenReturn(project);

        Project savedProject = service.save(project);

        assertThat(savedProject).isNotNull();
    }

}

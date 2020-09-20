package guru.svadhyaya.learnspring.service;

import guru.svadhyaya.learnspring.persistence.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceIntegrationMockTest {

    //We can use the @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
    @MockBean
    IProjectService mockProjectService;

    @Autowired
    ApplicationContext context;

    @Test
    public void whenSavingProject_thenOk() {
        assertThat(mockProjectService).isNotNull();

        Project project = new Project(6L, "TU", LocalDate.now());
        Mockito.when(mockProjectService.save(project)).thenReturn(project);

        IProjectService projectSvcFromBean = context.getBean(IProjectService.class);
        Project savedProject = projectSvcFromBean.save(project);

        assertThat(savedProject).isNotNull();
        Mockito.verify(mockProjectService).save(project);

    }
}

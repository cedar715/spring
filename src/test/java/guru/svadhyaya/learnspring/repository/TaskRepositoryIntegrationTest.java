package guru.svadhyaya.learnspring.repository;

import guru.svadhyaya.learnspring.persistence.model.Task;
import guru.svadhyaya.learnspring.persistence.repository.ITaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskRepositoryIntegrationTest {

    @Autowired
    ITaskRepository taskRepository;

    @Test
    public void givenProjectCreated_thenFindByTaskName_MatchesSuccess() {
        Task task1 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
//        Task task2 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
//        Task task3 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());
//        Task task4 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());

        Task save = taskRepository.save(task1);
        assertThat(save).isNotNull();
        System.out.println(save);
//        Task save2 = taskRepository.save(task2);
//        System.out.println(save2);
//        Task save3 = taskRepository.save(task3);
//        System.out.println(save3);
//        Task save4 = taskRepository.save(task4);
//        System.out.println(save4);

//        Optional<Task> byId = taskRepository.findById(save.getId());
//        System.out.println(byId.get());

//        List<Task> retrievedTasks = taskRepository.findByNameMatches("High");
//        System.out.println(retrievedTasks);
//        assertThat(retrievedTasks).contains(task3, task4);

//        Optional<Task> byId = taskRepository.findById(save.getId());
//        System.out.println(byId.get());
    }
}

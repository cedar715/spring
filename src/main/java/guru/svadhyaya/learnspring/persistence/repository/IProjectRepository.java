package guru.svadhyaya.learnspring.persistence.repository;

import guru.svadhyaya.learnspring.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectRepository extends CrudRepository<Project, Long> {
}

package guru.svadhyaya.learnspring.persistence.repository;

import guru.svadhyaya.learnspring.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}

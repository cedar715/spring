package guru.svadhyaya.learnspring.persistence.repository.impl;

import guru.svadhyaya.learnspring.persistence.model.Project;
import guru.svadhyaya.learnspring.persistence.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepositoryImpl.class);


    @Value("${project.prefix}")
    private String prefix;

    @Value("${project.suffix}")
    private Integer suffix;

    public ProjectRepositoryImpl() {
        super();
    }

    List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project p;
        Optional<Project> existingProject = findById(project.getId());
        updateInternalId(project);
        if (existingProject.isPresent()) {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
            p = newProject;
        } else {
            projects.add(project);
            p = project;
        }

        return p;
    }

    private void updateInternalId(Project project) {

        LOG.info("Prepending Prefix " + prefix);
        LOG.info("Appending Suffix " + suffix);
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
        LOG.info("Generated internal id " + project.getInternalId());

    }
}

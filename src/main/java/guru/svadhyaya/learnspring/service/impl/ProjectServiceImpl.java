package guru.svadhyaya.learnspring.service.impl;

import guru.svadhyaya.learnspring.persistence.model.Project;
import guru.svadhyaya.learnspring.persistence.repository.IProjectRepository;
import guru.svadhyaya.learnspring.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService, ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    final
    IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project service >> Finding Project by ID {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project service >> Saving Project {}", project);
        return projectRepository.save(project);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG.info("CONTEXT WITH ID '{}' SET", applicationContext.getId());

    }
}

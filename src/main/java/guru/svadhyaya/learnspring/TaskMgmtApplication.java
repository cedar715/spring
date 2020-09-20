package guru.svadhyaya.learnspring;

import guru.svadhyaya.learnspring.persistence.model.Project;
import guru.svadhyaya.learnspring.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class TaskMgmtApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TaskMgmtApplication.class);

    @Autowired
    IProjectService projectService;

    public static void main(String[] args) {
        SpringApplication.run(TaskMgmtApplication.class, args);

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("guru.svadhyaya.learnspring.persistence.repository");
//        ctx.scan("guru.svadhyaya.learnspring.service");
//
//        LOG.info("context created with id {}", ctx.getId());
//        IProjectService projectService = ctx.getBean("projectServiceImpl", IProjectService.class);
//        projectService.save(new Project(1L, "Test1", LocalDate.now()));
//        IProjectService projectService2 = ctx.getBean("projectServiceImpl", IProjectService.class);
//        LOG.info("projectService = projectService2? {}", projectService == projectService2);
//
//        LOG.info("{}", projectService.findById(1L));
//
//
//        LOG.info("Context active before close: {}", ctx.isActive());
//
//        ctx.close();
//
//        LOG.info("Context active after close: {}", ctx.isActive());
    }

    @PostConstruct
    public void postContruct(){
        projectService.save(new Project(1L, "Test1", LocalDate.now()));
        projectService.save(new Project(2L, "Test2", LocalDate.now()));
    }



}

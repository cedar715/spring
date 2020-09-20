package guru.svadhyaya.learnspring;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class ContextIntegrationTest {

    @Test
    public void whenContextIsLoaded_thenNoExceptions() {
        // test to verify the context is loaded properly w/o any errors during the bootstrap process
    }

    @Test
    public void whenContextIsLoaded_thenNoExceptions2() {
        // test to verify that the application context will be cached and the same
        // application context will be used
    }

    @Test
    @DirtiesContext
    public void whenContextIsLoaded_thenNoExceptions3() {
        // this method uses a new context and NOT the cached
    }
}

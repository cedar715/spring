package guru.svadhyaya.learnspring.spring;

import org.springframework.boot.CommandLineRunner;

public class BeanA implements CommandLineRunner {

    private String profile;

    public BeanA(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "profile='" + profile + '\'' +
                '}';
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("BeanA.run");
    }
}

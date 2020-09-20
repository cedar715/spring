package guru.svadhyaya.learnspring.spring;

public class BeanA {

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
}

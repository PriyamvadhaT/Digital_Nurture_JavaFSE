package singleton;

public class SingletonTest {

    public static void main(String[] args) {

        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.log("First Message");
        log2.log("Second Message");

        System.out.println(log1 == log2);
    }
}
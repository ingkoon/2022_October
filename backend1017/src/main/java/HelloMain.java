import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
    public static void main(String[] args) {
        HelloMessageKor kor = new HelloMessageKor();
        String greet = kor.helloKor("orlando");
        ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
        String text = context.getBean("11").toString();
        System.out.println(greet);
    }
}

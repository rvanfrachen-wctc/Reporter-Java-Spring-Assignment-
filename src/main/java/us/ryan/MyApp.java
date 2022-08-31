package us.ryan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyAppConfig.class);
        context.refresh();

        ((TheReport)context.getBean("theReport")).run();
    }
}

package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        try(AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(Launcher.class)){
            RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
            do {
                System.out.print("Input a message, we will sent it for you (q for quit) : ");
                input = sc.nextLine();

                if (input.equals("q")){
                    System.out.print("Bye.");
                }else {
                    rabbitTemplate.convertAndSend("", "chat_messages", input);
                    System.out.print("Message sent.");
                }
            }while (!input.equals("q"));
            context.close();
        }
    }
}

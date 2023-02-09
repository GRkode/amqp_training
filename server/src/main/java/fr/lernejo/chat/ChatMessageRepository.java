package fr.lernejo.chat;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatMessageRepository {

    private final List<String> messages = new ArrayList<>();
    void addChatMessage(String message){
        messages.add(message);
    }

    List<String> getLastTenMessages(){
        int size = messages.size();
        List<String> lastTen = new ArrayList<>();
        for (int i = Math.max(0, size - 10); i < size; i++) {
            lastTen.add(messages.get(i));
        }
        return lastTen;
    }
}

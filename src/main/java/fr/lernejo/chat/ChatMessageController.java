package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageController(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }
    @GetMapping("api/message")
    List<String> getMessage(){
        return chatMessageRepository.getLastTenMessages();
    }
}

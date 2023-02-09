package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageListener(ChatMessageRepository chatMessage) {
        this.chatMessageRepository = chatMessage;
    }

    void onMessage(String message){
        chatMessageRepository.addChatMessage(message);
    }
}

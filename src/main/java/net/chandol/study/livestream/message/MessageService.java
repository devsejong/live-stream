package net.chandol.study.livestream.message;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepository;

    public Message sendMessage(Long channelId, Long connectorId, String body) {
        Message message = new Message(channelId, connectorId, body);
        return messageRepository.save(message);
    }
}

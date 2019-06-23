package net.chandol.study.livestream.message;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private Long channelId;

    private Long connectorId;

    private String body;

    private Message() {
    }

    public Message(Long channelId, Long connectorId, String body) {
        this.channelId = channelId;
        this.connectorId = connectorId;
        this.body = body;
    }
}

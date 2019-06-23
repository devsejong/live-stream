package net.chandol.study.livestream.channel.dto;

import lombok.Getter;
import net.chandol.study.livestream.channel.domain.Channel;
import net.chandol.study.livestream.connector.Connector;

@Getter
public class ChannelCreateResponse {
    private Channel channel;
    private Connector connector;

    public ChannelCreateResponse(Channel channel, Connector connector) {
        this.channel = channel;
        this.connector = connector;
    }
}

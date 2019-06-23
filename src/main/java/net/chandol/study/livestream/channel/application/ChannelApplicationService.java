package net.chandol.study.livestream.channel.application;

import lombok.AllArgsConstructor;
import net.chandol.study.livestream.channel.domain.Channel;
import net.chandol.study.livestream.channel.domain.ChannelService;
import net.chandol.study.livestream.channel.dto.ChannelCreateResponse;
import net.chandol.study.livestream.connector.Connector;
import net.chandol.study.livestream.connector.ConnectorService;
import net.chandol.study.livestream.message.Message;
import net.chandol.study.livestream.message.MessageService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChannelApplicationService {
    private ChannelService channelService;
    private ConnectorService connectorService;
    private MessageService messageService;

    public ChannelCreateResponse create(String channelName, String connectorName) {
        Channel channel = channelService.create(channelName);
        Connector connector = connectorService.connect(channel.getId(), connectorName);

        return new ChannelCreateResponse(channel, connector);
    }

    public Connector connect(Long channelId, String connectorName) {
        channelService.validateChannel(channelId);
        return connectorService.connect(channelId, connectorName);
    }

    public Message sendMessage(Long channelId, Long connectorId, String body) {
        channelService.validateChannel(channelId);
        connectorService.validateConnector(channelId, connectorId);

        return messageService.sendMessage(channelId, connectorId, body);
    }
}

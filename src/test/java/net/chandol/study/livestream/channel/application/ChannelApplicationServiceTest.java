package net.chandol.study.livestream.channel.application;

import net.chandol.study.livestream.channel.domain.Channel;
import net.chandol.study.livestream.channel.domain.ChannelService;
import net.chandol.study.livestream.channel.dto.ChannelCreateResponse;
import net.chandol.study.livestream.connector.Connector;
import net.chandol.study.livestream.connector.ConnectorService;
import net.chandol.study.livestream.message.Message;
import net.chandol.study.livestream.message.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChannelApplicationServiceTest {

    @Autowired
    ChannelApplicationService channelApplicationService;
    @MockBean
    ChannelService channelService;
    @MockBean
    ConnectorService connectorService;
    @MockBean
    MessageService messageService;

    // 지금 당장은 필요없는 테스트
    // 추후 부가 기능이 들어가는 경우 테스트 뼈대로 활용할 예정
    @Test
    public void create() {
        // given
        when(channelService.create(anyString())).thenReturn(Channel.create("test-channel"));
        when(connectorService.connect(any(), anyString())).thenReturn(Connector.connect(1L, "test-connector"));

        // when
        ChannelCreateResponse channelCreateResponse = channelApplicationService.create("test-channel", "test-connect");

        // then
        assertThat(channelCreateResponse.getChannel().getName()).isEqualTo("test-channel");
        assertThat(channelCreateResponse.getConnector().getName()).isEqualTo("test-connector");
    }

    @Test
    public void connect() {
        // given
        when(connectorService.connect(1L, "connector"))
                .thenReturn(Connector.connect(1L, "connector"));

        // when
        Connector connector = channelApplicationService.connect(1L, "connector");

        // then
        assertThat(connector.getName()).isEqualTo("connector");
    }


    @Test
    public void sendMessage() {
        // given
        when(messageService.sendMessage(any(), any(), any())).thenReturn(new Message(1L, 2L, "message"));

        // when
        Message message = channelApplicationService.sendMessage(1L, 2L, "message");

        // then
        assertThat(message.getBody()).isEqualTo("message");
    }
}
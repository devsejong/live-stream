package net.chandol.study.livestream.channel;

import net.chandol.study.livestream.channel.domain.ChannelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    public void create() {

    }
}
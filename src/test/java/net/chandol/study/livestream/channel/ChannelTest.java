package net.chandol.study.livestream.channel;


import net.chandol.study.livestream.channel.domain.Channel;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ChannelTest {

    @Test
    public void 비어있는_이름이_들어오는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Channel.create(""));
    }

    @Test
    public void 이름이_null로_들어오는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Channel.create(null));
    }
}
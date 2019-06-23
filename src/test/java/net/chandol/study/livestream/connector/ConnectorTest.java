package net.chandol.study.livestream.connector;

import net.chandol.study.livestream.channel.domain.Channel;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.*;

public class ConnectorTest {

    @Test
    public void 비어있는_이름이_들어오는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Connector.connect(0L, ""));
    }

    @Test
    public void 이름이_null로_들어오는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Connector.connect(0L, null));
    }

    @Test
    public void 채널_ID는_null을_허용하지_않는다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Connector.connect(null, "exist"));
    }
}
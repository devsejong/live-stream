package net.chandol.study.livestream.common.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationEventPublisherProviderTest {

    @Test
    public void publishEvent() {
        TestEvent testEvent = new TestEvent();

        assertThat(testEvent.getEventReceiveCount()).isEqualTo(0);

        // when
        ApplicationEventPublisherProvider.publishEvent(testEvent);

        // then
        assertThat(testEvent.getEventReceiveCount()).isEqualTo(1);
    }
}

@Component
class TestEventHandler {

    @EventListener(classes = TestEvent.class)
    public void listen(TestEvent e) {
        e.eventReceived();
    }
}

class TestEvent {
    private AtomicInteger eventReceiveCount = new AtomicInteger(0);

    public int getEventReceiveCount() {
        return eventReceiveCount.get();
    }

    public void eventReceived() {
        eventReceiveCount.incrementAndGet();
    }
}

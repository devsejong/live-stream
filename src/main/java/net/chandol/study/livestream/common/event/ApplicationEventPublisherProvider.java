package net.chandol.study.livestream.common.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationEventPublisherProvider implements ApplicationEventPublisherAware {
    private static ApplicationEventPublisher publisher;

    public static ApplicationEventPublisher getEventPublisher() {
        return publisher;
    }

    public static void publishEvent(Object event) {
        if (publisher != null) {
            publisher.publishEvent(event);
        } else {
            log.warn("ApplicationEventPublisher가 존재하지 않습니다.");
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        ApplicationEventPublisherProvider.publisher = eventPublisher;
    }
}
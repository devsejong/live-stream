package net.chandol.study.livestream.connector;

import lombok.Getter;
import net.chandol.study.livestream.channel.domain.Channel;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

@Entity
@Getter
public class Connector {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long channelId;

    private Connector() {
    }

    private Connector(Long channelId, String name) {
        this.channelId = channelId;
        this.name = name;
    }

    public static Connector connect(Long channelId, String name) {
        checkArgument(hasText(name), "유효하지 않은 이름 : %s ", name);
        checkArgument(nonNull(channelId), "유효하지 않은 channelId");

        Connector connector = new Connector(channelId, name);
        return connector;
    }
}

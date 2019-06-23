package net.chandol.study.livestream.channel.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.persistence.GenerationType.AUTO;
import static org.springframework.util.StringUtils.hasText;


@Getter
@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    private Channel() {
    }

    private Channel(String name) {
        this.name = name;
    }

    public static Channel create(String name) {
        checkArgument(hasText(name), "유효하지 않는 이름 : %s ", name);
        return new Channel(name);
    }

}

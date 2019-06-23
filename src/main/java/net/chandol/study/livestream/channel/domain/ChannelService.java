package net.chandol.study.livestream.channel.domain;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import net.chandol.study.livestream.channel.domain.Channel;
import net.chandol.study.livestream.channel.infra.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class ChannelService {
    private ChannelRepository channelRepository;

    public Channel create(String channelName) {
        Channel channel = Channel.create(channelName);
        channelRepository.save(channel);

        return channel;
    }

    public void validateChannel(Long channelId) {
        checkArgument(nonNull(channelId), "채널Id는 null을 허용하지 않습니다.");
        checkArgument(channelRepository.existsById(channelId), "채널이 존재하지 않습니다. channelId : %s", channelId);
    }
}

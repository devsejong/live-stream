package net.chandol.study.livestream.channel.infra;

import net.chandol.study.livestream.channel.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}

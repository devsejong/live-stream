package net.chandol.study.livestream.connector;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class ConnectorService {

    private ConnectorRepository connectorRepository;

    public Connector connect(Long channelId, String name) {
        Connector connector = Connector.connect(channelId, name);
        connectorRepository.save(connector);

        return connector;
    }

    public void validateConnector(Long channelId, Long connectorId) {
        checkArgument(nonNull(connectorId) && nonNull(channelId), "채널Id와 커넥터Id는 null을 허용하지 않습니다.");
        Connector connector = connectorRepository.findById(channelId).orElseThrow(()->new IllegalArgumentException("커넥터가 존재하지 않습니다. channelId : " + channelId));
        checkArgument(Objects.equals(connector.getChannelId(), channelId), "connectorId와 channelId가 서로 다릅니다.");
    }
}

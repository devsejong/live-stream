package net.chandol.study.livestream.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChannelController {
    @GetMapping("/channel/{channelId}")
    public String channel(@PathVariable String channelId, Model model) {
        // 화면 반환하쟈...
        model.addAttribute("title", "타이틀 " + channelId);
        model.addAttribute("body", "바디");

        return "channel";
    }
}

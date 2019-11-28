package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    private final Map<String, String> env;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr) {
        this.env = new HashMap<>();
        this.env.put("PORT", port);
        this.env.put("MEMORY_LIMIT", memoryLimit);
        this.env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        this.env.put("CF_INSTANCE_ADDR", cfInstanceAddr);

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return this.env;
    }
}

package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;




@RestController
public class EnvController {
    Map <String,String> map = new HashMap();

    public EnvController(@Value("${port:NOT SET}")  String port,
                         @Value("${memory.limit:NOT SET}") String memory_limit,
                         @Value("${cf.instance.index:NOT SET}") String cf_instance_index,
                         @Value("${cf.instance.addr:NOT SET}") String cf_instance_addr) {
        map.put("PORT", port);
        map.put("MEMORY_LIMIT", memory_limit);
        map.put("CF_INSTANCE_INDEX", cf_instance_index);
        map.put("CF_INSTANCE_ADDR", cf_instance_addr);

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return map;


    }



}



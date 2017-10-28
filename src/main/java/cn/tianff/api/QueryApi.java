package cn.tianff.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * HTTP REST API for cache CRUD ops
 * Created by Tianff on 2017/10/28.
 */
@RestController
@RequestMapping("/cache/api")
public class QueryApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryApi.class);


    @GetMapping("/object/{Key}")
    public Object retrieve(@PathVariable("Key") String key) {


        return null;
    }

    @PostMapping("/object")
    public Object save(@RequestBody String json) {


        return null;
    }

    @DeleteMapping("/object/{Key}")
    public Object delete(@PathVariable("Key") String key) {

        return null;
    }


}

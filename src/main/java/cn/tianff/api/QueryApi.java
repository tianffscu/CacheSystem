package cn.tianff.api;

import org.springframework.web.bind.annotation.*;

/**
 * HTTP REST API for cache CRUD ops
 * Created by Tianff on 2017/10/28.
 */
@RestController
@RequestMapping("/cache/api")
public class QueryApi {


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

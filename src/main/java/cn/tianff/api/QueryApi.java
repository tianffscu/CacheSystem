package cn.tianff.api;

import cn.tianff.cache.CachedObject;
import cn.tianff.cache.HashCacheWrapper;
import cn.tianff.testing.Bear;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HTTP REST API for cache CRUD ops
 * Created by Tianff on 2017/10/28.
 */
@RestController
@RequestMapping("/cache/api")
public class QueryApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryApi.class);

    //Gson object is thread safe.
    private Gson defaultJsonParser = new Gson();

    /***************************************************************
     * Only for testing:
     * A Map for cache use, test the API function
     */
    private Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {

        String testingKeyWithSpace = "cn.tianff.testing.CacheBear:A demo space bear";

        Bear bear = new Bear("A demo space bear", "I am a bear with space.");
        CachedObject<Bear> cachedBear = new HashCacheWrapper<>(testingKeyWithSpace, bear);

        String testingKeyWithDash = "cn.tianff.testing.CacheBear:A-demo-dash-bear";
        Bear bear2 = new Bear("A demo dash bear", "I am a bear with dash.");
        CachedObject<Bear> cachedBear2 = new HashCacheWrapper<>(testingKeyWithDash, bear2);

        cacheMap.put(testingKeyWithDash, cachedBear2.cache());
        cacheMap.put(testingKeyWithSpace, cachedBear.cache());
    }
    //***************************************************************


    /**
     * Retrieve Api
     *
     * @param key REST get param, {:.+} means do not cut the url at the last {.}, see Spring Docs
     *            e.g. http://localhost/object/com.example.key will be normally cut as com.example
     *            but we need com.example.key here.
     * @return A json contains cached object
     */
    @GetMapping("/object/{Key:.+}")
    public Object retrieve(@PathVariable("Key") String key) {

        return defaultJsonParser.toJson(cacheMap.get(key));
    }


    @GetMapping("/object")
    public Object getAll() {
        return defaultJsonParser.toJson(cacheMap);
    }

    @PostMapping("/object")
    public Object save(@RequestBody String json) {

        CachedObject<?> cachedObject
                = defaultJsonParser.fromJson(json, new TypeToken<HashCacheWrapper<Bear>>() {
        }.getType());

        LOGGER.debug("Received: " + cachedObject);

        return "ok";
    }

    @DeleteMapping("/object/{Key:.+}")
    public Object delete(@PathVariable("Key") String key) {
        return cacheMap.remove(key);
    }

}

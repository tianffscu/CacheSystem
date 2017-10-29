package cn.tianff.cache.repo;

import cn.tianff.cache.CachedObject;
import cn.tianff.cache.HashCacheWrapper;
import cn.tianff.testing.Bear;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HashCacheRepositoryTest {

    @Autowired
    HashCacheRepository repo;

    @Test
    public void testSave(){

        Bear bear = new Bear("Bear001","I am a testing bear");

        CachedObject<Bear> cachedObject = new HashCacheWrapper<>("cn.tianff.testing.CacheBear:Bear001",bear);
        cachedObject.cache();
        System.out.println(cachedObject);

        repo.save(cachedObject);
    }

}
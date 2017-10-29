package cn.tianff.cache.service;

import cn.tianff.cache.CachedObject;
import cn.tianff.cache.repo.HashCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl<T extends CachedObject<?>> implements CacheService<T> {

    @Autowired
    private HashCacheRepository repo;


    @Override
    public void save(T t) {

    }

    @Override
    public T getOne(String cacheKey) {
        return null;
    }

    @Override
    public void remove(String cacheKey) {

    }
}

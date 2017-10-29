package cn.tianff.cache.service;

import cn.tianff.cache.CachedObject;

/**
 * Cache operation definition
 * Created by Tianff on 2017/10/28.
 */
public interface CacheService<T extends CachedObject<?>> {

    void save(T t);

    T getOne(String cacheKey);

    void remove(String cacheKey);

}

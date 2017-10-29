package cn.tianff.cache.repo;

import cn.tianff.cache.CachedObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tianff on 2017/10/28.
 */
public interface HashCacheRepository extends CrudRepository<CachedObject<?>,String>{
}

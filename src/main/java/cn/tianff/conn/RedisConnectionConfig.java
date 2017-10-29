package cn.tianff.conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConnectionConfig {
    /**
     * Type safe representation of application.properties
     */

    private ClusterConfigurationProperties clusterProperties;

    @Autowired
    public RedisConnectionConfig(ClusterConfigurationProperties clusterProperties) {
        this.clusterProperties = clusterProperties;
    }

//    @Bean
    public RedisConnectionFactory connectionFactory() {
        System.out.println(clusterProperties.getNodes());

        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()));
//        return new LettuceConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()));
    }

//    @Bean
//    public RedisTemplate<?, ?> redisTemplate() {
//        return new RedisTemplate<byte[], byte[]>();
//    }
}

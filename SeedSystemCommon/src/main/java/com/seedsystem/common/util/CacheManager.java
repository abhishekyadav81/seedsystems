package com.seedsystem.common.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * This Class will be used to update the Cache in Redis.
 *
 */
@Component
public class CacheManager {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;
  
  
  
  @Value("${link.expiration.duration}")
  private int linkExpirationDuration;

  
  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
      return new JedisConnectionFactory();
  }
   
  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
      RedisTemplate<String, Object> template = new RedisTemplate<>();
      template.setConnectionFactory(jedisConnectionFactory());
      return template;
  }

  
  
  
  
  /**
   * This method is used to store the element in cache against a identifier.
   *
   * @param cacheType
   *          Type of Cache.
   * @param key
   *          Key of Item.
   * @param obj
   *          Value of Item put in Cache.
   */
  public void put(String cacheType, String key, Object obj) {
    redisTemplate.opsForHash().put(cacheType, key, obj);

  }

  /**
   * This method is used to get the item from Cache.
   *
   * @param cacheType
   *          Type of Cache.
   * @param key
   *          Key of Item.
   * @param cls
   *          Type of Object
   * @param <T>
   *          Object return from Cache
   * @return Object return from Cache
   */
  public <T> T get(String cacheType, String key, Class<T> cls) {
    return (cls.cast(redisTemplate.opsForHash().get(cacheType, key)));
  }

  /**
   * This method is used to remove the entries from Cache.
   *
   * @param cacheType
   *          Type of Cache.
   * @param key
   *          Key of Item.
   */
  public void remove(String cacheType, String key) {
    redisTemplate.opsForHash().delete(cacheType, key);
  }

  /**
   * This method is used to set cache.
   * 
   * @param key
   *          {@link String}
   * @param obj
   *          {@link Object}
   */
  public void set(String key, Object obj) {
    redisTemplate.opsForValue().set(key, obj, linkExpirationDuration, TimeUnit.HOURS);
  }

  /**
   * This method is used to get value from cache.
   * 
   * @param key
   *          {@link String}
   * @return {@link Object}
   */
  public Object get(String key) {
    return redisTemplate.opsForValue().get(key);
  }

  /**
   * This method is used to get value from cache.
   * 
   * @param key
   *          {@link String}
   */
  public void remove(String key) {
    redisTemplate.expire(key, 0, TimeUnit.SECONDS);
  }

}

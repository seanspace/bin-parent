package com.bin.redis.structure;

import com.bin.redis.utils.JedisUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @Author: xiaobin.liu
 * @Date: 16/9/30
 * @Time: 上午10:43
 */
public class RedisHash {

    Logger logger = LoggerFactory.getLogger(RedisString.class) ;

    /**
     * HSET key field value
     * 将哈希表 key 中的字段 field 的值设为 value 。
     */
    @Test
    public void testHSet() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        long result = jedis.hset("com.bin.RedisHash.testHSet", "key1", "com.bin.RedisHash.testHSet the Value");
        logger.info("resuslt :" + result);

        logger.info("getAll :" + jedis.hgetAll("com.bin.RedisHash.testHSet"));
    }

    /**
     * HGET key field
     * 获取存储在哈希表中指定字段的值。
     */
    @Test
    public void testHet() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        String result = jedis.hget("com.bin.RedisHash.testHSet","key1");
        logger.info("resuslt :" + result);

        logger.info("getAll :" + jedis.hgetAll("com.bin.RedisHash.testHSet"));
    }
}

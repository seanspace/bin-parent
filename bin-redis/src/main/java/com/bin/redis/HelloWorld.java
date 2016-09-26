package com.bin.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by xiaobin on 2016/9/25.
 */
public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class) ;

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("172.21.1.11",32379);
//        jedis.auth("123");
        //查看服务是否运行
        long time1 = System.currentTimeMillis() ;
        logger.info("Server is running: " + jedis.ping());
        logger.info("times:" + (System.currentTimeMillis() - time1) + "ms");
        logger.info("redis:" + jedis.get("redis")) ;
        logger.info("times:" + (System.currentTimeMillis() - time1) + "ms");

        logger.info("" + jedis.hset("hset_test", "name", "xiaobin"));
        logger.info("" + jedis.expire("hset_test", 10));//10秒过期
        logger.info("" + jedis.hgetAll("hset_test"));
        jedis.hexists("hset_test", "name");
        String hset_test = jedis.hget("hset_test", "name");
        logger.info(hset_test);
    }
}

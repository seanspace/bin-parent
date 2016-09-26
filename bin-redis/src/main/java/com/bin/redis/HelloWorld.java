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
        Jedis jedis = new Jedis("192.168.163.129",6379);
        jedis.auth("123");
        //查看服务是否运行
        long time1 = System.currentTimeMillis() ;
        logger.info("Server is running: " + jedis.ping());
        logger.info("times:" + (System.currentTimeMillis() - time1) + "ms");
        logger.info("redis:" + jedis.get("redis")) ;
        logger.info("times:" + (System.currentTimeMillis() - time1) + "ms");

        jedis.hset("hset_test", "name", "xiaobin" );
        jedis.hgetAll("hset_test");
        jedis.hexists("hset_test", "name");
        jedis.hget("hset_test", "xiaobin");
    }
}

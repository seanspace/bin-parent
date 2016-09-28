package com.bin.redis.utils;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * 简单的链接获取，不可用于生产
 */
public class JedisUtil {

    public static Jedis createJedis() {
        Jedis jedis = new Jedis("192.168.163.129",6379);
        jedis.auth("123");
        return jedis;
    }

    public static Jedis createJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);

        return jedis;
    }

    public static Jedis createJedis(String host, int port, String passwrod) {
        Jedis jedis = new Jedis(host, port);

        if (!StringUtils.isNotBlank(passwrod))
            jedis.auth(passwrod);
        
        return jedis;
    }

    public static Jedis createYeepayJedis() {
        Jedis jedis = new Jedis("172.21.1.11",32379);
//        jedis.auth("123");
        return jedis;
    }

}
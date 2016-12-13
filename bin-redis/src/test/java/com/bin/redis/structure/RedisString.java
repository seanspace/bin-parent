package com.bin.redis.structure;

import com.bin.redis.utils.JedisUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 字符串(string)
 * @Description:操作字符串
 * @Author: xiaobin.liu
 * @Date: 16/9/28
 * @Time: 上午10:44
 */
public class RedisString {
    Logger logger = LoggerFactory.getLogger(RedisString.class) ;

    /**
     * SET key value
     * 设置指定 key 的值
     *
     * 测试结论:key已经存在,再次调用Set将覆盖原有值。
     */
    @Test
    public void testSet() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        String result = jedis.set("com.bin.RedisString.testSet", "com.bin.RedisString.testSet the Value 2");
        logger.info("resuslt :" + result);
        if ("OK".equals(result)) {
            jedis.expire("com.bin.RedisString.testSet",300) ;
            logger.info("Set String success");
        }
    }

    /**
     * GET key
     * 获取指定 key 的值
     */
    @Test
    public void testGet() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        logger.info("get : + " + jedis.get("com.bin.RedisString.testSet"));

    }

    /**
     * GETRANGE key start end
     * 返回 key 中字符串值的子字符  做截取用0,2  com
     */
    @Test
    public void testGetRange() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        logger.info("get :  " + jedis.get("com.bin.RedisString.testSet"));
        logger.info("getRange :" + jedis.getrange("com.bin.RedisString.testSet",0,2)) ;// com
    }

    /**
     * SETRANGE key offset value
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始。
     */
    @Test
    public void testSetRange() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        testSet() ;
        logger.info("get :  " + jedis.get("com.bin.RedisString.testSet"));
        logger.info("getRange :" + jedis.getrange("com.bin.RedisString.testSet",0,2)) ;// com
        jedis.setrange("com.bin.RedisString.testSet",0,"cn") ;// co替换成cn
        logger.info("setRange :" + jedis.get("com.bin.RedisString.testSet"));
    }

    /**
     * GETSET key value
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     */
    @Test
    public void testGetSet() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        testSet() ;
        logger.info("get : " + jedis.get("com.bin.RedisString.testSet"));
        logger.info("GetSet ,Old Value :" + jedis.getSet("com.bin.RedisString.testSet","GetSet update the Value")) ;
        logger.info("After GetSet New value : " + jedis.get("com.bin.RedisString.testSet"));
    }


//    GETBIT key offset
//    对 key 所储存的字符串值，获取指定偏移量上的位(bit)。

    /**
     * MSET key value [key value ...]
     * 同时设置一个或多个 key-value 对。
     *
     * MGET key1 [key2..]
     * 获取所有(一个或多个)给定 key 的值。
     */
    @Test
    public void testMSetMget() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        jedis.mset("com.bin.RedisString.testMSet1","testMSet1 value","com.bin.RedisString.testMSet2","testMSet2 value") ;
        List<String> mgetList = jedis.mget("com.bin.RedisString.testMSet1", "com.bin.RedisString.testMSet2");
        logger.info("MSet success Mget:" + mgetList);

    }

    /**
     * STRLEN key
     * 返回 key 所储存的字符串值的长度。
     */
    @Test
    public void testSTRLEN() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        testSet() ;
        logger.info("get : " + jedis.get("com.bin.RedisString.testSet"));
        logger.info("strlen :" + jedis.strlen("com.bin.RedisString.testSet"));
    }

    /**
     * SETEX key seconds value
     * 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
     */
    @Test
    public void testSetex() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        //10秒钟的有效期  设置key的值为value  10秒钟的有效期
        jedis.setex("com.bin.RedisString.testSetex", 10, "com.bin.RedisString.testSetex's value");
        logger.info("setex's value is : " + jedis.get("com.bin.RedisString.testSetex"));
    }

    /**
     * SETNX key value
     * 只有在 key 不存在时设置 key 的值。
     *
     * MSETNX key value [key value ...]
     * 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在
     */
    @Test
    public void testSetnx() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
//        testSetex() ;
        Long setSucc = jedis.setnx("com.bin.RedisString.testSetex11", "value has be setted");
        //如果设置成功,返回1,如果已经存在不设置,并返回0
        logger.info("是否设置:" + setSucc + ",setex's value is : " + jedis.get("com.bin.RedisString.testSetex"));
    }

    /**
     * INCR key
     * 将 key 中储存的数字值增一
     *
     * 测试:
     * 1. 字母abc不能进行自增,抛出异常: JedisDataException: `ERR value is not an integer or out of range
     * 2. 自增后,返回值为自增后的值。
     */
    @Test
    public void testIncr() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        jedis.set("testIncrStr","1") ;
        logger.info("设置值为:" + jedis.get("testIncrStr"));
        Long incr = jedis.incr("testIncrStr");//返回值为自增后的值
        logger.info("自增返回值:" + incr + ",增加后值为:" + jedis.get("testIncrStr"));

    }

    /**
     * INCRBY key increment
     * 将 key 所储存的值加上给定的增量值（increment） 。
     */
    @Test
    public void testIncrBy() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        jedis.set("testIncrby","1") ;
        logger.info("设置值为:" + jedis.get("testIncrby"));
        Long incr = jedis.incrBy("testIncrby",3);//返回值为自增后的值
        logger.info("增加后的返回值:" + incr + ",增加后值为:" + jedis.get("testIncrby"));

    }

    /**
     * INCRBYFLOAT key increment
     * 将 key 所储存的值加上给定的浮点增量值（increment） 。
     */
    @Test
    public void testIncrFloat() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        jedis.setex("testIncrFloat",10,"1") ;
        logger.info("设置值为:" + jedis.get("testIncrFloat"));
        Double incr = jedis.incrByFloat("testIncrFloat",3.1);//返回值为自增后的值
        logger.info("增加后的返回值:" + incr + ",增加后值为:" + jedis.get("testIncrFloat"));

    }

    /**
     * DECR key
     * 将 key 中储存的数字值减一。
     *
     * DECRBY key decrement
     * key 所储存的值减去给定的减量值（decrement） 。
     */
    @Test
    public void testDecr() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        jedis.setex("testDecr",10,"1") ;
        logger.info("设置值为:" + jedis.get("testDecr"));
        long decr = jedis.decr("testDecr");
        logger.info("减去后的返回值:" + decr + ",增加后值为:" + jedis.get("testDecr"));

    }

    /**
     * APPEND key value
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
     *
     * 返回值为字符串的长度。
     */
    @Test
    public void testAppend() {
        Jedis jedis = JedisUtil.createYeepayJedis() ;
        jedis.setex("testAppend",10,"123") ;
        logger.info("设置值为:" + jedis.get("testAppend"));
        long decr = jedis.append("testAppend", "45678");
        logger.info("Append后的返回值:" + decr + ",Append后的值为:" + jedis.get("testAppend"));

    }

//    PSETEX key milliseconds value
//    这个命令和 SETEX 命令相似，但它以毫秒为单位设置 key 的生存时间，而不是像 SETEX 命令那样，以秒为单位。





}

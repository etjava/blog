package com.etjava.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池
 * @author etjav
 *
 */
public class JedisPoolUtil {

	private static JedisPool pool = null;
	
	public static JedisPool instance() {
		if(pool == null) {
			synchronized (JedisPoolUtil.class) {
				if(pool == null) {
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxTotal(1000);// 最大连接数
					poolConfig.setMaxWaitMillis(2000);// 最大等待时间
					poolConfig.setMaxIdle(64);// 最大空闲连接数
					pool = new JedisPool(poolConfig, "192.168.199.125", 6379);
				}
			}
		}
		
		return pool;
	}
	
	public static void releace(Jedis jedis) {
		if(jedis!=null) {
			jedis.quit(); // 退出客户端
			jedis.disconnect(); // 断开连接
			jedis.close();
		}
	}
}

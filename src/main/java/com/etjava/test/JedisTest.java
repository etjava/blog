package com.etjava.test;

import com.etjava.util.JedisPoolUtil;

import redis.clients.jedis.JedisPool;

public class JedisTest {

	public static void main(String[] args) {
		JedisPool pool = JedisPoolUtil.instance();
		JedisPool pool2 = JedisPoolUtil.instance();
		System.out.println(pool == pool2);
	}
}

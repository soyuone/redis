package com.song.redis.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterTest {

	private JedisCluster jc;

	@Before
	public void before() {
		Set<HostAndPort> clusters = new HashSet<HostAndPort>();
		clusters.add(new HostAndPort("127.0.0.1", 6379));
		clusters.add(new HostAndPort("127.0.0.1", 6380));
		jc = new JedisCluster(clusters);
		jc.auth("asdf");
	}

	@Test
	public void testCluster() {
		jc.set("score", "100");
		jc.set("age", "28");

		String score = jc.get("score");
		Assert.assertEquals(score, "100");
		String age = jc.get("age");
		Assert.assertEquals(age, "28");
	}

	// 无法操作多个key
	@Test
	public void testMGet() {
		// 返回给定的key的值，如果有key不存在，则该key返回特殊值nil.
		List<String> values = jc.mget("score", "age");
		System.out.println(values);
	}

	@Test
	public void testBatchCluster() {
		// Jedis cluster不支持pipleline
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			jc.set("key" + i, "value" + i);
		}
		long time = System.currentTimeMillis() - begin;
		System.out.println(time);
	}

	@After
	public void after() {
		try {
			jc.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

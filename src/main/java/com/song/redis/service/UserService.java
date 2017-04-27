package com.song.redis.service;

import org.springframework.data.redis.core.RedisTemplate;

import com.song.redis.beans.UserBean;

public class UserService {

	RedisTemplate<String, UserBean> redisTemplate;

	public RedisTemplate<String, UserBean> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, UserBean> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(UserBean user) {
		redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
	}

	public void delete(UserBean key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	public UserBean get(UserBean key) {
		return (UserBean) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
	}
}

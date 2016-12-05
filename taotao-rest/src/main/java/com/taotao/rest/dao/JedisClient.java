package com.taotao.rest.dao;

/**
 * jedis client interface
 * 
 * @author yujia
 * 
 */
public interface JedisClient {

	String get(String key);

	String set(String key, String value);

	/**
	 * hash key
	 * 
	 * @param hkey
	 * @param key
	 * @return
	 */
	String hget(String hkey, String key);

	/**
	 * hash key
	 * 
	 * @param hkey
	 * @param key
	 * @param value
	 * @return
	 */
	long hset(String hkey, String key, String value);

	/**
	 * 递增
	 * 
	 * @param key
	 * @return
	 */
	long incr(String key);

	/**
	 * 设置存活时间
	 * 
	 * @param key
	 * @param second
	 * @return
	 */
	long expire(String key, int second);

	/**
	 * 命令以秒为单位返回 key 的剩余过期时间
	 * 
	 * @param key
	 * @return
	 */
	long ttl(String key);

	long del(String key);

	/**
	 * hash delete
	 * 
	 * @param hkey
	 * @param key
	 * @return
	 */
	long hdel(String hkey, String key);

}

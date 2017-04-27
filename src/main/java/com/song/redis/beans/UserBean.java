package com.song.redis.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = -2057792958148490460L;

	public static final String OBJECT_KEY = "USER";

	public UserBean() {
	}

	public UserBean(String id) {
	}

	public UserBean(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public String getKey() {
		return getId();
	}

	public String getObjectKey() {
		return OBJECT_KEY;
	}

}

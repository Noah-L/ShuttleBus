package com.oocl.shuttlebus.model;

import java.io.Serializable;

/**
 * Created by LANLE on 1/7/2016.
 */
public class BusStop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

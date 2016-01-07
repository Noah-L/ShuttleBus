package com.oocl.shuttlebus.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LANLE on 1/7/2016.
 */
public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String type;
	private List<BusStop> stop;
	private String name;
	private int vacancy;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public List<BusStop> getStop() {
		return stop;
	}

	public void setStop(List<BusStop> stop) {
		this.stop = stop;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

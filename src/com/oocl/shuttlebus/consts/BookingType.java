package com.oocl.shuttlebus.consts;

public enum BookingType {
	TEMPORARY(1, "临时预定", "临时预定(有效期为当天)"), USUALLY(2, "长期预定", "长期预定(长期有效)");

	private int id;
	private String value;
	private String text;

	private BookingType(int id, String value, String text) {
		this.id = id;
		this.value = value;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

package com.example.webdevsummer2018.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Widget {
	private String dtype;
	@Id
	private int id;
	private String name;
	private int size;
	private String text;
	private String widgetType;
	private String src;
	private String items;
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}

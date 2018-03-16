package com.yc.power.bean;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	private static final long serialVersionUID = 213109965369294996L;
	private Integer id;
	private String text;
	
	private List<MenuItem> children;
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", text=" + text + ", children=" + children + "]";
	}

	public Menu() {
		super();
	}
	
}

package com.javaex.ex01;

public class PhoneBook {

	// Field
	String name;
	String hp;
	String company;

	// Constructor

	public PhoneBook() {

	}

	public PhoneBook(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	// Method - gs

	public String getName() {
		return name;
	}

	public String getHp() {
		return hp;
	}

	public String getCompany() {
		return company;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// Method - Ordinary

	@Override
	public String toString() {
		return "PhoneBook [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}

	public String showInfo() {
		return name + "	" + hp + "	" + company;
	}

}

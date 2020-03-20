package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "steet1")
	private String steet1;

	@Column(name = "steet2")
	private String steet2;

	@Column(name = "city")
	private String city;

	@Column(name = "pin")
	private Long pin;

	@Column(name = "country")
	private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSteet1() {
		return steet1;
	}

	public void setSteet1(String steet1) {
		this.steet1 = steet1;
	}

	public String getSteet2() {
		return steet2;
	}

	public void setSteet2(String steet2) {
		this.steet2 = steet2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", steet1=" + steet1 + ", steet2=" + steet2 + ", city=" + city + ", pin=" + pin
				+ ", country=" + country + ", getId()=" + getId() + ", getSteet1()=" + getSteet1() + ", getSteet2()="
				+ getSteet2() + ", getCity()=" + getCity() + ", getPin()=" + getPin() + ", getCountry()=" + getCountry()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}

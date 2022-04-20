package com.example.entities;

import java.sql.Time;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rest_id;
	@Column(length = 20, nullable = false)
	private String rest_name;
	@Column(name="address",unique = true, nullable = false)
	private String address;
	@Column(length=20,nullable = false)
	private String area;
	@Column(length = 20,nullable = false)
	private String city;
	@Column(length = 10,nullable = false)
	private String pincode;
	@Column(length = 20,nullable = false)
	private Time estimated_deliver_time;
	@Column(length = 20,nullable = false)
	private Time open_time;
	@Column(length = 20,nullable = false)
	private Time close_time;
	
	@ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin adm;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Restaurant(String rest_name, String address, String area, String city, String pincode,
			Time estimated_deliver_time, Time open_time, Time close_time, Admin adm) {
		super();
		this.rest_name = rest_name;
		this.address = address;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.estimated_deliver_time = estimated_deliver_time;
		this.open_time = open_time;
		this.close_time = close_time;
		this.adm = adm;
	}



	public Integer getRest_id() {
		return rest_id;
	}

	public void setId(Integer id) {
		this.rest_id = rest_id;
	}

	public String getRest_name() {
		return rest_name;
	}

	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Time getEstimated_deliver_time() {
		return estimated_deliver_time;
	}

	public void setEstimated_deliver_time(Time estimated_deliver_time) {
		this.estimated_deliver_time = estimated_deliver_time;
	}

	public Time getOpen_time() {
		return open_time;
	}

	public void setOpen_time(Time open_time) {
		this.open_time = open_time;
	}

	public Time getClose_time() {
		return close_time;
	}

	public void setClose_time(Time close_time) {
		this.close_time = close_time;
	}



	public Admin getAdm() {
		return adm;
	}



	public void setAdm(Admin adm) {
		this.adm = adm;
	}



	public void setRest_id(Integer rest_id) {
		this.rest_id = rest_id;
	}



	@Override
	public String toString() {
		return "Restaurant [rest_id=" + rest_id + ", rest_name=" + rest_name + ", address=" + address + ", area=" + area
				+ ", city=" + city + ", pincode=" + pincode + ", estimated_deliver_time=" + estimated_deliver_time
				+ ", open_time=" + open_time + ", close_time=" + close_time + ", adm=" + adm + "]";
	}

	

}

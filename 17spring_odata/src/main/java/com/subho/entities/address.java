package com.subho.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

@EdmEntitySet
@EdmEntityType
@Entity
public class address {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name="uui2", strategy = "org.hibernet.id.UUIDGenerator")
	@Column(nullable=false, name="ID")
	@EdmKey
	@EdmProperty
	private Long addressId;
	@Column(name="TYPE")
	@EdmProperty
	private String addressType;
	@Column(name="STREET")
	@EdmProperty
	private String street;
	@Column(name="CITY")
	@EdmProperty
	private String city;
	@Column(name="COUNTRY")
	@EdmProperty
	private String country;
	@Column(name="REGION")
	@EdmProperty
	private String region;
	
	
//	Bi-directional relationship between Vendor and address class just like in SEGW
	@ManyToOne
	@JoinColumn(name = "vendor_id", referencedColumnName = "id")
	public Vendor vendor;
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public address() {
		
	}
	
	public address(Long addressId, String addressType, String street, String city, String country, String region) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.street = street;
		this.city = city;
		this.country = country;
		this.region = region;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}

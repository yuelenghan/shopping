package com.my.shopping.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_product")
public class Product {

	private long id;
	private String name;
	private String description;
	private double normalPrice;
	private double memberPrice;
	private Date pdate;
	private Category category;
	private Set<SalesItem> item;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", length = 40, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 255, nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "normal_price")
	public double getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}

	@Column(name = "member_price")
	public double getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(double memberPrice) {
		this.memberPrice = memberPrice;
	}

	@Column(name = "pdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	@ManyToOne
	@JoinColumn(name = "category", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(mappedBy = "product")
	public Set<SalesItem> getItem() {
		return item;
	}

	public void setItem(Set<SalesItem> item) {
		this.item = item;
	}

}

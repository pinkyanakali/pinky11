package com.niit.ShoppingCart.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="supid")
	private int supid;
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="supname")
	private String supname;
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="suplocation")
	private String suplocation;
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="categoryid")
	private int categoryid;
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="categoryname")
	private String categoryname;
	
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="productid")
	private int productid;
	@NotNull
	@Size(min=2,max=30)
	 @Column(name="productname")
	private String productname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSuplocation() {
		return suplocation;
	}
	public void setSuplocation(String suplocation) {
		this.suplocation = suplocation;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
}
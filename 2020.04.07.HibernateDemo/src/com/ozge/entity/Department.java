package com.ozge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity //kayıtlı sorgu denebilir.  
@Table(name="DEPARTMENTS")
public class Department {
	
	
	@Id //bu nesnenin unic anahtar olduğunu belşrtmem gerekiyor ıdenfier hatasında burası sorunlu oluyor belirtmem lazım
	@Column(name="department_id")
	@SequenceGenerator(name="dept_seq", sequenceName ="DEPARTMENTS_SEQ", allocationSize = 10 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "dept_seq")
	
	
	/*
	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	private Integer dept_id;
	
	@Column(name="department_name")
	private String deptname; 
	
	@Column(name="manager_id")
	private Integer managerid;
	
	@Column(name="location_id")
	private Integer locationid;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Integer getManagerid() {
		return managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public Department(String deptname, Integer managerid, Integer locationid) {
		this.deptname = deptname;
		this.managerid = managerid;
		this.locationid = locationid;
	}

	public Department() {
		super();
	}
	
	
	
	
	
	
	
	
	

}

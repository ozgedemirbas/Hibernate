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
public class Departments {
	
	
	@Id //bu nesnenin unic anahtar olduğunu belşrtmem gerekiyor ıdenfier hatasında burası sorunlu oluyor belirtmem lazım
	@Column(name="department_id")
	@SequenceGenerator(name="dept_seq", sequenceName ="DEPARTMENTS_SEQ", allocationSize = 10 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "dept_seq")
	private int dept_id;
	
	@Column(name="department_name")
	private String deptname; 
	
	@Column(name="manager_id")
	private int managerid;
	
	@Column(name="location_id")
	private int locationid;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public Departments(String deptname, int managerid, int locationid) {
		this.deptname = deptname;
		this.managerid = managerid;
		this.locationid = locationid;
	}
	
	
	
	
	
	
	
	
	

}

package com.sf.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
		
	// define constructors
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// define tostring

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
		
}



//package com.sf.assignment.entity;
//
//		import javax.persistence.*;
//		import java.util.List;
//
//@Entity
//@Table(name="patients")
//public class Patient {
//
//	@Id
//	@GeneratedValue(strategy= GenerationType.SEQUENCE)
//	@Column(name="P_id")
//	private int pid;
//
//	@Column(name="P_name")
//	private String pname;
//
//	@Column(name="Age")
//	private int age;
//
//	@Column(name="H_id")
//	private int hid;
//
//	@JoinTable(
//			name = "hospitals_patients",
//			joinColumns = @JoinColumn(name = "H_id"),
//			inverseJoinColumns = @JoinColumn(name = "PIH_id")
//	)
//	private List<Hospital> hospitals;
//
//	public Patient() {
//
//	}
//
//	public Patient(int pid, String pname, int age, int hid) {
//		this.pid = pid;
//		this.pname = pname;
//		this.age = age;
//		this.hid = hid;
//	}
//
//	public int getPid() {
//		return pid;
//	}
//
//	public void setPid(int pid) {
//		this.pid = pid;
//	}
//
//	public String getPname() {
//		return pname;
//	}
//
//	public void setPname(String pname) {
//		this.pname = pname;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public int getHid() {
//		return hid;
//	}
//
//	public void setHid(int hid) {
//		this.hid = hid;
//	}
//
//	@Override
//	public String toString() {
//		return "Patient{" +
//				"pid=" + pid +
//				", pname='" + pname + '\'' +
//				", age=" + age +
//				", hid=" + hid +
//				", hospitals=" + hospitals +
//				'}';
//	}
//}












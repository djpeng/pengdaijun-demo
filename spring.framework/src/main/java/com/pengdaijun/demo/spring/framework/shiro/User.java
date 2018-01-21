package com.pengdaijun.demo.spring.framework.shiro;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "s_user") // code11

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 8414549386401576226L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", length = 120)
	private String name; // 用户名
	@Column(name = "email", length = 50)
	private String email;// 用户邮箱
	@Column(name = "password", length = 120)
	private String password;// 用户密码
	@Temporal(TemporalType.DATE)
	@Column(name = "dob", length = 10)
	private Date dob;// 时间

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
	private Set<Role> SysRoles = new HashSet<Role>(0);// 所对应的角色集合

	public User() {
	}

	public User(String name, String email, String password, Date dob, Set<Role> SysRoles) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.SysRoles = SysRoles;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
	public Set<Role> getSysRoles() {
		return this.SysRoles;
	}

	public void setSysRoles(Set<Role> SysRoles) {
		this.SysRoles = SysRoles;
	}

}

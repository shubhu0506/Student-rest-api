package com.students.info.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "t_role")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@ManyToMany(targetEntity = User.class, mappedBy = "roles", cascade = CascadeType.ALL)
	private List<User> users;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Role(Long id, String name, String description, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
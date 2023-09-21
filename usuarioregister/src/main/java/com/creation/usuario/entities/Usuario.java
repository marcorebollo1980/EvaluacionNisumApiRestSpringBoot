package com.creation.usuario.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
public class Usuario {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String password;
	
	
	@Column(name="created")
	@Temporal(TemporalType.DATE)
	private Date created;
	
	
	@Column(name="modified")
	@Temporal(TemporalType.DATE)
	private Date modified;
	
	
	@Column(name="lastlogin")
	@Temporal(TemporalType.DATE)
	private Date lastlogin;
	

	@Column(name = "isactive")
	private String isactive;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Telefono> phones;
	
	//Metodos getters and setters
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Telefono> getPhones() {
		return phones;
	}
	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public Usuario orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

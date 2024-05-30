package com.creation.usuario.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="telefono")
@JsonIgnoreType
public class Telefono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("number") // Nombre del atributo JSON
    private String number;

    @JsonProperty("citycode") // Nombre del atributo JSON
    private String citycode;

    @JsonProperty("contrycode") // Nombre del atributo JSON
    private String contrycode;
	

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCitycode() {
		return citycode;
	}


	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public String getContrycode() {
		return contrycode;
	}


	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}

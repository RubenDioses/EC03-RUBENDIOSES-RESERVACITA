package com.idat.EC3RUBENDIOSESreservacita.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Hospital")
@Entity
public class Hospital implements Serializable {	

	private static final long serialVersionUID = -2458780697381215562L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "cliente_hospital", joinColumns = @JoinColumn(name = "id_cliente", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition =  "foreign key (id_cliente) reference cliente (id_cliente)")),
	
			inverseJoinColumns = @JoinColumn(name = "id_hospital", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition =  "foreign key (id_hospital) reference hospital (id_hospital)")) )
	private List<Cliente> cliente = new ArrayList<Cliente>();
			
	public Hospital() {
		super();
	}
	public int getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
	
	

}

package sistemacaja.com;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity
@Table(name = "almacenes") 
public class Almacen {
   @Id
   @GeneratedValue
   private Long id;
   private String nombre;
   @OneToMany(mappedBy = "almacen")
   private List<Usuario> Usuarios=new ArrayList<>(); //Un almacen podria tener mas de un usuario q ingrese datos

	public Almacen(){}

	public Long getIdAlmacen(){
		return id;
	}

	public String getNombreAlmacen(){
		return nombre;
	}

	public List<Usuario> getUsuario(){
		return Usuarios;
	}

	public Long getId(){
		return id;
	}
	
	public void setIdAlmacen(Long id){
		this.id=id;
	}

	public void setNombreAlmacen(String nombre){
		this.nombre=nombre;
	}

	public void setUsuarios(List<Usuario> Usuarios){
		this.Usuarios=Usuarios;
	}

	//Constructor

	public Almacen(Long id, String nombre, List<Usuario> Usuarios){
		this.id=id;
		this.nombre=nombre;
		this.Usuarios=Usuarios;
	}
}



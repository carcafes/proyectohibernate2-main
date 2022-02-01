package proyectohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hoteles")
public class Hoteles {
	@Id
	@Column ( columnDefinition= "char(6)")
	private String 	codHotel; 
	@Column ( columnDefinition= "varchar(60)")
	private String nomHotel;
	
	//TO-DO
	
	@OneToMany (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER,mappedBy="hotelesobj" )
	//@JoinColumn(name="cod")
	List<Habitaciones> habitacion = new ArrayList<Habitaciones>();

	public List<Habitaciones> getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(List<Habitaciones> habitacion) {
		this.habitacion = habitacion;
	}
	
	@OneToMany (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY,mappedBy="hotelesobj" )
	//@JoinColumn(name="cod")
	List<Regimenes> regimen = new ArrayList<Regimenes>();
	
	public List<Regimenes> getRegimen() {
		return regimen;
	}

	public void setRegimen(List<Regimenes> regimen) {
		this.regimen = regimen;
	}
	
	
	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	

	public Hoteles(String codHotel, String nomHotel) {
		super();
		this.codHotel = codHotel;
		this.nomHotel = nomHotel;
	}

	public Hoteles() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

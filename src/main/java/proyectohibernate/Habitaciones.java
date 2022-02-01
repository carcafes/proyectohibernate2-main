package proyectohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="habitaciones")
public class Habitaciones {
	
	@Transient
	String codHotel;
	
	@Id
	@Column(columnDefinition= "int(11)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codHabitacion;
	
	/*@Column(columnDefinition="char(6)")
	private String codHotel;*/
	
	@ManyToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.EAGER )
	@JoinColumn(name="codHotel")
	private Hoteles hotelesobj;
	
	@Column(columnDefinition="char(4)")
	private String numHabitacion;

	@Column(columnDefinition="smallint(6)")
	private int capacidad;
	
	@Column(columnDefinition="int(11)")
	private int precioDia;
	
	@Column(columnDefinition="tinyint(1)")
	private int activa;

	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@PrimaryKeyJoinColumn (name="codHabitaciones")
	private HabitacionesObservaciones habitacionesobservaciones;
	
	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="habitacionesobj" )
	//@JoinColumn(name="cod")
	List<Estancias> estancia = new ArrayList<Estancias>(); 
	
	
	
	
	public Habitaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPrecioDia() {
		return ""+precioDia;
	}


	public void setPrecioDia(int precioDia) {
		this.precioDia = precioDia;
	}


	public String getCodHabitacion() {
		return ""+codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public String getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
	/*
	public String getCodHotel() {
		return ;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}*/

	public String getCapacidad() {
		return ""+capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean getActiva() {
		if(activa==1)
			return true;
		else
			return false;
	}

	public void setActiva(boolean i) {
		if(i==true)
			this.activa=1;
		else
			this.activa=0;
	}


	public HabitacionesObservaciones getHabitacionesobservaciones() {
		if(habitacionesobservaciones!=null)
			return habitacionesobservaciones;
			else return new HabitacionesObservaciones();
	}


	public void setHabitacionesobservaciones(HabitacionesObservaciones habitacionesobservaciones) {
		this.habitacionesobservaciones = habitacionesobservaciones;
	}


	public List<Estancias> getEstancia() {
		return estancia;
	}


	public void setEstancia(List<Estancias> estancia) {
		this.estancia = estancia;
	}


	public Hoteles getHotelessobj() {
		return hotelesobj;
	}


	public void setHotelesobj(Hoteles hotelesobj) {
		this.hotelesobj = hotelesobj;
		this.codHotel=hotelesobj.getCodHotel();
	}


	@Override
	public String toString() {
		return "Habitaciones [codHabitacion=" + codHabitacion + ", numHabitacion=" + numHabitacion + ", capacidad=" + capacidad
				+ ", activa=" + activa + ", habitacionesobservaciones=" + habitacionesobservaciones + ", estancia="
				+ estancia + ", hotelesobj=" + hotelesobj + "]";
	}


	public Habitaciones( String numHabitacion, int capacidad, int activa, Hoteles hotelesobj) {
		super();
		this.numHabitacion = numHabitacion;
		this.capacidad = capacidad;
		this.activa = activa;
		this.hotelesobj = hotelesobj;
	}
	
}

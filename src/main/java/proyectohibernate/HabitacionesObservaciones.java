package proyectohibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="habitacionobservaciones")
public class HabitacionesObservaciones {
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator( name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "codHabitacionesXXX")})
	private int codHabitaciones ;
	
	@Column ( columnDefinition= "varchar(200)")
	private String observaciones ; 
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*cascade={CascadeType.PERSIST,CascadeType.REMOVE}*/
	@PrimaryKeyJoinColumn
	private Habitaciones codHabitacionesXXX;

	public HabitacionesObservaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HabitacionesObservaciones(int i,String x) {
		super();
		this.codHabitaciones=i;
		this.observaciones=x;
		// TODO Auto-generated constructor stub
	}

	public Integer getCodHabitaciones() {
		return codHabitaciones;
	}

	public void setCodHabitaciones(Integer codHabitaciones) {
		this.codHabitaciones = codHabitaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Habitaciones getCodHabitacionesXXX() {
		return codHabitacionesXXX;
	}

	public void setCodHabitacionesXXX(Habitaciones codHabitacionesXXX) {
		this.codHabitacionesXXX = codHabitacionesXXX;
	}

	@Override
	public String toString() {
		return "HabitacionesObservaciones [codHabitaciones=" + codHabitaciones + ", observaciones=" + observaciones + ", codHabitacionesXXX="
				+ codHabitacionesXXX + "]";
	}

	public HabitacionesObservaciones( String observaciones) {
		super();
		this.observaciones = observaciones;
	}
	
	
}

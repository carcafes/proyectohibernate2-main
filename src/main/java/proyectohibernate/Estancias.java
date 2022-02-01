package proyectohibernate;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estancias")
public class Estancias {

	@Id
	@Column(columnDefinition = "int(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codEstancia;
	
	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name = "codDNIoNIE")
	private Clientes clientesobj;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "codHabitaciones")
	private Habitaciones habitacionesobj;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "codRegimen")
	private Regimenes regimenobj;
	
	/*
	  @Column(columnDefinition= "char(9)") private String codDNIoNIE;
	  
	  @Column(columnDefinition= "int(11)") private int codHabitaciones;
	 */

	@Column(columnDefinition = "date")
	private String fechaInicio;

	@Column(columnDefinition = "date")
	private String fechaFin;

	@Column(columnDefinition = "smallint(6)")
	private int ocupantes;
	
	@Column(columnDefinition = "int(11)")
	private int precioEstancia;

	@Column(columnDefinition = "tinyint(1)")
	private int pagado;
	//TO-DO
	//codRegimenes
	

	public Estancias() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodEstancia() {
		return codEstancia;
	}

	public void setCodEstancia(int codEstancia) {
		this.codEstancia = codEstancia;
	}
	/*
	 * public String getCodDNIoNIE() { return codDNIoNIE; }
	 * 
	 * public void setCodDNIoNIE(String codDNIoNIE) { this.codDNIoNIE = codDNIoNIE;
	 * } 
	 * public int getCodHabitaciones() { return codHabitaciones; }
	 * 
	 * public void setCodHabitaciones(int codHabitaciones) { this.codHabitaciones =
	 * codHabitaciones; }
	 */

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public boolean getPagado() {
		if(pagado==1)
			return true;
		else
			return false;
	}

	public void setPagado(boolean i) {
		if(i==true)
			this.pagado=1;
		else
			this.pagado=0;
	}

	public int getPrecioEstancia() {
		return precioEstancia;
	}

	public void setPrecioEstancia(int precioEstancia) {
		this.precioEstancia = precioEstancia;
	}
	
	public int getOcupantes() {
		return precioEstancia;
	}

	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}

	public Clientes getClienteobj() {
		return clientesobj;
	}

	public void setClientesobj(Clientes clientesobj) {
		this.clientesobj = clientesobj;
	}

//TO-DO
	public Habitaciones getHabitacionesobj() {
		return habitacionesobj;
	}

	public void setHabitacionesobj(Habitaciones habitacionesobj) {
		this.habitacionesobj = habitacionesobj;
	}
	
	public Regimenes getRegimenesobj() {
		return regimenobj;
	}

	public void setRegimenesobj(Regimenes regimenobj) {
		this.regimenobj = regimenobj;
	}

	public Estancias(Clientes clientesobj,Regimenes regimenobj, Habitaciones habitacionesobj, String fechaInicio,
			String fechaFin, int precioEstancia) {
		super();
		this.clientesobj = clientesobj;
		this.regimenobj = regimenobj;
		this.habitacionesobj = habitacionesobj;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioEstancia = precioEstancia;
		
	}

}

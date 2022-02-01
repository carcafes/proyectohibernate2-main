package proyectohibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Clientes {


	@Id
	@Column(columnDefinition= "char(9)")
	private String codDNIoNIE;
	
	@Column(columnDefinition= "varchar (50)")
	private String nombre;

	@Column(columnDefinition= "varchar (40)")
	private String nacionalidad;
	
	@OneToMany (cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER,mappedBy="clientesobj" )
	//@JoinColumn(name="codDNIoNIE")
	List<Estancias> estancia = new ArrayList<Estancias>();

	public List<Estancias> getContratos() {
		return estancia;
	}

	public void setContratos(List<Estancias> estancia) {
		this.estancia = estancia;
	}
	
	public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	

	@Override
	public String toString() {
		return "Clientes [codDNIoNIE=" + codDNIoNIE + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", estancia=" + estancia + "]";
	}

	public Clientes(String codDNIoNIE, String nombre, String nacionalidad) {
		super();
		this.codDNIoNIE = codDNIoNIE;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;	}

	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	} 

	
}

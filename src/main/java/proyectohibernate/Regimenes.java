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
@Table(name="regimenes")
public class Regimenes {
	
	@Id
	@Column(columnDefinition= "int(11)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codregimen;
	
	/*@Column(columnDefinition="char(6)")
	private String codHotel;*/
	
	@ManyToOne (cascade={CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY )
	@JoinColumn(name="codHotel")
	private Hoteles hotelesobj;
	
	@Column(columnDefinition="char(2)")
	private String tipo;
	
	@Column(columnDefinition="tinyint(1)")
	private int pagado;
	
	@Column(columnDefinition="int(11)")
	private int precioDia;

	public int getCodregimen() {
		return codregimen;
	}

	public void setCodregimen(int codregimen) {
		this.codregimen = codregimen;
	}

	public Hoteles getHotelesobj() {
		return hotelesobj;
	}

	public void setHotelesobj(Hoteles hotelesobj) {
		this.hotelesobj = hotelesobj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(int precioDia) {
		this.precioDia = precioDia;
	}
}

package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_troncal")
public class Troncal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_troncal_orientacion")
    private String TroncalOrientacion;

    @Column(name = "inv_troncal_zona")
    private String TroncalZona;

    @Column(name = "inv_troncal_nombre")
    private String TroncalNombre;

    @Column(name = "inv_troncal_descipcion")
    private String TroncalDescipcion;

	public void setTroncalOrientacion(String TroncalOrientacion) {this.TroncalOrientacion = TroncalOrientacion;}
	public String getTroncalOrientacion() {return TroncalOrientacion;}
	public void setTroncalZona(String TroncalZona) {this.TroncalZona = TroncalZona;}
	public String getTroncalZona() {return TroncalZona;}
	public void setTroncalNombre(String TroncalNombre) {this.TroncalNombre = TroncalNombre;}
	public String getTroncalNombre() {return TroncalNombre;}
	public void setTroncalDescipcion(String TroncalDescipcion) {this.TroncalDescipcion = TroncalDescipcion;}
	public String getTroncalDescipcion() {return TroncalDescipcion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
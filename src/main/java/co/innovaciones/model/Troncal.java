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
    @Column(name = "inv_id_troncal")
    private Double idTroncal;

    @Column(name = "inv_troncal_orientacion")
    private String troncalOrientacion;

    @Column(name = "inv_troncal_zona")
    private String troncalZona;

    @Column(name = "inv_troncal_nombre")
    private String troncalNombre;

    @Column(name = "inv_troncal_descipcion")
    private String troncalDescripcion;

	public void setIdTroncal(Double idTroncal) {this.idTroncal = idTroncal;}
	public Double getIdTroncal() {return idTroncal;}
	public void setTroncalOrientacion(String troncalOrientacion) {this.troncalOrientacion = troncalOrientacion;}
	public String getTroncalOrientacion() {return troncalOrientacion;}
	public void setTroncalZona(String troncalZona) {this.troncalZona = troncalZona;}
	public String getTroncalZona() {return troncalZona;}
	public void setTroncalNombre(String troncalNombre) {this.troncalNombre = troncalNombre;}
	public String getTroncalNombre() {return troncalNombre;}
	public void setTroncalDescipcion(String troncalDescripcion) {this.troncalDescripcion = troncalDescripcion;}
	public String getTroncalDescipcion() {return troncalDescripcion;}
}
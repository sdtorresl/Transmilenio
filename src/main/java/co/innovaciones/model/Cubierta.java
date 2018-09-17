package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cubierta")
public class Cubierta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_cubierta_ancholucemario")
    private Double CubiertaAncholucemario;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_cubierta_lucemario")
    private Boolean CubiertaLucemario;

    @Column(name = "inv_cubierta_ancho")
    private Double CubiertaAncho;

    @Column(name = "inv_cubierta_largo")
    private Double CubiertaLargo;

    @Column(name = "inv_cubierta_largolucemario")
    private Double CubiertaLargolucemario;

    @Column(name = "inv_cubierta_averia")
    private Boolean CubiertaAveria;

	public void setCubiertaAncholucemario(Double CubiertaAncholucemario) {this.CubiertaAncholucemario = CubiertaAncholucemario;}
	public Double getCubiertaAncholucemario() {return CubiertaAncholucemario;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCubiertaLucemario(Boolean CubiertaLucemario) {this.CubiertaLucemario = CubiertaLucemario;}
	public Boolean getCubiertaLucemario() {return CubiertaLucemario;}
	public void setCubiertaAncho(Double CubiertaAncho) {this.CubiertaAncho = CubiertaAncho;}
	public Double getCubiertaAncho() {return CubiertaAncho;}
	public void setCubiertaLargo(Double CubiertaLargo) {this.CubiertaLargo = CubiertaLargo;}
	public Double getCubiertaLargo() {return CubiertaLargo;}
	public void setCubiertaLargolucemario(Double CubiertaLargolucemario) {this.CubiertaLargolucemario = CubiertaLargolucemario;}
	public Double getCubiertaLargolucemario() {return CubiertaLargolucemario;}
	public void setCubiertaAveria(Boolean CubiertaAveria) {this.CubiertaAveria = CubiertaAveria;}
	public Boolean getCubiertaAveria() {return CubiertaAveria;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
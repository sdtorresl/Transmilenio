package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_carpa")
public class Carpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_carpa_alto")
    private Double CarpaAlto;

    @Column(name = "inv_carpa_ancho")
    private Double CarpaAncho;

    @Column(name = "inv_carpa_largo")
    private Double CarpaLargo;

    @Column(name = "inv_carpa_id")
    private Double CarpaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_carpa")
    private Double IdCarpa;

    @Column(name = "inv_carpa_rota")
    private Boolean CarpaRota;

	public void setCarpaAlto(Double CarpaAlto) {this.CarpaAlto = CarpaAlto;}
	public Double getCarpaAlto() {return CarpaAlto;}
	public void setCarpaAncho(Double CarpaAncho) {this.CarpaAncho = CarpaAncho;}
	public Double getCarpaAncho() {return CarpaAncho;}
	public void setCarpaLargo(Double CarpaLargo) {this.CarpaLargo = CarpaLargo;}
	public Double getCarpaLargo() {return CarpaLargo;}
	public void setCarpaId(Double CarpaId) {this.CarpaId = CarpaId;}
	public Double getCarpaId() {return CarpaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdCarpa(Double IdCarpa) {this.IdCarpa = IdCarpa;}
	public Double getIdCarpa() {return IdCarpa;}
	public void setCarpaRota(Boolean CarpaRota) {this.CarpaRota = CarpaRota;}
	public Boolean getCarpaRota() {return CarpaRota;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
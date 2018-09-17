package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_rampa")
public class Rampa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_rampa")
    private Double IdRampa;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_rampa_id")
    private Double RampaId;

    @Column(name = "inv_rampa_longitud")
    private Double RampaLongitud;

    @Column(name = "inv_rampa_area")
    private Double RampaArea;

    @Column(name = "inv_rampa_averia")
    private Boolean RampaAveria;

    @Column(name = "inv_rampa_porcentajeaveria")
    private Double RampaPorcentajeaveria;

    @Column(name = "inv_id_material_averia")
    private Double IdMaterialAveria;

	public void setIdRampa(Double IdRampa) {this.IdRampa = IdRampa;}
	public Double getIdRampa() {return IdRampa;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setRampaId(Double RampaId) {this.RampaId = RampaId;}
	public Double getRampaId() {return RampaId;}
	public void setRampaLongitud(Double RampaLongitud) {this.RampaLongitud = RampaLongitud;}
	public Double getRampaLongitud() {return RampaLongitud;}
	public void setRampaArea(Double RampaArea) {this.RampaArea = RampaArea;}
	public Double getRampaArea() {return RampaArea;}
	public void setRampaAveria(Boolean RampaAveria) {this.RampaAveria = RampaAveria;}
	public Boolean getRampaAveria() {return RampaAveria;}
	public void setRampaPorcentajeaveria(Double RampaPorcentajeaveria) {this.RampaPorcentajeaveria = RampaPorcentajeaveria;}
	public Double getRampaPorcentajeaveria() {return RampaPorcentajeaveria;}
	public void setIdMaterialAveria(Double IdMaterialAveria) {this.IdMaterialAveria = IdMaterialAveria;}
	public Double getIdMaterialAveria() {return IdMaterialAveria;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
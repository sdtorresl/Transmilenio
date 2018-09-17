package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_puenteexterno")
public class Puenteexterno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_puenteexterno")
    private Double IdPuenteexterno;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_puenteexterno_id")
    private Double PuenteexternoId;

    @Column(name = "inv_id_material_pisoescalera")
    private String IdMaterialPisoescalera;

    @Column(name = "inv_puenteexterno_ubicacion")
    private String PuenteexternoUbicacion;

    @Column(name = "inv_puenteexterno_numeroascensor")
    private Double PuenteexternoNumeroascensor;

    @Column(name = "inv_puenteexterno_pmr")
    private String PuenteexternoPmr;

    @Column(name = "inv_puenteexterno_averiatablerometalico")
    private Boolean PuenteexternoAveriatablerometalico;

    @Column(name = "inv_puenteexterno_averiatablerobaldosa")
    private Boolean PuenteexternoAveriatablerobaldosa;

    @Column(name = "inv_puenteexterno_averiatableroconcreto")
    private Boolean PuenteexternoAveriatableroconcreto;

    @Column(name = "inv_puenteexterno_averiatableromadera")
    private Boolean PuenteexternoAveriatableromadera;

    @Column(name = "inv_puenteexterno_ruta_imagen")
    private String PuenteexternoRutaImagen;

    @Column(name = "inv_puenteexterno_imagen")
    private String PuenteexternoImagen;

    @Column(name = "inv_puenteexterno_numerorampa")
    private Double PuenteexternoNumerorampa;

    @Column(name = "inv_puenteexterno_numeroescalera")
    private Double PuenteexternoNumeroescalera;

	public void setIdPuenteexterno(Double IdPuenteexterno) {this.IdPuenteexterno = IdPuenteexterno;}
	public Double getIdPuenteexterno() {return IdPuenteexterno;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setPuenteexternoId(Double PuenteexternoId) {this.PuenteexternoId = PuenteexternoId;}
	public Double getPuenteexternoId() {return PuenteexternoId;}
	public void setIdMaterialPisoescalera(String IdMaterialPisoescalera) {this.IdMaterialPisoescalera = IdMaterialPisoescalera;}
	public String getIdMaterialPisoescalera() {return IdMaterialPisoescalera;}
	public void setPuenteexternoUbicacion(String PuenteexternoUbicacion) {this.PuenteexternoUbicacion = PuenteexternoUbicacion;}
	public String getPuenteexternoUbicacion() {return PuenteexternoUbicacion;}
	public void setPuenteexternoNumeroascensor(Double PuenteexternoNumeroascensor) {this.PuenteexternoNumeroascensor = PuenteexternoNumeroascensor;}
	public Double getPuenteexternoNumeroascensor() {return PuenteexternoNumeroascensor;}
	public void setPuenteexternoPmr(String PuenteexternoPmr) {this.PuenteexternoPmr = PuenteexternoPmr;}
	public String getPuenteexternoPmr() {return PuenteexternoPmr;}
	public void setPuenteexternoAveriatablerometalico(Boolean PuenteexternoAveriatablerometalico) {this.PuenteexternoAveriatablerometalico = PuenteexternoAveriatablerometalico;}
	public Boolean getPuenteexternoAveriatablerometalico() {return PuenteexternoAveriatablerometalico;}
	public void setPuenteexternoAveriatablerobaldosa(Boolean PuenteexternoAveriatablerobaldosa) {this.PuenteexternoAveriatablerobaldosa = PuenteexternoAveriatablerobaldosa;}
	public Boolean getPuenteexternoAveriatablerobaldosa() {return PuenteexternoAveriatablerobaldosa;}
	public void setPuenteexternoAveriatableroconcreto(Boolean PuenteexternoAveriatableroconcreto) {this.PuenteexternoAveriatableroconcreto = PuenteexternoAveriatableroconcreto;}
	public Boolean getPuenteexternoAveriatableroconcreto() {return PuenteexternoAveriatableroconcreto;}
	public void setPuenteexternoAveriatableromadera(Boolean PuenteexternoAveriatableromadera) {this.PuenteexternoAveriatableromadera = PuenteexternoAveriatableromadera;}
	public Boolean getPuenteexternoAveriatableromadera() {return PuenteexternoAveriatableromadera;}
	public void setPuenteexternoRutaImagen(String PuenteexternoRutaImagen) {this.PuenteexternoRutaImagen = PuenteexternoRutaImagen;}
	public String getPuenteexternoRutaImagen() {return PuenteexternoRutaImagen;}
	public void setPuenteexternoImagen(String PuenteexternoImagen) {this.PuenteexternoImagen = PuenteexternoImagen;}
	public String getPuenteexternoImagen() {return PuenteexternoImagen;}
	public void setPuenteexternoNumerorampa(Double PuenteexternoNumerorampa) {this.PuenteexternoNumerorampa = PuenteexternoNumerorampa;}
	public Double getPuenteexternoNumerorampa() {return PuenteexternoNumerorampa;}
	public void setPuenteexternoNumeroescalera(Double PuenteexternoNumeroescalera) {this.PuenteexternoNumeroescalera = PuenteexternoNumeroescalera;}
	public Double getPuenteexternoNumeroescalera() {return PuenteexternoNumeroescalera;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_puertatroncal")
public class Puertatroncal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_puertatroncal_botonpanico")
    private Boolean PuertatroncalBotonpanico;

    @Column(name = "inv_puertatroncal_tapacarter")
    private Boolean PuertatroncalTapacarter;

    @Column(name = "inv_puertatroncal_pisavidrio")
    private Boolean PuertatroncalPisavidrio;

    @Column(name = "inv_puertatroncal_zocaloinferior")
    private Boolean PuertatroncalZocaloinferior;

    @Column(name = "inv_puertatroncal_marcorobusto")
    private Boolean PuertatroncalMarcorobusto;

    @Column(name = "inv_puertatroncal_rutas")
    private String PuertatroncalRutas;

    @Column(name = "inv_puertatroncal_ruta_imagen")
    private String PuertatroncalRutaImagen;

    @Column(name = "inv_puertatroncal_imagen")
    private String PuertatroncalImagen;

    @Column(name = "inv_puertatroncal_costado")
    private String PuertatroncalCostado;

    @Column(name = "inv_puertatroncal_id")
    private Double PuertatroncalId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_puertatroncal")
    private Double IdPuertatroncal;

    @Column(name = "inv_puertatroncal_mecatronico")
    private Boolean PuertatroncalMecatronico;

    @Column(name = "inv_puertatroncal_marco")
    private String PuertatroncalMarco;

    @Column(name = "inv_id_tipo_puertatroncal")
    private String IdTipoPuertatroncal;

    @Column(name = "inv_puertatroncal_distancia")
    private Double PuertatroncalDistancia;

	public void setPuertatroncalBotonpanico(Boolean PuertatroncalBotonpanico) {this.PuertatroncalBotonpanico = PuertatroncalBotonpanico;}
	public Boolean getPuertatroncalBotonpanico() {return PuertatroncalBotonpanico;}
	public void setPuertatroncalTapacarter(Boolean PuertatroncalTapacarter) {this.PuertatroncalTapacarter = PuertatroncalTapacarter;}
	public Boolean getPuertatroncalTapacarter() {return PuertatroncalTapacarter;}
	public void setPuertatroncalPisavidrio(Boolean PuertatroncalPisavidrio) {this.PuertatroncalPisavidrio = PuertatroncalPisavidrio;}
	public Boolean getPuertatroncalPisavidrio() {return PuertatroncalPisavidrio;}
	public void setPuertatroncalZocaloinferior(Boolean PuertatroncalZocaloinferior) {this.PuertatroncalZocaloinferior = PuertatroncalZocaloinferior;}
	public Boolean getPuertatroncalZocaloinferior() {return PuertatroncalZocaloinferior;}
	public void setPuertatroncalMarcorobusto(Boolean PuertatroncalMarcorobusto) {this.PuertatroncalMarcorobusto = PuertatroncalMarcorobusto;}
	public Boolean getPuertatroncalMarcorobusto() {return PuertatroncalMarcorobusto;}
	public void setPuertatroncalRutas(String PuertatroncalRutas) {this.PuertatroncalRutas = PuertatroncalRutas;}
	public String getPuertatroncalRutas() {return PuertatroncalRutas;}
	public void setPuertatroncalRutaImagen(String PuertatroncalRutaImagen) {this.PuertatroncalRutaImagen = PuertatroncalRutaImagen;}
	public String getPuertatroncalRutaImagen() {return PuertatroncalRutaImagen;}
	public void setPuertatroncalImagen(String PuertatroncalImagen) {this.PuertatroncalImagen = PuertatroncalImagen;}
	public String getPuertatroncalImagen() {return PuertatroncalImagen;}
	public void setPuertatroncalCostado(String PuertatroncalCostado) {this.PuertatroncalCostado = PuertatroncalCostado;}
	public String getPuertatroncalCostado() {return PuertatroncalCostado;}
	public void setPuertatroncalId(Double PuertatroncalId) {this.PuertatroncalId = PuertatroncalId;}
	public Double getPuertatroncalId() {return PuertatroncalId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdPuertatroncal(Double IdPuertatroncal) {this.IdPuertatroncal = IdPuertatroncal;}
	public Double getIdPuertatroncal() {return IdPuertatroncal;}
	public void setPuertatroncalMecatronico(Boolean PuertatroncalMecatronico) {this.PuertatroncalMecatronico = PuertatroncalMecatronico;}
	public Boolean getPuertatroncalMecatronico() {return PuertatroncalMecatronico;}
	public void setPuertatroncalMarco(String PuertatroncalMarco) {this.PuertatroncalMarco = PuertatroncalMarco;}
	public String getPuertatroncalMarco() {return PuertatroncalMarco;}
	public void setIdTipoPuertatroncal(String IdTipoPuertatroncal) {this.IdTipoPuertatroncal = IdTipoPuertatroncal;}
	public String getIdTipoPuertatroncal() {return IdTipoPuertatroncal;}
	public void setPuertatroncalDistancia(Double PuertatroncalDistancia) {this.PuertatroncalDistancia = PuertatroncalDistancia;}
	public Double getPuertatroncalDistancia() {return PuertatroncalDistancia;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
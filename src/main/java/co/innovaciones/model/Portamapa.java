package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_portamapa")
public class Portamapa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_portamapa_id")
    private String PortamapaId;

    @Column(name = "inv_portamapa_corroido")
    private Boolean PortamapaCorroido;

    @Column(name = "inv_portamapa_malaconexion")
    private Boolean PortamapaMalaconexion;

    @Column(name = "inv_portamapa_averia")
    private Boolean PortamapaAveria;

    @Column(name = "inv_portamapa_costado")
    private String PortamapaCostado;

    @Column(name = "inv_portamapa_ancho")
    private Double PortamapaAncho;

    @Column(name = "inv_portamapa_alto")
    private Double PortamapaAlto;

    @Column(name = "inv_portamapa_presentamapa")
    private Boolean PortamapaPresentamapa;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_portamapa")
    private Double IdPortamapa;

	public void setPortamapaId(String PortamapaId) {this.PortamapaId = PortamapaId;}
	public String getPortamapaId() {return PortamapaId;}
	public void setPortamapaCorroido(Boolean PortamapaCorroido) {this.PortamapaCorroido = PortamapaCorroido;}
	public Boolean getPortamapaCorroido() {return PortamapaCorroido;}
	public void setPortamapaMalaconexion(Boolean PortamapaMalaconexion) {this.PortamapaMalaconexion = PortamapaMalaconexion;}
	public Boolean getPortamapaMalaconexion() {return PortamapaMalaconexion;}
	public void setPortamapaAveria(Boolean PortamapaAveria) {this.PortamapaAveria = PortamapaAveria;}
	public Boolean getPortamapaAveria() {return PortamapaAveria;}
	public void setPortamapaCostado(String PortamapaCostado) {this.PortamapaCostado = PortamapaCostado;}
	public String getPortamapaCostado() {return PortamapaCostado;}
	public void setPortamapaAncho(Double PortamapaAncho) {this.PortamapaAncho = PortamapaAncho;}
	public Double getPortamapaAncho() {return PortamapaAncho;}
	public void setPortamapaAlto(Double PortamapaAlto) {this.PortamapaAlto = PortamapaAlto;}
	public Double getPortamapaAlto() {return PortamapaAlto;}
	public void setPortamapaPresentamapa(Boolean PortamapaPresentamapa) {this.PortamapaPresentamapa = PortamapaPresentamapa;}
	public Boolean getPortamapaPresentamapa() {return PortamapaPresentamapa;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdPortamapa(Double IdPortamapa) {this.IdPortamapa = IdPortamapa;}
	public Double getIdPortamapa() {return IdPortamapa;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cerramiento")
public class Cerramiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_cerramiento_libricacion_numero")
    private Double CerramientoLibricacionNumero;

    @Column(name = "inv_cerramiento_tipo")
    private String CerramientoTipo;

    @Column(name = "inv_cerramiento_piezafaltante")
    private Boolean CerramientoPiezafaltante;

    @Column(name = "inv_cerramiento_piezafaltante_numero")
    private Double CerramientoPiezafaltanteNumero;

    @Column(name = "inv_cerramiento_desnivel")
    private Boolean CerramientoDesnivel;

    @Column(name = "inv_cerramiento_desnivel_numero")
    private Double CerramientoDesnivelNumero;

    @Column(name = "inv_cerramiento_pasadore")
    private Boolean CerramientoPasadore;

    @Column(name = "inv_cerramiento_pasadorenumero")
    private Double CerramientoPasadorenumero;

    @Column(name = "inv_cerramiento_bisagra")
    private Boolean CerramientoBisagra;

    @Column(name = "inv_cerramiento_bisagranumero")
    private Double CerramientoBisagranumero;

    @Column(name = "inv_cerramiento_corrosion_numero")
    private Double CerramientoCorrosionNumero;

    @Column(name = "inv_cerramiento_corrosion")
    private Boolean CerramientoCorrosion;

    @Column(name = "inv_cerramiento_averia")
    private Boolean CerramientoAveria;

    @Column(name = "inv_cerramiento_id")
    private Double CerramientoId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_cerramiento_lubricacion")
    private Boolean CerramientoLubricacion;

	public void setCerramientoLibricacionNumero(Double CerramientoLibricacionNumero) {this.CerramientoLibricacionNumero = CerramientoLibricacionNumero;}
	public Double getCerramientoLibricacionNumero() {return CerramientoLibricacionNumero;}
	public void setCerramientoTipo(String CerramientoTipo) {this.CerramientoTipo = CerramientoTipo;}
	public String getCerramientoTipo() {return CerramientoTipo;}
	public void setCerramientoPiezafaltante(Boolean CerramientoPiezafaltante) {this.CerramientoPiezafaltante = CerramientoPiezafaltante;}
	public Boolean getCerramientoPiezafaltante() {return CerramientoPiezafaltante;}
	public void setCerramientoPiezafaltanteNumero(Double CerramientoPiezafaltanteNumero) {this.CerramientoPiezafaltanteNumero = CerramientoPiezafaltanteNumero;}
	public Double getCerramientoPiezafaltanteNumero() {return CerramientoPiezafaltanteNumero;}
	public void setCerramientoDesnivel(Boolean CerramientoDesnivel) {this.CerramientoDesnivel = CerramientoDesnivel;}
	public Boolean getCerramientoDesnivel() {return CerramientoDesnivel;}
	public void setCerramientoDesnivelNumero(Double CerramientoDesnivelNumero) {this.CerramientoDesnivelNumero = CerramientoDesnivelNumero;}
	public Double getCerramientoDesnivelNumero() {return CerramientoDesnivelNumero;}
	public void setCerramientoPasadore(Boolean CerramientoPasadore) {this.CerramientoPasadore = CerramientoPasadore;}
	public Boolean getCerramientoPasadore() {return CerramientoPasadore;}
	public void setCerramientoPasadorenumero(Double CerramientoPasadorenumero) {this.CerramientoPasadorenumero = CerramientoPasadorenumero;}
	public Double getCerramientoPasadorenumero() {return CerramientoPasadorenumero;}
	public void setCerramientoBisagra(Boolean CerramientoBisagra) {this.CerramientoBisagra = CerramientoBisagra;}
	public Boolean getCerramientoBisagra() {return CerramientoBisagra;}
	public void setCerramientoBisagranumero(Double CerramientoBisagranumero) {this.CerramientoBisagranumero = CerramientoBisagranumero;}
	public Double getCerramientoBisagranumero() {return CerramientoBisagranumero;}
	public void setCerramientoCorrosionNumero(Double CerramientoCorrosionNumero) {this.CerramientoCorrosionNumero = CerramientoCorrosionNumero;}
	public Double getCerramientoCorrosionNumero() {return CerramientoCorrosionNumero;}
	public void setCerramientoCorrosion(Boolean CerramientoCorrosion) {this.CerramientoCorrosion = CerramientoCorrosion;}
	public Boolean getCerramientoCorrosion() {return CerramientoCorrosion;}
	public void setCerramientoAveria(Boolean CerramientoAveria) {this.CerramientoAveria = CerramientoAveria;}
	public Boolean getCerramientoAveria() {return CerramientoAveria;}
	public void setCerramientoId(Double CerramientoId) {this.CerramientoId = CerramientoId;}
	public Double getCerramientoId() {return CerramientoId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCerramientoLubricacion(Boolean CerramientoLubricacion) {this.CerramientoLubricacion = CerramientoLubricacion;}
	public Boolean getCerramientoLubricacion() {return CerramientoLubricacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
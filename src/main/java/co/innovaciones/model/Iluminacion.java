package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_iluminacion")
public class Iluminacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_iluminacion")
	private Integer id;

    @Column(name = "inv_ilum|acion_sirveparcialporcentaje")
    private Double IluminacionSirveparcialporcentaje;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_iluminacion_id")
    private Double IluminacionId;

    @Column(name = "inv_iluminacion_numero")
    private Double IluminacionNumero;

    @Column(name = "inv_iluminacion_tipo")
    private String IluminacionTipo;

    @Column(name = "inv_iluminacion_costado")
    private String IluminacionCostado;

    @Column(name = "inv_iluminacion_averia")
    private Boolean IluminacionAveria;

    @Column(name = "inv_iluminacion_nosirve")
    private Boolean IluminacionNosirve;

    @Column(name = "inv_iluminacion_sirveparcial")
    private Boolean IluminacionSirveparcial;

    @Column(name = "inv_iluminacion_soporte")
    private Boolean IluminacionSoporte;

    @Column(name = "inv_iluminacion_faltabombilla")
    private Boolean IluminacionFaltabombilla;

    @Column(name = "inv_iluminacion_faltaacrilico")
    private Boolean IluminacionFaltaacrilico;

	public void setIluminacionSirveparcialporcentaje(Double IluminacionSirveparcialporcentaje) {this.IluminacionSirveparcialporcentaje = IluminacionSirveparcialporcentaje;}
	public Double getIluminacionSirveparcialporcentaje() {return IluminacionSirveparcialporcentaje;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIluminacionId(Double IluminacionId) {this.IluminacionId = IluminacionId;}
	public Double getIluminacionId() {return IluminacionId;}
	public void setIluminacionNumero(Double IluminacionNumero) {this.IluminacionNumero = IluminacionNumero;}
	public Double getIluminacionNumero() {return IluminacionNumero;}
	public void setIluminacionTipo(String IluminacionTipo) {this.IluminacionTipo = IluminacionTipo;}
	public String getIluminacionTipo() {return IluminacionTipo;}
	public void setIluminacionCostado(String IluminacionCostado) {this.IluminacionCostado = IluminacionCostado;}
	public String getIluminacionCostado() {return IluminacionCostado;}
	public void setIluminacionAveria(Boolean IluminacionAveria) {this.IluminacionAveria = IluminacionAveria;}
	public Boolean getIluminacionAveria() {return IluminacionAveria;}
	public void setIluminacionNosirve(Boolean IluminacionNosirve) {this.IluminacionNosirve = IluminacionNosirve;}
	public Boolean getIluminacionNosirve() {return IluminacionNosirve;}
	public void setIluminacionSirveparcial(Boolean IluminacionSirveparcial) {this.IluminacionSirveparcial = IluminacionSirveparcial;}
	public Boolean getIluminacionSirveparcial() {return IluminacionSirveparcial;}
	public void setIluminacionSoporte(Boolean IluminacionSoporte) {this.IluminacionSoporte = IluminacionSoporte;}
	public Boolean getIluminacionSoporte() {return IluminacionSoporte;}
	public void setIluminacionFaltabombilla(Boolean IluminacionFaltabombilla) {this.IluminacionFaltabombilla = IluminacionFaltabombilla;}
	public Boolean getIluminacionFaltabombilla() {return IluminacionFaltabombilla;}
	public void setIluminacionFaltaacrilico(Boolean IluminacionFaltaacrilico) {this.IluminacionFaltaacrilico = IluminacionFaltaacrilico;}
	public Boolean getIluminacionFaltaacrilico() {return IluminacionFaltaacrilico;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
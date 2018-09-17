package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_estribo")
public class Estribo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_estribo")
	private Integer id;

    @Column(name = "inv_estribo_perdida")
    private Boolean EstriboPerdida;

    @Column(name = "inv_estribo_pandeo")
    private Boolean EstriboPandeo;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_estribo_id")
    private Double EstriboId;

    @Column(name = "inv_estribo_costado")
    private String EstriboCostado;

    @Column(name = "inv_estribo_largo")
    private Double EstriboLargo;

    @Column(name = "inv_estribo_ancho")
    private Double EstriboAncho;

    @Column(name = "inv_estribo_alfajor")
    private Boolean EstriboAlfajor;

    @Column(name = "inv_estribo_averia")
    private Boolean EstriboAveria;

    @Column(name = "inv_estribo_desgaste")
    private Boolean EstriboDesgaste;

    @Column(name = "inv_estribo_fisurado")
    private Boolean EstriboFisurado;

    @Column(name = "inv_estribo_corrosion")
    private Boolean EstriboCorrosion;

	public void setEstriboPerdida(Boolean EstriboPerdida) {this.EstriboPerdida = EstriboPerdida;}
	public Boolean getEstriboPerdida() {return EstriboPerdida;}
	public void setEstriboPandeo(Boolean EstriboPandeo) {this.EstriboPandeo = EstriboPandeo;}
	public Boolean getEstriboPandeo() {return EstriboPandeo;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setEstriboId(Double EstriboId) {this.EstriboId = EstriboId;}
	public Double getEstriboId() {return EstriboId;}
	public void setEstriboCostado(String EstriboCostado) {this.EstriboCostado = EstriboCostado;}
	public String getEstriboCostado() {return EstriboCostado;}
	public void setEstriboLargo(Double EstriboLargo) {this.EstriboLargo = EstriboLargo;}
	public Double getEstriboLargo() {return EstriboLargo;}
	public void setEstriboAncho(Double EstriboAncho) {this.EstriboAncho = EstriboAncho;}
	public Double getEstriboAncho() {return EstriboAncho;}
	public void setEstriboAlfajor(Boolean EstriboAlfajor) {this.EstriboAlfajor = EstriboAlfajor;}
	public Boolean getEstriboAlfajor() {return EstriboAlfajor;}
	public void setEstriboAveria(Boolean EstriboAveria) {this.EstriboAveria = EstriboAveria;}
	public Boolean getEstriboAveria() {return EstriboAveria;}
	public void setEstriboDesgaste(Boolean EstriboDesgaste) {this.EstriboDesgaste = EstriboDesgaste;}
	public Boolean getEstriboDesgaste() {return EstriboDesgaste;}
	public void setEstriboFisurado(Boolean EstriboFisurado) {this.EstriboFisurado = EstriboFisurado;}
	public Boolean getEstriboFisurado() {return EstriboFisurado;}
	public void setEstriboCorrosion(Boolean EstriboCorrosion) {this.EstriboCorrosion = EstriboCorrosion;}
	public Boolean getEstriboCorrosion() {return EstriboCorrosion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
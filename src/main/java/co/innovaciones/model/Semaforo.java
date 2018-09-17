package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_semaforo")
public class Semaforo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_semaforo_porcentajeaveria")
    private Double SemaforoPorcentajeaveria;

    @Column(name = "inv_semaforo_sinservicio")
    private Boolean SemaforoSinservicio;

    @Column(name = "inv_semaforo_perdida")
    private Boolean SemaforoPerdida;

    @Column(name = "inv_id_semaforo")
    private Integer IdSemaforo;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_semaforo_id")
    private Integer SemaforoId;

    @Column(name = "inv_semaforo_cantidad")
    private Integer SemaforoCantidad;

	public void setSemaforoPorcentajeaveria(Double SemaforoPorcentajeaveria) {this.SemaforoPorcentajeaveria = SemaforoPorcentajeaveria;}
	public Double getSemaforoPorcentajeaveria() {return SemaforoPorcentajeaveria;}
	public void setSemaforoSinservicio(Boolean SemaforoSinservicio) {this.SemaforoSinservicio = SemaforoSinservicio;}
	public Boolean getSemaforoSinservicio() {return SemaforoSinservicio;}
	public void setSemaforoPerdida(Boolean SemaforoPerdida) {this.SemaforoPerdida = SemaforoPerdida;}
	public Boolean getSemaforoPerdida() {return SemaforoPerdida;}
	public void setIdSemaforo(Integer IdSemaforo) {this.IdSemaforo = IdSemaforo;}
	public Integer getIdSemaforo() {return IdSemaforo;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setSemaforoId(Integer SemaforoId) {this.SemaforoId = SemaforoId;}
	public Integer getSemaforoId() {return SemaforoId;}
	public void setSemaforoCantidad(Integer SemaforoCantidad) {this.SemaforoCantidad = SemaforoCantidad;}
	public Integer getSemaforoCantidad() {return SemaforoCantidad;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
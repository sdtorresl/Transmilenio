package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_estacion")
public class Estacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_estacion_codigo")
    private String EstacionCodigo;

    @Column(name = "inv_id_estaciontipo")
    private Double IdEstaciontipo;

    @Column(name = "inv_estacion_distribucion")
    private String EstacionDistribucion;

    @Column(name = "inv_id_troncal")
    private Double IdTroncal;

    @Column(name = "inv_estacion_nombre")
    private String EstacionNombre;

    @Column(name = "inv_estacion_direccion")
    private String EstacionDireccion;

    @Column(name = "inv_estacion_fechentrega")
    private Long EstacionFechentrega;

    @Column(name = "inv_estacion_fechoperacion")
    private Long EstacionFechoperacion;

    @Column(name = "inv_estacion_fase")
    private String EstacionFase;

    @Column(name = "inv_estacion_estado")
    private String EstacionEstado;

	public void setEstacionCodigo(String EstacionCodigo) {this.EstacionCodigo = EstacionCodigo;}
	public String getEstacionCodigo() {return EstacionCodigo;}
	public void setIdEstaciontipo(Double IdEstaciontipo) {this.IdEstaciontipo = IdEstaciontipo;}
	public Double getIdEstaciontipo() {return IdEstaciontipo;}
	public void setEstacionDistribucion(String EstacionDistribucion) {this.EstacionDistribucion = EstacionDistribucion;}
	public String getEstacionDistribucion() {return EstacionDistribucion;}
	public void setIdTroncal(Double IdTroncal) {this.IdTroncal = IdTroncal;}
	public Double getIdTroncal() {return IdTroncal;}
	public void setEstacionNombre(String EstacionNombre) {this.EstacionNombre = EstacionNombre;}
	public String getEstacionNombre() {return EstacionNombre;}
	public void setEstacionDireccion(String EstacionDireccion) {this.EstacionDireccion = EstacionDireccion;}
	public String getEstacionDireccion() {return EstacionDireccion;}
	public void setEstacionFechentrega(Long EstacionFechentrega) {this.EstacionFechentrega = EstacionFechentrega;}
	public Long getEstacionFechentrega() {return EstacionFechentrega;}
	public void setEstacionFechoperacion(Long EstacionFechoperacion) {this.EstacionFechoperacion = EstacionFechoperacion;}
	public Long getEstacionFechoperacion() {return EstacionFechoperacion;}
	public void setEstacionFase(String EstacionFase) {this.EstacionFase = EstacionFase;}
	public String getEstacionFase() {return EstacionFase;}
	public void setEstacionEstado(String EstacionEstado) {this.EstacionEstado = EstacionEstado;}
	public String getEstacionEstado() {return EstacionEstado;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
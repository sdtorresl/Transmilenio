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
    @Column(name = "inv_id_estacion")
    private Integer idEstacion;

    @Column(name = "inv_id_estaciontipo")
    private Double idEstacionTipo;

    @Column(name = "inv_estacion_distribucion")
    private String estacionDistribucion;

    @Column(name = "inv_id_troncal")
    private Double idTroncal;

    @Column(name = "inv_estacion_nombre")
    private String estacionNombre;

    @Column(name = "inv_estacion_direccion")
    private String estacionDireccion;

    @Column(name = "inv_estacion_fechentrega")
    private String estacionFechentrega;

    @Column(name = "inv_estacion_fechoperacion")
    private String estacionFechoperacion;

    @Column(name = "inv_estacion_fase")
    private String estacionFase;

    @Column(name = "inv_estacion_estado")
    private String estacionEstado;

    @Column(name = "inv_estacion_codigo")
    private Double estacionCodigo;

    public Integer getIdEstacion() {return  this.idEstacion;}
    
    void setIdEstacion(Integer idEstacion) {
        this.idEstacion = idEstacion;
    }
    
    public Double getIdEstacionTipo() {return this.idEstacionTipo;}
    
    void setIdEstacionTipo(Double idEstacionTipo) {
        this.idEstacionTipo = idEstacionTipo;
    }
    
    public String getEstacionDistribucion() {return this.estacionDistribucion;}

    void setEstacionDistribucion(String estacionDistribucion) {
        this.estacionDistribucion = estacionDistribucion;
    }

    public Double getIdTroncal() {return this.idTroncal;}

    void setIdTroncal(Double idTroncal) {
        this.idTroncal = idTroncal;
    }

    public String getEstacionNombre() {return this.estacionNombre;}

    void setEstacionNombre(String estacionNombre) {
        this.estacionNombre = estacionNombre;
    }

    public String getEstacionDireccion() {return this.estacionDireccion;}

    void setEstacionDireccion(String estacionDireccion) {
        this.estacionDireccion = estacionDireccion;
    }

    public String getEstacionFechentrega() {return this.estacionFechentrega;}

    void setEstacionFechentrega(String estacionFechentrega) {
        this.estacionFechentrega = estacionFechentrega;
    }

    public String getEstacionFechoperacion() {return this.estacionFechoperacion;}

    void setEstacionFechoperacion(String estacionFechoperacion) {
        this.estacionFechoperacion = estacionFechoperacion;
    }
    public String getEstacionFase() {return this.estacionFase;}

    void setEstacionFase(String estacionFase) {
        this.estacionFase = estacionFase;
    }

    public String getEstacionEstado() {return this.estacionEstado;}

    void setEstacionEstado(String estacionEstado) {
        this.estacionEstado = estacionEstado;
    }

    public Double getEstacionCodigo() {return this.estacionCodigo;}

    void setEstacionCodigo(Double estacionCodigo) {
        this.estacionCodigo = estacionCodigo;
    }

}

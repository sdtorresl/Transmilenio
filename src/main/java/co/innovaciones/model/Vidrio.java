package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_vidrio")
public class Vidrio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_vidrio")
	private Integer id;

    @Column(name = "inv_vidrio_fisurado")
    private Boolean VidrioFisurado;

    @Column(name = "inv_vidrio_ancho")
    private Double VidrioAncho;

    @Column(name = "inv_vidrio_id")
    private Double VidrioId;

    @Column(name = "inv_vidrio_costado")
    private String VidrioCostado;

    @Column(name = "inv_vidrio_alto")
    private Double VidrioAlto;

    @Column(name = "inv_vidrio_tipo")
    private String VidrioTipo;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_vidrio_deterioro")
    private Boolean VidrioDeterioro;

    @Column(name = "inv_vidrio_desaparecido")
    private Boolean VidrioDesaparecido;

    @Column(name = "inv_vidrio_contaminacion")
    private Boolean VidrioContaminacion;

	public void setVidrioFisurado(Boolean VidrioFisurado) {this.VidrioFisurado = VidrioFisurado;}
	public Boolean getVidrioFisurado() {return VidrioFisurado;}
	public void setVidrioAncho(Double VidrioAncho) {this.VidrioAncho = VidrioAncho;}
	public Double getVidrioAncho() {return VidrioAncho;}
	public void setVidrioId(Double VidrioId) {this.VidrioId = VidrioId;}
	public Double getVidrioId() {return VidrioId;}
	public void setVidrioCostado(String VidrioCostado) {this.VidrioCostado = VidrioCostado;}
	public String getVidrioCostado() {return VidrioCostado;}
	public void setVidrioAlto(Double VidrioAlto) {this.VidrioAlto = VidrioAlto;}
	public Double getVidrioAlto() {return VidrioAlto;}
	public void setVidrioTipo(String VidrioTipo) {this.VidrioTipo = VidrioTipo;}
	public String getVidrioTipo() {return VidrioTipo;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setVidrioDeterioro(Boolean VidrioDeterioro) {this.VidrioDeterioro = VidrioDeterioro;}
	public Boolean getVidrioDeterioro() {return VidrioDeterioro;}
	public void setVidrioDesaparecido(Boolean VidrioDesaparecido) {this.VidrioDesaparecido = VidrioDesaparecido;}
	public Boolean getVidrioDesaparecido() {return VidrioDesaparecido;}
	public void setVidrioContaminacion(Boolean VidrioContaminacion) {this.VidrioContaminacion = VidrioContaminacion;}
	public Boolean getVidrioContaminacion() {return VidrioContaminacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
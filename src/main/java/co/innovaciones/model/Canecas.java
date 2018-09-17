package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_canecas")
public class Canecas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_canecas_id")
    private Double CanecasId;

    @Column(name = "inv_canecas_costado")
    private String CanecasCostado;

    @Column(name = "inv_canecas_numerosinservicio")
    private Boolean CanecasNumerosinservicio;

    @Column(name = "inv_canecas_numeroaveriados")
    private Boolean CanecasNumeroaveriados;

    @Column(name = "inv_canecas_total")
    private Double CanecasTotal;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCanecasId(Double CanecasId) {this.CanecasId = CanecasId;}
	public Double getCanecasId() {return CanecasId;}
	public void setCanecasCostado(String CanecasCostado) {this.CanecasCostado = CanecasCostado;}
	public String getCanecasCostado() {return CanecasCostado;}
	public void setCanecasNumerosinservicio(Boolean CanecasNumerosinservicio) {this.CanecasNumerosinservicio = CanecasNumerosinservicio;}
	public Boolean getCanecasNumerosinservicio() {return CanecasNumerosinservicio;}
	public void setCanecasNumeroaveriados(Boolean CanecasNumeroaveriados) {this.CanecasNumeroaveriados = CanecasNumeroaveriados;}
	public Boolean getCanecasNumeroaveriados() {return CanecasNumeroaveriados;}
	public void setCanecasTotal(Double CanecasTotal) {this.CanecasTotal = CanecasTotal;}
	public Double getCanecasTotal() {return CanecasTotal;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
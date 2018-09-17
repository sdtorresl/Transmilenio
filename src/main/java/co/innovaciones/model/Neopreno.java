package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_neopreno")
public class Neopreno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_neopreno_id")
    private Double NeoprenoId;

    @Column(name = "inv_neopreno_desprendido")
    private Boolean NeoprenoDesprendido;

    @Column(name = "inv_neopreno_inexistente")
    private Boolean NeoprenoInexistente;

    @Column(name = "inv_neopreno_fisurado")
    private Boolean NeoprenoFisurado;

    @Column(name = "inv_neopreno_desgaste")
    private Boolean NeoprenoDesgaste;

    @Column(name = "inv_id_neopreno")
    private Double IdNeopreno;

    @Column(name = "inv_neopreno_averia")
    private Boolean NeoprenoAveria;

    @Column(name = "inv_neopreno_cuadrado")
    private Boolean NeoprenoCuadrado;

    @Column(name = "inv_neopreno_semicircular")
    private Boolean NeoprenoSemicircular;

    @Column(name = "inv_neopreno_largo")
    private Double NeoprenoLargo;

    @Column(name = "inv_neopreno_ancho")
    private Double NeoprenoAncho;

    @Column(name = "inv_neopreno_costado")
    private String NeoprenoCostado;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setNeoprenoId(Double NeoprenoId) {this.NeoprenoId = NeoprenoId;}
	public Double getNeoprenoId() {return NeoprenoId;}
	public void setNeoprenoDesprendido(Boolean NeoprenoDesprendido) {this.NeoprenoDesprendido = NeoprenoDesprendido;}
	public Boolean getNeoprenoDesprendido() {return NeoprenoDesprendido;}
	public void setNeoprenoInexistente(Boolean NeoprenoInexistente) {this.NeoprenoInexistente = NeoprenoInexistente;}
	public Boolean getNeoprenoInexistente() {return NeoprenoInexistente;}
	public void setNeoprenoFisurado(Boolean NeoprenoFisurado) {this.NeoprenoFisurado = NeoprenoFisurado;}
	public Boolean getNeoprenoFisurado() {return NeoprenoFisurado;}
	public void setNeoprenoDesgaste(Boolean NeoprenoDesgaste) {this.NeoprenoDesgaste = NeoprenoDesgaste;}
	public Boolean getNeoprenoDesgaste() {return NeoprenoDesgaste;}
	public void setIdNeopreno(Double IdNeopreno) {this.IdNeopreno = IdNeopreno;}
	public Double getIdNeopreno() {return IdNeopreno;}
	public void setNeoprenoAveria(Boolean NeoprenoAveria) {this.NeoprenoAveria = NeoprenoAveria;}
	public Boolean getNeoprenoAveria() {return NeoprenoAveria;}
	public void setNeoprenoCuadrado(Boolean NeoprenoCuadrado) {this.NeoprenoCuadrado = NeoprenoCuadrado;}
	public Boolean getNeoprenoCuadrado() {return NeoprenoCuadrado;}
	public void setNeoprenoSemicircular(Boolean NeoprenoSemicircular) {this.NeoprenoSemicircular = NeoprenoSemicircular;}
	public Boolean getNeoprenoSemicircular() {return NeoprenoSemicircular;}
	public void setNeoprenoLargo(Double NeoprenoLargo) {this.NeoprenoLargo = NeoprenoLargo;}
	public Double getNeoprenoLargo() {return NeoprenoLargo;}
	public void setNeoprenoAncho(Double NeoprenoAncho) {this.NeoprenoAncho = NeoprenoAncho;}
	public Double getNeoprenoAncho() {return NeoprenoAncho;}
	public void setNeoprenoCostado(String NeoprenoCostado) {this.NeoprenoCostado = NeoprenoCostado;}
	public String getNeoprenoCostado() {return NeoprenoCostado;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
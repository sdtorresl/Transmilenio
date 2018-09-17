package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_primerauxilio")
public class Primerauxilio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_primerauxilio_tipo")
    private String PrimerauxilioTipo;

    @Column(name = "inv_primerauxilio_botiquincorrosion")
    private Boolean PrimerauxilioBotiquincorrosion;

    @Column(name = "inv_primerauxilio_botiquinanclaje")
    private Boolean PrimerauxilioBotiquinanclaje;

    @Column(name = "inv_primerauxilio_botiquinvencido")
    private Boolean PrimerauxilioBotiquinvencido;

    @Column(name = "inv_primerauxilio_botiquinfalta")
    private Boolean PrimerauxilioBotiquinfalta;

    @Column(name = "inv_primerauxilio_camillacerradura")
    private Boolean PrimerauxilioCamillacerradura;

    @Column(name = "inv_primerauxilio_camillaanclaje")
    private Boolean PrimerauxilioCamillaanclaje;

    @Column(name = "inv_primerauxilio_camillaaveria")
    private Boolean PrimerauxilioCamillaaveria;

    @Column(name = "inv_primerauxilio_camilladesaparece")
    private Boolean PrimerauxilioCamilladesaparece;

    @Column(name = "inv_primerauxilio_costado")
    private String PrimerauxilioCostado;

    @Column(name = "inv_primerauxilio_id")
    private Double PrimerauxilioId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_primerauxilio")
    private Double IdPrimerauxilio;

	public void setPrimerauxilioTipo(String PrimerauxilioTipo) {this.PrimerauxilioTipo = PrimerauxilioTipo;}
	public String getPrimerauxilioTipo() {return PrimerauxilioTipo;}
	public void setPrimerauxilioBotiquincorrosion(Boolean PrimerauxilioBotiquincorrosion) {this.PrimerauxilioBotiquincorrosion = PrimerauxilioBotiquincorrosion;}
	public Boolean getPrimerauxilioBotiquincorrosion() {return PrimerauxilioBotiquincorrosion;}
	public void setPrimerauxilioBotiquinanclaje(Boolean PrimerauxilioBotiquinanclaje) {this.PrimerauxilioBotiquinanclaje = PrimerauxilioBotiquinanclaje;}
	public Boolean getPrimerauxilioBotiquinanclaje() {return PrimerauxilioBotiquinanclaje;}
	public void setPrimerauxilioBotiquinvencido(Boolean PrimerauxilioBotiquinvencido) {this.PrimerauxilioBotiquinvencido = PrimerauxilioBotiquinvencido;}
	public Boolean getPrimerauxilioBotiquinvencido() {return PrimerauxilioBotiquinvencido;}
	public void setPrimerauxilioBotiquinfalta(Boolean PrimerauxilioBotiquinfalta) {this.PrimerauxilioBotiquinfalta = PrimerauxilioBotiquinfalta;}
	public Boolean getPrimerauxilioBotiquinfalta() {return PrimerauxilioBotiquinfalta;}
	public void setPrimerauxilioCamillacerradura(Boolean PrimerauxilioCamillacerradura) {this.PrimerauxilioCamillacerradura = PrimerauxilioCamillacerradura;}
	public Boolean getPrimerauxilioCamillacerradura() {return PrimerauxilioCamillacerradura;}
	public void setPrimerauxilioCamillaanclaje(Boolean PrimerauxilioCamillaanclaje) {this.PrimerauxilioCamillaanclaje = PrimerauxilioCamillaanclaje;}
	public Boolean getPrimerauxilioCamillaanclaje() {return PrimerauxilioCamillaanclaje;}
	public void setPrimerauxilioCamillaaveria(Boolean PrimerauxilioCamillaaveria) {this.PrimerauxilioCamillaaveria = PrimerauxilioCamillaaveria;}
	public Boolean getPrimerauxilioCamillaaveria() {return PrimerauxilioCamillaaveria;}
	public void setPrimerauxilioCamilladesaparece(Boolean PrimerauxilioCamilladesaparece) {this.PrimerauxilioCamilladesaparece = PrimerauxilioCamilladesaparece;}
	public Boolean getPrimerauxilioCamilladesaparece() {return PrimerauxilioCamilladesaparece;}
	public void setPrimerauxilioCostado(String PrimerauxilioCostado) {this.PrimerauxilioCostado = PrimerauxilioCostado;}
	public String getPrimerauxilioCostado() {return PrimerauxilioCostado;}
	public void setPrimerauxilioId(Double PrimerauxilioId) {this.PrimerauxilioId = PrimerauxilioId;}
	public Double getPrimerauxilioId() {return PrimerauxilioId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdPrimerauxilio(Double IdPrimerauxilio) {this.IdPrimerauxilio = IdPrimerauxilio;}
	public Double getIdPrimerauxilio() {return IdPrimerauxilio;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
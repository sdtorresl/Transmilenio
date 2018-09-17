package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_altavoz")
public class Altavoz implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_altavoz_partesfaltantes")
    private Boolean AltavozPartesfaltantes;

    @Column(name = "inv_altavoz_desaparecido")
    private Boolean AltavozDesaparecido;

    @Column(name = "inv_altavoz_costado")
    private String AltavozCostado;

    @Column(name = "inv_altavoz_averia")
    private Boolean AltavozAveria;

    @Column(name = "inv_altavoz_id")
    private Double AltavozId;

    @Column(name = "inv_altavoz_averiasoporte")
    private Boolean AltavozAveriasoporte;

    @Column(name = "inv_altavoz_contaminacion")
    private Boolean AltavozContaminacion;

    @Column(name = "inv_altavoz_porcentajecontaminacion")
    private Double AltavozPorcentajecontaminacion;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setAltavozPartesfaltantes(Boolean AltavozPartesfaltantes) {this.AltavozPartesfaltantes = AltavozPartesfaltantes;}
	public Boolean getAltavozPartesfaltantes() {return AltavozPartesfaltantes;}
	public void setAltavozDesaparecido(Boolean AltavozDesaparecido) {this.AltavozDesaparecido = AltavozDesaparecido;}
	public Boolean getAltavozDesaparecido() {return AltavozDesaparecido;}
	public void setAltavozCostado(String AltavozCostado) {this.AltavozCostado = AltavozCostado;}
	public String getAltavozCostado() {return AltavozCostado;}
	public void setAltavozAveria(Boolean AltavozAveria) {this.AltavozAveria = AltavozAveria;}
	public Boolean getAltavozAveria() {return AltavozAveria;}
	public void setAltavozId(Double AltavozId) {this.AltavozId = AltavozId;}
	public Double getAltavozId() {return AltavozId;}
	public void setAltavozAveriasoporte(Boolean AltavozAveriasoporte) {this.AltavozAveriasoporte = AltavozAveriasoporte;}
	public Boolean getAltavozAveriasoporte() {return AltavozAveriasoporte;}
	public void setAltavozContaminacion(Boolean AltavozContaminacion) {this.AltavozContaminacion = AltavozContaminacion;}
	public Boolean getAltavozContaminacion() {return AltavozContaminacion;}
	public void setAltavozPorcentajecontaminacion(Double AltavozPorcentajecontaminacion) {this.AltavozPorcentajecontaminacion = AltavozPorcentajecontaminacion;}
	public Double getAltavozPorcentajecontaminacion() {return AltavozPorcentajecontaminacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_banderametal")
public class Banderametal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_banderametal")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_banderametal_id")
    private Double BanderametalId;

    @Column(name = "inv_banderametal_costado")
    private String BanderametalCostado;

    @Column(name = "inv_banderametal_vagonnumero")
    private Double BanderametalVagonnumero;

    @Column(name = "inv_banderametal_numero")
    private Double BanderametalNumero;

    @Column(name = "inv_banderametal_doblado")
    private Boolean BanderametalDoblado;

    @Column(name = "inv_banderametal_roto")
    private Boolean BanderametalRoto;

    @Column(name = "inv_banderametal_desaparecido")
    private Boolean BanderametalDesaparecido;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBanderametalId(Double BanderametalId) {this.BanderametalId = BanderametalId;}
	public Double getBanderametalId() {return BanderametalId;}
	public void setBanderametalCostado(String BanderametalCostado) {this.BanderametalCostado = BanderametalCostado;}
	public String getBanderametalCostado() {return BanderametalCostado;}
	public void setBanderametalVagonnumero(Double BanderametalVagonnumero) {this.BanderametalVagonnumero = BanderametalVagonnumero;}
	public Double getBanderametalVagonnumero() {return BanderametalVagonnumero;}
	public void setBanderametalNumero(Double BanderametalNumero) {this.BanderametalNumero = BanderametalNumero;}
	public Double getBanderametalNumero() {return BanderametalNumero;}
	public void setBanderametalDoblado(Boolean BanderametalDoblado) {this.BanderametalDoblado = BanderametalDoblado;}
	public Boolean getBanderametalDoblado() {return BanderametalDoblado;}
	public void setBanderametalRoto(Boolean BanderametalRoto) {this.BanderametalRoto = BanderametalRoto;}
	public Boolean getBanderametalRoto() {return BanderametalRoto;}
	public void setBanderametalDesaparecido(Boolean BanderametalDesaparecido) {this.BanderametalDesaparecido = BanderametalDesaparecido;}
	public Boolean getBanderametalDesaparecido() {return BanderametalDesaparecido;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
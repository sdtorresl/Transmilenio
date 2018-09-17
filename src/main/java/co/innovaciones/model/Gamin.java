package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_gamin")
public class Gamin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_gamin_id")
    private Double GaminId;

    @Column(name = "inv_gamin_lamina")
    private Boolean GaminLamina;

    @Column(name = "inv_gamin_celosia")
    private Boolean GaminCelosia;

    @Column(name = "inv_gamin_averia")
    private Boolean GaminAveria;

    @Column(name = "inv_gamin_doblado")
    private Boolean GaminDoblado;

    @Column(name = "inv_gamin_roto")
    private Boolean GaminRoto;

    @Column(name = "inv_gamin_extraviado")
    private Boolean GaminExtraviado;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setGaminId(Double GaminId) {this.GaminId = GaminId;}
	public Double getGaminId() {return GaminId;}
	public void setGaminLamina(Boolean GaminLamina) {this.GaminLamina = GaminLamina;}
	public Boolean getGaminLamina() {return GaminLamina;}
	public void setGaminCelosia(Boolean GaminCelosia) {this.GaminCelosia = GaminCelosia;}
	public Boolean getGaminCelosia() {return GaminCelosia;}
	public void setGaminAveria(Boolean GaminAveria) {this.GaminAveria = GaminAveria;}
	public Boolean getGaminAveria() {return GaminAveria;}
	public void setGaminDoblado(Boolean GaminDoblado) {this.GaminDoblado = GaminDoblado;}
	public Boolean getGaminDoblado() {return GaminDoblado;}
	public void setGaminRoto(Boolean GaminRoto) {this.GaminRoto = GaminRoto;}
	public Boolean getGaminRoto() {return GaminRoto;}
	public void setGaminExtraviado(Boolean GaminExtraviado) {this.GaminExtraviado = GaminExtraviado;}
	public Boolean getGaminExtraviado() {return GaminExtraviado;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_toteminfor")
public class Toteminfor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_toteminfor_deformacion")
    private Boolean ToteminforDeformacion;

    @Column(name = "inv_id_totem")
    private Double IdTotem;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_toteminfor_id")
    private Double ToteminforId;

    @Column(name = "inv_toteminfor_longitud")
    private Double ToteminforLongitud;

    @Column(name = "inv_toteminfor_altura")
    private Double ToteminforAltura;

    @Column(name = "inv_toteminfor_averia")
    private Boolean ToteminforAveria;

    @Column(name = "inv_toteminfor_porcentajeaveria")
    private Double ToteminforPorcentajeaveria;

    @Column(name = "inv_toteminfor_corrosion")
    private Boolean ToteminforCorrosion;

    @Column(name = "inv_toteminfor_perdidaestrucmetal")
    private Boolean ToteminforPerdidaestrucmetal;

    @Column(name = "inv_toteminfor_contamivisual")
    private Boolean ToteminforContamivisual;

    @Column(name = "inv_toteminfor_fisuraestrucmetalica")
    private Boolean ToteminforFisuraestrucmetalica;

    @Column(name = "inv_toteminfor_acrilicoausente")
    private Boolean ToteminforAcrilicoausente;

    @Column(name = "inv_toteminfor_ruta_imagen")
    private String ToteminforRutaImagen;

    @Column(name = "inv_toteminfor_imagen")
    private String ToteminforImagen;

	public void setToteminforDeformacion(Boolean ToteminforDeformacion) {this.ToteminforDeformacion = ToteminforDeformacion;}
	public Boolean getToteminforDeformacion() {return ToteminforDeformacion;}
	public void setIdTotem(Double IdTotem) {this.IdTotem = IdTotem;}
	public Double getIdTotem() {return IdTotem;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setToteminforId(Double ToteminforId) {this.ToteminforId = ToteminforId;}
	public Double getToteminforId() {return ToteminforId;}
	public void setToteminforLongitud(Double ToteminforLongitud) {this.ToteminforLongitud = ToteminforLongitud;}
	public Double getToteminforLongitud() {return ToteminforLongitud;}
	public void setToteminforAltura(Double ToteminforAltura) {this.ToteminforAltura = ToteminforAltura;}
	public Double getToteminforAltura() {return ToteminforAltura;}
	public void setToteminforAveria(Boolean ToteminforAveria) {this.ToteminforAveria = ToteminforAveria;}
	public Boolean getToteminforAveria() {return ToteminforAveria;}
	public void setToteminforPorcentajeaveria(Double ToteminforPorcentajeaveria) {this.ToteminforPorcentajeaveria = ToteminforPorcentajeaveria;}
	public Double getToteminforPorcentajeaveria() {return ToteminforPorcentajeaveria;}
	public void setToteminforCorrosion(Boolean ToteminforCorrosion) {this.ToteminforCorrosion = ToteminforCorrosion;}
	public Boolean getToteminforCorrosion() {return ToteminforCorrosion;}
	public void setToteminforPerdidaestrucmetal(Boolean ToteminforPerdidaestrucmetal) {this.ToteminforPerdidaestrucmetal = ToteminforPerdidaestrucmetal;}
	public Boolean getToteminforPerdidaestrucmetal() {return ToteminforPerdidaestrucmetal;}
	public void setToteminforContamivisual(Boolean ToteminforContamivisual) {this.ToteminforContamivisual = ToteminforContamivisual;}
	public Boolean getToteminforContamivisual() {return ToteminforContamivisual;}
	public void setToteminforFisuraestrucmetalica(Boolean ToteminforFisuraestrucmetalica) {this.ToteminforFisuraestrucmetalica = ToteminforFisuraestrucmetalica;}
	public Boolean getToteminforFisuraestrucmetalica() {return ToteminforFisuraestrucmetalica;}
	public void setToteminforAcrilicoausente(Boolean ToteminforAcrilicoausente) {this.ToteminforAcrilicoausente = ToteminforAcrilicoausente;}
	public Boolean getToteminforAcrilicoausente() {return ToteminforAcrilicoausente;}
	public void setToteminforRutaImagen(String ToteminforRutaImagen) {this.ToteminforRutaImagen = ToteminforRutaImagen;}
	public String getToteminforRutaImagen() {return ToteminforRutaImagen;}
	public void setToteminforImagen(String ToteminforImagen) {this.ToteminforImagen = ToteminforImagen;}
	public String getToteminforImagen() {return ToteminforImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
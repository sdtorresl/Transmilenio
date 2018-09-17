package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_columna")
public class Columna implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_columna")
	private Integer id;

    @Column(name = "inv_columna_fisura")
    private Boolean ColumnaFisura;

    @Column(name = "inv_columna_descascaramiento")
    private Boolean ColumnaDescascaramiento;

    @Column(name = "inv_columna_porcentajeaveria")
    private Double ColumnaPorcentajeaveria;

    @Column(name = "inv_columna_tipo")
    private String ColumnaTipo;

    @Column(name = "inv_columna_averia")
    private Boolean ColumnaAveria;

    @Column(name = "inv_columna_perimetro")
    private Double ColumnaPerimetro;

    @Column(name = "inv_columna_id")
    private Double ColumnaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_columna_grieta")
    private Boolean ColumnaGrieta;

    @Column(name = "inv_columna_corrosion")
    private Boolean ColumnaCorrosion;

    @Column(name = "inv_columna_deformacion")
    private Boolean ColumnaDeformacion;

    @Column(name = "inv_columna_perdida")
    private Boolean ColumnaPerdida;

	public void setColumnaFisura(Boolean ColumnaFisura) {this.ColumnaFisura = ColumnaFisura;}
	public Boolean getColumnaFisura() {return ColumnaFisura;}
	public void setColumnaDescascaramiento(Boolean ColumnaDescascaramiento) {this.ColumnaDescascaramiento = ColumnaDescascaramiento;}
	public Boolean getColumnaDescascaramiento() {return ColumnaDescascaramiento;}
	public void setColumnaPorcentajeaveria(Double ColumnaPorcentajeaveria) {this.ColumnaPorcentajeaveria = ColumnaPorcentajeaveria;}
	public Double getColumnaPorcentajeaveria() {return ColumnaPorcentajeaveria;}
	public void setColumnaTipo(String ColumnaTipo) {this.ColumnaTipo = ColumnaTipo;}
	public String getColumnaTipo() {return ColumnaTipo;}
	public void setColumnaAveria(Boolean ColumnaAveria) {this.ColumnaAveria = ColumnaAveria;}
	public Boolean getColumnaAveria() {return ColumnaAveria;}
	public void setColumnaPerimetro(Double ColumnaPerimetro) {this.ColumnaPerimetro = ColumnaPerimetro;}
	public Double getColumnaPerimetro() {return ColumnaPerimetro;}
	public void setColumnaId(Double ColumnaId) {this.ColumnaId = ColumnaId;}
	public Double getColumnaId() {return ColumnaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setColumnaGrieta(Boolean ColumnaGrieta) {this.ColumnaGrieta = ColumnaGrieta;}
	public Boolean getColumnaGrieta() {return ColumnaGrieta;}
	public void setColumnaCorrosion(Boolean ColumnaCorrosion) {this.ColumnaCorrosion = ColumnaCorrosion;}
	public Boolean getColumnaCorrosion() {return ColumnaCorrosion;}
	public void setColumnaDeformacion(Boolean ColumnaDeformacion) {this.ColumnaDeformacion = ColumnaDeformacion;}
	public Boolean getColumnaDeformacion() {return ColumnaDeformacion;}
	public void setColumnaPerdida(Boolean ColumnaPerdida) {this.ColumnaPerdida = ColumnaPerdida;}
	public Boolean getColumnaPerdida() {return ColumnaPerdida;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
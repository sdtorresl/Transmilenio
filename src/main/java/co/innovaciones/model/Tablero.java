package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_tablero")
public class Tablero implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_tablero_ruta_imagen")
    private String TableroRutaImagen;

    @Column(name = "inv_tablero_imagen")
    private String TableroImagen;

    @Column(name = "inv_tablero_tipo")
    private String TableroTipo;

    @Column(name = "inv_tablero_nombre")
    private String TableroNombre;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_tablero_numero")
    private String TableroNumero;

    @Column(name = "inv_tablero_averia")
    private Boolean TableroAveria;

    @Column(name = "inv_tablero_sucio")
    private Boolean TableroSucio;

    @Column(name = "inv_tablero_corrosion")
    private Boolean TableroCorrosion;

    @Column(name = "inv_tablero_faltapintura")
    private Boolean TableroFaltapintura;

    @Column(name = "inv_tablero_sincerradura")
    private Boolean TableroSincerradura;

    @Column(name = "inv_tablero_sintapa")
    private Boolean TableroSintapa;

    @Column(name = "inv_tablero_malanclaje")
    private Boolean TableroMalanclaje;

    @Column(name = "inv_tablero_vidriofisura")
    private Boolean TableroVidriofisura;

    @Column(name = "inv_tablero_vidriofaltante")
    private Boolean TableroVidriofaltante;

    @Column(name = "inv_tablero_cablederretido")
    private Boolean TableroCablederretido;

	public void setTableroRutaImagen(String TableroRutaImagen) {this.TableroRutaImagen = TableroRutaImagen;}
	public String getTableroRutaImagen() {return TableroRutaImagen;}
	public void setTableroImagen(String TableroImagen) {this.TableroImagen = TableroImagen;}
	public String getTableroImagen() {return TableroImagen;}
	public void setTableroTipo(String TableroTipo) {this.TableroTipo = TableroTipo;}
	public String getTableroTipo() {return TableroTipo;}
	public void setTableroNombre(String TableroNombre) {this.TableroNombre = TableroNombre;}
	public String getTableroNombre() {return TableroNombre;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setTableroNumero(String TableroNumero) {this.TableroNumero = TableroNumero;}
	public String getTableroNumero() {return TableroNumero;}
	public void setTableroAveria(Boolean TableroAveria) {this.TableroAveria = TableroAveria;}
	public Boolean getTableroAveria() {return TableroAveria;}
	public void setTableroSucio(Boolean TableroSucio) {this.TableroSucio = TableroSucio;}
	public Boolean getTableroSucio() {return TableroSucio;}
	public void setTableroCorrosion(Boolean TableroCorrosion) {this.TableroCorrosion = TableroCorrosion;}
	public Boolean getTableroCorrosion() {return TableroCorrosion;}
	public void setTableroFaltapintura(Boolean TableroFaltapintura) {this.TableroFaltapintura = TableroFaltapintura;}
	public Boolean getTableroFaltapintura() {return TableroFaltapintura;}
	public void setTableroSincerradura(Boolean TableroSincerradura) {this.TableroSincerradura = TableroSincerradura;}
	public Boolean getTableroSincerradura() {return TableroSincerradura;}
	public void setTableroSintapa(Boolean TableroSintapa) {this.TableroSintapa = TableroSintapa;}
	public Boolean getTableroSintapa() {return TableroSintapa;}
	public void setTableroMalanclaje(Boolean TableroMalanclaje) {this.TableroMalanclaje = TableroMalanclaje;}
	public Boolean getTableroMalanclaje() {return TableroMalanclaje;}
	public void setTableroVidriofisura(Boolean TableroVidriofisura) {this.TableroVidriofisura = TableroVidriofisura;}
	public Boolean getTableroVidriofisura() {return TableroVidriofisura;}
	public void setTableroVidriofaltante(Boolean TableroVidriofaltante) {this.TableroVidriofaltante = TableroVidriofaltante;}
	public Boolean getTableroVidriofaltante() {return TableroVidriofaltante;}
	public void setTableroCablederretido(Boolean TableroCablederretido) {this.TableroCablederretido = TableroCablederretido;}
	public Boolean getTableroCablederretido() {return TableroCablederretido;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
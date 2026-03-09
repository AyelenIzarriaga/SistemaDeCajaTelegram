package sistemacaja.com;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Movimientos")
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "movimiento")
    private movimientoTipo movimiento;

    @Column(nullable = false)
    private LocalDate fechaMovimiento;

    @Column(nullable = false, updatable = false)
    private LocalDate fechaRegistro;

    private BigDecimal monto;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private OrigenMov origen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id")
    @JsonIgnore
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

    private String hashControl;

    public Movimientos() {}

    @PrePersist
    public void prePersist() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDate.now();
        }
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public movimientoTipo getMovimiento() { return movimiento; }
    public void setMovimiento(movimientoTipo movimiento) { this.movimiento = movimiento; }
    public LocalDate getFechaMovimiento() { return fechaMovimiento; }
    public void setFechaMovimiento(LocalDate fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public OrigenMov getOrigen() { return origen; }
    public void setOrigen(OrigenMov origen) { this.origen = origen; }
    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }
    public Almacen getAlmacen() { return almacen; }
    public void setAlmacen(Almacen almacen) { this.almacen = almacen; }
    public String getHashControl() { return hashControl; }
    public void setHashControl(String hashControl) { this.hashControl = hashControl; }
}

package sistemacaja.com;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {

    @Query("SELECT m FROM Movimientos m WHERE m.fechaMovimiento = :fecha AND m.almacen.id = :idAlmacen")
    List<Movimientos> findByFechaMovimiento(@Param("fecha") LocalDate fecha, @Param("idAlmacen") Long idAlmacen);

    @Query("SELECT m FROM Movimientos m WHERE m.fechaMovimiento BETWEEN :desde AND :hasta AND m.almacen.id = :idAlmacen")
    List<Movimientos> findByRango(@Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta, @Param("idAlmacen") Long idAlmacen);

    List<Movimientos> findByAlmacenId(Long idAlmacen);

    Optional<Movimientos> findTopByAlmacenIdOrderByFechaRegistroDesc(Long almacenId);

    boolean existsByHashControl(String hashControl);
    
    Optional<Movimientos> findByHashControl(String hashControl);
}



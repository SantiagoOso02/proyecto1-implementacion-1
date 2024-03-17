package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{

    @Query(value = "SELECT * FROM prestamos", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamos WHERE id=:id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") int id);

    @Modifying
    @Query(value = "INSERT INTO prestamos (id, tipo, estado, monto, interes, numero_cuotas, dia_mes, tipo_doc_cliente, num_doc_cliente) VALUES (prestamo_sequence.nextval, :tipo, :estado, :monto, :interes, :numero_cuotas, :dia_mes, :tipo_doc_cliente, :num_doc_cliente)", nativeQuery = true)
    void insertarPrestamo(@Param("tipo") String tipo, @Param("estado")  String estado, @Param("monto") float monto, @Param("interes")  float interes, @Param("numero_cuotas") Integer numero_cuotas, @Param("dia_mes") Integer dia_mes, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente);

    @Modifying
    @Query(value = "UPDATE prestamos SET tipo = :tipo, estado = :estado, monto = :monto, interes = :interes, numero_cuotas = :numero_cuotas, dia_mes = :dia_mes, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("tipo") String tipo, @Param("estado")  String estado, @Param("monto")  float monto, @Param("interes")  float interes, @Param("numero_cuotas") Integer numero_cuotas, @Param("dia_mes") Integer dia_mes, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente);

    @Modifying
    @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);
    
}

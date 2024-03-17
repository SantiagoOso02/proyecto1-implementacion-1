package uniandes.edu.co.proyecto.repositorio;


import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String>{

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE numero_cuenta=:numero_cuenta", nativeQuery = true)
    Cuenta darCuentaPorId(String numero_cuenta);

    @Modifying
    @Query(value = "INSERT INTO cuentas (numero_cuenta, tipo_cuenta, estado, saldo, fecha_ultima_transaccion, tipo_doc_cliente, num_doc_cliente) VALUES (:numero_cuenta, :tipo_cuenta, :estado, :saldo, :fecha_ultima_transaccion, :tipo_doc_cliente, :num_doc_cliente)", nativeQuery = true)
    void insertarCuenta(@Param("numero_cuenta") String numero_cuenta, @Param("tipo_cuenta") String tipo_cuenta, @Param("estado") String estado, @Param("saldo") float saldo, @Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion , @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente);

    @Modifying
    @Query(value = "UPDATE cuentas SET tipo_cuenta = :tipo_cuenta, estado = :estado, saldo = :saldo, fecha_ultima_transaccion = :fecha_ultima_transaccion, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente WHERE numero_cuenta = :numero_cuenta", nativeQuery = true)
    void actualizarCuenta(@Param("numero_cuenta") String numero_cuenta, @Param("tipo_cuenta") String tipo_cuenta, @Param("estado") String estado, @Param("saldo") float saldo, @Param("fecha_ultima_transaccion") Date fecha_ultima_transaccion , @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente);

    @Modifying
    @Query(value = "DELETE FROM cuentas WHERE numero_cuenta = :numero_cuenta", nativeQuery = true)
    void eliminarCuenta(@Param("numero_cuenta") String numero_cuenta);
    
    
}

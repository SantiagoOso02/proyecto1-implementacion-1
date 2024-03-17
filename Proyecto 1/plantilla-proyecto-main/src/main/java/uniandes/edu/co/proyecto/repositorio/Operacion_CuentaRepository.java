package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta;

public interface Operacion_CuentaRepository extends JpaRepository<Operacion_Cuenta, Integer>{
    
    @Query(value = "SELECT * FROM operaciones_cuenta", nativeQuery = true)
    Collection<Operacion_Cuenta> darOperaciones_Cuentas();

    @Query(value = "SELECT * FROM operaciones_cuenta WHERE ID=:ID", nativeQuery = true)
    Operacion_Cuenta darOperacion_Cuenta(@Param("ID") Integer ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_cuenta(ID, tipo_operacion_cuenta, numero_cuenta, monto, hora, fecha, tipo_doc_empleado, num_doc_empleado, tipo_doc_cliente, num_doc_cliente, punto_atencion) VALUES (operacion_cuenta_sequence.nextval, :tipo_operacion_cuenta, :numero_cuenta, :monto, :hora, :fecha, :tipo_doc_empleado, :num_doc_empleado, :tipo_doc_cliente, :num_doc_cliente, :punto_atencion)", nativeQuery = true)
    void insertarOperacion_Cuenta (@Param("tipo_operacion_cuenta") String tipo_operacion_cuenta, @Param("numero_cuenta") String numero_cuenta, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo_doc_empleado") String tipo_doc_empleado, @Param ("num_doc_empleado") String num_doc_empelado, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente, @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_cuenta SET tipo_operacion_cuenta = :tipo_operacion_cuenta, numero_cuenta = :numero_cuenta, monto = :monto, hora = :hora, fecha = :fecha, tipo_doc_empleado = :tipo_doc_empleado, num_doc_empleado = :num_doc_empleado, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente, punto_atencion = :punto_atencion  WHERE ID=:ID", nativeQuery = true)
    void actualizarOperacion_Cuenta (@Param("ID") Integer ID, @Param("tipo_operacion_cuenta") String tipo_operacion_cuenta, @Param("numero_cuenta") String numero_cuenta, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo_doc_empleado") String tipo_doc_empleado, @Param ("num_doc_empleado") String num_doc_empelado, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente, @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_cuenta WHERE ID=:ID", nativeQuery = true)
    void eliminarOperacion_Cuenta (@Param("ID") Integer ID);

}
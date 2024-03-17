package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;


import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta_Transferencia;


public interface Operacion_Cuenta_TransferenciaRepository extends JpaRepository<Operacion_Cuenta_Transferencia, Integer>{
    
    @Query(value = "SELECT * FROM operaciones_cuenta_transferencia", nativeQuery = true)
    Collection<Operacion_Cuenta_Transferencia> darOperaciones_Cuentas_Transferencias();

    @Query(value = "SELECT * FROM operaciones_cuenta_transferencia WHERE ID=:ID", nativeQuery = true)
    Operacion_Cuenta_Transferencia darOperacion_Cuenta_Transferencia(@Param("ID") Integer ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_cuenta_transferencia(ID, tipo_operacion_cuenta_transferencia, monto, hora, fecha, numero_cuenta_origen, numero_cuenta_destino, tipo_doc_empleado, num_doc_empleado, tipo_doc_cliente, num_doc_cliente, punto_atencion) VALUES (operacion_cuenta_transferencia_sequence.nextval, :tipo_operacion_cuenta_transferencia, :monto, :hora, :fecha, :numero_cuenta_origen, :numero_cuenta_destino, :tipo_doc_empleado, :num_doc_empleado, :tipo_doc_cliente, :num_doc_cliente, :punto_atencion)", nativeQuery = true)
    void insertarOperacion_Cuenta_Transferencia (@Param("tipo_operacion_cuenta_transferencia") String tipo_operacion_cuenta_transferencia, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("numero_cuenta_origen") String numero_cuenta_origen, @Param("numero_cuenta_destino") String numero_cuenta_destino, @Param("tipo_doc_empleado") String tipo_doc_empleado, @Param ("num_doc_empleado") String num_doc_empelado, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente, @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_cuenta_transferencia SET tipo_operacion_cuenta_transferencia = :tipo_operacion_cuenta_transferencia, monto = :monto, hora = :hora, fecha = :fecha, numero_cuenta_origen = :numero_cuenta_origen, numero_cuenta_destino = :numero_cuenta_destino, tipo_doc_empleado = :tipo_doc_empleado, num_doc_empleado = :num_doc_empleado, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente, punto_atencion = :punto_atencion  WHERE ID=:ID", nativeQuery = true)
    void actualizarOperacion_Cuenta_Transferencia (@Param("ID") Integer ID, @Param("tipo_operacion_cuenta_transferencia") String tipo_operacion_cuenta_transferencia, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("numero_cuenta_origen") String numero_cuenta_origen, @Param("numero_cuenta_destino") String numero_cuenta_destino, @Param("tipo_doc_empleado") String tipo_doc_empleado, @Param ("num_doc_empleado") String num_doc_empelado, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente, @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_cuenta_transferencia WHERE ID=:ID", nativeQuery = true)
    void eliminarOperacion_Cuenta_Transferencia (@Param("ID") Integer ID);
}
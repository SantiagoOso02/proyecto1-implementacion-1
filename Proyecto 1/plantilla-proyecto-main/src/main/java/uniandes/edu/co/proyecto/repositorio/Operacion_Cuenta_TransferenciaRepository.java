package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta_Transferencia;
import uniandes.edu.co.proyecto.modelo.Punto_Atencion;

public interface Operacion_Cuenta_TransferenciaRepository extends JpaRepository<Operacion_Cuenta_Transferencia, Integer>{
    
    @Query(value = "SELECT * FROM OPERACIONES_CUENTA_TRANSFERENCIA", nativeQuery = true)
    Collection<Operacion_Cuenta_Transferencia> darOperaciones_Cuentas_Transferencias();

    @Query(value = "SELECT * FROM OPERACIONES_CUENTA_TRANSFERENCIA WHERE ID=:ID", nativeQuery = true)
    Operacion_Cuenta_Transferencia darOperacion_Cuenta_Transferencia(@Param("ID") Integer ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONES_CUENTA_TRANSFERENCIA(ID, monto, hora, fecha, tipo, numero_cuenta_origen, numero_cuenta_destino, tipo_doc_empleado, num_doc_empleado, tipo_doc_cliente, num_doc_cliente, punto_atencion) VALUES (bancos_sequence.nextval, :monto, :hora, :fecha, :tipo, :numero_cuenta_origen, :numero_cuenta_destino, :tipo_doc_empleado, :num_doc_empleado, :tipo_doc_cliente, :num_doc_cliente, :punto_atencion)", nativeQuery = true)
    void insertarOperacion_Cuenta_Transferencia (@Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo") String tipo, @Param("numero_cuenta_origen") Cuenta numero_cuenta_origen, @Param("numero_cuenta_destino") Cuenta numero_cuenta_destino, @Param("tipo_doc_empleado") String string, @Param ("num_doc_empleado") String string2, @Param("tipo_doc_cliente") String string3, @Param("num_doc_cliente") String string4, @Param("punto_atencion") Punto_Atencion punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACIONES_CUENTA_TRANSFERENCIA SET monto = :monto, hora = :hora, fecha = :fecha, tipo = :tipo, numero_cuenta_origen = :numero_cuenta_origen, numero_cuenta_destino = :numero_cuenta_destino, tipo_doc_empleado = :tipo_doc_empleado, num_doc_empleado = :num_doc_empleado, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente, punto_atencion = :punto_atencion  WHERE ID=:ID", nativeQuery = true)
    void actualizarOperacion_Cuenta_Transferencia (@Param("ID") Integer id, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo") String tipo, @Param("numero_cuenta_origen") Cuenta numero_cuenta_origen, @Param("numero_cuenta_destino") Cuenta numero_cuenta_destino, @Param("tipo_doc_empleado") String string, @Param ("num_doc_empleado") String string2, @Param("tipo_doc_cliente") String string3, @Param("num_doc_cliente") String string4, @Param("punto_atencion") Punto_Atencion punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONES_CUENTA_TRANSFERENCIA WHERE ID=:ID", nativeQuery = true)
    void eliminarOperacion_Cuenta_Transferencia (@Param("ID") Integer ID);
}
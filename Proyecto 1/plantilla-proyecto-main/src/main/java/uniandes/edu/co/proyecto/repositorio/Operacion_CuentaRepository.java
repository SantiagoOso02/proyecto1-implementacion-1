package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Operacion_Cuenta;
import uniandes.edu.co.proyecto.modelo.Punto_Atencion;

public interface Operacion_CuentaRepository extends JpaRepository<Operacion_Cuenta, Integer>{
    
    @Query(value = "SELECT * FROM OPERACIONES_CUENTA", nativeQuery = true)
    Collection<Operacion_Cuenta> darOperaciones_Cuentas();

    @Query(value = "SELECT * FROM OPERACIONES_CUENTA WHERE ID=:ID", nativeQuery = true)
    Operacion_Cuenta darOperacion_Cuenta(@Param("ID") String ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONES_CUENTA(ID, monto, hora, fecha, tipo, numero_cuenta, tipo_doc_empleado, num_doc_empleado, tipo_doc_cliente, num_doc_cliente, punto_atencion) VALUES (bancos_sequence.nextval, :monto, :hora, :fecha, :tipo, :numero_cuenta, :tipo_doc_empleado, :num_doc_empleado, :tipo_doc_cliente, :num_doc_cliente, :punto_atencion)", nativeQuery = true)
    void insertarOperacion_Cuenta (@Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo") String tipo, @Param("numero_cuenta") Cuenta numero_cuenta, @Param("tipo_doc_empleado") Empleado tipo_doc_empleado, @Param ("num_doc_empleado") Empleado num_doc_empelado, @Param("tipo_doc_cliente") Cliente tipo_doc_cliente, @Param("num_doc_cliente") Cliente num_doc_cliente, @Param("punto_atencion") Punto_Atencion punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACIONES_CUENTA SET monto = :monto, hora = :hora, fecha = :fecha, tipo = :tipo, numero_cuenta = :numero_cuenta, tipo_doc_empleado = :tipo_doc_empleado, num_doc_empleado = :num_doc_empleado, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente, punto_atencion = :punto_atencion  WHERE ID=:ID", nativeQuery = true)
    void actualizarOperacion_Cuenta (@Param("ID") String ID, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo") String tipo, @Param("numero_cuenta") Cuenta numero_cuenta, @Param("tipo_doc_empleado") Empleado tipo_doc_empleado, @Param ("num_doc_empleado") Empleado num_doc_empelado, @Param("tipo_doc_cliente") Cliente tipo_doc_cliente, @Param("num_doc_cliente") Cliente num_doc_cliente, @Param("punto_atencion") Punto_Atencion punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONES_CUENTA WHERE ID=:ID", nativeQuery = true)
    void eliminarOperacion_Cuenta (@Param("ID") String ID);
}
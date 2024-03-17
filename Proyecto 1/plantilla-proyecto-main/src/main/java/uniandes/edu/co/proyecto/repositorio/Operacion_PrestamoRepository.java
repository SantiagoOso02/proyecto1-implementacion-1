package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Operacion_Prestamo;


public interface Operacion_PrestamoRepository extends JpaRepository<Operacion_Prestamo, Integer>{
    
    @Query(value = "SELECT * FROM operaciones_prestamo", nativeQuery = true)
    Collection<Operacion_Prestamo> darOperaciones_Prestamos();

    @Query(value = "SELECT * FROM operaciones_prestamo WHERE ID=:ID", nativeQuery = true)
    Operacion_Prestamo darOperacion_Prestamo(@Param("ID") Integer ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_prestamo(ID, tipo_operacion_prestamo, prestamo, monto, hora, fecha, tipo_doc_empleado, num_doc_empleado, tipo_doc_cliente, num_doc_cliente, punto_atencion) VALUES (operacion_prestamo_sequence.nextval, :tipo_operacion_prestamo, :prestamo, :monto, :hora, :fecha, :tipo_doc_empleado, :num_doc_empleado, :tipo_doc_cliente, :num_doc_cliente, :punto_atencion)", nativeQuery = true)
    void insertarOperacion_Prestamo (@Param("tipo_operacion_prestamo") String tipo_operacion_prestamo, @Param("prestamo") Integer prestamo, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo_doc_empleado") String tipo_doc_empleado, @Param ("num_doc_empleado") String num_doc_empelado, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente, @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_prestamo SET tipo_operacion_prestamo = :tipo_operacion_prestamo, prestamo = :prestamo, monto = :monto, hora = :hora, fecha = :fecha, tipo_doc_empleado = :tipo_doc_empleado, num_doc_empleado = :num_doc_empleado, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente, punto_atencion = :punto_atencion  WHERE ID=:ID", nativeQuery = true)
    void actualizarOperacion_Prestamo (@Param("ID") Integer ID, @Param("tipo_operacion_prestamo") String tipo_operacion_prestamo, @Param("prestamo") Integer prestamo, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo_doc_empleado") String tipo_doc_empleado, @Param ("num_doc_empleado") String num_doc_empelado, @Param("tipo_doc_cliente") String tipo_doc_cliente, @Param("num_doc_cliente") String num_doc_cliente, @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_prestamo WHERE ID=:ID", nativeQuery = true)
    void eliminarOperacion_Prestamo (@Param("ID") Integer ID);
}
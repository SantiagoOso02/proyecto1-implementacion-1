package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Operacion_Prestamo;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.Punto_Atencion;

public interface Operacion_PrestamoRepository extends JpaRepository<Operacion_Prestamo, Integer>{
    
    @Query(value = "SELECT * FROM OPERACIONES_PRESTAMO", nativeQuery = true)
    Collection<Operacion_Prestamo> darOperaciones_Prestamos();

    @Query(value = "SELECT * FROM OPERACIONES_PRESTAMO WHERE ID=:ID", nativeQuery = true)
    Operacion_Prestamo darOperacion_Prestamo(@Param("ID") String ID);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OPERACIONES_PRESTAMO(ID, monto, hora, fecha, tipo, prestamo, tipo_doc_empleado, num_doc_empleado, tipo_doc_cliente, num_doc_cliente, punto_atencion) VALUES (bancos_sequence.nextval, :monto, :hora, :fecha, :tipo, :prestamo, :tipo_doc_empleado, :num_doc_empleado, :tipo_doc_cliente, :num_doc_cliente, :punto_atencion)", nativeQuery = true)
    void insertarOperacion_Prestamo (@Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo") String tipo, @Param("prestamo") Prestamo prestamo, @Param("tipo_doc_empleado") Empleado tipo_doc_empleado, @Param ("num_doc_empleado") Empleado num_doc_empelado, @Param("tipo_doc_cliente") Cliente tipo_doc_cliente, @Param("num_doc_cliente") Cliente num_doc_cliente, @Param("punto_atencion") Punto_Atencion punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OPERACIONES_PRESTAMO SET monto = :monto, hora = :hora, fecha = :fecha, tipo = :tipo, prestamo = :prestamo, tipo_doc_empleado = :tipo_doc_empleado, num_doc_empleado = :num_doc_empleado, tipo_doc_cliente = :tipo_doc_cliente, num_doc_cliente = :num_doc_cliente, punto_atencion = :punto_atencion  WHERE ID=:ID", nativeQuery = true)
    void actualizarOperacion_Prestamo (@Param("ID") String ID, @Param("monto") float monto, @Param("hora") Date hora, @Param("fecha") Date fecha, @Param("tipo") String tipo, @Param("prestamo") Prestamo prestamo, @Param("tipo_doc_empleado") Empleado tipo_doc_empleado, @Param ("num_doc_empleado") Empleado num_doc_empelado, @Param("tipo_doc_cliente") Cliente tipo_doc_cliente, @Param("num_doc_cliente") Cliente num_doc_cliente, @Param("punto_atencion") Punto_Atencion punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OPERACIONES_PRESTAMO WHERE ID=:ID", nativeQuery = true)
    void eliminarOperacion_Prestamo (@Param("ID") String ID);
}
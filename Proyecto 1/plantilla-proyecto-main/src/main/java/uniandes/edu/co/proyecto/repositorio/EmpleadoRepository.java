package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.EmpleadoPK;


public interface EmpleadoRepository extends JpaRepository<Empleado, EmpleadoPK> {

    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM empleados WHERE tipo_doc = :tipo_doc AND num_doc = :num_doc", nativeQuery = true)
    Empleado darEmpleadoPorId(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (tipo_doc, num_doc, tipo_empleado, nombre, nacionalidad, telefono, login, clave, direccion, punto_atencion, tipo_doc_empleado_creador, num_doc_empleado_creador) VALUES (:tipo_doc, :num_doc, :tipo_empleado, :nombre, :nacionalidad, :telefono, :login, :clave, :direccion, :punto_atencion, :tipo_doc_empleado_creador, :num_doc_empleado_creador)", nativeQuery = true)
    void insertarEmpleado(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc, @Param("tipo_empleado") String tipo_empleado, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Integer direccion,
    @Param("punto_atencion") Integer punto_atencion, @Param("tipo_doc_empleado_creador") String tipo_doc_empleado_creador, @Param("num_doc_empleado_creador") String num_doc_empleado_creador);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET tipo_empleado = :tipo_empleado, nombre = :nombre, nacionalidad = :nacionalidad, telefono = :telefono, login = :login, clave = :clave, direccion = :direccion, punto_atencion = :punto_atencion, tipo_doc_empleado_creador = :tipo_doc_empleado_creador, num_doc_empleado_creador = :num_doc_empleado_creador WHERE tipo_doc = :tipo_doc AND num_doc = :num_doc", nativeQuery = true)
    void actualizarEmpleado(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc, @Param("tipo_empleado") String tipo_empleado, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Integer direccion,
    @Param("punto_atencion") Integer punto_atencion, @Param("tipo_doc_empleado_creador") String tipo_doc_empleado_creador, @Param("num_doc_empleado_creador") String num_doc_empleado_creador);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE tipo_doc = :tipo_doc AND num_doc = :num_doc", nativeQuery = true)
    void eliminarEmpleado(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc);
    
 

    
}
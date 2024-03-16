package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.EmpleadoPK;


public interface EmpleadoRepository extends JpaRepository<Empleado, EmpleadoPK> {

    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM empleados WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    Empleado darEmpleadoPorId(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (tipo_doc, num_doc, nombre, nacionalidad, telefono, login, clave, direccion,  tipo_doc_empleado_creador, num_doc_empleado_creador, tipo_empleado) VALUES (:tipoDoc, :numDoc, :nombre, :nacionalidad, :telefono, :login, :clave, :direccion,  :tipoDocEmpleadoCreador, :numDocEmpleadoCreador, :tipoEmpleado)", nativeQuery = true)
    void insertarEmpleado(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Direccion direccion,
      @Param("tipoDocEmpleadoCreador") String tipoDocEmpleadoCreador, @Param("numDocEmpleadoCreador") String numDocEmpleadoCreador, @Param("tipoEmpleado") String tipoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET nombre = :nombre, nacionalidad = :nacionalidad, telefono = :telefono, login = :login, clave = :clave, direccion = :direccion, tipo_doc_empleado_creador = :tipoDocEmpleadoCreador, num_doc_empleado_creador = :numDocEmpleadoCreador, tipo_empleado = :tipoEmpleado,  WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    void actualizarEmpleado(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Direccion direccion,
     @Param("tipoDocEmpleadoCreador") String tipoDocEmpleadoCreador, @Param("numDocEmpleadoCreador") String numDocEmpleadoCreador, @Param("tipoEmpleado") String tipoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    void eliminarEmpleado(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc);
 

    
}
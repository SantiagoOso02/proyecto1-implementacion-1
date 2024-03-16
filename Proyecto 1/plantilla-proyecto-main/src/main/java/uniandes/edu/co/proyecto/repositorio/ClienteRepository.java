package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.ClientePK;
import uniandes.edu.co.proyecto.modelo.Direccion;



public interface ClienteRepository extends JpaRepository<Cliente, ClientePK>{
   
    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    Cliente darClientePorId(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (tipo_doc, num_doc, nombre, nacionalidad, telefono, login, clave, direccion,  tipo_doc_empleado_creador, num_doc_empleado_creador, tipo_cliente) VALUES (:tipoDoc, :numDoc, :nombre, :nacionalidad, :telefono, :login, :clave, :direccion, :tipoUsuario, :tipoDocEmpleadoCreador, :numDocEmpleadoCreador, :tipoCliente)", nativeQuery = true)
    void insertarCliente(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Direccion direccion, 
     @Param("tipoDocEmpleadoCreador") String tipoDocEmpleadoCreador, @Param("numDocEmpleadoCreador") String numDocEmpleadoCreador, @Param("tipoCliente") String tipoCliente);


    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre = :nombre, nacionalidad = :nacionalidad, telefono = :telefono, login = :login, clave = :clave, direccion = :direccion, tipo_doc_empleado_creador = :tipoDocEmpleadoCreador, num_doc_empleado_creador = :numDocEmpleadoCreador, tipo_cliente = :tipoCliente WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    void actualizarUsuario(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Direccion direccion, @Param("tipoDocEmpleadoCreador") String tipoDocEmpleadoCreador, 
    @Param("numDocEmpleadoCreador") String numDocEmpleadoCreador, @Param("tipoCliente") String tipoCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    void eliminarCliente(@Param("tipoDoc") String tipoDoc, @Param("numDoc") String numDoc);

}
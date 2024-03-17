package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.ClientePK;



public interface ClienteRepository extends JpaRepository<Cliente, ClientePK>{
   
    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE tipo_doc = :tipo_doc AND num_doc = :num_doc", nativeQuery = true)
    Cliente darClientePorId(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (tipo_doc, num_doc, tipo_cliente, nombre, nacionalidad, telefono, login, clave, direccion,  tipo_doc_empleado_creador, num_doc_empleado_creador) VALUES (:tipo_doc, :num_doc,:tipo_cliente, :nombre, :nacionalidad, :telefono, :login, :clave, :direccion, :tipo_doc_empleado_creador, :num_doc_empleado_creador, :tipo_cliente)", nativeQuery = true)
    void insertarCliente(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc, @Param("tipo_cliente") String tipo_cliente, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Integer direccion, 
     @Param("tipo_doc_empleado_creador") String tipo_doc_empleado_creador, @Param("num_doc_empleado_creador") String num_doc_empleado_creador);


    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET tipo_cliente = :tipo_cliente, nombre = :nombre, nacionalidad = :nacionalidad, telefono = :telefono, login = :login, clave = :clave, direccion = :direccion, tipo_doc_empleado_creador = :tipo_doc_empleado_creador, num_doc_empleado_creador = :num_doc_empleado_creador WHERE tipo_doc = :tipo_doc AND num_doc = :num_doc", nativeQuery = true)
    void actualizarCliente(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc, @Param("tipo_cliente") String tipo_cliente, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("telefono") String telefono, @Param("login") String login, @Param("clave") String clave, @Param("direccion") Integer direccion,
        @Param("tipo_doc_empleado_creador") String tipo_doc_empleado_creador, @Param("num_doc_empleado_creador") String num_doc_empleado_creador);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE tipo_doc = :tipo_doc AND num_doc = :num_doc", nativeQuery = true)
    void eliminarCliente(@Param("tipo_doc") String tipo_doc, @Param("num_doc") String num_doc);

}
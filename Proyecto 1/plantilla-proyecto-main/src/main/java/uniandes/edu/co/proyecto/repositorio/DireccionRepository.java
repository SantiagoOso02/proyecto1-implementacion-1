package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Integer>{

    @Query(value= "SELECT * FROM direcciones", nativeQuery = true)
    Collection<Direccion> darDireccion();

    @Query(value="SELECT * FROM direcciones WHERE id =:id", nativeQuery = true)
    Direccion darDireccionPorId(Integer id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO direcciones (id, direccion_fisica, direccion_electronica, ciudad, departamento, codigo_postal) VALUES (direccion_sequence.nextval, :direccion_fisica, :direccion_electronica, :ciudad, :departamento, :codigo_postal)", nativeQuery = true)
    void insertarDireccion(@Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica") String direccion_electronica, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigo_postal") String codigo_postal);
    
    @Modifying
    @Transactional
    @Query(value="UPDATE direcciones SET direccion_fisica = :direccion_fisica, direccion_electronica = :direccion_electronica, ciudad = :ciudad, departamento = :departamento, codigo_postal = :codigo_postal WHERE id = :id", nativeQuery = true)
    void actualizarDireccion(@Param("id") Integer id, @Param("direccion_fisica") String direccion_fisica, @Param("direccion_electronica") String direccion_electronica, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigo_postal") String codigo_postal);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM direcciones WHERE id = :id", nativeQuery = true)
    void eliminarDireccion(@Param("id") Integer id);


}
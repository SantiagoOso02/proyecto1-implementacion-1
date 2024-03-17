package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Oficina;
public interface OficinaRepository extends JpaRepository <Oficina, Integer>{

    @Query(value = "SELECT * FROM oficinas", nativeQuery = true)
    Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM oficinas WHERE id=:id", nativeQuery = true)
    Oficina darOficinaPorId(Integer id);

    @Modifying
    @Query(value = "INSERT INTO oficinas (id, nombre, direccion, numero_puntos_atencion, tipo_doc_gerente, num_doc_gerente) VALUES (oficina_sequence.nextval, :nombre, :direccion, :numero_puntos_atencion, :tipo_doc_gerente, :num_doc_gerente)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre, @Param("direccion") Integer direccion, @Param("numero_puntos_atencion") Integer numero_puntos_atencion, @Param("tipo_doc_gerente") String tipo_doc_gerente, @Param("num_doc_gerente") String num_doc_gerente);
    
    @Modifying
    @Query(value = "UPDATE oficinas SET nombre = :nombre, direccion = :direccion, numero_puntos_atencion = :numero_puntos_atencion, tipo_doc_gerente = :tipo_doc_gerente, num_doc_gerente = :num_doc_gerente WHERE id = :id", nativeQuery = true)
    void actualizarOficina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("direccion") Integer direccion, @Param("numero_puntos_atencion") Integer numero_puntos_atencion, @Param("tipo_doc_gerente") String tipo_doc_gerente, @Param("num_doc_gerente") String num_doc_gerente);

    @Modifying
    @Query(value = "DELETE FROM oficinas WHERE id = :id", nativeQuery = true)
    void eliminarOficina(Integer id);

}

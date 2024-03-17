package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Punto_Atencion;

public interface Punto_AtencionRepository extends JpaRepository<Punto_Atencion, Integer>{
    
    @Query(value = "SELECT * FROM puntos_atencion", nativeQuery = true)
    Collection<Punto_AtencionRepository> darPuntosAtencion();

    @Query(value = "SELECT * FROM puntos_atencion WHERE id = :id", nativeQuery = true)
    Punto_AtencionRepository darPuntoAtencionPorId(Integer id);

    @Modifying
    @Query(value = "INSERT INTO puntos_atencion (id, tipo_punto_atencion, localizacion_geografica, tipo_doc_empleado_creador, num_doc_empleado_creador, oficina) VALUES (punto_atencion_sequence.nextval , :tipo_punto_atencion, :localizacion_geografica, :tipo_doc_empleado_creador, :num_doc_empleado_creador, :oficina)", nativeQuery = true)
    void insertarPuntoAtencion(@Param("tipo_punto_atencion") String tipo_punto_atencion, @Param("localizacion_geografica") String localizacion_geografica, @Param("tipo_doc_empleado_creador") String tipo_doc_empleado_creador, @Param("num_doc_empleado_creador") String num_doc_empleado_creador, @Param("oficina") Integer oficina);

    @Modifying
    @Query(value = "UPDATE puntos_atencion SET tipo_punto_atencion = :tipo_punto_atencion, localizacion_geografica = :localizacion_geografica, tipo_doc_empleado_creador = :tipo_doc_empleado_creador, num_doc_empleado_creador = :num_doc_empleado_creador, oficina = :oficina WHERE id = :id", nativeQuery = true)
    void actualizarPuntoAtencion(@Param("id") Integer id, @Param("tipo_punto_atencion") String tipo_punto_atencion, @Param("localizacion_geografica") String localizacion_geografica, @Param("tipo_doc_empleado_creador") String tipo_doc_empleado_creador, @Param("num_doc_empleado_creador") String num_doc_empleado_creador, @Param("oficina") Integer oficina);

    @Modifying
    @Query(value = "DELETE FROM puntos_atencion WHERE id = :id", nativeQuery = true)
    void eliminarPuntoAtencion(@Param("id") Integer id);


}

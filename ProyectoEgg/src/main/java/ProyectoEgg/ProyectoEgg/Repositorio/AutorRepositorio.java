package ProyectoEgg.ProyectoEgg.Repositorio;


import ProyectoEgg.ProyectoEgg.Entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository <Autor, String> {
    @Modifying
    @Query("UPDATE Autor a SET a.nombre = :nombre WHERE a.id = :id")
    void modificarAutor(@Param("id") String id, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Libro l SET l.alta = true WHERE l.id = :id")
    void darDeAlta(@Param("id") String id);
}

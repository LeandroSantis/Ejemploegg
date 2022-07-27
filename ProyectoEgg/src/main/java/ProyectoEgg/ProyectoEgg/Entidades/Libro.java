package ProyectoEgg.ProyectoEgg.Entidades;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private Long isbn;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Integer ejemplares;

    @Column(nullable = false)
    private Integer ejemplaresPrestados;

    @Column(nullable = false)
    private Integer ejemplaresRestantes;

    @Column(nullable = false)
    private boolean alta;

    @ManyToOne
    private Autor autor;

    @OneToOne
    private Editorial editorial;

    public Libro(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro() {

    }

}

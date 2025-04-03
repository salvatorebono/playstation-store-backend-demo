package it.lipari.accademy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;
    @Column
    private Double price;
    @Column
    private String description;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String img;

/*    @Lob
    @Column(columnDefinition = "TEXT")
    private byte[] imgBackground;*/

}

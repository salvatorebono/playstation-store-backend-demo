package it.lipari.accademy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    private Long id;
    private String title;
    private Double price;
    private String description;
    private String img;
    private String imgBackground;
}

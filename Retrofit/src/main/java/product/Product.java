package product;

import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
public class Product {
    private String categoryTitle;
    private Integer price;
    private Integer id;
    private String title;
    private ArrayList<Product> products;
}

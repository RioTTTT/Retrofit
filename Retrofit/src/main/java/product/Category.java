package product;

import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
public class Category {
    private Integer id;
    private String title;
    private ArrayList<Product> products;
}

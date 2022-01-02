package Base.ProductControllerTests;

import Base.CreateProduct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import utils.PrettyLogin;

import java.util.ArrayList;

public class GetAllProducts extends CreateProduct {
    @DisplayName("Получение списка продуктов")
    @SneakyThrows
    @Test
    void getProduct() {
        Response<ArrayList<Product>> response = productService
                .getProducts()
                .execute();
        softAssertions.assertThat(response.headers()).isEqualTo(200);
    }
}

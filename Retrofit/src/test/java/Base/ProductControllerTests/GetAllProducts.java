package Base.ProductControllerTests;

import Base.PreparingProduct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;

import java.util.ArrayList;

public class GetAllProducts extends PreparingProduct {
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

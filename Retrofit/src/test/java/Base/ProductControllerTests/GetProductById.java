package Base.ProductControllerTests;

import Base.PreparingProduct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import utils.PrettyLogin;


public class GetProductById extends PreparingProduct {
    @DisplayName("Получение продука по id")
    @Test
    @SneakyThrows
    void getProductId() {
        Response<Product> response = productService
                .getProduct(id)
                .execute();

        PrettyLogin.DEFAULT.log(response.body().toString());

        softAssertions.assertThat(response.headers()).isEqualTo(200);
    }
}

package Base.ProductControllerTests;

import Base.CreateProduct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import utils.PrettyLogin;

public class ModifyProduct extends CreateProduct {
    @DisplayName("изменение названия продукта")
    @Test
    @SneakyThrows
    void chanceProduct() {
        Response<Product> response = productService
                .updateProduct(product.withId(id)
                        .withTitle(faker.food().spice()))
                .execute();

        PrettyLogin.DEFAULT.log(response.body().toString());

        softAssertions.assertThat(response.headers())
                .isEqualTo(200);
    }
}

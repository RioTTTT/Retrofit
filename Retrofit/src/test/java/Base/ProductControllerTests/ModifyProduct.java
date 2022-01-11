package Base.ProductControllerTests;

import Base.PreparingProduct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import utils.PrettyLogin;

import static org.hamcrest.MatcherAssert.assertThat;


public class ModifyProduct extends PreparingProduct {
    @DisplayName("изменение названия продукта")
    @Test
    @SneakyThrows
    void changeProduct() {
        Response<Product> response = productService
                .updateProduct(product.withId(id)
                        .withTitle(faker.food().spice()))
                .execute();

        PrettyLogin.DEFAULT.log(response.body().toString());

        softAssertions.assertThat(response.headers())
                .isEqualTo(200);
        assertThat("Updated", response.isSuccessful());
    }
}

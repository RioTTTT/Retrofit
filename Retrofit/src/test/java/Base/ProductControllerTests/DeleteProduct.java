package Base.ProductControllerTests;

import Base.CreateProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import utils.PrettyLogin;

public class DeleteProduct extends CreateProduct {
    @DisplayName("проверка удаления продукта")
    @Test
    void deleteProduct() {
        softAssertions.assertThat(productService.deleteProduct(id)).isEqualTo(200);

    }


}

package Base;

import com.github.javafaker.Faker;
import enums.CategoryType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import product.Product;
import retrofit2.Response;
import utils.PrettyLogin;

import java.io.IOException;

public class PreparingProduct extends BaseTest{

    protected Faker faker = new Faker();
    protected Product product;
    protected Integer id;

    @BeforeEach
    void createProduct() throws IOException {
        product = new Product()
                .withTitle(faker.food().spice())
                .withPrice((int) (Math.random() + 1) * 100)
                .withCategoryTitle(CategoryType.FOOD.getTitle());

        Response<Product> response = productService
                .createProduct(product)
                .execute();

        PrettyLogin.DEFAULT.log(response.body().toString());
        id = response.body().getId();



        softAssertions.assertThat(response.body().getTitle())
                .isEqualTo(product.getTitle());
        softAssertions.assertThat(response.body().getPrice())
                .isEqualTo(product.getPrice());
        softAssertions.assertThat(response.body().getCategoryTitle())
                .isEqualTo(product.getCategoryTitle());
        softAssertions.assertAll();

    }


    @AfterEach
    void deleteProduct() {
        softAssertions.assertThat(productService.deleteProduct(id)).isEqualTo(200);

    }
}

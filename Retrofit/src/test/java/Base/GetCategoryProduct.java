package Base;


import enums.CategoryType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Category;
import retrofit2.Response;
import utils.PrettyLogin;


public class GetCategoryProduct extends BaseTest{
    Integer id;

    @DisplayName("Получение категории продукта по id")
    @Test
    @SneakyThrows
    void getCategoryId() {
        id = CategoryType.FOOD.getId();

        Response<Category> categoryResponse = categoryService.getCategory(id)
                .execute();


        PrettyLogin.DEFAULT.log(categoryResponse.body().toString());
        softAssertions.assertThat(categoryResponse.body().getTitle()).isEqualTo(CategoryType.FOOD.getTitle());
        softAssertions.assertThat(categoryResponse.body().getId()).isEqualTo(id);


    }
}

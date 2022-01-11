package Base;

import ru.batis.db.dao.ProductsMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;
import services.CategoryService;
import services.ProductService;
import utils.Utils;
import utils.UtilsDb;

public class BaseTest {
    protected static Retrofit client;
    protected static ProductService productService;
    protected static CategoryService categoryService;
    protected static SoftAssertions softAssertions;
    protected static ProductsMapper productsMapper;

    @BeforeAll
    static void beforeAll() {

        client = Utils.getRetrofitClient();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
        softAssertions = new SoftAssertions();
        productsMapper = UtilsDb.getProductsMapper();


    }

}

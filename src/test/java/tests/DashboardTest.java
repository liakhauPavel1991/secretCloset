package tests;

import org.junit.jupiter.api.Test;
import steps.MainScreenSteps;
import steps.ProductSteps;
import steps.SellerSteps;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyDiscountAndSellerInfo() {
        MainScreenSteps.selectRandomCity();
        ProductSteps.verifyProductPriceWithDiscount();
        SellerSteps.verifySellerInfo();

//        1	Click on city label

//        2	Type 'Los Angeles' in search field
//        3	Click on search result 'Los Angeles, CA'
//        4	Check 'L.Angeles' is selected as region

//        5	Select first item with discount
//        6	Check that selected item is displaying

//        7	Check that old price, discount and price with discount are correct
//        8	Click on seller
//        9 Check that seller information is correct (name, city)

    }
}

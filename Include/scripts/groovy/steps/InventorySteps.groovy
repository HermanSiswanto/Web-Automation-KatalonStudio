package steps

import pages.InventoryPage
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import io.cucumber.datatable.DataTable

class InventorySteps {

    private InventoryPage inventoryPage = new InventoryPage()

    @Then("user should be redirected to the inventory page")
    void userShouldBeRedirectedToTheInventoryPage() {
        inventoryPage.verifyOnInventoryPage()
    }

    @When("user adds product {string} to the cart")
    void userAddsProductToTheCart(String itemName) {
        inventoryPage.addItemToCartSafely(itemName)
    }

    @When("user adds the following products to the cart:")
    void userAddsTheFollowingProductsToTheCart(DataTable dataTable) {
        List<String> itemNames = dataTable.asList(String)
        inventoryPage.addMultipleItemsToCart(itemNames)
    }

    @When("user removes product {string} from the inventory page")
    void userRemovesProductFromTheInventoryPage(String itemName) {
        inventoryPage.removeItemFromCart(itemName)
    }

    @Then("user should see product {string} details with price {string} and description {string}")
    void userShouldSeeProductDetailsWithPriceAndDescription(String itemName, String expectedPrice, String expectedDesc) {
        inventoryPage.verifyProductDetails(itemName, expectedPrice, expectedDesc)
    }

    @Then("user verifies product image for {string} is displayed correctly")
    void userVerifiesProductImageForIsDisplayedCorrectly(String itemName) {
        inventoryPage.verifyProductImageNotBroken(itemName)
    }

    @When("user sorts the products by {string}")
    void userSortsTheProductsBy(String sortOption) {
        inventoryPage.selectSortOption(sortOption)
    }

    @Then("user should see products sorted by {string}")
    void userShouldSeeProductsSortedBy(String expectedSorting) {
        inventoryPage.verifyProductsSortedBy(expectedSorting)
    }

    @Then("user should see total {int} products in the catalog")
    void userShouldSeeTotalProductsInTheCatalog(int expectedCount) {
        inventoryPage.verifyTotalProductsCount(expectedCount)
    }
}

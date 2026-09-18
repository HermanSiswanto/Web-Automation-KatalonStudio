package steps

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import org.testng.Assert

import pages.CartPage
import pages.CheckoutInformationPage
import pages.InventoryPage

class CartSteps {

    CartPage cartPage = new CartPage()
    InventoryPage inventoryPage = new InventoryPage()
    CheckoutInformationPage checkoutPage = new CheckoutInformationPage()

    private TestObject lblCartBadge =
            findTestObject('Object Repository/Common/icn_CartBadge')


    // --- Navigation ---

    @When("user clicks on shopping cart icon")
    void userClicksOnShoppingCartIcon() {
        inventoryPage.clickCartButton()
    }

    @Then("user should be on the cart page")
    void userShouldBeOnTheCartPage() {
        cartPage.verifyCartPageLoaded()
    }

    @When("user clicks the Continue Shopping button")
    void userClicksTheContinueShoppingButton() {
        cartPage.clickContinueShopping()
    }

    @Then("user should be redirected back to the inventory page")
    void userShouldBeRedirectedBackToInventoryPage() {
        inventoryPage.verifyOnInventoryPage()
    }

    @When("user clicks the Checkout button")
    void userClicksTheCheckoutButton() {
        cartPage.clickCheckout()
    }

    @Then("user should be directed to the Checkout Information Page")
    void userShouldBeDirectedToCheckoutInformationPage() {
        checkoutPage.verifyOnCheckoutPage()
    }


    // --- Cart Actions ---


    @When("user removes {string} from the cart page")
    void userRemovesProductFromCartPage(String itemName) {
        cartPage.removeProductFromCart(itemName)
    }


    // --- Verification --- 


    @Then("the cart page should be empty")
    void theCartPageShouldBeEmpty() {
        cartPage.verifyCartIsEmpty()
    }

    @Then("user should see product name {string} and price {string} in the cart")
    void userShouldSeeProductNameAndPrice(String itemName, String expectedPrice) {
        cartPage.verifyProductDetailsInCart(itemName, expectedPrice)
    }

    @Then("the cart should contain {int} item")
    @Then("the cart should contain {int} items")
    void theCartShouldContainItems(int expectedCount) {
        cartPage.verifyCartItemCount(expectedCount)
    }

    @Then("cart badge should display {string}")
    void cartBadgeShouldDisplay(String expectedBadge) {

        WebUI.waitForElementVisible(lblCartBadge, 5)

        String actualBadge = WebUI.getText(lblCartBadge)

        Assert.assertEquals(
                actualBadge,
                expectedBadge,
                "Cart badge count does not match!"
        )
    }

    @Then("cart badge should not be visible")
	void cartBadgeShouldNotBeVisible() {
	
	    boolean isVisible =
	        !WebUI.findWebElements(lblCartBadge, 1).isEmpty()
	
	    Assert.assertFalse(
	            isVisible,
	            "Cart badge should not be visible."
	    )
	}
		
}
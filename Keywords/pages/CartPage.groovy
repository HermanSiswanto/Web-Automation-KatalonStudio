package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.testng.Assert

class CartPage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5

    // --- Object Locators ---

    private TestObject lblTitle = findTestObject("Object Repository/Cart/lbl_Title")
    private TestObject btnContinueShopping = findTestObject("Object Repository/Cart/btn_ContinueShopping")
    private TestObject btnCheckout = findTestObject("Object Repository/Cart/btn_Checkout")
    private TestObject cartItems = findTestObject("Object Repository/Cart/lbl_CartItem_List")

	// --- Private Internal Helper Methods ---
	
    private TestObject getDynamicObject(String objectPath, String itemName) {
        return findTestObject(objectPath, [('item_name'): itemName])
    }

    private String toItemSlug(String itemName) {
        return itemName
                .toLowerCase()
                .replaceAll('[^a-z0-9]+', '-')
                .replaceAll('^-|-$', '')
    }

    // --- Verification ---

    @Keyword
    void verifyCartPageLoaded() {

        WebUI.waitForElementVisible(lblTitle, DEFAULT_TIMEOUT_SECONDS)

        Assert.assertEquals(
                WebUI.getText(lblTitle),
                "Your Cart",
                "Cart page title does not match."
        )
    }

    @Keyword
    void verifyProductDetailsInCart(String itemName, String expectedPrice) {

        TestObject lblName = getDynamicObject('Object Repository/Cart/lbl_ProductName_Dynamic', itemName)
        TestObject lblPrice = getDynamicObject('Object Repository/Cart/lbl_ProductPrice_Dynamic', itemName)

        WebUI.waitForElementVisible(lblName, DEFAULT_TIMEOUT_SECONDS)
        WebUI.waitForElementVisible(lblPrice, DEFAULT_TIMEOUT_SECONDS)

        Assert.assertEquals(
                WebUI.getText(lblName),
                itemName,
                "Product name mismatch."
        )

        Assert.assertEquals(
                WebUI.getText(lblPrice),
                expectedPrice,
                "Product price mismatch."
        )
    }

    @Keyword
    void verifyCartItemCount(int expectedCount) {

        List<WebElement> items =
                WebUI.findWebElements(cartItems, DEFAULT_TIMEOUT_SECONDS)

        Assert.assertEquals(
                items.size(),
                expectedCount,
                "Cart item count mismatch."
        )
    }

    @Keyword
    void verifyCartIsEmpty() {

        List<WebElement> items =
                WebUI.findWebElements(cartItems, DEFAULT_TIMEOUT_SECONDS)

        Assert.assertTrue(
                items.isEmpty(),
                "Cart should be empty."
        )
    }

    // --- Actions --- 

    @Keyword
    void removeProductFromCart(String itemName) {

        TestObject btnRemove = getDynamicObject(
                'Object Repository/Cart/btn_Remove_Dynamic',
                toItemSlug(itemName))

        WebUI.waitForElementClickable(btnRemove, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnRemove)
    }

    @Keyword
    void clickContinueShopping() {

        WebUI.waitForElementClickable(btnContinueShopping, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnContinueShopping)
    }

    @Keyword
    void clickCheckout() {

        WebUI.waitForElementClickable(btnCheckout, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnCheckout)
    }
}

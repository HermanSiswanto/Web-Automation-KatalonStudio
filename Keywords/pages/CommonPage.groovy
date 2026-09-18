package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.testng.Assert

class CommonPage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5

    @Keyword
    void clickCart() {

        TestObject btnCart = findTestObject("Common/btn_Cart")

        WebUI.waitForElementClickable(btnCart, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnCart)
    }

    @Keyword
    void clickMenu() {

        TestObject btnMenu = findTestObject("Common/btnMenu")

        WebUI.waitForElementClickable(btnMenu, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnMenu)
    }

    @Keyword
    void verifyCartBadge(String expectedCount) {

        TestObject lblCartBadge = findTestObject("Common/icn_CartBadge")

        WebUI.waitForElementVisible(lblCartBadge, DEFAULT_TIMEOUT_SECONDS)
        WebUI.verifyElementText(lblCartBadge, expectedCount)
    }

    @Keyword
	boolean isCartBadgeDisplayed() {
	
	    TestObject lblCartBadge = findTestObject("Common/icn_CartBadge")
	
	    return !WebUI.findWebElements(lblCartBadge, DEFAULT_TIMEOUT_SECONDS).isEmpty()
	}

    @Keyword
	void verifyCartBadgeNotDisplayed() {
	
	    Assert.assertFalse(
	        isCartBadgeDisplayed(),
	        "Cart badge should not be visible."
	    )
	}

}
package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.testng.Assert

class CheckoutOverviewPage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5
    private static final String PAGE_TITLE = 'Checkout: Overview'

    // --- Object Locators ---
    private TestObject lblTitle = findTestObject('Object Repository/CheckoutOverview/lbl_Title')
    private TestObject lblItemTotal = findTestObject('Object Repository/CheckoutOverview/lbl_ItemTotal')
    private TestObject lblTax = findTestObject('Object Repository/CheckoutOverview/lbl_Tax')
    private TestObject lblTotal = findTestObject('Object Repository/CheckoutOverview/lbl_Total')
    private TestObject btnCancel = findTestObject('Object Repository/CheckoutOverview/btn_Cancel')
    private TestObject btnFinish = findTestObject('Object Repository/CheckoutOverview/btn_Finish')

    // --- Verifications ---
    @Keyword
    void verifyOnCheckoutOverviewPage() {
        WebUI.waitForElementVisible(lblTitle, DEFAULT_TIMEOUT_SECONDS)
        Assert.assertEquals(WebUI.getText(lblTitle), PAGE_TITLE,
                'User is not on the Checkout Overview page.')
    }

    @Keyword
    void verifyOrderTotals(String expectedItemTotal, String expectedTax, String expectedTotal) {
        WebUI.waitForElementVisible(lblItemTotal, DEFAULT_TIMEOUT_SECONDS)
        WebUI.waitForElementVisible(lblTax, DEFAULT_TIMEOUT_SECONDS)
        WebUI.waitForElementVisible(lblTotal, DEFAULT_TIMEOUT_SECONDS)

        Assert.assertEquals(WebUI.getText(lblItemTotal), "Item total: ${expectedItemTotal}",
                'Checkout item total does not match.')
        Assert.assertEquals(WebUI.getText(lblTax), "Tax: ${expectedTax}",
                'Checkout tax does not match.')
        Assert.assertEquals(WebUI.getText(lblTotal), "Total: ${expectedTotal}",
                'Checkout total does not match.')
    }

    // --- Actions ---
    @Keyword
    void clickCancel() {
        WebUI.waitForElementClickable(btnCancel, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnCancel)
    }

    @Keyword
    void clickFinish() {
        WebUI.waitForElementClickable(btnFinish, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnFinish)
    }
}

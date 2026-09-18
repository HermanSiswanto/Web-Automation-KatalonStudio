package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.testng.Assert

class CheckoutCompletePage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5
    private static final String PAGE_TITLE = 'Checkout: Complete!'

    // --- Object Locators ---
    private TestObject lblTitle = findTestObject('Object Repository/CheckoutComplete/lbl_Title')
    private TestObject lblCompleteHeader = findTestObject('Object Repository/CheckoutComplete/lbl_CompleteHeader')
    private TestObject btnBackHome = findTestObject('Object Repository/CheckoutComplete/btn_BackHome')

    // --- Verifications ---
    @Keyword
    void verifyOnCheckoutCompletePage() {
        WebUI.waitForElementVisible(lblTitle, DEFAULT_TIMEOUT_SECONDS)
        Assert.assertEquals(WebUI.getText(lblTitle), PAGE_TITLE,
                'User is not on the Checkout Complete page.')
    }

    @Keyword
    void verifyOrderConfirmation(String expectedMessage) {
        WebUI.waitForElementVisible(lblCompleteHeader, DEFAULT_TIMEOUT_SECONDS)
        Assert.assertEquals(WebUI.getText(lblCompleteHeader), expectedMessage,
                'Order confirmation message does not match.')
    }

    // --- Actions ---
    @Keyword
    void clickBackHome() {
        WebUI.waitForElementClickable(btnBackHome, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnBackHome)
    }
}

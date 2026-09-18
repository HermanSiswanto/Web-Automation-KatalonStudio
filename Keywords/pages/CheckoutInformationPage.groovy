package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.testng.Assert

class CheckoutInformationPage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5
    private static final String PAGE_TITLE = 'Checkout: Your Information'
    private static final String CHECKOUT_OVERVIEW_PATH = '/checkout-step-two.html'

    // --- Object Locators ---
    private TestObject lblTitle = findTestObject('Object Repository/Checkout/lbl_Title')
    private TestObject txtFirstName = findTestObject('Object Repository/Checkout/txt_FirstName')
    private TestObject txtLastName = findTestObject('Object Repository/Checkout/txt_LastName')
    private TestObject txtPostalCode = findTestObject('Object Repository/Checkout/txt_PostalCode')
    private TestObject btnContinue = findTestObject('Object Repository/Checkout/btn_Continue')
    private TestObject btnCancel = findTestObject('Object Repository/Checkout/btn_Cancel')
    private TestObject lblErrorMessage = findTestObject('Object Repository/Checkout/lbl_ErrorMessage')

    // --- Verifications ---
    @Keyword
    void verifyOnCheckoutPage() {
        WebUI.waitForElementVisible(lblTitle, DEFAULT_TIMEOUT_SECONDS)
        Assert.assertEquals(WebUI.getText(lblTitle), PAGE_TITLE,
                'User is not on the Checkout Information page.')
    }

    @Keyword
    void verifyProceedsToCheckoutOverview() {
        WebUI.waitForPageLoad(DEFAULT_TIMEOUT_SECONDS)
        Assert.assertTrue(WebUI.getUrl().endsWith(CHECKOUT_OVERVIEW_PATH),
                "Expected checkout overview URL, but was '${WebUI.getUrl()}'.")
    }

    @Keyword
    void verifyErrorMessage(String expectedMessage) {
        WebUI.waitForElementVisible(lblErrorMessage, DEFAULT_TIMEOUT_SECONDS)
        Assert.assertEquals(WebUI.getText(lblErrorMessage), expectedMessage,
                'Checkout error message does not match.')
    }

    // --- Actions ---
    @Keyword
    void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        WebUI.waitForElementVisible(txtFirstName, DEFAULT_TIMEOUT_SECONDS)
        WebUI.setText(txtFirstName, firstName)
        WebUI.setText(txtLastName, lastName)
        WebUI.setText(txtPostalCode, postalCode)
    }

    @Keyword
    void clickContinue() {
        WebUI.waitForElementClickable(btnContinue, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnContinue)
    }

    @Keyword
    void clickCancel() {
        WebUI.waitForElementClickable(btnCancel, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnCancel)
    }
}

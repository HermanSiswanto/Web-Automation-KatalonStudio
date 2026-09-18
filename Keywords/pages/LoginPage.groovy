package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import org.testng.Assert

class LoginPage {

    private static final int DEFAULT_TIMEOUT_SECONDS = 5

    private TestObject txtUsername = findTestObject('Login/txt_Username')
    private TestObject txtPassword = findTestObject('Login/txt_Password')
    private TestObject btnLogin = findTestObject('Login/btn_Login')
    private TestObject lblErrorMessage = findTestObject('Login/lbl_ErrorMessage')

    @Keyword
    void login(String username, String password) {
        WebUI.waitForElementVisible(txtUsername, DEFAULT_TIMEOUT_SECONDS)
        WebUI.setText(txtUsername, username)
        WebUI.setText(txtPassword, password)

        WebUI.waitForElementClickable(btnLogin, DEFAULT_TIMEOUT_SECONDS)
        WebUI.click(btnLogin)
    }

    @Keyword
    void loginWithGlobalCredentials() {
        login(GlobalVariable.username, GlobalVariable.password)
    }

    @Keyword
    void verifyErrorMessage(String expectedMessage) {
        WebUI.waitForElementVisible(lblErrorMessage, DEFAULT_TIMEOUT_SECONDS)
        String actualMessage = WebUI.getText(lblErrorMessage)
        Assert.assertEquals(actualMessage, expectedMessage, "Login error message does not match!")
    }

    @Keyword
    String getErrorMessage() {
        WebUI.waitForElementVisible(lblErrorMessage, DEFAULT_TIMEOUT_SECONDS)
        return WebUI.getText(lblErrorMessage)
    }

    @Keyword
    boolean isLoginSuccessful() {
        return WebUI.waitForElementVisible(findTestObject('Inventory/lbl_Title'), DEFAULT_TIMEOUT_SECONDS)
    }
}
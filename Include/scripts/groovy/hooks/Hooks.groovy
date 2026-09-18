package hooks

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import io.cucumber.java.After
import io.cucumber.java.Before

class Hooks {

    @Before
    void setUp() {
        WebUI.openBrowser('')
        WebUI.maximizeWindow()
        WebUI.navigateToUrl(GlobalVariable.baseUrl)
        WebUI.waitForPageLoad(10)
    }

    @After
    void tearDown() {
        WebUI.closeBrowser()
    }
}
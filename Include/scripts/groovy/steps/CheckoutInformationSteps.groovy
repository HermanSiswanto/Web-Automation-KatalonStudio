package steps

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.CheckoutInformationPage

class CheckoutInformationSteps {

    private CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage()

    @When('user submits checkout information with first name {string}, last name {string}, and postal code {string}')
    void userSubmitsCheckoutInformation(String firstName, String lastName, String postalCode) {
        checkoutInformationPage.fillCheckoutInformation(firstName, lastName, postalCode)
        checkoutInformationPage.clickContinue()
    }

    @Then('user should be redirected to the checkout overview page')
    void userShouldBeRedirectedToCheckoutOverviewPage() {
        checkoutInformationPage.verifyProceedsToCheckoutOverview()
    }

    @Then('checkout information should show error message {string}')
    void checkoutInformationShouldShowErrorMessage(String expectedMessage) {
        checkoutInformationPage.verifyErrorMessage(expectedMessage)
    }
}

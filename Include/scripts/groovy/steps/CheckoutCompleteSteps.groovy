package steps

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.CheckoutCompletePage

class CheckoutCompleteSteps {

    private CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage()

    @Then('user should be on the Checkout Complete page')
    void userShouldBeOnCheckoutCompletePage() {
        checkoutCompletePage.verifyOnCheckoutCompletePage()
    }

    @Then('order confirmation should be {string}')
    void orderConfirmationShouldBe(String expectedMessage) {
        checkoutCompletePage.verifyOrderConfirmation(expectedMessage)
    }

    @When('user clicks the Back Home button')
    void userClicksBackHomeButton() {
        checkoutCompletePage.clickBackHome()
    }
}

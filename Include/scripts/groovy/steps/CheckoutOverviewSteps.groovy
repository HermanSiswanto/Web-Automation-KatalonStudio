package steps

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.CheckoutOverviewPage

class CheckoutOverviewSteps {

    private CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage()

    @Then('user should be on the Checkout Overview page')
    void userShouldBeOnCheckoutOverviewPage() {
        checkoutOverviewPage.verifyOnCheckoutOverviewPage()
    }

    @Then('checkout overview should show item total {string}, tax {string}, and total {string}')
    void checkoutOverviewShouldShowOrderTotals(String itemTotal, String tax, String total) {
        checkoutOverviewPage.verifyOrderTotals(itemTotal, tax, total)
    }

    @When('user cancels checkout from the overview page')
    void userCancelsCheckoutFromOverviewPage() {
        checkoutOverviewPage.clickCancel()
    }

    @When('user finishes checkout from the overview page')
    void userFinishesCheckoutFromOverviewPage() {
        checkoutOverviewPage.clickFinish()
    }
}

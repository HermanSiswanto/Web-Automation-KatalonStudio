package steps

import pages.LoginPage
import pages.InventoryPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then

class LoginSteps {

    private LoginPage loginPage = new LoginPage()
    private InventoryPage inventoryPage = new InventoryPage()

    // --- Pre-condition for other Features (Inventory, Cart, Checkout, etc) ---
    @Given("user is logged in with valid credentials")
    void userIsLoggedInWithValidCredentials() {
        loginPage.loginWithGlobalCredentials()
        inventoryPage.verifyOnInventoryPage()
    }

    // --- Step only for Login.feature --- 
    @Given("user is on the login page")
    void userIsOnTheLoginPage() {
    }

    @When("user logs in with username {string} and password {string}")
    void userLogsInWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password)
    }

    @Then("login should fail with error message {string}")
    void loginShouldFailWithErrorMessage(String expectedMessage) {
        loginPage.verifyErrorMessage(expectedMessage)
    }
}
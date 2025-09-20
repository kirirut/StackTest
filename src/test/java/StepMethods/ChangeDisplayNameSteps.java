package StepMethods;

import PageObjects.LandingPO;
import PageObjects.LoginPO;
import PageObjects.ProfilePO;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;

public class ChangeDisplayNameSteps {
    private Dotenv dotenv;
    LandingPO landingPO;
    LoginPO loginPO;
    ProfilePO profilePO;

    @Before
    public void setup() {
        // Загружаем переменные из .env
        dotenv = Dotenv.configure().ignoreIfMissing().load();
    }

    @Given("I'm on Stack Overflow web page")
    public void iMOnStackOverflowWebPage() {
        landingPO = new LandingPO();
        landingPO.openStackOverFlowUrl();
    }

    @And("I click login button")
    public void iClickLoginButton() {
        landingPO.clickLoginBtn();
    }

    @And("I login using my {string} and {string}")
    public void iLoginUsingMyAnd(String email, String password) {

        String testEmail = dotenv.get("TEST_EMAIL");
        String testPassword = dotenv.get("TEST_PASSWORD");

        loginPO = new LoginPO();
        loginPO.enterEmail(testEmail);
        loginPO.enterPassword(testPassword);
        loginPO.clickLoginBtn();
    }

    @And("I open my profile")
    public void iOpenMyProfile() {
        profilePO = new ProfilePO();
        profilePO.openUserProfile();
    }

    @And("I click edit profile")
    public void iClickEditProfile() {
        profilePO.editMyProfile();
    }

    @When("I change my display name to {string}")
    public void iChangeMyDisplayNameTo(String display_name) {

        String testDisplayName = dotenv.get("TEST_DISPLAY_NAME");
        profilePO.changeDisplayName(testDisplayName);
    }

    @And("I save changes")
    public void iSaveChanges() {
        profilePO.saveChanges();
    }

    @Then("Changes should be saved successfully")
    public void changesShouldBeSavedSuccessfully() {

    }
}
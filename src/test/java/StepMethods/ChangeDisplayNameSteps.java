package StepMethods;

import PageObjects.LandingPO;
import PageObjects.LoginPO;
import PageObjects.ProfilePO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeDisplayNameSteps {
    LandingPO landingPO;
    LoginPO loginPO;
    ProfilePO profilePO;

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
        loginPO = new LoginPO();
        loginPO.enterEmail(email);
        loginPO.enterPassword(password);
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
        profilePO.changeDisplayName(display_name);
    }

    @And("I save changes")
    public void iSaveChanges() {
        profilePO.saveChanges();
    }

    @Then("Changes should be saved successfully")
    public void changesShouldBeSavedSuccessfully() {
    }
}
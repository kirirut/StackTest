package PageObjects;

import StepMethods.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePO extends Driver {
    public ProfilePO() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='user-profile-button']")
    public WebElement userProfileButton;

    @FindBy(xpath = "//a[contains(@class, 's-btn__icon') and contains(@class, 's-btn__sm')]")
    public WebElement editProfileBtn;

    @FindBy(xpath = "//input[@id='displayName']")
    public WebElement displayNameFld;

    @FindBy(xpath = "//button[contains(@class, 'js-save-button') and contains(@class, 's-btn__filled')]")
    public WebElement saveChangesBtn;


    public void openUserProfile() {
        wait.until(ExpectedConditions.visibilityOf(userProfileButton)).click();
    }
    public void editMyProfile(){
        wait.until(ExpectedConditions.visibilityOf(editProfileBtn)).click();
    }

    public void changeDisplayName(String argDisplay_name){
        wait.until(ExpectedConditions.visibilityOf(displayNameFld));
        displayNameFld.clear();
        displayNameFld.sendKeys(argDisplay_name);
    }
    public void saveChanges(){
        wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn)).click();
    }

}

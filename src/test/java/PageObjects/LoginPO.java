package PageObjects;

import StepMethods.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPO extends Driver {
    public LoginPO() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public WebElement emailInputFld;

    @FindBy(id = "password")
    public WebElement passwordInputFld;

    @FindBy(id = "submit-button")
    public WebElement loginBtn;

    public void enterEmail(String argEmail) {
        wait.until(ExpectedConditions.visibilityOf(emailInputFld)).sendKeys(argEmail);
    }


    public void enterPassword(String argPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputFld)).click();
        passwordInputFld.sendKeys(argPassword);
    }

    public void clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

}

package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static StepMethods.Driver.driver;
import static StepMethods.Driver.wait;

public class LandingPO {
    public LandingPO(){
        PageFactory.initElements(driver,this);
    }
    private String url="https://stackoverflow.com/";

    @FindBy(xpath = "//a[contains(@class, 's-btn__outlined') and normalize-space(text())='Log in']")
    public WebElement loginBtn;

    public void openStackOverFlowUrl() {
    driver.get(url);
    driver.manage().window().maximize();
    }
    public void clickLoginBtn() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
    }

}

package casestudy.pages;
import casestudy.utils.ConfigReader;
import casestudy.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.util.Properties;

public class LogInPage {
    public LogInPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    ConfigReader config=new ConfigReader();
    @FindBy(id="fld-e")
    public WebElement emailField;

    @FindBy(id="fld-p1")
    public WebElement passwordField;

    @FindBy(css=".c-button.c-button-outline.c-button-lg.c-button-block.c-button-icon.c-button-icon-leading.svg-button.social-button.undefined")
    public WebElement gmailButton;

    public void logIn() throws IOException {
        Properties prop=config.readPropertiesFile("src/test/resources/config/config.properties");
        emailField.click();
        emailField.sendKeys(prop.getProperty("username"));
        passwordField.click();
        passwordField.sendKeys(prop.getProperty("password"));
    }

    public void sendEnter(){
        emailField.sendKeys((Keys.ENTER));
    }
    public void logInGmail(){
        gmailButton.click();
    }

}
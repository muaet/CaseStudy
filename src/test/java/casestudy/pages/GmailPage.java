package casestudy.pages;

import casestudy.utils.ConfigReader;
import casestudy.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;


public class GmailPage {
    public GmailPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    ConfigReader config=new ConfigReader();
    @FindBy(xpath = "//div[contains(@class,'JDAKTe eARute W7Aapd zpCp3 SmR8')][contains(@jsname, 'rwl3qc')]")
    public WebElement anotherAccount;

    @FindBy(css=".whsOnd.zHQkBf")
    public WebElement gmailInput;

    @FindBy(css=".whsOnd.zHQkBf")
    public WebElement gPasswordInput;

    @FindBy(css=".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qIypjc.TrZEUc.lw1w4b")
    public WebElement gmailnext;

    public void chooseAnotherAcoount(){
        anotherAccount.click();
    }

    public void enterGmail() throws IOException {
        Properties prop=config.readPropertiesFile("src/test/resources/config/config.properties");
        gmailInput.click();
        gmailInput.sendKeys(prop.getProperty("gusername"));

    }
    public void enterGpassword() throws IOException {
        Properties prop=config.readPropertiesFile("src/test/resources/config/config.properties");
        gPasswordInput.sendKeys(prop.getProperty("gpassword"));

    }

    public void gmailNext(){
        gmailnext.click();
    }

}

package casestudy.pages;

import casestudy.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.get(),this);

    }

    @FindBy(css = "[alt='United States']")
    public WebElement country;

    @FindBy(css = ".c-close-icon.c-modal-close-icon")
    public WebElement closeButton;

    @FindBy(id="gh-search-input")
    public WebElement searchBar;

    @FindBy(css=".header-search-button")
    public WebElement searchButton;

    @FindBy(css=".plButton-label.v-ellipsis")
    public WebElement accountButton;

    @FindBy(css=".c-button.c-button-secondary.c-button-sm.sign-in-btn")
    public WebElement signInButton;

    @FindBy(css=".plButton-label.v-ellipsis")
    public WebElement loggedAcoountButton;

    public void chooseUS(){
        country.click();
    }

    public void closePopUp(){
        closeButton.click();
    }

    public void verifyPageTitle(String title){
        String current_title=Driver.get().getTitle();
        Assert.assertEquals(current_title, title);
    }
    public void searchString(String string){
        searchBar.click();
        searchBar.sendKeys(string);
        searchButton.click();
    }

    public void signInScreen(){
        accountButton.click();
        signInButton.click();
    }
    public void verifyLogin(){
        loggedAcoountButton.click();
        Assert.assertNotNull(Driver.get().findElement(By.id("logout-button")));

    }

}
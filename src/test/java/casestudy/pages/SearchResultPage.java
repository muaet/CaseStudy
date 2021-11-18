package casestudy.pages;

import casestudy.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    public SearchResultPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".title-wrapper.title")
    public WebElement searchResults;

    public void verifySearch(String text){
        Assert.assertTrue(searchResults.getText().contains("Results for"));
    }
}

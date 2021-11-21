package casestudy.pages;
import casestudy.utils.ConfigReader;
import casestudy.utils.Driver;
import casestudy.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage {
    public ItemPage(){PageFactory.initElements(Driver.get(),this);}

    @FindBy(id="brand_facet-search-bar-input")
    public WebElement searchBar;

    @FindBy(css="[aria-label='suggested brands']")
    public WebElement suggestedBrand;

    @FindBy(css=".sku-header")
    public List<WebElement> filteredItems;

    @FindBy(css=".save-for-later-save")
    public WebElement saveButton;

    @FindBy(css=".c-button-unstyled.plButton.savedItems-button")
    public WebElement savedItems;

    @FindBy(css=".item.c-carousel-item ")
    public List<WebElement> savedItemList;

    @FindBy(css=".heading-5.v-fw-regular")
    public WebElement itemTitle;



    public void searchByBrand(String brand){
        searchBar.sendKeys(brand);
        Helper.waitFor(1);
        suggestedBrand.click();
    }

    public void chooseByOrder(){
        filteredItems.get(1).click();
    }

    public void saveItem(){
        saveButton.click();
    }

    public void openSavedList(){
        savedItems.click();
    }

    public void verifyItemAdded(){
        Assert.assertTrue(savedItemList.get(0).getText().contains(itemTitle.getText()));

    }
}

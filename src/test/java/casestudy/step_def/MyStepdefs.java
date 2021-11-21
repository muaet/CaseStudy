package casestudy.step_def;
import casestudy.pages.*;
import casestudy.utils.Driver;
import casestudy.utils.Helper;
import casestudy.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;

import java.io.IOException;
import java.util.*;
import java.util.Properties;

public class MyStepdefs {
        Homepage homepage = new Homepage();
        SearchResultPage searchResultPage=new SearchResultPage();
        LogInPage logInPage=new LogInPage();
        GmailPage gmailPage=new GmailPage();
        ItemPage itemPage=new ItemPage();
        @Given("homepage is open")
        public void homepageIsOpen() {
            homepage.chooseUS();
        }
        @And("close the pop up")
        public void closeThePopUp() {
                homepage.closePopUp();
        }
        @When("page title {string} verified")
        public void pageTitleVerified(String string) {
                homepage.verifyPageTitle(string);
        }

        @Then("Maximize window")
        public void maximizeWindow() {
                Helper.maximizeWindow();
        }

        @And("Search for {string}")
        public void searchFor(String string) {
                homepage.searchString(string);
        }

        @Then("Verify search results are listed for {string}")
        public void verifySearchResultsAreListedFor(String text) {
                searchResultPage.verifySearch(text);
        }

        @When("go to Sign In page")
        public void goToSignInPage() {
                homepage.signInScreen();
        }

        @Then("fill the login form")
        public void fillTheLoginForm() throws IOException {
                logInPage.logIn();
        }
        @And("login with Enter button")
        public void loginWithEnterButton() {
                logInPage.sendEnter();
        }

        @Then("verify sucessful login")
        public void verifySucessfulLogin() {
                homepage.verifyLogin();
        }

        @Then("click sign in with google")
        public void clickSignInWithGoogle() {
                Helper.waitFor(3);
                logInPage.logInGmail();
        }

        @And("switch to other window")
        public void switchToOtherWindow() {
                System.out.println(Driver.get().getTitle());
                Object[] windows=Driver.get().getWindowHandles().toArray();
                Driver.get().switchTo().window(windows[1].toString());
                System.out.println(Driver.get().getTitle());
        }

        @And("choose use another account")
        public void chooseUseAnotherAccount() {
                gmailPage.chooseAnotherAcoount();
        }

        @Then("enter gmail")
        public void enterGmail() throws IOException {
                gmailPage.enterGmail();
        }

        @And("enter gmail password")
        public void enterGmailPassword() throws IOException {
                Helper.waitFor(3);
                gmailPage.enterGpassword();
        }

        @Then("click gmail next button")
        public void clickGmailNextButton() {
                gmailPage.gmailNext();
        }

        @Then("switch to main window")
        public void switchToMainWindow() {
                System.out.println(Driver.get().getTitle());
                Object[] windows=Driver.get().getWindowHandles().toArray();
                Driver.get().switchTo().window(windows[0].toString());
                System.out.println(Driver.get().getTitle());
        }

        @Then("open new tab")
        public void openNewTab() {
                ((JavascriptExecutor) Driver.get()).executeScript("window.open()");
        }

        @Then("go to {string}")
        public void goTo(String arg0) {
                Driver.get().get(arg0);
        }

        @When("go to Menu")
        public void goToMenu() {
                homepage.clickOnMenu();
        }

        @Then("click to {string}")
        public void clickTo(String arg0) {
                homepage.DropDownElement(arg0);
        }


        @Then("search by brand {string}")
        public void searchByBrand(String arg0) {
                itemPage.searchByBrand(arg0);
                Helper.waitFor(5);
        }

        @And("choose item number 2")
        public void chooseItemNumber() {
                itemPage.chooseByOrder();
                Helper.waitFor(3);
        }

        @Then("click save button")
        public void clickSaveButton() {
                itemPage.saveItem();
                Helper.waitFor(5);
        }

        @And("Go to saved items")
        public void goToSavedItems() {
                itemPage.openSavedList();
                Helper.waitFor(3);
        }

        @Then("Verify list is not empty")
        public void verifyListIsNotEmpty() {
                itemPage.verifyItemAdded();

        }


}

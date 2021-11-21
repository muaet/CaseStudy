package casestudy.step_def;
import casestudy.pages.GmailPage;
import casestudy.pages.SearchResultPage;
import casestudy.utils.Driver;
import casestudy.utils.Helper;
import casestudy.pages.Homepage;
import casestudy.pages.LogInPage;
import casestudy.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.*;
import java.util.Properties;

public class MyStepdefs {
        Homepage homepage = new Homepage();
        SearchResultPage searchResultPage=new SearchResultPage();
        LogInPage logInPage=new LogInPage();
        GmailPage gmailPage=new GmailPage();

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
}

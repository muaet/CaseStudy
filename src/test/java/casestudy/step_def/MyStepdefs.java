package casestudy.step_def;
import casestudy.pages.SearchResultPage;
import casestudy.utils.Helper;
import casestudy.pages.Homepage;
import casestudy.pages.LogInPage;
import casestudy.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.*;
import java.util.Properties;

public class MyStepdefs {
        Homepage homepage = new Homepage();
        SearchResultPage searchResultPage=new SearchResultPage();
        LogInPage logInPage=new LogInPage();

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

}

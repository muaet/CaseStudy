package casestudy.step_def;
import casestudy.pages.SearchResultPage;
import casestudy.utils.Helper;
import casestudy.pages.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
        Homepage homepage = new Homepage();
        SearchResultPage searchResultPage=new SearchResultPage();

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

}

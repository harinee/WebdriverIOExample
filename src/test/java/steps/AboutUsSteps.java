package steps;

import com.example.tests.lib.pages.actions.AboutUsPage;
import com.example.tests.lib.pages.actions.HomePage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import static org.junit.Assert.assertTrue;

public class AboutUsSteps {

    private final WebDriver driver;

    public AboutUsSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @Step("Navigate to About Us page")
    public void navigateToAboutUsPage() {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        AboutUsPage aboutUsPage = homepage.openAboutUsPage();
        DataStoreFactory.getScenarioDataStore().put("aboutUsPage", aboutUsPage);
    }

    @Step("Verify the title of GetStartedPage is <title>")
    public void VerifyTitleOfGetStartedPage(String title) {
        AboutUsPage getStartedPage = (AboutUsPage) DataStoreFactory.getScenarioDataStore().get("aboutUsPage");
        if (getStartedPage != null) {
            boolean titleOfPageMatches = getStartedPage.isTitleOfPage(title);
            assertTrue(titleOfPageMatches);
        }
    }
}


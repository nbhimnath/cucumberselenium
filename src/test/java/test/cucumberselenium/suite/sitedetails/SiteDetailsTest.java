package test.cucumberselenium.suite.sitedetails;


import com.pages.BasePage;
import cucumber.api.java.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class SiteDetailsTest {


    public WebDriver driver;
    public WebDriverWait wait;
    private static final String HOME_PAGE_URL="https://www.loft.com/";
    private static final String PETITE_CATEGORY_PAGE_URL="https://www.loft.com/petite-new-arrivals/cat220010";
    private static final String LOGIN_PAGE_URL="https://www.loft.com/profile/login.jsp";
    private static final String SYORE_PAGE_URL="https://www.loft.com/stores.jsp";


    @Before
    public void setup () throws MalformedURLException {
        //Create a Chrome driver. All test and page classes use this driver.
        //System.setProperty("webdriver.chrome.driver","REPLACE_WITH_PATH");
        //driver = new ChromeDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver,15);
        //Maximize Window
        //driver.manage().window().maximize();
    }

    @Given("^user is  on homepage$")
    public void user_is_on_homepage() throws Throwable {
        driver.get(HOME_PAGE_URL);
    }

    @Then("^user should see page title as \"([^\"]*)\"$")
    public void user_should_see_page_title_as(String arg1) throws Throwable {
        BasePage basePage = new BasePage(driver,wait);
        String pageTitle = basePage.getPageTitle();
        Assert.assertEquals("Page title should be " + arg1, arg1, pageTitle.trim());
    }

    @Given("^user is  on petites category page$")
    public void user_is_on_petites_category_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get(PETITE_CATEGORY_PAGE_URL);
    }

    @Given("^user is  on loginpage$")
    public void user_is_on_loginpage() throws Throwable {
        driver.get(LOGIN_PAGE_URL);
    }

    @Given("^user is  on store page$")
    public void user_is_on_store_page() throws Throwable {
        driver.get(SYORE_PAGE_URL);
    }

    @After
    public void teardown () {
        driver.quit();
    }

}

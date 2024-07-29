package my.project;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HovererTest {

    @BeforeEach
    void setUp() throws InterruptedException {
        System.out.println("\nWaiting for " + this.getClass().getSimpleName() + " to run...");
        Thread.sleep(5000);
    }

    @Test
    @Order(1)
    @DisplayName("Testing the hovering API: the top menu list")
    void hoverOverTopMenuList() {

        // Arrange
        String[] textLinks = new String[]{"ABOUT", "INNOVATION", "INDUSTRIES", "TECHNOLOGIES",
        "PRODUCTS", "TALENT", "ESG"};
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Hoverer hoverer = new Hoverer(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Act
        try {

            // Maximize browser window
            System.out.println("Maximizing browser window...");
            driver.manage().window().maximize();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the pop-up window is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sliding-popup")));
            System.out.println("Pop-up window is visible...");
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the 'Reject All Cookies' button is clickable
            WebElement declineCookiesButton = wait
                    .until(ExpectedConditions.elementToBeClickable(By.className("decline-button")));

            // Remove the pop-up window by clicking on the 'Reject All Cookies' button
            System.out.println("Clicking on the 'Reject All Cookies' button...");
            declineCookiesButton.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Hover over the top menu list items
            WebElement topMenuLink;
            for(String textLink : textLinks) {
                topMenuLink = driver.findElement(By.linkText(textLink));
                System.out.println("Hovering over " + textLink + "...");
                hoverer.hover(topMenuLink, actions);
                actions.pause(Duration.ofSeconds(3)).perform();
            }

            // Refresh the main page
            System.out.println("Refreshing main landing page...");
            driver.navigate().refresh();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Exit browser
            System.out.println("Exiting the browser...");
            driver.quit();

        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Testing the hovering API: Visit button")
    void hoverOverVisitBtn() {

        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Hoverer hoverer = new Hoverer(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Act
        try {
            // Maximize browser window
            System.out.println("Maximizing browser window...");
            driver.manage().window().maximize();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the pop-up window is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sliding-popup")));
            System.out.println("Pop-up window is visible...");
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the 'Reject All Cookies' button is clickable
            WebElement declineCookiesBtn = wait
                    .until(ExpectedConditions.elementToBeClickable(By.className("decline-button")));

            // Remove the pop-up window by clicking on the 'Reject All Cookies' button
            System.out.println("Clicking on the 'Reject All Cookies' button...");
            declineCookiesBtn.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Hover over the visit button
            WebElement visitBtn = driver.findElement(By.linkText("Visit"));
            System.out.println("Hovering over the Visit button...");
            hoverer.hover(visitBtn, actions);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Refresh the main page
            System.out.println("Refreshing main landing page...");
            driver.navigate().refresh();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Exit browser
            System.out.println("Exiting the browser...");
            driver.quit();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Testing the hovering API: search button")
    void hoverOverSearchBtn() {

        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Hoverer hoverer = new Hoverer(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Act
        try {
            // Maximize browser window
            System.out.println("Maximizing browser window...");
            driver.manage().window().maximize();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the pop-up window is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sliding-popup")));
            System.out.println("Pop-up window is visible...");
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the 'Reject All Cookies' button is clickable
            WebElement declineCookiesBtn = wait
                    .until(ExpectedConditions.elementToBeClickable(By.className("decline-button")));

            // Remove the pop-up window by clicking on the 'Reject All Cookies' button
            System.out.println("Clicking on the 'Reject All Cookies' button...");
            declineCookiesBtn.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Hover over the search button
            WebElement searchBtn = driver.findElement(By.id("search-btn"));
            System.out.println("Hovering over the Search button...");
            hoverer.hover(searchBtn, actions);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Refresh the main page
            System.out.println("Refreshing main landing page...");
            driver.navigate().refresh();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Exit browser
            System.out.println("Exiting the browser...");
            driver.quit();

        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }
}
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
class ClickerTest {

    @BeforeEach
    void setUp() throws InterruptedException {
        System.out.println("\nWaiting for " + this.getClass().getSimpleName() + " to run...");
        Thread.sleep(5000);
    }

    @Test
    @Order(1)
    @DisplayName("Testing the clicking API: Visit button")
    void clickVisitBtn() {

        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Clicker clicker = new Clicker(driver);
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

            // Click the visit button
            WebElement visitBtn = driver.findElement(By.linkText("Visit"));
            System.out.println("Clicking the Visit button...");
            clicker.click(visitBtn);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Navigate back to the main page
            System.out.println("Navigating back to main landing page...");
            driver.navigate().back();
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
    @DisplayName("Testing the clicking: span with 'Industries' text")
    void clickSpanWithIndustriesText() {

        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Clicker clicker = new Clicker(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

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

            // Click the Visit button
            WebElement visitBtn = driver.findElement(By.linkText("Visit"));
            System.out.println("Clicking the Visit button...");
            clicker.click(visitBtn);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the pop-up window is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialog")));
            System.out.println("Pop-up window is visible...");
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the 'Use necessary cookies only' button is clickable
            WebElement useNecessaryCookiesBtn = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogBodyButtonDecline")));

            // Remove the pop-up window by clicking the 'Use necessary cookies only'
            System.out.println("Clicking on the 'Use necessary cookies only' button...");
            useNecessaryCookiesBtn.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Click the span with the 'Industries' text
            WebElement spanWithTextIndustries = driver.findElement(By.xpath("//span[text()='Industries']"));
            System.out.println("Clicking on the 'Industries' span to open sub-menu...");
            spanWithTextIndustries.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Re-click to close the 'Industries' sub-menu
            System.out.println("Clicking on the 'Industries' span to close sub-menu... ");
            spanWithTextIndustries.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Navigate back to the main page
            System.out.println("Navigating back to main landing page...");
            driver.navigate().back();
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
    @DisplayName("Testing clicking API: span with 'Offerings' text ")
    void clickSpanWithOfferingsText() {
        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Clicker clicker = new Clicker(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

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

            // Click the Visit button
            WebElement visitBtn = driver.findElement(By.linkText("Visit"));
            System.out.println("Clicking the Visit button...");
            clicker.click(visitBtn);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the pop-up window is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialog")));
            System.out.println("Pop-up window is visible...");
            actions.pause(Duration.ofSeconds(3)).perform();

            // Wait until the 'Use necessary cookies only' button is clickable
            WebElement useNecessaryCookiesBtn = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogBodyButtonDecline")));

            // Remove the pop-up window by clicking the 'Use necessary cookies only'
            System.out.println("Clicking on the 'Use necessary cookies only' button...");
            useNecessaryCookiesBtn.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Click the span with the 'Offerings' text
            WebElement spanWithTextOfferings = driver.findElement(By.xpath("//span[text()='Offerings']"));
            System.out.println("Clicking on the 'Offerings' span to open sub-menu...");
            spanWithTextOfferings.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Re-click to close the 'Offerings' sub-menu
            System.out.println("Clicking on the 'Offerings' span to close sub-menu... ");
            spanWithTextOfferings.click();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Navigate back to the main page
            System.out.println("Navigating back to main landing page...");
            driver.navigate().back();
            actions.pause(Duration.ofSeconds(3)).perform();

            // Exit browser
            System.out.println("Exiting the browser...");
            driver.quit();

        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Testing clicking API: search button")
    void clickSearchButton() {
        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Clicker clicker = new Clicker(driver);
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

            // Open search box by clicking the Search button
            WebElement searchBtn = driver.findElement(By.id("search-btn"));
            System.out.println("Opening the search box...");
            clicker.click(searchBtn);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Close search box
            WebElement closeSearchBoxBtn = driver.findElement(By.id("search-btn-close"));
            System.out.println("Closing the search box...");
            clicker.click(closeSearchBoxBtn);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Exit browser
            System.out.println("Exiting the browser...");
            driver.quit();

        } catch (NoSuchElementException | ElementClickInterceptedException e) {
            fail(e.getMessage());
        }
    }
}
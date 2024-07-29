package my.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TyperTest {
    @BeforeEach
    void setUp() throws InterruptedException {
        System.out.println("\nWaiting for " + this.getClass().getSimpleName() + " to run...");
        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Testing typing and enter APIs: search box")
    void typeAndEnterSearchBox() {

        // Arrange
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netcompany-intrasoft.com/");
        Typer typer = new Typer(driver);
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

            // Typing 'projects' inside the Search box
            WebElement searchBox = driver.findElement(By.id("edit-keywords"));
            System.out.println("Typing 'projects' inside the search box...");
            typer.type(searchBox, "projects");
            actions.pause(Duration.ofSeconds(3)).perform();

            // Press 'Enter' to get search results
            System.out.println("Clicking 'Enter' to get search results...");
            typer.enter(searchBox, actions);
            actions.pause(Duration.ofSeconds(3)).perform();

            // Exit browser
            System.out.println("Exiting the browser...");
            driver.quit();

        } catch(NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }
}
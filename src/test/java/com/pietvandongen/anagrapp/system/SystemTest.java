package com.pietvandongen.anagrapp.system;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Category(com.pietvandongen.anagrapp.test.categories.SystemTest.class)
public class SystemTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void shutDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("http://localhost:9000/");

        WebElement input = driver.findElement(By.id("word"));
        input.sendKeys("piet");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        (new WebDriverWait(driver, 5))
                .until((ExpectedCondition<Boolean>) webDriver -> !webDriver
                        .findElement(By.id("anagrams"))
                        .findElements(By.tagName("li"))
                        .isEmpty());

        List<String> expected = Arrays.asList("piet", "ba");
        List<String> actual = driver
                .findElement(By.id("anagrams"))
                .findElements(By.tagName("li"))
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());

        assertThat(actual, is(expected));
    }
}

package edu.pitt.cs;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    //
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    //
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void tEST1LINKS() {
    // Test name: TEST-1-LINKS
    // Step # | name | target | value
    // 1 | open | / |
    driver.get("http://localhost:8080//");
    // 2 | verifyElementPresent | xpath=//a[@href='/reset' and text()='Reset'] |
    {
      List<WebElement> elements = driver.findElements(By.xpath("//a[@href=\'/reset\' and text()=\'Reset\']"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST2RESET() {
    // Test name: TEST-2-RESET
    // Step # | name | target | value
    // 1 | open | https://cs1632.appspot.com/ |
    driver.get("http://localhost:8080/");
    // 2 | click | link=Reset |
    driver.findElement(By.linkText("Reset")).click();
    // 3 | assertText | xpath=//div[@id='listing']/ul/li | ID 1. Jennyanydots
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
    // 4 | assertText | xpath=//div[@id='listing']/ul/li[2] | ID 2. Old Deuteronomy
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    // 5 | assertText | xpath=//div[@id='listing']/ul/li[3] | ID 3. Mistoffelees
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }

  @Test
  public void tEST3CATALOG() {
    driver.get("http://localhost:8080//");
    driver.findElement(By.linkText("Catalog")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//ol/li[1]/img[@src=\'/images/cat1.jpg\']"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST5RENTACAT() {
    // Test name: TEST-5-RENT-A-CAT
    // Step # | name | target | value
    // 1 | open | /rent-a-cat |
    driver.get("http://localhost:8080//rent-a-cat");
    // 2 | assertElementPresent | xpath=//button[text()='Rent'] |
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[text()=\'Rent\']"));
      assert (elements.size() > 0);
    }
    // 3 | assertElementPresent | xpath=//button[text()='Return'] |
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[text()=\'Return\']"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST6RENT() {
    // Test name: TEST-6-RENT
    // Step # | name | target | value
    // 1 | open | https://cs1632.appspot.com/ |
    driver.get("http://localhost:8080/");
    // 2 | runScript | document.cookie = "1=false";document.cookie =
    // "2=false";document.cookie = "3=false"; |
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    // 3 | click | linkText=Rent-A-Cat |
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    // 4 | click | id=rentID |
    driver.findElement(By.id("rentID")).click();
    // 5 | type | id=rentID | 1
    driver.findElement(By.id("rentID")).sendKeys("1");
    // 6 | click | css=.form-group:nth-child(3) .btn |
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    // 7 | assertText | xpath=//div[@id='listing']/ul/li | Rented out
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("Rented out"));
    // 8 | assertText | xpath=//div[@id='listing']/ul/li[2] | ID 2. Old Deuteronomy
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    // 9 | assertText | xpath=//div[@id='listing']/ul/li[3] | ID 3. Mistoffelees
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    // 10 | assertText | id=rentResult | Success!
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
  }

  @Test
  public void tEST7RETURN() {
    // Test name: TEST-7-RETURN
    // Step # | name | target | value
    // 1 | open | /rent-a-cat |
    driver.get("http://localhost:8080//rent-a-cat");
    // 2 | type | id=rentID | 1
    driver.findElement(By.id("rentID")).sendKeys("1");
    // 3 | type | id=returnID | 1
    driver.findElement(By.id("returnID")).sendKeys("1");
    // 4 | click | xpath=//button[text()='Rent'] |
    driver.findElement(By.xpath("//button[text()=\'Rent\']")).click();
    // 5 | click | xpath=//button[text()='Return'] |
    driver.findElement(By.xpath("//button[text()=\'Return\']")).click();
    // 6 | assertText | id=cat-id1 | ID 1. Jennyanydots
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    // 7 | assertText | id=cat-id2 | ID 2. Old Deuteronomy
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    // 8 | assertText | id=cat-id3 | ID 3. Mistoffelees
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
    // 9 | assertText | id=returnResult | Success!
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }

  @Test
  public void tEST8FEEDACAT() {
    // Test name: TEST-8-FEED-A-CAT
    // Step # | name | target | value
    // 1 | open | /feed-a-cat |
    driver.get("http://localhost:8080//feed-a-cat");
    // 2 | assertElementPresent | xpath=//button[text()="Feed"] |
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[text()=\"Feed\"]"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST9FEED() {
    // Test name: TEST-9-FEED
    // Step # | name | target | value
    // 1 | open | /feed-a-cat |
    driver.get("http://localhost:8080//feed-a-cat");
    // 2 | type | id=catnips | 6
    driver.findElement(By.id("catnips")).sendKeys("6");
    // 3 | click | xpath=//button[text()="Feed"] |
    driver.findElement(By.xpath("//button[text()=\"Feed\"]")).click();
    // 4 | assertText | xpath=//*[@id='feedResult' and text()='Nom, nom, nom.'] |
    // Nom, nom, nom.
    assertThat(driver.findElement(By.xpath("//*[@id=\'feedResult\' and text()=\'Nom, nom, nom.\']")).getText(),
        is("Nom, nom, nom."));
  }

  @Test
  public void tEST10GREETACAT() {
    // Test name: TEST-10-GREET-A-CAT
    // Step # | name | target | value
    // 1 | open | /greet-a-cat |
    driver.get("http://localhost:8080//greet-a-cat");
    // 2 | assertText | id=greeting | Meow!Meow!Meow!
    assertThat(driver.findElement(By.id("greeting")).getText(), is("Meow!Meow!Meow!"));
  }

  @Test
  public void tEST11GREETACATWITHNAME() {
    // Test name: TEST-11-GREET-A-CAT-WITH-NAME
    // Step # | name | target | value
    // 1 | open | /greet-a-cat/Jennyanydots |
    driver.get("http://localhost:8080//greet-a-cat/Jennyanydots");
    // 2 | assertText | id=greeting | Meow! from Jennyanydots.
    assertThat(driver.findElement(By.id("greeting")).getText(), is("Meow! from Jennyanydots."));
  }

  @Test
  public void tEST4LISTING() {
    // Test name: TEST-4-LISTING
    // Step # | name | target | value
    // 1 | open | https://cs1632.appspot.com/ |
    driver.get("http://localhost:8080/");
    // 2 | click | linkText=Catalog |
    driver.findElement(By.linkText("Catalog")).click();
    // 3 | storeXpathCount | xpath=//div/ul/li | list
    vars.put("list", driver.findElements(By.xpath("//div/ul/li")).size());
    // 4 | echo | list |
    System.out.println("list");
    // 5 | assert | list | 3
    assertEquals(vars.get("list").toString(), "3");
    // 6 | assertText | xpath=//div[@id='listing']/ul/li[3] | ID 3. Mistoffelees
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
}

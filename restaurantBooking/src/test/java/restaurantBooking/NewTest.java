package restaurantBooking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  //Set up Selenium as driver
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  //Navigate to the manage booking view 
	  driver.get("http://localhost:8090/restaurantBooking/ManageBookingServlet");
	  
	  //Create a test booking 
	  driver.findElement(By.linkText("Book another slot")).click();
	  driver.findElement(By.name("restaurantName")).sendKeys("Test Restaurant");
	  driver.findElement(By.name("bookingName")).sendKeys("Test Name");
	  driver.findElement(By.name("bookingNumber")).sendKeys("91234567");
	  Select selectTime = new Select(driver.findElement(By.name("bookingTime")));
	  selectTime.selectByVisibleText("2pm");
	  
	  //Edit button of the created booking
	  driver.findElement(By.cssSelector("body > form > input[type=submit]:nth-child(8)")).click();
	  
	  
	  //Edit the newly created booking
	  //Editing the name
	  driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(4) > td:nth-child(5) > a:nth-child(1)")).click();
	  driver.findElement(By.cssSelector("body > div > div > div > form > fieldset:nth-child(2) > input")).clear();
	  driver.findElement(By.cssSelector("body > div > div > div > form > fieldset:nth-child(2) > input")).sendKeys("Test Name 1");
	  
	  //Editing the phone number
	  driver.findElement(By.cssSelector("body > div > div > div > form > fieldset:nth-child(4) > input")).clear();
	  driver.findElement(By.cssSelector("body > div > div > div > form > fieldset:nth-child(4) > input")).sendKeys("92345678");
	  
	  //Editing the time of the booking
	  Select updateTime = new Select(driver.findElement(By.cssSelector("body > div > div > div > form > fieldset:nth-child(5) > select")));
	  updateTime.selectByVisibleText("6pm");
	  
	  //Saving the changes made to the booking
	  driver.findElement(By.cssSelector("body > div > div > div > form > button")).click();
	  
	  //Delete the booking that has been created and updated
	  driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(4) > td:nth-child(5) > a:nth-child(2)")).click();
	  
	 
	  
	  
	 
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}

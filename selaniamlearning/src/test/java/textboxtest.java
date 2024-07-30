import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class textboxtest {

    WebDriver driver;

    @BeforeMethod

    public void textbox(){
       // ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.setBrowserVersion("126");
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");


    }

    @Test
    public void tetboxtest1()
    {
        //tye name
        WebElement name= driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Sandaru");

        //apend coutry
        WebElement Country = driver.findElement(By.id("j_idt88:j_idt91"));
        Country.sendKeys("Srilnka ");

        //Verify if text box is disabled
        boolean Enabled = driver.findElement(By.name("j_idt88:j_idt93")).isSelected();
        System.out.println("output is = " +Enabled);

        //Clear the typed text.
        WebElement Cleartext = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        Cleartext.clear();

        //Retrieve the typed text.
        WebElement Retreivetext = driver.findElement(By.id("j_idt88:j_idt97"));
        String value =Retreivetext.getAttribute("value");
        System.out.println("value " + value);

        //Type email and Tab. Confirm control moved to next element.
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("avishkasFernando2001@gmail.com" +Keys.TAB+"confiremd control moved to next element ");

    }

}

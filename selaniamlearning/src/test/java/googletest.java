import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class googletest {

    WebDriver driver ;
    @BeforeMethod
    public void test1()
    {
        driver = new FirefoxDriver();
        driver.get("https://www.leafground.com/link.xhtml");
       // driver.findElement(By.id("APjFqb")).sendKeys("NSBM" , Keys.ENTER);
        //Thread.sleep(3000);
       // driver.navigate().back();
    }



    @Test

    public void google_test() throws InterruptedException {


       WebElement new1  =  driver.findElement(By.partialLinkText("Go to Dashboard"));
       new1 .click();
       driver.navigate().back();

      WebElement new2 =  driver.findElement(By.partialLinkText("Find the URL without clicking me."));
       // new2.click();
       String path =  new2.getAttribute("href");
        System.out.println("destination is = " +path);

        WebElement new3 =  driver.findElement(By.partialLinkText("Broken?"));
        new3.click();

        String title = driver.getTitle();

        if (title.equals("Error 404 /lists.xhtml Not Found in ExternalContext as a Resource"))
        {
            System.out.println("this page link is broken");
        }
        else
        {
            System.out.println("this page link is not broken");
        }




        List<WebElement> new4 =driver.findElements(By.tagName("a"));
        System.out.println("count of links is = " + new4.size());


       WebElement new5 = driver.findElement(By.className("layout-main-content"));
        List<WebElement> linkcount = new5.findElements(By.tagName("a"));
        System.out.println("count fo links is layout is = " +linkcount.size());






    }
}

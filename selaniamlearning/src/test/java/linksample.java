import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class linksample {

    WebDriver driver;// ඕන තැනකට දාගන්න පුලුවන් විදිහට වෙබ් ඩ්‍ර්‍යිවර් එක හදනවා

    @BeforeMethod
    public void precondition()
    {
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void linktest()
    {
    //take me to dashboard
        WebElement homelink = driver.findElement(By.linkText("How many links in this page?"));
        homelink.click();
        driver.navigate().back();

    //find my destination
        WebElement wheretogo =  driver.findElement(By.partialLinkText("Find the URL without clicking me"));
       String path = wheretogo.getAttribute("href");
        System.out.println("this link is going to ;" + path);

    // error link
        WebElement brokenlink =  driver.findElement(By.partialLinkText("Broken?"));
        brokenlink.click();

        String title =driver.getTitle(); //වෙබ් පේජ් එකේ ටයිටල් එක ලබාගැනීම
        if (title.contains("404"))
        {
            System.out.println("this lin is broken ");
        }
        else
        {
            System.out.println("not broken");
        }
driver.navigate().back();

    //duplicate
        WebElement homelink1 = driver.findElement(By.linkText("How many links in this page?"));
        homelink1.click();
        driver.navigate().back();

    //count of link exist
        List<WebElement> countfullagelinks = driver.findElements(By.tagName("a"));
        int pagelnikcount = countfullagelinks.size();
        System.out.println("count of links is = " +pagelnikcount);

    //count layout lniks
        WebElement layuotcount = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countoflayoutlink = layuotcount.findElements(By.tagName("a"));
        System.out.println("count of layout link = " + countoflayoutlink.size());
    }


}

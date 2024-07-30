import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class drodownlist {

    WebDriver driver ;
    @BeforeMethod
    public void precondition()
    {
        driver=new ChromeDriver();
        Dimension newsize =new Dimension(800,600);
        driver.manage().window().setSize(newsize);
        //driver.manage().window().maximize();

    }

    @Test
    public void dropdowntest() throws InterruptedException {

        driver.get("https://www.leafground.com/select.xhtml");
       // Which is your favorite UI Automation tool?
        WebElement basicdro = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(basicdro);
        select.selectByIndex(1);//array id (1) = "selanium"
        Thread.sleep(3000);//execution is temrerory puse untill 3  second
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);//execution is temrerory puse untill 3  second


        //get the number of dropdown options
        List<WebElement> listofoptions = select.getOptions();//show the option of above list
       int listsize = listofoptions.size();
        System.out.println("Number of elemet in dropdown" +listsize);
        for (WebElement element :listofoptions) // show the element of dropdownlist
        {
            System.out.println(element.getText());
        }


        //using sendkeays select drodownvalue

        basicdro.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //select value in a boostrap drodown value

       WebElement dropdound2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
       dropdound2.click();
        List<WebElement> listofdropdown2 = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listofdropdown2)
        {
          String drodwonvalue =  element.getText();
          if(drodwonvalue.equals("USA"))
          {
              element.click();
              break;
          }
        }


    }

    //google search - pick a value from suggestion

    @Test
    public void googlesearch() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Palitha ");
        Thread.sleep(2000);
        List<WebElement> googlesearchlist = driver.findElements(By.xpath("//ul[@role = 'listbox']//li//div[@class='wM6W7d']"));
        System.out.println(googlesearchlist.size());

        for (WebElement element: googlesearchlist)
        {
           // System.out.println(element.getText());
            String drodwonvalue1 =  element.getText();

            if (drodwonvalue1.equals("Palitha Thewarapperuma"))
            {
                element.click();
                break;
            }

        }
        driver.navigate().back();


        //handle hidden auto suggestion drop down and search using dom debugger tric

        /*
        setTimeout(function()
{
    debugger;
},3000);
         */


    }
}

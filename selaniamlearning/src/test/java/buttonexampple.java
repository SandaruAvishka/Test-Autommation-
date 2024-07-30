import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class buttonexampple {

    WebDriver driver;// ඕන තැනකට දාගන්න පුලුවන් විදිහට වෙබ් ඩ්‍ර්‍යිවර් එක හදනවා

    @BeforeMethod
    public void precondition()
    {
        driver=new FirefoxDriver();
        Dimension newsize =new Dimension(800,600);
        driver.manage().window().setSize(newsize);
        //driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

        @Test
        public void buttontest()
        {
            //Click and Confirm title.
            driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt90\"]")).click();
            String Expected_title = "Dashboard";
            String actual_title = driver.getTitle(); // answer is title -> Dashboard

            if (Expected_title.equals(actual_title ))
            {
                System.out.println("Actual titile same as expected");
            }
            else
                System.out.println("Actual titile not same as expected");

            // Assert.assertEquals(actual_title,Expected_title,"titile  mismatch");
            driver.navigate().back();

            //Find the position of the Submit button

            WebElement submit = driver.findElement(By.id("j_idt88:j_idt94"));
            //find the position
            Point xypoint =  submit.getLocation(); // getlocation() -> x and y
            int x = xypoint.getX();
            int y = xypoint.getY();
            System.out.println(" x and y position is  " + x +"And " + y);

            //Find the Save button color

            WebElement color = driver.findElement(By.id("j_idt88:j_idt96"));
            String backcolor = color.getCssValue("background-color"); //cssvalue = background-color = rgb(96, 125, 139);
            System.out.println("button bacground color is = " +backcolor);

            //Find the height and width of this button
           WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
            int height =  size.getSize().getHeight();
            int width =  size.getSize().getHeight();
            System.out.println("button width and heigth is = " + width +"and " +height);

        }






}

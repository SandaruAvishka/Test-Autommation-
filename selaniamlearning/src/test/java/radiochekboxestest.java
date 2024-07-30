import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class radiochekboxestest {

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
    public void checktest()
    {
        driver.get("https://www.leafground.com/radio.xhtml");

        //Find the default select radio button
        boolean chrom=    driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefox=    driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safari=    driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edge=    driver.findElement(By.id("j_idt87:console2:3")).isSelected();


        if(chrom)
        {
          String s1 = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:0\"]")).getText();
            System.out.println("default select radio button is " + s1);

        } else if (firefox) {
            String s2 = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:1\"]")).getText();
            System.out.println("default select radio button is " + s2);
        }
     else if (safari) {
        String s3 = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:2\"]")).getText();
        System.out.println("default select radio button is " + s3);
    }
        else if (edge) {
        String s4 = driver.findElement(By.xpath("//label[@for=\"j_idt87:console2:3\"]")).getText();
        System.out.println("default select radio button is " + s4);
    }


        //Select the age group (only if not selected)

        WebElement n1 = driver.findElement(By.id("j_idt87:age:1"));
        boolean isselect = n1.isSelected();

        if (!isselect)
        {
            n1.click();
            driver.findElement(By.xpath("//label[@for=\"j_idt87:age:0\"]")).click();
        }






    }


    @Test
    public void radiotest()
    {
        driver.get("https://www.leafground.com/checkbox.xhtml");
        //Choose your favorite language(s)

        List<WebElement> find = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));//fid the checkbox lists
        for (WebElement element : find)
        {
            if(!(element.getText().equals("Others")))
            {
                element.click();
            }
        }


        for (int i = 0;i<find.size();i++)//get the output  all click checkbox options is selected exept that "other" checkbox
        {

           boolean checboxstatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("checbox " +i+ "selected status is :" +checboxstatus);
        }






    }



}

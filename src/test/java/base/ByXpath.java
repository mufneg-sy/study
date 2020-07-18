package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 12:42.
 */
public class ByXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.qunar.com/";
        //访问去哪儿网
        driver.get(url);
        driver.findElementByXPath("//b[text() = \"攻略\"]").click();
        driver.findElementByXPath("//b[text() = \"门票\"]").click();
    }
}

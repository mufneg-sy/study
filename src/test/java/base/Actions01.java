package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 20:39.
 */
public class Actions01 {
    public static void main(String[] args) {
        ChromeDriver driver = DriverUtils.getChromeDriver();
        driver.get("https://www.baidu.com/");
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //定位"更多产品"元素
        WebElement more = driver.findElement(By.name("tj_briicon"));
        //移动到"更多产品"元素
        actions.moveToElement(more).perform();
        //点击第三个产品:
        driver.findElement(By.name("tj_baike")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

        //
    }
}

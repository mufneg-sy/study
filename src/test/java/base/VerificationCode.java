package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 21:08.
 */
public class VerificationCode {
    public static void main(String[] args) {
        ChromeDriver driver = DriverUtils.getChromeDriver();
        driver.get("https://www.taobao.com/");
        Cookie cookie1 = new Cookie("XSRF-TOKEN", "115e25ea-786b-4524-b3ef-e47b382e61ac");
        Cookie cookie2 = new Cookie("XSRF-TOKEN","2ac0d982-fe12-4d3e-842a-6110663c4ab0");
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.findElement(By.partialLinkText("待收货")).click();
        driver.quit();
    }
}

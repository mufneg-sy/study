package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 16:23.
 */
public class Iframe {
    public static void main(String[] args) {
        ChromeDriver driver = DriverUtils.getChromeDriver();
        driver.get("https://ke.qq.com/");
        //查找登录按钮并点击
        driver.findElement(By.id("js_login")).click();
        //硬性等待2秒,加载出登录方式选择div
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击中间的QQ登录按钮
        //登录按钮的 的 xpaht   //a[@class = "js-btns-enter btns-enter btns-enter-qq"]
        driver.findElementByXPath("//a[@class = \"js-btns-enter btns-enter btns-enter-qq\"]").click();
        //切换到登录按钮所在的iframe
        //定位登录页面的iframe
        WebElement loginFrame = driver.findElement(By.name("login_frame_qq"));
        //切换iframe
        driver.switchTo().frame(loginFrame);
        //点击登录弹出框的"账号密码登录"按钮(超链接)
        driver.findElement(By.id("switcher_plogin")).click();
        //硬性等待2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //因为"关闭"按钮不在登录的iframe中,所以切换回第一个iframe(首页)
        driver.switchTo().defaultContent();
        //点击关闭按钮
        driver.findElement(By.id("login_close")).click();
        driver.findElement(By.id("js_keyword")).sendKeys("软件测试");
        driver.findElement(By.id("js_search")).click();
        //硬性等待3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }


}

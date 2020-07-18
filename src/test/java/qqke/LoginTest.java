package qqke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/17 21:15.
 */
public class LoginTest {
    @Test
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        //默认窗口最大化
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //打开Chrome浏览器,创建一个driver对象
        ChromeDriver driver = new ChromeDriver(options);
        //打开腾讯课堂首页
        driver.get("https://lemon.ke.qq.com/");
        //硬性等待2秒,加载出登录方式选择div
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击登录
        driver.findElement(By.id("js_login")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在账号登录类型选择框选择QQ登录
        driver.findElementByXPath("//a[@class = \"js-btns-enter btns-enter btns-enter-qq\"]").click();
        //硬性等待5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //切换到登录框iframe
        WebElement loginFrame = driver.findElement(By.name("login_frame_qq"));
        driver.switchTo().frame(loginFrame);
        //切换到使用用户名和密码登录
        driver.findElement(By.id("switcher_plogin")).click();
        //定位到qq号输入框并输入值
        driver.findElement(By.id("u")).sendKeys("");
        //输入密码
        driver.findElement(By.id("p")).sendKeys("");
        //点击登录按钮
        driver.findElement(By.id("login_button")).click();
        //实际的提示
        String actualStr = driver.findElement(By.id("err_m")).getText();
        //断言提示符合预期
        Assert.assertEquals(actualStr,"你还没有输入帐号！");
        //关闭所有窗口
        driver.close();
    }
}

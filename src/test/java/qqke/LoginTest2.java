package qqke;

import org.apache.tools.ant.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/17 22:52.
 */
public class LoginTest2 {

    //将driver设置为成员变量
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        //默认窗口最大化
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //打开Chrome浏览器,创建一个driver对象
         driver = new ChromeDriver(options);
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
        driver.findElement(By.xpath("//a[@class = \"js-btns-enter btns-enter btns-enter-qq\"]")).click();
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
    }

    @BeforeMethod
    public void beforeMethod(){

            driver.findElement(By.id("u")).clear();
            driver.findElement(By.id("u")).clear();
    }

    @Test(priority = 0)
    //不输入账号和密码
    public void noAccountAndPassWord(){
        driver.findElement(By.id("u")).sendKeys("");
        driver.findElement(By.id("p")).sendKeys("");
        driver.findElement(By.id("login_button")).click();
        String actualStr = driver.findElement(By.id("err_m")).getText();
        Assert.assertEquals(actualStr,"你还没有输入帐号！");
    }

    @Test(priority = 1)
    //输入账号不输入密码
    public void accountAndNOPassWord(){
        driver.findElement(By.id("u")).sendKeys("123456");
        driver.findElement(By.id("p")).sendKeys("");
        driver.findElement(By.id("login_button")).click();
        String actualStr = driver.findElement(By.id("err_m")).getText();
        Assert.assertEquals(actualStr,"你还没有输入密码！");
    }

    @Test(priority = 2)
    //输入账号和输入错误密码
    public void accountAndMissPassWord(){
        driver.findElement(By.id("u")).sendKeys("123456");
        driver.findElement(By.id("p")).sendKeys("123456");
        driver.findElement(By.id("login_button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualStr = driver.findElement(By.id("err_m")).getText();
        Assert.assertEquals(actualStr,"你输入的帐号或密码不正确，请重新输入。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}

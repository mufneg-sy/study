package qqke;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/18 11:05.
 */
public class LoginTest3 {
    //将driver设置为成员变量
    WebDriver driver;
    
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://lemon.ke.qq.com/");
        driver.findElement(By.id("js_login")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@class = \"js-btns-enter btns-enter btns-enter-qq\"]")).click();
        WebElement loginFrame = driver.findElement(By.name("login_frame_qq"));
        driver.switchTo().frame(loginFrame);
        driver.findElement(By.id("switcher_plogin")).click();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.findElement(By.id("u")).clear();
        driver.findElement(By.id("p")).clear();
    }

    @Test(dataProvider = "dp")
    @Description("登录用例")
    @Step("case1")
    public void case1(String userName,String passWord,String tips){
        driver.findElement(By.id("u")).sendKeys(userName);
        driver.findElement(By.id("p")).sendKeys(passWord);
        driver.findElement(By.id("login_button")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualStr = driver.findElement(By.id("err_m")).getText();
        Assert.assertEquals(actualStr,tips);
    }

    @DataProvider
    public Object[][] dp(){
        Object[][] datas = {
                {"","","你还没有输入帐号！"},
                {"123456","","你还没有输入密码！"},
                {"123456","123456","你输入的帐号或密码不正确，请重新输入。"}
        };

        return datas;
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void sea(int i ,int j){
        System.out.println(i + j);
    }
}

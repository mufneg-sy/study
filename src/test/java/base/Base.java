package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/14 11:40.
 */
public class Base {
    public static void main(String[] args) {
        //设置浏览器及对应的浏览器驱动地址
        System.setProperty("webdriver.chrome.driver","C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
       /* //创建浏览器对象
        WebDriver driver = new ChromeDriver();
        //让浏览器最大化
        driver.manage().window().maximize();*/

       //浏览器启东市就默认最大化窗口
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);

        //获取当前浏览器尺寸
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        //设置浏览器尺寸
        Dimension dimension = new Dimension(400, 400);
        driver.manage().window().setSize(dimension);

        //让浏览器最大化
        driver.manage().window().maximize();

        //获取浏览器位置
        Point position = driver.manage().window().getPosition();
        System.out.println(position);

        //设置浏览器位置
        Point point = new Point(0, 0);
        driver.manage().window().setPosition(point);

        driver.get("https://www.baidu.com");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取网页的title
        String title = driver.getTitle();
        System.out.println("Title is "+ title);

        //找到搜索框并输入"易百教程"By.id
        //driver.findElement(By.id("kw")).sendKeys("易百教程");
        ////找到搜索框并输入"易百教程"By.className
        driver.findElement(By.className("s_ipt")).sendKeys("易百教程");
        //找到搜索按钮并点击By.id
        driver.findElement(By.id("su")).click();


        //关闭所有窗口
        driver.quit();

        //关闭当前窗口
        driver.close();
    }

}

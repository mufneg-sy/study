package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/14 23:45.
 */
public class Selenium01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "http://www.baidu.com";
        //访问百度首页
        driver.get(url);

        //访问知乎专栏
        driver.get("https://www.zhihu.com/signin?next=%2F");

        //后退操作,从知乎退到百度
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("后退至"+driver.getCurrentUrl());
        //刷新页面
        //driver.navigate().refresh();

        //前进操作,从百度前进至知乎
        driver.navigate().forward();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("前进至"+driver.getCurrentUrl());

        /*//获取当前页面的url地址
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        //获取当前页面标题
        String title = driver.getTitle();
        System.out.println(title);

        //获取当前页面源码
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);*/

    }
}

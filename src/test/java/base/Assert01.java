package base;

import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 10:21.
 */
public class Assert01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "http://www.baidu.com";
        //访问百度首页
        driver.get(url);

        //显示当前的url
        System.out.println(driver.getCurrentUrl());

        //显示当前的页面标题
        System.out.println(driver.getTitle());

        //截图方法一: 图片保存到电脑上某一个位置
       /* //执行屏幕截图操作(截取浏览器体内的内容,不包括浏览器的菜单和桌面的任务栏区域)
        //1.转类型为截图接口类型
        TakesScreenshot takesScreenshot = driver;
        //2.通过调用截图方法等得到截图图片文件对象
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //创建一个目标文件
        File file = new File("D:\\baidu.jpg");
        //
        try {
            FileUtils.copyFile(screenshotFile,file);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

       //截图方法二: 图片保存到工程目录下
        try {
            BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(img,"png",new File("robot_screen01.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}

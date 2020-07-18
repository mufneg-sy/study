package base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 18:13.
 *
 * 日期控件有问题.
 */
public class Date {
    public static void main(String[] args) {
        ChromeDriver driver = DriverUtils.getChromeDriver();
        /*driver.get("https://www.ctrip.com/");
        //时间控件没有限制手动输入
        driver.findElement(By.id("HD_CheckIn")).clear();
        driver.findElement(By.id("HD_CheckIn")).sendKeys("2020-7-20");*/

        // 因为日期控件限制了手动输入,所以通过执行JavaScript脚本来改变元素value属性值
        driver.get("https://www.12306.cn/index/");
        String script = "document.getElementById('train_date').value = '2020-07-18'";
        driver.findElement(By.id("train_date")).sendKeys();
        //执行js脚本
        driver.executeScript(script);
        System.out.println(driver.getTitle());
    }
}

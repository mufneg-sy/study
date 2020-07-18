package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
* 操作下拉框*/

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 17:18.
 */
public class DropDownBox {
    public static void main(String[] args) {
        ChromeDriver driver = DriverUtils.getChromeDriver();
        driver.get("https://www.2345.com/");
        //定位"切换"链接并点击
        driver.findElement(By.id("J_city_switch")).click();
        //因为下拉框存在于嵌套的iframe中间,所以先切换过去
        WebElement frame = driver.findElement(By.id("city_set_ifr"));
        driver.switchTo().frame(frame);
        //找到第一个省份的下拉框
        WebElement provinceElement = driver.findElement(By.id("province"));
        provinceElement.click();
        //选择省份,对select进行操作,首先把元素包装成select
        Select provinceSelect = new Select(provinceElement);
        //根据可见的文本
//        provinceSelect.selectByVisibleText("G 广东");
        //根据索引选中对应的选项
//        provinceSelect.selectByIndex(4);
        //选择指定value值对应的选项
        provinceSelect.selectByValue("34");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭浏览器
        driver.quit();
    }
}

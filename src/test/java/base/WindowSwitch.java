package base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 17:44.
 */
public class WindowSwitch {
    public static void main(String[] args) {
        ChromeDriver driver = DriverUtils.getChromeDriver();
        driver.get("https://www.baidu.com/");
        //获得第一个窗口的句柄,返回句柄字符串
        String firstWindowHandle = driver.getWindowHandle();
        //点击底部的"京公网安备110000000020001号"超链接  //span[@class = "lh s-bottom-recordcode"]
        driver.findElement(By.partialLinkText("京公网安备")).click();
        //获取所有的窗口句柄,返回所有窗口句柄集合
        Set<String> handles = driver.getWindowHandles();
        //通过遍历集合和字符串比较,确定第二个句柄内容
        String secondHandle = "";
        for (String handle : handles) {
            //如果不是第一个,那就是我要找的第二个窗口
            if(!firstWindowHandle.equals(handle)){
                secondHandle = handle;
            }
        }
        //通过句柄,切换到第二个窗口
        driver.switchTo().window(secondHandle);
        //操作第二个窗口的"公共查询"超链接
        driver.findElement(By.partialLinkText("公共查询")).click();
        //要操作第一个窗口的元素,需要通过句柄切换回第一个窗口
        driver.switchTo().window(firstWindowHandle);
        //再点击第一个窗口的"京公网"超链接
        driver.findElement(By.partialLinkText("京公网安备")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}

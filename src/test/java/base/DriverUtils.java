package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 17:20.
 */
public class DriverUtils {

    public static ChromeDriver getChromeDriver() {
        //设置驱动文件路径
        System.setProperty("webdriver.chrome.driver","C:/Users/syanl/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        //创建Chrome驱动并且浏览器默认最大化
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    }
}

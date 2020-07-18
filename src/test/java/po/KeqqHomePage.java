package po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/15 22:14.
 * 腾讯课堂首页类
 */
public class KeqqHomePage extends BasePage {

    //下拉图标
    @FindBy(css = "i[class='icon-font i-v-bottom-small']")
    @CacheLookup
    public WebElement select_icon;

    //机构元素
    @FindBy(css = "span[class = 'mod-search-dropdown-item']")
    @CacheLookup
    public  WebElement organization_item;

    //输入框
    @FindBy(id = "js_keyword")
    @CacheLookup
    public WebElement search_input;

    //搜索按钮
    @FindBy(id = "js_search")
    @CacheLookup
    public WebElement search_btn;

    //页面url
    private static final String HOME_PAGE_URL = "https://ke.qq.com/";

    //打开首页
    public void openUrl(){
        driver.get(HOME_PAGE_URL);
    }

    public void close(){
        driver.close();
    }

    //构造方法
    public KeqqHomePage(){
        //当前页面,当前对象
        PageFactory.initElements(driver,this);
    }

    //方法(行为)
    /**
     * 选择机构
     */
    public void selectOrg(){
        //选择则机构需要进行什么操作
        select_icon.click();
        organization_item.click();
    }

    /**
     * 输入内容并且搜索 ---> 返回一个结果页面
     */
    public SearchResultPage typeContentAndSearch(String content){
        //输入框输入内容
        search_input.sendKeys(content);
        //点击搜索按钮
        search_btn.click();
        return new SearchResultPage();
    }



}

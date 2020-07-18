package po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/16 21:37.
 */
public class SearchResultPage extends BasePage {

    //logo图标
    @FindBy(css = "a[href = '//lemon.ke.qq.com']")
    @CacheLookup
    public WebElement logo_icon;

    //机构名
    @FindBy(css = "h2[class = 'search-anency-name']")
    @CacheLookup
    public WebElement agency_name_label;

    public SearchResultPage() {
        PageFactory.initElements(driver,this);
    }

    /**
     * 校验搜索结果
     */
    public  void checkSearchResult(){
        System.out.println(agency_name_label.getText());
    }

}
package po;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/16 22:15.
 */
public class Tester {
    public static void main(String[] args) {
        //1.打开腾讯课堂首页,
        KeqqHomePage homePage = new KeqqHomePage();
        homePage.openUrl();
        //2.选择机构
        homePage.selectOrg();
        //3.输入内容并且点击搜索
        SearchResultPage resultPage = homePage.typeContentAndSearch("柠檬班");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //4.检验结果
        resultPage.checkSearchResult();
        //关闭浏览器
        homePage.close();
    }
}

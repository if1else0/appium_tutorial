import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Aaron on 2016/5/3.
 */
public class Demo {
    private AppiumDriver driver;
    private String apkName = "news.apk";
    private String deviceName = "Nexus 5";
    private String platformVersion = "4.4.4";
    private String appActivity = "com.netease.nr.biz.ad.AdActivity";

    @Before
    public void setup() throws MalformedURLException {
        File root = new File(System.getProperty("user.dir"));
        File apk = new File(root, "apk" + File.separator + apkName);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("app", apk.getAbsolutePath());
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("noRest", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void demo() throws InterruptedException {
        Thread.sleep(8000);
        WebElement me = (WebElement) driver.findElements(By.id("com.netease.newsreader.activity:id/biz_navi_tab")).get(4);
        me.click();
        driver.findElement(By.id("com.netease.newsreader.activity:id/biz_pc_main_info_profile_avatar")).click();
        driver.findElement(By.id("com.netease.newsreader.activity:id/login_username")).sendKeys("robotium2016@163.com");
        driver.findElement(By.id("com.netease.newsreader.activity:id/login_password")).click();
        driver.findElement(By.id("com.netease.newsreader.activity:id/login_password")).sendKeys("uiautomator");
        driver.findElement(By.id("com.netease.newsreader.activity:id/do_login_button")).click();
        Thread.sleep(4000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
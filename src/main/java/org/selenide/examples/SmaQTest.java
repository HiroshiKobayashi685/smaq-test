package org.selenide.examples;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class SmaQTest {

	Date date = new Date();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
	String contentName = "testContent"+sdf1.format(date);



	@Test
	public void test() {

		// chromeを利用
		Configuration.browser = WebDriverRunner.CHROME;
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

		// Login
        open("http://p.smaq.party/editor/");
        Selenide.$(By.name("username")).val("selenium");
        Selenide.$(By.name("password")).val("selenium").pressEnter();

        // イベント登録をクリック
        $(By.linkText("イベント登録")).click();
        $("body").shouldHave(text("Regist Content"));

        // イベント登録実行
        Selenide.$(By.name("contentname")).val(contentName);
        WebDriverRunner.getWebDriver().findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/hiroshi5/Downloads/sakura.jpg");
        sleep(3000);
        $(By.xpath("/html/body/div[2]/div/form/div[3]/button")).click();
        sleep(5000);


	}

}

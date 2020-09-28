package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstNextTest {
    WebDriver wd;

    @BeforeMethod
    public void SetUP(){
        wd = new ChromeDriver();
        wd.get("https://www.next.co.il/en");
    }

    @Test
    public void OpenNextSite(){
        System.out.println("Site Next opened!!!");
        wd.findElement(By.name("w")).click();
        wd.findElement(By.name("w")).sendKeys("dress baby" + Keys.ENTER);
        wd.findElement(By.id("sli_search_1")).click();
        String text = wd.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(text.toLowerCase(), "dress baby");
    }
    @AfterMethod
    public void TerarDown(){
        wd.quit();
    }
}

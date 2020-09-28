package com.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstWikiTest {
    WebDriver wd;

    @BeforeMethod
    public void SetUp(){
        wd = new ChromeDriver();
        wd.get("https://www.wikipedia.org/");
    }

    @Test
    public void OpenWikiTest(){
        System.out.println("Site Wiki opened!!!");
        wd.findElement(By.name("search")).click();
        wd.findElement(By.name("search")).sendKeys("History" + Keys.ENTER);
        wd.findElement(By.id("searchInput")).click();
        String text = wd.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(text.toLowerCase(), "history");

    }
    @AfterMethod
    public void TearDown(){
        wd.quit();
    }
}

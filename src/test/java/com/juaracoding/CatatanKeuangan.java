package com.juaracoding;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CatatanKeuangan {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 8 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage","com.chad.financialrecord");
        dc.setCapability("appActivity","com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void tearDown() {
        delay(3);
        driver.quit();
    }

    @Test
    public void testPemasukan() {
        delay(5);

        //test pemasukan gaji
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click();
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Gaji']").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("500000");
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(2);


        //test pemasukan penjualan
        driver.findElementById("com.chad.financialrecord:id/fabMenu").click();
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btnIncome").click();
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("100000");
        driver.findElementByXPath("//android.widget.TextView[@text='Deposito']").click();
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(2);

    }

    @Test
    public void testPengeluaran() {
        delay(5);

        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btnExpense").click();
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Kesehatan']").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("50000");
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(2);

        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btnExpense").click();
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Makanan']").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("100000");
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(2);

        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(2);
        driver.findElementById("com.chad.financialrecord:id/btnExpense").click();
        driver.findElementById("com.chad.financialrecord:id/spCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Pulsa']").click();
        driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("100000");
        driver.findElementById("com.chad.financialrecord:id/btSave").click();
        delay(2);
    }

    // Fitur Cek Saldo
    @Test
    public void testCheckBalance() {
        delay(10);
        String balance = driver.findElementById("com.chad.financialrecord:id/tv_saldo").getText();
        System.out.println("Saldo Saat Ini: " + balance);
        Assert.assertTrue(balance.contains("350000")); //
    }


    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

package com.scraping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.SeleniumUtility;

class Task implements Runnable {

	private String pageUrl;

	public Task(String url) {
		this.pageUrl = url;
	}

	@Override
	public void run() {

		System.out.println("\n===================== Starting Thread: " + Thread.currentThread().getName() + " ======================");
		WebDriver driver = new SeleniumUtility().openChrome(pageUrl);
		App.sleep(2000);

		List<WebElement> recordEles = driver.findElements(By.xpath("//div[@class='result']//a[@class='business-name']"));
		List<String> recordUrlList = recordEles.stream().map(l -> l.getAttribute("href")).collect(Collectors.toList());

		List<Data> dataList = new ArrayList<Data>();

		for (String resultUrl : recordUrlList) {

			driver.get(resultUrl);
			
			new SeleniumUtility().waitForEle(driver, "//*[@id='main-header']", 5);
			WebElement dataEle = driver.findElement(By.xpath("//*[@id='main-header']"));

			String info = dataEle.findElement(By.xpath(".//div[@class='sales-info']//h1")).getText();
			String address = dataEle.findElement(By.xpath(".//*[@class='address']")).getText();
			String phone = dataEle.findElement(By.xpath(".//*[@class='phone']")).getText();

			String website = "";
			try {
				website = dataEle.findElement(By.xpath(".//*[contains(@class,'website-link')]")).getAttribute("href");
			} catch (Exception e) {
			}

			String email = "";
			try {
				email = dataEle.findElement(By.xpath(".//*[@class='email-business']")).getAttribute("href");
				email = email.contains(":") ? email.substring(email.indexOf(":")+1) : email;
			} catch (Exception e) {
			}

			Data data = new Data(info, address, phone, website, email);
			dataList.add(data);
		}

		System.out.println("\n##### Thread: " + Thread.currentThread().getName() + " Size: " + dataList.size() + "\t URL: " + pageUrl + " ######");
		dataList.forEach(i -> {
			System.out.println("\t" + "=> " + i);
		});
		App.finalDataList.addAll(dataList);
		driver.quit();
		System.out.println("Thread Completed");

	}

}

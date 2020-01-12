package com.scraping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.SeleniumUtility;

public class App {

	public static List<Data> finalDataList = new ArrayList<>();

	public static void main(String[] args) {

		String search = "laptop";
		List<String> locations = new ArrayList<>(Arrays.asList("New+York%2C+NY", "Washington%2C+DC", "Los+Angeles%2C+CA", "Boston%2C+MA"));

		searchWithMultipleLocation(search, locations);

	}

	public static void searchWithMultipleLocation(String search, List<String> locations) {

		for (String location : locations) {
			searchWithSingleLocation(search, location);
		}

	}

	public static void searchWithSingleLocation(String search, String location) {

		long start = System.currentTimeMillis();

		Property.MAIN_URL = url(search, location);

		List<String> pageUrls = pagination();

		executeThreads(pageUrls);

		System.out.println("============================ FINAL_DATA_LIST (" + finalDataList.size() + ") ===============================");
		for (int i = 0; i < finalDataList.size(); i++) {
			System.out.println("(" + i + ") " + finalDataList.get(i));
		}

		System.out.println("Total Time: " + (System.currentTimeMillis() - start) + " ms");

	}

	public static List<String> pagination() {

		WebDriver driver = new SeleniumUtility().openChrome(Property.MAIN_URL);
		sleep(2000);
		List<WebElement> linkEles = driver.findElements(Property.BY_PAGINATION_LINKS);
		List<String> urlList = linkEles.stream().map(l -> l.getAttribute("href")).collect(Collectors.toList());
		urlList.forEach(System.out::println);
		driver.quit();
		urlList.add(Property.MAIN_URL);
		return urlList;
	}

	public static void executeThreads(List<String> pageUrls) {
		System.out.println("Starting Executor Service");
		ExecutorService executorService = Executors.newFixedThreadPool(Property.MAX_THREAD_COUNT);
		System.out.println("Executor Service Started");

		for (int i = 0; i < pageUrls.size(); i++) {
			String pageUrl = pageUrls.get(i);
			executorService.submit(new Task(pageUrl));
		}

		System.out.println("Closing Executor Service");
		executorService.shutdown();

		try {
			executorService.awaitTermination(Property.THREAD_MAX_TIME, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Executor Service Closed: " + executorService.isShutdown());

	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String url(String search, String location) {
		String url = "https://www.yellowpages.com/search?search_terms=" + search.trim() + "&geo_location_terms=" + location.trim();
		return url;
	}

}

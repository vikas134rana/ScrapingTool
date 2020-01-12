package com.scraping;

import org.openqa.selenium.By;

public class Property {

	public static String MAIN_URL;
	public static By BY_PAGINATION_LINKS;
	public static long THREAD_MAX_TIME;
	public static int MAX_THREAD_COUNT;
	public static boolean IS_HEADLESS;
	public static String CHROME_DRIVER_PATH;

	private static final String DEFAULT_MAIN_URL = "https://www.yellowpages.com/search?search_terms=laptop&geo_location_terms=Los+Angeles%2C+CA";
	private static final By DEFAULT_BY_PAGINATION_LINKS = By.xpath("//*[@class='pagination']//a[not(@class='next ajax-page')]");
	private static final long DEFAULT_THREAD_MAX_TIME = 15;
	private static final int DEFAULT_MAX_THREAD_COUNT = 5;
	private static final boolean DEFAULT_IS_HEADLESS = false;
	private static final String DEFAULT_CHROME_DRIVER_PATH = "D:\\Soft\\automation\\drivers\\chrome\\79.0\\chromedriver.exe";

	static {
		setDefaultProperties();
	}
	
//	private static Properties prop;

	public static void setDefaultProperties() {
		System.out.println("LOADING DEAFUALT PROPERTY . . .");
		MAIN_URL = DEFAULT_MAIN_URL;
		BY_PAGINATION_LINKS = DEFAULT_BY_PAGINATION_LINKS;
		THREAD_MAX_TIME = DEFAULT_THREAD_MAX_TIME;
		MAX_THREAD_COUNT = DEFAULT_MAX_THREAD_COUNT;
		IS_HEADLESS = DEFAULT_IS_HEADLESS;
		CHROME_DRIVER_PATH = DEFAULT_CHROME_DRIVER_PATH;
		printProperties();
		System.out.println("PROPERTY LOADED");
	}

	private static void printProperties() {
		System.out.println("\t=>" + "MAIN_URL: " + MAIN_URL);
		System.out.println("\t=>" + "BY_PAGINATION_LINKS: " + BY_PAGINATION_LINKS);
		System.out.println("\t=>" + "THREAD_MAX_TIME: " + THREAD_MAX_TIME);
		System.out.println("\t=>" + "MAX_THREADS: " + MAX_THREAD_COUNT);
		System.out.println("\t=>" + "IS_HEADLESS: " + IS_HEADLESS);
		System.out.println("\t=>" + "CHROME_DRIVER_PATH: " + CHROME_DRIVER_PATH);
	}

	/*- public static void setProperty(String propertyFilePath) {
	FileReader reader;
	try {
	
		System.out.println("LOADING PROPERTY . . .");
	
		reader = new FileReader(propertyFilePath);
		prop = new Properties();
		prop.load(reader);
	
		String mainUrlValue = prop.getProperty("mainUrl");
		MAIN_URL = mainUrlValue != null ? mainUrlValue : DEFAULT_MAIN_URL;
	
		String byPaginationLinksValue = prop.getProperty("byPaginationLinks");
		BY_PAGINATION_LINKS = byPaginationLinksValue != null ? By.xpath(byPaginationLinksValue) : DEFAULT_BY_PAGINATION_LINKS;
	
		String byResultDataValue = prop.getProperty("byResultData");
		BY_RESULT_DATA = byResultDataValue != null ? By.xpath(byResultDataValue) : DEFAULT_BY_RESULT_DATA;
	
		String threadMaxTimeValue = prop.getProperty("threadMaxTime");
		THREAD_MAX_TIME = threadMaxTimeValue != null ? Long.parseLong(threadMaxTimeValue) : DEFAULT_THREAD_MAX_TIME;
	
		String maxThreadCountValue = prop.getProperty("maxThreads");
		MAX_THREAD_COUNT = maxThreadCountValue != null ? Integer.parseInt(maxThreadCountValue) : DEFAULT_MAX_THREAD_COUNT;
	
		String isHeadlessValue = prop.getProperty("isHeadless");
		IS_HEADLESS = isHeadlessValue != null ? Boolean.parseBoolean(isHeadlessValue) : DEFAULT_IS_HEADLESS;
	
		if (CHROME_DRIVER_PATH == null) {
			String chromeDriverPathValue = prop.getProperty("chromeDriverPath");
			CHROME_DRIVER_PATH = chromeDriverPathValue != null ? chromeDriverPathValue : DEFAULT_CHROME_DRIVER_PATH;
		}
	
		printProperties();
		System.out.println("PROPERTY LOADED");
	
	} catch (IOException e) {
		e.printStackTrace();
		setDefaultProperties();
	}
	}*/

}

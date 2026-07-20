package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingShadowDOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-root"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		System.out.println(shadowRoot.findElement(By.cssSelector("#shadow-element")).getText());
		
		
		// Nested shadow dom 1
		
		SearchContext innerShadowRoot = shadowRoot.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		System.out.println(innerShadowRoot.findElement(By.cssSelector("#nested-shadow-element")).getText());
		
		
		// Multi Nested Shadow DOM
		SearchContext multiNestedShadowRoot = innerShadowRoot.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		System.out.println(multiNestedShadowRoot.findElement(By.cssSelector("#multi-nested-shadow-element")).getText());
		
		driver.quit();

	}

}

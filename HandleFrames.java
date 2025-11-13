package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		//Frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1); //pass frame as a webelement
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
		driver.switchTo().defaultContent(); //go back to main page from frame
		
		//Frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("something in frame2 input");
		driver.switchTo().defaultContent(); //go back to main page from frame
		
		//Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("something in frame3 input");

		//inner frame -- part of frame 3
		driver.switchTo().frame(0);  //switching to frame using index
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='vd3tt']")).click();
		driver.switchTo().defaultContent();
		
		//Frame 4
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("this is frame 4 input");
		
	}
}

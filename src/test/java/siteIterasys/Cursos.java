// 1 - Pacote
package siteIterasys;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//2 - importar bibliotecas

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


// 3 - Classe
public class Cursos {
	String url;
	WebDriver driver; 
	
	@Before
	public void Iniciar() {
		url = "https://www.iterasys.com.br";
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Coral\\Desktop\\irts01-workshop\\siteIterasys\\src\\main\\resources\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	
	@After 
	public void Finalizar() {
		driver.quit();
		
	}
	
	
	@Test 
	public void ConsultarCurso( ) {
		driver.get(url);
		driver.findElement(By.id("searchtext")).clear(); //clear search box
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("TestLink"));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("comprar")).click();
		
		//validate
		String title = "TestLink";
		String price = "R$ 79,99";
		
		assertEquals(title, driver.findElement(By.className("item-title")).getText());
		assertEquals(price,driver.findElement(By.className("new-price")).getText());
	}
}

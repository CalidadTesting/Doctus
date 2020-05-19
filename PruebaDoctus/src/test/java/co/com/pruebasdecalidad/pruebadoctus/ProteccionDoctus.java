package co.com.pruebasdecalidad.pruebadoctus;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class ProteccionDoctus {
  
	WebDriver driver;
	
	//iniciar_Sesion()
	By barraCorreo = By.id("Email");
	By barraContraseña = By.id("Password");
	By botonIniciarSesion = By.id("btnLogin");
	By resultadoErrorInicio = By.xpath("//*[@id=\"login-form\"]/div[1]/ul/li");
	
	//registrase()
	By linkRegistrase = By.linkText("Regístrate");
	By barraNombre = By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/input");
	By barraApellido = By.xpath("//*[@id=\"register-form\"]/div[1]/div[3]/input");
	By barraCedula = By.xpath("//*[@id=\"register-form\"]/div[1]/div[4]/input");
	By barraCorreoCorporativo = By.xpath("//*[@id=\"email\"]");
	By barraConfirmaCorreo = By.xpath("//*[@id=\"confirmEmail\"]");
	By barraContraseñaRegistro = By.xpath("//*[@id=\"register-form\"]/div[1]/div[7]/input");
	By barraConfirmacontraseñaRegistro = By.xpath("//*[@id=\"register-form\"]/div[1]/div[8]/input");
	By aceptoCondiciones = By.xpath("//*[@id=\"register-form\"]/div[2]/div/label/input");
	By botonEnviar = By.xpath("//*[@id=\"btnLogin\"]");
	By mensajeErrorRegistro = By.className("error-message");
	
	//olvido_Mi_Contrasena()
	By olvidoContraseña = By.xpath("//*[@id=\"login-form\"]/div/div[2]/div/a");
	By barraEmailRecuperacion = By.xpath("//*[@id=\"form\"]/input[2]");
	By botonEnviarRecuperar= By.xpath("//*[@id=\"form\"]/div[3]/input");
	By mensajeRecuperarEmail= By.xpath("//*[@id=\"form\"]/div[2]");
			
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://euno.lms.doctustest.com/");
	  }
	
		
    @Test(priority=0)
    public void iniciar_Sesion() {
    	
    	WebElement ingresa = driver.findElement(barraCorreo);
    	ingresa.clear();
  	  	ingresa.sendKeys("pruebastestingcalidad@gmail.com");
  	  	
  	  	WebElement contraseña = driver.findElement(barraContraseña);
  	  	contraseña.clear();
	  	contraseña.sendKeys("159753");
  	  	
	  	WebElement boton = driver.findElement(botonIniciarSesion);
	  	boton.submit();
	  	
	  	WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultadoErrorInicio));
		
		assertTrue(driver.findElement(resultadoErrorInicio).isDisplayed(),"Usuario o contraseña invalidos");
		
		  	  	
    }
    
    

    @Test(priority=1)
    public void registrase() {
    	
    	WebElement registrar = driver.findElement(linkRegistrase);
    	registrar.click();
    	
    	
    	WebElement nombre = driver.findElement(barraNombre);
  	  	nombre.clear();
	  	nombre.sendKeys("Emilio");
	  	
	  	WebElement apellido = driver.findElement(barraApellido);
  	  	apellido.clear();
	  	apellido.sendKeys("Mendoza");
	  	
	  	WebElement cedula = driver.findElement(barraCedula);
  	  	cedula.clear();
	  	cedula.sendKeys("71895623");
	  	
	  	WebElement correocorporativo = driver.findElement(barraCorreoCorporativo);
	  	correocorporativo.clear();
	  	correocorporativo.sendKeys("pruebastestingcalidad@gmail.com");
	  		  		
		WebElement confirmacorreocorporativo = driver.findElement(barraConfirmaCorreo);
		confirmacorreocorporativo.clear();
		confirmacorreocorporativo.sendKeys("pruebastestingcalidad@gmail.com");
		
		WebElement contraseñaregistro = driver.findElement(barraContraseñaRegistro);
		contraseñaregistro.clear();
		contraseñaregistro.sendKeys("159753");
	  	
		WebElement confirmacontraseñaregistro = driver.findElement(barraConfirmacontraseñaRegistro);
		confirmacontraseñaregistro.clear();
		confirmacontraseñaregistro.sendKeys("159753");
		
		WebElement condiciones = driver.findElement(aceptoCondiciones);
		condiciones.click();
		
		WebElement enviar = driver.findElement(botonEnviar);
		enviar.click();
		
	   	WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mensajeErrorRegistro));
		
		assertTrue(driver.findElement(mensajeErrorRegistro).isDisplayed(),"Lo sentimos, el correo electrónico ingresado no está autorizado para el registro.");
		
		
		  	  	
    }
    
    
    @Test(priority=2)
    public void olvido_Mi_Contrasena() {
    	
    	driver.get("https://euno.lms.doctustest.com/");
    	WebElement ingresa = driver.findElement(olvidoContraseña);
    	ingresa.click();
  	  	
    	WebElement recuraremail = driver.findElement(barraEmailRecuperacion);
    	recuraremail.clear();
    	recuraremail.sendKeys("pruebastestingcalidad@gmail.com");
    	
    	WebElement botonrecuperar = driver.findElement(botonEnviarRecuperar);
    	botonrecuperar.click();
    	
     	WebDriverWait wait = new WebDriverWait(driver,3);
  	  	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mensajeRecuperarEmail)); 
		
		//assertNotEquals(driver.findElement(mensajeRecuperarEmail).isDisplayed(),"Lo sentimos el email ingresado no existe.");
		assertFalse(driver.findElement(mensajeRecuperarEmail).isDisplayed(),"Lo sentimos el email ingresado no existe.");  	  	
    }
 

    @AfterClass
    public void afterClass() throws InterruptedException {
    	Thread.sleep(4000);
    	driver.close();
    	System.out.println("La prueba se ejecutó correctamente!!!");
    }

}

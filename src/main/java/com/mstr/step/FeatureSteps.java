package com.mstr.step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Config.Config;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FeatureSteps 
{
	  @When ("^user opens \"(.*)\" browser$")
	  public void openBrowser(String Browsernm)
	  {
		  if(Browsernm.equalsIgnoreCase("chrome"))
		  {
			  System.out.println("chrome browser");
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\PRAVIN\\Documents\\Selenium");
			  Config.driver=new ChromeDriver();
			  System.out.println("open browser successfully");
		   }else if(Browsernm.equalsIgnoreCase("ie"))
		  {
			 System.out.println("ie browser"); 
			 System.setProperty("webdriver.ie.driver","C:\\Users\\PRAVIN\\Documents\\Selenium");
			 Config.driver=new InternetExplorerDriver();
			 
		  }else if(Browsernm.equalsIgnoreCase("Firefox browser"));
		  {
			  System.out.println("firefox browser");
			  System.setProperty("webdriver.gecko.driver","C:\\Users\\PRAVIN\\Documents\\Selenium");
			  Config.driver=new FirefoxDriver();
			  System.out.println("open firefox brower");
		  }
	  }


	  @And ("^user enters application url \"(.*)\"$")
	  
	  public void EnterApplication(String url)
	  {
		  Config.driver.get(url);
		  System.out.println("enter the application");
	  }
	  
	 @And ("^user waits \"(.*)\" seconds to login screen to be loaded$")
		public void  waittillLoginpageloaded(int seconds) 
	 {
		 Config.driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		  
	 }
	 
	  @And ("^user maximizes chrome  browser$")
		  public void maximizBrowser()
		  {
		  Config.driver.manage().window().maximize();
		  }
		  
    @Then ("^user is on login screen of mercury tours application$")
    public void verifylogin()
    {

		String act_title=Config.driver.getTitle();
		System.out.println("Title of Welcome screen is:"+act_title);
		String exp_title="Welcome: Mercury Tours";
					
	}
    
    @Given ("^user access login screen of mercury tours application$")
    
    	public void verifylogining()
    	{
    	boolean act_flag=Config.driver.findElement(By.xpath("//img[@src='/images/featured_destination.gif']")).isDisplayed();
	    System.out.println("ARUBA image is displayed"+act_flag);
		boolean exp_flag=true;
		//Assert.assertEquals(exp_flag, act_flag);
	    
    	
    }
    @When ("^user enters \"(.*)\" as username$")
    public void enterusername(String username)
    {
    	Config.driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    	
    }
    	
    	
    @And ("^user enters \"(.*)\" as password$")
    public void enterPassword(String passwd)
    {
    	Config.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd);
    }
    	
    @And ("^user clicks on signin button$")
    public void clickonSignin()
    {
    	Config.driver.findElement(By.xpath("//input[@name='login']")).click();
    }
    	
    @Then ("^user is on flight finder screen$")
    public void verifyfinderscreen()
    {
    	boolean act_flag=Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
        System.out.println("flight finder screen is display:"+act_flag);
    	boolean exp_flag=true;
    	//Assert.assertEquals(exp_flag, act_flag);
    }
		  
    @When ("^user clicks on signoff link$")
    public void signofflink()
    {
    	Config.driver.findElement(By.linkText("SIGN-OFF")).click();
    }
		  
    @Then ("^user is on singon screen$")
    public void singonscreen()
    {
    	boolean act_flag2=Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		System.out.println("SignOn image is displayed: "+act_flag2);
		boolean exp_flag2=true;
		//Assert.assertEquals(exp_flag2, act_flag2);
	}
    
}

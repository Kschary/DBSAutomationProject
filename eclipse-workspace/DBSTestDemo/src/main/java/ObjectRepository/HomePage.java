package ObjectRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Properties.TestBase;



public class HomePage extends TestBase{
	
	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"dbsgroup\"]/div[3]/p[3]/a/button")
	WebElement LearnMore;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"sideNav\"]/ul/li[3]/a")
	WebElement singaporebtn;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"flpHeader\"]/header/div/div[2]/ul/li[1]/a")
	WebElement aboutbtn;
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"bodywrapper\"]/div[1]/div[1]/div/ul/li[2]/a")
	WebElement whowewrebtn;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Our Awards & Accolades')]")
	WebElement awardsbtn;


public void LearnMore_Btn() {
	
	LearnMore.click();
}

public void Singapore_Btn() {
	
	singaporebtn.click();
}

public void about_Btn() {
	
	aboutbtn.click();
}


public void Whoweare_Btn() {
	
	whowewrebtn.click();
}

public void Ourawards_Btn() {
	
	awardsbtn.click();
}


public void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + "SearchTestcase_" + System.currentTimeMillis() + ".png" ));
}



public void ExtData() throws IOException {

    
	WebElement table= driver.findElement(By.xpath("//*[@id=\"bodywrapper\"]/div[2]/section/div[1]/div[2]/div/div[5]/table/tbody"));
	
     FileOutputStream fis = new FileOutputStream(new File("/Users/shivakumar/eclipse-workspace/DBSTestDemo/target/TestData.xls"));
       HSSFWorkbook wb = new HSSFWorkbook();
       HSSFSheet sh = wb.createSheet("First Sheet");
       
       List<WebElement> rows = table.findElements(By.tagName("tr"));
       
       int rowcount = rows.size();
       for (int row = 0; row < rowcount; row++) {    
       	List<WebElement> columns_inrow = rows.get(row).findElements(By.tagName("td"));
           int columns_count = columns_inrow.size();
           System.out.println("Number of cells in Row " + row + " are " + columns_count);
           Row ro = sh.createRow(row);
           for (int column = 0; column < columns_count; column++) {

               String celltext = columns_inrow.get(column).getText();
               System.out.println(
                       "Cell Value of row number " + row + " and column number " + column + " Is " + celltext);
               ro.createCell(column).setCellValue(celltext);
           }
           System.out.println("====================================");

       }
       wb.write(fis);
       fis.close();
      
}

public void findNoOfDisplayeImages() throws InterruptedException {
    
    List<WebElement> listImages=driver.findElements(By.xpath("//*[@class=\"mBot-20 col-md-4\"]"));
    System.out.println("Verified Number of Awards are: "+listImages.size());
    
    System.out.println("===========================================");
    

}

	
	public void AwardsData() throws IOException {
		
	     
		List<WebElement> allRows= driver.findElements(By.xpath("//*[@class=\"col-md-8\"]"));
		
		  System.out.println("Award Name" + "\t" + "Caption of the award" +"\n") ;
	// And iterate over them and get all the cells 
	for (WebElement row : allRows) { 
	    List<WebElement> cells = row.findElements(By.tagName("strong"));
	    List<WebElement> cells1 = row.findElements(By.tagName("p")); 
          
	    // Print the contents of each cell
	    for (WebElement cell : cells) {  
	    	   
	           for (WebElement cell1 : cells1) { 
	            
	        	   System.out.println(cell.getText()+ "\t" + cell1.getText());
	
		    }
	
	}
	
}

	}
	
	
}
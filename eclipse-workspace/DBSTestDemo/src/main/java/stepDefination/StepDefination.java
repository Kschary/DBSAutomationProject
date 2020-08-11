package stepDefination;

import ObjectRepository.HomePage;

import Properties.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination extends TestBase {

	
	
	@Given("^user launch the Home page$")
	public void user_launch_the_Home_page() throws Throwable {
	    
		TestBase.initialization();
		Thread.sleep(5000);
	}	
		

	@When("^user enter to home page and click on Learn More button$")
	public void user_enter_to_home_page_and_click_on_Learn_More_button() throws Throwable {
		
		HomePage homepage = new HomePage(driver);
		homepage.LearnMore_Btn();
		
		Thread.sleep(2000);
			
	}

	@Then("^user scroll down and navigate to Singapore on the left panel$")
	public void user_scroll_down_and_navigate_to_Singapore_on_the_left_panel() throws Throwable {
		
		
        HomePage homepage = new HomePage(driver);
        homepage.Singapore_Btn();
        
        Thread.sleep(2000);
	
	}


	@Then("^user read and write the table data into excel sheet$")
	public void user_read_and_write_the_table_data_into_excel_sheet() throws Throwable {
 		
		HomePage homepage = new HomePage(driver);
        homepage.ExtData();

	}

	
	@Then("^user navigate to About in the header tabs$")
	public void user_navigate_to_About_in_the_header_tabs() throws Throwable {
		HomePage homepage = new HomePage(driver);
        homepage.about_Btn();
		
	}

	@Then("^user navigate to Who we are tab$")
	public void user_navigate_to_Who_we_are_tab() throws Throwable {
		HomePage homepage = new HomePage(driver);
        homepage.Whoweare_Btn();
        Thread.sleep(3000);
	}

	@Then("^user navigate to Our Awards and Accolades$")
	public void user_navigate_to_Our_Awards_Accolades() throws Throwable {
		HomePage homepage = new HomePage(driver);
        homepage.Ourawards_Btn();
		
	}

	@Then("^user validate the total number of awards displayed on the page is twenty two$")
	public void user_validate_the_total_number_of_awards_displayed_on_the_page_is_twenty_two() throws Throwable {
		HomePage homepage = new HomePage(driver);
        homepage.findNoOfDisplayeImages();
	}

	@Then("^user validate all the award name and caption of the awards mentioned in the below table and print in the cucumber report in the form of a table$")
	public void user_validate_all_the_award_name_and_caption_of_the_awards_mentioned_in_the_below_table_and_print_in_the_cucumber_report_in_the_form_of_a_table() throws Throwable {
		HomePage homepage = new HomePage(driver);
        homepage.AwardsData();
        driver.quit();
	}	
	
}
	
package com.pom;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class DropDownPage extends BasePage{

	public DropDownPage(WebDriver driver) {
		super(driver);
	}
	
	// locators for check specific drop down product heading
//	@FindBy(xpath = "//h2[normalize-space()='Mac']")
//	WebElement dropDown;
	
	
	
	// specific action method
	
//		public boolean dropDown_Heading() {
//			
//			try {
//				return dropDown.isDisplayed();
//			}catch(Exception e) {
//				return false;
//			}
//		}
	
	/**
	 * To handle the scenario where the sub-category name in the config.properties file 
	   includes extra details (like "Mac (1)"), but the actual heading displayed on the application 
	   is just "Mac," you can adjust your approach by normalizing the string before using it to find 
	   the heading element.
	   
	   NOTE : Normalization -> The normalizeSubCategoryName method removes any text within parentheses (like "(1)") 
	   from the sub-category name. This makes the name match the actual heading displayed on the application.
    **/
	
	
	// Method to normalize sub-category name (remove extra details like "(1)")
    private String normalizeSubCategoryName(String subCategoryName) {
        // Remove anything in parentheses and trim the result
        return subCategoryName.replaceAll("\\(.*\\)", "").trim();
    }
	
	public WebElement getSubCategoryElement(String subCategoryName) {
		// Normalize the sub-category name to match the heading on the application
        String normalizedCategoryName = normalizeSubCategoryName(subCategoryName);
		return driver.findElement(By.xpath("//h2[normalize-space()='" + normalizedCategoryName + "']"));
	}
	
	// action method
	
	public boolean select_SubCategory(String subCategoryName) {
		
		try {
			WebElement subcategoryElement = getSubCategoryElement(subCategoryName);
			subcategoryElement.click();
			return subcategoryElement.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

}

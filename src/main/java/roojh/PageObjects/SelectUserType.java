package roojh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roojh.AbstractComponents.AbstractComponents;

public class SelectUserType extends AbstractComponents {

	WebDriver driver;

	public SelectUserType(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@class='user-card-container'])[1]")
	private WebElement card_DoctorUserType;

	@FindBy(css = "div[class='next-button-center'] button")
	WebElement nextButton;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement checkBox;

	public void clickOnDoctorUserTypeCard() {

		wait_ElementToBeClickable(card_DoctorUserType);
		card_DoctorUserType.click();
	}

	
	public boolean verifyCheckboxIsSelectedOrNot() {
		
		if(checkBox.isSelected()) {
			return true;
		}
		return false;
	}
	
	public void clickOnNextButton() {

		nextButton.click();
	}

}

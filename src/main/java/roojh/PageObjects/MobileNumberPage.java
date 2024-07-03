package roojh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roojh.AbstractComponents.AbstractComponents;

public class MobileNumberPage extends AbstractComponents {

	WebDriver driver;

	public MobileNumberPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".form-control ")
	private WebElement mobileNumberField;

	@FindBy(xpath = "//button[text()='Request Otp']")
	private WebElement requestOTPButton;

	public void enterMobileNumber(String mobileNumber) {

		wait_ElementToBeClickable(mobileNumberField);
		mobileNumberField.sendKeys(mobileNumber);
	}

	public void clickOnRequestOTPButton() {
		requestOTPButton.click();
	}
}

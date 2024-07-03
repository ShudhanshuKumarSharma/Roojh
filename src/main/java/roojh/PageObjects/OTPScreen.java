package roojh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roojh.AbstractComponents.AbstractComponents;

public class OTPScreen extends AbstractComponents {

	WebDriver driver;

	public OTPScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='roojh-input-box'] input")
	private WebElement otpField;

	@FindBy(css = ".next-button-center button")
	WebElement submitOTPButton;

	public void enterOTP(String OTP) {
		wait_ElementToBeClickable(otpField);
		otpField.sendKeys(OTP);

	}

	public void clickSubmitOTPButton() {
		submitOTPButton.click();

	}

}

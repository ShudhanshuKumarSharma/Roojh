package roojh.TestScripts;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import roojh.PageObjects.MobileNumberPage;
import roojh.PageObjects.OTPScreen;
import roojh.TestComponents.BaseTestUtils;
import roojh.TestData.JsonFileReader;

public class LoginFlow extends BaseTestUtils {

	@Test(dataProvider = "dataProvider")
	public void loginToApp(HashMap<String, String> jsonData)
			throws InterruptedException, IOException, GeneralSecurityException {

		String mobileNumber = jsonData.get("mobileNumber");
		String OTP = jsonData.get("OTP");

		selectUserType.clickOnDoctorUserTypeCard();
		selectUserType.verifyCheckboxIsSelectedOrNot();
		selectUserType.clickOnNextButton();

		MobileNumberPage mobileNumberPage = new MobileNumberPage(driver);
		mobileNumberPage.enterMobileNumber(mobileNumber);
		mobileNumberPage.clickOnRequestOTPButton();

		OTPScreen otpScreen = new OTPScreen(driver);
		otpScreen.enterOTP(OTP);
		otpScreen.clickSubmitOTPButton();

	}

	@DataProvider
	public Object[] dataProvider() throws IOException {

		List<HashMap<String, String>> hashmapObjects = JsonFileReader.readJsonData();
		return new Object[] { hashmapObjects.get(0) };
	}

}

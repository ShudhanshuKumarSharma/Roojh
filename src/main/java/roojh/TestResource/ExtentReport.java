package roojh.TestResource;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    public static ExtentReports extentReportObject() {

        String extentfilePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "HTML Extent Report" + File.separator+"extentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentfilePath);
        reporter.config().setDocumentTitle("ROOJH Test Automation Report");
        reporter.config().setReportName("HTML Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setTimeStampFormat("MMM d, yyyy hh:mm:ss a");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);

        extentReports.setSystemInfo("Tester Name", "Shudhanshu Kumar");
        extentReports.setSystemInfo("Organization", "Roojh");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
       

        return extentReports;
    }
}

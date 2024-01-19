package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\user\\seleniumDemo\\Demowebshop-AddToCart\\src\\test\\java\\feature\\addtocart.feature",
    glue = { "steps" },
    plugin = {
        "html:target/Demowebshop_addtocart_report.html",
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"
    }
    // Add tags option if needed: tags = "@yourTag"
)
public class TestNgRunner extends AbstractTestNGCucumberTests {

    // A cucumber runner file is used to build a communication between your feature
    // files and step definition file
    // Whenever we have to run multiple features or multiple steps, then we use
    // Cucumber runner file.
    // Whenever have to generate reports, we will use the cucumber runner file
}



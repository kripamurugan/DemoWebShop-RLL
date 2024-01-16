package runner;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;
import testnglisteners.CustomTestNGListener;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\user\\seleniumDemo\\AddToCart-Demo\\src\\test\\java\\feature\\Addtocart.feature", glue = { "steps" }, 
plugin = {"html:target/Cucumber_addtocart_report.html", "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/" },monochrome = true)

@Listeners(CustomTestNGListener.class)
public class TestRunner{

	// A cucumber runner file is used to build a communication between your feature
	// files and step defination file
	// Whenever we have to run multiple features or multiple steps, then we use
	// Cucumber runner file.
	// Whenever have to generate reports , we will use cucumber runner file

	/*
	 * - cucumber report - Extent report - Cucumber reports in PDF format - HTML
	 * Reports - TestNG Reports
	 * 
	 * Various Cucumber options or properties :
	 * 
	 * features : comma separted paths to feature file. dryRun=true : It will check
	 * if every steps has an step defination method implemented or not glue : comma
	 * separated package names of step def. file plugin = pretty : Tags
	 * 
	 */

}


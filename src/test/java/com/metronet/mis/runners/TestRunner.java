package com.metronet.mis.runners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@ExtendedCucumberOptions(
        jsonReport = "target/81/cucumber.json",
        jsonUsageReport = "target/81/cucumber-usage.json",
        usageReport = true,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        overviewChartsReport = true,
        pdfPageSize = "A4 Landscape",
        toPDF = true,
        outputFolder = "target/81",
        retryCount = 3)

@CucumberOptions
		(
				plugin =
						{
								"html:target/cucumber-html-report.html",
								"json:target/cucumber.json",
								"pretty:target/cucumber-pretty.txt",
								"usage:target/cucumber-usage.json",
								"junit:target/cucumber-pretty.xml"

						},
				features = "src/test/resources/features",
				glue = "com/metronet/mis/step_definitions",
				dryRun = false,
				tags = "@testdata"
		)
@RunWith(Cucumber.class)
public class TestRunner
{
}

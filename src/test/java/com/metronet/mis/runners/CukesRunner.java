package com.metronet.mis.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

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
public class CukesRunner
{
}

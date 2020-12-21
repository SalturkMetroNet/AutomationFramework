package com.metronet.mis.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions
		(
				plugin =
						{
								"json:target/cucumber.json"
						},
				features = "src/test/resources/features",
				glue = "com/metronet/mis/step_definitions"
		)

@RunWith(Cucumber.class)
public class TestRunner
{
}

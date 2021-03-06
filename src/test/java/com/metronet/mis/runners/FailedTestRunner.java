package com.metronet.mis.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Failed Runner Class to run failed tests
 */
@RunWith(Cucumber.class)
@CucumberOptions
        (
                glue = "com/metronet/mis/step_definitions",
                features = "@target/rerun.txt"
        )
public class FailedTestRunner
{
}

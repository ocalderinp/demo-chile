package fligths.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import fligths.utils.TestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/fligths/features",
        glue = {"fligths/steps"},
        tags = {"@Reservas"},
        format = {
                "pretty",
                "html:reports/cucumber-pretty",
                "json:reports/cucumber.json"
        },
        monochrome = true,
        strict = false
)
public class ReservasRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    private TestContext context;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        context = new TestContext();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        this.context.getWebDriverManager().quitDriver();
        testNGCucumberRunner.finish();
    }
}

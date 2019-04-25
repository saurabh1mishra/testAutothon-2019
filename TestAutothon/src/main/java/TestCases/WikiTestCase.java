package TestCases;

import Base.DriverThreadLocal;
import Reporter.HtmlReporter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class WikiTestCase {
    private static HtmlReporter report = null;
    MovieInfo moviesInfo;

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        report = new HtmlReporter(context.getCurrentXmlTest().getName());
        report.setTestSuiteHeader("Test Suite: " + context.getCurrentXmlTest().getName());
        report.addStepRow("MovieInfo##Movie Name##wikiUrl##Wiki Director Name##imdb Director Name##imdb Url##Mode##Device", "warn", false);
    }

    /*@DataProvider(name = "movieInfo", parallel = true)
    public static Iterator<Object[]> moviesNames(ITestContext testContext) {
        if (testContext != null)
            System.getProperties().putAll(testContext.getCurrentXmlTest().getAllParameters());
        ImportData.initData();
        List<Object[]> data = new ArrayList<>();
        ImportData.moviesUrl.forEach((k, v) -> data.add(new Object[]{k, v}));
        return data.iterator();
    }*/

    public abstract void extractDataFromImdb(String movie, String url);

    public abstract void extractDataFromWiki(String movie, String wikiUrl) throws IOException;


    @Test
    public void testCompareDirectorNames() throws IOException {
        String movieName = moviesInfo.getMovieName();
        String wikiUrl = moviesInfo.getWikiUrl();
        extractDataFromImdb(movieName, wikiUrl);
        extractDataFromWiki(movieName, wikiUrl);
        System.out.println(moviesInfo);
        Assert.assertEquals(moviesInfo.getImdbDirectorName(), moviesInfo.getWikiDirectorName());
    }

    @AfterMethod
    public void tearDownMethod() {
        if (moviesInfo.getMode().equalsIgnoreCase("gui") && !moviesInfo.getWikiUrl().equalsIgnoreCase("URL Not Found")) {
            report.addStepRow_movies(moviesInfo.toString(), true);
            DriverThreadLocal.getDriver().quit();
        } else
            report.addStepRow_movies(moviesInfo.toString(), false);
    }

    @AfterSuite
    public void tearDownSuite(ITestContext context) {
        report.finalizeSuiteResult(context);
    }
}

package TestCases;

import Base.Device;
import Base.DriverThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WikiGuiTestCase extends WikiTestCase {

    // @Factory(dataProvider = "movieInfo")
    public WikiGuiTestCase(String movieName, String wikiUrl) {
        this.moviesInfo = new MovieInfo(movieName, wikiUrl);
        Device[] device = {Device.REMOTECHROME,Device.REMOTEFIREFOX,Device.MOBILECHROME};
        Random ran = new Random();
        moviesInfo.setDevice(Device.MOBILECHROME);
        moviesInfo.setMode("GUI");
    }

    @Override
    public void extractDataFromImdb(String movie, String url) {
        if (!url.equalsIgnoreCase("No url found")) {
            WebDriver driver = null;
            try {
                DriverThreadLocal.setDriver(moviesInfo.getDevice().setDriver());
                driver = DriverThreadLocal.getDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            assert driver != null;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);
            WebElement externalLink = driver.findElement(By.xpath("//*[@id='External_links']"));
            focusElement(driver, externalLink);
            externalLink.click();
            WebElement imdbPage = driver.findElement(By.xpath("//a[text() = 'IMDb']//preceding-sibling::a[1]"));
            focusElement(driver, imdbPage);
            imdbPage.click();
            List<WebElement> directorElements = driver.findElements(By.xpath("//*[contains (text(),'Director')]//following-sibling::*"));
            List<String> directorNameResult = new ArrayList<>();
            directorElements.forEach(i -> {
                if (StringUtils.isNotEmpty(i.getText())) {
                    directorNameResult.add(i.getText());
                }
            });
            moviesInfo.setImdbUrl(driver.getCurrentUrl());
            moviesInfo.setImdbDirectorName(directorNameResult.toString());
        } else {
            moviesInfo.setImdbDirectorName("Not Available");
            moviesInfo.setImdbUrl("URL Not Found");
        }
    }

    @Override
    public void extractDataFromWiki(String movie, String wikiUrl) {
        if (!wikiUrl.equalsIgnoreCase("No url found")) {
            WebDriver driver = DriverThreadLocal.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(wikiUrl);
            List<WebElement> directorNames = driver.findElements(By.xpath("//*[contains(text(),'Directed by')]//following-sibling::td/a"));
            List<String> directorNameResult = new ArrayList<>();
            directorNames.forEach(i -> {
                directorNameResult.add(i.getText());
            });
            moviesInfo.setMovieName(movie);
            moviesInfo.setWikiDirectorName(directorNameResult.toString());
        } else {
            moviesInfo.setWikiDirectorName("Not Available");
            moviesInfo.setWikiUrl("URL Not Found");
        }
    }

    private void focusElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void click(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


}

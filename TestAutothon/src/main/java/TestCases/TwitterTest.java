package TestCases;

import Base.Constant;
import Base.Device;
import Base.DriverThreadLocal;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Biographies;
import model.Twitter.TweetData;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.toilelibre.libe.curl.Curl.curl;
import static org.toilelibre.libe.curl.Curl.$;

public class TwitterTest extends TestCase {

    private static org.apache.log4j.Logger log = Logger.getLogger(TwitterTest.class.getName());
    private WebDriver driver;

    @BeforeSuite
    public void getJson() throws IOException {
        String res = $("curl -X GET '" + Constant.TWITTER_ENDPOINT + "?q=" + Constant.PAGE_NAME + "&result_type=recent&count=50&screen_name=" + Constant.PAGE_NAME + "' -H 'Authorization: " + Constant.OAUTH + " -H 'cache-control: no-cache'");
        ObjectMapper objectMapper = new ObjectMapper();
        tweetData = objectMapper.readValue(res, TweetData.class);
        log.info(tweetData.toString());
    }

    @Test
    public void testTwitterAccout() throws IOException {
        DriverThreadLocal.setDriver(Device.WEBCHROME.setDriver());
        this.driver = DriverThreadLocal.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://twitter.com/stepin_forum");
        String name_first = driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[1]/strong")).getText();
        driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[1]")).click();

        String handle_name_first = driver.findElement(By.xpath("//h2[contains(@class,'ProfileHeaderCard-screenname u-inlineBlock')]/a")).getText();
        String following_count_first = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[2]/a/span[3]")).getText();
        String followers_count_first = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[3]/a/span[3]")).getText();

        System.out.println("Name of the first people to follow:" + name_first);
        System.out.println("Handle Name of the first people to follow:" + handle_name_first);
        System.out.println("Following count of the first people:" + following_count_first);
        System.out.println("Followers of the first people:" + followers_count_first);

        Biographies biographiesfirst = new Biographies();
        biographiesfirst.setName(name_first);
        biographiesfirst.setHandel_name(handle_name_first);
        biographiesfirst.setFollower_count(followers_count_first);
        biographiesfirst.setFollowing_count(following_count_first);


        driver.navigate().back();
        //To fetch Second profile details
        String name_second = driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[2]/strong")).getText();

        driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[2]")).click();

        String handle_name_second = driver.findElement(By.xpath("//h2[contains(@class,'ProfileHeaderCard-screenname u-inlineBlock')]/a")).getText();
        String following_count_second = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[2]/a/span[3]")).getText();
        String followers_count_second = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[3]/a/span[3]")).getText();

        System.out.println("Name of the first second to follow:" + name_second);
        System.out.println("Handle Name of the second people to follow:" + handle_name_second);
        System.out.println("Following count of the second people:" + following_count_second);
        System.out.println("Followers of the second people:" + followers_count_second);

        Biographies biographiesSec = new Biographies();
        biographiesSec.setName(name_second);
        biographiesSec.setHandel_name(handle_name_second);
        biographiesSec.setFollower_count(followers_count_second);
        biographiesSec.setFollowing_count(following_count_second);

        driver.navigate().back();
        String name_third = driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[3]/strong")).getText();
        driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[3]")).click();

        String handle_name_third = driver.findElement(By.xpath("//h2[contains(@class,'ProfileHeaderCard-screenname u-inlineBlock')]/a")).getText();
        String following_count_third = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[2]/a/span[3]")).getText();
        String followers_count_third = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[3]/a/span[3]")).getText();

        System.out.println("Name of the first second to follow:" + name_third);
        System.out.println("Handle Name of the second people to follow:" + handle_name_third);
        System.out.println("Following count of the second people:" + following_count_third);
        System.out.println("Followers of the second people:" + followers_count_third);

        Biographies biographiesThird = new Biographies();
        biographiesThird.setName(name_third);
        biographiesThird.setHandel_name(handle_name_third);
        biographiesThird.setFollower_count(followers_count_third);
        biographiesThird.setFollowing_count(following_count_third);
        List<Biographies> biographiesList = new ArrayList<>();
        biographiesList.add(biographiesfirst);
        biographiesList.add(biographiesSec);
        biographiesList.add(biographiesThird);
        finalJson.setBiographies(biographiesList);
        getFilterJsonData();
        generateJson();

        // assert that there are only three biographies
        Assert.assertEquals(biographiesList.size(),3);
        //assert 10 hashtags are present
        int hastags_count = finalJson.getTop_10_hashtag().size();
        Assert.assertEquals(hastags_count,10);


        driver.get("http://cgi-lib.berkeley.edu/ex/fup.html");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + "/userTest.json");
        driver.findElement(By.xpath("//input[@value='Press']")).click();
        String msg = driver.findElement(By.xpath("/html/body/p[1]")).getText();
        Assert.assertEquals(msg, "You've uploaded a file. Your notes on the file were:");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}

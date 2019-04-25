package TestCases;

import Base.Device;
import Base.DriverThreadLocal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Biographies;
import model.Tweet;
import model.example.Statuses;
import model.example.TweetData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.toilelibre.libe.curl.Curl.curl;
import static org.toilelibre.libe.curl.Curl.$;

public class TwitterTest {

    public static TweetData data;
    public static Tweet finalJson= new Tweet();

    public void getJson() throws IOException {
        String res = $(
                "curl -X GET 'https://api.twitter.com/1.1/search/tweets.json?q=stepin_forum&result_type=recent&count=50&screen_name=stepin_forum' -H 'Authorization: OAuth oauth_consumer_key=\"3QHsalYXMeQchpOhwZWc2HfrC\",oauth_token=\"1121272893663584256-RoLkgcGZs7caL56l4YrCu9QZBVbmfD\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1556169937\",oauth_nonce=\"z7fyV9pdBwd\",oauth_version=\"1.0\",oauth_signature=\"qTHTOHbIV%2BCPp7nRs%2BWVWkS%2Fdqw%3D'  -H 'cache-control: no-cache'");
        ObjectMapper objectMapper = new ObjectMapper();
        data = objectMapper.readValue(res, TweetData.class);
    }

    @Test
    public void testTwitterAccout() throws MalformedURLException, IOException {
        WebDriver driver = Device.WEBCHROME.setDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
        //To fetch third profile details
        String name_third = driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[3]/strong")).getText();

        driver.findElement(By.xpath("(//span[contains(@class,'account-group-inner')])[3]")).click();

        String handle_name_third = driver.findElement(By.xpath("//h2[contains(@class,'ProfileHeaderCard-screenname u-inlineBlock')]/a")).getText();
        String following_count_third = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[2]/a/span[3]")).getText();
        String followers_count_third = driver.findElement(By.xpath("//ul[contains(@class,'ProfileNav-list')]/li[3]/a/span[3]")).getText();

        System.out.println("Name of the first second to follow:" + name_third);
        System.out.println("Handle Name of the second people to follow:" + handle_name_third);
        System.out.println("Following count of the second people:" + following_count_third);
        System.out.println("Followers of the second people:" + followers_count_third);
        driver.close();

        Biographies biographiesThird = new Biographies();
        biographiesThird.setName(name_third);
        biographiesThird.setHandel_name(handle_name_third);
        biographiesThird.setFollower_count(followers_count_third);
        biographiesThird.setFollowing_count(following_count_third);
        List<Biographies> biographiesList = new ArrayList<>();
        biographiesList.add(biographiesfirst);
        biographiesList.add(biographiesSec);
        biographiesList.add(biographiesThird);
        finalJson.setProperties(biographiesList);
        getJson();
        getMaxRetweet();
        genrateJson();
        driver = Device.WEBCHROME.setDriver();
        driver.get("http://cgi-lib.berkeley.edu/ex/fup.html");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(".\\user.json");
        driver.findElement(By.xpath("//input[@value='Press']"));
        driver.quit();
    }

    public void genrateJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File fileName=new File(".\\user.json");
        System.out.println(finalJson.toString());
        objectMapper.writeValue(fileName, finalJson);
    }

    public void getMaxRetweet() throws IOException {

        int Max_Count = 0;
        int Highest_like = 0;
        List<Statuses> tweetdata = data.getTweetdata();

        for (Statuses data : tweetdata) {
            if (Max_Count < data.getRetweetCount()) {
                Max_Count = data.getRetweetCount();
            }
        }

        for (Statuses data : tweetdata) {
            if (Highest_like < data.getFavoriteCount()) {
                Highest_like = data.getFavoriteCount();
            }
        }
        System.out.println("Max_Count :"+ Max_Count);
        System.out.println("Highest_like :"+ Highest_like);
        finalJson.setTop_retweet_count(Max_Count);
        finalJson.setTop_like_count(Highest_like);

    }
}

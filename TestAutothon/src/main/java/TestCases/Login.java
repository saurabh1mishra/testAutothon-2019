package TestCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.example.TweetData;

import java.io.IOException;

import static org.toilelibre.libe.curl.Curl.curl;
import static org.toilelibre.libe.curl.Curl.$;

public class Login {

    public static void login() throws IOException {

        String res = $(
                "curl -X GET 'https://api.twitter.com/1.1/search/tweets.json?q=stepin_forum&result_type=recent&count=50&screen_name=stepin_forum' -H 'Authorization: OAuth oauth_consumer_key=\"3QHsalYXMeQchpOhwZWc2HfrC\",oauth_token=\"1121272893663584256-RoLkgcGZs7caL56l4YrCu9QZBVbmfD\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1556169937\",oauth_nonce=\"z7fyV9pdBwd\",oauth_version=\"1.0\",oauth_signature=\"qTHTOHbIV%2BCPp7nRs%2BWVWkS%2Fdqw%3D'  -H 'cache-control: no-cache'");

        ObjectMapper objectMapper = new ObjectMapper();
        TweetData data = objectMapper.readValue(res, TweetData.class);


    }

    public static void main(String[] args) {
        try {
            login();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

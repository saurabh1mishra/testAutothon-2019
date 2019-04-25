package TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiApiTestCase extends WikiTestCase {

    private static final String IMDB_URL = "https://www.omdbapi.com?plot=full&apikey=380de361&t=";


  //  @Factory(dataProvider = "movieInfo")
    public WikiApiTestCase(String movieName, String wikiUrl) {
        moviesInfo = new MovieInfo(movieName, wikiUrl);
        moviesInfo.setMode("API");
    }

    @Override
    public void extractDataFromImdb(String movie, String url) {
        String imdbGetPoint = StringUtils.join(IMDB_URL, movie, "\\");
        moviesInfo.setImdbUrl(imdbGetPoint);
        Response response = RestAssured.given().get(imdbGetPoint);
        String directorName = response.jsonPath().get("Director");
        moviesInfo.setImdbDirectorName(directorName);
    }

    @Override
    public void extractDataFromWiki(String movie, String wikiUrl) throws IOException {
        Document document = Jsoup.connect(wikiUrl).get();
        Elements table = document.select("table[class=infobox vevent]");
        Elements tr = table.select("tr:nth-child(3)");
        Elements td = tr.select("td");
        moviesInfo.setWikiDirectorName(td.text());
    }

}

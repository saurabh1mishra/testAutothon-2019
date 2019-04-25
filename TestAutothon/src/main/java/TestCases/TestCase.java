package TestCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Tweet;
import model.Twitter.Statuses;
import model.Twitter.TweetData;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TestCase {
    private static org.apache.log4j.Logger log = Logger.getLogger(TwitterTest.class.getName());
    static TweetData tweetData;
    public static Tweet finalJson = new Tweet();

    void generateJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File fileName = new File("userTest.json");
        objectMapper.writeValue(fileName, finalJson);
        String jsonInString = objectMapper.writeValueAsString(finalJson);
        log.info("final josn is >>>\n" + jsonInString);
    }

    void getFilterJsonData() {
        int Max_Count = 0;
        int Highest_like = 0;
        Map<String, Integer> hashtagsMap = new HashMap<>();
        List<Statuses> tweetdata = tweetData.getTweetdata();
        for (Statuses data : tweetdata) {
            if (Max_Count < data.getRetweetCount())
                Max_Count = data.getRetweetCount();
            if (Highest_like < data.getFavoriteCount())
                Highest_like = data.getFavoriteCount();
            if (data.getEntities().getHashtags().size() != 0) {
                data.getEntities().getHashtags().forEach(i -> {
                    String hashtagtext = i.getText();
                    if (hashtagsMap.containsKey(hashtagtext)) {
                        hashtagsMap.put(hashtagtext, hashtagsMap.get(hashtagtext) + 1);
                    } else {
                        hashtagsMap.put(hashtagtext, 1);
                    }
                });
            }
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hashtagsMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        log.info("sorted HashTag is " + list);
        Iterator<Map.Entry<String, Integer>> listItretor = list.iterator();
        List<String> Top_10_hashtagList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (listItretor.hasNext())
                Top_10_hashtagList.add(listItretor.next().getKey());
        }
        log.info("Max_Count :" + Max_Count);
        log.info("Highest_like :" + Highest_like);
        log.info("Top 10 hashtag Array is :"+ Top_10_hashtagList);

        finalJson.setTop_10_hashtag(Top_10_hashtagList);
        finalJson.setTop_retweet_count(Max_Count);
        finalJson.setTop_like_count(Highest_like);
    }
}

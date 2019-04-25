package model;


        import lombok.Data;

        import java.util.List;

@Data
public class Tweet {

    int top_retweet_count;
    int top_like_count;
    String[] top_10_hashtag;
    public List<Biographies> properties;

}

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Chris on 2017-02-14.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            tweets.add(tweet);
        }
    }

    public boolean hasTweet(Tweet tweet){
        for (Tweet t: tweets){
            if (t.equals(tweet)) {
                return true;
            }
        }
        return false;
    }
    public void delete(int index){
        tweets.remove(index);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets);
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }
}

package ca.ualberta.cs.lonelytwitter;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Chris on 2017-02-14.
 */

public class TweetListTest1 extends ActivityInstrumentationTestCase2 {

    public TweetListTest1(){
        super(LonelyTwitterActivity.class);
    }
    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);

        try {
            tweets.add(tweet);
            assertTrue(false);
        }
        catch (IllegalArgumentException e){
            assertTrue(tweets.hasTweet(tweet));
        }


    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());

    }
    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(0);

        assertFalse(tweets.hasTweet(tweet));

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Has Tweet Test");
        Tweet falseTweet = new NormalTweet("Does not has tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
        assertFalse(tweets.hasTweet(falseTweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Has Tweet Test");
        Tweet secondTweet = new NormalTweet("Does not has tweet");

        tweets.add(tweet);
        assertEquals(tweets.getCount(), 1);
        tweets.add(secondTweet);
        assertEquals(tweets.getCount(), 2);

    }

    public void testString(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'", "test".startsWith(""));
    }
}

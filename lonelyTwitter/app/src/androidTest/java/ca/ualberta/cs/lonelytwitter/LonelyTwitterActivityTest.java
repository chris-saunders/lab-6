package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

import static ca.ualberta.cs.lonelytwitter.R.id.textView;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    private Solo solo;
    private Activity activity;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo((getInstrumentation()), getActivity());
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }


    public void testStart() throws Exception {
        activity = getActivity();

    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet");

        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test Tweet"));
        solo.clickOnButton("Clear");
        assertFalse(solo.searchText("Test Tweet"));
    }
    public void testClickTweetList(){
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet");

        solo.clickOnButton("Save");
        solo.clickInList(0);
        solo.waitForText("Test Tweet");

        final ListView oldTweetList = getActivity().getOldTweetsList();

        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Test Tweet", tweet.getMessage());

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
        final String string =(String) EditTweetActivity.text.getText();
        assertEquals("Test Tweet", string);




    }
}
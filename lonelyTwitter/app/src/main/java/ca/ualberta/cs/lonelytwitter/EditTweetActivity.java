package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    public static TextView text;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        text = (TextView) findViewById(R.id.textView);
        i = this.getIntent();
        Tweet tweet =(Tweet) i.getSerializableExtra("tweet");
        text.setText(tweet.getMessage());

    }




}

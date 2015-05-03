package nl.saxion.twitter_client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import nl.saxion.twitter_client.model.Model;
import nl.saxion.twitter_client.model.TweetApplication;
import nl.saxion.twitter_client.objects.Tweet;
import nl.saxion.twitter_client.objects.User;
import android.support.v7.app.ActionBarActivity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	
	private Model model;
	private ListView listview;
	private TweetAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TweetApplication app = (TweetApplication) getApplicationContext();
		model = app.getModel();
		
		listview = (ListView) findViewById(R.id.listViewTweet);
		
		
		//Tweet tweet1 = new Tweet("Test1");
		//Tweet tweet2 = new Tweet("Test2");
		
		//Log.d("User", "Test1");
		try {
			String test = readAssetIntoString("searchresult.json");
			JSONObject obj = new JSONObject(test);
			Log.d("Test","Test");
			
			JSONArray tweets = obj.getJSONArray("statuses");
			Log.d("Check", "Test1");
			for(int i = 0; i < tweets.length() ; i ++) {
				JSONObject tweet = tweets.getJSONObject(i);
				JSONObject user = tweet.getJSONObject("user");
				
				
				Log.d("Check", "Test2");
				String tweetText = tweet.getString("text");
				Tweet tweetmsg = new Tweet(tweetText,new User(user.getString("name")));
				model.addTweet(tweetmsg);
			}
			

		} catch (IOException e) {
			Log.d("error", "File not found");
			e.printStackTrace();
		} catch (JSONException e1) {
			Log.d("error", "Iets met jSON");
			e1.printStackTrace();
		}
		
		

		
		adapter = new TweetAdapter(this,R.layout.tweet, model.getTweetList());
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
    private String readAssetIntoString(String filename) throws IOException {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
			InputStream is = getAssets().open(filename, AssetManager.ACCESS_BUFFER);
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
            throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();		
	}
}

package nl.saxion.twitter_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import nl.saxion.twitter_client.model.Model;
import nl.saxion.twitter_client.model.TweetApplication;
import nl.saxion.twitter_client.objects.Tweet;
import nl.saxion.twitter_client.objects.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

public class JSONHandler {
	private Activity mainActivity;
	private Model model;
	
	public JSONHandler(Activity activity) {
		mainActivity = activity;
		
		TweetApplication app = (TweetApplication) mainActivity.getApplicationContext();
		model = app.getModel();
	}
	
	
	public void JSONToTweet(String filename) {
		try {
			String test = readAssetIntoString(filename);
			JSONObject obj = new JSONObject(test);
			Log.d("Test","Test");
			
			JSONArray tweets = obj.getJSONArray("statuses");
			Log.d("Check", "Test1");
			for(int i = 0; i < tweets.length() ; i ++) {
				JSONObject tweet = tweets.getJSONObject(i);
				JSONObject user = tweet.getJSONObject("user");
				//JSONObject name = tweet.getJSONObject("name");
				
				Log.d("Check", "Test2");
				String tweetText = tweet.getString("text");
				Tweet tweetmsg = new Tweet(tweetText,new User(user.getString("screen_name"), user.getString("name"), user.getString("profile_image_url")));
				model.addTweet(tweetmsg);
			}
			

		} catch (IOException e) {
			Log.d("error", "File not found");
			e.printStackTrace();
		} catch (JSONException e1) {
			Log.d("error", "Iets met jSON");
			e1.printStackTrace();
		}
	}
	
    private String readAssetIntoString(String filename) throws IOException {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
			InputStream is = mainActivity.getAssets().open(filename, AssetManager.ACCESS_BUFFER);
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

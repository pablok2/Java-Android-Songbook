package com.example.songbook;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

public class SongActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//get the song that was selected in the prior activity
		Bundle extras = getIntent().getExtras();
		int songValue = extras.getInt("SONG_SELECT");
		String songName = extras.getString("SONG_NAME");
		
		//sets the action bars title to the selected song
		this.setTitle(songName);
		setContentView(R.layout.activity_song);
		
		//setup the textview
		TextView helloTxt = (TextView)findViewById(R.id.textView1);
		
		//get the resource ID by the XML name
		int resId = this.getResources().getIdentifier("song_" + songValue, "string", this.getPackageName());
		helloTxt.setText(resId);
		
		WindowManager.LayoutParams params = getWindow().getAttributes();
		params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		getWindow().setAttributes(params);
	}
}

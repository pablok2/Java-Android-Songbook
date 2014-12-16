package com.example.songbook;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		//int test = preferences.getInt("example_list", 1);
		//if(test == 0)
		this.setTheme(R.style.CustomTheme);
		
		setContentView(R.layout.activity_main);
		
		//make a list adapter for the selection
		ListView list = (ListView)findViewById(R.id.listView1);

		//get the songs names from xml
	    final String[] listArray = this.getResources().getStringArray(R.array.songNameArray);
	    //populate the list using an array adapter
		list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listArray));
		
		//on click method passes an identifier to the next activity bundle
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
						
				//pass the selection to the SongActivity
				Intent intent = new Intent(getApplicationContext(), SongActivity.class);
				//pass in the int corresponding to the selection and deviate from the 0 based system for easy xml
				intent.putExtra("SONG_SELECT", position + 1);
				//pass in the song's name for display in the actionbar
				intent.putExtra("SONG_NAME", listArray[position]);
		        startActivity(intent);				        
			}
		});
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
			Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

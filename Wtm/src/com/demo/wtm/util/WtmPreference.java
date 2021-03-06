package com.demo.wtm.util;

import android.content.Context;
import android.content.SharedPreferences;

public class WtmPreference {
	private Context mContext;
	private SharedPreferences mPreferences; 
	private SharedPreferences.Editor mEditor; 

	public static final String PREF_FILE_NAME = "wtm";

	public WtmPreference(Context context){
		this.mContext = context;
		mPreferences = context.getSharedPreferences(PREF_FILE_NAME, 0);
		mEditor = mPreferences.edit();
	}

	public int getInt(String key, int defaultValue){
		return mPreferences.getInt(key, defaultValue);
	}

	public String getString(String key, String defalutValue){
	return mPreferences.getString(key, defalutValue);
	}

	public boolean getBoolean(String key, boolean defaultValue){
		return mPreferences.getBoolean(key, defaultValue);
	}

	public void putString(String key, String value){
		mEditor.putString(key, value);
	}

	public void putInt(String key, int value){
		mEditor.putInt(key, value);
	}

	public void putBoolean(String key, boolean value){
		mEditor.putBoolean(key, value);
	}

	public void commit(){
		mEditor.commit();
	}
}

package com.demo.wtm.service;

import java.net.MalformedURLException;

import android.content.Context;
import android.util.Log;
import android.widget.ProgressBar;

import com.demo.wtm.MainActivity.UserAuth;
import com.demo.wtm.config.WtmConfig;
import com.microsoft.windowsazure.mobileservices.MobileServiceAuthenticationProvider;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;


public class AuthService {
	
	private MobileServiceClient mClient;
	private Context mContext;
	private ProgressBar mProgressBar;
	private String mAuthtoken;
	private UserAuth mUserAuth;
	
	
	public AuthService(Context context, UserAuth userAuth)
	{
		mContext = context;
		mUserAuth = userAuth;
		
		try {
			// Create the Mobile Service Client instance, using the provided
			// Mobile Service URL and key
			mClient = new MobileServiceClient(
					WtmConfig.REST_SERVICE_APP_URL,
					WtmConfig.REST_SERVICE_APP_KEY,
					mContext);

			// ���� ó�� �߰� �κ�
			authenticate(userAuth);
			
		} catch (MalformedURLException e) {
			Log.i("Auth", "construct error");
		}
	}
	
	public String getAuthtoken()
	{
		return mAuthtoken;
	}
	
	private void authenticate(UserAuth userAuth) {
		// ������ ���� ���� ���� ��� �� ���
		// ���� ���� : http://www.windowsazure.com/en-us/develop/mobile/how-to-guides/register-for-google-authentication/?fb=ko-kr
		// facebook ���� : http://www.windowsazure.com/en-us/develop/mobile/how-to-guides/register-for-facebook-authentication/?fb=ko-kr
		mClient.login(MobileServiceAuthenticationProvider.Facebook,
		        userAuth);
	}
	
}
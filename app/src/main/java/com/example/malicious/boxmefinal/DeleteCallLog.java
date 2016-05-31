package com.example.malicious.boxmefinal;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DeleteCallLog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_delete_call_log);

        Bundle realNumber = getIntent().getExtras();
        Context cont = this.getApplicationContext();
        if(realNumber == null)
            return;
        String phoneNumber = realNumber.getString("phoneNumber");
        ContentResolver resolver = cont.getContentResolver();
        DeleteNumFromCallLog(resolver, phoneNumber);

        finish();

    }

    public void DeleteNumFromCallLog(ContentResolver resolver, String strNum)
    {
        try
        {
            String strUriCalls = "content://call_log/calls";
            Uri UriCalls = Uri.parse(strUriCalls);
            //Cursor c = res.query(UriCalls, null, null, null, null);
            if(null != resolver)
            {
                resolver.delete(UriCalls, CallLog.Calls.NUMBER +"=?",new String[]{ strNum});
            }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    public void removeContactsLogFromPhoneLogs(ContentResolver resolver, String numberTag){

        char[] number=numberTag.toCharArray();
        String n="%";
        for(int i=0;i<number.length;i++)
        {
            n=n+(number[i]+"%");
        }
        String queryString=CallLog.Calls.NUMBER+" LIKE '"+n+"'";
        resolver.delete(CallLog.Calls.CONTENT_URI, queryString, null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delete_call_log, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

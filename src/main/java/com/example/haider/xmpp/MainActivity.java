package com.example.haider.xmpp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import adapter.ChatListAdaptor;


public class MainActivity extends ActionBarActivity {


    ListView list_view;
    public String [] chat_array={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_window);

        list_view = (ListView) findViewById(R.id.chat_list_view);
        list_view.setDivider(null);
        list_view.setAdapter(new ChatListAdaptor(this, chat_array));

        Intent i= new Intent(getApplicationContext(), org.encorelab.sail.android.xmpp.XMPPService.class);
        i.putExtra("host", "192.168.1.6");
        getApplicationContext().startService(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
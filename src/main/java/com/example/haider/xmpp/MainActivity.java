package com.example.haider.xmpp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.koonj.utils.XMPPController;
import com.koonj.utils.XMPPService;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import java.io.IOException;

import adapter.ChatListAdaptor;


public class MainActivity extends ActionBarActivity {

    XMPPController mXMPPController;
    ListView list_view;
    public String [] chat_array={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_window);

        list_view = (ListView) findViewById(R.id.chat_list_view);
        list_view.setDivider(null);
        list_view.setAdapter(new ChatListAdaptor(this, chat_array));


        Intent i= new Intent(getApplicationContext(), XMPPService.class);
            // potentially add data to the intent
        i.putExtra("host", "212.100.239.152");
        getApplicationContext().startService(i);


        /*
        mXMPPController = XMPPController.getInstance();
        mXMPPController.init(this);

        if (mXMPPController.isConnected()) {
            Toast.makeText(getApplicationContext(), "Connected ..... ;)", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Login sent", Toast.LENGTH_SHORT).show();
            try {

                mXMPPController.connect();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XMPPException e) {
                e.printStackTrace();
            } catch (SmackException e) {
                e.printStackTrace();
            }
            connect();

        }
        */


    }



    private void connect()
    {

       // final ProgressDialog dialog = ProgressDialog.show(this, "Connecting...", "Please wait...", false);
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    if (mXMPPController.isConnected())
                        mXMPPController.login("waqar", "12345678");


                    Log.v("Start ", "Sleeping");
                    Log.v("Start ", "Sleeping");
                    Log.v("Start ", "Sleeping");
                    Log.v("Start ", "Sleeping");
                    Log.v("Start ", "Sleeping");

                    Thread.sleep(1 *   // minutes to sleep
                            60 *   // seconds to a minute
                            1000); // milliseconds to a second

                    Log.v("Stop ", "Sleeping");
                    Log.v("Stop ", "Sleeping");
                    Log.v("Stop ", "Sleeping");
                    Log.v("Stop ", "Sleeping");
                    Log.v("Stop ", "Sleeping");
                    Log.v("Stop ", "Sleeping");


                }
                catch (Exception e)
                {
                    // TODO Implement exception
//                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        t.start();
       // dialog.show();


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

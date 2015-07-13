package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.haider.xmpp.R;

/**
 * Created by haider on 6/19/15.
 */
public class ChatListAdaptor extends BaseAdapter {

    String [] chat_array;
    Activity activity;
    LayoutInflater inflater;

    public ChatListAdaptor(Activity activity, String [] chat_array) {
        this.chat_array = chat_array;
        this.activity   = activity;
    }

    @Override
    public int getCount() {
        return this.chat_array.length;
    }

    @Override
    public Object getItem(int position) {
        return  chat_array[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(position % 2 == 0)
            view = inflater.inflate(R.layout.received, null);
        else
            view = inflater.inflate(R.layout.sent, null);


        return view;
    }
}

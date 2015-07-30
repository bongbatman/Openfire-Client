package org.encorelab.sail.android.xmpp;

import org.apache.http.impl.client.DefaultHttpClient;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.StringUtils;

import android.os.AsyncTask;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;


public class XMPPThread extends HandlerThread {
	
	public static final String TAG = "XMPP"; 
	
	private int state;
	
	// the JID of the conference room (MUC) for sending and listening to events
	protected String conferenceJid;
	
	protected String username;
	protected String resource;
	
	protected XMPPConnection xmpp;
	
	private ConnectionConfiguration xmppConfig;

	
	public static class State {
		public static final int DISOCNNECTED = 0;
		public static final int CONNECTED = 1;
		public static final int LOGGED_IN = 2;
	}
	
	public XMPPThread() {
		super("XMPP");
	}
	
	@Override
	public void run() {
        if (Looper.myLooper() == null)
    		Looper.prepare();
		try {
			connect();
		} catch (Exception e) {
			Log.e("XMPP", "Couldn't connect to XMPP server!", e);
		}
		Looper.loop();
	}
	
	public void configure(String host, int port) {
		Log.d(XMPPThread.TAG, "Configuring with host: "+host+", port: "+port+"...");
		if (state != State.DISOCNNECTED)
			throw new NullPointerException("XMPPService must be disconnected before it can be configured!");
		
		xmppConfig = new ConnectionConfiguration(host, port);
//		xmppConfig.setSASLAuthenticationEnabled(true);
		xmppConfig.setSecurityMode(SecurityMode.disabled);
		
		Log.d(XMPPThread.TAG, "Configured.");
	}
	
	public void connect() throws XMPPException {
		Log.d(XMPPThread.TAG, "Connecting...");

        xmppConfig = new ConnectionConfiguration("192.168.1.6", 5222);
        xmppConfig.setSASLAuthenticationEnabled(true);
        xmppConfig.setSecurityMode(SecurityMode.disabled);

		if (xmppConfig == null)
			throw new NullPointerException("XMPPService must be configured before it can connect!");

        class UpdateTask extends AsyncTask<String, String,String> {
            protected String doInBackground(String... urls) {

                try {

                    if (xmpp == null) {

                        xmppConfig = new ConnectionConfiguration("192.168.1.6", 5222);
//                        xmppConfig.setSASLAuthenticationEnabled(true);
  //                      xmppConfig.setSecurityMode(SecurityMode.disabled);

                        xmpp = new XMPPConnection(xmppConfig);
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");
                        Log.d("Connected ...", "Xmpp server reached successfully......");

                    }

                    xmpp.connect();
                    Log.d("Connected ...", "Xmpp connected ....");
                    Log.d("Connected ...", "Xmpp connected ....");
                    Log.d("Connected ...", "Xmpp connected ....");
                    Log.d("Connected ...", "Xmpp connected ....");
                    Log.d("Connected ...", "Xmpp connected ....");
                    Log.d("Connected ...", "Xmpp connected ....");

                    xmpp.login("user5@haider", "12345678", "");
                    Log.d("Connected ...", "Logged in ....");
                    Log.d("Connected ...", "Logged in ....");
                    Log.d("Connected ...", "Logged in ....");
                    Log.d("Connected ...", "Logged in ....");
                    Log.d("Connected ...", "Logged in ....");
                    Log.d("Connected ...", "Logged in ....");
                    Log.d("Connected ...", "Logged in ....");


                    String to = "user4@haider";
                    String text = "hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world ";

                    Log.i("XMPPClient", "Sending text [" + text + "] to [" + to + "]");
                    Message msg = new Message(to, Message.Type.chat);
                    msg.setBody(text);
                    xmpp.sendPacket(msg);
                    Log.i("Sent ", "Message successfull sent");

                    PacketFilter filter = new MessageTypeFilter(Message.Type.chat);
                    xmpp.addPacketListener(new PacketListener() {
                        @Override
                        public void processPacket(Packet packet) {
                            Message message = (Message) packet;
                            if (message.getBody() != null) {
                                String fromName = StringUtils.parseBareAddress(message.getFrom());
                                Log.i("XMPPClient", "Got text [" + message.getBody() + "] from [" + fromName + "]");
                                Log.i("Message From" , message.getFrom().toString());
                                Log.i("Message Body" , message.getBody().toString());


                                // Add the incoming message to the list view
/*
                                mHandler.post(new Runnable() {
                                    public void run() {
                                        setListAdapter();
                                    }
                                });
*/

                            }

                        }
                    }, filter);


                    state = State.LOGGED_IN;


                    username = username;
                    resource = resource;


                } catch (XMPPException ex) {
                    Log.d("Error ...", ex.toString());
                }

                return null;
            }

        }

        new UpdateTask().execute();
		
		state = State.CONNECTED;
		Log.d(XMPPThread.TAG, "Connected.");
	}
	
	public void login(String username, String password, String resource) throws XMPPException {
		Log.d(XMPPThread.TAG, "Logging in as "+username+" with password: '"+password+"', resource: '"+resource+"' ...");
		if (!this.isConnected())
			throw new NullPointerException("XMPPService must be connected in before it can log in!");
		
		xmpp.login(username, password, resource);
		state = State.LOGGED_IN;
		
		this.username = username;
		this.resource = resource;
		
		Log.d(XMPPThread.TAG, "Logged in.");
	}
	
	public void joinConference(String conferenceJid, String resource) {
		Log.d(XMPPThread.TAG, "Joining conference "+conferenceJid+"/"+resource+"...");
		if (!this.isLoggedIn())
			throw new NullPointerException("XMPPService must be logged in before it can join a conference!");
		
		this.conferenceJid = conferenceJid;
		Presence p = new Presence(Presence.Type.available);
		p.setStatus("chat");
		p.setTo(this.conferenceJid+"/"+resource);
		xmpp.sendPacket(p);
		Log.d(XMPPThread.TAG, "Joined conference "+conferenceJid+"/"+resource+".");
	}
	
	// TODO: implement me
	/*public void leaveConference() {
		
	}*/
	
	public void disconnect() {
		xmpp.disconnect();
		state = State.DISOCNNECTED;
	}
	
	public boolean isConnected() {
		return state == State.CONNECTED;
	}
	
	public boolean isLoggedIn() {
		return state == State.LOGGED_IN;
	}
	


}

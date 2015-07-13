package com.koonj.utils;


import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


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

        if(Looper.myLooper() == null) { // check already Looper is associated or not.
            Looper.prepare(); // No Looper is defined So define a new one
        }
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
        xmppConfig.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        xmppConfig.setSendPresence(true);
        xmppConfig.setSecurityMode(SecurityMode.disabled);
        Log.d(XMPPThread.TAG, "Configured.");
    }

    public void connect() throws XMPPException, IOException, SmackException {
        Log.d(XMPPThread.TAG, "Connecting...");


        xmppConfig = new ConnectionConfiguration("10.10.1.26");
        if (xmpp == null)
            xmpp = new XMPPTCPConnection(xmppConfig);

        try {
            xmpp.connect();
        }

        catch (XMPPException e) {
            Log.d(TAG, e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        } catch (SmackException e) {
            Log.d(TAG, e.getMessage());
        }
        if(xmpp.isConnected())
            state = State.CONNECTED;
        else
            state = State.DISOCNNECTED;

        Log.d(XMPPThread.TAG, "Connected.");
    }

    public void login(String username, String password, String resource) throws XMPPException, IOException, SmackException {

        Log.d(XMPPThread.TAG, "Logging in as "+username+" with password: '"+password+"', resource: '"+resource+"' ...");
        if (!this.isConnected())
            throw new NullPointerException("XMPPService must be connected in before it can log in!");

        xmpp.login(username, password, resource);
        state = State.LOGGED_IN;

        this.username = username;
        this.resource = resource;

        Log.d(XMPPThread.TAG, "Logged in.");
    }


    public void disconnect() throws  SmackException{
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
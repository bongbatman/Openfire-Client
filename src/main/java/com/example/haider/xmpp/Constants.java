package com.example.haider.xmpp;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Constants {
    public static String PREFS_NAME = "SMSall-Prefs";
    public static String JSON_LIST_NAME = "lst";
    public static String JSON_DICTIONARY_NAME = "dictionary";
    public static String JSON_INTEGER_NAME = "integer";
    public static String JSON_STRING_NAME = "string";
    public static String JSON_STATUS_NAME = "status";
    public static String INTENT_LOGINCODE="code";
    public static String INTENT_KEY_GROUP_NAME = "group_name";
    public static String INTENT_KEY_GROUP_SENDER_FULL_NAME = "group_sender_full_name";
    public static String INTENT_KEY_GROUP_SENDER_IDENT = "group_sender_ident";
    public static String INTENT_KEY_GROUP_TS = "t_s";
    public static String INTENT_KEY_GROUP_RAW_CONTENT = "raw_content";
    public static String INTENT_KEY_GROUP_IDENT = "group_ident";
    public static String INTENT_KEY_OWNER_NAME = "owner_name";
    public static String INTENT_KEY_OWNER_IDENT = "owner_ident";
    public static String INTENT_KEY_MESSAGE = "content";
    public static String INTENT_KEY_THREAD_ID = "thread_id";
    public static String INTENT_KEY_GROUP_OWNER_STATUS = "group_owner_status";
    public static String INTENT_KEY_MULTIPLE_CONTACTS_LIST = "multiContactsList";
    public static String INTENT_KEY_USER_NAME = "user_name";
    public static String INTENT_KEY_USER_PRESENCE = "user_presence";
    public static String INTENT_KEY_USER_FULL_NAME = "user_full_name";
    public static String INTENT_KEY_USER_PHONE = "phone";
    public static String INTENT_KEY_USER_ROASTER_IDENT = "ident";
    public static String INTENT_KEY_USER_NOTIFICATION = "notification";
    public static String INTENT_KEY_USER_DELIVERED_PACKETID = "packetid";
    public static String INTENT_KEY_USER_ID = "user_id";
    public static String INTENT_CONTACTS_SELECTED = "contacts_selected";
    public static String GCM_SENDER_ID = "51771553365";
    public static String GCM_EXTRA_MESSAGE = "51771553365";
    //	public static String SERVER_URL = "http://10.11.11.105:8081";
    public static String XMPP_SMSall_CHAT_URL = "app.smsall.pk";
    public static String API_SERVER_URL = "https://api.smsall.pk";
    public static String PARAM_GROUP_NAME = "group_name";
    public static String NOT_AVAILABLE = "NA";
    public static Integer Success = 0;
    public static Integer Exception = -1;
    public static Integer LoginFailed = 1;
    public static boolean chatOpen = false;
    public static String USER_NAME = "";
    public static String FULL_NAME = "";
    public static String PHONE_NUMBER = "";
    public static String EMAIL = "";
    public static String NAME = "";
    public static String COUNTRY_CODE = "countryCode";
    public static String connectionTimeOutMessage = "Internet Connection is Slow!";
    public static boolean countrypakistan =true;
    public static String contactsync = "";
    public static String contactsynctime ="";
    public static String hashtagsynctime ="";
    public static String upcominghashtagsynctime ="";

    public static String Ident="";
    public static String GCMregId="";
    public static String notification="notification";
    public static String installation_notification="installation_notification";

    public static String groupinvite="invite_group";
    public static String hashtagdiscussioninvite="invite_hashtag";
    public static String notificationident="";
    public static String notificationfullName="";
    public static String GCM_GROUP_NAME="";
    public static String GCM_GROUP_IDENT="";
    public static String GCM_GROUP_OWNER_IDENT="";
    public static String GCM_GROUP_OWNER_NAME="";
    public static String GCM_GROUP_THREAD_ID="";

    public static String ConnectionNotConnected = "not connected";
    public static String ConnectionConnecting = "connecting";
    public static String ConnectionConnected = "connected";
    public static String HASHTAG = "hashtag";
    public static String FILE_UPLOAD_SERVER = "http://www.smsall.pk/upload/";

    public static String DB_Name = "SMSall_messenger_db";
    public static int DB_Version = 23;
    public static int currentapiVersion = android.os.Build.VERSION.SDK_INT;

    public static boolean isSingleChatAvailable = true;
    public static boolean isGroupChatAvailable = true;
    public static String identcurrentlytalkingto="";
    public static String groupidentcurrentlytalkingto="";
    static File cacheDir;

    public static String Wifi_Error = "Connection Error";
    public static String contacts_added = "Contacts have been added";
    public static String contacts_added_error = "There was some error in Contacts number you selected , Try again";
    public static String contacts_deleted = "Contacts have been deleted from group";
    public static String contacts_added_personal_group = "Contacts have been invited to personal group";
    public static String starred = "User has been starred!!!";
    public static String reported = "Person has been reported";
    public static String group_created = "Group has been created";
    public static String group_joined = "Congratulations You have joined the Group";
    public static String group_left = "You have left the Group";
    public static String group_deleted = "You have Deleted the Group";
    public static String hash_join_error = "You couldnt join the hashtag due to some error";
    public static String group_join_error = "You couldnt join the group due to some error";
    public static String group_delete_error = "You couldnt delete the group due to some error";
    public static String group_leave_error = "You couldnt leave the group due to some error";

    public static String group_create_error = "Group couldnot be created Try again !";
    public static String file_size_error = "File size greater then 400K limit. Select small size file";
    public static String contact_block = "Block this contact";
    public static String wait = "Please wait";
    public static String no_group = "Currently You dont have any group";
    public static String no_group_info_loaded = "Group information could not be loaded!";
    public static String discussion_deleted = "You have deleted the discussion!";
    public static String cant_discussion_deleted = "You couldnt delete the discussion due to some error";
    public static String group_enter_name = "Please enter a group name!";
    public static String group_must_named = "You must name this group!";
    public static String message_discarded = "Message discarded";
    public static String message_sent = "Message sent";
    public static String contacts_direct_added_personal_group = "Contacts added To group";
    public static String app_update = "A newer version is available at www.smsall.pk, Please update";
    public static String exit_app = "Please click BACK again to exit";
    public static String login_error = "An error occurred during login. Please try again later!!";
    public static String hash_friends_notified = "Friends are being notified about this hashtag!";
    public static String international = "You are an international user";
    public static String login_success = "Login success!!";
    public static String invalid_code = "Invalid verification code!";
    public static String phone_no_error = "Please check if your phone number is correct.";
    public static String back_pressed = "Back pressed";
    public static String enter_topic = "Please enter a topic!";
    public static String saved = "Saved";
    public static String no_contacts_selected = "No contacts were selected";
    public static String invitation_sent = "Invitation has been sent";
    public static String invitation_sent_error = "There was some error in sending invitation , Try again";
    public static String text_selected = "Text size selected !";
    public static String wallpaper_selected = "Wallpaper selected !";



    public static boolean isOnline(Context c) {

        if (c != null){
            ConnectivityManager cm =
                    (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            }
        }


        return false;
    }





}

package cordova.plugin;

import android.os.Build;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.apache.cordova.LOG;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class AutoStartPermission extends CordovaPlugin {

    String TAG = "Auto Start Permission Plugin";
    CallbackContext context;

    //String [] permissions = { 'in.btransit.btag.permission.AUTO_START' };

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
           super.initialize(cordova, webView);
    }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        /*LOG.d(TAG, "Inside Xiaomi Auto start");

        //context = callbackContext;
        Context context = cordova.getActivity().getApplicationContext();
        if(action.equals("getPermission"))
        {
           if (Build.BRAND.equalsIgnoreCase("xiaomi")) {
                // Intent intent = new Intent();
                // intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                //context.startActivity(intent);
                this.openNewActivity(context);
            }
            return true;
        }*/
        return false;
    }

    public boolean isAutoStartPermissionAvailable() {
        return AutoStartPermissionHelper.getInstance().isAutoStartPermissionAvailable(cordova.getActivity().getApplicationContext());
    }

    public boolean getAutoStartPermission() {
        return AutoStartPermissionHelper.getInstance().getAutoStartPermission(cordova.getActivity().getApplicationContext());
    }

    private void openNewActivity(Context context) {
           Intent intent = new Intent();
           intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
           
           this.cordova.getActivity().startActivity(intent);
    }

    // public void onRequestPermissionResult(int requestCode, String[] permissions,
    //                                       int[] grantResults) throws JSONException
    // {
    //     PluginResult result;
    //     //This is important if we're using Cordova without using Cordova, but we have the geolocation plugin installed
    //     if(context != null) {
    //         for (int r : grantResults) {
    //             if (r == PackageManager.PERMISSION_DENIED) {
    //                 LOG.d(TAG, "Permission Denied!");
    //                 result = new PluginResult(PluginResult.Status.ILLEGAL_ACCESS_EXCEPTION);
    //                 context.sendPluginResult(result);
    //                 return;
    //             }

    //         }
    //         result = new PluginResult(PluginResult.Status.OK);
    //         context.sendPluginResult(result);
    //     }
    // }

    // public boolean hasPermisssion() {
    //     for(String p : permissions)
    //     {
    //         if(!PermissionHelper.hasPermission(this, p))
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // /*
    //  * We override this so that we can access the permissions variable, which no longer exists in
    //  * the parent class, since we can't initialize it reliably in the constructor!
    //  */

    // public void requestPermissions(int requestCode)
    // {
    //     PermissionHelper.requestPermissions(this, requestCode, permissions);
    // }
}

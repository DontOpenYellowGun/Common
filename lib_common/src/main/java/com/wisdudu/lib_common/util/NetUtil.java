package com.wisdudu.lib_common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.wisdudu.lib_common.base.BaseApplication;

/**
 * 文件描述：网络工具类
 * <p>
 * 作者：   Created by Sven on 2017/7/21 0021.
 */
public enum NetUtil {

    INSTANCE;

    /**
     * 判断网络是否连接
     *
     * @return 是否已连接网络
     */
    public boolean isConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) BaseApplication.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     *
     * @param context
     * @return 是否连接Wi-Fi
     */
    public boolean isWifi(Context context) {
        // 先判断是否连接
        if (!isConnected()) {
            return false;
        }
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null)
            return false;
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }


    /**
     * 打开网络设置界面
     *
     * @param activity
     */
    public void openSetting(Activity activity) {
//        Intent intent = new Intent("/");
        Intent intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
        activity.startActivity(intent);
//        ComponentName cm = new ComponentName("com.android.settings",
//                "com.android.settings.WirelessSettings");
//        intent.setComponent(cm);
//        intent.setAction("android.intent.action.VIEW");
//        activity.startActivityForResult(intent, 0);
    }

    /**
     * 判断GPS是否打开
     *
     * @param context
     * @return
     */
    public boolean isGpsEnabled(Context context) {
        LocationManager alm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (!alm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return false;
        }
        return true;
    }


    /**
     * 获取wifi名称，ssid
     */
    public String getWifiConnectedSsid() {
        WifiInfo mWifiInfo = getConnectionInfo();
        String ssid = null;
        if (mWifiInfo != null && isWifiConnected()) {
            int len = mWifiInfo.getSSID().length();
            if (mWifiInfo.getSSID().startsWith("\"")
                    && mWifiInfo.getSSID().endsWith("\"")) {
                ssid = mWifiInfo.getSSID().substring(1, len - 1);
            } else {
                ssid = mWifiInfo.getSSID();
            }

        }
        return ssid;
    }

    public int getWifiRssi() {
        WifiInfo wifiInfo = getConnectionInfo();
        int level = wifiInfo.getRssi();
        //RSSI就是接受信号强度指示 】
        // 得到的值是一个0到-100的区间值，是一个int型数据，其中0到-50表示信号最好，
        // -50到-70表示信号偏差，小于-70表示最差，有可能连接不上或者掉线，一般Wifi已断则值为-200。
        if (level <= 0 && level >= -50) {
            return 5;
        } else if (level < -50 && level >= -70) {
            return 4;
        } else if (level < -70 && level >= -80) {
            return 3;
        } else if (level < -80 && level >= -100) {
            return 2;
        } else {
            return 1;
        }

    }

//    public int getWifiRssiIcon() {
//        WifiInfo wifiInfo = getConnectionInfo();
//        int level = wifiInfo.getRssi();
//        if (level <= 0 && level >= -50) {
//            return R.drawable.guanli_box_icon_wifi_normal;
//        } else if (level < -50 && level >= -70) {
//            return R.drawable.guanli_box_icon_wifi_normal;
//        } else if (level < -70 && level >= -80) {
//            return R.drawable.guanli_box_icon_wifi_normal;
//        } else if (level < -80 && level >= -100) {
//            return R.drawable.guanli_box_icon_wifi_weak;
//        } else {
//            return R.drawable.guanli_box_icon_wifi_weak;
//        }
//    }

    public String getWifiConnectedBssid() {
        WifiInfo mWifiInfo = getConnectionInfo();
        String bssid = null;
        if (mWifiInfo != null && isWifiConnected()) {
            bssid = mWifiInfo.getBSSID();
        }
        return bssid;
    }

    /**
     * 得到Wifi网络名称
     */
    public String getWifiName(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        assert wifiManager != null;
        String wifiName = wifiManager.getConnectionInfo().getSSID();
        if (wifiName != null) {
            if (!wifiName.contains("unknown ssid") && wifiName.length() > 2) {
                if (wifiName.startsWith("\"") && wifiName.endsWith("\"")) {
                    wifiName = wifiName.subSequence(1, wifiName.length() - 1).toString();
                }
                return wifiName;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    // get the wifi info which is "connected" in wifi-setting
    private WifiInfo getConnectionInfo() {
        WifiManager mWifiManager = (WifiManager) BaseApplication.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        assert mWifiManager != null;
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        return wifiInfo;
    }

    /**
     * 当且仅当已经连接了Wifi类型的网络才返回true,反之返回false.
     */
    public static boolean isConnectedWifi(Context context) {
        NetworkInfo info = getWifiNetworkInfo();
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    private boolean isWifiConnected() {
        NetworkInfo mWiFiNetworkInfo = getWifiNetworkInfo();
        boolean isWifiConnected = false;
        if (mWiFiNetworkInfo != null) {
            isWifiConnected = mWiFiNetworkInfo.isConnected();
        }
        return isWifiConnected;
    }

    private static NetworkInfo getWifiNetworkInfo() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) BaseApplication.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWiFiNetworkInfo;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.stdio.hackedgonative.fucked;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.stdio.hackedgonative.fucked.IOUtils;
import com.stdio.hackedgonative.fucked.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppConfig {
    public static final String PROCESSED_MENU_MESSAGE = "io.gonative.android.AppConfig.processedMenu";
    public static final String PROCESSED_TAB_NAVIGATION_MESSAGE = "io.gonative.android.AppConfig.processedTabNavigation";
    public static final String PROCESSED_WEBVIEW_POOLS_MESSAGE = "io.gonative.android.AppConfig.processedWebViewPools";
    public static final String PROCESSED_SEGMENTED_CONTROL = "io.gonative.android.AppConfig.processedSegmentedControl";
    public static final String PROCESSED_NAVIGATION_TITLES = "io.gonative.android.AppConfig.processedNavigationTitles";
    public static final String PROCESSED_NAVIGATION_LEVELS = "io.gonative.android.AppConfig.processedNavigationLevels";
    private static final String a = AppConfig.class.getName();
    private static AppConfig b = null;
    private Context c;
    private JSONObject d;
    public Exception configError;
    public String initialUrl;
    public String initialHost;
    public String appName;
    public String publicKey;
    public String deviceRegKey;
    private String e;
    private String f;
    private String g;
    public String userAgent;
    public int forceSessionCookieExpiry;
    public ArrayList<Pattern> userAgentRegexes;
    public ArrayList<String> userAgentStrings;
    public boolean disableConfigUpdater;
    public boolean disableEventRecorder;
    public boolean directCameraUploads = true;
    public boolean clearCache;
    public boolean enableWindowOpen;
    public AppConfig.ScreenOrientations forceScreenOrientation;
    public boolean keepScreenOn;
    public Map<String, String> customHeaders;
    public boolean enableWebRTC;
    public List<Pattern> nativeBridgeUrls;
    public boolean pullToRefresh;
    public HashMap<String, JSONArray> menus;
    public boolean showNavigationMenu;
    public List<Pattern> sidebarEnabledRegexes;
    public List<Boolean> sidebarIsEnabled;
    public String userIdRegex;
    public String loginDetectionUrl;
    public ArrayList<Pattern> loginDetectRegexes;
    public ArrayList<JSONObject> loginDetectLocations;
    public ArrayList<Pattern> navStructureLevelsRegex;
    public ArrayList<Integer> navStructureLevels;
    public ArrayList<HashMap<String, Object>> navTitles;
    public String profilePickerJS;
    public ArrayList<Pattern> regexInternalExternal;
    public ArrayList<Boolean> regexIsInternal;
    public HashMap<String, String> redirects;
    public boolean useWebpageTitle;
    public boolean showOfflinePage;
    public ArrayList<JSONObject> segmentedControl;
    public HashMap<String, JSONArray> tabMenus;
    public ArrayList<Pattern> tabMenuRegexes;
    public ArrayList<String> tabMenuIDs;
    public HashMap<String, JSONArray> actions;
    public ArrayList<Pattern> actionRegexes;
    public ArrayList<String> actionIDs;
    public ArrayList<Pattern> ignorePageFinishedRegexes;
    public Integer sidebarBackgroundColor;
    public Integer sidebarForegroundColor;
    public Integer tintColor;
    public Integer tabBarTextColor;
    public Integer tabBarBackgroundColor;
    public Integer tabBarIndicatorColor;
    public String customCSS;
    public double forceViewportWidth;
    public boolean zoomableForceViewport;
    public String androidTheme;
    public Integer actionbarForegroundColor;
    public boolean showActionBar = true;
    public double interactiveDelay;
    public String stringViewport;
    public boolean hideTitleInActionBar;
    public boolean showLogoInActionBar;
    public boolean showRefreshButton;
    public ArrayList<Pattern> navigationTitleImageRegexes;
    public float hideWebviewAlpha;
    public Integer pullToRefreshColor;
    public boolean showSplash;
    public double showSplashMaxTime;
    public double showSplashForceTime;
    public boolean disableAnimations;
    public String searchTemplateUrl;
    public String loginUrl;
    public JSONObject loginConfig;
    public boolean loginIsFirstPage;
    public String signupUrl;
    public JSONObject signupConfig;
    public boolean usesGeolocation = false;
    public boolean downloadToPublicStorage = false;
    public boolean analytics = false;
    public int idsite_test = -2147483648;
    public int idsite_prod = -2147483648;
    public boolean oneSignalEnabled = false;
    public String oneSignalAppId;
    public String oneSignalTagsJsonUrl;
    public boolean oneSignalRequiresUserPrivacyConsent = false;
    public boolean xtremepushEnabled = false;
    public String xtremepushAppKey;
    public String xtremepushGoogleProjectId;
    public boolean cleverPushEnabled = false;
    public String cleverPushChannelId;
    public boolean cleverPushAutoRegister = true;
    public boolean ibmpushEnabled = false;
    public JSONObject ibmpushConfig;
    public boolean facebookEnabled = false;
    public String facebookAppId;
    public String facebookDisplayName;
    public boolean adjustEnabled = false;
    public String adjustAppToken;
    public String adjustEnvironment;
    public String appsFlyerDevKey;
    public boolean appsFlyerEnabled = false;
    public List<Pattern> checkIdentityUrlRegexes;
    public String identityEndpointUrl;
    public JSONArray registrationEndpoints;
    public JSONArray webviewPools;
    public boolean admobEnabled = false;
    public String admobApplicationId;
    public String admobBannerAdUnitId;
    public String admobInterstitialAdUnitId;
    public boolean cardIOEnabled = false;
    public boolean chromecastEnabled = false;
    public String chromecastReceiverAppId;
    public ArrayList<Pattern> showCastButtonRegex = new ArrayList();
    public boolean authEnabled = false;
    public ArrayList<Pattern> authAllowdUrls = new ArrayList();
    public boolean documentScannerEnabled = false;
    public String anylineLicenseKey = null;
    public boolean scanditEnabled = false;
    public String scanditLicenseKey = null;
    public boolean allowZoom = true;
    public boolean interceptHtml = false;
    public String postLoadJavascript;
    private long h = 0L;
    private boolean i = true;
    private boolean j = true;
    private HashMap<String, String> k;
    private ArrayList<Pattern> l;
    private ArrayList<Boolean> m;
    private HashMap<String, JSONArray> n;
    private HashMap<String, JSONArray> o;
    private boolean p;

    public File fileForOTAconfig() {
        return new File(this.c.getFilesDir(), "appConfig.json");
    }

    private AppConfig(Context context) {
        this.c = context;
        InputStream var2 = null;

        try {
            if (this.fileForOTAconfig().exists()) {
                BufferedInputStream var3 = null;

                try {
                    var3 = new BufferedInputStream(new FileInputStream(this.fileForOTAconfig()));
                    ByteArrayOutputStream var4 = new ByteArrayOutputStream();
                    IOUtils.copy(var3, var4);
                    var4.close();
                    this.d = new JSONObject(var4.toString("UTF-8"));
                } catch (Exception var13) {
                    Log.e(a, var13.getMessage(), var13);
                    IOUtils.close(var3);
                }
            }

            if (this.d == null) {
                var2 = context.getAssets().open("appConfig.json");
                ByteArrayOutputStream var18 = new ByteArrayOutputStream();
                IOUtils.copy(var2, var18);
                IOUtils.close(var18);
                this.d = new JSONObject(var18.toString("UTF-8"));
            }

            this.regexInternalExternal = new ArrayList();
            this.regexIsInternal = new ArrayList();
            String var6;
            JSONObject context2;
            JSONObject var19;
            String var20;
            if ((var19 = this.d.optJSONObject("general")) != null) {
                this.initialUrl = optString(var19, "initialUrl");
                this.initialHost = Uri.parse(this.initialUrl).getHost();
                if (this.initialHost.startsWith("www.")) {
                    this.initialHost = this.initialHost.substring(4);
                }

                this.appName = optString(var19, "appName");
                this.e = optString(var19, "forceUserAgent");
                if (this.e != null && !this.e.isEmpty()) {
                    this.userAgent = this.e;
                } else {
                    this.f = optString(var19, "userAgentAdd");
                    if (this.f == null) {
                        this.f = "gonative";
                    }

                    if (this.f.equals("gonative")) {
                        this.f = "GoNativeAndroid/1.0 gonative";
                    }

                    String context1 = (new WebView(context)).getSettings().getUserAgentString();
                    this.userAgent = context1 + " " + this.f;
                }

                this.publicKey = optString(var19, "publicKey");
                this.deviceRegKey = optString(var19, "deviceRegKey");
                this.forceSessionCookieExpiry = var19.optInt("forceSessionCookieExpiry", 0);
                if (this.forceSessionCookieExpiry > 0) {
                    this.interceptHtml = true;
                }

                this.a(var19.optJSONArray("userAgentRegexes"));
                this.disableConfigUpdater = var19.optBoolean("disableConfigUpdater", false);
                this.disableEventRecorder = var19.optBoolean("disableEventRecorder", false);
                this.directCameraUploads = var19.optBoolean("androidDirectCameraUploads", true);
                this.clearCache = var19.optBoolean("androidClearCache", false);
                this.enableWindowOpen = var19.optBoolean("enableWindowOpen", false);
                var20 = optString(var19, "forceScreenOrientation");
                this.forceScreenOrientation = AppConfig.ScreenOrientations.UNSPECIFIED;
                if (var20 != null) {
                    if (var20.equalsIgnoreCase("portrait")) {
                        this.forceScreenOrientation = AppConfig.ScreenOrientations.PORTRAIT;
                    } else if (var20.equalsIgnoreCase("landscape")) {
                        this.forceScreenOrientation = AppConfig.ScreenOrientations.LANDSCAPE;
                    }
                }

                this.keepScreenOn = var19.optBoolean("keepScreenOn", false);
                if ((context2 = var19.optJSONObject("androidCustomHeaders")) == null) {
                    context2 = var19.optJSONObject("customHeaders");
                }

                if (context2 != null) {
                    this.customHeaders = new HashMap();
                    Iterator var5 = context2.keys();

                    while(var5.hasNext()) {
                        var20 = (String)var5.next();
                        var6 = optString(context2, var20);
                        if (var20 != null && var6 != null && !var20.isEmpty() && !var6.isEmpty()) {
                            this.customHeaders.put(var20, var6);
                        }
                    }
                }

                this.postLoadJavascript = optString(var19, "postLoadJavascript");
                this.nativeBridgeUrls = b(var19.opt("nativeBridgeUrls"));
            }

            JSONObject var22;
            JSONObject var23;
            if ((var22 = this.d.optJSONObject("forms")) != null) {
                if ((context2 = var22.optJSONObject("search")) != null && context2.optBoolean("active", false)) {
                    this.searchTemplateUrl = optString(context2, "searchTemplateURL");
                }

                if ((var23 = var22.optJSONObject("loginConfig")) != null && var23.optBoolean("active", false)) {
                    this.loginConfig = var23;
                    this.loginUrl = optString(var23, "interceptUrl");
                    this.loginIsFirstPage = var23.optBoolean("loginIsFirstPage", false);
                }

                if ((var22 = var22.optJSONObject("signupConfig")) != null && var22.optBoolean("active", false)) {
                    this.signupConfig = var22;
                    this.signupUrl = optString(var22, "interceptUrl");
                }
            }

            JSONArray var21;
            String var25;
            JSONObject var27;
            int var31;
            String var32;
            JSONArray var36;
            JSONObject var37;
            if ((context2 = this.d.optJSONObject("navigation")) != null) {
                this.pullToRefresh = context2.optBoolean("androidPullToRefresh");
                var23 = context2.optJSONObject("sidebarNavigation");
                this.c(var23);
                if ((var22 = this.a("navlevels.json")) == null) {
                    var22 = context2.optJSONObject("androidNavigationLevels");
                }

                if (var22 == null) {
                    var22 = context2.optJSONObject("navigationLevels");
                }

                this.b(var22);
                if ((var27 = this.a("navtitles.json")) == null) {
                    var27 = context2.optJSONObject("navigationTitles");
                }

                this.a(var27);
                this.profilePickerJS = optString(context2, "profilePickerJS");
                if ((var19 = context2.optJSONObject("regexInternalExternal")) != null && (var21 = var19.optJSONArray("rules")) != null) {
                    for(var31 = 0; var31 < var21.length(); ++var31) {
                        if ((var23 = var21.optJSONObject(var31)) != null && var23.has("regex") && var23.has("internal")) {
                            var6 = optString(var23, "regex");
                            boolean var7 = var23.optBoolean("internal", true);
                            if (var6 != null) {
                                this.regexInternalExternal.add(Pattern.compile(var6));
                                this.regexIsInternal.add(var7);
                            }
                        }
                    }
                }

                var19 = context2.optJSONObject("tabNavigation");
                this.e(var19);
                var22 = context2.optJSONObject("actionConfig");
                this.f(var22);
                this.showRefreshButton = context2.optBoolean("androidShowRefreshButton", true);
                JSONArray var28 = context2.optJSONArray("ignorePageFinishedRegexes");
                this.ignorePageFinishedRegexes = new ArrayList();
                if (var28 != null) {
                    for(int var33 = 0; var33 < var28.length(); ++var33) {
                        if (!var28.isNull(var33) && (var32 = var28.optString(var33)) != null) {
                            try {
                                Pattern var24 = Pattern.compile(var32);
                                this.ignorePageFinishedRegexes.add(var24);
                            } catch (PatternSyntaxException var12) {
                                Log.e(a, "Error parsing regex " + var32, var12);
                            }
                        }
                    }
                }

                if ((var36 = context2.optJSONArray("redirects")) != null) {
                    this.redirects = new HashMap(var36.length());

                    for(int var34 = 0; var34 < var36.length(); ++var34) {
                        var25 = Utils.optString(var36.optJSONObject(var34), "from");
                        var20 = Utils.optString(var36.optJSONObject(var34), "to");
                        if (var25 != null && var20 != null) {
                            this.redirects.put(var25, var20);
                        }
                    }
                } else {
                    this.redirects = null;
                }

                var37 = context2.optJSONObject("segmentedControl");
                this.d(var37);
                this.showOfflinePage = context2.optBoolean("androidShowOfflinePage", true);
            }

            var23 = this.d.optJSONObject("styling");
            this.customCSS = optString(var23, "customCSS");
            if (this.customCSS != null && !this.customCSS.isEmpty()) {
                this.interceptHtml = true;
            }

            this.forceViewportWidth = var23.optDouble("forceViewportWidth", 0.0D / 0.0);
            if (!Double.isNaN(this.forceViewportWidth)) {
                this.interceptHtml = true;
            }

            this.zoomableForceViewport = var23.optBoolean("zoomableForceViewport", false);
            this.showActionBar = var23.optBoolean("showActionBar", true);
            this.androidTheme = optString(var23, "androidTheme");
            var20 = optString(var23, "androidSidebarBackgroundColor");
            this.sidebarBackgroundColor = Utils.parseColor(var20);
            var6 = optString(var23, "androidSidebarForegroundColor");
            this.sidebarForegroundColor = Utils.parseColor(var6);
            var25 = optString(var23, "androidTintColor");
            this.tintColor = Utils.parseColor(var25);
            this.tabBarBackgroundColor = Utils.parseColor(optString(var23, "androidTabBarBackgroundColor"));
            this.tabBarTextColor = Utils.parseColor(optString(var23, "androidTabBarTextColor"));
            this.tabBarIndicatorColor = Utils.parseColor(optString(var23, "androidTabBarIndicatorColor"));
            this.interactiveDelay = var23.optDouble("transitionInteractiveDelayMax", 0.0D / 0.0);
            this.hideTitleInActionBar = var23.optBoolean("androidHideTitleInActionBar", false);
            this.showLogoInActionBar = var23.optBoolean("androidShowLogoInActionBar", this.hideTitleInActionBar);
            var25 = optString(var23, "androidActionBarForegroundColor");
            this.actionbarForegroundColor = Utils.parseColor(var25);
            if (this.actionbarForegroundColor == null) {
                if (this.androidTheme != null && this.androidTheme.equalsIgnoreCase("light")) {
                    this.actionbarForegroundColor = -16777216;
                } else {
                    this.actionbarForegroundColor = -1;
                }
            }

            this.a(var23.opt("navigationTitleImage"));
            this.hideWebviewAlpha = (float)var23.optDouble("hideWebviewAlpha", 0.0D);
            this.pullToRefreshColor = Utils.parseColor(optString(var23, "androidPullToRefreshColor"));
            this.showSplash = var23.optBoolean("androidShowSplash", false);
            this.showSplashMaxTime = var23.optDouble("androidShowSplashMaxTime", 1.5D);
            this.showSplashForceTime = var23.optDouble("androidShowSplashForceTime", 0.0D / 0.0);
            this.disableAnimations = var23.optBoolean("disableAnimations", false);
            if ((var22 = this.d.optJSONObject("permissions")) != null) {
                this.usesGeolocation = var22.optBoolean("usesGeolocation", false);
                this.downloadToPublicStorage = var22.optBoolean("androidDownloadToPublicStorage", false);
                this.enableWebRTC = var22.optBoolean("enableWebRTC", false);
            }

            if ((var23 = this.d.optJSONObject("services")) != null) {
                if ((var27 = var23.optJSONObject("analytics")) != null && var27.optBoolean("active", false)) {
                    this.idsite_test = var27.optInt("idsite_test", -2147483648);
                    this.idsite_prod = var27.optInt("idsite_prod", -2147483648);
                    if (this.idsite_test != -2147483648 && this.idsite_prod != -2147483648) {
                        this.analytics = true;
                    } else {
                        Log.w(a, "Analytics requires idsite_test and idsite_prod");
                        this.analytics = false;
                    }
                }

                if ((var37 = var23.optJSONObject("oneSignal")) != null && var37.optBoolean("active")) {
                    this.oneSignalAppId = optString(var37, "applicationId");
                    this.oneSignalEnabled = this.oneSignalAppId != null;
                    this.oneSignalTagsJsonUrl = optString(var37, "tagsJsonUrl");
                    this.oneSignalRequiresUserPrivacyConsent = var37.optBoolean("requiresUserPrivacyConsent");
                }

                if ((var19 = var23.optJSONObject("xtremepushAndroid")) == null) {
                    var19 = var23.optJSONObject("xtremepush");
                }

                if (var19 != null && var19.optBoolean("active")) {
                    this.xtremepushAppKey = optString(var19, "appKey");
                    this.xtremepushEnabled = this.xtremepushAppKey != null;
                    this.xtremepushGoogleProjectId = optString(var19, "googleProjectId");
                }

                if ((var22 = var23.optJSONObject("cleverpush")) != null && var22.optBoolean("active")) {
                    this.cleverPushEnabled = true;
                    this.cleverPushChannelId = optString(var22, "channelId");
                    this.cleverPushAutoRegister = var22.optBoolean("autoRegister", true);
                }

                if ((context2 = var23.optJSONObject("ibmpushAndroid")) == null) {
                    context2 = var23.optJSONObject("ibmpush");
                }

                if (context2 != null && context2.optBoolean("active")) {
                    this.ibmpushEnabled = true;
                    this.ibmpushConfig = context2;
                }

                if ((context2 = var23.optJSONObject("facebook")) != null && context2.optBoolean("active")) {
                    this.facebookAppId = optString(context2, "appId");
                    this.facebookDisplayName = optString(context2, "displayName");
                    this.facebookEnabled = this.facebookAppId != null;
                }

                if ((context2 = var23.optJSONObject("adjust")) != null && context2.optBoolean("active")) {
                    this.adjustEnabled = true;
                    this.adjustAppToken = optString(context2, "appToken");
                    this.adjustEnvironment = optString(context2, "environment");
                }

                if ((context2 = var23.optJSONObject("appsflyer")) != null && context2.optBoolean("active")) {
                    this.appsFlyerEnabled = true;
                    this.appsFlyerDevKey = optString(context2, "devKey");
                }

                if ((context2 = var23.optJSONObject("identity")) != null && context2.optBoolean("active")) {
                    LinkedList var35 = new LinkedList();
                    this.checkIdentityUrlRegexes = var35;
                    Object var40;
                    if ((var40 = context2.opt("checkIdentityUrl")) != null && var40 instanceof String) {
                        Pattern var41 = Pattern.compile((String)var40);
                        var35.add(var41);
                    } else if (var40 != null && var40 instanceof JSONArray) {
                        var36 = (JSONArray)var40;

                        for(var31 = 0; var31 < var36.length(); ++var31) {
                            if ((var32 = var36.optString(var31)) != null && !var32.isEmpty()) {
                                Pattern var39 = Pattern.compile(var32);
                                var35.add(var39);
                            }
                        }
                    }

                    this.identityEndpointUrl = optString(context2, "identityEndpointUrl");
                }

                if ((var19 = var23.optJSONObject("registration")) != null && var19.optBoolean("active")) {
                    this.registrationEndpoints = var19.optJSONArray("endpoints");
                }

                if ((var22 = var23.optJSONObject("admobAndroid")) != null && var22.optBoolean("active") && (var6 = optString(var22, "applicationId")) != null && !var6.isEmpty()) {
                    this.admobEnabled = true;
                    this.admobBannerAdUnitId = optString(var22, "bannerAdUnitId");
                    if (this.admobBannerAdUnitId != null && this.admobBannerAdUnitId.isEmpty()) {
                        this.admobBannerAdUnitId = null;
                    }

                    this.admobInterstitialAdUnitId = optString(var22, "interstitialAdUnitId");
                    if (this.admobInterstitialAdUnitId != null && this.admobInterstitialAdUnitId.isEmpty()) {
                        this.admobInterstitialAdUnitId = null;
                    }
                }

                if ((var27 = var23.optJSONObject("cardIO")) != null && var27.optBoolean("active")) {
                    this.cardIOEnabled = true;
                }

                Object var42;
                if ((var22 = var23.optJSONObject("auth")) != null && var22.optBoolean("active")) {
                    this.authEnabled = true;
                    if ((var42 = var22.opt("allowdUrls")) instanceof String) {
                        this.authAllowdUrls.add(Pattern.compile((String)var42));
                    } else if (var42 instanceof JSONArray) {
                        JSONArray var43 = (JSONArray)var42;

                        for(int context3 = 0; context3 < var43.length(); ++context3) {
                            if ((var25 = var43.optString(context3)) != null) {
                                this.authAllowdUrls.add(Pattern.compile(var25));
                            }
                        }
                    }
                }

                if ((var37 = var23.optJSONObject("chromecast")) != null && var37.optBoolean("active")) {
                    this.chromecastEnabled = true;
                    this.chromecastReceiverAppId = optString(var37, "receiverAppId");
                }

                if (this.chromecastEnabled) {
                    this.showCastButtonRegex = new ArrayList();
                    if ((var42 = var37.opt("showCastButtonRegex")) instanceof String) {
                        Pattern context4 = Pattern.compile((String)var42);
                        this.showCastButtonRegex.add(context4);
                    } else if (var42 instanceof JSONArray) {
                        JSONArray context5 = (JSONArray)var42;

                        for(int var38 = 0; var38 < context5.length(); ++var38) {
                            if ((var20 = context5.optString(var38)) != null) {
                                this.showCastButtonRegex.add(Pattern.compile(var20));
                            }
                        }
                    } else {
                        this.showCastButtonRegex.add(Pattern.compile(".*"));
                    }
                }

                if ((var37 = var23.optJSONObject("documentScanner")) != null && var37.optBoolean("active")) {
                    this.documentScannerEnabled = true;
                    this.anylineLicenseKey = optString(var37, "androidAnylineLicenseKey");
                    if (this.anylineLicenseKey == null) {
                        this.anylineLicenseKey = optString(var37, "anylineLicenseKey");
                    }
                }

                if ((context2 = var23.optJSONObject("scandit")) != null && context2.optBoolean("active")) {
                    this.scanditLicenseKey = optString(context2, "androidLicenseKey");
                    if (this.scanditLicenseKey == null) {
                        this.scanditLicenseKey = optString(context2, "licenseKey");
                    }

                    if (this.scanditLicenseKey != null) {
                        this.scanditEnabled = true;
                    }
                }
            }

            if ((var27 = this.d.optJSONObject("performance")) != null) {
                var21 = var27.optJSONArray("webviewPools");
                if (var21 != null) {
                    this.webviewPools = var21;
                    LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedWebViewPools"));
                }
            }

            this.allowZoom = this.d.optBoolean("allowZoom", true);
        } catch (Exception var14) {
            Log.e(a, var14.getMessage(), var14);
            this.configError = var14;
        } finally {
            IOUtils.close((Closeable)null);
            IOUtils.close(var2);
        }

        this.b();
    }

    private void a(JSONObject var1) {
        this.navTitles = null;
        if (var1 != null && var1.optBoolean("active")) {
            this.navTitles = new ArrayList();
            JSONArray var8;
            if ((var8 = var1.optJSONArray("titles")) != null) {
                for(int var2 = 0; var2 < var8.length(); ++var2) {
                    JSONObject var3;
                    String var4;
                    if ((var3 = var8.optJSONObject(var2)) != null && (var4 = optString(var3, "regex")) != null) {
                        try {
                            HashMap var5 = new HashMap();
                            Pattern var10 = Pattern.compile(var4);
                            var5.put("regex", var10);
                            var4 = optString(var3, "title");
                            String var6 = optString(var3, "urlRegex");
                            int var9 = var3.optInt("urlChompWords", -1);
                            if (var4 != null) {
                                var5.put("title", var4);
                            }

                            if (var6 != null) {
                                var10 = Pattern.compile(var6);
                                var5.put("urlRegex", var10);
                            }

                            if (var9 >= 0) {
                                var5.put("urlChompWords", var9);
                            }

                            this.navTitles.add(var5);
                        } catch (PatternSyntaxException var7) {
                            Log.e(a, var7.getMessage(), var7);
                        }
                    }
                }
            }
        }

        LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedNavigationTitles"));
    }

    private void b(JSONObject var1) {
        this.navStructureLevels = null;
        this.navStructureLevelsRegex = null;
        if (var1 != null && var1.optBoolean("active")) {
            this.navStructureLevelsRegex = new ArrayList();
            this.navStructureLevels = new ArrayList();
            JSONArray var5;
            if ((var5 = var1.optJSONArray("levels")) != null) {
                for(int var2 = 0; var2 < var5.length(); ++var2) {
                    JSONObject var3;
                    if ((var3 = var5.optJSONObject(var2)) != null) {
                        String var4 = optString(var3, "regex");
                        int var6 = var3.optInt("level", -1);
                        if (var4 != null && var6 != -1) {
                            this.navStructureLevelsRegex.add(Pattern.compile(var4));
                            this.navStructureLevels.add(var6);
                        }
                    }
                }
            }
        }

        LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedNavigationLevels"));
    }

    private void c(JSONObject var1) {
        if (var1 != null) {
            this.menus = new HashMap();
            this.loginDetectRegexes = new ArrayList();
            this.loginDetectLocations = new ArrayList();
            int var2 = 0;
            JSONArray var3;
            if ((var3 = var1.optJSONArray("menus")) != null) {
                for(int var4 = 0; var4 < var3.length(); ++var4) {
                    JSONObject var5;
                    if ((var5 = var3.optJSONObject(var4)) != null && var5.optBoolean("active", false)) {
                        ++var2;
                        String var6 = optString(var5, "name");
                        JSONArray var7 = var5.optJSONArray("items");
                        if (var6 != null && var7 != null) {
                            this.menus.put(var6, var7);
                            if (var6.equals("default")) {
                                this.showNavigationMenu = true;
                            }
                        }
                    }
                }
            }

            LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedMenu"));
            this.userIdRegex = optString(var1, "userIdRegex");
            JSONObject var14 = var1.optJSONObject("menuSelectionConfig");
            if ((var2 > 1 || this.loginIsFirstPage) && var14 != null) {
                this.loginDetectionUrl = optString(var14, "testURL");
                JSONArray var15;
                if ((var15 = var14.optJSONArray("redirectLocations")) != null) {
                    for(int var17 = 0; var17 < var15.length(); ++var17) {
                        String var11;
                        JSONObject var19;
                        if ((var19 = var15.optJSONObject(var17)) != null && (var11 = optString(var19, "regex")) != null) {
                            this.loginDetectRegexes.add(Pattern.compile(var11));
                            this.loginDetectLocations.add(var19);
                        }
                    }
                }
            }

            this.sidebarEnabledRegexes = new ArrayList();
            this.sidebarIsEnabled = new ArrayList();
            Object var16;
            if ((var16 = var1.opt("sidebarEnabledRegex")) != null) {
                if (var16 instanceof String) {
                    try {
                        this.sidebarEnabledRegexes.add(Pattern.compile((String)var16));
                        this.sidebarIsEnabled.add(true);
                        return;
                    } catch (PatternSyntaxException var8) {
                        Log.e(a, "Invalid regex for sidebarEnabledRegex", var8);
                        return;
                    }
                }

                if (var16 instanceof JSONArray) {
                    JSONArray var18 = (JSONArray)var16;

                    for(int var20 = 0; var20 < var18.length(); ++var20) {
                        Object var12;
                        if ((var12 = var18.opt(var20)) != null) {
                            String var10 = null;
                            Boolean var13 = true;
                            if (var12 instanceof String) {
                                var10 = (String)var12;
                            } else if (var12 instanceof JSONObject) {
                                var10 = optString((JSONObject)var12, "regex");
                                var13 = ((JSONObject)var12).optBoolean("value", true);
                            }

                            if (var10 != null) {
                                try {
                                    this.sidebarEnabledRegexes.add(Pattern.compile(var10));
                                    this.sidebarIsEnabled.add(var13);
                                } catch (PatternSyntaxException var9) {
                                    Log.e(a, "Invalid regex in sidebarEnabledRegex", var9);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public void setSidebarNavigation(Object items) {
        if (items != null) {
            if (items instanceof Boolean) {
                this.showNavigationMenu = (Boolean)items;
            } else if (items instanceof JSONArray) {
                ArrayList var2 = new ArrayList(Arrays.asList("default", "loggedIn"));
                int var3;
                if (this.loginDetectLocations != null) {
                    for(var3 = 0; var3 < this.loginDetectLocations.size(); ++var3) {
                        String var4;
                        if ((var4 = optString((JSONObject)this.loginDetectLocations.get(var3), "status")) != null) {
                            var2.add(var4);
                        }
                    }
                }

                this.menus = new HashMap();

                for(var3 = 0; var3 < var2.size(); ++var3) {
                    this.menus.put((String) var2.get(var3), (JSONArray)items);
                }
            }

            LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedMenu"));
        }
    }

    public void setNavigationTitles(JSONObject navigationTitles, boolean persist) {
        if (navigationTitles != null) {
            this.a(navigationTitles);
            if (persist) {
                this.a(navigationTitles, "navtitles.json");
                return;
            }
        } else {
            if ((navigationTitles = this.d.optJSONObject("navigation")) != null) {
                this.a(navigationTitles.optJSONObject("navigationTitles"));
            } else {
                this.a((JSONObject)null);
            }

            if (persist) {
                this.b("navtitles.json");
            }
        }

    }

    public void setNavigationLevels(JSONObject navigationLevels, boolean persist) {
        if (navigationLevels != null) {
            this.b(navigationLevels);
            if (persist) {
                this.a(navigationLevels, "navlevels.json");
                return;
            }
        } else {
            JSONObject var3;
            if ((var3 = (navigationLevels = this.d.optJSONObject("navigation")).optJSONObject("androidNaviationLevels")) == null) {
                var3 = navigationLevels.optJSONObject("navigationLevels");
            }

            this.b(var3);
            if (persist) {
                this.b("navlevels.json");
            }
        }

    }

    private void d(JSONObject var1) {
        if (var1 != null) {
            this.segmentedControl = new ArrayList();
            JSONArray var4 = var1.optJSONArray("items");

            for(int var2 = 0; var2 < var4.length(); ++var2) {
                JSONObject var3;
                if ((var3 = var4.optJSONObject(var2)) != null) {
                    this.segmentedControl.add(var3);
                }
            }

            LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedSegmentedControl"));
        }
    }

    private void e(JSONObject var1) {
        if (var1 != null) {
            this.tabMenus = new HashMap();
            this.tabMenuIDs = new ArrayList();
            this.tabMenuRegexes = new ArrayList();
            if (var1.optBoolean("active")) {
                JSONArray var2;
                if ((var2 = var1.optJSONArray("tabMenus")) != null) {
                    for(int var3 = 0; var3 < var2.length(); ++var3) {
                        JSONObject var4;
                        if ((var4 = var2.optJSONObject(var3)) != null) {
                            String var5 = optString(var4, "id");
                            JSONArray var6 = var4.optJSONArray("items");
                            if (var5 != null && var6 != null) {
                                this.tabMenus.put(var5, var6);
                            }
                        }
                    }
                }

                JSONArray var10;
                if ((var10 = var1.optJSONArray("tabSelectionConfig")) != null) {
                    for(int var11 = 0; var11 < var10.length(); ++var11) {
                        JSONObject var12;
                        if ((var12 = var10.optJSONObject(var11)) != null) {
                            String var13 = optString(var12, "regex");
                            String var8 = optString(var12, "id");
                            if (var13 != null && var8 != null) {
                                try {
                                    Pattern var9 = Pattern.compile(var13);
                                    this.tabMenuRegexes.add(var9);
                                    this.tabMenuIDs.add(var8);
                                } catch (PatternSyntaxException var7) {
                                    Log.w(a, "Problem with tabSelectionConfig pattern. " + var7.getMessage());
                                }
                            }
                        }
                    }
                }

                LocalBroadcastManager.getInstance(this.c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedTabNavigation"));
            }
        }
    }

    private void f(JSONObject var1) {
        if (var1 != null) {
            this.actions = new HashMap();
            this.actionIDs = new ArrayList();
            this.actionRegexes = new ArrayList();
            if (var1.optBoolean("active")) {
                JSONArray var2;
                if ((var2 = var1.optJSONArray("actions")) != null) {
                    for(int var3 = 0; var3 < var2.length(); ++var3) {
                        JSONObject var4;
                        if ((var4 = var2.optJSONObject(var3)) != null) {
                            String var5 = optString(var4, "id");
                            JSONArray var6 = var4.optJSONArray("items");
                            if (var5 != null && var6 != null) {
                                this.actions.put(var5, var6);
                            }
                        }
                    }
                }

                JSONArray var10;
                if ((var10 = var1.optJSONArray("actionSelection")) != null) {
                    for(int var11 = 0; var11 < var10.length(); ++var11) {
                        JSONObject var12;
                        if ((var12 = var10.optJSONObject(var11)) != null) {
                            String var13 = optString(var12, "regex");
                            String var8 = optString(var12, "id");
                            if (var13 != null && var8 != null) {
                                try {
                                    Pattern var9 = Pattern.compile(var13);
                                    this.actionRegexes.add(var9);
                                    this.actionIDs.add(var8);
                                } catch (PatternSyntaxException var7) {
                                    Log.w(a, "Problem with actionSelection pattern. " + var7.getMessage());
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private void a(JSONArray var1) {
        if (var1 != null) {
            this.userAgentRegexes = new ArrayList(var1.length());
            this.userAgentStrings = new ArrayList(var1.length());

            for(int var2 = 0; var2 < var1.length(); ++var2) {
                JSONObject var3;
                if ((var3 = var1.optJSONObject(var2)) != null) {
                    String var4 = optString(var3, "regex");
                    String var6 = optString(var3, "userAgent");
                    if (var4 != null && var6 != null) {
                        try {
                            Pattern var7 = Pattern.compile(var4);
                            this.userAgentRegexes.add(var7);
                            this.userAgentStrings.add(var6);
                            this.interceptHtml = true;
                        } catch (PatternSyntaxException var5) {
                            Log.e(a, "Syntax error with user agent regex", var5);
                        }
                    }
                }
            }

        }
    }

    private void a(Object var1) {
        if (var1 != null) {
            if (!(var1 instanceof Boolean)) {
                this.navigationTitleImageRegexes = new ArrayList();
                if (var1 instanceof JSONArray) {
                    JSONArray var5 = (JSONArray)var1;

                    for(int var2 = 0; var2 < var5.length(); ++var2) {
                        String var3;
                        if ((var3 = var5.optString(var2)) != null) {
                            try {
                                this.navigationTitleImageRegexes.add(Pattern.compile(var3));
                            } catch (PatternSyntaxException var4) {
                                Log.e(a, "Problem with navigation title image regex: " + var4.getMessage(), var4);
                            }
                        }
                    }
                }

            }
        }
    }

    public String userAgentForUrl(String url) {
        if (url == null) {
            url = "";
        }

        if (this.userAgentRegexes != null) {
            for(int var2 = 0; var2 < this.userAgentRegexes.size(); ++var2) {
                if (((Pattern)this.userAgentRegexes.get(var2)).matcher(url).matches()) {
                    return (String)this.userAgentStrings.get(var2);
                }
            }
        }

        return this.userAgent;
    }

    public boolean shouldShowNavigationTitleImageForUrl(String url) {
        this.b();
        if (url != null && this.navigationTitleImageRegexes != null) {
            Iterator var2 = this.navigationTitleImageRegexes.iterator();

            do {
                if (!var2.hasNext()) {
                    return false;
                }
            } while(!((Pattern)var2.next()).matcher(url).matches());

            return true;
        } else {
            return this.showLogoInActionBar;
        }
    }

    public boolean shouldShowSidebarForUrl(String url) {
        if (this.sidebarEnabledRegexes != null && !this.sidebarEnabledRegexes.isEmpty()) {
            if (url == null) {
                url = "";
            }

            for(int var2 = 0; var2 < this.sidebarEnabledRegexes.size(); ++var2) {
                if (((Pattern)this.sidebarEnabledRegexes.get(var2)).matcher(url).matches()) {
                    return (Boolean)this.sidebarIsEnabled.get(var2);
                }
            }

            return false;
        } else {
            return true;
        }
    }

    private void a(JSONObject var1, String var2) {
        try {
            BufferedWriter var3;
            (var3 = new BufferedWriter(new FileWriter(this.c(var2)))).write(var1.toString(4));
            var3.close();
        } catch (Exception var4) {
            Log.e(a, "Error writing to file " + var2, var4);
            this.b(var2);
        }
    }

    private JSONObject a(String var1) {
        File var2 = this.c(var1);

        try {
            FileInputStream var6;
            byte[] var3 = new byte[(var6 = new FileInputStream(var2)).available()];
            var6.read(var3);
            var6.close();
            String var7 = new String(var3, "UTF-8");
            return new JSONObject(var7);
        } catch (FileNotFoundException var4) {
            return null;
        } catch (Exception var5) {
            Log.e(a, "Error reading " + var1, var5);
            this.b(var1);
            return null;
        }
    }

    private void b(String var1) {
        this.c(var1).delete();
    }

    private File c(String var1) {
        File var2;
        (var2 = new File(this.c.getFilesDir(), "gonative-config")).mkdirs();
        return new File(var2, var1);
    }

    public static synchronized AppConfig getInstance(Context context) {
        if (b == null) {
            b = new AppConfig(context.getApplicationContext());
        }

        return b;
    }

    public void setWebviewDefaultUserAgent(String ua) {
        this.g = ua;
        if (this.e == null && this.f != null) {
            this.userAgent = this.g + " " + this.f;
        }

    }

    private Map<String, Object> a() {
        HashMap var1;
        (var1 = new HashMap()).put("platform", "android");
        if (this.publicKey != null) {
            var1.put("publicKey", this.publicKey);
        }

        if (this.deviceRegKey != null) {
            var1.put("deviceRegKey", this.deviceRegKey);
        }

        String var2 = this.c.getPackageName();
        var1.put("appId", var2);
        PackageManager var3 = this.c.getPackageManager();

        try {
            PackageInfo var4 = var3.getPackageInfo(this.c.getPackageName(), 0);
            var1.put("appVersion", var4.versionName);
            var1.put("appVersionCode", var4.versionCode);
        } catch (NameNotFoundException var6) {
        }

        boolean var9 = 0 != (this.c.getApplicationInfo().flags & 2);
        var1.put("isDebuggable", var9);
        if ((var2 = var3.getInstallerPackageName(var2)) == null) {
            var2 = "none";
        }

        var1.put("installer", var2);
        var1.put("language", Locale.getDefault().getLanguage());
        var1.put("os", "Android");
        var1.put("osVersion", VERSION.RELEASE);
        var1.put("model", Build.MANUFACTURER + " " + Build.MODEL);
        var1.put("hardware", Build.FINGERPRINT);
        var1.put("timeZone", TimeZone.getDefault().getID());
        var1.put("initialUrl", this.initialUrl);
        var1.put("oneSignalEnabled", this.oneSignalEnabled);
        var1.put("isLicensed", this.i);
        HashMap var7;
        (var7 = new HashMap()).put("onesignal", this.oneSignalEnabled);
        var7.put("xtremepush", this.xtremepushEnabled);
        var7.put("cleverpush", this.cleverPushEnabled);
        var7.put("facebook", this.facebookEnabled);
        var7.put("adjust", this.adjustEnabled);
        var7.put("admob", this.admobEnabled);
        var7.put("cardIO", this.cardIOEnabled);
        var7.put("chromecast", this.chromecastEnabled);
        var7.put("auth", this.authEnabled);
        var7.put("documentScanner", this.documentScannerEnabled);
        var7.put("scandit", this.scanditEnabled);
        var1.put("activeServices", var7);
        (var7 = new HashMap()).put("io.gonative.android.CardScanner", d("io.gonative.android.CardScanner"));
        var7.put("io.gonative.android.CastManager", d("io.gonative.android.CastManager"));
        var7.put("io.gonative.android.Authentication", d("io.gonative.android.Authentication"));
        var7.put("io.gonative.android.ScanditBarcodeScannerActivity", d("io.gonative.android.ScanditBarcodeScannerActivity"));
        var7.put("io.gonative.android.downloadmanager.DownloadsActivity", d("io.gonative.android.downloadmanager.DownloadsActivity"));
        var7.put("io.gonative.android.documentscanner.ScanDocumentActivity", d("io.gonative.android.documentscanner.ScanDocumentActivity"));
        var7.put("io.gonative.android.SharingUtils", d("io.gonative.android.SharingUtils"));
        var1.put("gonativeClasses", var7);

        try {
            Class var8;
            if ((var8 = Class.forName("io.gonative.android.LeanWebView").getSuperclass()) != null) {
                var1.put("webviewParentClass", var8.getName());
            }
        } catch (ClassNotFoundException var5) {
        }

        return var1;
    }

    private static boolean d(String var0) {
        try {
            Class.forName(var0);
            return true;
        } catch (ClassNotFoundException var1) {
            return false;
        }
    }

    private void b() {
        if (!this.i || this.h <= 0L || SystemClock.elapsedRealtime() - this.h >= 1800000L) {
            if (this.i || this.h <= 0L || SystemClock.elapsedRealtime() - this.h >= 60000L) {
                (new AppConfig.a((byte)0)).execute(new Void[0]);
            }
        }
    }

    public static String optString(JSONObject json, String key) {
        return json.isNull(key) ? null : json.optString(key, (String)null);
    }

    private static List<Pattern> b(Object var0) {
        ArrayList var1 = new ArrayList();
        if (var0 instanceof String) {
            String var6 = (String)var0;

            try {
                Pattern var2 = Pattern.compile(var6);
                var1.add(var2);
            } catch (Exception var5) {
            }
        } else if (var0 instanceof JSONArray) {
            JSONArray var7 = (JSONArray)var0;

            for(int var8 = 0; var8 < var7.length(); ++var8) {
                try {
                    Object var3;
                    if ((var3 = var7.get(var8)) instanceof String) {
                        String var9;
                        Pattern var10 = Pattern.compile(var9 = (String)var3);
                        var1.add(var10);
                    }
                } catch (Exception var4) {
                }
            }
        }

        return var1;
    }

    private class a extends AsyncTask<Void, Void, JSONObject> {
        private a(byte b) {
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            return null;
        }

        private JSONObject a() {
            AppConfig.this.h = SystemClock.elapsedRealtime();

            try {
                JSONObject var1 = new JSONObject(AppConfig.this.a());
                byte[] var2 = new byte[]{-21, 41, 13, -62, 113, 29, -7, 48, 26, -97, 4, 125, -107, 4, -80, 115, 26, -127, 22, 50, -39, -33, 96, -105, 25, -46, 123, -62, -90, 109, -33, 58, 71, -100, -107, 56, -20, -16, -5, 116};
                byte[] var3 = new byte[]{-125, 93, 121, -78, 2, 39, -42, 31, 118, -10, 103, 24, -5, 119, -43, 93, 125, -18, 120, 83, -83, -74, 22, -14, 55, -69, 20, -19, -54, 4, -68, 95, 41, -17, -16, 91, -124, -107, -104, 31};
                byte[] var4 = new byte[40];

                for(int var5 = 0; var5 < 40; ++var5) {
                    var4[var5] = (byte)(var2[var5] ^ var3[var5]);
                }

                HttpURLConnection var8;
                (var8 = (HttpURLConnection)(new URL(new String(var4, Charset.forName("US-ASCII")))).openConnection()).setRequestMethod("POST");
                var8.setRequestProperty("Content-Type", "application/json");
                var8.setDoOutput(true);
                OutputStreamWriter var10;
                (var10 = new OutputStreamWriter(var8.getOutputStream(), "UTF-8")).write(var1.toString());
                var10.close();
                var8.connect();
                if (var8.getResponseCode() != 200) {
                    throw new Exception("Non-200 response");
                } else {
                    ByteArrayOutputStream var7;
                    if (var8.getContentLength() > 0) {
                        var7 = new ByteArrayOutputStream(var8.getContentLength());
                    } else {
                        var7 = new ByteArrayOutputStream();
                    }

                    BufferedInputStream var9;
                    IOUtils.copy(var9 = new BufferedInputStream(var8.getInputStream()), var7);
                    var9.close();
                    var7.close();
                    return new JSONObject(var7.toString("UTF-8"));
                }
            } catch (Exception var6) {
                return null;
            }
        }
    }

    public static enum ScreenOrientations {
        UNSPECIFIED,
        PORTRAIT,
        LANDSCAPE;

        private ScreenOrientations() {
        }
    }
}

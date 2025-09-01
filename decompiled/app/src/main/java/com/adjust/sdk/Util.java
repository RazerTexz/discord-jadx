package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import b.d.b.a.outline;
import com.adjust.sdk.GooglePlayServicesClient;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    /* renamed from: com.adjust.sdk.Util$1, reason: invalid class name */
    public static class AnonymousClass1 implements Callable<Object> {
        public final /* synthetic */ Context val$context;

        public AnonymousClass1(Context context) {
            this.val$context = context;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            try {
                return Reflection.getAdvertisingInfoObject(this.val$context);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* renamed from: com.adjust.sdk.Util$2, reason: invalid class name */
    public static class AnonymousClass2 implements Callable<String> {
        public final /* synthetic */ Object val$advertisingInfoObject;
        public final /* synthetic */ Context val$context;

        public AnonymousClass2(Context context, Object obj) {
            this.val$context = context;
            this.val$advertisingInfoObject = obj;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ String call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public String call2() {
            return Reflection.getPlayAdId(this.val$context, this.val$advertisingInfoObject);
        }
    }

    /* renamed from: com.adjust.sdk.Util$3, reason: invalid class name */
    public static class AnonymousClass3 implements Callable<Boolean> {
        public final /* synthetic */ Object val$advertisingInfoObject;
        public final /* synthetic */ Context val$context;

        public AnonymousClass3(Context context, Object obj) {
            this.val$context = context;
            this.val$advertisingInfoObject = obj;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Reflection.isPlayTrackingEnabled(this.val$context, this.val$advertisingInfoObject);
        }
    }

    /* renamed from: com.adjust.sdk.Util$4, reason: invalid class name */
    public static class AnonymousClass4 extends AsyncTask<Object, Void, Void> {
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Object[] objArr) {
            return doInBackground2(objArr);
        }

        @Override // android.os.AsyncTask
        /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Object... objArr) {
            ((Runnable) objArr[0]).run();
            return null;
        }
    }

    /* renamed from: com.adjust.sdk.Util$5, reason: invalid class name */
    public static class AnonymousClass5 extends AsyncTask<Context, Void, String> {
        public final /* synthetic */ OnDeviceIdsRead val$onDeviceIdRead;

        public AnonymousClass5(OnDeviceIdsRead onDeviceIdsRead) {
            this.val$onDeviceIdRead = onDeviceIdsRead;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ String doInBackground(Context[] contextArr) {
            return doInBackground2(contextArr);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(String str) {
            onPostExecute2(str);
        }

        /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public String doInBackground2(Context... contextArr) {
            ILogger logger = AdjustFactory.getLogger();
            String strAccess$000 = Util.access$000(contextArr[0]);
            logger.debug(outline.w("GoogleAdId read ", strAccess$000), new Object[0]);
            return strAccess$000;
        }

        /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(String str) {
            AdjustFactory.getLogger();
            this.val$onDeviceIdRead.onGoogleAdIdRead(str);
        }
    }

    public static /* synthetic */ String access$000(Context context) {
        return getGoogleAdId(context);
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e.getMessage());
            return false;
        }
    }

    public static String convertToHex(byte[] bArr) {
        return formatString(outline.B(outline.U("%0"), bArr.length << 1, "x"), new BigInteger(1, bArr));
    }

    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static boolean equalEnum(Enum r0, Enum r1) {
        return equalObject(r0, r1);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalLong(Long l, Long l2) {
        return equalObject(l, l2);
    }

    public static boolean equalObject(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : obj.equals(obj2);
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalsDouble(Double d, Double d2) {
        return (d == null || d2 == null) ? d == null && d2 == null : Double.doubleToLongBits(d.doubleValue()) == Double.doubleToLongBits(d2.doubleValue());
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Object getAdvertisingInfoObject(Context context, long j) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new AnonymousClass1(context), j);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    public static int getConnectivityType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            getLogger().warn("Couldn't read connectivity type (%s)", e.getMessage());
        }
        if (connectivityManager == null) {
            return -1;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            return connectivityManager.getActiveNetworkInfo().getType();
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return -1;
        }
        if (networkCapabilities.hasTransport(1)) {
            return 1;
        }
        if (networkCapabilities.hasTransport(0)) {
            return 0;
        }
        if (networkCapabilities.hasTransport(3)) {
            return 3;
        }
        if (networkCapabilities.hasTransport(4)) {
            return 4;
        }
        if (networkCapabilities.hasTransport(2)) {
            return 2;
        }
        if (i < 26) {
            return -1;
        }
        if (networkCapabilities.hasTransport(5)) {
            return 5;
        }
        return (i >= 27 && networkCapabilities.hasTransport(6)) ? 6 : -1;
    }

    public static String getCpuAbi() {
        return null;
    }

    public static String getFireAdvertisingId(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void getGoogleAdId(Context context, OnDeviceIdsRead onDeviceIdsRead) {
        ILogger logger = AdjustFactory.getLogger();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            logger.debug("GoogleAdId being read in the foreground", new Object[0]);
            new AnonymousClass5(onDeviceIdsRead).execute(context);
        } else {
            logger.debug("GoogleAdId being read in the background", new Object[0]);
            String googleAdId = getGoogleAdId(context);
            logger.debug(outline.w("GoogleAdId read ", googleAdId), new Object[0]);
            onDeviceIdsRead.onGoogleAdIdRead(googleAdId);
        }
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales;
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && (locales = configuration.getLocales()) != null && !locales.isEmpty()) {
            return locales.get(0);
        }
        if (i < 24) {
            return configuration.locale;
        }
        return null;
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String getMacAddress(Context context) {
        return MacAddressUtil.getMacAddress(context);
    }

    public static String getMcc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(0, 3);
            }
            AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
            return null;
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
            return null;
        }
    }

    public static String getMnc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(3);
            }
            AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
            return null;
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mnc", new Object[0]);
            return null;
        }
    }

    public static int getNetworkType(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
            getLogger().warn("Couldn't read network type (%s)", e.getMessage());
            return -1;
        }
    }

    public static String getPlayAdId(Context context, Object obj, long j) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new AnonymousClass2(context, obj), j);
    }

    public static String getReasonString(String str, Throwable th) {
        return th != null ? formatString("%s: %s", str, th) : formatString("%s", str);
    }

    public static String getRootCause(Exception exc) {
        if (!hasRootCause(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        int iIndexOf = string.indexOf("Caused by:");
        return string.substring(iIndexOf, string.indexOf("\n", iIndexOf));
    }

    private static String getSdkPrefix(String str) {
        String[] strArrSplit;
        if (str != null && str.contains("@") && (strArrSplit = str.split("@")) != null && strArrSplit.length == 2) {
            return strArrSplit[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] strArrSplit;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (strArrSplit = sdkPrefix.split("\\d+", 2)) == null || strArrSplit.length == 0) {
            return null;
        }
        return strArrSplit[0];
    }

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    public static String[] getSupportedAbis() {
        return Build.SUPPORTED_ABIS;
    }

    public static long getWaitingTime(int i, BackoffStrategy backoffStrategy) {
        if (i < backoffStrategy.minRetries) {
            return 0L;
        }
        return (long) (Math.min(((long) Math.pow(2.0d, i - r0)) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait) * randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange));
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String hash(String str, String str2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes(Constants.ENCODING);
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int hashBoolean(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public static int hashEnum(Enum r0) {
        if (r0 == null) {
            return 0;
        }
        return r0.hashCode();
    }

    public static int hashLong(Long l) {
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public static int hashObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static int hashString(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public static Boolean isPlayTrackingEnabled(Context context, Object obj, long j) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new AnonymousClass3(context, obj), j);
    }

    public static boolean isUrlFilteredOut(Uri uri) {
        String string;
        return uri == null || (string = uri.toString()) == null || string.length() == 0 || string.matches(Constants.FB_AUTH_REGEX);
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        if (str == null) {
            getLogger().error("%s parameter %s is missing", str3, str2);
            return false;
        }
        if (!str.equals("")) {
            return true;
        }
        getLogger().error("%s parameter %s is empty", str3, str2);
        return false;
    }

    public static String md5(String str) {
        return hash(str, Constants.MD5);
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap map3 = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String str2 = (String) map3.put(entry.getKey(), entry.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", entry.getKey(), str2, str, entry.getValue());
            }
        }
        return map3;
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return !Pattern.compile("\\s").matcher(str).find() ? str : formatString("'%s'", str);
    }

    private static double randomInRange(double d, double d2) {
        return (new Random().nextDouble() * (d2 - d)) + d;
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z2) {
        try {
            return getField.get(str, z2);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return z2;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i) {
        try {
            return getField.get(str, i);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return i;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j) {
        try {
            return getField.get(str, j);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T readObject(Context context, String str, String str2, Class<T> cls) throws IOException {
        T t;
        ?? OpenFileInput;
        T tCast = null;
        try {
            OpenFileInput = context.openFileInput(str);
            try {
                ?? bufferedInputStream = new BufferedInputStream(OpenFileInput);
                try {
                    OpenFileInput = new ObjectInputStream(bufferedInputStream);
                    try {
                        tCast = cls.cast(OpenFileInput.readObject());
                        getLogger().debug("Read %s: %s", str2, tCast);
                    } catch (ClassCastException e) {
                        getLogger().error("Failed to cast %s object (%s)", str2, e.getMessage());
                    } catch (ClassNotFoundException e2) {
                        getLogger().error("Failed to find %s class (%s)", str2, e2.getMessage());
                    } catch (Exception e3) {
                        getLogger().error("Failed to read %s object (%s)", str2, e3.getMessage());
                    }
                } catch (FileNotFoundException unused) {
                    t = null;
                    tCast = bufferedInputStream;
                    getLogger().debug("%s file not found", str2);
                    T t2 = tCast;
                    tCast = t;
                    OpenFileInput = t2;
                    if (OpenFileInput != 0) {
                    }
                    return tCast;
                } catch (Exception e4) {
                    e = e4;
                    t = null;
                    tCast = bufferedInputStream;
                    getLogger().error("Failed to open %s file for reading (%s)", str2, e);
                    T t22 = tCast;
                    tCast = t;
                    OpenFileInput = t22;
                    if (OpenFileInput != 0) {
                    }
                    return tCast;
                }
            } catch (FileNotFoundException unused2) {
                T t3 = tCast;
                tCast = OpenFileInput;
                t = t3;
            } catch (Exception e5) {
                e = e5;
                T t4 = tCast;
                tCast = OpenFileInput;
                t = t4;
            }
        } catch (FileNotFoundException unused3) {
            t = null;
        } catch (Exception e6) {
            e = e6;
            t = null;
        }
        if (OpenFileInput != 0) {
            try {
                OpenFileInput.close();
            } catch (Exception e7) {
                getLogger().error("Failed to close %s file for reading (%s)", str2, e7);
            }
        }
        return tCast;
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return (T) getField.get(str, t);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return t;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        try {
            return context.getPackageManager().resolveContentProvider(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void runInBackground(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runnable.run();
        } else {
            new AnonymousClass4().execute(runnable);
        }
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                if (playAdIdScheduler == null) {
                    playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                }
            }
        }
        try {
            return (R) playAdIdScheduler.scheduleFutureWithReturn(callable, 0L).get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public static String sha1(String str) {
        return hash(str, Constants.SHA1);
    }

    public static String sha256(String str) {
        return hash(str, Constants.SHA256);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.ObjectOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void writeObject(T t, Context context, String str, String str2) throws IOException {
        ?? OpenFileOutput;
        Closeable closeable;
        BufferedOutputStream bufferedOutputStream;
        try {
            OpenFileOutput = context.openFileOutput(str, 0);
        } catch (Exception e) {
            e = e;
            OpenFileOutput = 0;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(OpenFileOutput);
        } catch (Exception e2) {
            e = e2;
            getLogger().error("Failed to open %s for writing (%s)", str2, e);
            closeable = OpenFileOutput;
            if (closeable != null) {
            }
        }
        try {
            OpenFileOutput = new ObjectOutputStream(bufferedOutputStream);
            try {
                OpenFileOutput.writeObject(t);
                getLogger().debug("Wrote %s: %s", str2, t);
                closeable = OpenFileOutput;
            } catch (NotSerializableException unused) {
                getLogger().error("Failed to serialize %s", str2);
                closeable = OpenFileOutput;
            }
        } catch (Exception e3) {
            e = e3;
            OpenFileOutput = bufferedOutputStream;
            getLogger().error("Failed to open %s for writing (%s)", str2, e);
            closeable = OpenFileOutput;
            if (closeable != null) {
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e4) {
                getLogger().error("Failed to close %s file for writing (%s)", str2, e4);
            }
        }
    }

    private static String getGoogleAdId(Context context) {
        Object advertisingInfoObject;
        String gpsAdid = null;
        try {
            GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, 11000L);
            if (googlePlayServicesInfo != null) {
                gpsAdid = googlePlayServicesInfo.getGpsAdid();
            }
        } catch (Exception unused) {
        }
        return (gpsAdid != null || (advertisingInfoObject = getAdvertisingInfoObject(context, 11000L)) == null) ? gpsAdid : getPlayAdId(context, advertisingInfoObject, 1000L);
    }
}

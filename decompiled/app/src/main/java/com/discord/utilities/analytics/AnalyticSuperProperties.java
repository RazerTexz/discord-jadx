package com.discord.utilities.analytics;

import android.os.Build;
import com.discord.BuildConfig;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;

/* compiled from: AnalyticSuperProperties.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b,\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\fJ#\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001eR$\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u001eR\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u001eR$\u0010+\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010&R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u001eR\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010\u001eR\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010\u001eR\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010\u001eR\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010\u001eR\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010\u001eR\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010\u001eR\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010\u001eR\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010\u001eR\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010\u001eR\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010\u001eR\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u0010\u001eRC\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010\tR\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010\u001eR\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010\u001eR\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010\u001eR\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010\u001e¨\u0006D"}, d2 = {"Lcom/discord/utilities/analytics/AnalyticSuperProperties;", "", "", "setBaselineProperties", "()V", "", "", "extraSuperProperties", "updateSuperProperties", "(Ljava/util/Map;)V", "advertiserId", "setAdvertiserId", "(Ljava/lang/String;)V", "referrerUrl", "setCampaignProperties", "", "accessibilitySupportEnabled", "Ljava/util/EnumSet;", "Lcom/discord/utilities/accessibility/AccessibilityFeatureFlags;", "features", "setAccessibilityProperties", "(ZLjava/util/EnumSet;)V", "", "cpu", "", "memoryKb", "cpuCoreCount", "setClientPerformanceProperties", "(IJI)V", "PROPERTY_CLIENT_VERSION", "Ljava/lang/String;", "PROPERTY_SEARCH_ENGINE", "PROPERTY_REFERRING_DOMAIN", "PROPERTY_UTM_MEDIUM", "PROPERTY_OS_SDK_VERSION", "<set-?>", "superPropertiesStringBase64", "getSuperPropertiesStringBase64", "()Ljava/lang/String;", "PROPERTY_SYSTEM_LOCALE", "PROPERTY_UTM_CONTENT", "PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED", "PROPERTY_BROWSER_USER_AGENT", "superPropertiesString", "getSuperPropertiesString", "PROPERTY_CLIENT_BUILD_NUMBER", "PROPERTY_ACCESSIBILITY_FEATURES", "PROPERTY_UTM_CAMPAIGN", "PROPERTY_UTM_SOURCE", "PROPERTY_REFERRER", "PROPERTY_OS", "PROPERTY_BROWSER", "PROPERTY_CLIENT_PERFORMANCE_CPU", "PROPERTY_CPU_CORE_COUNT", "PROPERTY_LOCATION", "PROPERTY_DEVICE", "PROPERTY_DEVICE_ADVERTISER_ID", "superProperties$delegate", "Lkotlin/properties/ReadWriteProperty;", "getSuperProperties", "()Ljava/util/Map;", "setSuperProperties", "superProperties", "PROPERTY_UTM_TERM", "PROPERTY_CLIENT_PERFORMANCE_MEMORY", "PROPERTY_OS_VERSION", "PROPERTY_MP_KEYWORD", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AnalyticSuperProperties {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(AnalyticSuperProperties.class, "superProperties", "getSuperProperties()Ljava/util/Map;", 0))};
    public static final AnalyticSuperProperties INSTANCE;
    private static final String PROPERTY_ACCESSIBILITY_FEATURES = "accessibility_features";
    private static final String PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED = "accessibility_support_enabled";
    private static final String PROPERTY_BROWSER = "browser";
    private static final String PROPERTY_BROWSER_USER_AGENT = "browser_user_agent";
    private static final String PROPERTY_CLIENT_BUILD_NUMBER = "client_build_number";
    private static final String PROPERTY_CLIENT_PERFORMANCE_CPU = "client_performance_cpu";
    private static final String PROPERTY_CLIENT_PERFORMANCE_MEMORY = "client_performance_memory";
    private static final String PROPERTY_CLIENT_VERSION = "client_version";
    private static final String PROPERTY_CPU_CORE_COUNT = "cpu_core_count";
    private static final String PROPERTY_DEVICE = "device";
    private static final String PROPERTY_DEVICE_ADVERTISER_ID = "device_advertiser_id";
    private static final String PROPERTY_LOCATION = "location";
    private static final String PROPERTY_MP_KEYWORD = "mp_keyword";
    private static final String PROPERTY_OS = "os";
    private static final String PROPERTY_OS_SDK_VERSION = "os_sdk_version";
    private static final String PROPERTY_OS_VERSION = "os_version";
    private static final String PROPERTY_REFERRER = "referrer";
    private static final String PROPERTY_REFERRING_DOMAIN = "referring_domain";
    private static final String PROPERTY_SEARCH_ENGINE = "search_engine";
    private static final String PROPERTY_SYSTEM_LOCALE = "system_locale";
    private static final String PROPERTY_UTM_CAMPAIGN = "utm_campaign";
    private static final String PROPERTY_UTM_CONTENT = "utm_content";
    private static final String PROPERTY_UTM_MEDIUM = "utm_medium";
    private static final String PROPERTY_UTM_SOURCE = "utm_source";
    private static final String PROPERTY_UTM_TERM = "utm_term";

    /* renamed from: superProperties$delegate, reason: from kotlin metadata */
    private static final Interfaces superProperties;
    private static String superPropertiesString;
    private static String superPropertiesStringBase64;

    static {
        AnalyticSuperProperties analyticSuperProperties = new AnalyticSuperProperties();
        INSTANCE = analyticSuperProperties;
        superPropertiesString = "";
        superPropertiesStringBase64 = "";
        Map mapEmptyMap = Maps6.emptyMap();
        superProperties = new Delegates(mapEmptyMap, mapEmptyMap);
        analyticSuperProperties.setBaselineProperties();
    }

    private AnalyticSuperProperties() {
    }

    public static final /* synthetic */ String access$getSuperPropertiesString$p(AnalyticSuperProperties analyticSuperProperties) {
        return superPropertiesString;
    }

    public static final /* synthetic */ String access$getSuperPropertiesStringBase64$p(AnalyticSuperProperties analyticSuperProperties) {
        return superPropertiesStringBase64;
    }

    public static final /* synthetic */ void access$setSuperPropertiesString$p(AnalyticSuperProperties analyticSuperProperties, String str) {
        superPropertiesString = str;
    }

    public static final /* synthetic */ void access$setSuperPropertiesStringBase64$p(AnalyticSuperProperties analyticSuperProperties, String str) {
        superPropertiesStringBase64 = str;
    }

    private final void setBaselineProperties() {
        String string = Locale.getDefault().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "Locale.getDefault().toString()");
        updateSuperProperties(Maps6.mapOf(Tuples.to(PROPERTY_BROWSER, "Discord Android"), Tuples.to(PROPERTY_BROWSER_USER_AGENT, BuildConfig.USER_AGENT), Tuples.to(PROPERTY_CLIENT_BUILD_NUMBER, Integer.valueOf(BuildConfig.VERSION_CODE)), Tuples.to(PROPERTY_CLIENT_VERSION, BuildConfig.VERSION_NAME), Tuples.to(PROPERTY_DEVICE, Build.MODEL + ", " + Build.PRODUCT), Tuples.to(PROPERTY_OS, "Android"), Tuples.to(PROPERTY_OS_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT)), Tuples.to(PROPERTY_OS_VERSION, Build.VERSION.RELEASE), Tuples.to(PROPERTY_SYSTEM_LOCALE, StringsJVM.replace$default(string, "_", "-", false, 4, (Object) null))));
    }

    private final void setSuperProperties(Map<String, ? extends Object> map) {
        superProperties.setValue(this, $$delegatedProperties[0], map);
    }

    private final synchronized void updateSuperProperties(Map<String, ? extends Object> extraSuperProperties) {
        setSuperProperties(Maps6.plus(getSuperProperties(), extraSuperProperties));
    }

    public final Map<String, Object> getSuperProperties() {
        return (Map) superProperties.getValue(this, $$delegatedProperties[0]);
    }

    public final String getSuperPropertiesString() {
        return superPropertiesString;
    }

    public final String getSuperPropertiesStringBase64() {
        return superPropertiesStringBase64;
    }

    public final void setAccessibilityProperties(boolean accessibilitySupportEnabled, EnumSet<AccessibilityFeatureFlags> features) {
        Intrinsics3.checkNotNullParameter(features, "features");
        Iterator<T> it = features.iterator();
        long value = 0;
        while (it.hasNext()) {
            value |= ((AccessibilityFeatureFlags) it.next()).getValue();
        }
        updateSuperProperties(Maps6.mapOf(Tuples.to(PROPERTY_ACCESSIBILITY_SUPPORT_ENABLED, Boolean.valueOf(accessibilitySupportEnabled)), Tuples.to(PROPERTY_ACCESSIBILITY_FEATURES, Long.valueOf(value))));
    }

    public final void setAdvertiserId(String advertiserId) {
        Intrinsics3.checkNotNullParameter(advertiserId, "advertiserId");
        updateSuperProperties(MapsJVM.mapOf(Tuples.to(PROPERTY_DEVICE_ADVERTISER_ID, advertiserId)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setCampaignProperties(String referrerUrl) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(referrerUrl, "referrerUrl");
        Map<String, ? extends Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.to("referrer", referrerUrl));
        List listSplit$default = Strings4.split$default((CharSequence) referrerUrl, new String[]{"&"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Strings4.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((List) obj).size() == 2) {
                arrayList2.add(obj);
            }
        }
        ArrayList<List> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            String str = (String) ((List) obj2).get(0);
            switch (str.hashCode()) {
                case -1539894552:
                    if (str.equals(PROPERTY_UTM_CONTENT)) {
                        z2 = true;
                        break;
                    } else {
                        z2 = false;
                        break;
                    }
                case -1089678029:
                    if (str.equals(PROPERTY_REFERRING_DOMAIN)) {
                    }
                    break;
                case -64687999:
                    if (str.equals(PROPERTY_UTM_CAMPAIGN)) {
                    }
                    break;
                case 833459293:
                    if (str.equals(PROPERTY_UTM_TERM)) {
                    }
                    break;
                case 1027243853:
                    if (str.equals(PROPERTY_MP_KEYWORD)) {
                    }
                    break;
                case 1061643449:
                    if (str.equals(PROPERTY_SEARCH_ENGINE)) {
                    }
                    break;
                case 1889642278:
                    if (str.equals(PROPERTY_UTM_MEDIUM)) {
                    }
                    break;
                case 1901043637:
                    if (str.equals("location")) {
                    }
                    break;
                case 2071166924:
                    if (str.equals(PROPERTY_UTM_SOURCE)) {
                    }
                    break;
            }
            if (z2) {
                arrayList3.add(obj2);
            }
        }
        for (List list : arrayList3) {
            mapMutableMapOf.put((String) list.get(0), (String) list.get(1));
        }
        updateSuperProperties(mapMutableMapOf);
    }

    public final void setClientPerformanceProperties(int cpu, long memoryKb, int cpuCoreCount) {
        updateSuperProperties(Maps6.mapOf(Tuples.to(PROPERTY_CLIENT_PERFORMANCE_CPU, Integer.valueOf(cpu)), Tuples.to(PROPERTY_CLIENT_PERFORMANCE_MEMORY, Long.valueOf(memoryKb)), Tuples.to(PROPERTY_CPU_CORE_COUNT, Integer.valueOf(cpuCoreCount))));
    }
}

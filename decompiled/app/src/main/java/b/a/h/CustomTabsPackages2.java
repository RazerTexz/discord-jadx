package b.a.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsService;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: CustomTabsPackages.kt */
/* renamed from: b.a.h.c, reason: use source file name */
/* loaded from: classes.dex */
public final class CustomTabsPackages2 {
    public static final CustomTabsPackages2 a = new CustomTabsPackages2();

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(Context context, Function1<? super String, Boolean> function1) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Intrinsics3.checkNotNullParameter(context, "$this$getCustomTabsDefaultPackage");
        Intrinsics3.checkNotNullParameter(function1, "filter");
        PackageManager packageManager = context.getPackageManager();
        Object obj = null;
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
        Intrinsics3.checkNotNullExpressionValue(data, "Intent()\n          .setA…mParts(\"http\", \"\", null))");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(data, 0);
        Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…ltViewIntentHandler(), 0)");
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent = new Intent().setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(resolveInfo.activityInfo.packageName);
            Intrinsics3.checkNotNullExpressionValue(intent, "Intent()\n            .se…activityInfo.packageName)");
            String str = context.getPackageManager().resolveService(intent, 0) != null ? resolveInfo.activityInfo.packageName : null;
            if (str != null) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics3.areEqual((String) next, "com.android.chrome")) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 == null) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next4 = null;
                    break;
                }
                next4 = it2.next();
                if (Intrinsics3.areEqual((String) next4, "com.chrome.beta")) {
                    break;
                }
            }
            str2 = (String) next4;
        }
        if (str2 == null) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next3 = null;
                    break;
                }
                next3 = it3.next();
                if (Intrinsics3.areEqual((String) next3, "com.chrome.dev")) {
                    break;
                }
            }
            str2 = (String) next3;
        }
        if (str2 == null) {
            Iterator it4 = arrayList.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it4.next();
                if (Intrinsics3.areEqual((String) next2, "com.google.android.apps.chrome")) {
                    break;
                }
            }
            str2 = (String) next2;
        }
        if (str2 != null) {
            return str2;
        }
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next5 = it5.next();
            if (function1.invoke(next5).booleanValue()) {
                obj = next5;
                break;
            }
        }
        return (String) obj;
    }
}

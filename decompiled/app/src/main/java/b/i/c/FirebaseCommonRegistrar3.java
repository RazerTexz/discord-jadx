package b.i.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import b.i.c.x.LibraryVersionComponent2;

/* compiled from: FirebaseCommonRegistrar.java */
/* renamed from: b.i.c.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar3 implements LibraryVersionComponent2 {
    public static final FirebaseCommonRegistrar3 a = new FirebaseCommonRegistrar3();

    @Override // b.i.c.x.LibraryVersionComponent2
    public String a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }
}

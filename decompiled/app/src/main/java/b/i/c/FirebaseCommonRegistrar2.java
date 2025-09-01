package b.i.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import b.i.c.x.LibraryVersionComponent2;

/* compiled from: FirebaseCommonRegistrar.java */
/* renamed from: b.i.c.d, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar2 implements LibraryVersionComponent2 {
    public static final FirebaseCommonRegistrar2 a = new FirebaseCommonRegistrar2();

    @Override // b.i.c.x.LibraryVersionComponent2
    public String a(Object obj) {
        ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }
}

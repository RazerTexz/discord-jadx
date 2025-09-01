package b.i.c;

import android.content.Context;
import b.i.c.x.LibraryVersionComponent2;
import com.google.firebase.FirebaseCommonRegistrar;

/* compiled from: FirebaseCommonRegistrar.java */
/* renamed from: b.i.c.g, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar5 implements LibraryVersionComponent2 {
    public static final FirebaseCommonRegistrar5 a = new FirebaseCommonRegistrar5();

    @Override // b.i.c.x.LibraryVersionComponent2
    public String a(Object obj) {
        Context context = (Context) obj;
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? FirebaseCommonRegistrar.a(installerPackageName) : "";
    }
}

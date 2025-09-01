package b.i.c;

import android.content.Context;
import android.os.Build;
import b.i.c.x.LibraryVersionComponent2;

/* compiled from: FirebaseCommonRegistrar.java */
/* renamed from: b.i.c.f, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseCommonRegistrar4 implements LibraryVersionComponent2 {
    public static final FirebaseCommonRegistrar4 a = new FirebaseCommonRegistrar4();

    @Override // b.i.c.x.LibraryVersionComponent2
    public String a(Object obj) {
        Context context = (Context) obj;
        int i = Build.VERSION.SDK_INT;
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto";
    }
}

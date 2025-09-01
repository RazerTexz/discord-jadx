package b.i.c.m.d.u;

import android.content.Context;
import android.content.res.Resources;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CommonUtils;

/* compiled from: ResourceUnityVersionProvider.java */
/* renamed from: b.i.c.m.d.u.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ResourceUnityVersionProvider {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1754b = false;
    public String c;

    public ResourceUnityVersionProvider(Context context) {
        this.a = context;
    }

    public String a() throws Resources.NotFoundException {
        String string;
        if (!this.f1754b) {
            Context context = this.a;
            int iN = CommonUtils.n(context, "com.google.firebase.crashlytics.unity_version", "string");
            if (iN != 0) {
                string = context.getResources().getString(iN);
                outline.o0("Unity Editor version is: ", string, Logger3.a);
            } else {
                string = null;
            }
            this.c = string;
            this.f1754b = true;
        }
        String str = this.c;
        if (str != null) {
            return str;
        }
        return null;
    }
}

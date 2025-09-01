package b.i.c.m.e;

import android.content.Context;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.util.Objects;

/* compiled from: CrashlyticsNdkRegistrar.java */
/* renamed from: b.i.c.m.e.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsNdkRegistrar2 implements ComponentFactory {
    public final CrashlyticsNdkRegistrar a;

    public CrashlyticsNdkRegistrar2(CrashlyticsNdkRegistrar crashlyticsNdkRegistrar) {
        this.a = crashlyticsNdkRegistrar;
    }

    @Override // b.i.c.l.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        Objects.requireNonNull(this.a);
        Context context = (Context) componentContainer.a(Context.class);
        return new FirebaseCrashlyticsNdk(new BreakpadController(context, new JniNativeApi(context), new NdkCrashFilesManager(new File(context.getFilesDir(), ".com.google.firebase.crashlytics-ndk"))));
    }
}

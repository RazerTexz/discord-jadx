package f0.e0.k.i;

import d0.z.d.Intrinsics3;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StandardAndroidSocketAdapter.kt */
/* renamed from: f0.e0.k.i.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter2 {
    public static final a h = new a(null);

    /* compiled from: StandardAndroidSocketAdapter.kt */
    /* renamed from: f0.e0.k.i.l$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        Intrinsics3.checkParameterIsNotNull(cls, "sslSocketClass");
        Intrinsics3.checkParameterIsNotNull(cls2, "sslSocketFactoryClass");
        Intrinsics3.checkParameterIsNotNull(cls3, "paramClass");
    }
}

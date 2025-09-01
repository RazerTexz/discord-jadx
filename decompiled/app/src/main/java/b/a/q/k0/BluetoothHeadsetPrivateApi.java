package b.a.q.k0;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothHeadset;
import d0.LazyJVM;
import d0.z.d.Lambda;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: BluetoothHeadsetPrivateApi.kt */
@SuppressLint({"DiscouragedPrivateApi"})
/* renamed from: b.a.q.k0.d, reason: use source file name */
/* loaded from: classes.dex */
public final class BluetoothHeadsetPrivateApi {
    public static final Lazy a = LazyJVM.lazy(a.j);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f263b = LazyJVM.lazy(b.j);
    public static final BluetoothHeadsetPrivateApi c = null;

    /* compiled from: BluetoothHeadsetPrivateApi.kt */
    /* renamed from: b.a.q.k0.d$a */
    public static final class a extends Lambda implements Function0<String> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            try {
                Object obj = BluetoothHeadset.class.getField("ACTION_ACTIVE_DEVICE_CHANGED").get(null);
                if (!(obj instanceof String)) {
                    obj = null;
                }
                return (String) obj;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: BluetoothHeadsetPrivateApi.kt */
    /* renamed from: b.a.q.k0.d$b */
    public static final class b extends Lambda implements Function0<Method> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Method invoke() {
            try {
                return BluetoothHeadset.class.getDeclaredMethod("getActiveDevice", new Class[0]);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}

package b.i.a.f.f;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    /* renamed from: b.i.a.f.f.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0040a extends b.i.a.f.h.g.b implements a {
        public AbstractBinderC0040a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static a g(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder);
        }
    }
}

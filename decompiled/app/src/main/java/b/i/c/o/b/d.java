package b.i.c.o.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.c;
import org.objectweb.asm.Opcodes;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* loaded from: classes3.dex */
public final class d extends b.i.a.f.e.k.d<j> {
    public d(Context context, Looper looper, b.i.a.f.e.k.c cVar, c.a aVar, c.b bVar) {
        super(context, looper, Opcodes.LXOR, cVar, aVar, bVar);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a.f
    public final int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b
    @Nullable
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
        return iInterfaceQueryLocalInterface instanceof j ? (j) iInterfaceQueryLocalInterface : new l(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final String x() {
        return "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
    }

    @Override // b.i.a.f.e.k.b
    @NonNull
    public final String y() {
        return "com.google.firebase.dynamiclinks.service.START";
    }
}

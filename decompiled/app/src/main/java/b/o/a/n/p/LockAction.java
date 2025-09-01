package b.o.a.n.p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.i.a.f.e.o.f;
import b.o.a.n.o.ActionWrapper;
import b.o.a.n.o.BaseAction;

/* compiled from: LockAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public class LockAction extends ActionWrapper {
    public final BaseAction e = f.x1(new ExposureLock(), new FocusLock(), new WhiteBalanceLock());

    @Override // b.o.a.n.o.ActionWrapper
    @NonNull
    public BaseAction m() {
        return this.e;
    }
}

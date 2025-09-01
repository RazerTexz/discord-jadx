package b.o.a.n.r;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.n.o.ActionWrapper;
import b.o.a.n.o.BaseAction;

/* compiled from: MeterResetAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.h, reason: use source file name */
/* loaded from: classes3.dex */
public class MeterResetAction extends ActionWrapper {
    public final BaseAction e = b.i.a.f.e.o.f.x1(new ExposureReset(), new FocusReset(), new WhiteBalanceReset());

    @Override // b.o.a.n.o.ActionWrapper
    @NonNull
    public BaseAction m() {
        return this.e;
    }
}

package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: TimeoutAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.i, reason: use source file name */
/* loaded from: classes3.dex */
public class TimeoutAction extends ActionWrapper {
    public long e;
    public long f;
    public BaseAction g;

    public TimeoutAction(long j, @NonNull BaseAction baseAction) {
        this.f = j;
        this.g = baseAction;
    }

    @Override // b.o.a.n.o.ActionWrapper, b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.b(actionHolder, captureRequest, totalCaptureResult);
        if (g() || System.currentTimeMillis() <= this.e + this.f) {
            return;
        }
        this.g.a(actionHolder);
    }

    @Override // b.o.a.n.o.ActionWrapper, b.o.a.n.o.BaseAction
    public void j(@NonNull ActionHolder actionHolder) {
        this.e = System.currentTimeMillis();
        super.j(actionHolder);
    }

    @Override // b.o.a.n.o.ActionWrapper
    @NonNull
    public BaseAction m() {
        return this.g;
    }
}

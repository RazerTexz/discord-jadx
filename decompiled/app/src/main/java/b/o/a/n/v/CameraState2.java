package b.o.a.n.v;

import androidx.annotation.NonNull;

/* compiled from: CameraState.java */
/* renamed from: b.o.a.n.v.e, reason: use source file name */
/* loaded from: classes3.dex */
public enum CameraState2 {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);

    private int mState;

    CameraState2(int i) {
        this.mState = i;
    }

    public boolean f(@NonNull CameraState2 cameraState2) {
        return this.mState >= cameraState2.mState;
    }
}

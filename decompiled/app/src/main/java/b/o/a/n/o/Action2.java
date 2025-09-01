package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Action.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface Action2 {
    void a(@NonNull ActionHolder actionHolder);

    void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult);

    void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest);

    void d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult);

    void e(@NonNull ActionHolder actionHolder);
}

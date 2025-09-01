package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.CameraEngine;

/* compiled from: LogAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.g, reason: use source file name */
/* loaded from: classes3.dex */
public class LogAction extends BaseAction {
    public static final CameraLogger e = new CameraLogger(CameraEngine.class.getSimpleName());
    public String f;

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num3 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        String str = "aeMode: " + num + " aeLock: " + ((Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + num2 + " aeTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + num3 + " afTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER));
        if (str.equals(this.f)) {
            return;
        }
        this.f = str;
        e.a(1, str);
    }

    @Override // b.o.a.n.o.BaseAction
    public void i(@NonNull ActionHolder actionHolder) {
        l(0);
        e(actionHolder);
    }
}

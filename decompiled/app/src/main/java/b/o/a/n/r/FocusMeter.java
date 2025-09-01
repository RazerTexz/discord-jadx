package b.o.a.n.r;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.ActionHolder;
import java.util.List;

/* compiled from: FocusMeter.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.e, reason: use source file name */
/* loaded from: classes3.dex */
public class FocusMeter extends BaseMeter {
    public static final CameraLogger i = new CameraLogger(FocusMeter.class.getSimpleName());

    public FocusMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
    public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        i.a(1, "onCaptureCompleted:", "afState:", num);
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 4) {
            this.g = true;
            l(Integer.MAX_VALUE);
        } else {
            if (iIntValue != 5) {
                return;
            }
            this.g = false;
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.o.BaseAction
    public void i(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // b.o.a.n.r.BaseMeter
    public boolean m(@NonNull ActionHolder actionHolder) {
        Integer num = (Integer) ((Camera2Engine) actionHolder).f1921i0.get(CaptureRequest.CONTROL_AF_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        i.a(1, "checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.BaseMeter
    public boolean n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f1922j0;
        if (totalCaptureResult == null) {
            i.a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z2 = num != null && (num.intValue() == 4 || num.intValue() == 2);
        i.a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // b.o.a.n.r.BaseMeter
    public void o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) throws CameraAccessException {
        i.a(1, "onStarted:", "with areas:", list);
        ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int iIntValue = ((Integer) k(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && iIntValue > 0) {
            ((Camera2Engine) actionHolder).f1921i0.set(CaptureRequest.CONTROL_AF_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        ((Camera2Engine) actionHolder).k1();
    }
}

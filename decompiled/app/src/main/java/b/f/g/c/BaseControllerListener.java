package b.f.g.c;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;

/* compiled from: BaseControllerListener.java */
/* renamed from: b.f.g.c.c, reason: use source file name */
/* loaded from: classes.dex */
public class BaseControllerListener<INFO> implements ControllerListener<INFO> {
    private static final ControllerListener<Object> NO_OP_LISTENER = new BaseControllerListener();

    public static <INFO> ControllerListener<INFO> getNoOpListener() {
        return (ControllerListener<INFO>) NO_OP_LISTENER;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, INFO info, Animatable animatable) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, INFO info) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String str) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
    }
}

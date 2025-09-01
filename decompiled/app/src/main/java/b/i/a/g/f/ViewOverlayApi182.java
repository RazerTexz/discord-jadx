package b.i.a.g.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.ViewOverlayImpl;

/* compiled from: ViewOverlayApi18.java */
@RequiresApi(18)
/* renamed from: b.i.a.g.f.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ViewOverlayApi182 implements ViewOverlayImpl {
    public final ViewOverlay a;

    public ViewOverlayApi182(@NonNull View view) {
        this.a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.a.remove(drawable);
    }
}

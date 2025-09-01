package b.o.a.s;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: AutoFocusMarker.java */
/* renamed from: b.o.a.s.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface AutoFocusMarker {
    void a(@NonNull AutoFocusTrigger autoFocusTrigger, @NonNull PointF pointF);

    @Nullable
    View b(@NonNull Context context, @NonNull ViewGroup viewGroup);

    void c(@NonNull AutoFocusTrigger autoFocusTrigger, boolean z2, @NonNull PointF pointF);
}

package b.o.a.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: MarkerLayout.java */
/* renamed from: b.o.a.s.c, reason: use source file name */
/* loaded from: classes3.dex */
public class MarkerLayout extends FrameLayout {

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, View> j;

    public MarkerLayout(@NonNull Context context) {
        super(context);
        this.j = new HashMap<>();
    }
}

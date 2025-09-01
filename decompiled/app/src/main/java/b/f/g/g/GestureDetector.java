package b.f.g.g;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;

/* compiled from: GestureDetector.java */
/* renamed from: b.f.g.g.a, reason: use source file name */
/* loaded from: classes.dex */
public class GestureDetector {

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final float f524b;

    @VisibleForTesting
    public long e;

    @VisibleForTesting
    public float f;

    @VisibleForTesting
    public float g;

    @VisibleForTesting
    public a a = null;

    @VisibleForTesting
    public boolean c = false;

    @VisibleForTesting
    public boolean d = false;

    /* compiled from: GestureDetector.java */
    /* renamed from: b.f.g.g.a$a */
    public interface a {
    }

    public GestureDetector(Context context) {
        this.f524b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}

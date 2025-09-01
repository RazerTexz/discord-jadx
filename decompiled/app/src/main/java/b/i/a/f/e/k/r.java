package b.i.a.f.e.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class r {
    public final SparseIntArray a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    public b.i.a.f.e.c f1392b;

    public r(@NonNull b.i.a.f.e.c cVar) {
        Objects.requireNonNull(cVar, "null reference");
        this.f1392b = cVar;
    }

    public final int a(@NonNull Context context, @NonNull a.f fVar) throws PackageManager.NameNotFoundException {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(fVar, "null reference");
        int iB = 0;
        if (!fVar.k()) {
            return 0;
        }
        int iL = fVar.l();
        int i = this.a.get(iL, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.a.size()) {
                iB = i;
                break;
            }
            int iKeyAt = this.a.keyAt(i2);
            if (iKeyAt > iL && this.a.get(iKeyAt) == 0) {
                break;
            }
            i2++;
        }
        if (iB == -1) {
            iB = this.f1392b.b(context, iL);
        }
        this.a.put(iL, iB);
        return iB;
    }
}

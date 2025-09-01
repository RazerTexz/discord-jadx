package b.o.a.x;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* compiled from: SizeSelectors.java */
/* renamed from: b.o.a.x.f, reason: use source file name */
/* loaded from: classes3.dex */
public class SizeSelectors3 implements SizeSelector {
    @Override // b.o.a.x.SizeSelector
    @NonNull
    public List<Size3> a(@NonNull List<Size3> list) {
        Collections.sort(list);
        return list;
    }
}

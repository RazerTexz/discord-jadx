package b.o.a.x;

import androidx.annotation.NonNull;

/* compiled from: SizeSelectors.java */
/* renamed from: b.o.a.x.g, reason: use source file name */
/* loaded from: classes3.dex */
public class SizeSelectors4 implements SizeSelectors7 {
    public final /* synthetic */ int a;

    public SizeSelectors4(int i) {
        this.a = i;
    }

    @Override // b.o.a.x.SizeSelectors7
    public boolean a(@NonNull Size3 size3) {
        return size3.k * size3.j <= this.a;
    }
}

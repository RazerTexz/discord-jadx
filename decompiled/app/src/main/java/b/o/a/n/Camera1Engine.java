package b.o.a.n;

import java.util.Comparator;

/* compiled from: Camera1Engine.java */
/* renamed from: b.o.a.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera1Engine implements Comparator<int[]> {
    public Camera1Engine(Camera1Engine2 camera1Engine2) {
    }

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return (iArr4[1] - iArr4[0]) - (iArr3[1] - iArr3[0]);
    }
}

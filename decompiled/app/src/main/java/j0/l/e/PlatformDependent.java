package j0.l.e;

/* compiled from: PlatformDependent.java */
/* renamed from: j0.l.e.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlatformDependent {
    public static final int a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f3795b;

    static {
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        a = iIntValue;
        f3795b = iIntValue != 0;
    }
}

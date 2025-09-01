package b.f.i;

/* compiled from: ImageFormat.java */
/* renamed from: b.f.i.c, reason: use source file name */
/* loaded from: classes.dex */
public class ImageFormat {
    public static final ImageFormat a = new ImageFormat("UNKNOWN", null);

    /* renamed from: b, reason: collision with root package name */
    public final String f541b;

    /* compiled from: ImageFormat.java */
    /* renamed from: b.f.i.c$a */
    public interface a {
        int a();

        ImageFormat b(byte[] bArr, int i);
    }

    public ImageFormat(String str, String str2) {
        this.f541b = str;
    }

    public String toString() {
        return this.f541b;
    }
}

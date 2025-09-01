package b.i.e;

import com.discord.widgets.chat.input.MentionUtils;

/* compiled from: LuminanceSource.java */
/* renamed from: b.i.e.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LuminanceSource {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1823b;

    public LuminanceSource(int i, int i2) {
        this.a = i;
        this.f1823b = i2;
    }

    public abstract byte[] a();

    public abstract byte[] b(int i, byte[] bArr);

    public boolean c() {
        return false;
    }

    public LuminanceSource d() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.a;
        byte[] bArrB = new byte[i];
        StringBuilder sb = new StringBuilder((i + 1) * this.f1823b);
        for (int i2 = 0; i2 < this.f1823b; i2++) {
            bArrB = b(i2, bArrB);
            for (int i3 = 0; i3 < this.a; i3++) {
                int i4 = bArrB[i3] & 255;
                sb.append(i4 < 64 ? MentionUtils.CHANNELS_CHAR : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

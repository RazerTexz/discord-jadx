package d0.e0.p.d.m0.i;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: Internal.java */
/* renamed from: d0.e0.p.d.m0.i.h, reason: use source file name */
/* loaded from: classes3.dex */
public class Internal {
    public static final byte[] a;

    /* compiled from: Internal.java */
    /* renamed from: d0.e0.p.d.m0.i.h$a */
    public interface a {
        int getNumber();
    }

    /* compiled from: Internal.java */
    /* renamed from: d0.e0.p.d.m0.i.h$b */
    public interface b<T extends a> {
        T findValueByNumber(int i);
    }

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, Constants.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }
}

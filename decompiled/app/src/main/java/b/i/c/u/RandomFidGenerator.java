package b.i.c.u;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* compiled from: RandomFidGenerator.java */
/* renamed from: b.i.c.u.l, reason: use source file name */
/* loaded from: classes3.dex */
public class RandomFidGenerator {
    public static final byte a = Byte.parseByte("01110000", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final byte f1782b = Byte.parseByte("00001111", 2);

    @NonNull
    public String a() {
        UUID uuidRandomUUID = UUID.randomUUID();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[17]);
        byteBufferWrap.putLong(uuidRandomUUID.getMostSignificantBits());
        byteBufferWrap.putLong(uuidRandomUUID.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        bArrArray[16] = bArrArray[0];
        bArrArray[0] = (byte) ((f1782b & bArrArray[0]) | a);
        return new String(Base64.encode(bArrArray, 11), Charset.defaultCharset()).substring(0, 22);
    }
}

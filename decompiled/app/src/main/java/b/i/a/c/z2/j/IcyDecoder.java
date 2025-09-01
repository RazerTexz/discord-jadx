package b.i.a.c.z2.j;

import b.i.a.c.z2.MetadataInputBuffer;
import b.i.a.c.z2.SimpleMetadataDecoder;
import b.i.a.f.e.o.f;
import b.i.b.a.Charsets;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IcyDecoder.java */
/* renamed from: b.i.a.c.z2.j.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class IcyDecoder extends SimpleMetadataDecoder {
    public static final Pattern a = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: b, reason: collision with root package name */
    public final CharsetDecoder f1323b = Charsets.c.newDecoder();
    public final CharsetDecoder c = Charsets.f1642b.newDecoder();

    @Override // b.i.a.c.z2.SimpleMetadataDecoder
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String string;
        String str = null;
        try {
            string = this.f1323b.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                string = this.c.decode(byteBuffer).toString();
                this.c.reset();
                byteBuffer.rewind();
            } catch (CharacterCodingException unused2) {
                this.c.reset();
                byteBuffer.rewind();
                string = null;
            } catch (Throwable th) {
                this.c.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.f1323b.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (string == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = a.matcher(string);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strU1 = f.u1(strGroup);
                strU1.hashCode();
                if (strU1.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strU1.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}

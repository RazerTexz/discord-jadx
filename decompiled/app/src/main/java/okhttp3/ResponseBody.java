package okhttp3;

import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import g0.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;

/* compiled from: ResponseBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00162\u00020\u0001:\u0002\u0006\u0003B\u0007¢\u0006\u0004\b\u0015\u0010\u0010J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "Lokhttp3/MediaType;", "b", "()Lokhttp3/MediaType;", "", "a", "()J", "Lg0/g;", "c", "()Lg0/g;", "", "d", "()Ljava/lang/String;", "", "close", "()V", "Ljava/io/Reader;", "k", "Ljava/io/Reader;", "reader", "<init>", "j", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class ResponseBody implements Closeable {

    /* renamed from: k, reason: from kotlin metadata */
    public Reader reader;

    /* compiled from: ResponseBody.kt */
    public static final class a extends Reader {
        public boolean j;
        public Reader k;
        public final BufferedSource l;
        public final Charset m;

        public a(BufferedSource bufferedSource, Charset charset) {
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(charset, "charset");
            this.l = bufferedSource;
            this.m = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.j = true;
            Reader reader = this.k;
            if (reader != null) {
                reader.close();
            } else {
                this.l.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            Intrinsics3.checkParameterIsNotNull(cArr, "cbuf");
            if (this.j) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.k;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.l.u0(), Util7.s(this.l, this.m));
                this.k = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    public abstract long a();

    public abstract MediaType b();

    public abstract BufferedSource c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util7.d(c());
    }

    public final String d() throws IOException {
        Charset charsetA;
        BufferedSource bufferedSourceC = c();
        try {
            MediaType mediaTypeB = b();
            if (mediaTypeB == null || (charsetA = mediaTypeB.a(Charsets2.a)) == null) {
                charsetA = Charsets2.a;
            }
            String strM = bufferedSourceC.M(Util7.s(bufferedSourceC, charsetA));
            d0.y.Closeable.closeFinally(bufferedSourceC, null);
            return strM;
        } finally {
        }
    }
}

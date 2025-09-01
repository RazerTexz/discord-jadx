package okio;

import g0.Buffer3;
import g0.Sink;
import g0.Source2;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

/* compiled from: BufferedSink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000bH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000bH&¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H&¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0000H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0000H&¢\u0006\u0004\b'\u0010&R\u0016\u0010+\u001a\u00020(8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lokio/BufferedSink;", "Lg0/v;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/ByteString;", "byteString", "e0", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "source", "write", "([B)Lokio/BufferedSink;", "", "offset", "byteCount", "([BII)Lokio/BufferedSink;", "Lg0/x;", "", "P", "(Lg0/x;)J", "", "string", "K", "(Ljava/lang/String;)Lokio/BufferedSink;", "b", "writeByte", "(I)Lokio/BufferedSink;", "s", "writeShort", "i", "writeInt", "v", "q0", "(J)Lokio/BufferedSink;", "Q", "", "flush", "()V", "p", "()Lokio/BufferedSink;", "F", "Lg0/e;", "g", "()Lg0/e;", "buffer", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink F() throws IOException;

    BufferedSink K(String string) throws IOException;

    long P(Source2 source) throws IOException;

    BufferedSink Q(long v) throws IOException;

    BufferedSink e0(ByteString byteString) throws IOException;

    @Override // g0.Sink, java.io.Flushable
    void flush() throws IOException;

    Buffer3 g();

    BufferedSink p() throws IOException;

    BufferedSink q0(long v) throws IOException;

    BufferedSink write(byte[] source) throws IOException;

    BufferedSink write(byte[] source, int offset, int byteCount) throws IOException;

    BufferedSink writeByte(int b2) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int s2) throws IOException;
}

package okhttp3.internal.http2;

import d0.z.d.Intrinsics3;
import f0.e0.j.ErrorCode2;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: StreamResetException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/StreamResetException;", "Ljava/io/IOException;", "Lf0/e0/j/a;", "errorCode", "Lf0/e0/j/a;", "<init>", "(Lf0/e0/j/a;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode2 errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(ErrorCode2 errorCode2) {
        super("stream was reset: " + errorCode2);
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        this.errorCode = errorCode2;
    }
}

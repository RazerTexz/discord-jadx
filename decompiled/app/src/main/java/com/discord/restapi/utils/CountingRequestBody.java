package com.discord.restapi.utils;

import b.d.b.a.outline;
import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import g0.Buffer3;
import g0.ForwardingSink;
import g0.RealBufferedSink;
import g0.Sink;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: CountingRequestBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\"B\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R:\u0010\u0015\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u0002 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019¨\u0006#"}, d2 = {"Lcom/discord/restapi/utils/CountingRequestBody;", "Lokhttp3/RequestBody;", "", "bytesWritten", "", "updateProgress", "(J)V", "Lrx/Observable;", "getBytesWrittenObservable", "()Lrx/Observable;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "contentLength", "()J", "Lokio/BufferedSink;", "sink", "writeTo", "(Lokio/BufferedSink;)V", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "bytesWrittenSubject", "Lrx/subjects/BehaviorSubject;", "", "ignoreWriteToCount", "I", "estimatedContentLength", "J", "getEstimatedContentLength", "delegate", "Lokhttp3/RequestBody;", "numWriteToCalls", "<init>", "(Lokhttp3/RequestBody;I)V", "CountingSink", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CountingRequestBody extends RequestBody {
    private final BehaviorSubject<Long> bytesWrittenSubject;
    private final RequestBody delegate;
    private final long estimatedContentLength;
    private final int ignoreWriteToCount;
    private int numWriteToCalls;

    /* compiled from: CountingRequestBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/discord/restapi/utils/CountingRequestBody$CountingSink;", "Lg0/i;", "Lg0/e;", "source", "", "byteCount", "", "write", "(Lg0/e;J)V", "Lkotlin/Function1;", "listener", "Lkotlin/jvm/functions/Function1;", "bytesWritten", "J", "Lg0/v;", "delegate", "<init>", "(Lg0/v;Lkotlin/jvm/functions/Function1;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class CountingSink extends ForwardingSink {
        private long bytesWritten;
        private final Function1<Long, Unit> listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CountingSink(Sink sink, Function1<? super Long, Unit> function1) {
            super(sink);
            Intrinsics3.checkNotNullParameter(sink, "delegate");
            Intrinsics3.checkNotNullParameter(function1, "listener");
            this.listener = function1;
        }

        @Override // g0.ForwardingSink, g0.Sink
        public void write(Buffer3 source, long byteCount) throws IOException {
            Intrinsics3.checkNotNullParameter(source, "source");
            super.write(source, byteCount);
            long j = this.bytesWritten + byteCount;
            this.bytesWritten = j;
            this.listener.invoke(Long.valueOf(j));
        }
    }

    public /* synthetic */ CountingRequestBody(RequestBody requestBody, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestBody, (i2 & 2) != 0 ? 0 : i);
    }

    public static final /* synthetic */ void access$updateProgress(CountingRequestBody countingRequestBody, long j) {
        countingRequestBody.updateProgress(j);
    }

    private final void updateProgress(long bytesWritten) {
        if (this.numWriteToCalls > this.ignoreWriteToCount) {
            this.bytesWrittenSubject.onNext(Long.valueOf(bytesWritten));
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public final Observable<Long> getBytesWrittenObservable() {
        Observable<Long> observableL = this.bytesWrittenSubject.r().L();
        Intrinsics3.checkNotNullExpressionValue(observableL, "bytesWrittenSubject.dist…().onBackpressureLatest()");
        return observableL;
    }

    public final long getEstimatedContentLength() {
        return this.estimatedContentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics3.checkNotNullParameter(sink, "sink");
        int i = this.numWriteToCalls;
        this.numWriteToCalls = i + 1;
        if (i < this.ignoreWriteToCount) {
            ByteString.Companion companion = ByteString.INSTANCE;
            StringBuilder sbQ = outline.Q('<');
            sbQ.append(this.delegate);
            sbQ.append('>');
            sink.e0(companion.b(sbQ.toString(), Charsets2.a));
            return;
        }
        CountingSink countingSink = new CountingSink(sink, new CountingRequestBody2(this));
        Intrinsics3.checkParameterIsNotNull(countingSink, "$this$buffer");
        RealBufferedSink realBufferedSink = new RealBufferedSink(countingSink);
        this.delegate.writeTo(realBufferedSink);
        realBufferedSink.flush();
    }

    public CountingRequestBody(RequestBody requestBody, int i) {
        Intrinsics3.checkNotNullParameter(requestBody, "delegate");
        this.delegate = requestBody;
        this.ignoreWriteToCount = i;
        this.bytesWrittenSubject = BehaviorSubject.l0(0L);
        this.estimatedContentLength = requestBody.contentLength();
    }
}

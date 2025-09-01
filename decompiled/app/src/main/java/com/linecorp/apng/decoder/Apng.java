package com.linecorp.apng.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Trace;
import androidx.annotation.IntRange;
import com.discord.models.domain.ModelAuditLogEntry;
import com.linecorp.apng.decoder.ApngException;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Apng.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\b\u0000\u0018\u0000 A2\u00020\u0001:\u0002ABBE\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010>\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\b\b\u0001\u0010 \u001a\u00020\b\u0012\u0006\u0010-\u001a\u00020(\u0012\b\b\u0001\u00106\u001a\u00020\b\u0012\b\b\u0001\u00103\u001a\u00020.¢\u0006\u0004\b?\u0010@J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J7\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0019\u0010 \u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010$\u001a\u00020!8F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010&\u001a\u00020%8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0019\u0010-\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u00103\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0019\u00106\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0018R\u001c\u00109\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u0018R\u0013\u0010;\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b:\u0010\u0018R\u0019\u0010>\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0014\u001a\u0004\b=\u0010\u0018¨\u0006C"}, d2 = {"Lcom/linecorp/apng/decoder/Apng;", "", "", "recycle", "()V", "copy", "()Lcom/linecorp/apng/decoder/Apng;", "finalize", "", "frameIndex", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Rect;", "src", "dst", "Landroid/graphics/Paint;", "paint", "drawWithIndex", "(ILandroid/graphics/Canvas;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V", "c", "I", ModelAuditLogEntry.CHANGE_KEY_ID, "e", "getHeight", "()I", "height", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "bitmap", "f", "getFrameCount", "frameCount", "Landroid/graphics/Bitmap$Config;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "config", "", "isRecycled", "()Z", "", "g", "[I", "getFrameDurations", "()[I", "frameDurations", "", "i", "J", "getAllFrameByteCount", "()J", "allFrameByteCount", "h", "getLoopCount", "loopCount", "b", "getDuration", "duration", "getByteCount", "byteCount", "d", "getWidth", "width", "<init>", "(IIII[IIJ)V", "Companion", "DecodeResult", "apng-drawable_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class Apng {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final Bitmap bitmap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @IntRange(from = 0, to = 2147483647L)
    public final int duration;

    /* renamed from: c, reason: from kotlin metadata */
    public final int id;

    /* renamed from: d, reason: from kotlin metadata */
    public final int width;

    /* renamed from: e, reason: from kotlin metadata */
    public final int height;

    /* renamed from: f, reason: from kotlin metadata */
    public final int frameCount;

    /* renamed from: g, reason: from kotlin metadata */
    public final int[] frameDurations;

    /* renamed from: h, reason: from kotlin metadata */
    public final int loopCount;

    /* renamed from: i, reason: from kotlin metadata */
    public final long allFrameByteCount;

    /* compiled from: Apng.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/linecorp/apng/decoder/Apng$Companion;", "", "Ljava/io/InputStream;", "stream", "Lcom/linecorp/apng/decoder/Apng;", "decode", "(Ljava/io/InputStream;)Lcom/linecorp/apng/decoder/Apng;", "", "isApng", "(Ljava/io/InputStream;)Z", "apng", "copy", "(Lcom/linecorp/apng/decoder/Apng;)Lcom/linecorp/apng/decoder/Apng;", "<init>", "()V", "apng-drawable_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final Apng copy(Apng apng) throws ApngException {
            Intrinsics3.checkNotNullParameter(apng, "apng");
            DecodeResult decodeResult = new DecodeResult();
            Trace.beginSection("Apng#copy");
            try {
                int iCopy = ApngDecoderJni.copy(Apng.access$getId$p(apng), decodeResult);
                if (iCopy < 0) {
                    throw new ApngException(ApngException.ErrorCode.INSTANCE.fromErrorCode$apng_drawable_release(iCopy), null, 2, null);
                }
                try {
                    return new Apng(iCopy, decodeResult.getWidth(), decodeResult.getHeight(), decodeResult.getFrameCount(), decodeResult.getFrameDurations(), decodeResult.getLoopCount(), decodeResult.getAllFrameByteCount());
                } finally {
                    ApngException apngException = new ApngException(th);
                }
            } finally {
            }
        }

        public final Apng decode(InputStream stream) throws ApngException {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            DecodeResult decodeResult = new DecodeResult();
            Trace.beginSection("Apng#decode");
            try {
                int iDecode = ApngDecoderJni.decode(stream, decodeResult);
                if (iDecode < 0) {
                    throw new ApngException(ApngException.ErrorCode.INSTANCE.fromErrorCode$apng_drawable_release(iDecode), null, 2, null);
                }
                try {
                    return new Apng(iDecode, decodeResult.getWidth(), decodeResult.getHeight(), decodeResult.getFrameCount(), decodeResult.getFrameDurations(), decodeResult.getLoopCount(), decodeResult.getAllFrameByteCount());
                } finally {
                    ApngException apngException = new ApngException(th);
                }
            } finally {
            }
        }

        public final boolean isApng(InputStream stream) throws ApngException {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            try {
                return ApngDecoderJni.isApng(stream);
            } catch (Throwable th) {
                throw new ApngException(th);
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: Apng.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/linecorp/apng/decoder/Apng$DecodeResult;", "", "", "loopCount", "I", "getLoopCount", "()I", "setLoopCount", "(I)V", "width", "getWidth", "setWidth", "", "frameDurations", "[I", "getFrameDurations", "()[I", "setFrameDurations", "([I)V", "frameCount", "getFrameCount", "setFrameCount", "", "allFrameByteCount", "J", "getAllFrameByteCount", "()J", "setAllFrameByteCount", "(J)V", "height", "getHeight", "setHeight", "<init>", "()V", "apng-drawable_release"}, k = 1, mv = {1, 4, 2})
    public static final class DecodeResult {
        private long allFrameByteCount;
        private int frameCount;
        private int[] frameDurations = new int[0];
        private int height;
        private int loopCount;
        private int width;

        public final long getAllFrameByteCount() {
            return this.allFrameByteCount;
        }

        public final int getFrameCount() {
            return this.frameCount;
        }

        public final int[] getFrameDurations() {
            return this.frameDurations;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLoopCount() {
            return this.loopCount;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setAllFrameByteCount(long j) {
            this.allFrameByteCount = j;
        }

        public final void setFrameCount(int i) {
            this.frameCount = i;
        }

        public final void setFrameDurations(int[] iArr) {
            Intrinsics3.checkNotNullParameter(iArr, "<set-?>");
            this.frameDurations = iArr;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setLoopCount(int i) {
            this.loopCount = i;
        }

        public final void setWidth(int i) {
            this.width = i;
        }
    }

    public Apng(int i, int i2, int i3, @IntRange(from = 1, to = 2147483647L) int i4, int[] iArr, @IntRange(from = 0, to = 2147483647L) int i5, @IntRange(from = 0, to = 2147483647L) long j) {
        Intrinsics3.checkNotNullParameter(iArr, "frameDurations");
        this.id = i;
        this.width = i2;
        this.height = i3;
        this.frameCount = i4;
        this.frameDurations = iArr;
        this.loopCount = i5;
        this.allFrameByteCount = j;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = bitmapCreateBitmap;
        Trace.beginSection("Apng#draw");
        ApngDecoderJni.draw(i, 0, bitmapCreateBitmap);
        Trace.endSection();
        this.duration = _Arrays.sum(iArr);
    }

    public static final /* synthetic */ int access$getId$p(Apng apng) {
        return apng.id;
    }

    public final Apng copy() {
        return INSTANCE.copy(this);
    }

    public final void drawWithIndex(int frameIndex, Canvas canvas, Rect src, Rect dst, Paint paint) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(dst, "dst");
        Intrinsics3.checkNotNullParameter(paint, "paint");
        Trace.beginSection("Apng#draw");
        ApngDecoderJni.draw(this.id, frameIndex, this.bitmap);
        Trace.endSection();
        canvas.drawBitmap(this.bitmap, src, dst, paint);
    }

    public final void finalize() {
        recycle();
    }

    public final long getAllFrameByteCount() {
        return this.allFrameByteCount;
    }

    public final int getByteCount() {
        return this.bitmap.getAllocationByteCount();
    }

    public final Bitmap.Config getConfig() {
        Bitmap.Config config = this.bitmap.getConfig();
        Intrinsics3.checkNotNullExpressionValue(config, "bitmap.config");
        return config;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final int[] getFrameDurations() {
        return this.frameDurations;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isRecycled() {
        return this.bitmap.isRecycled();
    }

    public final void recycle() {
        ApngDecoderJni.recycle(this.id);
    }
}

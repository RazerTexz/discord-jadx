package com.discord.utilities.rest;

import android.content.ContentResolver;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.utilities.attachments.AttachmentUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import g0.JvmOkio;
import g0.Timeout2;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* compiled from: AttachmentRequestBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/rest/AttachmentRequestBody;", "Lokhttp3/RequestBody;", "", "contentLength", "()J", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "Lokio/BufferedSink;", "sink", "", "writeTo", "(Lokio/BufferedSink;)V", "", "toString", "()Ljava/lang/String;", "Lcom/lytefast/flexinput/model/Attachment;", "attachment", "Lcom/lytefast/flexinput/model/Attachment;", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/ContentResolver;", "size", "J", "<init>", "(Landroid/content/ContentResolver;Lcom/lytefast/flexinput/model/Attachment;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AttachmentRequestBody extends RequestBody {
    private final Attachment<?> attachment;
    private final ContentResolver contentResolver;
    private final long size;

    public AttachmentRequestBody(ContentResolver contentResolver, Attachment<?> attachment) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        this.contentResolver = contentResolver;
        this.attachment = attachment;
        Object data = attachment.getData();
        File file = (File) (data instanceof File ? data : null);
        this.size = file != null ? file.length() : SendUtils5.computeFileSizeBytes(attachment.getUri(), contentResolver);
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentLength, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.b(AttachmentUtils.getMimeType(this.attachment, this.contentResolver));
    }

    public String toString() {
        StringBuilder sbU = outline.U("AttachmentRequestBody(attachment=");
        sbU.append(this.attachment);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics3.checkNotNullParameter(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(this.attachment.getUri());
            if (inputStreamOpenInputStream == null) {
                return;
            }
            try {
                Intrinsics3.checkNotNullExpressionValue(inputStreamOpenInputStream, "inputStream");
                Intrinsics3.checkParameterIsNotNull(inputStreamOpenInputStream, "$this$source");
                JvmOkio jvmOkio = new JvmOkio(inputStreamOpenInputStream, new Timeout2());
                try {
                    sink.P(jvmOkio);
                    Closeable.closeFinally(jvmOkio, null);
                    Closeable.closeFinally(inputStreamOpenInputStream, null);
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AppLog.g.i("Could not write to sink", e);
            throw e;
        }
    }
}

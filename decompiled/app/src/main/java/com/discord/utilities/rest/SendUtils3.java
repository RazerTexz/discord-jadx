package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.attachments.AttachmentUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.t._Collections;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SendUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB3\u0012\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJB\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\tR#\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/rest/ProcessedMessageContent;", "", "", "Lcom/lytefast/flexinput/model/Attachment;", "component1", "()Ljava/util/List;", "component2", "", "component3", "()Ljava/lang/String;", "validAttachments", "invalidAttachments", "content", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/discord/utilities/rest/ProcessedMessageContent;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getValidAttachments", "Ljava/lang/String;", "getContent", "getInvalidAttachments", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rest.ProcessedMessageContent, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class SendUtils3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final List<Attachment<?>> invalidAttachments;
    private final List<Attachment<?>> validAttachments;

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0011\u001a\u00020\u00102\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/rest/ProcessedMessageContent$Companion;", "", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Landroid/content/ContentResolver;", "contentResolver", "", "isUriValid", "(Landroid/net/Uri;Landroid/content/ContentResolver;)Z", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "", "content", "Landroid/content/Context;", "context", "Lcom/discord/utilities/rest/ProcessedMessageContent;", "fromAttachments", "(Ljava/util/List;Ljava/lang/String;Landroid/content/Context;)Lcom/discord/utilities/rest/ProcessedMessageContent;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.ProcessedMessageContent$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final boolean isUriValid(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    Closeable.closeFinally(inputStreamOpenInputStream, null);
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final SendUtils3 fromAttachments(List<? extends Attachment<?>> attachments, String content, Context context) {
            Intrinsics3.checkNotNullParameter(attachments, "attachments");
            Intrinsics3.checkNotNullParameter(content, "content");
            Intrinsics3.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            List<Attachment<?>> listExtractLinks = AttachmentUtils.extractLinks(attachments, contentResolver);
            String strAppendLinks = AttachmentUtils.appendLinks(content, listExtractLinks);
            for (Attachment attachment : _Collections.minus((Iterable) attachments, (Iterable) listExtractLinks)) {
                Uri uri = attachment.getUri();
                ContentResolver contentResolver2 = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                if (isUriValid(uri, contentResolver2)) {
                    arrayList.add(attachment);
                } else {
                    arrayList2.add(attachment);
                }
            }
            return new SendUtils3(arrayList, arrayList2, strAppendLinks);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendUtils3(List<? extends Attachment<?>> list, List<? extends Attachment<?>> list2, String str) {
        Intrinsics3.checkNotNullParameter(list, "validAttachments");
        Intrinsics3.checkNotNullParameter(list2, "invalidAttachments");
        Intrinsics3.checkNotNullParameter(str, "content");
        this.validAttachments = list;
        this.invalidAttachments = list2;
        this.content = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendUtils3 copy$default(SendUtils3 sendUtils3, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sendUtils3.validAttachments;
        }
        if ((i & 2) != 0) {
            list2 = sendUtils3.invalidAttachments;
        }
        if ((i & 4) != 0) {
            str = sendUtils3.content;
        }
        return sendUtils3.copy(list, list2, str);
    }

    public final List<Attachment<?>> component1() {
        return this.validAttachments;
    }

    public final List<Attachment<?>> component2() {
        return this.invalidAttachments;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final SendUtils3 copy(List<? extends Attachment<?>> validAttachments, List<? extends Attachment<?>> invalidAttachments, String content) {
        Intrinsics3.checkNotNullParameter(validAttachments, "validAttachments");
        Intrinsics3.checkNotNullParameter(invalidAttachments, "invalidAttachments");
        Intrinsics3.checkNotNullParameter(content, "content");
        return new SendUtils3(validAttachments, invalidAttachments, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUtils3)) {
            return false;
        }
        SendUtils3 sendUtils3 = (SendUtils3) other;
        return Intrinsics3.areEqual(this.validAttachments, sendUtils3.validAttachments) && Intrinsics3.areEqual(this.invalidAttachments, sendUtils3.invalidAttachments) && Intrinsics3.areEqual(this.content, sendUtils3.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Attachment<?>> getInvalidAttachments() {
        return this.invalidAttachments;
    }

    public final List<Attachment<?>> getValidAttachments() {
        return this.validAttachments;
    }

    public int hashCode() {
        List<Attachment<?>> list = this.validAttachments;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Attachment<?>> list2 = this.invalidAttachments;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.content;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ProcessedMessageContent(validAttachments=");
        sbU.append(this.validAttachments);
        sbU.append(", invalidAttachments=");
        sbU.append(this.invalidAttachments);
        sbU.append(", content=");
        return outline.J(sbU, this.content, ")");
    }
}

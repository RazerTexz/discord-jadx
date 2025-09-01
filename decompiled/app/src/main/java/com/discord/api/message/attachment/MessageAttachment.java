package com.discord.api.message.attachment;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: MessageAttachment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\u001c\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u001e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u0019\u0010!\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\nR\u0019\u0010#\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\n¨\u0006&"}, d2 = {"Lcom/discord/api/message/attachment/MessageAttachment;", "", "", "h", "()Z", "Lcom/discord/api/message/attachment/MessageAttachmentType;", "e", "()Lcom/discord/api/message/attachment/MessageAttachmentType;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "", "size", "J", "d", "()J", "width", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "height", "b", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "url", "Ljava/lang/String;", "f", "filename", "a", "proxyUrl", "c", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageAttachment {
    public static final String SPOILER_PREFIX = "SPOILER_";
    private final String filename;
    private final Integer height;
    private final long id;
    private final String proxyUrl;
    private final long size;
    private final String url;
    private final Integer width;

    /* renamed from: a, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* renamed from: c, reason: from getter */
    public final String getProxyUrl() {
        return this.proxyUrl;
    }

    /* renamed from: d, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final MessageAttachmentType e() {
        boolean z2;
        String str = this.url;
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> listA = MessageAttachment2.a();
        boolean z3 = true;
        if ((listA instanceof Collection) && listA.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            return MessageAttachmentType.IMAGE;
        }
        List<String> listB = MessageAttachment2.b();
        if ((listB instanceof Collection) && listB.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it2 = listB.iterator();
            while (it2.hasNext()) {
                if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) it2.next(), false, 2, (Object) null)) {
                    break;
                }
            }
            z3 = false;
        }
        return z3 ? MessageAttachmentType.VIDEO : MessageAttachmentType.FILE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageAttachment)) {
            return false;
        }
        MessageAttachment messageAttachment = (MessageAttachment) other;
        return Intrinsics3.areEqual(this.url, messageAttachment.url) && this.size == messageAttachment.size && this.id == messageAttachment.id && Intrinsics3.areEqual(this.proxyUrl, messageAttachment.proxyUrl) && Intrinsics3.areEqual(this.filename, messageAttachment.filename) && Intrinsics3.areEqual(this.width, messageAttachment.width) && Intrinsics3.areEqual(this.height, messageAttachment.height);
    }

    /* renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: g, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    public final boolean h() {
        return StringsJVM.startsWith$default(this.filename, SPOILER_PREFIX, false, 2, null);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.size;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.id;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str2 = this.proxyUrl;
        int iHashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.filename;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.width;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageAttachment(url=");
        sbU.append(this.url);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", proxyUrl=");
        sbU.append(this.proxyUrl);
        sbU.append(", filename=");
        sbU.append(this.filename);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return outline.F(sbU, this.height, ")");
    }
}

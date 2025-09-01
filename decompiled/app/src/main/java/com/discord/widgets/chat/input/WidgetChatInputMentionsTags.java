package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetChatInputMentionsTags.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputMentionsTags;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "component1", "()Ljava/util/List;", "", "component2", "()C", "", "component3", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_TAGS, "tokenIdentifier", "token", "copy", "(Ljava/util/List;CLjava/lang/String;)Lcom/discord/widgets/chat/input/WidgetChatInputMentionsTags;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "C", "getTokenIdentifier", "Ljava/util/List;", "getTags", "<init>", "(Ljava/util/List;CLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatInputMentionsTags<T> {
    private final List<T> tags;
    private final String token;
    private final char tokenIdentifier;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputMentionsTags(List<? extends T> list, char c, String str) {
        Intrinsics3.checkNotNullParameter(list, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        Intrinsics3.checkNotNullParameter(str, "token");
        this.tags = list;
        this.tokenIdentifier = c;
        this.token = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatInputMentionsTags copy$default(WidgetChatInputMentionsTags widgetChatInputMentionsTags, List list, char c, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetChatInputMentionsTags.tags;
        }
        if ((i & 2) != 0) {
            c = widgetChatInputMentionsTags.tokenIdentifier;
        }
        if ((i & 4) != 0) {
            str = widgetChatInputMentionsTags.token;
        }
        return widgetChatInputMentionsTags.copy(list, c, str);
    }

    public final List<T> component1() {
        return this.tags;
    }

    /* renamed from: component2, reason: from getter */
    public final char getTokenIdentifier() {
        return this.tokenIdentifier;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final WidgetChatInputMentionsTags<T> copy(List<? extends T> tags, char tokenIdentifier, String token) {
        Intrinsics3.checkNotNullParameter(tags, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        Intrinsics3.checkNotNullParameter(token, "token");
        return new WidgetChatInputMentionsTags<>(tags, tokenIdentifier, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputMentionsTags)) {
            return false;
        }
        WidgetChatInputMentionsTags widgetChatInputMentionsTags = (WidgetChatInputMentionsTags) other;
        return Intrinsics3.areEqual(this.tags, widgetChatInputMentionsTags.tags) && this.tokenIdentifier == widgetChatInputMentionsTags.tokenIdentifier && Intrinsics3.areEqual(this.token, widgetChatInputMentionsTags.token);
    }

    public final List<T> getTags() {
        return this.tags;
    }

    public final String getToken() {
        return this.token;
    }

    public final char getTokenIdentifier() {
        return this.tokenIdentifier;
    }

    public int hashCode() {
        List<T> list = this.tags;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.tokenIdentifier) * 31;
        String str = this.token;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatInputMentionsTags(tags=");
        sbU.append(this.tags);
        sbU.append(", tokenIdentifier=");
        sbU.append(this.tokenIdentifier);
        sbU.append(", token=");
        return outline.J(sbU, this.token, ")");
    }
}

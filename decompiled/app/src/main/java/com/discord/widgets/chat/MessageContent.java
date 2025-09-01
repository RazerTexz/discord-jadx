package com.discord.widgets.chat;

import b.d.b.a.outline;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MessageContent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/MessageContent;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/models/user/User;", "component2", "()Ljava/util/List;", "textContent", "mentionedUsers", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/widgets/chat/MessageContent;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMentionedUsers", "Ljava/lang/String;", "getTextContent", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MessageContent {
    private final List<User> mentionedUsers;
    private final String textContent;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageContent(String str, List<? extends User> list) {
        Intrinsics3.checkNotNullParameter(str, "textContent");
        Intrinsics3.checkNotNullParameter(list, "mentionedUsers");
        this.textContent = str;
        this.mentionedUsers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageContent copy$default(MessageContent messageContent, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageContent.textContent;
        }
        if ((i & 2) != 0) {
            list = messageContent.mentionedUsers;
        }
        return messageContent.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    public final List<User> component2() {
        return this.mentionedUsers;
    }

    public final MessageContent copy(String textContent, List<? extends User> mentionedUsers) {
        Intrinsics3.checkNotNullParameter(textContent, "textContent");
        Intrinsics3.checkNotNullParameter(mentionedUsers, "mentionedUsers");
        return new MessageContent(textContent, mentionedUsers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageContent)) {
            return false;
        }
        MessageContent messageContent = (MessageContent) other;
        return Intrinsics3.areEqual(this.textContent, messageContent.textContent) && Intrinsics3.areEqual(this.mentionedUsers, messageContent.mentionedUsers);
    }

    public final List<User> getMentionedUsers() {
        return this.mentionedUsers;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public int hashCode() {
        String str = this.textContent;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<User> list = this.mentionedUsers;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageContent(textContent=");
        sbU.append(this.textContent);
        sbU.append(", mentionedUsers=");
        return outline.L(sbU, this.mentionedUsers, ")");
    }
}

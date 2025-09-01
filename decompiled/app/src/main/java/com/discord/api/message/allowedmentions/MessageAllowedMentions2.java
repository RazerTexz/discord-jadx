package com.discord.api.message.allowedmentions;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import kotlin.Metadata;

/* compiled from: MessageAllowedMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/discord/api/message/allowedmentions/MessageAllowedMentionsTypes;", "", "", "serialize", "()Ljava/lang/String;", "apiStringRepresentation", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "USERS", "ROLES", "EVERYONE", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes, reason: use source file name */
/* loaded from: classes.dex */
public enum MessageAllowedMentions2 {
    USERS("users"),
    ROLES("roles"),
    EVERYONE(ModelGuildMemberListUpdate.EVERYONE_ID);

    private final String apiStringRepresentation;

    MessageAllowedMentions2(String str) {
        this.apiStringRepresentation = str;
    }

    /* renamed from: serialize, reason: from getter */
    public final String getApiStringRepresentation() {
        return this.apiStringRepresentation;
    }
}

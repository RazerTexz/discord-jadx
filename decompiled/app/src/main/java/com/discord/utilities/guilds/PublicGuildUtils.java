package com.discord.utilities.guilds;

import com.discord.api.message.MessageReference;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PublicGuildUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/utilities/guilds/PublicGuildUtils;", "", "Lcom/discord/models/message/Message;", "message", "", "isPublicGuildSystemMessage", "(Lcom/discord/models/message/Message;)Z", "", "PUBLIC_GUILD_UPDATES_WEBHOOK_USER_ID", "J", "PUBLIC_GUILD_ANNOUNCEMENTS_GUILD_ID", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PublicGuildUtils {
    public static final PublicGuildUtils INSTANCE = new PublicGuildUtils();
    private static final long PUBLIC_GUILD_ANNOUNCEMENTS_GUILD_ID = 667560445975986187L;
    private static final long PUBLIC_GUILD_UPDATES_WEBHOOK_USER_ID = 669627189624307712L;

    private PublicGuildUtils() {
    }

    public final boolean isPublicGuildSystemMessage(Message message) {
        User author;
        Intrinsics3.checkNotNullParameter(message, "message");
        MessageReference messageReference = message.getMessageReference();
        Long guildId = messageReference != null ? messageReference.getGuildId() : null;
        return (guildId != null && guildId.longValue() == PUBLIC_GUILD_ANNOUNCEMENTS_GUILD_ID) || ((author = message.getAuthor()) != null && author.getId() == PUBLIC_GUILD_UPDATES_WEBHOOK_USER_ID);
    }
}

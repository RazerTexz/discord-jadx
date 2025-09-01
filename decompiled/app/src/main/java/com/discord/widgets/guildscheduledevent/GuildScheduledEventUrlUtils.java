package com.discord.widgets.guildscheduledevent;

import com.discord.BuildConfig;
import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventUrlUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUrlUtils;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "guildEventId", "", "getEventDetailsUrl", "(JJ)Ljava/lang/CharSequence;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventUrlUtils {
    public static final GuildScheduledEventUrlUtils INSTANCE = new GuildScheduledEventUrlUtils();

    private GuildScheduledEventUrlUtils() {
    }

    public final CharSequence getEventDetailsUrl(long guildId, long guildEventId) {
        return BuildConfig.HOST + "/events/" + guildId + MentionUtils.SLASH_CHAR + guildEventId;
    }
}

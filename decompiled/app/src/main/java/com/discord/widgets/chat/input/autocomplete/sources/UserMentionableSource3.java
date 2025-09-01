package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import kotlin.Metadata;

/* compiled from: UserMentionableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "", "isTextOrVoiceChannel", "(Lcom/discord/api/channel/Channel;)Z", "isDmOrGroupDm", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserMentionableSourceKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class UserMentionableSource3 {
    public static final /* synthetic */ boolean access$isDmOrGroupDm(Channel channel) {
        return isDmOrGroupDm(channel);
    }

    public static final /* synthetic */ boolean access$isTextOrVoiceChannel(Channel channel) {
        return isTextOrVoiceChannel(channel);
    }

    private static final boolean isDmOrGroupDm(Channel channel) {
        return channel.getType() == 3 || channel.getType() == 1;
    }

    private static final boolean isTextOrVoiceChannel(Channel channel) {
        return channel.getType() == 5 || channel.getType() == 0 || channel.getType() == 11 || channel.getType() == 12 || channel.getType() == 2;
    }
}

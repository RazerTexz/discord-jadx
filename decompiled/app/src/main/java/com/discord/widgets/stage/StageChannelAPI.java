package com.discord.widgets.stage;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: StageChannelAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ%\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\rJ?\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u000e¢\u0006\u0004\b\u0012\u0010\u0013JC\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/stage/StageChannelAPI;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "accept", "Lrx/Observable;", "Ljava/lang/Void;", "ackInvitationToSpeak", "(JZ)Lrx/Observable;", "Lcom/discord/api/channel/Channel;", "channel", "(Lcom/discord/api/channel/Channel;Z)Lrx/Observable;", "Lcom/discord/primitives/UserId;", "userId", "isSuppressed", "meId", "setUserSuppressedInChannel", "(Lcom/discord/api/channel/Channel;JZJ)Lrx/Observable;", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "privacyLevel", "sendStartNotification", "guildScheduledEventId", "Lcom/discord/api/stageinstance/StageInstance;", "startStageInstance", "(JLjava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;ZLjava/lang/String;)Lrx/Observable;", "updateStageInstance", "(JLjava/lang/String;Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageChannelAPI {
    public static final StageChannelAPI INSTANCE = new StageChannelAPI();

    private StageChannelAPI() {
    }

    public static /* synthetic */ Observable setUserSuppressedInChannel$default(StageChannelAPI stageChannelAPI, Channel channel, long j, boolean z2, long j2, int i, Object obj) {
        if ((i & 8) != 0) {
            j2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        }
        return stageChannelAPI.setUserSuppressedInChannel(channel, j, z2, j2);
    }

    public static /* synthetic */ Observable startStageInstance$default(StageChannelAPI stageChannelAPI, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = null;
        }
        return stageChannelAPI.startStageInstance(j, str, stageInstancePrivacyLevel, z2, str2);
    }

    public static /* synthetic */ Observable updateStageInstance$default(StageChannelAPI stageChannelAPI, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            stageInstancePrivacyLevel = null;
        }
        return stageChannelAPI.updateStageInstance(j, str, stageInstancePrivacyLevel);
    }

    public final Observable<Void> ackInvitationToSpeak(long channelId, boolean accept) {
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(channelId);
        if (channel != null) {
            return INSTANCE.ackInvitationToSpeak(channel, accept);
        }
        return null;
    }

    public final Observable<Void> setUserSuppressedInChannel(Channel channel, long userId, boolean isSuppressed, long meId) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return userId == meId ? RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, isSuppressed) : RestAPI.INSTANCE.getApi().setUserSuppressed(channel, userId, isSuppressed);
    }

    public final Observable<StageInstance> startStageInstance(long channelId, String topic, StageInstancePrivacyLevel privacyLevel, boolean sendStartNotification, String guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        Intrinsics3.checkNotNullParameter(privacyLevel, "privacyLevel");
        return RestAPI.INSTANCE.getApi().startStageInstance(new RestAPIParams.StartStageInstanceBody(channelId, topic, privacyLevel, sendStartNotification, guildScheduledEventId));
    }

    public final Observable<StageInstance> updateStageInstance(long channelId, String topic, StageInstancePrivacyLevel privacyLevel) {
        return RestAPI.INSTANCE.getApi().updateStageInstance(channelId, new RestAPIParams.UpdateStageInstanceBody(topic, privacyLevel));
    }

    public final Observable<Void> ackInvitationToSpeak(Channel channel, boolean accept) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return setUserSuppressedInChannel$default(this, channel, StoreStream.INSTANCE.getUsers().getMeSnapshot().getId(), !accept, 0L, 8, null);
    }
}

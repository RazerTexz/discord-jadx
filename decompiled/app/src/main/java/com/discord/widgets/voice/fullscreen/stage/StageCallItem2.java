package com.discord.widgets.voice.fullscreen.stage;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants;
import kotlin.Metadata;

/* compiled from: StageCallItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallParticipantItem;", "", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getVoiceUser", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceUser", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem, reason: use source file name */
/* loaded from: classes.dex */
public interface StageCallItem2 {
    Channel getChannel();

    StoreVoiceParticipants.VoiceUser getVoiceUser();
}

package com.discord.widgets.stage.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StageCallModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JL\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\n¨\u0006,"}, d2 = {"Lcom/discord/widgets/stage/model/StageMediaParticipant;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component2", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "component4", "()Z", "component5", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", "component6", "()Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", ModelAuditLogEntry.CHANGE_KEY_ID, "voiceUser", "channel", "isModerator", "isBlocked", "mediaType", "copy", "(Ljava/lang/String;Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;ZZLcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;)Lcom/discord/widgets/stage/model/StageMediaParticipant;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getVoiceUser", "Ljava/lang/String;", "getId", "Z", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;", "getMediaType", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Ljava/lang/String;Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/channel/Channel;ZZLcom/discord/widgets/voice/fullscreen/stage/StageCallItem$MediaType;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.model.StageMediaParticipant, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StageCallModel5 {
    private final Channel channel;
    private final String id;
    private final boolean isBlocked;
    private final boolean isModerator;
    private final StageCallItem.MediaType mediaType;
    private final StoreVoiceParticipants.VoiceUser voiceUser;

    public StageCallModel5(String str, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, StageCallItem.MediaType mediaType) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        this.id = str;
        this.voiceUser = voiceUser;
        this.channel = channel;
        this.isModerator = z2;
        this.isBlocked = z3;
        this.mediaType = mediaType;
    }

    public static /* synthetic */ StageCallModel5 copy$default(StageCallModel5 stageCallModel5, String str, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean z2, boolean z3, StageCallItem.MediaType mediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stageCallModel5.id;
        }
        if ((i & 2) != 0) {
            voiceUser = stageCallModel5.voiceUser;
        }
        StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
        if ((i & 4) != 0) {
            channel = stageCallModel5.channel;
        }
        Channel channel2 = channel;
        if ((i & 8) != 0) {
            z2 = stageCallModel5.isModerator;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = stageCallModel5.isBlocked;
        }
        boolean z5 = z3;
        if ((i & 32) != 0) {
            mediaType = stageCallModel5.mediaType;
        }
        return stageCallModel5.copy(str, voiceUser2, channel2, z4, z5, mediaType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final StoreVoiceParticipants.VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    /* renamed from: component6, reason: from getter */
    public final StageCallItem.MediaType getMediaType() {
        return this.mediaType;
    }

    public final StageCallModel5 copy(String id2, StoreVoiceParticipants.VoiceUser voiceUser, Channel channel, boolean isModerator, boolean isBlocked, StageCallItem.MediaType mediaType) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        return new StageCallModel5(id2, voiceUser, channel, isModerator, isBlocked, mediaType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallModel5)) {
            return false;
        }
        StageCallModel5 stageCallModel5 = (StageCallModel5) other;
        return Intrinsics3.areEqual(this.id, stageCallModel5.id) && Intrinsics3.areEqual(this.voiceUser, stageCallModel5.voiceUser) && Intrinsics3.areEqual(this.channel, stageCallModel5.channel) && this.isModerator == stageCallModel5.isModerator && this.isBlocked == stageCallModel5.isBlocked && Intrinsics3.areEqual(this.mediaType, stageCallModel5.mediaType);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getId() {
        return this.id;
    }

    public final StageCallItem.MediaType getMediaType() {
        return this.mediaType;
    }

    public final StoreVoiceParticipants.VoiceUser getVoiceUser() {
        return this.voiceUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        StoreVoiceParticipants.VoiceUser voiceUser = this.voiceUser;
        int iHashCode2 = (iHashCode + (voiceUser != null ? voiceUser.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.isBlocked;
        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        StageCallItem.MediaType mediaType = this.mediaType;
        return i3 + (mediaType != null ? mediaType.hashCode() : 0);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageMediaParticipant(id=");
        sbU.append(this.id);
        sbU.append(", voiceUser=");
        sbU.append(this.voiceUser);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", isBlocked=");
        sbU.append(this.isBlocked);
        sbU.append(", mediaType=");
        sbU.append(this.mediaType);
        sbU.append(")");
        return sbU.toString();
    }
}

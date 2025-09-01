package com.discord.api.stageinstance;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StageInstance.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/discord/api/stageinstance/StageInstance;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "Ljava/lang/String;", "f", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "c", "()J", "guildId", "b", "inviteCode", "d", "channelId", "a", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "privacyLevel", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "e", "()Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class StageInstance {
    private final long channelId;
    private final long guildId;
    private final long id;
    private final String inviteCode;
    private final StageInstancePrivacyLevel privacyLevel;
    private final String topic;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: e, reason: from getter */
    public final StageInstancePrivacyLevel getPrivacyLevel() {
        return this.privacyLevel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageInstance)) {
            return false;
        }
        StageInstance stageInstance = (StageInstance) other;
        return this.id == stageInstance.id && this.guildId == stageInstance.guildId && this.channelId == stageInstance.channelId && Intrinsics3.areEqual(this.topic, stageInstance.topic) && Intrinsics3.areEqual(this.privacyLevel, stageInstance.privacyLevel) && Intrinsics3.areEqual(this.inviteCode, stageInstance.inviteCode);
    }

    /* renamed from: f, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.channelId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.topic;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
        int iHashCode2 = (iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
        String str2 = this.inviteCode;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageInstance(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", inviteCode=");
        return outline.J(sbU, this.inviteCode, ")");
    }
}

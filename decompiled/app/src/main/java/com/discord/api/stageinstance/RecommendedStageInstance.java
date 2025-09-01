package com.discord.api.stageinstance;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: RecommendedStageInstance.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 ¨\u0006)"}, d2 = {"Lcom/discord/api/stageinstance/RecommendedStageInstance;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "participantCount", "I", "b", "", "score", "D", "getScore", "()D", "source", "getSource", "Lcom/discord/api/stageinstance/RecommendedStageInstanceGuild;", "guild", "Lcom/discord/api/stageinstance/RecommendedStageInstanceGuild;", "getGuild", "()Lcom/discord/api/stageinstance/RecommendedStageInstanceGuild;", "", "Lcom/discord/api/guildmember/GuildMember;", "sampleSpeakerMembers", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/discord/api/stageinstance/StageInstance;", "instance", "Lcom/discord/api/stageinstance/StageInstance;", "a", "()Lcom/discord/api/stageinstance/StageInstance;", "", "speakers", "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class RecommendedStageInstance {
    private final RecommendedStageInstanceGuild guild;
    private final StageInstance instance;
    private final int participantCount;
    private final List<GuildMember> sampleSpeakerMembers;
    private final double score;
    private final int source;
    private final List<Long> speakers;

    /* renamed from: a, reason: from getter */
    public final StageInstance getInstance() {
        return this.instance;
    }

    /* renamed from: b, reason: from getter */
    public final int getParticipantCount() {
        return this.participantCount;
    }

    public final List<GuildMember> c() {
        return this.sampleSpeakerMembers;
    }

    public final List<Long> d() {
        return this.speakers;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedStageInstance)) {
            return false;
        }
        RecommendedStageInstance recommendedStageInstance = (RecommendedStageInstance) other;
        return Intrinsics3.areEqual(this.guild, recommendedStageInstance.guild) && Intrinsics3.areEqual(this.instance, recommendedStageInstance.instance) && Intrinsics3.areEqual(this.speakers, recommendedStageInstance.speakers) && Intrinsics3.areEqual(this.sampleSpeakerMembers, recommendedStageInstance.sampleSpeakerMembers) && this.participantCount == recommendedStageInstance.participantCount && this.source == recommendedStageInstance.source && Double.compare(this.score, recommendedStageInstance.score) == 0;
    }

    public int hashCode() {
        RecommendedStageInstanceGuild recommendedStageInstanceGuild = this.guild;
        int iHashCode = (recommendedStageInstanceGuild != null ? recommendedStageInstanceGuild.hashCode() : 0) * 31;
        StageInstance stageInstance = this.instance;
        int iHashCode2 = (iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        List<Long> list = this.speakers;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildMember> list2 = this.sampleSpeakerMembers;
        int iHashCode4 = (((((iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.participantCount) * 31) + this.source) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.score);
        return iHashCode4 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("RecommendedStageInstance(guild=");
        sbU.append(this.guild);
        sbU.append(", instance=");
        sbU.append(this.instance);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", sampleSpeakerMembers=");
        sbU.append(this.sampleSpeakerMembers);
        sbU.append(", participantCount=");
        sbU.append(this.participantCount);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", score=");
        sbU.append(this.score);
        sbU.append(")");
        return sbU.toString();
    }
}

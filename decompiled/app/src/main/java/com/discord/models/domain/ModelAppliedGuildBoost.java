package com.discord.models.domain;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: ModelAppliedGuildBoost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0002j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J:\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0005R\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/discord/models/domain/ModelAppliedGuildBoost;", "", "", "Lcom/discord/primitives/AppliedGuildBoostId;", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "Lcom/discord/primitives/UserId;", "component3", ModelAuditLogEntry.CHANGE_KEY_ID, "guildId", "userId", "copy", "(JJJ)Lcom/discord/models/domain/ModelAppliedGuildBoost;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUserId", "getId", "getGuildId", "<init>", "(JJJ)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelAppliedGuildBoost {
    private final long guildId;
    private final long id;
    private final long userId;

    public ModelAppliedGuildBoost(long j, long j2, long j3) {
        this.id = j;
        this.guildId = j2;
        this.userId = j3;
    }

    public static /* synthetic */ ModelAppliedGuildBoost copy$default(ModelAppliedGuildBoost modelAppliedGuildBoost, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelAppliedGuildBoost.id;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = modelAppliedGuildBoost.guildId;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = modelAppliedGuildBoost.userId;
        }
        return modelAppliedGuildBoost.copy(j4, j5, j3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final ModelAppliedGuildBoost copy(long id2, long guildId, long userId) {
        return new ModelAppliedGuildBoost(id2, guildId, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelAppliedGuildBoost)) {
            return false;
        }
        ModelAppliedGuildBoost modelAppliedGuildBoost = (ModelAppliedGuildBoost) other;
        return this.id == modelAppliedGuildBoost.id && this.guildId == modelAppliedGuildBoost.guildId && this.userId == modelAppliedGuildBoost.userId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getId() {
        return this.id;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        return i + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelAppliedGuildBoost(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        return outline.C(sbU, this.userId, ")");
    }
}

package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelGuildTemplate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\u0010\u0019\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\u0010\u001d\u001a\u00060\u000ej\u0002`\u000f\u0012\n\u0010\u001e\u001a\u00060\u000ej\u0002`\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b:\u0010;J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0002j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0012\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011J\u0010\u0010\u0018\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0011J\u0088\u0001\u0010#\u001a\u00020\u00002\f\b\u0002\u0010\u0019\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\f\b\u0002\u0010\u001b\u001a\u00060\u0002j\u0002`\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\f\b\u0002\u0010\u001d\u001a\u00060\u000ej\u0002`\u000f2\f\b\u0002\u0010\u001e\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b%\u0010\u0011J\u0010\u0010&\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b&\u0010\u0015J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001d\u0010\u001d\u001a\u00060\u000ej\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010\u0011R\u0019\u0010!\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b-\u0010\u0011R\u0019\u0010\"\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010+\u001a\u0004\b.\u0010\u0011R\u001d\u0010\u0019\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u0010\u0005R\u001d\u0010\u001e\u001a\u00060\u000ej\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b1\u0010\u0011R\u001d\u0010\u001b\u001a\u00060\u0002j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b2\u0010\u0005R\u0019\u0010\u001f\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b4\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\rR\u0019\u0010 \u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010+\u001a\u0004\b7\u0010\u0011R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010\b¨\u0006<"}, d2 = {"Lcom/discord/models/domain/ModelGuildTemplate;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/api/user/User;", "component2", "()Lcom/discord/api/user/User;", "Lcom/discord/primitives/GuildId;", "component3", "Lcom/discord/api/guild/Guild;", "component4", "()Lcom/discord/api/guild/Guild;", "", "Lcom/discord/primitives/UtcTimestamp;", "component5", "()Ljava/lang/String;", "component6", "", "component7", "()I", "component8", "component9", "component10", "creatorId", "creator", "sourceGuildId", "serializedSourceGuild", "createdAt", "updatedAt", "usageCount", ModelAuditLogEntry.CHANGE_KEY_CODE, ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "copy", "(JLcom/discord/api/user/User;JLcom/discord/api/guild/Guild;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/ModelGuildTemplate;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCreatedAt", "getName", "getDescription", "J", "getCreatorId", "getUpdatedAt", "getSourceGuildId", "I", "getUsageCount", "Lcom/discord/api/guild/Guild;", "getSerializedSourceGuild", "getCode", "Lcom/discord/api/user/User;", "getCreator", "<init>", "(JLcom/discord/api/user/User;JLcom/discord/api/guild/Guild;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGuildTemplate {
    private final String code;
    private final String createdAt;
    private final User creator;
    private final long creatorId;
    private final String description;
    private final String name;
    private final Guild serializedSourceGuild;
    private final long sourceGuildId;
    private final String updatedAt;
    private final int usageCount;

    public ModelGuildTemplate(long j, User user, long j2, Guild guild, String str, String str2, int i, String str3, String str4, String str5) {
        Intrinsics3.checkNotNullParameter(str, "createdAt");
        Intrinsics3.checkNotNullParameter(str2, "updatedAt");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str5, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.creatorId = j;
        this.creator = user;
        this.sourceGuildId = j2;
        this.serializedSourceGuild = guild;
        this.createdAt = str;
        this.updatedAt = str2;
        this.usageCount = i;
        this.code = str3;
        this.name = str4;
        this.description = str5;
    }

    public static /* synthetic */ ModelGuildTemplate copy$default(ModelGuildTemplate modelGuildTemplate, long j, User user, long j2, Guild guild, String str, String str2, int i, String str3, String str4, String str5, int i2, Object obj) {
        return modelGuildTemplate.copy((i2 & 1) != 0 ? modelGuildTemplate.creatorId : j, (i2 & 2) != 0 ? modelGuildTemplate.creator : user, (i2 & 4) != 0 ? modelGuildTemplate.sourceGuildId : j2, (i2 & 8) != 0 ? modelGuildTemplate.serializedSourceGuild : guild, (i2 & 16) != 0 ? modelGuildTemplate.createdAt : str, (i2 & 32) != 0 ? modelGuildTemplate.updatedAt : str2, (i2 & 64) != 0 ? modelGuildTemplate.usageCount : i, (i2 & 128) != 0 ? modelGuildTemplate.code : str3, (i2 & 256) != 0 ? modelGuildTemplate.name : str4, (i2 & 512) != 0 ? modelGuildTemplate.description : str5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreatorId() {
        return this.creatorId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final User getCreator() {
        return this.creator;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSourceGuildId() {
        return this.sourceGuildId;
    }

    /* renamed from: component4, reason: from getter */
    public final Guild getSerializedSourceGuild() {
        return this.serializedSourceGuild;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component7, reason: from getter */
    public final int getUsageCount() {
        return this.usageCount;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildTemplate copy(long creatorId, User creator, long sourceGuildId, Guild serializedSourceGuild, String createdAt, String updatedAt, int usageCount, String code, String name, String description) {
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics3.checkNotNullParameter(updatedAt, "updatedAt");
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new ModelGuildTemplate(creatorId, creator, sourceGuildId, serializedSourceGuild, createdAt, updatedAt, usageCount, code, name, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildTemplate)) {
            return false;
        }
        ModelGuildTemplate modelGuildTemplate = (ModelGuildTemplate) other;
        return this.creatorId == modelGuildTemplate.creatorId && Intrinsics3.areEqual(this.creator, modelGuildTemplate.creator) && this.sourceGuildId == modelGuildTemplate.sourceGuildId && Intrinsics3.areEqual(this.serializedSourceGuild, modelGuildTemplate.serializedSourceGuild) && Intrinsics3.areEqual(this.createdAt, modelGuildTemplate.createdAt) && Intrinsics3.areEqual(this.updatedAt, modelGuildTemplate.updatedAt) && this.usageCount == modelGuildTemplate.usageCount && Intrinsics3.areEqual(this.code, modelGuildTemplate.code) && Intrinsics3.areEqual(this.name, modelGuildTemplate.name) && Intrinsics3.areEqual(this.description, modelGuildTemplate.description);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final User getCreator() {
        return this.creator;
    }

    public final long getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Guild getSerializedSourceGuild() {
        return this.serializedSourceGuild;
    }

    public final long getSourceGuildId() {
        return this.sourceGuildId;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getUsageCount() {
        return this.usageCount;
    }

    public int hashCode() {
        long j = this.creatorId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.creator;
        int iHashCode = user != null ? user.hashCode() : 0;
        long j2 = this.sourceGuildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Guild guild = this.serializedSourceGuild;
        int iHashCode2 = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
        String str = this.createdAt;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.updatedAt;
        int iHashCode4 = (((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.usageCount) * 31;
        String str3 = this.code;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildTemplate(creatorId=");
        sbU.append(this.creatorId);
        sbU.append(", creator=");
        sbU.append(this.creator);
        sbU.append(", sourceGuildId=");
        sbU.append(this.sourceGuildId);
        sbU.append(", serializedSourceGuild=");
        sbU.append(this.serializedSourceGuild);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", updatedAt=");
        sbU.append(this.updatedAt);
        sbU.append(", usageCount=");
        sbU.append(this.usageCount);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        return outline.J(sbU, this.description, ")");
    }
}

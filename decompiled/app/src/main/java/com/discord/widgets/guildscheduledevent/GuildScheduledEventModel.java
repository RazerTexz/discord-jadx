package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\u0010+\u001a\u00060\nj\u0002`\u000b\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010-\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u0011\u0012\u000e\u0010.\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u0014\u0012\u0006\u0010/\u001a\u00020\u0016\u0012\u0006\u00100\u001a\u00020\u0019\u0012\b\u00101\u001a\u0004\u0018\u00010\u0016\u0012\b\u00102\u001a\u0004\u0018\u00010\u0019\u0012\b\u00103\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u00104\u001a\u00020\u001f\u0012\b\u00105\u001a\u0004\u0018\u00010\"\u0012\b\u00106\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010(¢\u0006\u0004\bW\u0010XJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00060\nj\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010 \u001a\u00020\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b)\u0010*J´\u0001\u00108\u001a\u00020\u00002\f\b\u0002\u0010+\u001a\u00060\nj\u0002`\u000b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010-\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u00112\u0010\b\u0002\u0010.\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u00142\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020\u00192\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00104\u001a\u00020\u001f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00106\u001a\u0004\u0018\u00010%2\n\b\u0002\u00107\u001a\u0004\u0018\u00010(HÆ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b:\u0010\u0010J\u0010\u0010;\u001a\u00020%HÖ\u0001¢\u0006\u0004\b;\u0010<J\u001a\u0010?\u001a\u00020(2\b\u0010>\u001a\u0004\u0018\u00010=HÖ\u0003¢\u0006\u0004\b?\u0010@R\u001b\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010A\u001a\u0004\bB\u0010\u0018R\u001d\u0010+\u001a\u00060\nj\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010C\u001a\u0004\bD\u0010\rR\u0019\u0010/\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010A\u001a\u0004\bE\u0010\u0018R\u0019\u00100\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010F\u001a\u0004\bG\u0010\u001bR!\u0010.\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u00148\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010H\u001a\u0004\bI\u0010\u0013R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010J\u001a\u0004\bK\u0010\u0010R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010J\u001a\u0004\bL\u0010\u0010R\u001b\u00105\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010M\u001a\u0004\bN\u0010$R!\u0010-\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010H\u001a\u0004\bO\u0010\u0013R\u001b\u00106\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010P\u001a\u0004\bQ\u0010'R\u001b\u00102\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010F\u001a\u0004\bR\u0010\u001bR\u0019\u00104\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010S\u001a\u0004\bT\u0010!R\u001b\u00107\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010U\u001a\u0004\bV\u0010*¨\u0006Y"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "Ljava/io/Serializable;", "Lcom/discord/restapi/RestAPIParams$CreateGuildScheduledEventBody;", "toCreateRequestBody", "()Lcom/discord/restapi/RestAPIParams$CreateGuildScheduledEventBody;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "currentEvent", "Lcom/discord/restapi/RestAPIParams$UpdateGuildScheduledEventBody;", "toUpdateRequestBody", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/restapi/RestAPIParams$UpdateGuildScheduledEventBody;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "Lcom/discord/primitives/ChannelId;", "component3", "()Ljava/lang/Long;", "Lcom/discord/primitives/UserId;", "component4", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "component5", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "component6", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "component7", "component8", "component9", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "component10", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "component11", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "", "component12", "()Ljava/lang/Integer;", "", "component13", "()Ljava/lang/Boolean;", "guildId", ModelAuditLogEntry.CHANGE_KEY_NAME, "channelId", "creatorId", "startDate", "startTime", "endDate", "endTime", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "entityType", "entityMetadata", "userCount", "broadcastToDirectoryChannels", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;Ljava/lang/String;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "getEndDate", "J", "getGuildId", "getStartDate", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "getStartTime", "Ljava/lang/Long;", "getCreatorId", "Ljava/lang/String;", "getDescription", "getName", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "getEntityMetadata", "getChannelId", "Ljava/lang/Integer;", "getUserCount", "getEndTime", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "getEntityType", "Ljava/lang/Boolean;", "getBroadcastToDirectoryChannels", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;Ljava/lang/String;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventModel implements Serializable {
    private final Boolean broadcastToDirectoryChannels;
    private final Long channelId;
    private final Long creatorId;
    private final String description;
    private final GuildScheduledEventPickerDateTime2 endDate;
    private final GuildScheduledEventPickerDateTime3 endTime;
    private final GuildScheduledEventEntityMetadata entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final long guildId;
    private final String name;
    private final GuildScheduledEventPickerDateTime2 startDate;
    private final GuildScheduledEventPickerDateTime3 startTime;
    private final Integer userCount;

    public GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventPickerDateTime2, "startDate");
        Intrinsics3.checkNotNullParameter(guildScheduledEventPickerDateTime3, "startTime");
        Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        this.guildId = j;
        this.name = str;
        this.channelId = l;
        this.creatorId = l2;
        this.startDate = guildScheduledEventPickerDateTime2;
        this.startTime = guildScheduledEventPickerDateTime3;
        this.endDate = guildScheduledEventPickerDateTime22;
        this.endTime = guildScheduledEventPickerDateTime32;
        this.description = str2;
        this.entityType = guildScheduledEventEntityType;
        this.entityMetadata = guildScheduledEventEntityMetadata;
        this.userCount = num;
        this.broadcastToDirectoryChannels = bool;
    }

    public static /* synthetic */ GuildScheduledEventModel copy$default(GuildScheduledEventModel guildScheduledEventModel, long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, Object obj) {
        return guildScheduledEventModel.copy((i & 1) != 0 ? guildScheduledEventModel.guildId : j, (i & 2) != 0 ? guildScheduledEventModel.name : str, (i & 4) != 0 ? guildScheduledEventModel.channelId : l, (i & 8) != 0 ? guildScheduledEventModel.creatorId : l2, (i & 16) != 0 ? guildScheduledEventModel.startDate : guildScheduledEventPickerDateTime2, (i & 32) != 0 ? guildScheduledEventModel.startTime : guildScheduledEventPickerDateTime3, (i & 64) != 0 ? guildScheduledEventModel.endDate : guildScheduledEventPickerDateTime22, (i & 128) != 0 ? guildScheduledEventModel.endTime : guildScheduledEventPickerDateTime32, (i & 256) != 0 ? guildScheduledEventModel.description : str2, (i & 512) != 0 ? guildScheduledEventModel.entityType : guildScheduledEventEntityType, (i & 1024) != 0 ? guildScheduledEventModel.entityMetadata : guildScheduledEventEntityMetadata, (i & 2048) != 0 ? guildScheduledEventModel.userCount : num, (i & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : bool);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component10, reason: from getter */
    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    /* renamed from: component11, reason: from getter */
    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getUserCount() {
        return this.userCount;
    }

    /* renamed from: component13, reason: from getter */
    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getCreatorId() {
        return this.creatorId;
    }

    /* renamed from: component5, reason: from getter */
    public final GuildScheduledEventPickerDateTime2 getStartDate() {
        return this.startDate;
    }

    /* renamed from: component6, reason: from getter */
    public final GuildScheduledEventPickerDateTime3 getStartTime() {
        return this.startTime;
    }

    /* renamed from: component7, reason: from getter */
    public final GuildScheduledEventPickerDateTime2 getEndDate() {
        return this.endDate;
    }

    /* renamed from: component8, reason: from getter */
    public final GuildScheduledEventPickerDateTime3 getEndTime() {
        return this.endTime;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventModel copy(long guildId, String name, Long channelId, Long creatorId, GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime, GuildScheduledEventPickerDateTime2 endDate, GuildScheduledEventPickerDateTime3 endTime, String description, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Integer userCount, Boolean broadcastToDirectoryChannels) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        Intrinsics3.checkNotNullParameter(entityType, "entityType");
        return new GuildScheduledEventModel(guildId, name, channelId, creatorId, startDate, startTime, endDate, endTime, description, entityType, entityMetadata, userCount, broadcastToDirectoryChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventModel)) {
            return false;
        }
        GuildScheduledEventModel guildScheduledEventModel = (GuildScheduledEventModel) other;
        return this.guildId == guildScheduledEventModel.guildId && Intrinsics3.areEqual(this.name, guildScheduledEventModel.name) && Intrinsics3.areEqual(this.channelId, guildScheduledEventModel.channelId) && Intrinsics3.areEqual(this.creatorId, guildScheduledEventModel.creatorId) && Intrinsics3.areEqual(this.startDate, guildScheduledEventModel.startDate) && Intrinsics3.areEqual(this.startTime, guildScheduledEventModel.startTime) && Intrinsics3.areEqual(this.endDate, guildScheduledEventModel.endDate) && Intrinsics3.areEqual(this.endTime, guildScheduledEventModel.endTime) && Intrinsics3.areEqual(this.description, guildScheduledEventModel.description) && Intrinsics3.areEqual(this.entityType, guildScheduledEventModel.entityType) && Intrinsics3.areEqual(this.entityMetadata, guildScheduledEventModel.entityMetadata) && Intrinsics3.areEqual(this.userCount, guildScheduledEventModel.userCount) && Intrinsics3.areEqual(this.broadcastToDirectoryChannels, guildScheduledEventModel.broadcastToDirectoryChannels);
    }

    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventPickerDateTime2 getEndDate() {
        return this.endDate;
    }

    public final GuildScheduledEventPickerDateTime3 getEndTime() {
        return this.endTime;
    }

    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getName() {
        return this.name;
    }

    public final GuildScheduledEventPickerDateTime2 getStartDate() {
        return this.startDate;
    }

    public final GuildScheduledEventPickerDateTime3 getStartTime() {
        return this.startTime;
    }

    public final Integer getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.name;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.channelId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.creatorId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.startDate;
        int iHashCode4 = (iHashCode3 + (guildScheduledEventPickerDateTime2 != null ? guildScheduledEventPickerDateTime2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3 = this.startTime;
        int iHashCode5 = (iHashCode4 + (guildScheduledEventPickerDateTime3 != null ? guildScheduledEventPickerDateTime3.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22 = this.endDate;
        int iHashCode6 = (iHashCode5 + (guildScheduledEventPickerDateTime22 != null ? guildScheduledEventPickerDateTime22.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32 = this.endTime;
        int iHashCode7 = (iHashCode6 + (guildScheduledEventPickerDateTime32 != null ? guildScheduledEventPickerDateTime32.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode8 = (iHashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
        int iHashCode9 = (iHashCode8 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        int iHashCode10 = (iHashCode9 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
        Integer num = this.userCount;
        int iHashCode11 = (iHashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.broadcastToDirectoryChannels;
        return iHashCode11 + (bool != null ? bool.hashCode() : 0);
    }

    public final RestAPIParams.CreateGuildScheduledEventBody toCreateRequestBody() {
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3;
        String str = this.name;
        String utcDateString = null;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        String utcDateString2 = guildScheduledEventPickerDateTime.toUtcDateString(this.startDate, this.startTime);
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.endDate;
        if (guildScheduledEventPickerDateTime2 != null && (guildScheduledEventPickerDateTime3 = this.endTime) != null) {
            utcDateString = guildScheduledEventPickerDateTime.toUtcDateString(guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3);
        }
        return new RestAPIParams.CreateGuildScheduledEventBody(str, this.description, StageInstancePrivacyLevel.GUILD_ONLY, utcDateString2, utcDateString, this.channelId, this.entityType, this.entityMetadata, this.broadcastToDirectoryChannels);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventModel(guildId=");
        sbU.append(this.guildId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", creatorId=");
        sbU.append(this.creatorId);
        sbU.append(", startDate=");
        sbU.append(this.startDate);
        sbU.append(", startTime=");
        sbU.append(this.startTime);
        sbU.append(", endDate=");
        sbU.append(this.endDate);
        sbU.append(", endTime=");
        sbU.append(this.endTime);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", entityType=");
        sbU.append(this.entityType);
        sbU.append(", entityMetadata=");
        sbU.append(this.entityMetadata);
        sbU.append(", userCount=");
        sbU.append(this.userCount);
        sbU.append(", broadcastToDirectoryChannels=");
        return outline.D(sbU, this.broadcastToDirectoryChannels, ")");
    }

    public final RestAPIParams.UpdateGuildScheduledEventBody toUpdateRequestBody(GuildScheduledEvent currentEvent) {
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3;
        Intrinsics3.checkNotNullParameter(currentEvent, "currentEvent");
        String str = this.name;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        long millis = guildScheduledEventPickerDateTime.toMillis(this.startDate, this.startTime);
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.endDate;
        Long lValueOf = (guildScheduledEventPickerDateTime2 == null || (guildScheduledEventPickerDateTime3 = this.endTime) == null) ? null : Long.valueOf(guildScheduledEventPickerDateTime.toMillis(guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3));
        Long l = this.channelId;
        NullSerializable bVar = l != null ? new NullSerializable.b(l) : new NullSerializable.a(null, 1);
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        NullSerializable aVar = (guildScheduledEventEntityMetadata == null || guildScheduledEventEntityMetadata.b()) ? new NullSerializable.a(null, 1) : new NullSerializable.b(this.entityMetadata);
        String str2 = this.description;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = StageInstancePrivacyLevel.GUILD_ONLY;
        String uTCDateTime$default = currentEvent.getScheduledStartTime().getDateTimeMillis() == millis ? null : TimeUtils.toUTCDateTime$default(Long.valueOf(millis), null, 2, null);
        UtcDateTime scheduledEndTime = currentEvent.getScheduledEndTime();
        return new RestAPIParams.UpdateGuildScheduledEventBody(str, str2, stageInstancePrivacyLevel, uTCDateTime$default, Intrinsics3.areEqual(scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, lValueOf) ? null : TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null), bVar, this.entityType, aVar, null, this.broadcastToDirectoryChannels, 256, null);
    }

    public /* synthetic */ GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, l, l2, guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3, guildScheduledEventPickerDateTime22, guildScheduledEventPickerDateTime32, str2, guildScheduledEventEntityType, guildScheduledEventEntityMetadata, num, (i & 4096) != 0 ? null : bool);
    }
}

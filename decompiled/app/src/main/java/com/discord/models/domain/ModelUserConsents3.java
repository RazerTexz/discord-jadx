package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelUserConsents.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\n\u0010\u0012\u001a\u00060\u0002j\u0002`\r\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000e\u001a\u00060\u0002j\u0002`\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ>\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\n2\f\b\u0002\u0010\u0012\u001a\u00060\u0002j\u0002`\r2\b\b\u0002\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\fR\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b#\u0010\f¨\u0006&"}, d2 = {"Lcom/discord/models/domain/Harvest;", "", "", "createdAtInMillis", "()J", "nextAvailableRequestInMillis", "now", "", "canRequest", "(J)Z", "", "component1", "()Ljava/lang/String;", "Lcom/discord/primitives/UserId;", "component2", "component3", "component4", ModelAuditLogEntry.CHANGE_KEY_ID, "userId", "createdAt", "completedAt", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/Harvest;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCompletedAt", "getId", "J", "getUserId", "getCreatedAt", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.Harvest, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelUserConsents3 {
    private final String completedAt;
    private final String createdAt;
    private final String id;
    private final long userId;

    public ModelUserConsents3(String str, long j, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, "createdAt");
        this.id = str;
        this.userId = j;
        this.createdAt = str2;
        this.completedAt = str3;
    }

    public static /* synthetic */ boolean canRequest$default(ModelUserConsents3 modelUserConsents3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        return modelUserConsents3.canRequest(j);
    }

    public static /* synthetic */ ModelUserConsents3 copy$default(ModelUserConsents3 modelUserConsents3, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelUserConsents3.id;
        }
        if ((i & 2) != 0) {
            j = modelUserConsents3.userId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = modelUserConsents3.createdAt;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = modelUserConsents3.completedAt;
        }
        return modelUserConsents3.copy(str, j2, str4, str3);
    }

    private final long createdAtInMillis() {
        return TimeUtils.parseUTCDate(this.createdAt);
    }

    public final boolean canRequest(long now) {
        return now > nextAvailableRequestInMillis();
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCompletedAt() {
        return this.completedAt;
    }

    public final ModelUserConsents3 copy(String id2, long userId, String createdAt, String completedAt) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        return new ModelUserConsents3(id2, userId, createdAt, completedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserConsents3)) {
            return false;
        }
        ModelUserConsents3 modelUserConsents3 = (ModelUserConsents3) other;
        return Intrinsics3.areEqual(this.id, modelUserConsents3.id) && this.userId == modelUserConsents3.userId && Intrinsics3.areEqual(this.createdAt, modelUserConsents3.createdAt) && Intrinsics3.areEqual(this.completedAt, modelUserConsents3.completedAt);
    }

    public final String getCompletedAt() {
        return this.completedAt;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getId() {
        return this.id;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.userId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.createdAt;
        int iHashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.completedAt;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final long nextAvailableRequestInMillis() {
        return createdAtInMillis() + WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Harvest(id=");
        sbU.append(this.id);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", completedAt=");
        return outline.J(sbU, this.completedAt, ")");
    }
}

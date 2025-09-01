package com.discord.api.embeddedactivities;

import b.d.b.a.outline;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: EmbeddedActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u00060 j\u0002`!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u0004R\u001b\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "details", "Ljava/lang/String;", "d", "Lcom/discord/api/activity/ActivityTimestamps;", "timestamps", "Lcom/discord/api/activity/ActivityTimestamps;", "h", "()Lcom/discord/api/activity/ActivityTimestamps;", ModelAuditLogEntry.CHANGE_KEY_NAME, "e", "Lcom/discord/api/activity/ActivitySecrets;", "secrets", "Lcom/discord/api/activity/ActivitySecrets;", "f", "()Lcom/discord/api/activity/ActivitySecrets;", "Lcom/discord/api/activity/ActivityType;", "type", "Lcom/discord/api/activity/ActivityType;", "i", "()Lcom/discord/api/activity/ActivityType;", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "J", "a", "()J", "state", "g", "Lcom/discord/api/activity/ActivityAssets;", "assets", "Lcom/discord/api/activity/ActivityAssets;", "b", "()Lcom/discord/api/activity/ActivityAssets;", "createdAt", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EmbeddedActivity {
    private final long applicationId;
    private final ActivityAssets assets;
    private final Long createdAt;
    private final String details;
    private final String name;
    private final ActivitySecrets secrets;
    private final String state;
    private final ActivityTimestamps timestamps;
    private final ActivityType type;

    /* renamed from: a, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: b, reason: from getter */
    public final ActivityAssets getAssets() {
        return this.assets;
    }

    /* renamed from: c, reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: d, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivity)) {
            return false;
        }
        EmbeddedActivity embeddedActivity = (EmbeddedActivity) other;
        return this.applicationId == embeddedActivity.applicationId && Intrinsics3.areEqual(this.assets, embeddedActivity.assets) && Intrinsics3.areEqual(this.createdAt, embeddedActivity.createdAt) && Intrinsics3.areEqual(this.details, embeddedActivity.details) && Intrinsics3.areEqual(this.name, embeddedActivity.name) && Intrinsics3.areEqual(this.secrets, embeddedActivity.secrets) && Intrinsics3.areEqual(this.state, embeddedActivity.state) && Intrinsics3.areEqual(this.timestamps, embeddedActivity.timestamps) && Intrinsics3.areEqual(this.type, embeddedActivity.type);
    }

    /* renamed from: f, reason: from getter */
    public final ActivitySecrets getSecrets() {
        return this.secrets;
    }

    /* renamed from: g, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: h, reason: from getter */
    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    public int hashCode() {
        long j = this.applicationId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode = (i + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
        Long l = this.createdAt;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.details;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ActivitySecrets activitySecrets = this.secrets;
        int iHashCode5 = (iHashCode4 + (activitySecrets != null ? activitySecrets.hashCode() : 0)) * 31;
        String str3 = this.state;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ActivityTimestamps activityTimestamps = this.timestamps;
        int iHashCode7 = (iHashCode6 + (activityTimestamps != null ? activityTimestamps.hashCode() : 0)) * 31;
        ActivityType activityType = this.type;
        return iHashCode7 + (activityType != null ? activityType.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbeddedActivity(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", assets=");
        sbU.append(this.assets);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", details=");
        sbU.append(this.details);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", secrets=");
        sbU.append(this.secrets);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", timestamps=");
        sbU.append(this.timestamps);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}

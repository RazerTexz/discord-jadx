package com.discord.api.activity;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Activity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\u0006\u0010<\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010)\u001a\u0004\u0018\u00010$\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020-\u0018\u000102\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000102¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u0004R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u0004R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R!\u00103\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010<\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\r\u001a\u0004\b=\u0010\u0004R\u001b\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010C\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\r\u001a\u0004\bH\u0010\u0004R\u001b\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR!\u0010N\u001a\n\u0012\u0004\u0012\u00020-\u0018\u0001028\u0006@\u0006¢\u0006\f\n\u0004\bN\u00104\u001a\u0004\bO\u00106¨\u0006R"}, d2 = {"Lcom/discord/api/activity/Activity;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "details", "Ljava/lang/String;", "e", "state", "l", "Lcom/discord/api/activity/ActivityEmoji;", "emoji", "Lcom/discord/api/activity/ActivityEmoji;", "f", "()Lcom/discord/api/activity/ActivityEmoji;", "Lcom/discord/api/activity/ActivityAssets;", "assets", "Lcom/discord/api/activity/ActivityAssets;", "b", "()Lcom/discord/api/activity/ActivityAssets;", "Lcom/discord/api/activity/ActivityType;", "type", "Lcom/discord/api/activity/ActivityType;", "p", "()Lcom/discord/api/activity/ActivityType;", "url", "getUrl", "sessionId", "k", "", "createdAt", "J", "d", "()J", "applicationId", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "Lcom/discord/api/activity/ActivityPlatform;", "platform", "Lcom/discord/api/activity/ActivityPlatform;", "j", "()Lcom/discord/api/activity/ActivityPlatform;", "", "buttons", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/discord/api/activity/ActivityTimestamps;", "timestamps", "Lcom/discord/api/activity/ActivityTimestamps;", "o", "()Lcom/discord/api/activity/ActivityTimestamps;", ModelAuditLogEntry.CHANGE_KEY_NAME, "h", "Lcom/discord/api/activity/ActivityParty;", "party", "Lcom/discord/api/activity/ActivityParty;", "i", "()Lcom/discord/api/activity/ActivityParty;", "flags", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "syncId", "n", "Lcom/discord/api/activity/ActivityMetadata;", "metadata", "Lcom/discord/api/activity/ActivityMetadata;", "getMetadata", "()Lcom/discord/api/activity/ActivityMetadata;", "supportedPlatforms", "m", "<init>", "(Ljava/lang/String;Lcom/discord/api/activity/ActivityType;Ljava/lang/String;JLcom/discord/api/activity/ActivityTimestamps;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/activity/ActivityEmoji;Lcom/discord/api/activity/ActivityParty;Lcom/discord/api/activity/ActivityAssets;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/activity/ActivityMetadata;Lcom/discord/api/activity/ActivityPlatform;Ljava/util/List;Ljava/util/List;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Activity {
    private final Long applicationId;
    private final ActivityAssets assets;
    private final List<String> buttons;
    private final long createdAt;
    private final String details;
    private final ActivityEmoji emoji;
    private final Integer flags;
    private final ActivityMetadata metadata;
    private final String name;
    private final ActivityParty party;
    private final ActivityPlatform platform;
    private final String sessionId;
    private final String state;
    private final List<ActivityPlatform> supportedPlatforms;
    private final String syncId;
    private final ActivityTimestamps timestamps;
    private final ActivityType type;
    private final String url;

    public Activity(String str, ActivityType activityType, String str2, long j, ActivityTimestamps activityTimestamps, Long l, String str3, String str4, ActivityEmoji activityEmoji, ActivityParty activityParty, ActivityAssets activityAssets, Integer num, String str5, String str6, ActivityMetadata activityMetadata, ActivityPlatform activityPlatform, List<? extends ActivityPlatform> list, List<String> list2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(activityType, "type");
        this.name = str;
        this.type = activityType;
        this.url = null;
        this.createdAt = j;
        this.timestamps = activityTimestamps;
        this.applicationId = l;
        this.details = str3;
        this.state = str4;
        this.emoji = activityEmoji;
        this.party = activityParty;
        this.assets = activityAssets;
        this.flags = num;
        this.syncId = str5;
        this.sessionId = null;
        this.metadata = null;
        this.platform = activityPlatform;
        this.supportedPlatforms = null;
        this.buttons = null;
    }

    /* renamed from: a, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: b, reason: from getter */
    public final ActivityAssets getAssets() {
        return this.assets;
    }

    public final List<String> c() {
        return this.buttons;
    }

    /* renamed from: d, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: e, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) other;
        return Intrinsics3.areEqual(this.name, activity.name) && Intrinsics3.areEqual(this.type, activity.type) && Intrinsics3.areEqual(this.url, activity.url) && this.createdAt == activity.createdAt && Intrinsics3.areEqual(this.timestamps, activity.timestamps) && Intrinsics3.areEqual(this.applicationId, activity.applicationId) && Intrinsics3.areEqual(this.details, activity.details) && Intrinsics3.areEqual(this.state, activity.state) && Intrinsics3.areEqual(this.emoji, activity.emoji) && Intrinsics3.areEqual(this.party, activity.party) && Intrinsics3.areEqual(this.assets, activity.assets) && Intrinsics3.areEqual(this.flags, activity.flags) && Intrinsics3.areEqual(this.syncId, activity.syncId) && Intrinsics3.areEqual(this.sessionId, activity.sessionId) && Intrinsics3.areEqual(this.metadata, activity.metadata) && Intrinsics3.areEqual(this.platform, activity.platform) && Intrinsics3.areEqual(this.supportedPlatforms, activity.supportedPlatforms) && Intrinsics3.areEqual(this.buttons, activity.buttons);
    }

    /* renamed from: f, reason: from getter */
    public final ActivityEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: g, reason: from getter */
    public final Integer getFlags() {
        return this.flags;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ActivityType activityType = this.type;
        int iHashCode2 = (iHashCode + (activityType != null ? activityType.hashCode() : 0)) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.createdAt;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        ActivityTimestamps activityTimestamps = this.timestamps;
        int iHashCode4 = (i + (activityTimestamps != null ? activityTimestamps.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.details;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.state;
        int iHashCode7 = (iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ActivityEmoji activityEmoji = this.emoji;
        int iHashCode8 = (iHashCode7 + (activityEmoji != null ? activityEmoji.hashCode() : 0)) * 31;
        ActivityParty activityParty = this.party;
        int iHashCode9 = (iHashCode8 + (activityParty != null ? activityParty.hashCode() : 0)) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode10 = (iHashCode9 + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
        Integer num = this.flags;
        int iHashCode11 = (iHashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.syncId;
        int iHashCode12 = (iHashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.sessionId;
        int iHashCode13 = (iHashCode12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ActivityMetadata activityMetadata = this.metadata;
        int iHashCode14 = (iHashCode13 + (activityMetadata != null ? activityMetadata.hashCode() : 0)) * 31;
        ActivityPlatform activityPlatform = this.platform;
        int iHashCode15 = (iHashCode14 + (activityPlatform != null ? activityPlatform.hashCode() : 0)) * 31;
        List<ActivityPlatform> list = this.supportedPlatforms;
        int iHashCode16 = (iHashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.buttons;
        return iHashCode16 + (list2 != null ? list2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final ActivityParty getParty() {
        return this.party;
    }

    /* renamed from: j, reason: from getter */
    public final ActivityPlatform getPlatform() {
        return this.platform;
    }

    /* renamed from: k, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: l, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final List<ActivityPlatform> m() {
        return this.supportedPlatforms;
    }

    /* renamed from: n, reason: from getter */
    public final String getSyncId() {
        return this.syncId;
    }

    /* renamed from: o, reason: from getter */
    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    /* renamed from: p, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Activity(name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", timestamps=");
        sbU.append(this.timestamps);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", details=");
        sbU.append(this.details);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", party=");
        sbU.append(this.party);
        sbU.append(", assets=");
        sbU.append(this.assets);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", syncId=");
        sbU.append(this.syncId);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", metadata=");
        sbU.append(this.metadata);
        sbU.append(", platform=");
        sbU.append(this.platform);
        sbU.append(", supportedPlatforms=");
        sbU.append(this.supportedPlatforms);
        sbU.append(", buttons=");
        return outline.L(sbU, this.buttons, ")");
    }
}

package com.discord.models.embeddedactivities;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivitySecrets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.activity.ActivityType;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmbeddedActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 L2\u00020\u0001:\u0001LB\u0087\u0001\u0012\n\u0010 \u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010(\u001a\u00020\u0016\u0012\u0010\u0010)\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u001a0\u0019\u0012\u0006\u0010*\u001a\u00020\u000b\u0012\n\u0010+\u001a\u00060\u0002j\u0002`\u001e¢\u0006\u0004\bJ\u0010KJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u001a0\u0019HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\rJ\u0014\u0010\u001f\u001a\u00060\u0002j\u0002`\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0005J¨\u0001\u0010,\u001a\u00020\u00002\f\b\u0002\u0010 \u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010(\u001a\u00020\u00162\u0012\b\u0002\u0010)\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u001a0\u00192\b\b\u0002\u0010*\u001a\u00020\u000b2\f\b\u0002\u0010+\u001a\u00060\u0002j\u0002`\u001eHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b.\u0010\rJ\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u0010\nR\u001b\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b9\u0010\u0015R\u0019\u0010*\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010:\u001a\u0004\b;\u0010\rR\u0019\u0010(\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\b=\u0010\u0018R\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\b?\u0010\u0011R\u001d\u0010 \u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b \u0010@\u001a\u0004\bA\u0010\u0005R\u001b\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\bB\u0010\rR\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\bC\u0010\rR#\u0010)\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u001a0\u00198\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010D\u001a\u0004\bE\u0010\u001cR\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\bF\u0010\rR\u001d\u0010+\u001a\u00060\u0002j\u0002`\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010@\u001a\u0004\bG\u0010\u0005R\u001b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010H\u001a\u0004\bI\u0010\b¨\u0006M"}, d2 = {"Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "", "", "Lcom/discord/primitives/ApplicationId;", "component1", "()J", "Lcom/discord/api/activity/ActivityAssets;", "component2", "()Lcom/discord/api/activity/ActivityAssets;", "component3", "()Ljava/lang/Long;", "", "component4", "()Ljava/lang/String;", "component5", "Lcom/discord/api/activity/ActivitySecrets;", "component6", "()Lcom/discord/api/activity/ActivitySecrets;", "component7", "Lcom/discord/api/activity/ActivityTimestamps;", "component8", "()Lcom/discord/api/activity/ActivityTimestamps;", "Lcom/discord/api/activity/ActivityType;", "component9", "()Lcom/discord/api/activity/ActivityType;", "", "Lcom/discord/primitives/UserId;", "component10", "()Ljava/util/List;", "component11", "Lcom/discord/primitives/GuildId;", "component12", "applicationId", "assets", "createdAt", "details", ModelAuditLogEntry.CHANGE_KEY_NAME, "secrets", "state", "timestamps", "type", "userIds", "url", "guildId", "copy", "(JLcom/discord/api/activity/ActivityAssets;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/activity/ActivitySecrets;Ljava/lang/String;Lcom/discord/api/activity/ActivityTimestamps;Lcom/discord/api/activity/ActivityType;Ljava/util/List;Ljava/lang/String;J)Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getCreatedAt", "Lcom/discord/api/activity/ActivityTimestamps;", "getTimestamps", "Ljava/lang/String;", "getUrl", "Lcom/discord/api/activity/ActivityType;", "getType", "Lcom/discord/api/activity/ActivitySecrets;", "getSecrets", "J", "getApplicationId", "getState", "getName", "Ljava/util/List;", "getUserIds", "getDetails", "getGuildId", "Lcom/discord/api/activity/ActivityAssets;", "getAssets", "<init>", "(JLcom/discord/api/activity/ActivityAssets;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/activity/ActivitySecrets;Ljava/lang/String;Lcom/discord/api/activity/ActivityTimestamps;Lcom/discord/api/activity/ActivityType;Ljava/util/List;Ljava/lang/String;J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EmbeddedActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long applicationId;
    private final ActivityAssets assets;
    private final Long createdAt;
    private final String details;
    private final long guildId;
    private final String name;
    private final ActivitySecrets secrets;
    private final String state;
    private final ActivityTimestamps timestamps;
    private final ActivityType type;
    private final String url;
    private final List<Long> userIds;

    /* compiled from: EmbeddedActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/models/embeddedactivities/EmbeddedActivity$Companion;", "", "Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "apiEmbeddedActivity", "", "", "Lcom/discord/primitives/UserId;", "userIds", "", "url", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "fromApiEmbeddedActivity", "(Lcom/discord/api/embeddedactivities/EmbeddedActivity;Ljava/util/List;Ljava/lang/String;J)Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final EmbeddedActivity fromApiEmbeddedActivity(com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, List<Long> userIds, String url, long guildId) {
            Intrinsics3.checkNotNullParameter(apiEmbeddedActivity, "apiEmbeddedActivity");
            Intrinsics3.checkNotNullParameter(userIds, "userIds");
            Intrinsics3.checkNotNullParameter(url, "url");
            long jA = apiEmbeddedActivity.getApplicationId();
            ActivityAssets activityAssetsB = apiEmbeddedActivity.getAssets();
            Long lC = apiEmbeddedActivity.getCreatedAt();
            String strD = apiEmbeddedActivity.getDetails();
            String strE = apiEmbeddedActivity.getName();
            ActivitySecrets activitySecretsF = apiEmbeddedActivity.getSecrets();
            String strG = apiEmbeddedActivity.getState();
            ActivityTimestamps activityTimestampsH = apiEmbeddedActivity.getTimestamps();
            ActivityType activityTypeI = apiEmbeddedActivity.getType();
            if (activityTypeI == null) {
                activityTypeI = ActivityType.UNKNOWN;
            }
            return new EmbeddedActivity(jA, activityAssetsB, lC, strD, strE, activitySecretsF, strG, activityTimestampsH, activityTypeI, userIds, url, guildId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EmbeddedActivity(long j, ActivityAssets activityAssets, Long l, String str, String str2, ActivitySecrets activitySecrets, String str3, ActivityTimestamps activityTimestamps, ActivityType activityType, List<Long> list, String str4, long j2) {
        Intrinsics3.checkNotNullParameter(activityType, "type");
        Intrinsics3.checkNotNullParameter(list, "userIds");
        Intrinsics3.checkNotNullParameter(str4, "url");
        this.applicationId = j;
        this.assets = activityAssets;
        this.createdAt = l;
        this.details = str;
        this.name = str2;
        this.secrets = activitySecrets;
        this.state = str3;
        this.timestamps = activityTimestamps;
        this.type = activityType;
        this.userIds = list;
        this.url = str4;
        this.guildId = j2;
    }

    public static /* synthetic */ EmbeddedActivity copy$default(EmbeddedActivity embeddedActivity, long j, ActivityAssets activityAssets, Long l, String str, String str2, ActivitySecrets activitySecrets, String str3, ActivityTimestamps activityTimestamps, ActivityType activityType, List list, String str4, long j2, int i, Object obj) {
        return embeddedActivity.copy((i & 1) != 0 ? embeddedActivity.applicationId : j, (i & 2) != 0 ? embeddedActivity.assets : activityAssets, (i & 4) != 0 ? embeddedActivity.createdAt : l, (i & 8) != 0 ? embeddedActivity.details : str, (i & 16) != 0 ? embeddedActivity.name : str2, (i & 32) != 0 ? embeddedActivity.secrets : activitySecrets, (i & 64) != 0 ? embeddedActivity.state : str3, (i & 128) != 0 ? embeddedActivity.timestamps : activityTimestamps, (i & 256) != 0 ? embeddedActivity.type : activityType, (i & 512) != 0 ? embeddedActivity.userIds : list, (i & 1024) != 0 ? embeddedActivity.url : str4, (i & 2048) != 0 ? embeddedActivity.guildId : j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    public final List<Long> component10() {
        return this.userIds;
    }

    /* renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component12, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final ActivityAssets getAssets() {
        return this.assets;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final ActivitySecrets getSecrets() {
        return this.secrets;
    }

    /* renamed from: component7, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component8, reason: from getter */
    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    /* renamed from: component9, reason: from getter */
    public final ActivityType getType() {
        return this.type;
    }

    public final EmbeddedActivity copy(long applicationId, ActivityAssets assets, Long createdAt, String details, String name, ActivitySecrets secrets, String state, ActivityTimestamps timestamps, ActivityType type, List<Long> userIds, String url, long guildId) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Intrinsics3.checkNotNullParameter(url, "url");
        return new EmbeddedActivity(applicationId, assets, createdAt, details, name, secrets, state, timestamps, type, userIds, url, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedActivity)) {
            return false;
        }
        EmbeddedActivity embeddedActivity = (EmbeddedActivity) other;
        return this.applicationId == embeddedActivity.applicationId && Intrinsics3.areEqual(this.assets, embeddedActivity.assets) && Intrinsics3.areEqual(this.createdAt, embeddedActivity.createdAt) && Intrinsics3.areEqual(this.details, embeddedActivity.details) && Intrinsics3.areEqual(this.name, embeddedActivity.name) && Intrinsics3.areEqual(this.secrets, embeddedActivity.secrets) && Intrinsics3.areEqual(this.state, embeddedActivity.state) && Intrinsics3.areEqual(this.timestamps, embeddedActivity.timestamps) && Intrinsics3.areEqual(this.type, embeddedActivity.type) && Intrinsics3.areEqual(this.userIds, embeddedActivity.userIds) && Intrinsics3.areEqual(this.url, embeddedActivity.url) && this.guildId == embeddedActivity.guildId;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final ActivityAssets getAssets() {
        return this.assets;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDetails() {
        return this.details;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getName() {
        return this.name;
    }

    public final ActivitySecrets getSecrets() {
        return this.secrets;
    }

    public final String getState() {
        return this.state;
    }

    public final ActivityTimestamps getTimestamps() {
        return this.timestamps;
    }

    public final ActivityType getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<Long> getUserIds() {
        return this.userIds;
    }

    public int hashCode() {
        int iA = b.a(this.applicationId) * 31;
        ActivityAssets activityAssets = this.assets;
        int iHashCode = (iA + (activityAssets != null ? activityAssets.hashCode() : 0)) * 31;
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
        int iHashCode8 = (iHashCode7 + (activityType != null ? activityType.hashCode() : 0)) * 31;
        List<Long> list = this.userIds;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.url;
        return b.a(this.guildId) + ((iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31);
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
        sbU.append(", userIds=");
        sbU.append(this.userIds);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", guildId=");
        return outline.C(sbU, this.guildId, ")");
    }
}

package com.discord.stores;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.activity.ActivityType;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.User;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreUserPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0086\u0001\u0087\u0001B!\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010q\u001a\u00020p¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J1\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\t2\n\u0010\u0017\u001a\u00060\u0011j\u0002`\u0016H\u0003¢\u0006\u0004\b\u0018\u0010\u0015J-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u001e\u001a\u00020\u001d2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0002¢\u0006\u0004\b \u0010!J!\u0010%\u001a\u0016\u0012\b\u0012\u00060\u0011j\u0002`\u0016\u0012\b\u0012\u00060#j\u0002`$0\"¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u00060#j\u0002`$¢\u0006\u0004\b'\u0010(J'\u0010*\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0011j\u0002`\u0016\u0012\b\u0012\u00060#j\u0002`$0\"0)¢\u0006\u0004\b*\u0010+J9\u0010.\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0011j\u0002`\u0016\u0012\b\u0012\u00060#j\u0002`$0\"0)2\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00160,¢\u0006\u0004\b.\u0010/J'\u00100\u001a\u0010\u0012\f\u0012\n\u0018\u00010#j\u0004\u0018\u0001`$0)2\n\u0010\u0017\u001a\u00060\u0011j\u0002`\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\f\u0012\b\u0012\u00060#j\u0002`$0)¢\u0006\u0004\b2\u0010+J-\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0)2\n\u0010\u0017\u001a\u00060\u0011j\u0002`\u00162\n\u00104\u001a\u00060\u0011j\u0002`3¢\u0006\u0004\b5\u00106J'\u00107\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0017\u001a\u00060\u0011j\u0002`\u00162\n\u00104\u001a\u00060\u0011j\u0002`3¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u000209H\u0007¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\t2\u0006\u0010>\u001a\u00020=H\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020=H\u0007¢\u0006\u0004\bA\u0010@J'\u0010B\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\n\u0010\u0017\u001a\u00060\u0011j\u0002`\u0016H\u0007¢\u0006\u0004\bB\u0010CJ\u001d\u0010D\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bF\u0010GJ'\u0010K\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\n\u0010J\u001a\u00060Hj\u0002`IH\u0007¢\u0006\u0004\bK\u0010LJI\u0010K\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\n\u0010\u0017\u001a\u00060\u0011j\u0002`\u00162\u0006\u0010N\u001a\u00020M2\b\u0010P\u001a\u0004\u0018\u00010O2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0007¢\u0006\u0004\bK\u0010RJ!\u0010T\u001a\u00020\t2\u0010\u0010S\u001a\f\u0012\b\u0012\u00060Hj\u0002`I0\u0004H\u0007¢\u0006\u0004\bT\u0010EJ\u0017\u0010W\u001a\u00020\t2\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\t2\u0006\u0010Z\u001a\u00020YH\u0007¢\u0006\u0004\b[\u0010\\J+\u0010_\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010]\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010^\u001a\u00020\u0007H\u0007¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\tH\u0017¢\u0006\u0004\ba\u0010bR\u0019\u0010d\u001a\u00020c8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR,\u0010i\u001a\u00060#j\u0002`$2\n\u0010h\u001a\u00060#j\u0002`$8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010(R\u001a\u0010l\u001a\u00060#j\u0002`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010jR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0019\u0010q\u001a\u00020p8\u0006@\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR#\u0010v\u001a\f\u0012\b\u0012\u00060#j\u0002`$0u8\u0006@\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\b%\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R*\u0010|\u001a\u0016\u0012\b\u0012\u00060\u0011j\u0002`\u0016\u0012\b\u0012\u00060#j\u0002`$0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R`\u0010\u0082\u0001\u001aI\u0012\b\u0012\u00060\u0011j\u0002`\u0016\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0005\u0012\u00030\u0080\u00010\u007f0~j$\u0012\b\u0012\u00060\u0011j\u0002`\u0016\u0012\u0015\u0012\u0013\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0005\u0012\u00030\u0080\u00010\u007f`\u0081\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/discord/stores/StoreUserPresence;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/models/domain/ModelUserSettings;", "userSettings", "", "Lcom/discord/models/domain/ModelSession;", "sessions", "", "sendGateway", "", "updateSelfPresence", "(Lcom/discord/models/domain/ModelUserSettings;Ljava/util/List;Z)V", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "customStatusSetting", "Lcom/discord/api/activity/Activity;", "getCustomStatusActivityFromSetting", "(Lcom/discord/models/domain/ModelCustomStatusSetting;)Lcom/discord/api/activity/Activity;", "", "Lcom/discord/primitives/GuildId;", "guildId", "clearPresences", "(J)V", "Lcom/discord/primitives/UserId;", "userId", "flattenPresence", "newActivity", "oldActivities", "replaceActivityInList", "(Lcom/discord/api/activity/Activity;Ljava/util/List;)Ljava/util/List;", "Lcom/discord/api/activity/ActivityType;", "type", "", "removeActivityInList", "(Lcom/discord/api/activity/ActivityType;Ljava/util/List;)Ljava/util/List;", "", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "getPresences", "()Ljava/util/Map;", "getLocalPresence", "()Lcom/discord/models/presence/Presence;", "Lrx/Observable;", "observeAllPresences", "()Lrx/Observable;", "", "userIds", "observePresencesForUsers", "(Ljava/util/Collection;)Lrx/Observable;", "observePresenceForUser", "(J)Lrx/Observable;", "observeLocalPresence", "Lcom/discord/primitives/ApplicationId;", "applicationId", "observeApplicationActivity", "(JJ)Lrx/Observable;", "getApplicationActivity", "(JJ)Lcom/discord/api/activity/Activity;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "handleGuildRemove", "handleGuildMemberRemove", "(JJ)V", "handleSessionsReplace", "(Ljava/util/List;)V", "handleUserSettingsUpdate", "(Lcom/discord/models/domain/ModelUserSettings;)V", "Lcom/discord/api/presence/Presence;", "Lcom/discord/stores/ApiPresence;", "presence", "handlePresenceUpdate", "(JLcom/discord/api/presence/Presence;)V", "Lcom/discord/api/presence/ClientStatus;", "status", "Lcom/discord/api/presence/ClientStatuses;", "clientStatuses", "activities", "(JJLcom/discord/api/presence/ClientStatus;Lcom/discord/api/presence/ClientStatuses;Ljava/util/List;)V", "presencesList", "handlePresenceReplace", "Lcom/discord/api/thread/ThreadMemberListUpdate;", "threadMemberListUpdate", "handleThreadMemberListUpdate", "(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "forceDirty", "updateActivity", "(Lcom/discord/api/activity/ActivityType;Lcom/discord/api/activity/Activity;Z)V", "snapshotData", "()V", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "getStream", "()Lcom/discord/stores/StoreStream;", "<set-?>", "localPresence", "Lcom/discord/models/presence/Presence;", "getLocalPresence$app_productionGoogleRelease", "localPresenceSnapshot", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getObservationDeck", "()Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "presences", "Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "()Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/models/user/MeUser;", "presencesSnapshot", "Ljava/util/Map;", "Ljava/util/HashMap;", "", "Lcom/discord/stores/StoreUserPresence$TimestampedPresence;", "Lkotlin/collections/HashMap;", "userGuildPresences", "Ljava/util/HashMap;", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreStream;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "TimestampedPresence", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserPresence extends StoreV2 {
    private static final StoreUserPresence2 LocalPresenceUpdateSource = new StoreUserPresence2();
    private final Clock clock;
    private Presence localPresence;
    private Presence localPresenceSnapshot;
    private MeUser meUser;
    private final ObservationDeck observationDeck;
    private final SnowflakePartitionMap.CopiablePartitionMap<Presence> presences;
    private Map<Long, Presence> presencesSnapshot;
    private final StoreStream stream;
    private final HashMap<Long, Map<Long, TimestampedPresence>> userGuildPresences;

    /* compiled from: StoreUserPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreUserPresence$TimestampedPresence;", "", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "component1", "()Lcom/discord/models/presence/Presence;", "", "component2", "()J", "presence", "timestamp", "copy", "(Lcom/discord/models/presence/Presence;J)Lcom/discord/stores/StoreUserPresence$TimestampedPresence;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "Lcom/discord/models/presence/Presence;", "getPresence", "<init>", "(Lcom/discord/models/presence/Presence;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class TimestampedPresence {
        private final Presence presence;
        private final long timestamp;

        public TimestampedPresence(Presence presence, long j) {
            Intrinsics3.checkNotNullParameter(presence, "presence");
            this.presence = presence;
            this.timestamp = j;
        }

        public static /* synthetic */ TimestampedPresence copy$default(TimestampedPresence timestampedPresence, Presence presence, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                presence = timestampedPresence.presence;
            }
            if ((i & 2) != 0) {
                j = timestampedPresence.timestamp;
            }
            return timestampedPresence.copy(presence, j);
        }

        /* renamed from: component1, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final TimestampedPresence copy(Presence presence, long timestamp) {
            Intrinsics3.checkNotNullParameter(presence, "presence");
            return new TimestampedPresence(presence, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimestampedPresence)) {
                return false;
            }
            TimestampedPresence timestampedPresence = (TimestampedPresence) other;
            return Intrinsics3.areEqual(this.presence, timestampedPresence.presence) && this.timestamp == timestampedPresence.timestamp;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            Presence presence = this.presence;
            return b.a(this.timestamp) + ((presence != null ? presence.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("TimestampedPresence(presence=");
            sbU.append(this.presence);
            sbU.append(", timestamp=");
            return outline.C(sbU, this.timestamp, ")");
        }
    }

    /* compiled from: StoreUserPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserPresence$observeAllPresences$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Presence>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Presence> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Presence> invoke2() {
            return StoreUserPresence.this.m19getPresences();
        }
    }

    /* compiled from: StoreUserPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presence", "Lcom/discord/api/activity/Activity;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/presence/Presence;)Lcom/discord/api/activity/Activity;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserPresence$observeApplicationActivity$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Presence, Activity> {
        public final /* synthetic */ long $applicationId;

        public AnonymousClass1(long j) {
            this.$applicationId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Activity call(Presence presence) {
            return call2(presence);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Activity call2(Presence presence) {
            List<Activity> activities;
            Activity activity = null;
            if (presence == null || (activities = presence.getActivities()) == null) {
                return null;
            }
            Iterator<T> it = activities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Long applicationId = ((Activity) next).getApplicationId();
                if (applicationId != null && applicationId.longValue() == this.$applicationId) {
                    activity = next;
                    break;
                }
            }
            return activity;
        }
    }

    /* compiled from: StoreUserPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "invoke", "()Lcom/discord/models/presence/Presence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserPresence$observeLocalPresence$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Presence> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Presence invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Presence invoke() {
            return StoreUserPresence.access$getLocalPresenceSnapshot$p(StoreUserPresence.this);
        }
    }

    /* compiled from: StoreUserPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/presence/Presence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserPresence$observePresenceForUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Presence>, Presence> {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Presence call(Map<Long, ? extends Presence> map) {
            return call2((Map<Long, Presence>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Presence call2(Map<Long, Presence> map) {
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreUserPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u000026\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserPresence$observePresencesForUsers$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Presence>, Map<Long, ? extends Presence>> {
        public final /* synthetic */ Collection $userIds;

        public AnonymousClass1(Collection collection) {
            this.$userIds = collection;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Presence> call(Map<Long, ? extends Presence> map) {
            return call2((Map<Long, Presence>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Presence> call2(Map<Long, Presence> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Presence> entry : map.entrySet()) {
                if (this.$userIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    public StoreUserPresence(Clock clock, StoreStream storeStream, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.clock = clock;
        this.stream = storeStream;
        this.observationDeck = observationDeck;
        this.presences = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.userGuildPresences = new HashMap<>();
        this.presencesSnapshot = new HashMap();
        ClientStatus clientStatus = ClientStatus.ONLINE;
        ClientStatus clientStatus2 = ClientStatus.OFFLINE;
        Presence presence = new Presence(clientStatus, new ClientStatuses(clientStatus2, clientStatus2, clientStatus), null);
        this.localPresence = presence;
        this.localPresenceSnapshot = Presence.copy$default(presence, null, null, null, 7, null);
    }

    public static final /* synthetic */ Presence access$getLocalPresenceSnapshot$p(StoreUserPresence storeUserPresence) {
        return storeUserPresence.localPresenceSnapshot;
    }

    public static final /* synthetic */ void access$setLocalPresenceSnapshot$p(StoreUserPresence storeUserPresence, Presence presence) {
        storeUserPresence.localPresenceSnapshot = presence;
    }

    @Store3
    private final void clearPresences(long guildId) {
        HashMap<Long, Map<Long, TimestampedPresence>> map = this.userGuildPresences;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, TimestampedPresence>> entry : map.entrySet()) {
            if (entry.getValue().remove(Long.valueOf(guildId)) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            flattenPresence(((Number) ((Map.Entry) it.next()).getKey()).longValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void flattenPresence(long userId) {
        Presence presence;
        ClientStatus status;
        List<Activity> activities;
        List listSortedWith;
        Collection<TimestampedPresence> collectionValues;
        Object next;
        Map<Long, TimestampedPresence> map = this.userGuildPresences.get(Long.valueOf(userId));
        if (map == null || (collectionValues = map.values()) == null) {
            presence = null;
        } else {
            Iterator<T> it = collectionValues.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long timestamp = ((TimestampedPresence) next).getTimestamp();
                    do {
                        Object next2 = it.next();
                        long timestamp2 = ((TimestampedPresence) next2).getTimestamp();
                        if (timestamp < timestamp2) {
                            next = next2;
                            timestamp = timestamp2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            TimestampedPresence timestampedPresence = (TimestampedPresence) next;
            if (timestampedPresence != null) {
                presence = timestampedPresence.getPresence();
            }
        }
        if (presence == null || (status = presence.getStatus()) == null) {
            status = ClientStatus.OFFLINE;
        }
        List listReversed = (presence == null || (activities = presence.getActivities()) == null || (listSortedWith = _Collections.sortedWith(activities, PresenceUtils.INSTANCE.getACTIVITY_COMPARATOR$app_productionGoogleRelease())) == null) ? null : _Collections.reversed(listSortedWith);
        ClientStatuses clientStatuses = presence != null ? presence.getClientStatuses() : null;
        ClientStatus clientStatus = ClientStatus.OFFLINE;
        if (status == clientStatus) {
            this.userGuildPresences.remove(Long.valueOf(userId));
            if (this.presences.remove(Long.valueOf(userId)) != null) {
                markChanged();
                return;
            }
            return;
        }
        Presence presence2 = this.presences.get(Long.valueOf(userId));
        if ((presence2 != null ? presence2.getStatus() : null) != status || (!Intrinsics3.areEqual(presence2.getActivities(), listReversed)) || (!Intrinsics3.areEqual(presence2.getClientStatuses(), clientStatuses))) {
            SnowflakePartitionMap.CopiablePartitionMap<Presence> copiablePartitionMap = this.presences;
            Long lValueOf = Long.valueOf(userId);
            if (clientStatuses == null) {
                clientStatuses = new ClientStatuses(clientStatus, clientStatus, clientStatus);
            }
            copiablePartitionMap.put(lValueOf, new Presence(status, clientStatuses, listReversed));
            markChanged();
        }
    }

    @Store3
    private final Activity getCustomStatusActivityFromSetting(ModelCustomStatusSetting customStatusSetting) {
        ActivityEmoji activityEmoji = null;
        if (customStatusSetting == ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return null;
        }
        if (customStatusSetting.getExpiresAt() != null && TimeUtils.parseUTCDate(customStatusSetting.getExpiresAt()) - this.clock.currentTimeMillis() <= 0) {
            return null;
        }
        if (customStatusSetting.getEmojiId() != null) {
            StoreEmoji emojis = this.stream.getEmojis();
            Long emojiId = customStatusSetting.getEmojiId();
            Intrinsics3.checkNotNull(emojiId);
            ModelEmojiCustom customEmojiInternal = emojis.getCustomEmojiInternal(emojiId.longValue());
            if (customEmojiInternal != null) {
                activityEmoji = new ActivityEmoji(String.valueOf(customEmojiInternal.getId()), customEmojiInternal.getName(), customEmojiInternal.isAnimated());
            }
        } else if (customStatusSetting.getEmojiName() != null) {
            Map<String, ModelEmojiUnicode> unicodeEmojiSurrogateMap = this.stream.getEmojis().getUnicodeEmojiSurrogateMap();
            String emojiName = customStatusSetting.getEmojiName();
            Intrinsics3.checkNotNull(emojiName);
            ModelEmojiUnicode modelEmojiUnicode = unicodeEmojiSurrogateMap.get(emojiName);
            if (modelEmojiUnicode != null) {
                activityEmoji = new ActivityEmoji(null, modelEmojiUnicode.getSurrogates(), false);
            }
        }
        return ActivityUtils.createCustomStatusActivity(customStatusSetting.getText(), activityEmoji, this.clock.currentTimeMillis());
    }

    private final List<Activity> removeActivityInList(ActivityType type, List<Activity> oldActivities) {
        List<Activity> arrayList;
        int i;
        if (oldActivities == null || (arrayList = _Collections.toMutableList((Collection) oldActivities)) == null) {
            arrayList = new ArrayList<>();
        }
        if (oldActivities != null) {
            Iterator<Activity> it = oldActivities.iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getType() == type) {
                    break;
                }
                i++;
            }
            i = -1;
        } else {
            i = -1;
        }
        if (i != -1) {
            arrayList.remove(i);
        }
        return arrayList;
    }

    private final List<Activity> replaceActivityInList(Activity newActivity, List<Activity> oldActivities) {
        List<Activity> listRemoveActivityInList = removeActivityInList(newActivity.getType(), oldActivities);
        listRemoveActivityInList.add(newActivity);
        return listRemoveActivityInList;
    }

    public static /* synthetic */ void updateActivity$default(StoreUserPresence storeUserPresence, ActivityType activityType, Activity activity, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeUserPresence.updateActivity(activityType, activity, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateSelfPresence(ModelUserSettings userSettings, List<? extends ModelSession> sessions, boolean sendGateway) {
        ClientStatus status;
        List<Activity> list;
        List<Activity> activities;
        Object next;
        MeUser meUser = this.meUser;
        if (meUser != null) {
            long id2 = meUser.getId();
            if (userSettings == null || (status = userSettings.getStatus()) == null) {
                status = this.localPresence.getStatus();
            }
            ClientStatus clientStatus = status;
            Intrinsics3.checkNotNullExpressionValue(clientStatus, "userSettings?.status\n   …  ?: localPresence.status");
            if (sessions != null) {
                Iterator<T> it = sessions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((ModelSession) next).isActive()) {
                            break;
                        }
                    }
                }
                ModelSession modelSession = (ModelSession) next;
                if (modelSession == null || (activities = modelSession.getActivities()) == null) {
                    Presence presence = this.presences.get(Long.valueOf(id2));
                    if (presence != null) {
                        List<Activity> activities2 = presence.getActivities();
                        list = activities2;
                    } else {
                        list = null;
                    }
                } else {
                    list = activities2;
                }
            }
            ModelCustomStatusSetting customStatus = userSettings != null ? userSettings.getCustomStatus() : null;
            if (customStatus != null) {
                Activity customStatusActivityFromSetting = getCustomStatusActivityFromSetting(customStatus);
                activities = customStatusActivityFromSetting != null ? replaceActivityInList(customStatusActivityFromSetting, this.localPresence.getActivities()) : removeActivityInList(ActivityType.CUSTOM_STATUS, this.localPresence.getActivities());
            } else {
                activities = this.localPresence.getActivities();
            }
            if (clientStatus != this.localPresence.getStatus() || (!Intrinsics3.areEqual(activities, this.localPresence.getActivities()))) {
                this.localPresence = new Presence(clientStatus, null, activities);
                markChanged(LocalPresenceUpdateSource);
            }
            handlePresenceUpdate(RecyclerView.FOREVER_NS, id2, clientStatus, null, list);
            if (sendGateway || PresenceUtils.INSTANCE.getCustomStatusActivity(this.localPresence) != null) {
                return;
            }
            markUnchanged(LocalPresenceUpdateSource);
        }
    }

    public final Activity getApplicationActivity(long userId, long applicationId) {
        List<Activity> activities;
        Presence presence = this.presencesSnapshot.get(Long.valueOf(userId));
        Object obj = null;
        if (presence == null || (activities = presence.getActivities()) == null) {
            return null;
        }
        Iterator<T> it = activities.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long applicationId2 = ((Activity) next).getApplicationId();
            if (applicationId2 != null && applicationId2.longValue() == applicationId) {
                obj = next;
                break;
            }
        }
        return (Activity) obj;
    }

    /* renamed from: getLocalPresence, reason: from getter */
    public final Presence getLocalPresenceSnapshot() {
        return this.localPresenceSnapshot;
    }

    /* renamed from: getLocalPresence$app_productionGoogleRelease, reason: from getter */
    public final Presence getLocalPresence() {
        return this.localPresence;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final SnowflakePartitionMap.CopiablePartitionMap<Presence> getPresences() {
        return this.presences;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.userGuildPresences.clear();
        this.presences.clear();
        User me2 = payload.getMe();
        Intrinsics3.checkNotNullExpressionValue(me2, "payload.me");
        this.meUser = new MeUser(me2);
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            handleGuildAdd((Guild) it.next());
        }
        List<com.discord.api.presence.Presence> presences = payload.getPresences();
        Intrinsics3.checkNotNullExpressionValue(presences, "payload.presences");
        for (com.discord.api.presence.Presence presence : presences) {
            User user = presence.getUser();
            if (user != null) {
                handlePresenceUpdate(RecyclerView.FOREVER_NS, user.getId(), presence.getStatus(), presence.getClientStatus(), presence.b());
            }
        }
        updateSelfPresence(payload.getUserSettings(), payload.getSessions(), false);
        markChanged();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<com.discord.api.presence.Presence> listD = guild.D();
        if (listD != null) {
            for (com.discord.api.presence.Presence presence : listD) {
                User user = presence.getUser();
                if (user != null) {
                    handlePresenceUpdate(guild.getId(), user.getId(), presence.getStatus(), presence.getClientStatus(), presence.b());
                }
            }
        }
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId, long userId) {
        Map<Long, TimestampedPresence> map = this.userGuildPresences.get(Long.valueOf(userId));
        if ((map != null ? map.remove(Long.valueOf(guildId)) : null) != null) {
            flattenPresence(userId);
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        clearPresences(guild.getId());
    }

    @Store3
    public final void handlePresenceReplace(List<com.discord.api.presence.Presence> presencesList) {
        Intrinsics3.checkNotNullParameter(presencesList, "presencesList");
        clearPresences(RecyclerView.FOREVER_NS);
        for (com.discord.api.presence.Presence presence : presencesList) {
            User user = presence.getUser();
            if (user != null) {
                long id2 = user.getId();
                ClientStatus status = presence.getStatus();
                ClientStatuses clientStatus = presence.getClientStatus();
                if (clientStatus == null) {
                    ClientStatus clientStatus2 = ClientStatus.OFFLINE;
                    clientStatus = new ClientStatuses(clientStatus2, clientStatus2, clientStatus2);
                }
                handlePresenceUpdate(RecyclerView.FOREVER_NS, id2, status, clientStatus, presence.b());
            }
        }
    }

    @Store3
    public final void handlePresenceUpdate(long guildId, com.discord.api.presence.Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if (user != null) {
            handlePresenceUpdate(guildId, user.getId(), presence.getStatus(), presence.getClientStatus(), presence.b());
        }
    }

    @Store3
    public final void handleSessionsReplace(List<? extends ModelSession> sessions) {
        Intrinsics3.checkNotNullParameter(sessions, "sessions");
        updateSelfPresence(null, sessions, true);
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            for (ThreadListMember threadListMember : listB) {
                com.discord.api.presence.Presence presenceB = threadListMember.getPresence();
                if (presenceB != null) {
                    handlePresenceUpdate(threadMemberListUpdate.getGuildId(), threadListMember.getUserId(), presenceB.getStatus(), presenceB.getClientStatus(), presenceB.b());
                }
            }
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            for (AugmentedThreadMember augmentedThreadMember : listA) {
                com.discord.api.presence.Presence presence = augmentedThreadMember.getPresence();
                if (presence != null) {
                    handlePresenceUpdate(threadMembersUpdate.getGuildId(), augmentedThreadMember.getUserId(), presence.getStatus(), presence.getClientStatus(), presence.b());
                }
            }
        }
    }

    @Store3
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        Intrinsics3.checkNotNullParameter(userSettings, "userSettings");
        updateSelfPresence(userSettings, null, true);
    }

    public final Observable<Map<Long, Presence>> observeAllPresences() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Activity> observeApplicationActivity(long userId, long applicationId) {
        Observable<Activity> observableR = observePresenceForUser(userId).G(new AnonymousClass1(applicationId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observePresenceForUser(u…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Presence> observeLocalPresence() {
        Observable<Presence> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{LocalPresenceUpdateSource}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n      .c…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Presence> observePresenceForUser(long userId) {
        Observable<Presence> observableR = observeAllPresences().G(new AnonymousClass1(userId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeAllPresences()\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Presence>> observePresencesForUsers(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Presence>> observableR = observeAllPresences().G(new AnonymousClass1(userIds)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeAllPresences()\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.presencesSnapshot = this.presences.fastCopy();
        Presence presence = this.localPresence;
        List<Activity> activities = presence.getActivities();
        this.localPresenceSnapshot = Presence.copy$default(presence, null, null, activities != null ? _Collections.toList(activities) : null, 3, null);
        if (getUpdateSources().contains(LocalPresenceUpdateSource)) {
            StoreGatewayConnection.presenceUpdate$default(StoreStream.INSTANCE.getGatewaySocket(), this.localPresence.getStatus(), null, this.localPresence.getActivities(), null, 10, null);
        }
    }

    @Store3
    public final void updateActivity(ActivityType type, Activity activity, boolean forceDirty) {
        Activity activity2;
        Object next;
        Intrinsics3.checkNotNullParameter(type, "type");
        if (!forceDirty) {
            List<Activity> activities = this.localPresence.getActivities();
            if (activities != null) {
                Iterator<T> it = activities.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((Activity) next).getType() == (activity != null ? activity.getType() : null)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                activity2 = (Activity) next;
            } else {
                activity2 = null;
            }
            if (!(!Intrinsics3.areEqual(activity, activity2))) {
                return;
            }
        }
        List<Activity> listReplaceActivityInList = activity != null ? replaceActivityInList(activity, this.localPresence.getActivities()) : removeActivityInList(type, this.localPresence.getActivities());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listReplaceActivityInList) {
            if (((Activity) obj).getType() != ActivityType.UNKNOWN) {
                arrayList.add(obj);
            }
        }
        this.localPresence = new Presence(this.localPresence.getStatus(), null, arrayList);
        markChanged(LocalPresenceUpdateSource);
        MeUser meUser = this.meUser;
        if (meUser != null) {
            long id2 = meUser.getId();
            if (!Intrinsics3.areEqual(this.presences.get(Long.valueOf(id2)), this.localPresence)) {
                this.presences.put(Long.valueOf(id2), this.localPresence);
                markChanged();
            }
        }
    }

    /* renamed from: getPresences, reason: collision with other method in class */
    public final Map<Long, Presence> m19getPresences() {
        return this.presencesSnapshot;
    }

    @Store3
    public final void handlePresenceUpdate(long guildId, long userId, ClientStatus status, ClientStatuses clientStatuses, List<Activity> activities) {
        Intrinsics3.checkNotNullParameter(status, "status");
        if (guildId == 0) {
            guildId = Long.MAX_VALUE;
        }
        MeUser meUser = this.meUser;
        if (meUser == null || meUser.getId() != userId || guildId == RecyclerView.FOREVER_NS) {
            HashMap<Long, Map<Long, TimestampedPresence>> map = this.userGuildPresences;
            Long lValueOf = Long.valueOf(userId);
            Map<Long, TimestampedPresence> map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(lValueOf, map2);
            }
            map2.put(Long.valueOf(guildId), new TimestampedPresence(new Presence(status, clientStatuses, activities), this.clock.currentTimeMillis()));
            flattenPresence(userId);
        }
    }
}

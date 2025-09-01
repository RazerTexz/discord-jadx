package com.discord.utilities.threads;

import android.content.Context;
import android.content.res.Resources;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import com.discord.widgets.chat.list.ViewThreadsFeatureFlag;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._CollectionsJvm;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: ThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001dB\t\b\u0002¢\u0006\u0004\bb\u0010cJK\u0010\t\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u001c\u0010\u0007\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJM\u0010\r\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00022&\u0010\f\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u000fj\b\u0012\u0004\u0012\u00020\u000b`\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012JU\u0010\u0014\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00022&\u0010\f\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b0\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\nJ;\u0010\u001a\u001a\u00020\u0003*\u00020\u00062\u000e\u0010\u0016\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00152\u000e\u0010\u0017\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\"\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\u00020\u001e2\u000e\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$¢\u0006\u0004\b&\u0010'J-\u0010+\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u000e\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u00020\u001e2\n\u0010.\u001a\u00060\u0003j\u0002`-¢\u0006\u0004\b/\u00100J;\u00107\u001a\u00020\u001e2\u000e\u00101\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$2\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J;\u0010:\u001a\u00020\u001e2\u000e\u00101\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$2\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u00109\u001a\u00020\u001e¢\u0006\u0004\b:\u0010;J;\u0010<\u001a\u00020\u001e2\u000e\u00101\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$2\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b<\u00108J%\u0010=\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u00062\u000e\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$¢\u0006\u0004\b=\u0010>J'\u0010?\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u00062\u000e\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$¢\u0006\u0004\b?\u0010>J\u001d\u0010@\u001a\u00020\u001e2\u000e\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`$¢\u0006\u0004\b@\u0010'J\u001d\u0010E\u001a\u00020D2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020 ¢\u0006\u0004\bE\u0010FJ\u0015\u0010G\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\bG\u0010HJ)\u0010M\u001a\u00020L2\u0006\u0010B\u001a\u00020A2\u0006\u0010J\u001a\u00020I2\n\u0010K\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\bM\u0010NJU\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060V2\n\u0010O\u001a\u00060\u0003j\u0002`\u00042\u000e\u0010Q\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`P2\u0006\u0010R\u001a\u00020 2\u0006\u0010S\u001a\u00020D2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010 2\b\u0010U\u001a\u0004\u0018\u00010D¢\u0006\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020 8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010ZR5\u0010]\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0[j\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 `\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020 8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010Z¨\u0006e"}, d2 = {"Lcom/discord/utilities/threads/ThreadUtils;", "", "", "", "Lcom/discord/primitives/ChannelId;", "", "Lcom/discord/api/channel/Channel;", "sortedThreadsMap", "selectedThread", "prependSelectedThread", "(Ljava/util/Map;Lcom/discord/api/channel/Channel;)Ljava/util/Map;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "threadsMap", "sortThreadsByJoinedDate", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getThreadTimestampComparator", "()Ljava/util/Comparator;", "selectedChannel", "sortThreadsForChannelList", "Lcom/discord/primitives/Timestamp;", "guildJoinedAt", "threadJoinedAt", "Lcom/discord/utilities/time/Clock;", "clock", "getThreadAckMessageTimestamp", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;Ljava/lang/Long;Lcom/discord/utilities/time/Clock;)J", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "", "isGuildOrCategoryOrParentMuted", "", "parentNotificationSetting", "computeThreadNotificationSetting", "(Lcom/discord/stores/StoreThreadsJoined$JoinedThread;ZLjava/lang/Integer;)I", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "isThreadModerator", "(Ljava/lang/Long;)Z", "Lcom/discord/models/user/User;", "user", "channel", "canManageThread", "(Lcom/discord/models/user/User;Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Z", "Lcom/discord/primitives/GuildId;", "guildId", "isThreadsEnabled", "(J)Z", "parentChannelPermissions", "parentChannel", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/models/guild/Guild;", "guild", "canCreatePublicThread", "(Ljava/lang/Long;Lcom/discord/api/channel/Channel;Lcom/discord/models/message/Message;Lcom/discord/models/guild/Guild;)Z", "checkGuildFeature", "canCreatePrivateThread", "(Ljava/lang/Long;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Z)Z", "canCreateThread", "canUnarchiveThread", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Z", "canViewAllPublicArchivedThreads", "canViewAllPrivateThreads", "Landroid/content/Context;", "context", "minutes", "", "autoArchiveDurationName", "(Landroid/content/Context;I)Ljava/lang/String;", "computeThreadAutoArchiveTimeMs", "(Lcom/discord/api/channel/Channel;)J", "Lcom/discord/utilities/error/Error;", "error", "channelId", "", "handleThreadCreateError", "(Landroid/content/Context;Lcom/discord/utilities/error/Error;J)V", "parentChannelId", "Lcom/discord/primitives/MessageId;", "parentMessageId", "type", ModelAuditLogEntry.CHANGE_KEY_NAME, "autoArchiveDuration", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Lrx/Observable;", "createThread", "(JLjava/lang/Long;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lrx/Observable;", "MAX_DISPLAYED_THREAD_BROWSER_ICON_COUNT", "I", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "THREAD_AUTO_ARCHIVE_DURATION_NAMES", "Ljava/util/LinkedHashMap;", "getTHREAD_AUTO_ARCHIVE_DURATION_NAMES", "()Ljava/util/LinkedHashMap;", "DEFAULT_AUTO_ARCHIVE_DURATION", "<init>", "()V", "ThreadArchiveDurations", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ThreadUtils {
    public static final int DEFAULT_AUTO_ARCHIVE_DURATION = 1440;
    public static final int MAX_DISPLAYED_THREAD_BROWSER_ICON_COUNT = 99;
    public static final ThreadUtils INSTANCE = new ThreadUtils();
    private static final LinkedHashMap<Integer, Integer> THREAD_AUTO_ARCHIVE_DURATION_NAMES = Maps6.linkedMapOf(Tuples.to(60, Integer.valueOf(R.string.auto_archive_duration_1_hour)), Tuples.to(1440, Integer.valueOf(R.string.auto_archive_duration_24_hours)), Tuples.to(Integer.valueOf(ThreadArchiveDurations.THREE_DAYS_IN_MINUTES), Integer.valueOf(R.string.auto_archive_duration_3_days)), Tuples.to(Integer.valueOf(ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES), Integer.valueOf(R.string.auto_archive_duration_1_week)));

    /* compiled from: ThreadUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/discord/utilities/threads/ThreadUtils$ThreadArchiveDurations;", "", "", "THREE_DAYS_IN_MINUTES", "I", "ONE_DAY_IN_MINUTES", "ONE_HOUR_IN_MINUTES", "SEVEN_DAYS_IN_MINUTES", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ThreadArchiveDurations {
        public static final ThreadArchiveDurations INSTANCE = new ThreadArchiveDurations();
        public static final int ONE_DAY_IN_MINUTES = 1440;
        public static final int ONE_HOUR_IN_MINUTES = 60;
        public static final int SEVEN_DAYS_IN_MINUTES = 10080;
        public static final int THREE_DAYS_IN_MINUTES = 4320;

        private ThreadArchiveDurations() {
        }
    }

    /* compiled from: ThreadUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "kotlin.jvm.PlatformType", "o1", "o2", "", "compare", "(Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.threads.ThreadUtils$getThreadTimestampComparator$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Comparator<StoreThreadsActiveJoined.ActiveJoinedThread> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread2) {
            return compare2(activeJoinedThread, activeJoinedThread2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread2) {
            return (activeJoinedThread2.getJoinTimestamp().getDateTimeMillis() > activeJoinedThread.getJoinTimestamp().getDateTimeMillis() ? 1 : (activeJoinedThread2.getJoinTimestamp().getDateTimeMillis() == activeJoinedThread.getJoinTimestamp().getDateTimeMillis() ? 0 : -1));
        }
    }

    private ThreadUtils() {
    }

    public static /* synthetic */ boolean canCreatePrivateThread$default(ThreadUtils threadUtils, Long l, Channel channel, Guild guild, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return threadUtils.canCreatePrivateThread(l, channel, guild, z2);
    }

    public static /* synthetic */ Observable createThread$default(ThreadUtils threadUtils, long j, Long l, int i, String str, Integer num, String str2, int i2, Object obj) {
        return threadUtils.createThread(j, l, i, str, (i2 & 16) != 0 ? null : num, str2);
    }

    public static /* synthetic */ long getThreadAckMessageTimestamp$default(ThreadUtils threadUtils, Channel channel, Long l, Long l2, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return threadUtils.getThreadAckMessageTimestamp(channel, l, l2, clock);
    }

    private final Comparator<StoreThreadsActiveJoined.ActiveJoinedThread> getThreadTimestampComparator() {
        return AnonymousClass1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<Long, Collection<Channel>> prependSelectedThread(Map<Long, ? extends Collection<Channel>> sortedThreadsMap, Channel selectedThread) {
        boolean z2;
        Collection collectionEmptyList = (Collection) sortedThreadsMap.get(Long.valueOf(selectedThread.getParentId()));
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections2.emptyList();
        }
        if ((collectionEmptyList instanceof Collection) && collectionEmptyList.isEmpty()) {
            z2 = false;
        } else {
            Iterator it = collectionEmptyList.iterator();
            while (it.hasNext()) {
                if (((Channel) it.next()).getId() == selectedThread.getId()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            return sortedThreadsMap;
        }
        Map<Long, Collection<Channel>> mutableMap = Maps6.toMutableMap(sortedThreadsMap);
        Long lValueOf = Long.valueOf(selectedThread.getParentId());
        List listMutableListOf = Collections2.mutableListOf(selectedThread);
        listMutableListOf.addAll(collectionEmptyList);
        mutableMap.put(lValueOf, listMutableListOf);
        return mutableMap;
    }

    private final Map<Long, Collection<Channel>> sortThreadsByJoinedDate(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> threadsMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(threadsMap.size()));
        Iterator<T> it = threadsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            SortedSet sortedSet = _CollectionsJvm.toSortedSet(((Map) entry.getValue()).values(), INSTANCE.getThreadTimestampComparator());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedSet, 10));
            Iterator it2 = sortedSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((StoreThreadsActiveJoined.ActiveJoinedThread) it2.next()).getChannel());
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }

    public final String autoArchiveDurationName(Context context, int minutes) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        Integer num = THREAD_AUTO_ARCHIVE_DURATION_NAMES.get(Integer.valueOf(minutes));
        if (num != null) {
            Intrinsics3.checkNotNullExpressionValue(num, "it");
            String string = context.getString(num.intValue());
            if (string != null) {
                return string;
            }
        }
        String quantityString = context.getResources().getQuantityString(R.plurals.duration_hours_hours, minutes / 60);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "context.resources.getQua…ours_hours, minutes / 60)");
        return quantityString;
    }

    public final boolean canCreatePrivateThread(Long parentChannelPermissions, Channel parentChannel, Guild guild, boolean checkGuildFeature) {
        if (guild == null || parentChannel == null) {
            return false;
        }
        boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(parentChannel, parentChannelPermissions);
        boolean zCan = PermissionUtils.can(Permission.CREATE_PRIVATE_THREADS, parentChannelPermissions);
        if (!NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guild.getId())) {
            zCan = zHasAccessWrite && zCan;
        }
        return isThreadsEnabled(guild.getId()) && zCan && (!ChannelUtils.H(parentChannel) && !ChannelUtils.J(parentChannel)) && (!checkGuildFeature || guild.hasFeature(GuildFeature.PRIVATE_THREADS)) && !ChannelUtils.i(parentChannel);
    }

    public final boolean canCreatePublicThread(Long parentChannelPermissions, Channel parentChannel, Message message, Guild guild) {
        if (guild == null || parentChannel == null) {
            return false;
        }
        boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(parentChannel, parentChannelPermissions);
        boolean zCan = PermissionUtils.can(Permission.CREATE_PUBLIC_THREADS, parentChannelPermissions);
        boolean z2 = message == null || PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, parentChannelPermissions);
        return isThreadsEnabled(guild.getId()) && (!NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guild.getId()) ? !(!zHasAccessWrite || !zCan || !z2) : !(!zCan || !z2)) && ((message == null || !message.isSystemMessage()) && !ChannelUtils.H(parentChannel) && ((message == null || !message.hasThread()) && !ChannelUtils.J(parentChannel)));
    }

    public final boolean canCreateThread(Long parentChannelPermissions, Channel parentChannel, Message message, Guild guild) {
        return canCreatePublicThread(parentChannelPermissions, parentChannel, message, guild) || canCreatePrivateThread$default(this, parentChannelPermissions, parentChannel, guild, false, 8, null);
    }

    public final boolean canManageThread(User user, Channel channel, Long channelPermissions) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (channel.getOwnerId() == user.getId() && PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions)) {
            return true;
        }
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.INSTANCE.hasAccess(channel, channelPermissions);
    }

    public final boolean canUnarchiveThread(Channel channel, Long channelPermissions) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        return Intrinsics3.areEqual(threadMetadata != null ? Boolean.valueOf(threadMetadata.getLocked()) : null, Boolean.TRUE) ? PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions) : PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions);
    }

    public final boolean canViewAllPrivateThreads(Long channelPermissions) {
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, channelPermissions);
    }

    public final boolean canViewAllPublicArchivedThreads(Channel channel, Long channelPermissions) {
        return channel != null && PermissionUtils.INSTANCE.hasAccess(channel, channelPermissions) && PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, channelPermissions);
    }

    public final long computeThreadAutoArchiveTimeMs(Channel channel) {
        String archiveTimestamp;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long lastMessageId = (channel.getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        int autoArchiveDuration = (threadMetadata != null ? threadMetadata.getAutoArchiveDuration() : 0) * 60 * 1000;
        ThreadMetadata threadMetadata2 = channel.getThreadMetadata();
        return Math.max(lastMessageId, (threadMetadata2 == null || (archiveTimestamp = threadMetadata2.getArchiveTimestamp()) == null) ? 0L : TimeUtils.parseUTCDate(archiveTimestamp)) + autoArchiveDuration;
    }

    public final int computeThreadNotificationSetting(StoreThreadsJoined.JoinedThread joinedThread, boolean isGuildOrCategoryOrParentMuted, Integer parentNotificationSetting) {
        Integer numValueOf = joinedThread != null ? Integer.valueOf(joinedThread.getFlags()) : null;
        if (numValueOf != null) {
            if ((numValueOf.intValue() & 2) == 0) {
                if ((numValueOf.intValue() & 4) != 0) {
                    return 4;
                }
                if ((numValueOf.intValue() & 8) == 0 && !isGuildOrCategoryOrParentMuted) {
                    int i = ModelNotificationSettings.FREQUENCY_MENTIONS;
                    if (parentNotificationSetting != null && parentNotificationSetting.intValue() == i) {
                        return 4;
                    }
                    int i2 = ModelNotificationSettings.FREQUENCY_NOTHING;
                    if (parentNotificationSetting != null && parentNotificationSetting.intValue() == i2) {
                    }
                }
            }
            return 2;
        }
        return 8;
    }

    public final Observable<Channel> createThread(long parentChannelId, Long parentMessageId, int type, String name, Integer autoArchiveDuration, String location) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        RestAPIParams.ThreadCreationSettings threadCreationSettings = new RestAPIParams.ThreadCreationSettings(name, type, autoArchiveDuration);
        return parentMessageId == null ? RestAPI.INSTANCE.getApi().createThread(parentChannelId, location, threadCreationSettings) : RestAPI.INSTANCE.getApi().createThreadFromMessage(parentChannelId, parentMessageId.longValue(), location, threadCreationSettings);
    }

    public final LinkedHashMap<Integer, Integer> getTHREAD_AUTO_ARCHIVE_DURATION_NAMES() {
        return THREAD_AUTO_ARCHIVE_DURATION_NAMES;
    }

    public final long getThreadAckMessageTimestamp(Channel channel, Long l, Long l2, Clock clock) {
        String archiveTimestamp;
        Intrinsics3.checkNotNullParameter(channel, "$this$getThreadAckMessageTimestamp");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        long jLongValue = l != null ? l.longValue() : clock.currentTimeMillis();
        long jLongValue2 = l2 != null ? l2.longValue() - 5000 : 0L;
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        long jMax = Math.max(jLongValue2, (threadMetadata == null || (archiveTimestamp = threadMetadata.getArchiveTimestamp()) == null) ? 0L : TimeUtils.parseUTCDate(archiveTimestamp));
        if (jMax == 0) {
            jMax = TimeUtils.parseSnowflake(Long.valueOf(channel.getId()));
        }
        return Math.max(jLongValue, jMax);
    }

    public final void handleThreadCreateError(Context context, Error error, long channelId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(error, "error");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getCode() == 20016) {
            Error.Response response3 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs = response3.getRetryAfterMs();
            if (retryAfterMs == null) {
                retryAfterMs = 0L;
            }
            Intrinsics3.checkNotNullExpressionValue(retryAfterMs, "error.response.retryAfterMs ?: 0");
            StoreStream.INSTANCE.getSlowMode().onCooldown(channelId, retryAfterMs.longValue(), StoreSlowMode.Type.ThreadCreate.INSTANCE);
        }
        AppToast.g(context, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, null, 12);
    }

    public final boolean isThreadModerator(Long channelPermissions) {
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions);
    }

    public final boolean isThreadsEnabled(long guildId) {
        return ViewThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled() && CreateThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guildId);
    }

    public final Map<Long, Collection<Channel>> sortThreadsForChannelList(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> threadsMap, Channel selectedChannel) {
        Intrinsics3.checkNotNullParameter(threadsMap, "threadsMap");
        if (!ViewThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
            return Maps6.emptyMap();
        }
        Map<Long, Collection<Channel>> mapSortThreadsByJoinedDate = sortThreadsByJoinedDate(threadsMap);
        return (selectedChannel == null || !ChannelUtils.H(selectedChannel)) ? mapSortThreadsByJoinedDate : prependSelectedThread(mapSortThreadsByJoinedDate, selectedChannel);
    }
}

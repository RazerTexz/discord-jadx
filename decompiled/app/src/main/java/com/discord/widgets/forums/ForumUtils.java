package com.discord.widgets.forums;

import android.content.Context;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.message.Message;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: ForumUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bD\u0010EJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\tJ3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J9\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b \u0010!J1\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00162\n\u0010#\u001a\u00060\u0002j\u0002`\"2\u0006\u0010$\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J!\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b0\u00101J\u001b\u00103\u001a\u0004\u0018\u00010\u0010*\u0002022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b5\u00106J\u0019\u00109\u001a\u0004\u0018\u00010\f2\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J!\u0010<\u001a\u0004\u0018\u00010-2\u0006\u0010+\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u000107¢\u0006\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010?¨\u0006F"}, d2 = {"Lcom/discord/widgets/forums/ForumUtils;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "", "canAccessForumChannels", "(JLcom/discord/stores/StoreExperiments;)Z", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "", "getPlaceholderReactionName", "(Lcom/discord/stores/StoreEmoji;)Ljava/lang/String;", "Ljava/util/Comparator;", "Lcom/discord/api/message/reaction/MessageReaction;", "getMessageReactionComparator", "(Lcom/discord/stores/StoreEmoji;)Ljava/util/Comparator;", "canAccessRedesignedForumChannels", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "observeCanAccessRedesignedForumChannels", "(JLcom/discord/stores/StoreExperiments;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "observeCanCreateForumChannels", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "storeExperiments", "Lcom/discord/api/channel/Channel;", "observeSelectedPostChannel", "(Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "Lcom/discord/primitives/ChannelId;", "channelId", "hasActiveThreads", "Lcom/discord/stores/ArchivedThreadsStore;", "storeArchivedThreads", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "maybeLoadAndObserveThreadListing", "(JZLcom/discord/stores/ArchivedThreadsStore;)Lrx/Observable;", "Landroid/content/Context;", "context", "lastMessageTimestampMs", "", "getActiveAgoTimestamp", "(Landroid/content/Context;Ljava/lang/Long;)Ljava/lang/CharSequence;", "getPlaceholderMessageReaction", "(Lcom/discord/stores/StoreEmoji;)Lcom/discord/api/message/reaction/MessageReaction;", "Lcom/discord/models/message/Message;", "mostCommonReaction", "(Lcom/discord/models/message/Message;Lcom/discord/stores/StoreEmoji;)Lcom/discord/api/message/reaction/MessageReaction;", "isDefaultPostReaction", "(Lcom/discord/api/message/reaction/MessageReaction;Lcom/discord/stores/StoreEmoji;)Z", "", "messageCount", "getMessageCountString", "(Ljava/lang/Integer;)Ljava/lang/String;", "unreadCount", "getUnreadMessageCountString", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/CharSequence;", "ONE_HOUR_IN_MILLIS", "J", "ONE_DAY_IN_MILLIS", "PLACEHOLDER_EMOJI_KEY", "Ljava/lang/String;", "THIRTY_DAYS_IN_MILLIS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumUtils {
    public static final ForumUtils INSTANCE = new ForumUtils();
    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private static final long ONE_HOUR_IN_MILLIS = 3600000;
    private static final String PLACEHOLDER_EMOJI_KEY = "heart";
    private static final long THIRTY_DAYS_IN_MILLIS = 2592000000L;

    /* compiled from: ForumUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/message/reaction/MessageReaction;", "kotlin.jvm.PlatformType", "messageReaction1", "messageReaction2", "", "compare", "(Lcom/discord/api/message/reaction/MessageReaction;Lcom/discord/api/message/reaction/MessageReaction;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumUtils$getMessageReactionComparator$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Comparator<MessageReaction> {
        public final /* synthetic */ StoreEmoji $storeEmoji;

        public AnonymousClass1(StoreEmoji storeEmoji) {
            this.$storeEmoji = storeEmoji;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(MessageReaction messageReaction, MessageReaction messageReaction2) {
            return compare2(messageReaction, messageReaction2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(MessageReaction messageReaction, MessageReaction messageReaction2) {
            if (messageReaction != null && messageReaction2 != null) {
                int count = messageReaction.getCount();
                int count2 = messageReaction2.getCount();
                String strAccess$getPlaceholderReactionName = ForumUtils.access$getPlaceholderReactionName(ForumUtils.INSTANCE, this.$storeEmoji);
                String name = messageReaction.getEmoji().getName();
                String name2 = messageReaction2.getEmoji().getName();
                String strC = messageReaction.getEmoji().c();
                String strC2 = messageReaction2.getEmoji().c();
                if (count2 != count) {
                    return count2 - count;
                }
                if (Intrinsics3.areEqual(strAccess$getPlaceholderReactionName, name)) {
                    return 1;
                }
                if (!Intrinsics3.areEqual(strAccess$getPlaceholderReactionName, name2) && strC2.compareTo(strC) <= 0) {
                    return 1;
                }
            } else if (messageReaction == null || messageReaction2 != null) {
                return (messageReaction != null || messageReaction2 == null) ? 0 : 1;
            }
            return -1;
        }
    }

    /* compiled from: ForumUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumUtils$observeCanAccessRedesignedForumChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ StoreExperiments $experimentsStore;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, StoreExperiments storeExperiments) {
            super(0);
            this.$guildId = j;
            this.$experimentsStore = storeExperiments;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ForumUtils.INSTANCE.canAccessRedesignedForumChannels(this.$guildId, this.$experimentsStore);
        }
    }

    /* compiled from: ForumUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumUtils$observeCanCreateForumChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ StoreExperiments $experimentsStore;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, StoreExperiments storeExperiments) {
            super(0);
            this.$guildId = j;
            this.$experimentsStore = storeExperiments;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ForumUtils.access$canAccessForumChannels(ForumUtils.INSTANCE, this.$guildId, this.$experimentsStore);
        }
    }

    /* compiled from: ForumUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/channel/Channel;", "invoke", "()Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumUtils$observeSelectedPostChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ StoreChannels $storeChannels;
        public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
        public final /* synthetic */ StoreExperiments $storeExperiments;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StoreChannels storeChannels) {
            super(0);
            this.$storeChannelsSelected = storeChannelsSelected;
            this.$storeExperiments = storeExperiments;
            this.$storeChannels = storeChannels;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel selectedChannel = this.$storeChannelsSelected.getSelectedChannel();
            if (selectedChannel == null) {
                return null;
            }
            boolean zCanAccessRedesignedForumChannels = ForumUtils.INSTANCE.canAccessRedesignedForumChannels(selectedChannel.getGuildId(), this.$storeExperiments);
            Channel channel = this.$storeChannels.getChannel(selectedChannel.getParentId());
            if (zCanAccessRedesignedForumChannels && channel != null && ChannelUtils.q(channel)) {
                return selectedChannel;
            }
            return null;
        }
    }

    private ForumUtils() {
    }

    public static final /* synthetic */ boolean access$canAccessForumChannels(ForumUtils forumUtils, long j, StoreExperiments storeExperiments) {
        return forumUtils.canAccessForumChannels(j, storeExperiments);
    }

    public static final /* synthetic */ String access$getPlaceholderReactionName(ForumUtils forumUtils, StoreEmoji storeEmoji) {
        return forumUtils.getPlaceholderReactionName(storeEmoji);
    }

    private final boolean canAccessForumChannels(long guildId, StoreExperiments experimentsStore) {
        Experiment guildExperiment = experimentsStore.getGuildExperiment("2021-07_threads_only_channel", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public static /* synthetic */ boolean canAccessForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        return forumUtils.canAccessForumChannels(j, storeExperiments);
    }

    public static /* synthetic */ boolean canAccessRedesignedForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        return forumUtils.canAccessRedesignedForumChannels(j, storeExperiments);
    }

    private final Comparator<MessageReaction> getMessageReactionComparator(StoreEmoji storeEmoji) {
        return new AnonymousClass1(storeEmoji);
    }

    private final String getPlaceholderReactionName(StoreEmoji storeEmoji) {
        MessageReactionEmoji emoji;
        MessageReaction placeholderMessageReaction = getPlaceholderMessageReaction(storeEmoji);
        if (placeholderMessageReaction == null || (emoji = placeholderMessageReaction.getEmoji()) == null) {
            return null;
        }
        return emoji.getName();
    }

    public static /* synthetic */ Observable maybeLoadAndObserveThreadListing$default(ForumUtils forumUtils, long j, boolean z2, ArchivedThreadsStore archivedThreadsStore, int i, Object obj) {
        if ((i & 4) != 0) {
            archivedThreadsStore = StoreStream.INSTANCE.getArchivedThreads();
        }
        return forumUtils.maybeLoadAndObserveThreadListing(j, z2, archivedThreadsStore);
    }

    public static /* synthetic */ Observable observeCanAccessRedesignedForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return forumUtils.observeCanAccessRedesignedForumChannels(j, storeExperiments, observationDeck);
    }

    public static /* synthetic */ Observable observeCanCreateForumChannels$default(ForumUtils forumUtils, long j, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 2) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return forumUtils.observeCanCreateForumChannels(j, storeExperiments, observationDeck);
    }

    public static /* synthetic */ Observable observeSelectedPostChannel$default(ForumUtils forumUtils, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        if ((i & 8) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return forumUtils.observeSelectedPostChannel(storeChannels, storeChannelsSelected, storeExperiments, observationDeck);
    }

    public final boolean canAccessRedesignedForumChannels(long guildId, StoreExperiments experimentsStore) {
        Intrinsics3.checkNotNullParameter(experimentsStore, "experimentsStore");
        Experiment guildExperiment = experimentsStore.getGuildExperiment("2022-03_android_forum_channel_redesign", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final CharSequence getActiveAgoTimestamp(Context context, Long lastMessageTimestampMs) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (lastMessageTimestampMs == null) {
            return null;
        }
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - lastMessageTimestampMs.longValue();
        if (jCurrentTimeMillis < 0) {
            return null;
        }
        return jCurrentTimeMillis < ONE_HOUR_IN_MILLIS ? FormatUtils.h(context, R.string.form_post_active_ago_timestamp_minutes, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getMinutesFromMillis(jCurrentTimeMillis))}, null, 4) : jCurrentTimeMillis < ONE_DAY_IN_MILLIS ? FormatUtils.h(context, R.string.form_post_active_ago_timestamp_hours, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getHoursFromMillis(jCurrentTimeMillis))}, null, 4) : jCurrentTimeMillis < 2592000000L ? FormatUtils.h(context, R.string.form_post_active_ago_timestamp_days, new Object[]{Integer.valueOf(TimeUtils.INSTANCE.getDaysFromMillis(jCurrentTimeMillis))}, null, 4) : context.getString(R.string.form_post_active_ago_timestamp_more_than_month);
    }

    public final String getMessageCountString(Integer messageCount) {
        if (messageCount == null) {
            return null;
        }
        return messageCount.intValue() < 50 ? String.valueOf(messageCount.intValue()) : "50+";
    }

    public final MessageReaction getPlaceholderMessageReaction(StoreEmoji storeEmoji) {
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        ModelEmojiUnicode modelEmojiUnicode = storeEmoji.getUnicodeEmojisNamesMap().get(PLACEHOLDER_EMOJI_KEY);
        if (modelEmojiUnicode != null) {
            return new MessageReaction(0, new MessageReactionEmoji(null, modelEmojiUnicode.getUniqueId(), false), false);
        }
        return null;
    }

    public final CharSequence getUnreadMessageCountString(Context context, Integer unreadCount) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (unreadCount == null || unreadCount.intValue() == 0) {
            return null;
        }
        return FormatUtils.h(context, R.string.forum_post_message_count_short_parenthetical, new Object[]{unreadCount.intValue() < 10 ? String.valueOf(unreadCount.intValue()) : "10+"}, null, 4);
    }

    public final boolean isDefaultPostReaction(MessageReaction messageReaction, StoreEmoji storeEmoji) {
        Intrinsics3.checkNotNullParameter(messageReaction, "$this$isDefaultPostReaction");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        return Intrinsics3.areEqual(messageReaction.getEmoji().getName(), getPlaceholderReactionName(storeEmoji));
    }

    public final Observable<ArchivedThreadsStore.ThreadListingState> maybeLoadAndObserveThreadListing(long channelId, boolean hasActiveThreads, ArchivedThreadsStore storeArchivedThreads) {
        Intrinsics3.checkNotNullParameter(storeArchivedThreads, "storeArchivedThreads");
        return hasActiveThreads ? storeArchivedThreads.observeGuildForumThreadListing(channelId) : storeArchivedThreads.loadAndObserveGuildForumThreadListing(channelId);
    }

    public final MessageReaction mostCommonReaction(Message message, StoreEmoji storeEmoji) {
        List listSortedWith;
        Intrinsics3.checkNotNullParameter(message, "$this$mostCommonReaction");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        List<MessageReaction> reactions = message.getReactions();
        if (reactions == null || (listSortedWith = _Collections.sortedWith(reactions, getMessageReactionComparator(storeEmoji))) == null) {
            return null;
        }
        return (MessageReaction) _Collections.firstOrNull(listSortedWith);
    }

    public final Observable<Boolean> observeCanAccessRedesignedForumChannels(long guildId, StoreExperiments experimentsStore, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(experimentsStore, "experimentsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{experimentsStore}, false, null, null, new AnonymousClass1(guildId, experimentsStore), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeCanCreateForumChannels(long guildId, StoreExperiments experimentsStore, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(experimentsStore, "experimentsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{experimentsStore}, false, null, null, new AnonymousClass1(guildId, experimentsStore), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Channel> observeSelectedPostChannel(StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Observable<Channel> observableR = ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeChannels, storeChannelsSelected, storeExperiments}, false, null, null, new AnonymousClass1(storeChannelsSelected, storeExperiments, storeChannels), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }
}

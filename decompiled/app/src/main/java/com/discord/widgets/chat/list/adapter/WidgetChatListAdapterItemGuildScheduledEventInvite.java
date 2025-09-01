package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.ViewKt;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.WidgetChatListAdapterItemGuildScheduledEventInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInviteBase;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildScheduledEventInviteBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildScheduledEventInviteBinding;", "Lkotlinx/coroutines/Job;", "inviteJoinJob", "Lkotlinx/coroutines/Job;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;Lcom/discord/stores/StoreGuildScheduledEvents;)V", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemGuildScheduledEventInviteBinding binding;
    private final StoreGuildScheduledEvents guildScheduledEventStore;
    private Job inviteJoinJob;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0082\b\u0018\u0000 A2\u00020\u0001:\u0001ABe\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\"\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0007J\u0082\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00162\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/R\u0019\u0010\u001d\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b2\u0010\u000eR\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b4\u0010\u000bR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b6\u0010\u0004R\u001b\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b8\u0010\u0014R\u0019\u0010#\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\b9\u0010\u0007R\u0019\u0010$\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b:\u0010\u0007R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b<\u0010\u0011R!\u0010\"\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\b>\u0010\u0018R\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b\u001c\u0010\u0007¨\u0006B"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "", "component2", "()Z", "component3", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component4", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/api/channel/Channel;", "component5", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component6", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/guild/UserGuildMember;", "component7", "()Lcom/discord/models/guild/UserGuildMember;", "", "Lcom/discord/primitives/ChannelId;", "component8", "()Ljava/lang/Long;", "component9", "component10", "invite", "isInGuild", "isRsvped", "guildScheduledEvent", "channel", "guild", "creator", "selectedVoiceChannelId", "canConnect", "canShare", "copy", "(Lcom/discord/models/domain/ModelInvite;ZZLcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/UserGuildMember;Ljava/lang/Long;ZZ)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "Lcom/discord/models/guild/UserGuildMember;", "getCreator", "getCanConnect", "getCanShare", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getSelectedVoiceChannelId", "<init>", "(Lcom/discord/models/domain/ModelInvite;ZZLcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/UserGuildMember;Ljava/lang/Long;ZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canConnect;
        private final boolean canShare;
        private final Channel channel;
        private final UserGuildMember creator;
        private final Guild guild;
        private final GuildScheduledEvent guildScheduledEvent;
        private final ModelInvite invite;
        private final boolean isInGuild;
        private final boolean isRsvped;
        private final Long selectedVoiceChannelId;

        /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JW\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion;", "", "Lcom/discord/widgets/chat/list/entries/GuildScheduledEventInviteEntry;", "item", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StorePermissions;", "permissionStore", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "observe", "(Lcom/discord/widgets/chat/list/entries/GuildScheduledEventInviteEntry;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable observe$default(Companion companion, GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, int i, Object obj) {
                return companion.observe(guildScheduledEventInviteEntry, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
            }

            public final Observable<Model> observe(GuildScheduledEventInviteEntry item, StoreGuilds guildStore, StoreUser userStore, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StorePermissions permissionStore) {
                Intrinsics3.checkNotNullParameter(item, "item");
                Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
                Intrinsics3.checkNotNullParameter(userStore, "userStore");
                Intrinsics3.checkNotNullParameter(channelStore, "channelStore");
                Intrinsics3.checkNotNullParameter(guildScheduledEventStore, "guildScheduledEventStore");
                Intrinsics3.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
                Intrinsics3.checkNotNullParameter(permissionStore, "permissionStore");
                return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildStore, userStore, guildScheduledEventStore, voiceChannelSelectedStore, permissionStore}, false, null, null, new WidgetChatListAdapterItemGuildScheduledEventInvite2(item, guildStore, userStore, guildScheduledEventStore, channelStore, voiceChannelSelectedStore, permissionStore), 14, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            this.invite = modelInvite;
            this.isInGuild = z2;
            this.isRsvped = z3;
            this.guildScheduledEvent = guildScheduledEvent;
            this.channel = channel;
            this.guild = guild;
            this.creator = userGuildMember;
            this.selectedVoiceChannelId = l;
            this.canConnect = z4;
            this.canShare = z5;
        }

        public static /* synthetic */ Model copy$default(Model model, ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.invite : modelInvite, (i & 2) != 0 ? model.isInGuild : z2, (i & 4) != 0 ? model.isRsvped : z3, (i & 8) != 0 ? model.guildScheduledEvent : guildScheduledEvent, (i & 16) != 0 ? model.channel : channel, (i & 32) != 0 ? model.guild : guild, (i & 64) != 0 ? model.creator : userGuildMember, (i & 128) != 0 ? model.selectedVoiceChannelId : l, (i & 256) != 0 ? model.canConnect : z4, (i & 512) != 0 ? model.canShare : z5);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsInGuild() {
            return this.isInGuild;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        /* renamed from: component5, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component6, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component7, reason: from getter */
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final Model copy(ModelInvite invite, boolean isInGuild, boolean isRsvped, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, Long selectedVoiceChannelId, boolean canConnect, boolean canShare) {
            Intrinsics3.checkNotNullParameter(invite, "invite");
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            return new Model(invite, isInGuild, isRsvped, guildScheduledEvent, channel, guild, creator, selectedVoiceChannelId, canConnect, canShare);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.invite, model.invite) && this.isInGuild == model.isInGuild && this.isRsvped == model.isRsvped && Intrinsics3.areEqual(this.guildScheduledEvent, model.guildScheduledEvent) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.creator, model.creator) && Intrinsics3.areEqual(this.selectedVoiceChannelId, model.selectedVoiceChannelId) && this.canConnect == model.canConnect && this.canShare == model.canShare;
        }

        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final boolean getCanShare() {
            return this.canShare;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelInvite modelInvite = this.invite;
            int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
            boolean z2 = this.isInGuild;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.isRsvped;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode2 = (i4 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode5 = (iHashCode4 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z4 = this.canConnect;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (iHashCode6 + i5) * 31;
            boolean z5 = this.canShare;
            return i6 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public final boolean isInGuild() {
            return this.isInGuild;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(invite=");
            sbU.append(this.invite);
            sbU.append(", isInGuild=");
            sbU.append(this.isInGuild);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", canConnect=");
            sbU.append(this.canConnect);
            sbU.append(", canShare=");
            return outline.O(sbU, this.canShare, ")");
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.isInGuild()) {
                WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.showForGuild(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getFragmentManager(), this.$model.getGuildScheduledEvent().getId());
            } else {
                WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(WidgetChatListAdapterItemGuildScheduledEventInvite.this, WidgetChatListAdapterItemGuildScheduledEventInvite.class, this.$model.getInvite(), null, null, 12, null);
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$getGuildScheduledEventStore$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).toggleMeRsvpForEvent(this.$model.getGuildScheduledEvent());
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Job jobAccess$getInviteJoinJob$p = WidgetChatListAdapterItemGuildScheduledEventInvite.access$getInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this);
            if (jobAccess$getInviteJoinJob$p == null || !jobAccess$getInviteJoinJob$p.a()) {
                WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite = WidgetChatListAdapterItemGuildScheduledEventInvite.this;
                WidgetChatListAdapterItemGuildScheduledEventInvite.access$setInviteJoinJob$p(widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemGuildScheduledEventInvite, widgetChatListAdapterItemGuildScheduledEventInvite.getClass(), this.$model.getInvite(), null, null, 12, null));
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass5(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).onShareButtonClick(this.$model.getGuildScheduledEvent(), new WeakReference<>(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getContext()), new WeakReference<>(ViewKt.findFragment(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getRecycler())));
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
            super(1, widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$configureUI((WidgetChatListAdapterItemGuildScheduledEventInvite) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$setSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this, subscription);
        }
    }

    public /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Model model) throws Resources.NotFoundException {
        widgetChatListAdapterItemGuildScheduledEventInvite.configureUI(model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildScheduledEventInvite.adapter;
    }

    public static final /* synthetic */ StoreGuildScheduledEvents access$getGuildScheduledEventStore$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.guildScheduledEventStore;
    }

    public static final /* synthetic */ Job access$getInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.subscription;
    }

    public static final /* synthetic */ void access$setInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Job job) {
        widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob = job;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Subscription subscription) {
        widgetChatListAdapterItemGuildScheduledEventInvite.subscription = subscription;
    }

    private final void configureUI(Model model) throws Resources.NotFoundException {
        GuildScheduledEventItemView guildScheduledEventItemView = this.binding.f2322b;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildScheduledEventInviteContainer");
        guildScheduledEventItemView.setBackground(null);
        GuildScheduledEventItemView guildScheduledEventItemView2 = this.binding.f2322b;
        GuildScheduledEvent guildScheduledEvent = model.getGuildScheduledEvent();
        Channel channel = model.getChannel();
        Guild guild = model.getGuild();
        UserGuildMember creator = model.getCreator();
        boolean zIsInGuild = model.isInGuild();
        boolean zIsRsvped = model.isRsvped();
        Long channelId = model.getGuildScheduledEvent().getChannelId();
        boolean z2 = false;
        if (channelId != null) {
            long jLongValue = channelId.longValue();
            Long selectedVoiceChannelId = model.getSelectedVoiceChannelId();
            if (selectedVoiceChannelId != null && jLongValue == selectedVoiceChannelId.longValue()) {
                z2 = true;
            }
        }
        guildScheduledEventItemView2.configureInChatList(guildScheduledEvent, channel, guild, creator, zIsInGuild, zIsRsvped, z2, model.getCanConnect(), new AnonymousClass2(model), new AnonymousClass3(model), new AnonymousClass4(model), new AnonymousClass5(model));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(R.layout.widget_chat_list_adapter_item_guild_scheduled_event_invite, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventStore");
        this.guildScheduledEventStore = storeGuildScheduledEvents;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
        WidgetChatListAdapterItemGuildScheduledEventInviteBinding widgetChatListAdapterItemGuildScheduledEventInviteBinding = new WidgetChatListAdapterItemGuildScheduledEventInviteBinding(guildScheduledEventItemView, guildScheduledEventItemView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildScheduledEventInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGuildScheduledEventInviteBinding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(Model.Companion.observe$default(Model.INSTANCE, (GuildScheduledEventInviteEntry) data, null, null, null, null, null, null, 126, null)), WidgetChatListAdapterItemGuildScheduledEventInvite.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 58, (Object) null);
    }
}

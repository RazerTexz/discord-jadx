package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.y.o0.SpeakersItem;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.databinding.WidgetChatListAdapterItemStageInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.stages.StageCardSpeakersView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StageInviteEntry;
import com.discord.widgets.stage.StageCardSpeaker;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.StageRoles;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.Result3;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemStageInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInviteBase;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;)V", "", "iconUrl", "updateIconUrlIfChanged", "(Ljava/lang/String;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/widgets/chat/list/entries/StageInviteEntry;", "item", "Lcom/discord/widgets/chat/list/entries/StageInviteEntry;", "Lkotlinx/coroutines/Job;", "inviteJoinJob", "Lkotlinx/coroutines/Job;", "Ljava/lang/String;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/databinding/WidgetChatListAdapterItemStageInviteBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemStageInviteBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemStageInviteBinding binding;
    private String iconUrl;
    private Job inviteJoinJob;
    private StageInviteEntry item;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemStageInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0082\b\u0018\u0000 @2\u00020\u0001:\u0001@BY\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\n\u0010\u001d\u001a\u00060\u0005j\u0002`\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJr\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\f\b\u0002\u0010\u001d\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010 \u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u000bR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u0004R\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b3\u0010\u0018R\u001b\u0010#\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u0010\u001bR\u001b\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b7\u0010\u0014R\u001d\u0010\u001d\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010\u000eR\u0019\u0010 \u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\u0011¨\u0006A"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "Lcom/discord/models/user/User;", "component3", "()Lcom/discord/models/user/User;", "Lcom/discord/api/channel/Channel;", "component4", "()Lcom/discord/api/channel/Channel;", "", "component5", "()Z", "Lcom/discord/api/stageinstance/StageInstance;", "component6", "()Lcom/discord/api/stageinstance/StageInstance;", "", "Lcom/discord/widgets/stage/StageCardSpeaker;", "component7", "()Ljava/util/List;", "", "component8", "()Ljava/lang/Integer;", "invite", "meId", "authorUser", "channel", "shouldAnimateGuildIcon", "stageInstance", "speakers", "listenersCount", "copy", "(Lcom/discord/models/domain/ModelInvite;JLcom/discord/models/user/User;Lcom/discord/api/channel/Channel;ZLcom/discord/api/stageinstance/StageInstance;Ljava/util/List;Ljava/lang/Integer;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getAuthorUser", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "Ljava/util/List;", "getSpeakers", "Ljava/lang/Integer;", "getListenersCount", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "J", "getMeId", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "getShouldAnimateGuildIcon", "<init>", "(Lcom/discord/models/domain/ModelInvite;JLcom/discord/models/user/User;Lcom/discord/api/channel/Channel;ZLcom/discord/api/stageinstance/StageInstance;Ljava/util/List;Ljava/lang/Integer;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final User authorUser;
        private final Channel channel;
        private final ModelInvite invite;
        private final Integer listenersCount;
        private final long meId;
        private final boolean shouldAnimateGuildIcon;
        private final List<StageCardSpeaker> speakers;
        private final StageInstance stageInstance;

        /* compiled from: WidgetChatListAdapterItemStageInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+JG\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\u0010\f\u001a\u00060\bj\u0002`\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u000e*\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jm\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model$Companion;", "", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreStageChannels;", "stageChannelStore", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/widgets/stage/StageCardSpeaker;", "speakersFromLocalStore", "(Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreStageChannels;JJ)Ljava/util/List;", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "stageInstanceState", "speakersFromRequest", "(Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;)Ljava/util/List;", "Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "member", "toStageCardSpeaker", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/stage/StageCardSpeaker;", "Lcom/discord/widgets/chat/list/entries/StageInviteEntry;", "item", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreAccessibility;", "accessibilityStore", "Lcom/discord/stores/StoreStageInstances;", "stageInstanceStore", "Lcom/discord/stores/StoreRequestedStageChannels;", "requestedInstanceStore", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "observe", "(Lcom/discord/widgets/chat/list/entries/StageInviteEntry;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreAccessibility;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/StoreRequestedStageChannels;Lcom/discord/stores/StoreStageChannels;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ List access$speakersFromLocalStore(Companion companion, StoreGuilds storeGuilds, StoreUser storeUser, StoreStageChannels storeStageChannels, long j, long j2) {
                return companion.speakersFromLocalStore(storeGuilds, storeUser, storeStageChannels, j, j2);
            }

            public static final /* synthetic */ List access$speakersFromRequest(Companion companion, StoreRequestedStageChannels.StageInstanceState stageInstanceState) {
                return companion.speakersFromRequest(stageInstanceState);
            }

            public static /* synthetic */ Observable observe$default(Companion companion, StageInviteEntry stageInviteEntry, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreAccessibility storeAccessibility, StoreStageInstances storeStageInstances, StoreRequestedStageChannels storeRequestedStageChannels, StoreStageChannels storeStageChannels, ObservationDeck observationDeck, int i, Object obj) {
                return companion.observe(stageInviteEntry, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility, (i & 32) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 64) != 0 ? StoreStream.INSTANCE.getRequestedStageChannels() : storeRequestedStageChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels, (i & 256) != 0 ? ObservationDeck4.get() : observationDeck);
            }

            private final List<StageCardSpeaker> speakersFromLocalStore(StoreGuilds guildStore, StoreUser userStore, StoreStageChannels stageChannelStore, long channelId, long guildId) {
                User user;
                Map<Long, StageRoles> channelRoles = stageChannelStore.getChannelRoles(channelId);
                if (channelRoles == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<Long, StageRoles> entry : channelRoles.entrySet()) {
                    long jLongValue = entry.getKey().longValue();
                    StageCardSpeaker stageCardSpeaker = (!StageRoles.m33isSpeakerimpl(entry.getValue().m35unboximpl()) || (user = userStore.getUsers().get(Long.valueOf(jLongValue))) == null) ? null : Model.INSTANCE.toStageCardSpeaker(user, guildStore.getMember(guildId, jLongValue));
                    if (stageCardSpeaker != null) {
                        arrayList.add(stageCardSpeaker);
                    }
                }
                return arrayList;
            }

            private final List<StageCardSpeaker> speakersFromRequest(StoreRequestedStageChannels.StageInstanceState stageInstanceState) {
                RecommendedStageInstance stageInstance;
                if (stageInstanceState == null || (stageInstance = stageInstanceState.getStageInstance()) == null) {
                    return null;
                }
                List<GuildMember> listC = stageInstance.c();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listC, 10));
                for (GuildMember guildMember : listC) {
                    arrayList.add(new StageCardSpeaker(new CoreUser(guildMember.getUser()), GuildMember.Companion.from$default(com.discord.models.member.GuildMember.INSTANCE, guildMember, guildMember.getGuildId(), null, StoreStream.INSTANCE.getGuilds(), 4, null)));
                }
                return arrayList;
            }

            private final StageCardSpeaker toStageCardSpeaker(User user, com.discord.models.member.GuildMember guildMember) {
                return new StageCardSpeaker(user, guildMember);
            }

            public final Observable<Model> observe(StageInviteEntry item, StoreUser userStore, StoreChannels channelStore, StoreGuilds guildStore, StoreAccessibility accessibilityStore, StoreStageInstances stageInstanceStore, StoreRequestedStageChannels requestedInstanceStore, StoreStageChannels stageChannelStore, ObservationDeck observationDeck) {
                Intrinsics3.checkNotNullParameter(item, "item");
                Intrinsics3.checkNotNullParameter(userStore, "userStore");
                Intrinsics3.checkNotNullParameter(channelStore, "channelStore");
                Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
                Intrinsics3.checkNotNullParameter(accessibilityStore, "accessibilityStore");
                Intrinsics3.checkNotNullParameter(stageInstanceStore, "stageInstanceStore");
                Intrinsics3.checkNotNullParameter(requestedInstanceStore, "requestedInstanceStore");
                Intrinsics3.checkNotNullParameter(stageChannelStore, "stageChannelStore");
                Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
                return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{userStore, channelStore, guildStore, accessibilityStore, stageInstanceStore, requestedInstanceStore, stageChannelStore}, false, null, null, new WidgetChatListAdapterItemStageInvite2(userStore, item, channelStore, accessibilityStore, stageInstanceStore, requestedInstanceStore, stageChannelStore, guildStore), 14, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(ModelInvite modelInvite, long j, User user, Channel channel, boolean z2, StageInstance stageInstance, List<StageCardSpeaker> list, Integer num) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            Intrinsics3.checkNotNullParameter(list, "speakers");
            this.invite = modelInvite;
            this.meId = j;
            this.authorUser = user;
            this.channel = channel;
            this.shouldAnimateGuildIcon = z2;
            this.stageInstance = stageInstance;
            this.speakers = list;
            this.listenersCount = num;
        }

        public static /* synthetic */ Model copy$default(Model model, ModelInvite modelInvite, long j, User user, Channel channel, boolean z2, StageInstance stageInstance, List list, Integer num, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.invite : modelInvite, (i & 2) != 0 ? model.meId : j, (i & 4) != 0 ? model.authorUser : user, (i & 8) != 0 ? model.channel : channel, (i & 16) != 0 ? model.shouldAnimateGuildIcon : z2, (i & 32) != 0 ? model.stageInstance : stageInstance, (i & 64) != 0 ? model.speakers : list, (i & 128) != 0 ? model.listenersCount : num);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* renamed from: component2, reason: from getter */
        public final long getMeId() {
            return this.meId;
        }

        /* renamed from: component3, reason: from getter */
        public final User getAuthorUser() {
            return this.authorUser;
        }

        /* renamed from: component4, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShouldAnimateGuildIcon() {
            return this.shouldAnimateGuildIcon;
        }

        /* renamed from: component6, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final List<StageCardSpeaker> component7() {
            return this.speakers;
        }

        /* renamed from: component8, reason: from getter */
        public final Integer getListenersCount() {
            return this.listenersCount;
        }

        public final Model copy(ModelInvite invite, long meId, User authorUser, Channel channel, boolean shouldAnimateGuildIcon, StageInstance stageInstance, List<StageCardSpeaker> speakers, Integer listenersCount) {
            Intrinsics3.checkNotNullParameter(invite, "invite");
            Intrinsics3.checkNotNullParameter(speakers, "speakers");
            return new Model(invite, meId, authorUser, channel, shouldAnimateGuildIcon, stageInstance, speakers, listenersCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.invite, model.invite) && this.meId == model.meId && Intrinsics3.areEqual(this.authorUser, model.authorUser) && Intrinsics3.areEqual(this.channel, model.channel) && this.shouldAnimateGuildIcon == model.shouldAnimateGuildIcon && Intrinsics3.areEqual(this.stageInstance, model.stageInstance) && Intrinsics3.areEqual(this.speakers, model.speakers) && Intrinsics3.areEqual(this.listenersCount, model.listenersCount);
        }

        public final User getAuthorUser() {
            return this.authorUser;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final Integer getListenersCount() {
            return this.listenersCount;
        }

        public final long getMeId() {
            return this.meId;
        }

        public final boolean getShouldAnimateGuildIcon() {
            return this.shouldAnimateGuildIcon;
        }

        public final List<StageCardSpeaker> getSpeakers() {
            return this.speakers;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelInvite modelInvite = this.invite;
            int iA = (b.a(this.meId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
            User user = this.authorUser;
            int iHashCode = (iA + (user != null ? user.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.shouldAnimateGuildIcon;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            StageInstance stageInstance = this.stageInstance;
            int iHashCode3 = (i2 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
            List<StageCardSpeaker> list = this.speakers;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Integer num = this.listenersCount;
            return iHashCode4 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(invite=");
            sbU.append(this.invite);
            sbU.append(", meId=");
            sbU.append(this.meId);
            sbU.append(", authorUser=");
            sbU.append(this.authorUser);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", shouldAnimateGuildIcon=");
            sbU.append(this.shouldAnimateGuildIcon);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(", speakers=");
            sbU.append(this.speakers);
            sbU.append(", listenersCount=");
            return outline.F(sbU, this.listenersCount, ")");
        }
    }

    /* compiled from: WidgetChatListAdapterItemStageInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetChatListAdapterItemStageInvite.kt */
        @DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$configureUI$2$1", f = "WidgetChatListAdapterItemStageInvite.kt", l = {121}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
            public final /* synthetic */ long $channelId;
            public final /* synthetic */ long $guildId;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, long j2, Continuation continuation) {
                super(2, continuation);
                this.$guildId = j;
                this.$channelId = j2;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass2.this.new AnonymousClass1(this.$guildId, this.$channelId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(modelInvite, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                    Context context = AnonymousClass2.this.$context;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    FragmentManager fragmentManager = WidgetChatListAdapterItemStageInvite.access$getAdapter$p(WidgetChatListAdapterItemStageInvite.this).getFragmentManager();
                    long j = this.$guildId;
                    long j2 = this.$channelId;
                    this.label = 1;
                    if (StageChannelJoinHelper.lurkAndJoinStageAsync$default(stageChannelJoinHelper, context, fragmentManager, j, j2, true, null, null, null, this, 224, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return Unit.a;
            }
        }

        public AnonymousClass2(Model model, Context context) {
            this.$model = model;
            this.$context = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onClick(View view) {
            Long lValueOf;
            long guildId;
            Guild guild = this.$model.getInvite().guild;
            if (guild != null) {
                guildId = guild.getId();
            } else {
                Channel channel = this.$model.getChannel();
                if (channel == null) {
                    lValueOf = null;
                    if (lValueOf == null) {
                        long jLongValue = lValueOf.longValue();
                        Channel channel2 = this.$model.getChannel();
                        if (channel2 != null) {
                            long id2 = channel2.getId();
                            Job jobAccess$getInviteJoinJob$p = WidgetChatListAdapterItemStageInvite.access$getInviteJoinJob$p(WidgetChatListAdapterItemStageInvite.this);
                            if (jobAccess$getInviteJoinJob$p == null || !jobAccess$getInviteJoinJob$p.a()) {
                                WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite = WidgetChatListAdapterItemStageInvite.this;
                                WidgetChatListAdapterItemStageInvite.access$setInviteJoinJob$p(widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemStageInvite, widgetChatListAdapterItemStageInvite.getClass(), this.$model.getInvite(), new AnonymousClass1(jLongValue, id2, null), null, 8, null));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                guildId = channel.getGuildId();
            }
            lValueOf = Long.valueOf(guildId);
            if (lValueOf == null) {
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemStageInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
            super(1, widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemStageInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemStageInvite.access$configureUI((WidgetChatListAdapterItemStageInvite) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemStageInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$onConfigure$2, reason: invalid class name */
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
            WidgetChatListAdapterItemStageInvite.access$setSubscription$p(WidgetChatListAdapterItemStageInvite.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStageInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_stage_invite, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.item_invite_channel_topic;
        TextView textView = (TextView) view.findViewById(R.id.item_invite_channel_topic);
        if (textView != null) {
            i = R.id.item_invite_guild_name;
            TextView textView2 = (TextView) view.findViewById(R.id.item_invite_guild_name);
            if (textView2 != null) {
                i = R.id.item_invite_header;
                TextView textView3 = (TextView) view.findViewById(R.id.item_invite_header);
                if (textView3 != null) {
                    i = R.id.item_invite_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_invite_image);
                    if (simpleDraweeView != null) {
                        i = R.id.item_invite_image_text;
                        TextView textView4 = (TextView) view.findViewById(R.id.item_invite_image_text);
                        if (textView4 != null) {
                            i = R.id.item_invite_join_button;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_invite_join_button);
                            if (materialButton != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i = R.id.item_listeners_count;
                                TextView textView5 = (TextView) view.findViewById(R.id.item_listeners_count);
                                if (textView5 != null) {
                                    i = R.id.stage_discovery_speakers_view;
                                    StageCardSpeakersView stageCardSpeakersView = (StageCardSpeakersView) view.findViewById(R.id.stage_discovery_speakers_view);
                                    if (stageCardSpeakersView != null) {
                                        WidgetChatListAdapterItemStageInviteBinding widgetChatListAdapterItemStageInviteBinding = new WidgetChatListAdapterItemStageInviteBinding(constraintLayout, textView, textView2, textView3, simpleDraweeView, textView4, materialButton, constraintLayout, textView5, stageCardSpeakersView);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStageInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemStageInviteBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, Model model) {
        widgetChatListAdapterItemStageInvite.configureUI(model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStageInvite.adapter;
    }

    public static final /* synthetic */ Job access$getInviteJoinJob$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return widgetChatListAdapterItemStageInvite.inviteJoinJob;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        return widgetChatListAdapterItemStageInvite.subscription;
    }

    public static final /* synthetic */ void access$setInviteJoinJob$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, Job job) {
        widgetChatListAdapterItemStageInvite.inviteJoinJob = job;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite, Subscription subscription) {
        widgetChatListAdapterItemStageInvite.subscription = subscription;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(Model model) {
        boolean z2;
        Guild guild;
        String name;
        String name2;
        String topic;
        String icon;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Guild guild2 = model.getInvite().guild;
        Long lValueOf = guild2 != null ? Long.valueOf(guild2.getId()) : null;
        Guild guild3 = model.getInvite().guild;
        updateIconUrlIfChanged(IconUtils.getForGuild$default(lValueOf, guild3 != null ? guild3.getIcon() : null, IconUtils.DEFAULT_ICON_BLURPLE, model.getShouldAnimateGuildIcon(), null, 16, null));
        Guild guild4 = model.getInvite().guild;
        int i = 0;
        if (guild4 == null || (icon = guild4.getIcon()) == null) {
            z2 = false;
        } else if (icon.length() > 0) {
            z2 = true;
        }
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteImageText");
        ViewExtensions.setTextAndVisibilityBy(textView, (z2 || (guild = model.getInvite().guild) == null || (name = guild.getName()) == null) ? null : GuildUtils.computeShortName(name));
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemInviteGuildName");
        Guild guild5 = model.getInvite().guild;
        if (guild5 == null || (name2 = guild5.getName()) == null) {
            Channel channel = model.getChannel();
            name2 = channel != null ? channel.getName() : null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView2, name2);
        TextView textView3 = this.binding.f2332b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemInviteChannelTopic");
        StageInstance stageInstance = model.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            Channel channel2 = model.getChannel();
            topic = channel2 != null ? channel2.getTopic() : null;
        }
        if (topic == null) {
            Channel channel3 = model.getChannel();
            topic = channel3 != null ? channel3.getName() : null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, topic);
        TextView textView4 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemListenersCount");
        Integer listenersCount = model.getListenersCount();
        ViewExtensions.setTextAndVisibilityBy(textView4, listenersCount != null ? String.valueOf(listenersCount.intValue()) : null);
        StageCardSpeakersView stageCardSpeakersView = this.binding.h;
        List<StageCardSpeaker> speakers = model.getSpeakers();
        RecyclerView.ItemDecoration itemDecoration = StageCardSpeakersView.j;
        int size = speakers.size();
        Objects.requireNonNull(stageCardSpeakersView);
        Intrinsics3.checkNotNullParameter(speakers, "speakers");
        List listTake = _Collections.take(speakers, 3);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listTake, 10));
        for (Object obj : listTake) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            StageCardSpeaker stageCardSpeaker = (StageCardSpeaker) obj;
            User user = stageCardSpeaker.getUser();
            com.discord.models.member.GuildMember guildMember = stageCardSpeaker.getGuildMember();
            String displayName = stageCardSpeaker.getDisplayName();
            StringBuilder sb = new StringBuilder();
            sb.append(size);
            sb.append('-');
            sb.append(i);
            arrayList.add(new SpeakersItem.a(user, guildMember, displayName, sb.toString()));
            i = i2;
        }
        int size2 = size - arrayList.size();
        Intrinsics3.checkNotNullParameter(arrayList, "speakersToDisplay");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        if (size2 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(size);
            sb2.append('-');
            sb2.append(arrayList.size() + 1);
            arrayList2.add(new SpeakersItem.b(size2, sb2.toString()));
        }
        stageCardSpeakersView.speakersAdapter.setData(arrayList2);
        this.binding.f.setOnClickListener(new AnonymousClass2(model, context));
    }

    private final void updateIconUrlIfChanged(String iconUrl) {
        if (!Intrinsics3.areEqual(this.iconUrl, iconUrl)) {
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteImage");
            IconUtils.setIcon$default(simpleDraweeView, iconUrl, R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            this.iconUrl = iconUrl;
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.item = (StageInviteEntry) data;
        StoreInstantInvites instantInvites = StoreStream.INSTANCE.getInstantInvites();
        StageInviteEntry stageInviteEntry = this.item;
        if (stageInviteEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        StoreInstantInvites.fetchInviteIfNotLoaded$default(instantInvites, stageInviteEntry.getInviteCode(), null, "Invite Button Embed", null, null, 26, null);
        Model.Companion companion = Model.INSTANCE;
        StageInviteEntry stageInviteEntry2 = this.item;
        if (stageInviteEntry2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        Observable observableG = ObservableExtensionsKt.ui(Model.Companion.observe$default(companion, stageInviteEntry2, null, null, null, null, null, null, null, null, 510, null)).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetChatListAdapterItemStageInvite.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 58, (Object) null);
    }
}

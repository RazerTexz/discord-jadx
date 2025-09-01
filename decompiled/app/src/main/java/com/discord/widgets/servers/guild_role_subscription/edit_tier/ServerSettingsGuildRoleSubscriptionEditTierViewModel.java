package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.api.guildrolesubscription.SubscriptionTrial;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005YZ[\\]Be\u0012\n\u0010C\u001a\u00060\u0010j\u0002`B\u0012\u0006\u0010O\u001a\u00020\u0010\u0012\u0006\u0010L\u001a\u00020\u0010\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010S\u001a\u00020R\u0012\b\b\u0002\u0010U\u001a\u00020T\u0012\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020\b0\u001b¢\u0006\u0004\bW\u0010XJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ[\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0018\u001a\u0014\u0012\b\u0012\u00060\u0010j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0005¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010(R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R:\u0010;\u001a&\u0012\f\u0012\n :*\u0004\u0018\u00010\u00030\u0003 :*\u0012\u0012\f\u0012\n :*\u0004\u0018\u00010\u00030\u0003\u0018\u000109098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010(R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010C\u001a\u00060\u0010j\u0002`B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010+R\u0018\u0010F\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010(R\u0018\u0010G\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010AR\u0018\u0010K\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00108R\u0016\u0010L\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010DR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010.R\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010D¨\u0006^"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "event", "", "emitEvent", "(Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;)V", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;)V", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "guildRoleSubscriptionTierFreeTrial", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojiSet", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "handleLoadedStoreState", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;Ljava/util/Map;Lcom/discord/models/domain/emoji/EmojiSet;Ljava/util/Map;)V", "Lrx/Observable;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "guildRoleSubscriptionTier", "onTierUpdated", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)V", "submitChanges", "()V", "publishTier", "deleteTier", "", "editedMemberIcon", "Ljava/lang/String;", "", "editedTierPrice", "Ljava/lang/Integer;", "Lcom/discord/nullserializable/NullSerializable;", "editedActiveTrialUserLimit", "Lcom/discord/nullserializable/NullSerializable;", "editedTierDescription", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "", "editedCanAccessAllChannelsFlag", "Ljava/lang/Boolean;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "editedTierImage", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$ChannelBenefit;", "editedChannelBenefits", "Ljava/util/List;", "Lcom/discord/primitives/GuildId;", "guildId", "J", "editedMemberColor", "editedTierName", "storedGuildRoleSubscriptionTier", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$IntangibleBenefit;", "editedIntangibleBenefits", "isFullServerGating", "guildRoleSubscriptionGroupListingId", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "editedTrialInterval", "guildRoleSubscriptionTierListingId", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "storeStateObservable", "<init>", "(JJJLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreEmoji;Lcom/discord/stores/StoreGuilds;Lrx/Observable;)V", "Companion", "Event", "GuildRoleSubscriptionStoreData", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private NullSerializable<Integer> editedActiveTrialUserLimit;
    private Boolean editedCanAccessAllChannelsFlag;
    private List<Benefit.ChannelBenefit> editedChannelBenefits;
    private List<Benefit.IntangibleBenefit> editedIntangibleBenefits;
    private Integer editedMemberColor;
    private String editedMemberIcon;
    private String editedTierDescription;
    private String editedTierImage;
    private String editedTierName;
    private Integer editedTierPrice;
    private NullSerializable<SubscriptionTrialInterval> editedTrialInterval;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final long guildRoleSubscriptionGroupListingId;
    private final long guildRoleSubscriptionTierListingId;
    private Boolean isFullServerGating;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;
    private GuildRoleSubscriptionTier storedGuildRoleSubscriptionTier;

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel = ServerSettingsGuildRoleSubscriptionEditTierViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$handleStoreState(serverSettingsGuildRoleSubscriptionEditTierViewModel, storeState);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JQ\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "guildRoleSubscriptionTierListingId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", "observeStoreState", "(JJLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreEmoji;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, long j2, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds) {
            return companion.observeStoreState(j, j2, observationDeck, storeGuildRoleSubscriptions, storeChannels, storeEmoji, storeGuilds);
        }

        private final Observable<StoreState> observeStoreState(long guildId, long guildRoleSubscriptionTierListingId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds) {
            Observable<StoreState> observableJ = Observable.j(storeEmoji.getEmojiSet(new StoreEmoji.EmojiContext.Guild(guildId), false, false), ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions, storeChannels, storeGuilds}, false, null, null, new ServerSettingsGuildRoleSubscriptionEditTierViewModel2(storeGuildRoleSubscriptions, guildId, storeChannels, storeGuilds, guildRoleSubscriptionTierListingId), 14, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…oreData\n        )\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "", "<init>", "()V", "DeleteFailure", "DeleteSuccess", "StoredStateUpdate", "SubmitFailure", "SubmitSuccess", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteSuccess;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class DeleteFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeleteFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ DeleteFailure copy$default(DeleteFailure deleteFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = deleteFailure.error;
                }
                return deleteFailure.copy(error);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final DeleteFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new DeleteFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DeleteFailure) && Intrinsics3.areEqual(this.error, ((DeleteFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("DeleteFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteSuccess;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class DeleteSuccess extends Event {
            public static final DeleteSuccess INSTANCE = new DeleteSuccess();

            private DeleteSuccess() {
                super(null);
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "component1", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "", "component2", "()Z", "guildRoleSubscriptionTier", "isFullServerGating", "copy", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;Z)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "getGuildRoleSubscriptionTier", "Z", "<init>", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class StoredStateUpdate extends Event {
            private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
            private final boolean isFullServerGating;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StoredStateUpdate(GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
                this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
                this.isFullServerGating = z2;
            }

            public static /* synthetic */ StoredStateUpdate copy$default(StoredStateUpdate storedStateUpdate, GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionTier = storedStateUpdate.guildRoleSubscriptionTier;
                }
                if ((i & 2) != 0) {
                    z2 = storedStateUpdate.isFullServerGating;
                }
                return storedStateUpdate.copy(guildRoleSubscriptionTier, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
                return this.guildRoleSubscriptionTier;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsFullServerGating() {
                return this.isFullServerGating;
            }

            public final StoredStateUpdate copy(GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean isFullServerGating) {
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
                return new StoredStateUpdate(guildRoleSubscriptionTier, isFullServerGating);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StoredStateUpdate)) {
                    return false;
                }
                StoredStateUpdate storedStateUpdate = (StoredStateUpdate) other;
                return Intrinsics3.areEqual(this.guildRoleSubscriptionTier, storedStateUpdate.guildRoleSubscriptionTier) && this.isFullServerGating == storedStateUpdate.isFullServerGating;
            }

            public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
                return this.guildRoleSubscriptionTier;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
                int iHashCode = (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0) * 31;
                boolean z2 = this.isFullServerGating;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public final boolean isFullServerGating() {
                return this.isFullServerGating;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StoredStateUpdate(guildRoleSubscriptionTier=");
                sbU.append(this.guildRoleSubscriptionTier);
                sbU.append(", isFullServerGating=");
                return outline.O(sbU, this.isFullServerGating, ")");
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitFailure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SubmitFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SubmitFailure copy$default(SubmitFailure submitFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = submitFailure.error;
                }
                return submitFailure.copy(error);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final SubmitFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new SubmitFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SubmitFailure) && Intrinsics3.areEqual(this.error, ((SubmitFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubmitFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SubmitSuccess extends Event {
            public static final SubmitSuccess INSTANCE = new SubmitSuccess();

            private SubmitSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0018\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJD\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\rR+\u0010\u000f\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "component1", "()Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component2", "()Ljava/util/Map;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "component3", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "guildRoleSubscriptionGroupListingState", "guildRoles", "guildRoleSubscriptionFreeTrial", "copy", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;Ljava/util/Map;Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "getGuildRoleSubscriptionGroupListingState", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "getGuildRoleSubscriptionFreeTrial", "Ljava/util/Map;", "getGuildRoles", "<init>", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;Ljava/util/Map;Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildRoleSubscriptionStoreData {
        private final GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionFreeTrial;
        private final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState;
        private final Map<Long, GuildRole> guildRoles;

        public GuildRoleSubscriptionStoreData(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Map<Long, GuildRole> map, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            this.guildRoleSubscriptionGroupListingState = guildRoleSubscriptionGroupState;
            this.guildRoles = map;
            this.guildRoleSubscriptionFreeTrial = guildRoleSubscriptionTierFreeTrial;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildRoleSubscriptionStoreData copy$default(GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData, StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Map map, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupState = guildRoleSubscriptionStoreData.guildRoleSubscriptionGroupListingState;
            }
            if ((i & 2) != 0) {
                map = guildRoleSubscriptionStoreData.guildRoles;
            }
            if ((i & 4) != 0) {
                guildRoleSubscriptionTierFreeTrial = guildRoleSubscriptionStoreData.guildRoleSubscriptionFreeTrial;
            }
            return guildRoleSubscriptionStoreData.copy(guildRoleSubscriptionGroupState, map, guildRoleSubscriptionTierFreeTrial);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupListingState() {
            return this.guildRoleSubscriptionGroupListingState;
        }

        public final Map<Long, GuildRole> component2() {
            return this.guildRoles;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrial() {
            return this.guildRoleSubscriptionFreeTrial;
        }

        public final GuildRoleSubscriptionStoreData copy(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState, Map<Long, GuildRole> guildRoles, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionFreeTrial) {
            return new GuildRoleSubscriptionStoreData(guildRoleSubscriptionGroupListingState, guildRoles, guildRoleSubscriptionFreeTrial);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildRoleSubscriptionStoreData)) {
                return false;
            }
            GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData = (GuildRoleSubscriptionStoreData) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListingState, guildRoleSubscriptionStoreData.guildRoleSubscriptionGroupListingState) && Intrinsics3.areEqual(this.guildRoles, guildRoleSubscriptionStoreData.guildRoles) && Intrinsics3.areEqual(this.guildRoleSubscriptionFreeTrial, guildRoleSubscriptionStoreData.guildRoleSubscriptionFreeTrial);
        }

        public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrial() {
            return this.guildRoleSubscriptionFreeTrial;
        }

        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupListingState() {
            return this.guildRoleSubscriptionGroupListingState;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupListingState;
            int iHashCode = (guildRoleSubscriptionGroupState != null ? guildRoleSubscriptionGroupState.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial = this.guildRoleSubscriptionFreeTrial;
            return iHashCode2 + (guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildRoleSubscriptionStoreData(guildRoleSubscriptionGroupListingState=");
            sbU.append(this.guildRoleSubscriptionGroupListingState);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", guildRoleSubscriptionFreeTrial=");
            sbU.append(this.guildRoleSubscriptionFreeTrial);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR)\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\rR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component1", "()Ljava/util/Map;", "Lcom/discord/models/domain/emoji/EmojiSet;", "component2", "()Lcom/discord/models/domain/emoji/EmojiSet;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "component3", "()Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "channels", "guildEmojis", "guildRoleSubscriptionStoreData", "copy", "(Ljava/util/Map;Lcom/discord/models/domain/emoji/EmojiSet;Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannels", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "getGuildRoleSubscriptionStoreData", "Lcom/discord/models/domain/emoji/EmojiSet;", "getGuildEmojis", "<init>", "(Ljava/util/Map;Lcom/discord/models/domain/emoji/EmojiSet;Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> channels;
        private final EmojiSet guildEmojis;
        private final GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData;

        public StoreState(Map<Long, Channel> map, EmojiSet emojiSet, GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData) {
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(emojiSet, "guildEmojis");
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionStoreData, "guildRoleSubscriptionStoreData");
            this.channels = map;
            this.guildEmojis = emojiSet;
            this.guildRoleSubscriptionStoreData = guildRoleSubscriptionStoreData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, EmojiSet emojiSet, GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.channels;
            }
            if ((i & 2) != 0) {
                emojiSet = storeState.guildEmojis;
            }
            if ((i & 4) != 0) {
                guildRoleSubscriptionStoreData = storeState.guildRoleSubscriptionStoreData;
            }
            return storeState.copy(map, emojiSet, guildRoleSubscriptionStoreData);
        }

        public final Map<Long, Channel> component1() {
            return this.channels;
        }

        /* renamed from: component2, reason: from getter */
        public final EmojiSet getGuildEmojis() {
            return this.guildEmojis;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRoleSubscriptionStoreData getGuildRoleSubscriptionStoreData() {
            return this.guildRoleSubscriptionStoreData;
        }

        public final StoreState copy(Map<Long, Channel> channels, EmojiSet guildEmojis, GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData) {
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(guildEmojis, "guildEmojis");
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionStoreData, "guildRoleSubscriptionStoreData");
            return new StoreState(channels, guildEmojis, guildRoleSubscriptionStoreData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.guildEmojis, storeState.guildEmojis) && Intrinsics3.areEqual(this.guildRoleSubscriptionStoreData, storeState.guildRoleSubscriptionStoreData);
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final EmojiSet getGuildEmojis() {
            return this.guildEmojis;
        }

        public final GuildRoleSubscriptionStoreData getGuildRoleSubscriptionStoreData() {
            return this.guildRoleSubscriptionStoreData;
        }

        public int hashCode() {
            Map<Long, Channel> map = this.channels;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            EmojiSet emojiSet = this.guildEmojis;
            int iHashCode2 = (iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0)) * 31;
            GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData = this.guildRoleSubscriptionStoreData;
            return iHashCode2 + (guildRoleSubscriptionStoreData != null ? guildRoleSubscriptionStoreData.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channels=");
            sbU.append(this.channels);
            sbU.append(", guildEmojis=");
            sbU.append(this.guildEmojis);
            sbU.append(", guildRoleSubscriptionStoreData=");
            sbU.append(this.guildRoleSubscriptionStoreData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Failed;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\r\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState;", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "component4", "hasChanges", "isPublished", "tierName", "isSubmitting", "copy", "(ZZLjava/lang/String;Z)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getTierName", "getHasChanges", "<init>", "(ZZLjava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean hasChanges;
            private final boolean isPublished;
            private final boolean isSubmitting;
            private final String tierName;

            public Loaded() {
                this(false, false, null, false, 15, null);
            }

            public /* synthetic */ Loaded(boolean z2, boolean z3, String str, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z4);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, String str, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.hasChanges;
                }
                if ((i & 2) != 0) {
                    z3 = loaded.isPublished;
                }
                if ((i & 4) != 0) {
                    str = loaded.tierName;
                }
                if ((i & 8) != 0) {
                    z4 = loaded.isSubmitting;
                }
                return loaded.copy(z2, z3, str, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsPublished() {
                return this.isPublished;
            }

            /* renamed from: component3, reason: from getter */
            public final String getTierName() {
                return this.tierName;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final Loaded copy(boolean hasChanges, boolean isPublished, String tierName, boolean isSubmitting) {
                return new Loaded(hasChanges, isPublished, tierName, isSubmitting);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.hasChanges == loaded.hasChanges && this.isPublished == loaded.isPublished && Intrinsics3.areEqual(this.tierName, loaded.tierName) && this.isSubmitting == loaded.isSubmitting;
            }

            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            public final String getTierName() {
                return this.tierName;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
            public int hashCode() {
                boolean z2 = this.hasChanges;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                ?? r2 = this.isPublished;
                int i2 = r2;
                if (r2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                String str = this.tierName;
                int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
                boolean z3 = this.isSubmitting;
                return iHashCode + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isPublished() {
                return this.isPublished;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(hasChanges=");
                sbU.append(this.hasChanges);
                sbU.append(", isPublished=");
                sbU.append(this.isPublished);
                sbU.append(", tierName=");
                sbU.append(this.tierName);
                sbU.append(", isSubmitting=");
                return outline.O(sbU, this.isSubmitting, ")");
            }

            public Loaded(boolean z2, boolean z3, String str, boolean z4) {
                super(null);
                this.hasChanges = z2;
                this.isPublished = z3;
                this.tierName = str;
                this.isSubmitting = z4;
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionBenefitType.INTANGIBLE.ordinal()] = 1;
            iArr[GuildRoleSubscriptionBenefitType.CHANNEL.ordinal()] = 2;
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r8) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, Event.DeleteSuccess.INSTANCE);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$deleteTier$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, new Event.DeleteFailure(error));
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "it", "", "invoke", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$publishTier$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, Event.SubmitSuccess.INSTANCE);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$publishTier$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, new Event.SubmitFailure(error));
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "it", "", "invoke", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$submitChanges$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 6, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, Event.SubmitSuccess.INSTANCE);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$submitChanges$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, null, false, 7, null));
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel.this, new Event.SubmitFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel(long j, long j2, long j3, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 16) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreChannels channels = (i & 32) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(j, j2, j3, api, guildRoleSubscriptions, channels, emojis, guilds, (i & 256) != 0 ? Companion.access$observeStoreState(INSTANCE, j, j2, ObservationDeck4.get(), guildRoleSubscriptions, channels, emojis, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, Event event) {
        serverSettingsGuildRoleSubscriptionEditTierViewModel.emitEvent(event);
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, StoreState storeState) {
        serverSettingsGuildRoleSubscriptionEditTierViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsGuildRoleSubscriptionEditTierViewModel serverSettingsGuildRoleSubscriptionEditTierViewModel, ViewState viewState) {
        serverSettingsGuildRoleSubscriptionEditTierViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleLoadedStoreState(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded storeState, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, Map<Long, Channel> channels, EmojiSet emojiSet, Map<Long, GuildRole> guildRoles) {
        List<GuildRoleSubscriptionTierListing> listH;
        Object next;
        String emojiName;
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = storeState.getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listH = guildRoleSubscriptionGroupListing.h()) == null) {
            return;
        }
        Iterator<T> it = listH.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((GuildRoleSubscriptionTierListing) next).getId() == this.guildRoleSubscriptionTierListingId) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = (GuildRoleSubscriptionTierListing) next;
        if (guildRoleSubscriptionTierListing != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (GuildRoleSubscriptionBenefit guildRoleSubscriptionBenefit : guildRoleSubscriptionTierListing.getRoleBenefits().a()) {
                Long emojiId = guildRoleSubscriptionBenefit.getEmojiId();
                if (emojiId == null || (emojiName = String.valueOf(emojiId.longValue())) == null) {
                    emojiName = guildRoleSubscriptionBenefit.getEmojiName();
                }
                Emoji emoji = emojiSet.emojiIndex.get(emojiName);
                if (emoji != null) {
                    int iOrdinal = guildRoleSubscriptionBenefit.getRefType().ordinal();
                    if (iOrdinal == 1) {
                        Channel channel = channels.get(guildRoleSubscriptionBenefit.getRefId());
                        if (channel != null) {
                            arrayList.add(new Benefit.ChannelBenefit(ChannelUtils.c(channel), emoji, guildRoleSubscriptionBenefit.getDescription(), Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(channel)), channel.getId()));
                        }
                    } else if (iOrdinal == 2) {
                        arrayList2.add(new Benefit.IntangibleBenefit(guildRoleSubscriptionBenefit.getName(), emoji, guildRoleSubscriptionBenefit.getDescription()));
                    }
                }
            }
            GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(guildRoleSubscriptionTierListing.getRoleId())) : null;
            ViewState viewStateRequireViewState = requireViewState();
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                viewStateRequireViewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
            boolean zIsSubmitting = loaded != null ? loaded.isSubmitting() : false;
            boolean hasChanges = loaded != null ? loaded.getHasChanges() : false;
            if (hasChanges) {
                updateViewState(new ViewState.Loaded(hasChanges, guildRoleSubscriptionTierListing.getPublished(), null, false, 12, null));
                return;
            }
            Integer numValueOf = ((guildRole != null ? Integer.valueOf(guildRole.getColor()) : null) == null || guildRole.getColor() == 0) ? null : Integer.valueOf(RoleUtils.getOpaqueColor(guildRole));
            boolean zCanRole = PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole, null);
            SubscriptionTrial activeTrial = guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.getActiveTrial() : null;
            SubscriptionTrialInterval subscriptionTrialInterval = activeTrial != null ? new SubscriptionTrialInterval(activeTrial.getInterval(), activeTrial.getIntervalCount()) : null;
            String name = guildRoleSubscriptionTierListing.getName();
            Long lValueOf = Long.valueOf(guildRoleSubscriptionTierListing.getApplicationId());
            String description = guildRoleSubscriptionTierListing.getDescription();
            ImageAsset imageAsset = guildRoleSubscriptionTierListing.getImageAsset();
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = new GuildRoleSubscriptionTier(name, lValueOf, Integer.valueOf(GuildRoleSubscriptionUtils2.getPrice(guildRoleSubscriptionTierListing)), numValueOf, null, guildRole, null, imageAsset != null ? Long.valueOf(imageAsset.getId()) : null, description, Boolean.valueOf(guildRoleSubscriptionTierListing.getPublished()), Boolean.valueOf(zCanRole), arrayList, arrayList2, subscriptionTrialInterval, guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.getMaxNumActiveTrialUsers() : null, 80, null);
            Boolean fullServerGatingOverwrite = GuildRoleSubscriptionUtils2.getFullServerGatingOverwrite(storeState.getGuildRoleSubscriptionGroupListing(), guildRoles);
            boolean zBooleanValue = fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : storeState.getGuildRoleSubscriptionGroupListing().getFullServerGate();
            this.isFullServerGating = Boolean.valueOf(zBooleanValue);
            this.storedGuildRoleSubscriptionTier = guildRoleSubscriptionTier;
            this.eventSubject.k.onNext(new Event.StoredStateUpdate(guildRoleSubscriptionTier, zBooleanValue));
            updateViewState(new ViewState.Loaded(false, guildRoleSubscriptionTierListing.getPublished(), guildRoleSubscriptionTierListing.getName(), zIsSubmitting, 1, null));
        }
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState = storeState.getGuildRoleSubscriptionStoreData().getGuildRoleSubscriptionGroupListingState();
        if (guildRoleSubscriptionGroupListingState != null) {
            if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loading) {
                updateViewState(ViewState.Loading.INSTANCE);
            } else if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) {
                handleLoadedStoreState((StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionGroupListingState, storeState.getGuildRoleSubscriptionStoreData().getGuildRoleSubscriptionFreeTrial(), storeState.getChannels(), storeState.getGuildEmojis(), storeState.getGuildRoleSubscriptionStoreData().getGuildRoles());
            } else if (guildRoleSubscriptionGroupListingState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Failed) {
                updateViewState(ViewState.Failed.INSTANCE);
            }
        }
    }

    public final void deleteTier() {
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, true, 7, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.deleteGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.guildRoleSubscriptionGroupListingId, this.guildRoleSubscriptionTierListingId), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(loaded), (Function0) null, (Function0) null, new AnonymousClass1(loaded), 54, (Object) null);
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        boolean z2;
        boolean z3;
        String name;
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            String name2 = guildRoleSubscriptionTier.getName();
            if (!Intrinsics3.areEqual(name2, this.storedGuildRoleSubscriptionTier != null ? r1.getName() : null)) {
                String name3 = guildRoleSubscriptionTier.getName();
                if (!(name3 == null || StringsJVM.isBlank(name3))) {
                    this.editedTierName = guildRoleSubscriptionTier.getName();
                    z2 = true;
                }
            } else {
                this.editedTierName = null;
                z2 = false;
            }
            String description = guildRoleSubscriptionTier.getDescription();
            if (!Intrinsics3.areEqual(description, this.storedGuildRoleSubscriptionTier != null ? r6.getDescription() : null)) {
                String description2 = guildRoleSubscriptionTier.getDescription();
                if (!(description2 == null || StringsJVM.isBlank(description2))) {
                    this.editedTierDescription = guildRoleSubscriptionTier.getDescription();
                    z2 = true;
                }
            } else {
                this.editedTierDescription = null;
            }
            if (guildRoleSubscriptionTier.getImage() != null) {
                this.editedTierImage = guildRoleSubscriptionTier.getImage();
                z2 = true;
            } else {
                this.editedTierImage = null;
            }
            Integer priceTier = guildRoleSubscriptionTier.getPriceTier();
            if (!Intrinsics3.areEqual(priceTier, this.storedGuildRoleSubscriptionTier != null ? r5.getPriceTier() : null)) {
                this.editedTierPrice = guildRoleSubscriptionTier.getPriceTier();
                z2 = true;
            } else {
                this.editedTierPrice = null;
            }
            Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
            if (!Intrinsics3.areEqual(memberColor, this.storedGuildRoleSubscriptionTier != null ? r5.getMemberColor() : null)) {
                this.editedMemberColor = guildRoleSubscriptionTier.getMemberColor();
                z2 = true;
            } else {
                this.editedMemberColor = null;
            }
            if (guildRoleSubscriptionTier.getMemberIcon() != null) {
                this.editedMemberIcon = guildRoleSubscriptionTier.getMemberIcon();
                z2 = true;
            } else {
                this.editedMemberIcon = null;
            }
            List<Benefit.ChannelBenefit> channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
            if (!Intrinsics3.areEqual(channelBenefits, this.storedGuildRoleSubscriptionTier != null ? r5.getChannelBenefits() : null)) {
                this.editedChannelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
                z2 = true;
            } else {
                this.editedChannelBenefits = null;
            }
            List<Benefit.IntangibleBenefit> intangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
            if (!Intrinsics3.areEqual(intangibleBenefits, this.storedGuildRoleSubscriptionTier != null ? r5.getIntangibleBenefits() : null)) {
                this.editedIntangibleBenefits = guildRoleSubscriptionTier.getIntangibleBenefits();
                z2 = true;
            } else {
                this.editedIntangibleBenefits = null;
            }
            boolean zCanAccessAllChannelsOrDefault = guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating);
            GuildRoleSubscriptionTier guildRoleSubscriptionTier2 = this.storedGuildRoleSubscriptionTier;
            if (guildRoleSubscriptionTier2 == null || zCanAccessAllChannelsOrDefault != guildRoleSubscriptionTier2.canAccessAllChannelsOrDefault(this.isFullServerGating)) {
                this.editedCanAccessAllChannelsFlag = Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating));
                z2 = true;
            } else {
                this.editedCanAccessAllChannelsFlag = null;
            }
            SubscriptionTrialInterval trialInterval = guildRoleSubscriptionTier.getTrialInterval();
            if (!Intrinsics3.areEqual(trialInterval, this.storedGuildRoleSubscriptionTier != null ? r5.getTrialInterval() : null)) {
                this.editedTrialInterval = guildRoleSubscriptionTier.getTrialInterval() == null ? new NullSerializable.a<>(null, 1) : new NullSerializable.b<>(guildRoleSubscriptionTier.getTrialInterval());
                z2 = true;
            } else {
                this.editedTrialInterval = null;
            }
            Integer activeTrialUserLimit = guildRoleSubscriptionTier.getActiveTrialUserLimit();
            if (!Intrinsics3.areEqual(activeTrialUserLimit, this.storedGuildRoleSubscriptionTier != null ? r5.getActiveTrialUserLimit() : null)) {
                this.editedActiveTrialUserLimit = guildRoleSubscriptionTier.getActiveTrialUserLimit() == null ? new NullSerializable.a<>(null, 1) : new NullSerializable.b(guildRoleSubscriptionTier.getActiveTrialUserLimit());
                z3 = true;
            } else {
                this.editedActiveTrialUserLimit = null;
                z3 = z2;
            }
            String str = this.editedTierName;
            if (str != null) {
                name = str;
            } else {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier3 = this.storedGuildRoleSubscriptionTier;
                name = guildRoleSubscriptionTier3 != null ? guildRoleSubscriptionTier3.getName() : null;
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, z3, false, name, false, 10, null));
        }
    }

    public final void publishTier() {
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, true, 7, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils.INSTANCE, this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.guildRoleSubscriptionGroupListingId, this.guildRoleSubscriptionTierListingId, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, null, 114656, null), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(loaded), (Function0) null, (Function0) null, new AnonymousClass1(loaded), 54, (Object) null);
        }
    }

    public final void submitChanges() {
        Integer numValueOf;
        List<Benefit.ChannelBenefit> list;
        List<Benefit.IntangibleBenefit> list2;
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            Integer num = this.editedMemberColor;
            if (num != null) {
                numValueOf = Integer.valueOf(ColorCompat.INSTANCE.removeAlphaComponent(num.intValue()));
            } else {
                numValueOf = null;
            }
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.restApi;
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.storeGuildRoleSubscriptions;
            long j = this.guildId;
            long j2 = this.guildRoleSubscriptionGroupListingId;
            long j3 = this.guildRoleSubscriptionTierListingId;
            String str = this.editedTierName;
            String str2 = this.editedTierDescription;
            String str3 = this.editedTierImage;
            Integer num2 = this.editedTierPrice;
            String str4 = this.editedMemberIcon;
            Boolean bool = this.editedCanAccessAllChannelsFlag;
            List<Benefit.ChannelBenefit> channelBenefits = this.editedChannelBenefits;
            if (channelBenefits == null) {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.storedGuildRoleSubscriptionTier;
                if (guildRoleSubscriptionTier != null) {
                    channelBenefits = guildRoleSubscriptionTier.getChannelBenefits();
                    list = channelBenefits;
                } else {
                    list = null;
                }
            } else {
                list = channelBenefits;
            }
            List<Benefit.IntangibleBenefit> intangibleBenefits = this.editedIntangibleBenefits;
            if (intangibleBenefits == null) {
                GuildRoleSubscriptionTier guildRoleSubscriptionTier2 = this.storedGuildRoleSubscriptionTier;
                if (guildRoleSubscriptionTier2 != null) {
                    intangibleBenefits = guildRoleSubscriptionTier2.getIntangibleBenefits();
                    list2 = intangibleBenefits;
                } else {
                    list2 = null;
                }
            } else {
                list2 = intangibleBenefits;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing$default(guildRoleSubscriptionUtils, restAPI, storeGuildRoleSubscriptions, j, j2, j3, str, str2, str3, num2, numValueOf, str4, bool, list, list2, null, this.editedTrialInterval, this.editedActiveTrialUserLimit, 16384, null), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(loaded), (Function0) null, (Function0) null, new AnonymousClass2(loaded), 54, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel(long j, long j2, long j3, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreChannels storeChannels, StoreEmoji storeEmoji, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.guildRoleSubscriptionTierListingId = j2;
        this.guildRoleSubscriptionGroupListingId = j3;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), ServerSettingsGuildRoleSubscriptionEditTierViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

package com.discord.widgets.guilds.profile;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGuildProfileSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\t]^_\\`abcdB]\u0012\b\b\u0002\u0010J\u001a\u00020I\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\u0006\u0010C\u001a\u00020\u0016\u0012\b\b\u0002\u0010N\u001a\u00020M\u0012\b\b\u0002\u0010G\u001a\u00020F\u0012\b\b\u0002\u0010X\u001a\u00020W\u0012\n\u0010%\u001a\u00060\u0013j\u0002`\u0014\u0012\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00030!¢\u0006\u0004\bZ\u0010[J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007Js\u0010\u001c\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00122\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b&\u0010'J/\u0010,\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010)\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050*¢\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050*¢\u0006\u0004\b.\u0010/J'\u00100\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050*¢\u0006\u0004\b0\u0010/J+\u00104\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u0001012\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\u0006\u00103\u001a\u00020\u0016¢\u0006\u0004\b4\u00105J!\u00107\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\u0006\u00106\u001a\u00020\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0005¢\u0006\u0004\b9\u0010:J!\u0010=\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J)\u0010A\u001a\u00020\u00052\n\u0010%\u001a\u00060\u0013j\u0002`\u00142\u000e\u0010@\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`?¢\u0006\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010DR\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010%\u001a\u00060\u0013j\u0002`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR:\u0010U\u001a&\u0012\f\u0012\n T*\u0004\u0018\u00010\"0\" T*\u0012\u0012\f\u0012\n T*\u0004\u0018\u00010\"0\"\u0018\u00010S0S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006e"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;)V", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guild/preview/GuildPreview;", "guildPreview", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "guildChannelsInfo", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/models/member/GuildMember;", "computedMe", "", "", "Lcom/discord/primitives/GuildId;", "restrictedGuildIds", "", "isDeveloper", "Lcom/discord/models/domain/emoji/Emoji;", "emojis", "isLurking", "isUnread", "handleLoadedGuild", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/guild/preview/GuildPreview;Lcom/discord/utilities/channel/GuildChannelsInfo;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Ljava/util/List;ZLjava/util/List;ZZ)V", "meUser", "handleLoadedGuildPreview", "(Lcom/discord/api/guild/preview/GuildPreview;Lcom/discord/models/user/MeUser;)V", "Lrx/Observable;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "guildId", "onClickMarkAsRead", "(J)V", "", ModelAuditLogEntry.CHANGE_KEY_NICK, "Lkotlin/Function0;", "onSuccess", "onClickSaveNickname", "(JLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onClickResetNickname", "(JLkotlin/jvm/functions/Function0;)V", "onClickLeaveServer", "Lcom/discord/app/AppActivity;", "appActivity", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, "setAllowDM", "(Lcom/discord/app/AppActivity;JZ)V", "hide", "setHideMutedChannels", "(JZ)V", "onClickEmoji", "()V", "Landroidx/fragment/app/Fragment;", "fragment", "onClickJoinServer", "(JLandroidx/fragment/app/Fragment;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "onClickViewServer", "(JLjava/lang/Long;)V", "viewingGuild", "Z", "isEmojiSectionExpanded", "Lcom/discord/stores/StoreLurking;", "storeLurking", "Lcom/discord/stores/StoreLurking;", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUserSettings;", "J", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreUserGuildSettings;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "storeObservable", "<init>", "(Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreUserGuildSettings;ZLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreLurking;Lcom/discord/stores/StoreAnalytics;JLrx/Observable;)V", "Companion", "Actions", "Banner", "BottomActions", "EmojisData", "Event", "StoreState", "TabItems", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private boolean isEmojiSectionExpanded;
    private final RestAPI restAPI;
    private final StoreLurking storeLurking;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserSettings storeUserSettings;
    private final boolean viewingGuild;

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetGuildProfileSheetViewModel.access$handleStoreState(WidgetGuildProfileSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0082\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\nJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b-\u0010\nR\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010.\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b0\u0010\n¨\u00063"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;", "", "", "component1", "()Z", "component2", "component3", "component4", "", "component5", "()Ljava/lang/String;", "component6", "component7", "component8", "component9", "component10", "component11", "isUnread", "canManageChannels", "canManageEvents", "canChangeNickname", ModelAuditLogEntry.CHANGE_KEY_NICK, "guildAvatar", "isAllowDMChecked", "hideMutedChannels", "canLeaveGuild", "isDeveloper", "username", "copy", "(ZZZZLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanManageEvents", "getCanLeaveGuild", "Ljava/lang/String;", "getGuildAvatar", "getHideMutedChannels", "getCanManageChannels", "getCanChangeNickname", "getUsername", "displayGuildIdentityRow", "getDisplayGuildIdentityRow", "getNick", "<init>", "(ZZZZLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Actions {
        private final boolean canChangeNickname;
        private final boolean canLeaveGuild;
        private final boolean canManageChannels;
        private final boolean canManageEvents;
        private final boolean displayGuildIdentityRow;
        private final String guildAvatar;
        private final boolean hideMutedChannels;
        private final boolean isAllowDMChecked;
        private final boolean isDeveloper;
        private final boolean isUnread;
        private final String nick;
        private final String username;

        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Actions(boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3) {
            Intrinsics3.checkNotNullParameter(str3, "username");
            this.isUnread = z2;
            this.canManageChannels = z3;
            this.canManageEvents = z4;
            this.canChangeNickname = z5;
            this.nick = str;
            this.guildAvatar = str2;
            this.isAllowDMChecked = z6;
            this.hideMutedChannels = z7;
            this.canLeaveGuild = z8;
            this.isDeveloper = z9;
            this.username = str3;
            boolean z10 = false;
            if (str == null || str.length() == 0) {
                if (!(str2 == null || str2.length() == 0)) {
                }
            } else {
                z10 = true;
            }
            this.displayGuildIdentityRow = z10;
        }

        public static /* synthetic */ Actions copy$default(Actions actions, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3, int i, Object obj) {
            return actions.copy((i & 1) != 0 ? actions.isUnread : z2, (i & 2) != 0 ? actions.canManageChannels : z3, (i & 4) != 0 ? actions.canManageEvents : z4, (i & 8) != 0 ? actions.canChangeNickname : z5, (i & 16) != 0 ? actions.nick : str, (i & 32) != 0 ? actions.guildAvatar : str2, (i & 64) != 0 ? actions.isAllowDMChecked : z6, (i & 128) != 0 ? actions.hideMutedChannels : z7, (i & 256) != 0 ? actions.canLeaveGuild : z8, (i & 512) != 0 ? actions.isDeveloper : z9, (i & 1024) != 0 ? actions.username : str3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        /* renamed from: component11, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanManageChannels() {
            return this.canManageChannels;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        /* renamed from: component5, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        /* renamed from: component6, reason: from getter */
        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsAllowDMChecked() {
            return this.isAllowDMChecked;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getHideMutedChannels() {
            return this.hideMutedChannels;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanLeaveGuild() {
            return this.canLeaveGuild;
        }

        public final Actions copy(boolean isUnread, boolean canManageChannels, boolean canManageEvents, boolean canChangeNickname, String nick, String guildAvatar, boolean isAllowDMChecked, boolean hideMutedChannels, boolean canLeaveGuild, boolean isDeveloper, String username) {
            Intrinsics3.checkNotNullParameter(username, "username");
            return new Actions(isUnread, canManageChannels, canManageEvents, canChangeNickname, nick, guildAvatar, isAllowDMChecked, hideMutedChannels, canLeaveGuild, isDeveloper, username);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Actions)) {
                return false;
            }
            Actions actions = (Actions) other;
            return this.isUnread == actions.isUnread && this.canManageChannels == actions.canManageChannels && this.canManageEvents == actions.canManageEvents && this.canChangeNickname == actions.canChangeNickname && Intrinsics3.areEqual(this.nick, actions.nick) && Intrinsics3.areEqual(this.guildAvatar, actions.guildAvatar) && this.isAllowDMChecked == actions.isAllowDMChecked && this.hideMutedChannels == actions.hideMutedChannels && this.canLeaveGuild == actions.canLeaveGuild && this.isDeveloper == actions.isDeveloper && Intrinsics3.areEqual(this.username, actions.username);
        }

        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        public final boolean getCanLeaveGuild() {
            return this.canLeaveGuild;
        }

        public final boolean getCanManageChannels() {
            return this.canManageChannels;
        }

        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final boolean getDisplayGuildIdentityRow() {
            return this.displayGuildIdentityRow;
        }

        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        public final boolean getHideMutedChannels() {
            return this.hideMutedChannels;
        }

        public final String getNick() {
            return this.nick;
        }

        public final String getUsername() {
            return this.username;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isUnread;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.canManageChannels;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.canManageEvents;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.canChangeNickname;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            String str = this.nick;
            int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.guildAvatar;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            ?? r24 = this.isAllowDMChecked;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (iHashCode2 + i8) * 31;
            ?? r25 = this.hideMutedChannels;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            ?? r26 = this.canLeaveGuild;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            boolean z3 = this.isDeveloper;
            int i14 = (i13 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            String str3 = this.username;
            return i14 + (str3 != null ? str3.hashCode() : 0);
        }

        public final boolean isAllowDMChecked() {
            return this.isAllowDMChecked;
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Actions(isUnread=");
            sbU.append(this.isUnread);
            sbU.append(", canManageChannels=");
            sbU.append(this.canManageChannels);
            sbU.append(", canManageEvents=");
            sbU.append(this.canManageEvents);
            sbU.append(", canChangeNickname=");
            sbU.append(this.canChangeNickname);
            sbU.append(", nick=");
            sbU.append(this.nick);
            sbU.append(", guildAvatar=");
            sbU.append(this.guildAvatar);
            sbU.append(", isAllowDMChecked=");
            sbU.append(this.isAllowDMChecked);
            sbU.append(", hideMutedChannels=");
            sbU.append(this.hideMutedChannels);
            sbU.append(", canLeaveGuild=");
            sbU.append(this.canLeaveGuild);
            sbU.append(", isDeveloper=");
            sbU.append(this.isDeveloper);
            sbU.append(", username=");
            return outline.J(sbU, this.username, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001!B%\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006\""}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner$Type;", "component3", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner$Type;", "guildId", "hash", "type", "copy", "(JLjava/lang/String;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner$Type;)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHash", "J", "getGuildId", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner$Type;", "getType", "<init>", "(JLjava/lang/String;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner$Type;)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Banner {
        private final long guildId;
        private final String hash;
        private final Type type;

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner$Type;", "", "<init>", "(Ljava/lang/String;I)V", "BANNER", "SPLASH", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            BANNER,
            SPLASH
        }

        public Banner(long j, String str, Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.guildId = j;
            this.hash = str;
            this.type = type;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, long j, String str, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                j = banner.guildId;
            }
            if ((i & 2) != 0) {
                str = banner.hash;
            }
            if ((i & 4) != 0) {
                type = banner.type;
            }
            return banner.copy(j, str, type);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getHash() {
            return this.hash;
        }

        /* renamed from: component3, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final Banner copy(long guildId, String hash, Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new Banner(guildId, hash, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Banner)) {
                return false;
            }
            Banner banner = (Banner) other;
            return this.guildId == banner.guildId && Intrinsics3.areEqual(this.hash, banner.hash) && Intrinsics3.areEqual(this.type, banner.type);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getHash() {
            return this.hash;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.hash;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            Type type = this.type;
            return iHashCode + (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Banner(guildId=");
            sbU.append(this.guildId);
            sbU.append(", hash=");
            sbU.append(this.hash);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;", "", "", "component1", "()Z", "component2", "component3", "showUploadEmoji", "showJoinServer", "showViewServer", "copy", "(ZZZ)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowUploadEmoji", "getShowJoinServer", "getShowViewServer", "<init>", "(ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BottomActions {
        private final boolean showJoinServer;
        private final boolean showUploadEmoji;
        private final boolean showViewServer;

        public BottomActions(boolean z2, boolean z3, boolean z4) {
            this.showUploadEmoji = z2;
            this.showJoinServer = z3;
            this.showViewServer = z4;
        }

        public static /* synthetic */ BottomActions copy$default(BottomActions bottomActions, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = bottomActions.showUploadEmoji;
            }
            if ((i & 2) != 0) {
                z3 = bottomActions.showJoinServer;
            }
            if ((i & 4) != 0) {
                z4 = bottomActions.showViewServer;
            }
            return bottomActions.copy(z2, z3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowUploadEmoji() {
            return this.showUploadEmoji;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowJoinServer() {
            return this.showJoinServer;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowViewServer() {
            return this.showViewServer;
        }

        public final BottomActions copy(boolean showUploadEmoji, boolean showJoinServer, boolean showViewServer) {
            return new BottomActions(showUploadEmoji, showJoinServer, showViewServer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BottomActions)) {
                return false;
            }
            BottomActions bottomActions = (BottomActions) other;
            return this.showUploadEmoji == bottomActions.showUploadEmoji && this.showJoinServer == bottomActions.showJoinServer && this.showViewServer == bottomActions.showViewServer;
        }

        public final boolean getShowJoinServer() {
            return this.showJoinServer;
        }

        public final boolean getShowUploadEmoji() {
            return this.showUploadEmoji;
        }

        public final boolean getShowViewServer() {
            return this.showViewServer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.showUploadEmoji;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.showJoinServer;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.showViewServer;
            return i3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BottomActions(showUploadEmoji=");
            sbU.append(this.showUploadEmoji);
            sbU.append(", showJoinServer=");
            sbU.append(this.showJoinServer);
            sbU.append(", showViewServer=");
            return outline.O(sbU, this.showViewServer, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", "observeStores", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableC = Observable.c(companion.getGuilds().observeGuild(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), companion.getReadStates().getIsUnread(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Y(new WidgetGuildProfileSheetViewModel2(guildId)), companion.getUserSettings().observeRestrictedGuildIds(), companion.getEmojis().getEmojiSet(new StoreEmoji.EmojiContext.GuildProfile(guildId), true, false).G(new WidgetGuildProfileSheetViewModel3(guildId)), companion.getLurking().isLurkingObs(guildId), GuildChannelsInfo.INSTANCE.get(guildId), WidgetGuildProfileSheetViewModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…ead\n          )\n        }");
            return observableC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u000b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\n\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;", "", "", "component1", "()Z", "component2", "", "Lcom/discord/models/domain/emoji/Emoji;", "component3", "()Ljava/util/List;", "isPremium", "isExpanded", "emojis", "copy", "(ZZLjava/util/List;)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getEmojis", "Z", "<init>", "(ZZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class EmojisData {
        private final List<Emoji> emojis;
        private final boolean isExpanded;
        private final boolean isPremium;

        /* JADX WARN: Multi-variable type inference failed */
        public EmojisData(boolean z2, boolean z3, List<? extends Emoji> list) {
            Intrinsics3.checkNotNullParameter(list, "emojis");
            this.isPremium = z2;
            this.isExpanded = z3;
            this.emojis = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmojisData copy$default(EmojisData emojisData, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = emojisData.isPremium;
            }
            if ((i & 2) != 0) {
                z3 = emojisData.isExpanded;
            }
            if ((i & 4) != 0) {
                list = emojisData.emojis;
            }
            return emojisData.copy(z2, z3, list);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsPremium() {
            return this.isPremium;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsExpanded() {
            return this.isExpanded;
        }

        public final List<Emoji> component3() {
            return this.emojis;
        }

        public final EmojisData copy(boolean isPremium, boolean isExpanded, List<? extends Emoji> emojis) {
            Intrinsics3.checkNotNullParameter(emojis, "emojis");
            return new EmojisData(isPremium, isExpanded, emojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojisData)) {
                return false;
            }
            EmojisData emojisData = (EmojisData) other;
            return this.isPremium == emojisData.isPremium && this.isExpanded == emojisData.isExpanded && Intrinsics3.areEqual(this.emojis, emojisData.emojis);
        }

        public final List<Emoji> getEmojis() {
            return this.emojis;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isPremium;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isExpanded;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<Emoji> list = this.emojis;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public final boolean isPremium() {
            return this.isPremium;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmojisData(isPremium=");
            sbU.append(this.isPremium);
            sbU.append(", isExpanded=");
            sbU.append(this.isExpanded);
            sbU.append(", emojis=");
            return outline.L(sbU, this.emojis, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event;", "", "<init>", "()V", "DismissAndShowToast", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event;", "", "component1", "()I", "stringRes", "copy", "(I)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class DismissAndShowToast extends Event {
            private final int stringRes;

            public DismissAndShowToast(@StringRes int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ DismissAndShowToast copy$default(DismissAndShowToast dismissAndShowToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = dismissAndShowToast.stringRes;
                }
                return dismissAndShowToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final DismissAndShowToast copy(@StringRes int stringRes) {
                return new DismissAndShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DismissAndShowToast) && this.stringRes == ((DismissAndShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("DismissAndShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u0011\u0012\u0006\u0010#\u001a\u00020\u0016\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011\u0012\u0006\u0010%\u001a\u00020\u0016\u0012\u0006\u0010&\u001a\u00020\u0016¢\u0006\u0004\b@\u0010AJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0015J\u0010\u0010\u001b\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u008a\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\u0012\b\u0002\u0010\"\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u00112\b\b\u0002\u0010#\u001a\u00020\u00162\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u00112\b\b\u0002\u0010%\u001a\u00020\u00162\b\b\u0002\u0010&\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u0010\u0004R\u001b\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b5\u0010\u0010R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u0007R\u0019\u0010%\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b%\u00108\u001a\u0004\b%\u0010\u0018R\u0019\u0010#\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\b#\u0010\u0018R#\u0010\"\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010\u0015R\u0019\u0010\u001f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010\nR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118\u0006@\u0006¢\u0006\f\n\u0004\b$\u00109\u001a\u0004\b=\u0010\u0015R\u0019\u0010&\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\b&\u0010\u0018R\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010\r¨\u0006B"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "component2", "()Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "component3", "()Lcom/discord/utilities/channel/GuildChannelsInfo;", "Lcom/discord/models/user/MeUser;", "component4", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/member/GuildMember;", "component5", "()Lcom/discord/models/member/GuildMember;", "", "", "Lcom/discord/primitives/GuildId;", "component6", "()Ljava/util/List;", "", "component7", "()Z", "Lcom/discord/models/domain/emoji/Emoji;", "component8", "component9", "component10", "guild", "guildProfile", "guildChannelsInfo", "me", "computedMe", "restrictedGuildIds", "isDeveloper", "emojis", "isLurking", "isUnread", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;Lcom/discord/utilities/channel/GuildChannelsInfo;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Ljava/util/List;ZLjava/util/List;ZZ)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/models/member/GuildMember;", "getComputedMe", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "getGuildProfile", "Z", "Ljava/util/List;", "getRestrictedGuildIds", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "getGuildChannelsInfo", "getEmojis", "Lcom/discord/models/user/MeUser;", "getMe", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;Lcom/discord/utilities/channel/GuildChannelsInfo;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Ljava/util/List;ZLjava/util/List;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final GuildMember computedMe;
        private final List<Emoji> emojis;
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final StoreGuildProfiles.GuildProfileData guildProfile;
        private final boolean isDeveloper;
        private final boolean isLurking;
        private final boolean isUnread;
        private final MeUser me;
        private final List<Long> restrictedGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List<Long> list, boolean z2, List<? extends Emoji> list2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(list, "restrictedGuildIds");
            Intrinsics3.checkNotNullParameter(list2, "emojis");
            this.guild = guild;
            this.guildProfile = guildProfileData;
            this.guildChannelsInfo = guildChannelsInfo;
            this.me = meUser;
            this.computedMe = guildMember;
            this.restrictedGuildIds = list;
            this.isDeveloper = z2;
            this.emojis = list2;
            this.isLurking = z3;
            this.isUnread = z4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List list, boolean z2, List list2, boolean z3, boolean z4, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.guild : guild, (i & 2) != 0 ? storeState.guildProfile : guildProfileData, (i & 4) != 0 ? storeState.guildChannelsInfo : guildChannelsInfo, (i & 8) != 0 ? storeState.me : meUser, (i & 16) != 0 ? storeState.computedMe : guildMember, (i & 32) != 0 ? storeState.restrictedGuildIds : list, (i & 64) != 0 ? storeState.isDeveloper : z2, (i & 128) != 0 ? storeState.emojis : list2, (i & 256) != 0 ? storeState.isLurking : z3, (i & 512) != 0 ? storeState.isUnread : z4);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        /* renamed from: component4, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildMember getComputedMe() {
            return this.computedMe;
        }

        public final List<Long> component6() {
            return this.restrictedGuildIds;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final List<Emoji> component8() {
            return this.emojis;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsLurking() {
            return this.isLurking;
        }

        public final StoreState copy(Guild guild, StoreGuildProfiles.GuildProfileData guildProfile, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(restrictedGuildIds, "restrictedGuildIds");
            Intrinsics3.checkNotNullParameter(emojis, "emojis");
            return new StoreState(guild, guildProfile, guildChannelsInfo, me2, computedMe, restrictedGuildIds, isDeveloper, emojis, isLurking, isUnread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.guildProfile, storeState.guildProfile) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo) && Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.computedMe, storeState.computedMe) && Intrinsics3.areEqual(this.restrictedGuildIds, storeState.restrictedGuildIds) && this.isDeveloper == storeState.isDeveloper && Intrinsics3.areEqual(this.emojis, storeState.emojis) && this.isLurking == storeState.isLurking && this.isUnread == storeState.isUnread;
        }

        public final GuildMember getComputedMe() {
            return this.computedMe;
        }

        public final List<Emoji> getEmojis() {
            return this.emojis;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final List<Long> getRestrictedGuildIds() {
            return this.restrictedGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildProfiles.GuildProfileData guildProfileData = this.guildProfile;
            int iHashCode2 = (iHashCode + (guildProfileData != null ? guildProfileData.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            int iHashCode3 = (iHashCode2 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            GuildMember guildMember = this.computedMe;
            int iHashCode5 = (iHashCode4 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            List<Long> list = this.restrictedGuildIds;
            int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isDeveloper;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode6 + i) * 31;
            List<Emoji> list2 = this.emojis;
            int iHashCode7 = (i2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z3 = this.isLurking;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode7 + i3) * 31;
            boolean z4 = this.isUnread;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isLurking() {
            return this.isLurking;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", guildProfile=");
            sbU.append(this.guildProfile);
            sbU.append(", guildChannelsInfo=");
            sbU.append(this.guildChannelsInfo);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", computedMe=");
            sbU.append(this.computedMe);
            sbU.append(", restrictedGuildIds=");
            sbU.append(this.restrictedGuildIds);
            sbU.append(", isDeveloper=");
            sbU.append(this.isDeveloper);
            sbU.append(", emojis=");
            sbU.append(this.emojis);
            sbU.append(", isLurking=");
            sbU.append(this.isLurking);
            sbU.append(", isUnread=");
            return outline.O(sbU, this.isUnread, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;", "", "", "component1", "()Z", "component2", "", "component3", "()I", "canAccessSettings", "ableToInstantInvite", "premiumSubscriptionCount", "copy", "(ZZI)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAbleToInstantInvite", "getCanAccessSettings", "I", "getPremiumSubscriptionCount", "<init>", "(ZZI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class TabItems {
        private final boolean ableToInstantInvite;
        private final boolean canAccessSettings;
        private final int premiumSubscriptionCount;

        public TabItems(boolean z2, boolean z3, int i) {
            this.canAccessSettings = z2;
            this.ableToInstantInvite = z3;
            this.premiumSubscriptionCount = i;
        }

        public static /* synthetic */ TabItems copy$default(TabItems tabItems, boolean z2, boolean z3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = tabItems.canAccessSettings;
            }
            if ((i2 & 2) != 0) {
                z3 = tabItems.ableToInstantInvite;
            }
            if ((i2 & 4) != 0) {
                i = tabItems.premiumSubscriptionCount;
            }
            return tabItems.copy(z2, z3, i);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCanAccessSettings() {
            return this.canAccessSettings;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAbleToInstantInvite() {
            return this.ableToInstantInvite;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPremiumSubscriptionCount() {
            return this.premiumSubscriptionCount;
        }

        public final TabItems copy(boolean canAccessSettings, boolean ableToInstantInvite, int premiumSubscriptionCount) {
            return new TabItems(canAccessSettings, ableToInstantInvite, premiumSubscriptionCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TabItems)) {
                return false;
            }
            TabItems tabItems = (TabItems) other;
            return this.canAccessSettings == tabItems.canAccessSettings && this.ableToInstantInvite == tabItems.ableToInstantInvite && this.premiumSubscriptionCount == tabItems.premiumSubscriptionCount;
        }

        public final boolean getAbleToInstantInvite() {
            return this.ableToInstantInvite;
        }

        public final boolean getCanAccessSettings() {
            return this.canAccessSettings;
        }

        public final int getPremiumSubscriptionCount() {
            return this.premiumSubscriptionCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.canAccessSettings;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.ableToInstantInvite;
            return ((i + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.premiumSubscriptionCount;
        }

        public String toString() {
            StringBuilder sbU = outline.U("TabItems(canAccessSettings=");
            sbU.append(this.canAccessSettings);
            sbU.append(", ableToInstantInvite=");
            sbU.append(this.ableToInstantInvite);
            sbU.append(", premiumSubscriptionCount=");
            return outline.B(sbU, this.premiumSubscriptionCount, ")");
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Loading", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\u0010&\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020\u0006\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010+\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\b\u0010-\u001a\u0004\u0018\u00010\f\u0012\b\u0010.\u001a\u0004\u0018\u00010\f\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0014\u0012\b\u00100\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u00101\u001a\u00020\u001a\u0012\u0006\u00102\u001a\u00020\u001d\u0012\u0006\u00103\u001a\u00020 \u0012\u0006\u00104\u001a\u00020#¢\u0006\u0004\bV\u0010WJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÆ\u0003¢\u0006\u0004\b$\u0010%J¸\u0001\u00105\u001a\u00020\u00002\f\b\u0002\u0010&\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010,\u001a\u00020\u000f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u00101\u001a\u00020\u001a2\b\b\u0002\u00102\u001a\u00020\u001d2\b\b\u0002\u00103\u001a\u00020 2\b\b\u0002\u00104\u001a\u00020#HÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b7\u0010\bJ\u0010\u00108\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b8\u00109J\u001a\u0010<\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010:HÖ\u0003¢\u0006\u0004\b<\u0010=R\u0019\u0010(\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010>\u001a\u0004\b?\u0010\bR\u001b\u0010*\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010>\u001a\u0004\b@\u0010\bR\u001b\u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010A\u001a\u0004\bB\u0010\u000eR\u001b\u0010)\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010>\u001a\u0004\bC\u0010\bR\u001b\u0010/\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010D\u001a\u0004\bE\u0010\u0016R\u0019\u00101\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010F\u001a\u0004\bG\u0010\u001cR\u0019\u00103\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010H\u001a\u0004\b3\u0010\"R\u001d\u0010&\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010I\u001a\u0004\bJ\u0010\u0005R\u001b\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010A\u001a\u0004\bK\u0010\u000eR\u001b\u0010.\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010A\u001a\u0004\bL\u0010\u000eR\u0019\u00104\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010M\u001a\u0004\bN\u0010%R\u0019\u0010,\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010O\u001a\u0004\bP\u0010\u0011R\u0019\u00102\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010Q\u001a\u0004\bR\u0010\u001fR\u001b\u00100\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010S\u001a\u0004\bT\u0010\u0019R\u0019\u0010'\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010>\u001a\u0004\bU\u0010\b¨\u0006X"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Integer;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;", "component7", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;", "component8", "component9", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;", "component10", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;", "component11", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;", "component12", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;", "component13", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;", "", "component14", "()Z", "Lcom/discord/models/user/MeUser;", "component15", "()Lcom/discord/models/user/MeUser;", "guildId", "guildName", "guildShortName", "guildIcon", "guildDescription", "verifiedPartneredIconRes", "banner", "onlineCount", "memberCount", "tabItems", "actions", "emojisData", "bottomActions", "isGuildHub", "meUser", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;ZLcom/discord/models/user/MeUser;)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Loaded;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildShortName", "getGuildDescription", "Ljava/lang/Integer;", "getOnlineCount", "getGuildIcon", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;", "getTabItems", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;", "getEmojisData", "Z", "J", "getGuildId", "getVerifiedPartneredIconRes", "getMemberCount", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;", "getBanner", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;", "getBottomActions", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;", "getActions", "getGuildName", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Banner;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$TabItems;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$Actions;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$EmojisData;Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$BottomActions;ZLcom/discord/models/user/MeUser;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Actions actions;
            private final Banner banner;
            private final BottomActions bottomActions;
            private final EmojisData emojisData;
            private final String guildDescription;
            private final String guildIcon;
            private final long guildId;
            private final String guildName;
            private final String guildShortName;
            private final boolean isGuildHub;
            private final MeUser meUser;
            private final Integer memberCount;
            private final Integer onlineCount;
            private final TabItems tabItems;
            private final Integer verifiedPartneredIconRes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, String str, String str2, String str3, String str4, Integer num, Banner banner, Integer num2, Integer num3, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean z2, MeUser meUser) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "guildName");
                Intrinsics3.checkNotNullParameter(str2, "guildShortName");
                Intrinsics3.checkNotNullParameter(banner, "banner");
                Intrinsics3.checkNotNullParameter(emojisData, "emojisData");
                Intrinsics3.checkNotNullParameter(bottomActions, "bottomActions");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                this.guildId = j;
                this.guildName = str;
                this.guildShortName = str2;
                this.guildIcon = str3;
                this.guildDescription = str4;
                this.verifiedPartneredIconRes = num;
                this.banner = banner;
                this.onlineCount = num2;
                this.memberCount = num3;
                this.tabItems = tabItems;
                this.actions = actions;
                this.emojisData = emojisData;
                this.bottomActions = bottomActions;
                this.isGuildHub = z2;
                this.meUser = meUser;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, long j, String str, String str2, String str3, String str4, Integer num, Banner banner, Integer num2, Integer num3, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean z2, MeUser meUser, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.guildId : j, (i & 2) != 0 ? loaded.guildName : str, (i & 4) != 0 ? loaded.guildShortName : str2, (i & 8) != 0 ? loaded.guildIcon : str3, (i & 16) != 0 ? loaded.guildDescription : str4, (i & 32) != 0 ? loaded.verifiedPartneredIconRes : num, (i & 64) != 0 ? loaded.banner : banner, (i & 128) != 0 ? loaded.onlineCount : num2, (i & 256) != 0 ? loaded.memberCount : num3, (i & 512) != 0 ? loaded.tabItems : tabItems, (i & 1024) != 0 ? loaded.actions : actions, (i & 2048) != 0 ? loaded.emojisData : emojisData, (i & 4096) != 0 ? loaded.bottomActions : bottomActions, (i & 8192) != 0 ? loaded.isGuildHub : z2, (i & 16384) != 0 ? loaded.meUser : meUser);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component10, reason: from getter */
            public final TabItems getTabItems() {
                return this.tabItems;
            }

            /* renamed from: component11, reason: from getter */
            public final Actions getActions() {
                return this.actions;
            }

            /* renamed from: component12, reason: from getter */
            public final EmojisData getEmojisData() {
                return this.emojisData;
            }

            /* renamed from: component13, reason: from getter */
            public final BottomActions getBottomActions() {
                return this.bottomActions;
            }

            /* renamed from: component14, reason: from getter */
            public final boolean getIsGuildHub() {
                return this.isGuildHub;
            }

            /* renamed from: component15, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getGuildShortName() {
                return this.guildShortName;
            }

            /* renamed from: component4, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* renamed from: component5, reason: from getter */
            public final String getGuildDescription() {
                return this.guildDescription;
            }

            /* renamed from: component6, reason: from getter */
            public final Integer getVerifiedPartneredIconRes() {
                return this.verifiedPartneredIconRes;
            }

            /* renamed from: component7, reason: from getter */
            public final Banner getBanner() {
                return this.banner;
            }

            /* renamed from: component8, reason: from getter */
            public final Integer getOnlineCount() {
                return this.onlineCount;
            }

            /* renamed from: component9, reason: from getter */
            public final Integer getMemberCount() {
                return this.memberCount;
            }

            public final Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, Integer verifiedPartneredIconRes, Banner banner, Integer onlineCount, Integer memberCount, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean isGuildHub, MeUser meUser) {
                Intrinsics3.checkNotNullParameter(guildName, "guildName");
                Intrinsics3.checkNotNullParameter(guildShortName, "guildShortName");
                Intrinsics3.checkNotNullParameter(banner, "banner");
                Intrinsics3.checkNotNullParameter(emojisData, "emojisData");
                Intrinsics3.checkNotNullParameter(bottomActions, "bottomActions");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                return new Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, verifiedPartneredIconRes, banner, onlineCount, memberCount, tabItems, actions, emojisData, bottomActions, isGuildHub, meUser);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.guildId == loaded.guildId && Intrinsics3.areEqual(this.guildName, loaded.guildName) && Intrinsics3.areEqual(this.guildShortName, loaded.guildShortName) && Intrinsics3.areEqual(this.guildIcon, loaded.guildIcon) && Intrinsics3.areEqual(this.guildDescription, loaded.guildDescription) && Intrinsics3.areEqual(this.verifiedPartneredIconRes, loaded.verifiedPartneredIconRes) && Intrinsics3.areEqual(this.banner, loaded.banner) && Intrinsics3.areEqual(this.onlineCount, loaded.onlineCount) && Intrinsics3.areEqual(this.memberCount, loaded.memberCount) && Intrinsics3.areEqual(this.tabItems, loaded.tabItems) && Intrinsics3.areEqual(this.actions, loaded.actions) && Intrinsics3.areEqual(this.emojisData, loaded.emojisData) && Intrinsics3.areEqual(this.bottomActions, loaded.bottomActions) && this.isGuildHub == loaded.isGuildHub && Intrinsics3.areEqual(this.meUser, loaded.meUser);
            }

            public final Actions getActions() {
                return this.actions;
            }

            public final Banner getBanner() {
                return this.banner;
            }

            public final BottomActions getBottomActions() {
                return this.bottomActions;
            }

            public final EmojisData getEmojisData() {
                return this.emojisData;
            }

            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildShortName() {
                return this.guildShortName;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Integer getMemberCount() {
                return this.memberCount;
            }

            public final Integer getOnlineCount() {
                return this.onlineCount;
            }

            public final TabItems getTabItems() {
                return this.tabItems;
            }

            public final Integer getVerifiedPartneredIconRes() {
                return this.verifiedPartneredIconRes;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = b.a(this.guildId) * 31;
                String str = this.guildName;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildShortName;
                int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.guildDescription;
                int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                Integer num = this.verifiedPartneredIconRes;
                int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
                Banner banner = this.banner;
                int iHashCode6 = (iHashCode5 + (banner != null ? banner.hashCode() : 0)) * 31;
                Integer num2 = this.onlineCount;
                int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
                Integer num3 = this.memberCount;
                int iHashCode8 = (iHashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
                TabItems tabItems = this.tabItems;
                int iHashCode9 = (iHashCode8 + (tabItems != null ? tabItems.hashCode() : 0)) * 31;
                Actions actions = this.actions;
                int iHashCode10 = (iHashCode9 + (actions != null ? actions.hashCode() : 0)) * 31;
                EmojisData emojisData = this.emojisData;
                int iHashCode11 = (iHashCode10 + (emojisData != null ? emojisData.hashCode() : 0)) * 31;
                BottomActions bottomActions = this.bottomActions;
                int iHashCode12 = (iHashCode11 + (bottomActions != null ? bottomActions.hashCode() : 0)) * 31;
                boolean z2 = this.isGuildHub;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode12 + i) * 31;
                MeUser meUser = this.meUser;
                return i2 + (meUser != null ? meUser.hashCode() : 0);
            }

            public final boolean isGuildHub() {
                return this.isGuildHub;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildShortName=");
                sbU.append(this.guildShortName);
                sbU.append(", guildIcon=");
                sbU.append(this.guildIcon);
                sbU.append(", guildDescription=");
                sbU.append(this.guildDescription);
                sbU.append(", verifiedPartneredIconRes=");
                sbU.append(this.verifiedPartneredIconRes);
                sbU.append(", banner=");
                sbU.append(this.banner);
                sbU.append(", onlineCount=");
                sbU.append(this.onlineCount);
                sbU.append(", memberCount=");
                sbU.append(this.memberCount);
                sbU.append(", tabItems=");
                sbU.append(this.tabItems);
                sbU.append(", actions=");
                sbU.append(this.actions);
                sbU.append(", emojisData=");
                sbU.append(this.emojisData);
                sbU.append(", bottomActions=");
                sbU.append(this.bottomActions);
                sbU.append(", isGuildHub=");
                sbU.append(this.isGuildHub);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetGuildProfileSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickLeaveServer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickMarkAsRead$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetGuildProfileSheetViewModel.access$getEventSubject$p(WidgetGuildProfileSheetViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.DismissAndShowToast(R.string.marked_as_read));
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickResetNickname$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickSaveNickname$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    public /* synthetic */ WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 2) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, z2, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 16) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 32) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, j, (i & 128) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel) {
        return widgetGuildProfileSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModel, StoreState storeState) {
        widgetGuildProfileSheetViewModel.handleStoreState(storeState);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleLoadedGuild(Guild guild, GuildPreview guildPreview, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
        Integer num;
        Integer numValueOf;
        Actions actions;
        List<? extends Emoji> listEmptyList;
        List<GuildEmoji> listD;
        if (guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            numValueOf = Integer.valueOf(R.drawable.ic_verified_badge);
        } else {
            if (!guild.getFeatures().contains(GuildFeature.PARTNERED)) {
                num = null;
                Banner banner = new Banner(guild.getId(), guild.getBanner(), Banner.Type.BANNER);
                PermissionsContexts manageGuildContext = guildChannelsInfo.getManageGuildContext();
                TabItems tabItems = isLurking ? new TabItems(manageGuildContext.canManage(), guildChannelsInfo.getAbleToInstantInvite(), guild.getPremiumSubscriptionCount()) : null;
                if (isLurking) {
                    actions = new Actions(isUnread, manageGuildContext.getCanManageChannels(), manageGuildContext.getCanManageEvents(), guildChannelsInfo.getCanChangeNickname(), computedMe != null ? computedMe.getNick() : null, computedMe != null ? computedMe.getAvatarHash() : null, !restrictedGuildIds.contains(Long.valueOf(guild.getId())), guildChannelsInfo.getHideMutedChannels(), !guild.isOwner(me2.getId()), isDeveloper, me2.getUsername());
                } else {
                    actions = null;
                }
                if (isLurking) {
                    listEmptyList = emojis;
                } else if (guildPreview == null || (listD = guildPreview.d()) == null) {
                    listEmptyList = null;
                } else {
                    listEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listD, 10));
                    Iterator<T> it = listD.iterator();
                    while (it.hasNext()) {
                        listEmptyList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
                    }
                }
                BottomActions bottomActions = new BottomActions(isLurking && manageGuildContext.getCanManageEmojisAndStickers(), isLurking, true ^ this.viewingGuild);
                long id2 = guild.getId();
                String name = guild.getName();
                String shortName = guild.getShortName();
                String icon = guild.getIcon();
                String description = guild.getDescription();
                Integer approximatePresenceCount = guildPreview == null ? guildPreview.getApproximatePresenceCount() : null;
                Integer approximateMemberCount = guildPreview != null ? guildPreview.getApproximateMemberCount() : null;
                TabItems tabItems2 = tabItems;
                boolean zIsPremium = UserUtils.INSTANCE.isPremium(me2);
                boolean z2 = this.isEmojiSectionExpanded;
                if (listEmptyList == null) {
                    listEmptyList = Collections2.emptyList();
                }
                updateViewState(new ViewState.Loaded(id2, name, shortName, icon, description, num, banner, approximatePresenceCount, approximateMemberCount, tabItems2, actions, new EmojisData(zIsPremium, z2, listEmptyList), bottomActions, guild.isHub(), me2));
            }
            numValueOf = Integer.valueOf(R.drawable.ic_partnered_badge);
        }
        num = numValueOf;
        Banner banner2 = new Banner(guild.getId(), guild.getBanner(), Banner.Type.BANNER);
        PermissionsContexts manageGuildContext2 = guildChannelsInfo.getManageGuildContext();
        if (isLurking) {
        }
        if (isLurking) {
        }
        if (isLurking) {
        }
        BottomActions bottomActions2 = new BottomActions(isLurking && manageGuildContext2.getCanManageEmojisAndStickers(), isLurking, true ^ this.viewingGuild);
        long id22 = guild.getId();
        String name2 = guild.getName();
        String shortName2 = guild.getShortName();
        String icon2 = guild.getIcon();
        String description2 = guild.getDescription();
        if (guildPreview == null) {
        }
        if (guildPreview != null) {
        }
        TabItems tabItems22 = tabItems;
        boolean zIsPremium2 = UserUtils.INSTANCE.isPremium(me2);
        boolean z22 = this.isEmojiSectionExpanded;
        if (listEmptyList == null) {
        }
        updateViewState(new ViewState.Loaded(id22, name2, shortName2, icon2, description2, num, banner2, approximatePresenceCount, approximateMemberCount, tabItems22, actions, new EmojisData(zIsPremium2, z22, listEmptyList), bottomActions2, guild.isHub(), me2));
    }

    private final void handleLoadedGuildPreview(GuildPreview guildPreview, MeUser meUser) {
        Integer numValueOf = guildPreview.f().contains(GuildFeature.VERIFIED) ? Integer.valueOf(R.drawable.ic_verified_badge) : guildPreview.f().contains(GuildFeature.PARTNERED) ? Integer.valueOf(R.drawable.ic_partnered_badge) : null;
        Banner banner = new Banner(guildPreview.getId(), guildPreview.getSplash(), Banner.Type.SPLASH);
        BottomActions bottomActions = new BottomActions(false, true, !this.viewingGuild);
        long id2 = guildPreview.getId();
        String name = guildPreview.getName();
        String strComputeShortName = GuildUtils.computeShortName(guildPreview.getName());
        String icon = guildPreview.getIcon();
        String description = guildPreview.getDescription();
        Integer approximatePresenceCount = guildPreview.getApproximatePresenceCount();
        Integer approximateMemberCount = guildPreview.getApproximateMemberCount();
        boolean zIsPremium = UserUtils.INSTANCE.isPremium(meUser);
        boolean z2 = this.isEmojiSectionExpanded;
        List<GuildEmoji> listD = guildPreview.d();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
            it = it;
            approximatePresenceCount = approximatePresenceCount;
            approximateMemberCount = approximateMemberCount;
        }
        updateViewState(new ViewState.Loaded(id2, name, strComputeShortName, icon, description, numValueOf, banner, approximatePresenceCount, approximateMemberCount, null, null, new EmojisData(zIsPremium, z2, arrayList), bottomActions, guildPreview.f().contains(GuildFeature.HUB), meUser));
    }

    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildProfiles.GuildProfileData guildProfile = storeState.getGuildProfile();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        MeUser me2 = storeState.getMe();
        GuildMember computedMe = storeState.getComputedMe();
        List<Long> listComponent6 = storeState.component6();
        boolean isDeveloper = storeState.getIsDeveloper();
        List<Emoji> listComponent8 = storeState.component8();
        boolean isLurking = storeState.getIsLurking();
        boolean isUnread = storeState.getIsUnread();
        if (guild != null) {
            handleLoadedGuild(guild, guildProfile != null ? guildProfile.getData() : null, guildChannelsInfo, me2, computedMe, listComponent6, isDeveloper, listComponent8, isLurking, isUnread);
            return;
        }
        StoreGuildProfiles.FetchStates fetchState = guildProfile != null ? guildProfile.getFetchState() : null;
        StoreGuildProfiles.FetchStates fetchStates = StoreGuildProfiles.FetchStates.SUCCEEDED;
        if (fetchState == fetchStates && guildProfile.getData() != null) {
            handleLoadedGuildPreview(guildProfile.getData(), me2);
            return;
        }
        if ((guildProfile != null ? guildProfile.getFetchState() : null) != StoreGuildProfiles.FetchStates.FAILED) {
            if ((guildProfile != null ? guildProfile.getFetchState() : null) != fetchStates || guildProfile.getData() != null) {
                updateViewState(ViewState.Loading.INSTANCE);
                return;
            }
        }
        updateViewState(ViewState.Invalid.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickEmoji() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || this.isEmojiSectionExpanded) {
            return;
        }
        this.isEmojiSectionExpanded = true;
        updateViewState(ViewState.Loaded.copy$default(loaded, 0L, null, null, null, null, null, null, null, null, null, null, EmojisData.copy$default(loaded.getEmojisData(), false, this.isEmojiSectionExpanded, null, 5, null), null, false, null, 30719, null));
    }

    public final void onClickJoinServer(long guildId, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context context = fragment.getContext();
        if (context != null) {
            StoreLurking storeLurking = this.storeLurking;
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            storeLurking.postJoinGuildAsMember(guildId, context);
        }
    }

    public final void onClickLeaveServer(long guildId, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(guildId), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(onSuccess), 62, (Object) null);
    }

    public final void onClickMarkAsRead(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(guildId), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void onClickResetNickname(long guildId, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams.Nick("")), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(onSuccess), 62, (Object) null);
    }

    public final void onClickSaveNickname(long guildId, String nick, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams.Nick(nick)), false, 1, null), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(onSuccess), 62, (Object) null);
    }

    public final void onClickViewServer(long guildId, Long channelId) {
        StoreLurking.startLurkingAndNavigate$default(this.storeLurking, guildId, channelId, null, 4, null);
    }

    public final void setAllowDM(AppActivity appActivity, long guildId, boolean allow) {
        this.storeUserSettings.setRestrictedGuildId(appActivity, guildId, !allow);
    }

    public final void setHideMutedChannels(long guildId, boolean hide) {
        this.storeUserGuildSettings.setHideMutedChannels(guildId, hide);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeLurking, "storeLurking");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.viewingGuild = z2;
        this.restAPI = restAPI;
        this.storeLurking = storeLurking;
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetGuildProfileSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        storeAnalytics.trackGuildProfileOpened(j);
    }
}

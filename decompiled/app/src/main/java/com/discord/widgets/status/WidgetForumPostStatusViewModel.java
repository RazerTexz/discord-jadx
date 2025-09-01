package com.discord.widgets.status;

import a0.a.a.b;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.app.AppFragment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.forums.ForumUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetForumPostStatusViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003NOPB\u0083\u0001\u0012\u0006\u0010?\u001a\u00020>\u0012\b\b\u0002\u0010E\u001a\u00020D\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\b\b\u0002\u0010H\u001a\u00020G\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010<\u001a\u00020;\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u0010B\u001a\u00020A\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u00104\u001a\u000203\u0012\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160J¢\u0006\u0004\bL\u0010MJ+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJA\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0010\u001a\u00060\u0005j\u0002`\u000f2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019JE\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0010\u001a\u00060\u0005j\u0002`\u000f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJQ\u0010 \u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u001d\u001a\u00060\u0005j\u0002`\u001c2\n\u0010\u0010\u001a\u00060\u0005j\u0002`\u000f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!Je\u0010%\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\n\u0010#\u001a\u00060\u0005j\u0002`\"2\n\u0010\u001d\u001a\u00060\u0005j\u0002`\u001c2\n\u0010\u0010\u001a\u00060\u0005j\u0002`\u000f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\b¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006Q"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "isFollowedThread", "", "toggleFollowPost", "(Landroid/content/Context;JZ)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/primitives/GuildId;", "guildId", "isArchivedThread", "Lkotlin/Function0;", "onFullMembership", "doPress", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JZLkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;)V", "onFollowPress", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JJZZ)V", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "onReactionLongPress", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JJJZLcom/discord/api/message/reaction/MessageReaction;)V", "Lcom/discord/primitives/UserId;", "myUserId", "hasAddReactionPermission", "onReactionPress", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JJJJZLcom/discord/api/message/reaction/MessageReaction;Z)V", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lcom/discord/stores/StoreThreadsJoined;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/StoreThreadMessages;", "storeThreadMessages", "Lcom/discord/stores/StoreThreadMessages;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;", "userReactionHandler", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "followRequestInProgress", "Z", "Lcom/discord/stores/StoreForumPostMessages;", "storeForumPostMessages", "Lcom/discord/stores/StoreForumPostMessages;", "Lcom/discord/app/AppFragment;", "appFragment", "Lcom/discord/app/AppFragment;", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lcom/discord/stores/StoreEmoji;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lcom/discord/app/AppFragment;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreThreadsJoined;Lcom/discord/stores/StoreForumPostMessages;Lcom/discord/stores/StoreThreadMessages;Lcom/discord/stores/StoreMessages;Lcom/discord/stores/StoreEmoji;Lcom/discord/stores/StorePermissions;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AppFragment appFragment;
    private boolean followRequestInProgress;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreMessages storeMessages;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUser storeUser;
    private final WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler;

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$1, reason: invalid class name */
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
            WidgetForumPostStatusViewModel widgetForumPostStatusViewModel = WidgetForumPostStatusViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetForumPostStatusViewModel.handleStoreState(storeState);
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017JS\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$Companion;", "", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lcom/discord/stores/StoreForumPostMessages;", "storeForumPostMessages", "Lcom/discord/stores/StoreThreadMessages;", "storeThreadMessages", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreThreadsJoined;Lcom/discord/stores/StoreForumPostMessages;Lcom/discord/stores/StoreThreadMessages;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreEmoji;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStoreState(StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StorePermissions storePermissions, StoreEmoji storeEmoji) {
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
            Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
            Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
            Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
            Intrinsics3.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
            Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
            Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
            Observable<StoreState> observableY = ForumUtils.observeSelectedPostChannel$default(ForumUtils.INSTANCE, storeChannels, storeChannelsSelected, null, null, 12, null).Y(new WidgetForumPostStatusViewModel2(storeUser, storeThreadsJoined, storeForumPostMessages, storeThreadMessages, storePermissions, storeEmoji));
            Intrinsics3.checkNotNullExpressionValue(observableY, "ForumUtils.observeSelect…      }\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Loaded", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Loaded;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetForumPostStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Invalid;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetForumPostStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\u0010\u0019\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\b\u0012\u000e\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020\r\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b:\u0010;J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0002j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0018\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u008c\u0001\u0010#\u001a\u00020\u00002\f\b\u0002\u0010\u0019\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u001a\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\u001b\u001a\u00060\u0002j\u0002`\b2\u0010\b\u0002\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010.\u001a\u0004\b/\u0010\u0018R\u0019\u0010!\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b!\u0010\u000fR!\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\fR\u001d\u0010\u001a\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\u0005R\u0019\u0010\u001e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b\u001e\u0010\u000fR\u001d\u0010\u001b\u001a\u00060\u0002j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b5\u0010\u0005R\u001d\u0010\u0019\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00103\u001a\u0004\b6\u0010\u0005R\u0019\u0010\u001d\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b\u001d\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u0013R\u0019\u0010 \u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b9\u0010\u000f¨\u0006<"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Loaded;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/GuildId;", "component3", "Lcom/discord/primitives/MessageId;", "component4", "()Ljava/lang/Long;", "", "component5", "()Z", "component6", "", "component7", "()Ljava/lang/Integer;", "component8", "component9", "Lcom/discord/api/message/reaction/MessageReaction;", "component10", "()Lcom/discord/api/message/reaction/MessageReaction;", "myUserId", "channelId", "guildId", "messageId", "isFollowedThread", "isArchivedThread", "messageCount", "hasAddReactionPermission", "isDefaultReaction", "mostCommonReaction", "copy", "(JJJLjava/lang/Long;ZZLjava/lang/Integer;ZZLcom/discord/api/message/reaction/MessageReaction;)Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/message/reaction/MessageReaction;", "getMostCommonReaction", "Z", "Ljava/lang/Long;", "getMessageId", "J", "getChannelId", "getGuildId", "getMyUserId", "Ljava/lang/Integer;", "getMessageCount", "getHasAddReactionPermission", "<init>", "(JJJLjava/lang/Long;ZZLjava/lang/Integer;ZZLcom/discord/api/message/reaction/MessageReaction;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends StoreState {
            private final long channelId;
            private final long guildId;
            private final boolean hasAddReactionPermission;
            private final boolean isArchivedThread;
            private final boolean isDefaultReaction;
            private final boolean isFollowedThread;
            private final Integer messageCount;
            private final Long messageId;
            private final MessageReaction mostCommonReaction;
            private final long myUserId;

            public Loaded(long j, long j2, long j3, Long l, boolean z2, boolean z3, Integer num, boolean z4, boolean z5, MessageReaction messageReaction) {
                super(null);
                this.myUserId = j;
                this.channelId = j2;
                this.guildId = j3;
                this.messageId = l;
                this.isFollowedThread = z2;
                this.isArchivedThread = z3;
                this.messageCount = num;
                this.hasAddReactionPermission = z4;
                this.isDefaultReaction = z5;
                this.mostCommonReaction = messageReaction;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, long j, long j2, long j3, Long l, boolean z2, boolean z3, Integer num, boolean z4, boolean z5, MessageReaction messageReaction, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.myUserId : j, (i & 2) != 0 ? loaded.channelId : j2, (i & 4) != 0 ? loaded.guildId : j3, (i & 8) != 0 ? loaded.messageId : l, (i & 16) != 0 ? loaded.isFollowedThread : z2, (i & 32) != 0 ? loaded.isArchivedThread : z3, (i & 64) != 0 ? loaded.messageCount : num, (i & 128) != 0 ? loaded.hasAddReactionPermission : z4, (i & 256) != 0 ? loaded.isDefaultReaction : z5, (i & 512) != 0 ? loaded.mostCommonReaction : messageReaction);
            }

            /* renamed from: component1, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* renamed from: component10, reason: from getter */
            public final MessageReaction getMostCommonReaction() {
                return this.mostCommonReaction;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component4, reason: from getter */
            public final Long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsFollowedThread() {
                return this.isFollowedThread;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsArchivedThread() {
                return this.isArchivedThread;
            }

            /* renamed from: component7, reason: from getter */
            public final Integer getMessageCount() {
                return this.messageCount;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsDefaultReaction() {
                return this.isDefaultReaction;
            }

            public final Loaded copy(long myUserId, long channelId, long guildId, Long messageId, boolean isFollowedThread, boolean isArchivedThread, Integer messageCount, boolean hasAddReactionPermission, boolean isDefaultReaction, MessageReaction mostCommonReaction) {
                return new Loaded(myUserId, channelId, guildId, messageId, isFollowedThread, isArchivedThread, messageCount, hasAddReactionPermission, isDefaultReaction, mostCommonReaction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.myUserId == loaded.myUserId && this.channelId == loaded.channelId && this.guildId == loaded.guildId && Intrinsics3.areEqual(this.messageId, loaded.messageId) && this.isFollowedThread == loaded.isFollowedThread && this.isArchivedThread == loaded.isArchivedThread && Intrinsics3.areEqual(this.messageCount, loaded.messageCount) && this.hasAddReactionPermission == loaded.hasAddReactionPermission && this.isDefaultReaction == loaded.isDefaultReaction && Intrinsics3.areEqual(this.mostCommonReaction, loaded.mostCommonReaction);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            public final Integer getMessageCount() {
                return this.messageCount;
            }

            public final Long getMessageId() {
                return this.messageId;
            }

            public final MessageReaction getMostCommonReaction() {
                return this.mostCommonReaction;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = (b.a(this.guildId) + ((b.a(this.channelId) + (b.a(this.myUserId) * 31)) * 31)) * 31;
                Long l = this.messageId;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                boolean z2 = this.isFollowedThread;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isArchivedThread;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                Integer num = this.messageCount;
                int iHashCode2 = (i4 + (num != null ? num.hashCode() : 0)) * 31;
                boolean z4 = this.hasAddReactionPermission;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (iHashCode2 + i5) * 31;
                boolean z5 = this.isDefaultReaction;
                int i7 = (i6 + (z5 ? 1 : z5 ? 1 : 0)) * 31;
                MessageReaction messageReaction = this.mostCommonReaction;
                return i7 + (messageReaction != null ? messageReaction.hashCode() : 0);
            }

            public final boolean isArchivedThread() {
                return this.isArchivedThread;
            }

            public final boolean isDefaultReaction() {
                return this.isDefaultReaction;
            }

            public final boolean isFollowedThread() {
                return this.isFollowedThread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", isFollowedThread=");
                sbU.append(this.isFollowedThread);
                sbU.append(", isArchivedThread=");
                sbU.append(this.isArchivedThread);
                sbU.append(", messageCount=");
                sbU.append(this.messageCount);
                sbU.append(", hasAddReactionPermission=");
                sbU.append(this.hasAddReactionPermission);
                sbU.append(", isDefaultReaction=");
                sbU.append(this.isDefaultReaction);
                sbU.append(", mostCommonReaction=");
                sbU.append(this.mostCommonReaction);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Valid;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetForumPostStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Invalid;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetForumPostStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\u001c\u001a\u00060\u0002j\u0002`\b\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u000e\u0010\u001f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\u0015\u0012\u0006\u0010#\u001a\u00020\n\u0012\u0006\u0010$\u001a\u00020\n¢\u0006\u0004\b<\u0010=J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0002j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0018\u0010\fJ\u0010\u0010\u0019\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0019\u0010\fJ\u0094\u0001\u0010%\u001a\u00020\u00002\f\b\u0002\u0010\u001a\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u001b\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\u001c\u001a\u00060\u0002j\u0002`\b2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\n2\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b*\u0010\u0017J\u001a\u0010-\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001d\u0010\u001a\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0005R\u0019\u0010\u001d\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b\u001d\u0010\fR!\u0010\u001f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\u0010R\u001b\u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\u0013R\u0019\u0010#\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00101\u001a\u0004\b6\u0010\fR\u0019\u0010$\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00101\u001a\u0004\b7\u0010\fR\u001d\u0010\u001b\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b8\u0010\u0005R\u0019\u0010\u001e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b\u001e\u0010\fR\u001d\u0010\u001c\u001a\u00060\u0002j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b9\u0010\u0005R\u0019\u0010!\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b!\u0010\fR\u0019\u0010\"\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b;\u0010\u0017¨\u0006>"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Valid;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/GuildId;", "component3", "", "component4", "()Z", "component5", "Lcom/discord/primitives/MessageId;", "component6", "()Ljava/lang/Long;", "Lcom/discord/api/message/reaction/MessageReaction;", "component7", "()Lcom/discord/api/message/reaction/MessageReaction;", "component8", "", "component9", "()I", "component10", "component11", "myUserId", "channelId", "guildId", "isFollowedThread", "isArchivedThread", "messageId", "reaction", "isDefaultReaction", "messageCount", "hasAddReactionPermission", "followRequestInProgress", "copy", "(JJJZZLjava/lang/Long;Lcom/discord/api/message/reaction/MessageReaction;ZIZZ)Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Valid;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getMyUserId", "Z", "Ljava/lang/Long;", "getMessageId", "Lcom/discord/api/message/reaction/MessageReaction;", "getReaction", "getHasAddReactionPermission", "getFollowRequestInProgress", "getChannelId", "getGuildId", "I", "getMessageCount", "<init>", "(JJJZZLjava/lang/Long;Lcom/discord/api/message/reaction/MessageReaction;ZIZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final long channelId;
            private final boolean followRequestInProgress;
            private final long guildId;
            private final boolean hasAddReactionPermission;
            private final boolean isArchivedThread;
            private final boolean isDefaultReaction;
            private final boolean isFollowedThread;
            private final int messageCount;
            private final Long messageId;
            private final long myUserId;
            private final MessageReaction reaction;

            public Valid(long j, long j2, long j3, boolean z2, boolean z3, Long l, MessageReaction messageReaction, boolean z4, int i, boolean z5, boolean z6) {
                super(null);
                this.myUserId = j;
                this.channelId = j2;
                this.guildId = j3;
                this.isFollowedThread = z2;
                this.isArchivedThread = z3;
                this.messageId = l;
                this.reaction = messageReaction;
                this.isDefaultReaction = z4;
                this.messageCount = i;
                this.hasAddReactionPermission = z5;
                this.followRequestInProgress = z6;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, long j, long j2, long j3, boolean z2, boolean z3, Long l, MessageReaction messageReaction, boolean z4, int i, boolean z5, boolean z6, int i2, Object obj) {
                return valid.copy((i2 & 1) != 0 ? valid.myUserId : j, (i2 & 2) != 0 ? valid.channelId : j2, (i2 & 4) != 0 ? valid.guildId : j3, (i2 & 8) != 0 ? valid.isFollowedThread : z2, (i2 & 16) != 0 ? valid.isArchivedThread : z3, (i2 & 32) != 0 ? valid.messageId : l, (i2 & 64) != 0 ? valid.reaction : messageReaction, (i2 & 128) != 0 ? valid.isDefaultReaction : z4, (i2 & 256) != 0 ? valid.messageCount : i, (i2 & 512) != 0 ? valid.hasAddReactionPermission : z5, (i2 & 1024) != 0 ? valid.followRequestInProgress : z6);
            }

            /* renamed from: component1, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getFollowRequestInProgress() {
                return this.followRequestInProgress;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsFollowedThread() {
                return this.isFollowedThread;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsArchivedThread() {
                return this.isArchivedThread;
            }

            /* renamed from: component6, reason: from getter */
            public final Long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component7, reason: from getter */
            public final MessageReaction getReaction() {
                return this.reaction;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsDefaultReaction() {
                return this.isDefaultReaction;
            }

            /* renamed from: component9, reason: from getter */
            public final int getMessageCount() {
                return this.messageCount;
            }

            public final Valid copy(long myUserId, long channelId, long guildId, boolean isFollowedThread, boolean isArchivedThread, Long messageId, MessageReaction reaction, boolean isDefaultReaction, int messageCount, boolean hasAddReactionPermission, boolean followRequestInProgress) {
                return new Valid(myUserId, channelId, guildId, isFollowedThread, isArchivedThread, messageId, reaction, isDefaultReaction, messageCount, hasAddReactionPermission, followRequestInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return this.myUserId == valid.myUserId && this.channelId == valid.channelId && this.guildId == valid.guildId && this.isFollowedThread == valid.isFollowedThread && this.isArchivedThread == valid.isArchivedThread && Intrinsics3.areEqual(this.messageId, valid.messageId) && Intrinsics3.areEqual(this.reaction, valid.reaction) && this.isDefaultReaction == valid.isDefaultReaction && this.messageCount == valid.messageCount && this.hasAddReactionPermission == valid.hasAddReactionPermission && this.followRequestInProgress == valid.followRequestInProgress;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getFollowRequestInProgress() {
                return this.followRequestInProgress;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasAddReactionPermission() {
                return this.hasAddReactionPermission;
            }

            public final int getMessageCount() {
                return this.messageCount;
            }

            public final Long getMessageId() {
                return this.messageId;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final MessageReaction getReaction() {
                return this.reaction;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = (b.a(this.guildId) + ((b.a(this.channelId) + (b.a(this.myUserId) * 31)) * 31)) * 31;
                boolean z2 = this.isFollowedThread;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                boolean z3 = this.isArchivedThread;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                Long l = this.messageId;
                int iHashCode = (i4 + (l != null ? l.hashCode() : 0)) * 31;
                MessageReaction messageReaction = this.reaction;
                int iHashCode2 = (iHashCode + (messageReaction != null ? messageReaction.hashCode() : 0)) * 31;
                boolean z4 = this.isDefaultReaction;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (((iHashCode2 + i5) * 31) + this.messageCount) * 31;
                boolean z5 = this.hasAddReactionPermission;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                boolean z6 = this.followRequestInProgress;
                return i8 + (z6 ? 1 : z6 ? 1 : 0);
            }

            public final boolean isArchivedThread() {
                return this.isArchivedThread;
            }

            public final boolean isDefaultReaction() {
                return this.isDefaultReaction;
            }

            public final boolean isFollowedThread() {
                return this.isFollowedThread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", isFollowedThread=");
                sbU.append(this.isFollowedThread);
                sbU.append(", isArchivedThread=");
                sbU.append(this.isArchivedThread);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", reaction=");
                sbU.append(this.reaction);
                sbU.append(", isDefaultReaction=");
                sbU.append(this.isDefaultReaction);
                sbU.append(", messageCount=");
                sbU.append(this.messageCount);
                sbU.append(", hasAddReactionPermission=");
                sbU.append(this.hasAddReactionPermission);
                sbU.append(", followRequestInProgress=");
                return outline.O(sbU, this.followRequestInProgress, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$doPress$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isArchivedThread;
        public final /* synthetic */ Function0 $onFullMembership;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, Context context, Function0 function0) {
            super(0);
            this.$isArchivedThread = z2;
            this.$context = context;
            this.$onFullMembership = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$isArchivedThread) {
                AppToast.g(this.$context, R.string.thread_archived, 0, null, 12);
            } else {
                this.$onFullMembership.invoke();
            }
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onFollowPress$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isFollowedThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, long j, boolean z2) {
            super(0);
            this.$context = context;
            this.$channelId = j;
            this.$isFollowedThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.access$toggleFollowPost(WidgetForumPostStatusViewModel.this, this.$context, this.$channelId, this.$isFollowedThread);
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onReactionLongPress$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Context context, MessageReaction messageReaction) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$context = context;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetManageReactions.INSTANCE.create(this.$channelId, this.$messageId, this.$context, this.$reaction);
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$onReactionPress$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $hasAddReactionPermission;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ long $myUserId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, long j, long j2, long j3, MessageReaction messageReaction) {
            super(0);
            this.$hasAddReactionPermission = z2;
            this.$myUserId = j;
            this.$channelId = j2;
            this.$messageId = j3;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$hasAddReactionPermission) {
                WidgetForumPostStatusViewModel.access$getUserReactionHandler$p(WidgetForumPostStatusViewModel.this).toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
            }
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.access$setFollowRequestInProgress$p(WidgetForumPostStatusViewModel.this, false);
            WidgetForumPostStatusViewModel.access$updateViewState(WidgetForumPostStatusViewModel.this, ViewState.Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumPostStatusViewModel.access$setFollowRequestInProgress$p(WidgetForumPostStatusViewModel.this, false);
            WidgetForumPostStatusViewModel.access$updateViewState(WidgetForumPostStatusViewModel.this, ViewState.Valid.copy$default(this.$viewState, 0L, 0L, 0L, false, false, null, null, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null));
        }
    }

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$toggleFollowPost$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreThreadsJoined threadsJoined = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsJoined() : storeThreadsJoined;
        StoreForumPostMessages forumPostMessages = (i & 32) != 0 ? StoreStream.INSTANCE.getForumPostMessages() : storeForumPostMessages;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreMessages messages = (i & 128) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        StoreEmoji emojis = (i & 256) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(appFragment, users, channels, channelsSelected, threadsJoined, forumPostMessages, threadMessages, messages, emojis, permissions, (i & 1024) != 0 ? new WidgetChatListAdapterEventsHandler.UserReactionHandler(appFragment, messages, emojis) : userReactionHandler, (i & 2048) != 0 ? INSTANCE.observeStoreState(users, channels, channelsSelected, threadsJoined, forumPostMessages, threadMessages, permissions, emojis) : observable);
    }

    public static final /* synthetic */ boolean access$getFollowRequestInProgress$p(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel) {
        return widgetForumPostStatusViewModel.followRequestInProgress;
    }

    public static final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler access$getUserReactionHandler$p(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel) {
        return widgetForumPostStatusViewModel.userReactionHandler;
    }

    public static final /* synthetic */ void access$setFollowRequestInProgress$p(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, boolean z2) {
        widgetForumPostStatusViewModel.followRequestInProgress = z2;
    }

    public static final /* synthetic */ void access$toggleFollowPost(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, Context context, long j, boolean z2) {
        widgetForumPostStatusViewModel.toggleFollowPost(context, j, z2);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetForumPostStatusViewModel widgetForumPostStatusViewModel, ViewState viewState) {
        widgetForumPostStatusViewModel.updateViewState(viewState);
    }

    private final void doPress(Context context, FragmentManager fragmentManager, long guildId, boolean isArchivedThread, Function0<Unit> onFullMembership) {
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(isArchivedThread, context, onFullMembership), 32, null);
    }

    private final void toggleFollowPost(Context context, long channelId, boolean isFollowedThread) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || this.followRequestInProgress) {
            return;
        }
        this.followRequestInProgress = true;
        updateViewState(ViewState.Valid.copy$default(valid, 0L, 0L, 0L, false, false, null, null, false, 0, false, true, AudioAttributesCompat.FLAG_ALL, null));
        if (isFollowedThread) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Forum Split View Toolbar"), false, 1, null), this, null, 2, null), WidgetForumPostStatusViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, new AnonymousClass1(valid), AnonymousClass2.INSTANCE, 28, (Object) null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Forum Split View Toolbar", new RestAPIParams.EmptyBody()), false, 1, null), this, null, 2, null), WidgetForumPostStatusViewModel.class, context, (Function1) null, (Function1) null, (Function0) null, new AnonymousClass3(valid), AnonymousClass4.INSTANCE, 28, (Object) null);
        }
    }

    public final void handleStoreState(StoreState storeState) {
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        if (!(storeState instanceof StoreState.Loaded)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Loaded loaded = (StoreState.Loaded) storeState;
        long myUserId = loaded.getMyUserId();
        long channelId = loaded.getChannelId();
        long guildId = loaded.getGuildId();
        boolean zIsFollowedThread = loaded.isFollowedThread();
        boolean zIsArchivedThread = loaded.isArchivedThread();
        Long messageId = loaded.getMessageId();
        MessageReaction mostCommonReaction = loaded.getMostCommonReaction();
        boolean zIsDefaultReaction = loaded.isDefaultReaction();
        Integer messageCount = loaded.getMessageCount();
        int iIntValue = messageCount != null ? messageCount.intValue() : 0;
        boolean hasAddReactionPermission = loaded.getHasAddReactionPermission();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        updateViewState(new ViewState.Valid(myUserId, channelId, guildId, zIsFollowedThread, zIsArchivedThread, messageId, mostCommonReaction, zIsDefaultReaction, iIntValue, hasAddReactionPermission, valid != null ? valid.getFollowRequestInProgress() : false));
    }

    public final void onFollowPress(Context context, FragmentManager fragmentManager, long guildId, long channelId, boolean isArchivedThread, boolean isFollowedThread) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        doPress(context, fragmentManager, guildId, isArchivedThread, new AnonymousClass1(context, channelId, isFollowedThread));
    }

    public final void onReactionLongPress(Context context, FragmentManager fragmentManager, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new AnonymousClass1(channelId, messageId, context, reaction));
    }

    public final void onReactionPress(Context context, FragmentManager fragmentManager, long myUserId, long messageId, long guildId, long channelId, boolean isArchivedThread, MessageReaction reaction, boolean hasAddReactionPermission) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        doPress(context, fragmentManager, guildId, isArchivedThread, new AnonymousClass1(hasAddReactionPermission, myUserId, channelId, messageId, reaction));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel(AppFragment appFragment, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreMessages storeMessages, StoreEmoji storeEmoji, StorePermissions storePermissions, WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(appFragment, "appFragment");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        Intrinsics3.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(userReactionHandler, "userReactionHandler");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.appFragment = appFragment;
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeThreadsJoined = storeThreadsJoined;
        this.storeForumPostMessages = storeForumPostMessages;
        this.storeThreadMessages = storeThreadMessages;
        this.storeMessages = storeMessages;
        this.storeEmoji = storeEmoji;
        this.storePermissions = storePermissions;
        this.userReactionHandler = userReactionHandler;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetForumPostStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

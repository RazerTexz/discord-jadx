package com.discord.widgets.channels.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter;
import d0.g0.Strings4;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004;<=>B7\u0012\n\u0010/\u001a\u00060\tj\u0002`.\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u0015J\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R:\u0010&\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010\u00120\u0012 %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010\u00120\u0012\u0018\u00010$0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\u00060\tj\u0002`.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R:\u00102\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010\u001f0\u001f %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010\u001f0\u001f\u0018\u000101018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R&\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000b04j\b\u0012\u0004\u0012\u00020\u000b`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006?"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$ViewState;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;)V", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/api/channel/Channel;", "channel", "", "excludeUsersAlreadyInChannel", "(Ljava/util/Map;Lcom/discord/api/channel/Channel;)Ljava/util/List;", "", "searchText", "onSearch", "(Ljava/lang/CharSequence;)V", "emitChannelFullEvent", "()V", "user", "", "isChecked", "onChangeUserChecked", "(Lcom/discord/models/user/User;Z)V", "onSearchTextChanged", "Lrx/Observable;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "currentStoreState", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "searchTextChangedPublisher", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "", "maxNumMembers", "I", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lrx/subjects/PublishSubject;", "eventSubject", "Lrx/subjects/PublishSubject;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "checkedUsers", "Ljava/util/HashSet;", "storeStateObservable", "<init>", "(JLcom/discord/stores/StoreUser;ILrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long SEARCH_DEBOUNCE_MILLIS = 150;
    private final long channelId;
    private final HashSet<User> checkedUsers;
    private StoreState currentStoreState;
    private final PublishSubject<Event> eventSubject;
    private final int maxNumMembers;
    private final BehaviorSubject<CharSequence> searchTextChangedPublisher;
    private final StoreUser storeUser;

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$1, reason: invalid class name */
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
            GroupInviteFriendsSheetViewModel.access$handleStoreState(GroupInviteFriendsSheetViewModel.this, storeState);
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "searchText", "", "invoke", "(Ljava/lang/CharSequence;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<CharSequence, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
            invoke2(charSequence);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CharSequence charSequence) {
            GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel = GroupInviteFriendsSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(charSequence, "searchText");
            GroupInviteFriendsSheetViewModel.access$onSearch(groupInviteFriendsSheetViewModel, charSequence);
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lrx/Observable;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;)Lrx/Observable;", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "observeFriends", "(Lcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "", "getMaxNumMembers", "(Lcom/discord/stores/StoreUser;)I", "MAX_GROUP_MEMBERS", "I", "MAX_GROUP_MEMBERS_STAFF", "SEARCH_DEBOUNCE_MILLIS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$getMaxNumMembers(Companion companion, StoreUser storeUser) {
            return companion.getMaxNumMembers(storeUser);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
            return companion.observeStoreState(j, storeUserRelationships, storeUser, storeChannels);
        }

        private final int getMaxNumMembers(StoreUser storeUser) {
            return UserUtils.INSTANCE.isStaff(storeUser.getMeSnapshot()) ? 25 : 10;
        }

        private final Observable<Map<Long, User>> observeFriends(StoreUserRelationships storeUserRelationships, StoreUser storeUser) {
            Observable observableY = storeUserRelationships.observeForType(1).Y(new GroupInviteFriendsSheetViewModel2(storeUser));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUserRelationships.o…ships.keys)\n            }");
            return observableY;
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
            if (channelId == -1) {
                Observable observableG = observeFriends(storeUserRelationships, storeUser).G(GroupInviteFriendsSheetViewModel3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "observeFriends(storeUser…          )\n            }");
                return observableG;
            }
            Observable<StoreState> observableJ = Observable.j(storeChannels.observeChannel(channelId), observeFriends(storeUserRelationships, storeUser), GroupInviteFriendsSheetViewModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n             …      )\n                }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event;", "", "<init>", "()V", "ChannelFull", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event$ChannelFull;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: GroupInviteFriendsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event$ChannelFull;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ChannelFull extends Event {
            public static final ChannelFull INSTANCE = new ChannelFull();

            private ChannelFull() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\r\u001a\u00020\u00002\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R)\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component1", "()Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "friendUsersMap", "channel", "copy", "(Ljava/util/Map;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getFriendUsersMap", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Ljava/util/Map;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Map<Long, User> friendUsersMap;

        public StoreState() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, ? extends User> map, Channel channel) {
            Intrinsics3.checkNotNullParameter(map, "friendUsersMap");
            this.friendUsersMap = map;
            this.channel = channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.friendUsersMap;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            return storeState.copy(map, channel);
        }

        public final Map<Long, User> component1() {
            return this.friendUsersMap;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreState copy(Map<Long, ? extends User> friendUsersMap, Channel channel) {
            Intrinsics3.checkNotNullParameter(friendUsersMap, "friendUsersMap");
            return new StoreState(friendUsersMap, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.friendUsersMap, storeState.friendUsersMap) && Intrinsics3.areEqual(this.channel, storeState.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, User> getFriendUsersMap() {
            return this.friendUsersMap;
        }

        public int hashCode() {
            Map<Long, User> map = this.friendUsersMap;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Channel channel = this.channel;
            return iHashCode + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(friendUsersMap=");
            sbU.append(this.friendUsersMap);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ StoreState(Map map, Channel channel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Maps6.emptyMap() : map, (i & 2) != 0 ? null : channel);
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#J \u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJD\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR)\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006R\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\r¨\u0006$"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$ViewState;", "", "Ljava/util/HashSet;", "Lcom/discord/models/user/User;", "Lkotlin/collections/HashSet;", "component1", "()Ljava/util/HashSet;", "", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "checkedUsers", "friendItems", "showSearchIcon", "copy", "(Ljava/util/HashSet;Ljava/util/List;Z)Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/HashSet;", "getCheckedUsers", "Ljava/util/List;", "getFriendItems", "Z", "getShowSearchIcon", "<init>", "(Ljava/util/HashSet;Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final HashSet<User> checkedUsers;
        private final List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems;
        private final boolean showSearchIcon;

        public ViewState(HashSet<User> hashSet, List<GroupInviteFriendsSheetAdapter.FriendItem> list, boolean z2) {
            Intrinsics3.checkNotNullParameter(hashSet, "checkedUsers");
            Intrinsics3.checkNotNullParameter(list, "friendItems");
            this.checkedUsers = hashSet;
            this.friendItems = list;
            this.showSearchIcon = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, HashSet hashSet, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                hashSet = viewState.checkedUsers;
            }
            if ((i & 2) != 0) {
                list = viewState.friendItems;
            }
            if ((i & 4) != 0) {
                z2 = viewState.showSearchIcon;
            }
            return viewState.copy(hashSet, list, z2);
        }

        public final HashSet<User> component1() {
            return this.checkedUsers;
        }

        public final List<GroupInviteFriendsSheetAdapter.FriendItem> component2() {
            return this.friendItems;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowSearchIcon() {
            return this.showSearchIcon;
        }

        public final ViewState copy(HashSet<User> checkedUsers, List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems, boolean showSearchIcon) {
            Intrinsics3.checkNotNullParameter(checkedUsers, "checkedUsers");
            Intrinsics3.checkNotNullParameter(friendItems, "friendItems");
            return new ViewState(checkedUsers, friendItems, showSearchIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.checkedUsers, viewState.checkedUsers) && Intrinsics3.areEqual(this.friendItems, viewState.friendItems) && this.showSearchIcon == viewState.showSearchIcon;
        }

        public final HashSet<User> getCheckedUsers() {
            return this.checkedUsers;
        }

        public final List<GroupInviteFriendsSheetAdapter.FriendItem> getFriendItems() {
            return this.friendItems;
        }

        public final boolean getShowSearchIcon() {
            return this.showSearchIcon;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            HashSet<User> hashSet = this.checkedUsers;
            int iHashCode = (hashSet != null ? hashSet.hashCode() : 0) * 31;
            List<GroupInviteFriendsSheetAdapter.FriendItem> list = this.friendItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.showSearchIcon;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(checkedUsers=");
            sbU.append(this.checkedUsers);
            sbU.append(", friendItems=");
            sbU.append(this.friendItems);
            sbU.append(", showSearchIcon=");
            return outline.O(sbU, this.showSearchIcon, ")");
        }

        public /* synthetic */ ViewState(HashSet hashSet, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(hashSet, list, (i & 4) != 0 ? true : z2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        storeUser = (i2 & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        i = (i2 & 4) != 0 ? Companion.access$getMaxNumMembers(INSTANCE, storeUser) : i;
        if ((i2 & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, j, companion2.getUserRelationships(), storeUser, companion2.getChannels());
        }
        this(j, storeUser, i, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel, StoreState storeState) {
        groupInviteFriendsSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onSearch(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel, CharSequence charSequence) {
        groupInviteFriendsSheetViewModel.onSearch(charSequence);
    }

    private final void emitChannelFullEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ChannelFull.INSTANCE);
    }

    private final List<User> excludeUsersAlreadyInChannel(Map<Long, ? extends User> users, Channel channel) {
        Set set;
        List<com.discord.api.user.User> listZ;
        if (channel == null || (listZ = channel.z()) == null) {
            set = null;
        } else {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZ, 10));
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((com.discord.api.user.User) it.next()).getId()));
            }
            set = _Collections.toSet(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, ? extends User> entry : users.entrySet()) {
            boolean z2 = true;
            if (set != null && set.contains(entry.getKey())) {
                z2 = false;
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return _Collections.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
        List<User> listExcludeUsersAlreadyInChannel = excludeUsersAlreadyInChannel(storeState.getFriendUsersMap(), storeState.getChannel());
        HashSet<User> hashSet = this.checkedUsers;
        ArrayList<GroupInviteFriendsSheetAdapter.FriendItem> arrayListCreateItems = GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(listExcludeUsersAlreadyInChannel, hashSet);
        ViewState viewState = getViewState();
        updateViewState(new ViewState(hashSet, arrayListCreateItems, viewState != null ? viewState.getShowSearchIcon() : true));
    }

    private final void onSearch(CharSequence searchText) {
        Collection<User> collectionValues = this.currentStoreState.getFriendUsersMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Strings4.contains((CharSequence) ((User) next).getUsername(), searchText, true)) {
                arrayList.add(next);
            }
        }
        HashSet<User> hashSet = this.checkedUsers;
        updateViewState(new ViewState(hashSet, GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(arrayList, hashSet), (searchText.length() == 0) && this.checkedUsers.isEmpty()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onChangeUserChecked(User user, boolean isChecked) {
        Intrinsics3.checkNotNullParameter(user, "user");
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (!isChecked) {
                this.checkedUsers.remove(user);
            } else if (this.checkedUsers.size() < this.maxNumMembers) {
                this.checkedUsers.add(user);
            } else {
                emitChannelFullEvent();
            }
            List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems = viewState.getFriendItems();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(friendItems, 10));
            Iterator<T> it = friendItems.iterator();
            while (it.hasNext()) {
                arrayList.add(((GroupInviteFriendsSheetAdapter.FriendItem) it.next()).getUser());
            }
            HashSet<User> hashSet = this.checkedUsers;
            updateViewState(ViewState.copy$default(viewState, hashSet, GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(arrayList, hashSet), false, 4, null));
        }
    }

    public final void onSearchTextChanged(CharSequence searchText) {
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        this.searchTextChangedPublisher.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.storeUser = storeUser;
        this.maxNumMembers = i;
        this.eventSubject = PublishSubject.k0();
        this.currentStoreState = new StoreState(null, null, 3, null);
        this.checkedUsers = new HashSet<>();
        BehaviorSubject<CharSequence> behaviorSubjectK0 = BehaviorSubject.k0();
        this.searchTextChangedPublisher = behaviorSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GroupInviteFriendsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<CharSequence> observableP = behaviorSubjectK0.p(150L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "searchTextChangedPublish…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), GroupInviteFriendsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}

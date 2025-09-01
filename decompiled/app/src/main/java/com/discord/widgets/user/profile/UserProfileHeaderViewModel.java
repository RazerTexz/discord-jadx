package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: UserProfileHeaderViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eBe\u0012\n\u0010\f\u001a\u00060\nj\u0002`\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000e\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00060\nj\u0002`\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;)V", "toggleAllowAnimationInReducedMotion", "()V", "", "Lcom/discord/primitives/UserId;", "userId", "J", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "storeObservable", "", "shouldFetchProfile", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;Lrx/Observable;ZLcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserProfile;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long ME = -1;
    private final long userId;

    /* compiled from: UserProfileHeaderViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$1, reason: invalid class name */
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
            UserProfileHeaderViewModel.access$handleStoreState(UserProfileHeaderViewModel.this, storeState);
        }
    }

    /* compiled from: UserProfileHeaderViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(Jc\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\r2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u009b\u0001\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\r2\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u000f2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "", "users", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "observeComputedMembers", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Collection;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "userId", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUserPresence;", "storeUserPresence", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/utilities/streams/StreamContextService;", "streamContextService", "Lcom/discord/stores/StoreAccessibility;", "storeAccessibility", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", "observeStoreState", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StoreUserProfile;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreUserSettings;Lcom/discord/utilities/streams/StreamContextService;Lcom/discord/stores/StoreAccessibility;)Lrx/Observable;", "ME", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeComputedMembers(Companion companion, Long l, Long l2, Collection collection, StoreChannels storeChannels, StoreGuilds storeGuilds) {
            return companion.observeComputedMembers(l, l2, collection, storeChannels, storeGuilds);
        }

        private final Observable<Map<Long, GuildMember>> observeComputedMembers(Long channelId, Long guildId, Collection<Long> users, StoreChannels storeChannels, StoreGuilds storeGuilds) {
            if (channelId != null && channelId.longValue() > 0) {
                Observable observableY = storeChannels.observeChannel(channelId.longValue()).Y(new UserProfileHeaderViewModel2(storeGuilds, users));
                Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels\n          …emptyMap())\n            }");
                return observableY;
            }
            if (guildId != null && guildId.longValue() > 0) {
                return storeGuilds.observeComputed(guildId.longValue(), users);
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Maps6.emptyMap());
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(emptyMap())");
            return scalarSynchronousObservable;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility, int i, Object obj) {
            return companion.observeStoreState(j, l, l2, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 128) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 256) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 512) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 1024) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService, (i & 2048) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility);
        }

        @VisibleForTesting
        public final Observable<StoreState> observeStoreState(long userId, Long channelId, Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility) {
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
            Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
            Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
            Intrinsics3.checkNotNullParameter(streamContextService, "streamContextService");
            Intrinsics3.checkNotNullParameter(storeAccessibility, "storeAccessibility");
            Observable<StoreState> observableY = StoreUser.observeMe$default(storeUser, false, 1, null).Y(new UserProfileHeaderViewModel3(userId, storeUser)).Y(new UserProfileHeaderViewModel4(channelId, storeChannels, storeGuilds, guildId, storeUserPresence, streamContextService, storeUserProfile, storeUserSettings, storeAccessibility));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUser.observeMe()\n  …            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserProfileHeaderViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0016\u0010#\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u001c\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b0\u000e\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010'\u001a\u00020\u0017\u0012\u0006\u0010(\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020\u001a\u0012\b\u0010*\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bI\u0010JJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b0\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J \u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00052\u0018\b\u0002\u0010#\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b2\u001e\b\u0002\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b0\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u001a2\b\b\u0002\u0010)\u001a\u00020\u001a2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00104\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105R\u0019\u0010'\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b'\u00106\u001a\u0004\b7\u0010\u0019R\u001b\u0010&\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\b9\u0010\u0016R\u001b\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010:\u001a\u0004\b;\u0010\u0013R\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010\u0007R/\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010>\u001a\u0004\b?\u0010\u0010R\u0019\u0010(\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010@\u001a\u0004\bA\u0010\u001cR\u0019\u0010)\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010@\u001a\u0004\bB\u0010\u001cR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010C\u001a\u0004\bD\u0010\u0004R)\u0010#\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010E\u001a\u0004\bF\u0010\rR\u001b\u0010*\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010G\u001a\u0004\bH\u0010 ¨\u0006K"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/user/User;", "component2", "()Lcom/discord/models/user/User;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component3", "()Ljava/util/Map;", "", "component4", "()Ljava/util/Collection;", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "component5", "()Lcom/discord/widgets/user/presence/ModelRichPresence;", "Lcom/discord/utilities/streams/StreamContext;", "component6", "()Lcom/discord/utilities/streams/StreamContext;", "Lcom/discord/api/user/UserProfile;", "component7", "()Lcom/discord/api/user/UserProfile;", "", "component8", "()Z", "component9", "Lcom/discord/api/channel/Channel;", "component10", "()Lcom/discord/api/channel/Channel;", "me", "user", "userIdToGuildMemberMap", "guildMembers", "richPresence", "streamContext", "userProfile", "allowAnimatedEmojis", "reducedMotionEnabled", "channel", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/user/User;Ljava/util/Map;Ljava/util/Collection;Lcom/discord/widgets/user/presence/ModelRichPresence;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/user/UserProfile;ZZLcom/discord/api/channel/Channel;)Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/user/UserProfile;", "getUserProfile", "Lcom/discord/utilities/streams/StreamContext;", "getStreamContext", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "getRichPresence", "Lcom/discord/models/user/User;", "getUser", "Ljava/util/Collection;", "getGuildMembers", "Z", "getAllowAnimatedEmojis", "getReducedMotionEnabled", "Lcom/discord/models/user/MeUser;", "getMe", "Ljava/util/Map;", "getUserIdToGuildMemberMap", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/user/User;Ljava/util/Map;Ljava/util/Collection;Lcom/discord/widgets/user/presence/ModelRichPresence;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/user/UserProfile;ZZLcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean allowAnimatedEmojis;
        private final Channel channel;
        private final Collection<Map<Long, GuildMember>> guildMembers;
        private final MeUser me;
        private final boolean reducedMotionEnabled;
        private final ModelRichPresence richPresence;
        private final StreamContext streamContext;
        private final User user;
        private final Map<Long, GuildMember> userIdToGuildMemberMap;
        private final UserProfile userProfile;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(MeUser meUser, User user, Map<Long, GuildMember> map, Collection<? extends Map<Long, GuildMember>> collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(map, "userIdToGuildMemberMap");
            Intrinsics3.checkNotNullParameter(collection, "guildMembers");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            this.me = meUser;
            this.user = user;
            this.userIdToGuildMemberMap = map;
            this.guildMembers = collection;
            this.richPresence = modelRichPresence;
            this.streamContext = streamContext;
            this.userProfile = userProfile;
            this.allowAnimatedEmojis = z2;
            this.reducedMotionEnabled = z3;
            this.channel = channel;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, User user, Map map, Collection collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.me : meUser, (i & 2) != 0 ? storeState.user : user, (i & 4) != 0 ? storeState.userIdToGuildMemberMap : map, (i & 8) != 0 ? storeState.guildMembers : collection, (i & 16) != 0 ? storeState.richPresence : modelRichPresence, (i & 32) != 0 ? storeState.streamContext : streamContext, (i & 64) != 0 ? storeState.userProfile : userProfile, (i & 128) != 0 ? storeState.allowAnimatedEmojis : z2, (i & 256) != 0 ? storeState.reducedMotionEnabled : z3, (i & 512) != 0 ? storeState.channel : channel);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component10, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<Long, GuildMember> component3() {
            return this.userIdToGuildMemberMap;
        }

        public final Collection<Map<Long, GuildMember>> component4() {
            return this.guildMembers;
        }

        /* renamed from: component5, reason: from getter */
        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        /* renamed from: component6, reason: from getter */
        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        /* renamed from: component7, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        public final StoreState copy(MeUser me2, User user, Map<Long, GuildMember> userIdToGuildMemberMap, Collection<? extends Map<Long, GuildMember>> guildMembers, ModelRichPresence richPresence, StreamContext streamContext, UserProfile userProfile, boolean allowAnimatedEmojis, boolean reducedMotionEnabled, Channel channel) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userIdToGuildMemberMap, "userIdToGuildMemberMap");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            return new StoreState(me2, user, userIdToGuildMemberMap, guildMembers, richPresence, streamContext, userProfile, allowAnimatedEmojis, reducedMotionEnabled, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.userIdToGuildMemberMap, storeState.userIdToGuildMemberMap) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.richPresence, storeState.richPresence) && Intrinsics3.areEqual(this.streamContext, storeState.streamContext) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && this.allowAnimatedEmojis == storeState.allowAnimatedEmojis && this.reducedMotionEnabled == storeState.reducedMotionEnabled && Intrinsics3.areEqual(this.channel, storeState.channel);
        }

        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Collection<Map<Long, GuildMember>> getGuildMembers() {
            return this.guildMembers;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        public final User getUser() {
            return this.user;
        }

        public final Map<Long, GuildMember> getUserIdToGuildMemberMap() {
            return this.userIdToGuildMemberMap;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            User user = this.user;
            int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map = this.userIdToGuildMemberMap;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Collection<Map<Long, GuildMember>> collection = this.guildMembers;
            int iHashCode4 = (iHashCode3 + (collection != null ? collection.hashCode() : 0)) * 31;
            ModelRichPresence modelRichPresence = this.richPresence;
            int iHashCode5 = (iHashCode4 + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
            StreamContext streamContext = this.streamContext;
            int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode7 = (iHashCode6 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            boolean z2 = this.allowAnimatedEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode7 + i) * 31;
            boolean z3 = this.reducedMotionEnabled;
            int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Channel channel = this.channel;
            return i3 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(me=");
            sbU.append(this.me);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", userIdToGuildMemberMap=");
            sbU.append(this.userIdToGuildMemberMap);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", richPresence=");
            sbU.append(this.richPresence);
            sbU.append(", streamContext=");
            sbU.append(this.streamContext);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(", allowAnimatedEmojis=");
            sbU.append(this.allowAnimatedEmojis);
            sbU.append(", reducedMotionEnabled=");
            sbU.append(this.reducedMotionEnabled);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: UserProfileHeaderViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: UserProfileHeaderViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: UserProfileHeaderViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020\u0018\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\b\b\u0002\u0010,\u001a\u00020\u0018\u0012\u0006\u0010-\u001a\u00020\u0018\u0012\b\b\u0002\u0010.\u001a\u00020\u0018\u0012\b\b\u0002\u0010/\u001a\u00020\u0018\u0012\b\b\u0002\u00100\u001a\u00020\u0018\u0012\b\b\u0002\u00101\u001a\u00020\u0018¢\u0006\u0004\bg\u0010hJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u0010\u0010\u001e\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001aJ\u0010\u0010 \u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b \u0010\u001aJ\u0010\u0010!\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b!\u0010\u001aJÀ\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u00182\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u00020\u00182\b\b\u0002\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b4\u0010\u0007J\u0010\u00106\u001a\u000205HÖ\u0001¢\u0006\u0004\b6\u00107J\u001a\u0010:\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u000108HÖ\u0003¢\u0006\u0004\b:\u0010;R\u001b\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010<\u001a\u0004\b=\u0010\u0011R\u0019\u0010,\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010>\u001a\u0004\b?\u0010\u001aR\u0019\u0010@\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010>\u001a\u0004\bA\u0010\u001aR\u001b\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010B\u001a\u0004\bC\u0010\u000bR\u0019\u0010D\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010>\u001a\u0004\bE\u0010\u001aR\u0019\u0010-\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010>\u001a\u0004\bF\u0010\u001aR\u001b\u0010(\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010G\u001a\u0004\bH\u0010\u0014R\u001d\u0010L\u001a\u00020\u00058F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0007R\u0019\u0010M\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010>\u001a\u0004\bM\u0010\u001aR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010N\u001a\u0004\bO\u0010\u0004R\u0019\u0010P\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010>\u001a\u0004\bQ\u0010\u001aR\u0019\u0010.\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010>\u001a\u0004\bR\u0010\u001aR\u0019\u00101\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010>\u001a\u0004\b1\u0010\u001aR\u001d\u0010U\u001a\u00020\u00058F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010J\u001a\u0004\bT\u0010\u0007R\u0019\u0010*\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010>\u001a\u0004\b*\u0010\u001aR\u0019\u0010V\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010>\u001a\u0004\bW\u0010\u001aR\u001b\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010X\u001a\u0004\bY\u0010\u0007R\u0019\u0010+\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\b+\u0010\u001aR\u0019\u0010)\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010Z\u001a\u0004\b[\u0010\u0017R\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\\\u001a\u0004\b]\u0010\u000eR\u0019\u00100\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010>\u001a\u0004\b^\u0010\u001aR\u0019\u0010_\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010>\u001a\u0004\b`\u0010\u001aR\u0019\u0010a\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010>\u001a\u0004\bb\u0010\u001aR\u0019\u0010/\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010>\u001a\u0004\bc\u0010\u001aR\u0019\u0010d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010>\u001a\u0004\be\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010X\u001a\u0004\bf\u0010\u0007¨\u0006i"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "component2", "()Ljava/lang/String;", "component3", "Lcom/discord/models/member/GuildMember;", "component4", "()Lcom/discord/models/member/GuildMember;", "", "component5", "()Ljava/util/List;", "Lcom/discord/models/presence/Presence;", "component6", "()Lcom/discord/models/presence/Presence;", "Lcom/discord/utilities/streams/StreamContext;", "component7", "()Lcom/discord/utilities/streams/StreamContext;", "Lcom/discord/api/user/UserProfile;", "component8", "()Lcom/discord/api/user/UserProfile;", "", "component9", "()Z", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "user", "banner", "bannerColorHex", "guildMember", "guildMembersForAka", "presence", "streamContext", "userProfile", "isMeUserPremium", "isMeUserVerified", "allowAnimatedEmojis", "showPresence", "editable", "reducedMotionEnabled", "allowAnimationInReducedMotion", "isMe", "copy", "(Lcom/discord/models/user/User;Ljava/lang/String;Ljava/lang/String;Lcom/discord/models/member/GuildMember;Ljava/util/List;Lcom/discord/models/presence/Presence;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/user/UserProfile;ZZZZZZZZ)Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/presence/Presence;", "getPresence", "Z", "getAllowAnimatedEmojis", "showSmallAvatar", "getShowSmallAvatar", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "hasNickname", "getHasNickname", "getShowPresence", "Lcom/discord/utilities/streams/StreamContext;", "getStreamContext", "guildMemberColorId$delegate", "Lkotlin/Lazy;", "getGuildMemberColorId", "guildMemberColorId", "isProfileLoaded", "Lcom/discord/models/user/User;", "getUser", "showAkas", "getShowAkas", "getEditable", "avatarColorId$delegate", "getAvatarColorId", "avatarColorId", "hasGuildMemberAvatar", "getHasGuildMemberAvatar", "Ljava/lang/String;", "getBanner", "Lcom/discord/api/user/UserProfile;", "getUserProfile", "Ljava/util/List;", "getGuildMembersForAka", "getAllowAnimationInReducedMotion", "showMediumAvatar", "getShowMediumAvatar", "shouldShowGIFTag", "getShouldShowGIFTag", "getReducedMotionEnabled", "shouldAnimateBanner", "getShouldAnimateBanner", "getBannerColorHex", "<init>", "(Lcom/discord/models/user/User;Ljava/lang/String;Ljava/lang/String;Lcom/discord/models/member/GuildMember;Ljava/util/List;Lcom/discord/models/presence/Presence;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/user/UserProfile;ZZZZZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean allowAnimatedEmojis;
            private final boolean allowAnimationInReducedMotion;

            /* renamed from: avatarColorId$delegate, reason: from kotlin metadata */
            private final Lazy avatarColorId;
            private final String banner;
            private final String bannerColorHex;
            private final boolean editable;
            private final GuildMember guildMember;

            /* renamed from: guildMemberColorId$delegate, reason: from kotlin metadata */
            private final Lazy guildMemberColorId;
            private final List<GuildMember> guildMembersForAka;
            private final boolean hasGuildMemberAvatar;
            private final boolean hasNickname;
            private final boolean isMe;
            private final boolean isMeUserPremium;
            private final boolean isMeUserVerified;
            private final boolean isProfileLoaded;
            private final Presence presence;
            private final boolean reducedMotionEnabled;
            private final boolean shouldAnimateBanner;
            private final boolean shouldShowGIFTag;
            private final boolean showAkas;
            private final boolean showMediumAvatar;
            private final boolean showPresence;
            private final boolean showSmallAvatar;
            private final StreamContext streamContext;
            private final User user;
            private final UserProfile userProfile;

            public /* synthetic */ Loaded(User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(user, str, str2, (i & 8) != 0 ? null : guildMember, (i & 16) != 0 ? Collections2.emptyList() : list, (i & 32) != 0 ? null : presence, (i & 64) != 0 ? null : streamContext, (i & 128) != 0 ? StoreUserProfile.INSTANCE.getEMPTY_PROFILE() : userProfile, z2, z3, (i & 1024) != 0 ? false : z4, z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? false : z8, (i & 32768) != 0 ? false : z9);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.user : user, (i & 2) != 0 ? loaded.banner : str, (i & 4) != 0 ? loaded.bannerColorHex : str2, (i & 8) != 0 ? loaded.guildMember : guildMember, (i & 16) != 0 ? loaded.guildMembersForAka : list, (i & 32) != 0 ? loaded.presence : presence, (i & 64) != 0 ? loaded.streamContext : streamContext, (i & 128) != 0 ? loaded.userProfile : userProfile, (i & 256) != 0 ? loaded.isMeUserPremium : z2, (i & 512) != 0 ? loaded.isMeUserVerified : z3, (i & 1024) != 0 ? loaded.allowAnimatedEmojis : z4, (i & 2048) != 0 ? loaded.showPresence : z5, (i & 4096) != 0 ? loaded.editable : z6, (i & 8192) != 0 ? loaded.reducedMotionEnabled : z7, (i & 16384) != 0 ? loaded.allowAnimationInReducedMotion : z8, (i & 32768) != 0 ? loaded.isMe : z9);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getIsMeUserVerified() {
                return this.isMeUserVerified;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getShowPresence() {
                return this.showPresence;
            }

            /* renamed from: component13, reason: from getter */
            public final boolean getEditable() {
                return this.editable;
            }

            /* renamed from: component14, reason: from getter */
            public final boolean getReducedMotionEnabled() {
                return this.reducedMotionEnabled;
            }

            /* renamed from: component15, reason: from getter */
            public final boolean getAllowAnimationInReducedMotion() {
                return this.allowAnimationInReducedMotion;
            }

            /* renamed from: component16, reason: from getter */
            public final boolean getIsMe() {
                return this.isMe;
            }

            /* renamed from: component2, reason: from getter */
            public final String getBanner() {
                return this.banner;
            }

            /* renamed from: component3, reason: from getter */
            public final String getBannerColorHex() {
                return this.bannerColorHex;
            }

            /* renamed from: component4, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final List<GuildMember> component5() {
                return this.guildMembersForAka;
            }

            /* renamed from: component6, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component7, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* renamed from: component8, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsMeUserPremium() {
                return this.isMeUserPremium;
            }

            public final Loaded copy(User user, String banner, String bannerColorHex, GuildMember guildMember, List<GuildMember> guildMembersForAka, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean isMeUserPremium, boolean isMeUserVerified, boolean allowAnimatedEmojis, boolean showPresence, boolean editable, boolean reducedMotionEnabled, boolean allowAnimationInReducedMotion, boolean isMe) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(guildMembersForAka, "guildMembersForAka");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                return new Loaded(user, banner, bannerColorHex, guildMember, guildMembersForAka, presence, streamContext, userProfile, isMeUserPremium, isMeUserVerified, allowAnimatedEmojis, showPresence, editable, reducedMotionEnabled, allowAnimationInReducedMotion, isMe);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && Intrinsics3.areEqual(this.banner, loaded.banner) && Intrinsics3.areEqual(this.bannerColorHex, loaded.bannerColorHex) && Intrinsics3.areEqual(this.guildMember, loaded.guildMember) && Intrinsics3.areEqual(this.guildMembersForAka, loaded.guildMembersForAka) && Intrinsics3.areEqual(this.presence, loaded.presence) && Intrinsics3.areEqual(this.streamContext, loaded.streamContext) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile) && this.isMeUserPremium == loaded.isMeUserPremium && this.isMeUserVerified == loaded.isMeUserVerified && this.allowAnimatedEmojis == loaded.allowAnimatedEmojis && this.showPresence == loaded.showPresence && this.editable == loaded.editable && this.reducedMotionEnabled == loaded.reducedMotionEnabled && this.allowAnimationInReducedMotion == loaded.allowAnimationInReducedMotion && this.isMe == loaded.isMe;
            }

            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            public final boolean getAllowAnimationInReducedMotion() {
                return this.allowAnimationInReducedMotion;
            }

            public final String getAvatarColorId() {
                return (String) this.avatarColorId.getValue();
            }

            public final String getBanner() {
                return this.banner;
            }

            public final String getBannerColorHex() {
                return this.bannerColorHex;
            }

            public final boolean getEditable() {
                return this.editable;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final String getGuildMemberColorId() {
                return (String) this.guildMemberColorId.getValue();
            }

            public final List<GuildMember> getGuildMembersForAka() {
                return this.guildMembersForAka;
            }

            public final boolean getHasGuildMemberAvatar() {
                return this.hasGuildMemberAvatar;
            }

            public final boolean getHasNickname() {
                return this.hasNickname;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final boolean getReducedMotionEnabled() {
                return this.reducedMotionEnabled;
            }

            public final boolean getShouldAnimateBanner() {
                return this.shouldAnimateBanner;
            }

            public final boolean getShouldShowGIFTag() {
                return this.shouldShowGIFTag;
            }

            public final boolean getShowAkas() {
                return this.showAkas;
            }

            public final boolean getShowMediumAvatar() {
                return this.showMediumAvatar;
            }

            public final boolean getShowPresence() {
                return this.showPresence;
            }

            public final boolean getShowSmallAvatar() {
                return this.showSmallAvatar;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final User getUser() {
                return this.user;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.banner;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.bannerColorHex;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                List<GuildMember> list = this.guildMembersForAka;
                int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
                Presence presence = this.presence;
                int iHashCode6 = (iHashCode5 + (presence != null ? presence.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                int iHashCode8 = (iHashCode7 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
                boolean z2 = this.isMeUserPremium;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode8 + i) * 31;
                boolean z3 = this.isMeUserVerified;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.allowAnimatedEmojis;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.showPresence;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                boolean z6 = this.editable;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (i8 + i9) * 31;
                boolean z7 = this.reducedMotionEnabled;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (i10 + i11) * 31;
                boolean z8 = this.allowAnimationInReducedMotion;
                int i13 = z8;
                if (z8 != 0) {
                    i13 = 1;
                }
                int i14 = (i12 + i13) * 31;
                boolean z9 = this.isMe;
                return i14 + (z9 ? 1 : z9 ? 1 : 0);
            }

            public final boolean isMe() {
                return this.isMe;
            }

            public final boolean isMeUserPremium() {
                return this.isMeUserPremium;
            }

            public final boolean isMeUserVerified() {
                return this.isMeUserVerified;
            }

            /* renamed from: isProfileLoaded, reason: from getter */
            public final boolean getIsProfileLoaded() {
                return this.isProfileLoaded;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(user=");
                sbU.append(this.user);
                sbU.append(", banner=");
                sbU.append(this.banner);
                sbU.append(", bannerColorHex=");
                sbU.append(this.bannerColorHex);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(", guildMembersForAka=");
                sbU.append(this.guildMembersForAka);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", userProfile=");
                sbU.append(this.userProfile);
                sbU.append(", isMeUserPremium=");
                sbU.append(this.isMeUserPremium);
                sbU.append(", isMeUserVerified=");
                sbU.append(this.isMeUserVerified);
                sbU.append(", allowAnimatedEmojis=");
                sbU.append(this.allowAnimatedEmojis);
                sbU.append(", showPresence=");
                sbU.append(this.showPresence);
                sbU.append(", editable=");
                sbU.append(this.editable);
                sbU.append(", reducedMotionEnabled=");
                sbU.append(this.reducedMotionEnabled);
                sbU.append(", allowAnimationInReducedMotion=");
                sbU.append(this.allowAnimationInReducedMotion);
                sbU.append(", isMe=");
                return outline.O(sbU, this.isMe, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(User user, String str, String str2, GuildMember guildMember, List<GuildMember> list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
                String nick;
                super(null);
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(list, "guildMembersForAka");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                this.user = user;
                this.banner = str;
                this.bannerColorHex = str2;
                this.guildMember = guildMember;
                this.guildMembersForAka = list;
                this.presence = presence;
                this.streamContext = streamContext;
                this.userProfile = userProfile;
                this.isMeUserPremium = z2;
                this.isMeUserVerified = z3;
                this.allowAnimatedEmojis = z4;
                this.showPresence = z5;
                this.editable = z6;
                this.reducedMotionEnabled = z7;
                this.allowAnimationInReducedMotion = z8;
                this.isMe = z9;
                boolean z10 = false;
                boolean z11 = guildMember != null && guildMember.hasAvatar();
                this.hasGuildMemberAvatar = z11;
                boolean z12 = !StringsJVM.isBlank((guildMember == null || (nick = guildMember.getNick()) == null) ? "" : nick);
                this.hasNickname = z12;
                this.showMediumAvatar = z11 && !z12;
                this.showSmallAvatar = z11 && z12;
                this.shouldAnimateBanner = !z7 || z8;
                this.shouldShowGIFTag = z7 && !z8 && str != null && StringsJVM.startsWith$default(str, "a_", false, 2, null);
                this.isProfileLoaded = !Intrinsics3.areEqual(userProfile, StoreUserProfile.INSTANCE.getEMPTY_PROFILE());
                this.avatarColorId = LazyJVM.lazy(new UserProfileHeaderViewModel5(this));
                this.guildMemberColorId = LazyJVM.lazy(new UserProfileHeaderViewModel6(this));
                if ((!list.isEmpty()) && !z9) {
                    z10 = true;
                }
                this.showAkas = z10;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UserProfileHeaderViewModel(long j, Long l, Long l2, Observable observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Long l3 = (i & 2) != 0 ? null : l;
        Long l4 = (i & 4) == 0 ? l2 : null;
        this(j, l3, l4, (i & 8) != 0 ? Companion.observeStoreState$default(INSTANCE, j, l3, l4, null, null, null, null, null, null, null, null, null, 4088, null) : observable, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 64) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile);
    }

    public static final /* synthetic */ void access$handleStoreState(UserProfileHeaderViewModel userProfileHeaderViewModel, StoreState storeState) {
        userProfileHeaderViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        List listEmptyList;
        long id2 = storeState.getUser().getId();
        GuildMember guildMember = storeState.getUserIdToGuildMemberMap().get(Long.valueOf(id2));
        NullSerializable<String> nullSerializableB = storeState.getUserProfile().getUser().b();
        if (!(nullSerializableB instanceof NullSerializable.b)) {
            nullSerializableB = null;
        }
        NullSerializable.b bVar = (NullSerializable.b) nullSerializableB;
        String str = bVar != null ? (String) bVar.a() : null;
        Channel channel = storeState.getChannel();
        boolean z2 = channel != null && ChannelUtils.B(channel);
        ViewState viewState = getViewState();
        User user = storeState.getUser();
        NullSerializable<String> nullSerializableC = storeState.getUserProfile().getUser().c();
        String strA = nullSerializableC != null ? nullSerializableC.a() : null;
        if (z2) {
            Collection<Map<Long, GuildMember>> guildMembers = storeState.getGuildMembers();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = guildMembers.iterator();
            while (it.hasNext()) {
                GuildMember guildMember2 = (GuildMember) ((Map) it.next()).get(Long.valueOf(id2));
                if (guildMember2 != null) {
                    arrayList.add(guildMember2);
                }
            }
            listEmptyList = _Collections.toList(arrayList);
        } else {
            listEmptyList = Collections2.emptyList();
        }
        ModelRichPresence richPresence = storeState.getRichPresence();
        updateViewState(new ViewState.Loaded(user, str, strA, guildMember, listEmptyList, richPresence != null ? richPresence.getPresence() : null, storeState.getStreamContext(), storeState.getUserProfile(), UserUtils.INSTANCE.isPremium(storeState.getMe()), storeState.getMe().isVerified(), storeState.getAllowAnimatedEmojis(), true, false, storeState.getReducedMotionEnabled(), viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getAllowAnimationInReducedMotion() : false, id2 == storeState.getMe().getId(), 4096, null));
    }

    @MainThread
    public final void toggleAllowAnimationInReducedMotion() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !loaded.getReducedMotionEnabled()) {
            return;
        }
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, false, false, false, false, false, false, !loaded.getAllowAnimationInReducedMotion(), false, 49151, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel(long j, Long l, Long l2, Observable<StoreState> observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile) {
        super(ViewState.Uninitialized.INSTANCE);
        long j2 = j;
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        this.userId = j2;
        if (z2) {
            StoreUserProfile.fetchProfile$default(storeUserProfile, j2 == -1 ? storeUser.getMeSnapshot().getId() : j2, l2, false, null, 12, null);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), UserProfileHeaderViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

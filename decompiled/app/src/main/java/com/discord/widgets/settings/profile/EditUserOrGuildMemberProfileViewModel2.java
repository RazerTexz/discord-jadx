package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.api.user.PatchUserBody;
import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004PQRSBu\u0012\u000e\u0010F\u001a\n\u0018\u00010Dj\u0004\u0018\u0001`E\u0012\b\b\u0002\u0010L\u001a\u00020K\u0012\b\b\u0002\u0010B\u001a\u00020A\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\b\b\u0002\u0010I\u001a\u00020H\u0012$\b\u0002\u00108\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020605j\u0002`7\u0012\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0004\bN\u0010OJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\b\u0010\u0007J'\u0010\u000f\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u0002`\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b \u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\"\u0010\u001fJ\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\tH\u0007¢\u0006\u0004\b$\u0010\u001fJ\u0017\u0010%\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)J\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0019¢\u0006\u0004\b+\u0010\u001cJ\u001b\u0010.\u001a\u00020\u00052\n\u0010-\u001a\u0006\u0012\u0002\b\u00030,H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b0\u0010\u0007R:\u00103\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u001a0\u001a 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u001a0\u001a\u0018\u000101018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R2\u00108\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020605j\u0002`78\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010F\u001a\n\u0018\u00010Dj\u0004\u0018\u0001`E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006T"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;", "Landroid/content/Context;", "context", "", "saveGuildMemberChanges", "(Landroid/content/Context;)V", "saveUserChanges", "", "bio", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/settings/profile/AST;", "parseBio", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "createMessagePreprocessor", "()Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;)V", "createAndProcessBioAstFromText", "Lrx/Observable;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;", "observeEvents", "()Lrx/Observable;", "dataUrl", "updateAvatar", "(Ljava/lang/String;)V", "updateBannerImage", "colorHex", "updateBannerColor", ModelAuditLogEntry.CHANGE_KEY_NICK, "updateNickname", "updateBio", "", "isEditing", "updateIsEditingBio", "(Z)V", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "observeHeaderViewState", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "spoilerNode", "handleBioIndexClicked", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", "saveChanges", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "Lcom/discord/widgets/settings/profile/BioParser;", "bioParser", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "", "", "revealedBioIndices", "Ljava/util/Set;", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "Lcom/discord/stores/StoreUserProfile;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreUser;", "storeUser", "storeStateObservable", "<init>", "(Ljava/lang/Long;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserProfile;Lcom/discord/stores/StoreGuilds;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/simpleast/core/parser/Parser;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel2 extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> bioParser;
    private final PublishSubject<Event> eventSubject;
    private final Long guildId;
    private final RestAPI restAPI;
    private final Set<Integer> revealedBioIndices;
    private final StoreGuilds storeGuilds;
    private final StoreUserProfile storeUserProfile;

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            StoreUserProfile.fetchProfile$default(EditUserOrGuildMemberProfileViewModel2.access$getStoreUserProfile$p(EditUserOrGuildMemberProfileViewModel2.this), meUser.getId(), EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this), false, null, 12, null);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2 = EditUserOrGuildMemberProfileViewModel2.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            EditUserOrGuildMemberProfileViewModel2.access$handleStoreState(editUserOrGuildMemberProfileViewModel2, storeState);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "Lrx/Observable;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", "observeStoreState", "(Ljava/lang/Long;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserProfile;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(Long guildId, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile) {
            Observable<StoreState> observableY = Observable.j(StoreUser.observeMe$default(storeUser, false, 1, null), storeGuilds.observeGuild(guildId != null ? guildId.longValue() : -1L), EditUserOrGuildMemberProfileViewModel3.INSTANCE).Y(new EditUserOrGuildMemberProfileViewModel4(storeUserProfile, storeGuilds, guildId));
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…      )\n        }\n      }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, Long l, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile, int i, Object obj) {
            if ((i & 2) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            if ((i & 4) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            if ((i & 8) != 0) {
                storeUserProfile = StoreStream.INSTANCE.getUserProfile();
            }
            return companion.observeStoreState(l, storeUser, storeGuilds, storeUserProfile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;", "", "<init>", "()V", "UserUpdateRequestCompleted", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Event */
    public static abstract class Event {

        /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted */
        public static final class UserUpdateRequestCompleted extends Event {
            public static final UserUpdateRequestCompleted INSTANCE = new UserUpdateRequestCompleted();

            private UserUpdateRequestCompleted() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\rR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\n¨\u0006."}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/user/UserProfile;", "component3", "()Lcom/discord/api/user/UserProfile;", "Lcom/discord/models/member/GuildMember;", "component4", "()Lcom/discord/models/member/GuildMember;", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "component5", "()Lcom/discord/utilities/channel/GuildChannelsInfo;", "user", "guild", "userProfile", "meMember", "guildChannelsInfo", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/user/UserProfile;Lcom/discord/models/member/GuildMember;Lcom/discord/utilities/channel/GuildChannelsInfo;)Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getUser", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "getGuildChannelsInfo", "Lcom/discord/models/member/GuildMember;", "getMeMember", "Lcom/discord/api/user/UserProfile;", "getUserProfile", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/api/user/UserProfile;Lcom/discord/models/member/GuildMember;Lcom/discord/utilities/channel/GuildChannelsInfo;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$StoreState */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final GuildMember meMember;
        private final MeUser user;
        private final UserProfile userProfile;

        public StoreState(MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            this.user = meUser;
            this.guild = guild;
            this.userProfile = userProfile;
            this.meMember = guildMember;
            this.guildChannelsInfo = guildChannelsInfo;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.user;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                userProfile = storeState.userProfile;
            }
            UserProfile userProfile2 = userProfile;
            if ((i & 8) != 0) {
                guildMember = storeState.meMember;
            }
            GuildMember guildMember2 = guildMember;
            if ((i & 16) != 0) {
                guildChannelsInfo = storeState.guildChannelsInfo;
            }
            return storeState.copy(meUser, guild2, userProfile2, guildMember2, guildChannelsInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildMember getMeMember() {
            return this.meMember;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreState copy(MeUser user, Guild guild, UserProfile userProfile, GuildMember meMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            return new StoreState(user, guild, userProfile, meMember, guildChannelsInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && Intrinsics3.areEqual(this.meMember, storeState.meMember) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final GuildMember getMeMember() {
            return this.meMember;
        }

        public final MeUser getUser() {
            return this.user;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public int hashCode() {
            MeUser meUser = this.user;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode3 = (iHashCode2 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            GuildMember guildMember = this.meMember;
            int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            return iHashCode4 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(", meMember=");
            sbU.append(this.meMember);
            sbU.append(", guildChannelsInfo=");
            sbU.append(this.guildChannelsInfo);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$ViewState */
    public static abstract class ViewState {

        /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010)\u001a\u0004\u0018\u00010\u000f\u0012\u001a\u0010*\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017j\u0004\u0018\u0001`\u001a\u0012\u0006\u0010+\u001a\u00020\u001d\u0012\u0006\u0010,\u001a\u00020\u001d¢\u0006\u0004\b\\\u0010]J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J$\u0010\u001b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017j\u0004\u0018\u0001`\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b \u0010\u001fJ¼\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010$\u001a\u00020\u000b2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f2\u001c\b\u0002\u0010*\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017j\u0004\u0018\u0001`\u001a2\b\b\u0002\u0010+\u001a\u00020\u001d2\b\b\u0002\u0010,\u001a\u00020\u001dHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b/\u0010\u0015J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00105\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106R\u0019\u00107\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u001fR\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b;\u0010\u0015R\u0016\u0010<\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00108R\u0019\u0010+\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b+\u00108\u001a\u0004\b+\u0010\u001fR\u0019\u0010=\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010\u001fR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010?\u001a\u0004\b@\u0010\u0004R\u0019\u0010A\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bA\u00108\u001a\u0004\bA\u0010\u001fR\u0016\u0010B\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00108R\u0019\u0010C\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bC\u00108\u001a\u0004\bD\u0010\u001fR-\u0010*\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017j\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010E\u001a\u0004\bF\u0010\u001cR\u0019\u0010G\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bG\u00108\u001a\u0004\bH\u0010\u001fR\u0019\u0010I\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bI\u00108\u001a\u0004\bJ\u0010\u001fR!\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010K\u001a\u0004\bL\u0010\u0011R!\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010K\u001a\u0004\bM\u0010\u0011R\u001b\u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010N\u001a\u0004\bO\u0010\nR\u001b\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010:\u001a\u0004\bP\u0010\u0015R\u001b\u0010Q\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010:\u001a\u0004\bR\u0010\u0015R\u0019\u0010$\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010S\u001a\u0004\bT\u0010\rR\u0019\u0010U\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bU\u00108\u001a\u0004\bU\u0010\u001fR\u0019\u0010,\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b,\u00108\u001a\u0004\bV\u0010\u001fR\u0016\u0010W\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u00108R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010X\u001a\u0004\bY\u0010\u0007R\u0016\u0010Z\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u00108R!\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010K\u001a\u0004\b[\u0010\u0011¨\u0006^"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "Lcom/discord/api/user/UserProfile;", "component4", "()Lcom/discord/api/user/UserProfile;", "Lcom/discord/nullserializable/NullSerializable;", "", "component5", "()Lcom/discord/nullserializable/NullSerializable;", "component6", "component7", "component8", "()Ljava/lang/String;", "component9", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/settings/profile/AST;", "component10", "()Ljava/util/List;", "", "component11", "()Z", "component12", "user", "guild", "meMember", "userProfile", "currentAvatar", "currentBannerImage", "currentBannerColorHex", "currentNickname", "currentBio", "bioAst", "isEditingBio", "canEditNickname", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/models/member/GuildMember;Lcom/discord/api/user/UserProfile;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "showBioEditor", "Z", "getShowBioEditor", "Ljava/lang/String;", "getCurrentBio", "hasMemberBannerForDisplay", "hasBannerImageForDisplay", "getHasBannerImageForDisplay", "Lcom/discord/models/user/MeUser;", "getUser", "isBioChanged", "hasUserBannerForDisplay", "canHaveAnimatedAvatars", "getCanHaveAnimatedAvatars", "Ljava/util/List;", "getBioAst", "hasAvatarForDisplay", "getHasAvatarForDisplay", "showSaveFab", "getShowSaveFab", "Lcom/discord/nullserializable/NullSerializable;", "getCurrentBannerImage", "getCurrentBannerColorHex", "Lcom/discord/models/member/GuildMember;", "getMeMember", "getCurrentNickname", "nonDefaultColorPreviewHex", "getNonDefaultColorPreviewHex", "Lcom/discord/api/user/UserProfile;", "getUserProfile", "isDirty", "getCanEditNickname", "hasUserAvatarForDisplay", "Lcom/discord/models/guild/Guild;", "getGuild", "hasMemberAvatarForDisplay", "getCurrentAvatar", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/models/member/GuildMember;Lcom/discord/api/user/UserProfile;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$ViewState$Loaded */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Node<MessageRenderContext>> bioAst;
            private final boolean canEditNickname;
            private final boolean canHaveAnimatedAvatars;
            private final NullSerializable<String> currentAvatar;
            private final NullSerializable<String> currentBannerColorHex;
            private final NullSerializable<String> currentBannerImage;
            private final String currentBio;
            private final String currentNickname;
            private final Guild guild;
            private final boolean hasAvatarForDisplay;
            private final boolean hasBannerImageForDisplay;
            private final boolean hasMemberAvatarForDisplay;
            private final boolean hasMemberBannerForDisplay;
            private final boolean hasUserAvatarForDisplay;
            private final boolean hasUserBannerForDisplay;
            private final boolean isBioChanged;
            private final boolean isDirty;
            private final boolean isEditingBio;
            private final GuildMember meMember;
            private final String nonDefaultColorPreviewHex;
            private final boolean showBioEditor;
            private final boolean showSaveFab;
            private final MeUser user;
            private final UserProfile userProfile;

            public /* synthetic */ Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(meUser, guild, guildMember, userProfile, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2, (i & 64) != 0 ? null : nullSerializable3, (i & 128) != 0 ? null : str, str2, list, z2, z3);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.user : meUser, (i & 2) != 0 ? loaded.guild : guild, (i & 4) != 0 ? loaded.meMember : guildMember, (i & 8) != 0 ? loaded.userProfile : userProfile, (i & 16) != 0 ? loaded.currentAvatar : nullSerializable, (i & 32) != 0 ? loaded.currentBannerImage : nullSerializable2, (i & 64) != 0 ? loaded.currentBannerColorHex : nullSerializable3, (i & 128) != 0 ? loaded.currentNickname : str, (i & 256) != 0 ? loaded.currentBio : str2, (i & 512) != 0 ? loaded.bioAst : list, (i & 1024) != 0 ? loaded.isEditingBio : z2, (i & 2048) != 0 ? loaded.canEditNickname : z3);
            }

            /* renamed from: component1, reason: from getter */
            public final MeUser getUser() {
                return this.user;
            }

            public final List<Node<MessageRenderContext>> component10() {
                return this.bioAst;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getIsEditingBio() {
                return this.isEditingBio;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getCanEditNickname() {
                return this.canEditNickname;
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getMeMember() {
                return this.meMember;
            }

            /* renamed from: component4, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            public final NullSerializable<String> component5() {
                return this.currentAvatar;
            }

            public final NullSerializable<String> component6() {
                return this.currentBannerImage;
            }

            public final NullSerializable<String> component7() {
                return this.currentBannerColorHex;
            }

            /* renamed from: component8, reason: from getter */
            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            /* renamed from: component9, reason: from getter */
            public final String getCurrentBio() {
                return this.currentBio;
            }

            public final Loaded copy(MeUser user, Guild guild, GuildMember meMember, UserProfile userProfile, NullSerializable<String> currentAvatar, NullSerializable<String> currentBannerImage, NullSerializable<String> currentBannerColorHex, String currentNickname, String currentBio, List<Node<MessageRenderContext>> bioAst, boolean isEditingBio, boolean canEditNickname) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                return new Loaded(user, guild, meMember, userProfile, currentAvatar, currentBannerImage, currentBannerColorHex, currentNickname, currentBio, bioAst, isEditingBio, canEditNickname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.meMember, loaded.meMember) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile) && Intrinsics3.areEqual(this.currentAvatar, loaded.currentAvatar) && Intrinsics3.areEqual(this.currentBannerImage, loaded.currentBannerImage) && Intrinsics3.areEqual(this.currentBannerColorHex, loaded.currentBannerColorHex) && Intrinsics3.areEqual(this.currentNickname, loaded.currentNickname) && Intrinsics3.areEqual(this.currentBio, loaded.currentBio) && Intrinsics3.areEqual(this.bioAst, loaded.bioAst) && this.isEditingBio == loaded.isEditingBio && this.canEditNickname == loaded.canEditNickname;
            }

            public final List<Node<MessageRenderContext>> getBioAst() {
                return this.bioAst;
            }

            public final boolean getCanEditNickname() {
                return this.canEditNickname;
            }

            public final boolean getCanHaveAnimatedAvatars() {
                return this.canHaveAnimatedAvatars;
            }

            public final NullSerializable<String> getCurrentAvatar() {
                return this.currentAvatar;
            }

            public final NullSerializable<String> getCurrentBannerColorHex() {
                return this.currentBannerColorHex;
            }

            public final NullSerializable<String> getCurrentBannerImage() {
                return this.currentBannerImage;
            }

            public final String getCurrentBio() {
                return this.currentBio;
            }

            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasAvatarForDisplay() {
                return this.hasAvatarForDisplay;
            }

            public final boolean getHasBannerImageForDisplay() {
                return this.hasBannerImageForDisplay;
            }

            public final GuildMember getMeMember() {
                return this.meMember;
            }

            public final String getNonDefaultColorPreviewHex() {
                return this.nonDefaultColorPreviewHex;
            }

            public final boolean getShowBioEditor() {
                return this.showBioEditor;
            }

            public final boolean getShowSaveFab() {
                return this.showSaveFab;
            }

            public final MeUser getUser() {
                return this.user;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MeUser meUser = this.user;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                Guild guild = this.guild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meMember;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                int iHashCode4 = (iHashCode3 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable = this.currentAvatar;
                int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable2 = this.currentBannerImage;
                int iHashCode6 = (iHashCode5 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable3 = this.currentBannerColorHex;
                int iHashCode7 = (iHashCode6 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
                String str = this.currentNickname;
                int iHashCode8 = (iHashCode7 + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.currentBio;
                int iHashCode9 = (iHashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<Node<MessageRenderContext>> list = this.bioAst;
                int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isEditingBio;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode10 + i) * 31;
                boolean z3 = this.canEditNickname;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            /* renamed from: isBioChanged, reason: from getter */
            public final boolean getIsBioChanged() {
                return this.isBioChanged;
            }

            /* renamed from: isDirty, reason: from getter */
            public final boolean getIsDirty() {
                return this.isDirty;
            }

            public final boolean isEditingBio() {
                return this.isEditingBio;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(user=");
                sbU.append(this.user);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", meMember=");
                sbU.append(this.meMember);
                sbU.append(", userProfile=");
                sbU.append(this.userProfile);
                sbU.append(", currentAvatar=");
                sbU.append(this.currentAvatar);
                sbU.append(", currentBannerImage=");
                sbU.append(this.currentBannerImage);
                sbU.append(", currentBannerColorHex=");
                sbU.append(this.currentBannerColorHex);
                sbU.append(", currentNickname=");
                sbU.append(this.currentNickname);
                sbU.append(", currentBio=");
                sbU.append(this.currentBio);
                sbU.append(", bioAst=");
                sbU.append(this.bioAst);
                sbU.append(", isEditingBio=");
                sbU.append(this.isEditingBio);
                sbU.append(", canEditNickname=");
                return outline.O(sbU, this.canEditNickname, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, String str, String str2, List<Node<MessageRenderContext>> list, boolean z2, boolean z3) {
                boolean z4;
                boolean z5;
                String bio;
                super(null);
                Intrinsics3.checkNotNullParameter(meUser, "user");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                this.user = meUser;
                this.guild = guild;
                this.meMember = guildMember;
                this.userProfile = userProfile;
                this.currentAvatar = nullSerializable;
                this.currentBannerImage = nullSerializable2;
                this.currentBannerColorHex = nullSerializable3;
                this.currentNickname = str;
                this.currentBio = str2;
                this.bioAst = list;
                this.isEditingBio = z2;
                this.canEditNickname = z3;
                boolean z6 = false;
                if (nullSerializable != null || nullSerializable2 != null || nullSerializable3 != null) {
                    z4 = true;
                } else if (guildMember != null) {
                    bio = "";
                    if (!(!Intrinsics3.areEqual(str2, bio))) {
                        if (guildMember != null) {
                            if (!Intrinsics3.areEqual(guildMember.getNick() == null ? "" : r13, str == null ? "" : str)) {
                            }
                        }
                        z4 = false;
                    }
                } else {
                    bio = "";
                    if (!(!Intrinsics3.areEqual(str2, bio))) {
                    }
                }
                this.isDirty = z4;
                this.showSaveFab = z4 && !z2;
                this.isBioChanged = !Intrinsics3.areEqual(str2, meUser.getBio());
                if (z2) {
                    z5 = true;
                } else {
                    if (!(str2 == null || StringsJVM.isBlank(str2))) {
                        z5 = false;
                    }
                }
                this.showBioEditor = z5;
                this.nonDefaultColorPreviewHex = ((nullSerializable3 instanceof NullSerializable.b) || (nullSerializable3 instanceof NullSerializable.a)) ? nullSerializable3.a() : meUser.getBannerColor();
                boolean z7 = guildMember == null && meUser.getAvatar() != null;
                this.hasUserAvatarForDisplay = z7;
                boolean z8 = guildMember != null && guildMember.hasAvatar();
                this.hasMemberAvatarForDisplay = z8;
                this.hasAvatarForDisplay = !(nullSerializable instanceof NullSerializable.a) && ((nullSerializable instanceof NullSerializable.b) || z7 || z8);
                boolean z9 = guildMember == null && meUser.getBanner() != null;
                this.hasUserBannerForDisplay = z9;
                boolean z10 = guildMember != null && guildMember.hasBanner();
                this.hasMemberBannerForDisplay = z10;
                if (!(nullSerializable2 instanceof NullSerializable.a) && ((nullSerializable2 instanceof NullSerializable.b) || z9 || z10)) {
                    z6 = true;
                }
                this.hasBannerImageForDisplay = z6;
                this.canHaveAnimatedAvatars = PremiumUtils3.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;)Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$observeHeaderViewState$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ViewState, UserProfileHeaderViewModel.ViewState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ UserProfileHeaderViewModel.ViewState call(ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final UserProfileHeaderViewModel.ViewState call2(ViewState viewState) {
            String banner;
            GuildMember meMember;
            if (viewState == null) {
                return UserProfileHeaderViewModel.ViewState.Uninitialized.INSTANCE;
            }
            if (!(viewState instanceof ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewState;
            MeUser user = (loaded.getCurrentAvatar() == null || loaded.getMeMember() != null) ? loaded.getUser() : MeUser.copy$default(loaded.getUser(), 0L, null, loaded.getCurrentAvatar().a(), null, false, false, 0, null, null, false, false, null, 0, 0, null, null, null, null, 262139, null);
            UserProfile userProfile = loaded.getUserProfile();
            if (loaded.getCurrentBannerImage() != null) {
                banner = loaded.getCurrentBannerImage() instanceof NullSerializable.a ? loaded.getMeMember() != null ? loaded.getUser().getBanner() : null : loaded.getCurrentBannerImage().a();
            } else {
                GuildMember meMember2 = loaded.getMeMember();
                if (meMember2 == null || (banner = meMember2.getBannerHash()) == null) {
                    banner = loaded.getUser().getBanner();
                }
            }
            String str = banner;
            NullSerializable<String> currentBannerColorHex = loaded.getCurrentBannerColorHex();
            String strA = ((currentBannerColorHex instanceof NullSerializable.b) || (currentBannerColorHex instanceof NullSerializable.a)) ? currentBannerColorHex.a() : loaded.getUser().getBannerColor();
            boolean zIsPremium = UserUtils.INSTANCE.isPremium(loaded.getUser());
            boolean zIsVerified = loaded.getUser().isVerified();
            if (loaded.getMeMember() != null) {
                GuildMember meMember3 = loaded.getMeMember();
                if (loaded.getCurrentAvatar() != null) {
                    meMember3 = GuildMember.copy$default(meMember3, 0, 0L, null, null, null, false, null, 0L, 0L, loaded.getCurrentAvatar().a(), null, null, null, 7679, null);
                }
                GuildMember guildMemberCopy$default = meMember3;
                if (loaded.getCurrentBannerImage() != null) {
                    guildMemberCopy$default = GuildMember.copy$default(guildMemberCopy$default, 0, 0L, null, null, null, false, null, 0L, 0L, null, loaded.getCurrentBannerImage().a(), null, null, 7167, null);
                }
                meMember = guildMemberCopy$default;
            } else {
                meMember = loaded.getMeMember();
            }
            return new UserProfileHeaderViewModel.ViewState.Loaded(user, str, strA, meMember, null, null, null, userProfile, zIsPremium, zIsVerified, false, false, true, false, false, false, 58480, null);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveGuildMemberChanges$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildmember/GuildMember;", "apiMember", "", "invoke", "(Lcom/discord/api/guildmember/GuildMember;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveGuildMemberChanges$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<com.discord.api.guildmember.GuildMember, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guildmember.GuildMember guildMember) {
            invoke2(guildMember);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guildmember.GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(guildMember, "apiMember");
            EditUserOrGuildMemberProfileViewModel2.access$getStoreGuilds$p(EditUserOrGuildMemberProfileViewModel2.this).handleGuildMember(com.discord.api.guildmember.GuildMember.a(guildMember, EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this).longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this).longValue(), true);
            EditUserOrGuildMemberProfileViewModel2.access$updateViewState(EditUserOrGuildMemberProfileViewModel2.this, ViewState.Loaded.copy$default(this.$viewState, null, null, GuildMember.Companion.from$default(GuildMember.INSTANCE, guildMember, EditUserOrGuildMemberProfileViewModel2.access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2.this).longValue(), null, EditUserOrGuildMemberProfileViewModel2.access$getStoreGuilds$p(EditUserOrGuildMemberProfileViewModel2.this), 4, null), null, null, null, null, null, null, null, false, false, 3979, null));
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveUserChanges$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/User;", "apiUser", "", "invoke", "(Lcom/discord/api/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveUserChanges$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<User, Unit> {
        public final /* synthetic */ MeUser $meUser;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MeUser meUser, ViewState.Loaded loaded) {
            super(1);
            this.$meUser = meUser;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "apiUser");
            EditUserOrGuildMemberProfileViewModel2.access$getStoreUserProfile$p(EditUserOrGuildMemberProfileViewModel2.this).updateUser(user);
            EditUserOrGuildMemberProfileViewModel2.access$updateViewState(EditUserOrGuildMemberProfileViewModel2.this, ViewState.Loaded.copy$default(this.$viewState, MeUser.INSTANCE.merge(this.$meUser, user), null, null, null, null, null, null, null, null, null, false, false, 3982, null));
            PublishSubject publishSubjectAccess$getEventSubject$p = EditUserOrGuildMemberProfileViewModel2.access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    public /* synthetic */ EditUserOrGuildMemberProfileViewModel2(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, false, false, false, false, 28, null) : parser, (i & 64) != 0 ? Companion.observeStoreState$default(INSTANCE, l, null, null, null, 14, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.eventSubject;
    }

    public static final /* synthetic */ Long access$getGuildId$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.guildId;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.storeGuilds;
    }

    public static final /* synthetic */ StoreUserProfile access$getStoreUserProfile$p(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        return editUserOrGuildMemberProfileViewModel2.storeUserProfile;
    }

    public static final /* synthetic */ void access$handleStoreState(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2, StoreState storeState) {
        editUserOrGuildMemberProfileViewModel2.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2, ViewState viewState) {
        editUserOrGuildMemberProfileViewModel2.updateViewState(viewState);
    }

    private final List<Node<MessageRenderContext>> createAndProcessBioAstFromText(String bio) {
        List<Node<MessageRenderContext>> bio2 = parseBio(bio);
        createMessagePreprocessor().process(bio2);
        return bio2;
    }

    private final MessagePreprocessor createMessagePreprocessor() {
        return new MessagePreprocessor(-1L, this.revealedBioIndices, null, false, null, 28, null);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String bio;
        String str;
        MeUser user = storeState.getUser();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (bio = loaded.getCurrentBio()) == null) {
            GuildMember meMember = storeState.getMeMember();
            if (meMember != null) {
                bio = meMember.getBio();
                if (bio == null) {
                    bio = "";
                }
            } else {
                bio = null;
            }
        }
        if (bio == null) {
            bio = user.getBio();
        }
        String str2 = bio;
        List<Node<MessageRenderContext>> listCreateAndProcessBioAstFromText = str2 != null ? createAndProcessBioAstFromText(str2) : null;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        if (loaded2 == null || (nick = loaded2.getCurrentNickname()) == null) {
            GuildMember meMember2 = storeState.getMeMember();
            if (meMember2 != null) {
                String nick = meMember2.getNick();
                str = nick;
            } else {
                str = null;
            }
        } else {
            str = nick;
        }
        Guild guild = storeState.getGuild();
        UserProfile userProfile = storeState.getUserProfile();
        ViewState viewState3 = getViewState();
        ViewState.Loaded loaded3 = (ViewState.Loaded) (viewState3 instanceof ViewState.Loaded ? viewState3 : null);
        updateViewState(new ViewState.Loaded(user, guild, storeState.getMeMember(), userProfile, null, null, null, str, str2, listCreateAndProcessBioAstFromText, loaded3 != null ? loaded3.isEditingBio() : false, storeState.getGuildChannelsInfo().getCanChangeNickname(), 112, null));
    }

    private final List<Node<MessageRenderContext>> parseBio(String bio) {
        return Parser.parse$default(this.bioParser, bio, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void saveGuildMemberChanges(Context context) {
        Long l;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (l = this.guildId) == null) {
            return;
        }
        l.longValue();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateMeGuildMember(this.guildId.longValue(), new PatchGuildMemberBody(loaded.getCurrentNickname(), loaded.getCurrentAvatar(), loaded.getCurrentBannerImage(), loaded.getCurrentBio())), false, 1, null), this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(loaded), 52, (Object) null);
    }

    @MainThread
    private final void saveUserChanges(Context context) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            MeUser user = loaded.getUser();
            String currentBio = loaded.getCurrentBio();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(new PatchUserBody(loaded.getCurrentAvatar(), loaded.getCurrentBannerImage(), loaded.getCurrentBannerColorHex(), loaded.getIsBioChanged() ? currentBio != null ? new NullSerializable.b(currentBio) : new NullSerializable.a(null, 1) : null)), false, 1, null), this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(user, loaded), 52, (Object) null);
        }
    }

    @MainThread
    public final void handleBioIndexClicked(SpoilerNode<?> spoilerNode) {
        String currentBio;
        Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (currentBio = loaded.getCurrentBio()) == null) {
            return;
        }
        this.revealedBioIndices.add(Integer.valueOf(spoilerNode.getId()));
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, null, createAndProcessBioAstFromText(currentBio), false, false, 3583, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<UserProfileHeaderViewModel.ViewState> observeHeaderViewState() {
        Observable<UserProfileHeaderViewModel.ViewState> observableR = observeViewState().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeViewState().map {… }.distinctUntilChanged()");
        return observableR;
    }

    @MainThread
    public final void saveChanges(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (this.guildId != null) {
            saveGuildMemberChanges(context);
        } else {
            saveUserChanges(context);
        }
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, dataUrl != null ? new NullSerializable.b(dataUrl) : new NullSerializable.a(null, 1), null, null, null, null, null, false, false, 4079, null));
        }
    }

    @MainThread
    public final void updateBannerColor(String colorHex) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, colorHex != null ? new NullSerializable.b(colorHex) : new NullSerializable.a(null, 1), null, null, null, false, false, 4031, null));
        }
    }

    @MainThread
    public final void updateBannerImage(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, dataUrl != null ? new NullSerializable.b(dataUrl) : new NullSerializable.a(null, 1), null, null, null, null, false, false, 4063, null));
        }
    }

    @MainThread
    public final void updateBio(String bio) {
        Intrinsics3.checkNotNullParameter(bio, "bio");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null && (!Intrinsics3.areEqual(bio, loaded.getCurrentBio()))) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, bio, createAndProcessBioAstFromText(bio), false, false, 3327, null));
        }
    }

    @MainThread
    public final void updateIsEditingBio(boolean isEditing) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, null, null, isEditing, false, 3071, null));
        }
    }

    @MainThread
    public final void updateNickname(String nick) {
        Intrinsics3.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, nick, null, null, false, false, 3967, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserOrGuildMemberProfileViewModel2(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(parser, "bioParser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = l;
        this.storeUserProfile = storeUserProfile;
        this.storeGuilds = storeGuilds;
        this.restAPI = restAPI;
        this.bioParser = parser;
        this.eventSubject = PublishSubject.k0();
        Observable observableZ = ObservableExtensionsKt.computationLatest(storeUser.observeMe(false)).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeUser.observeMe(emit…Latest()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableZ, this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), EditUserOrGuildMemberProfileViewModel2.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        this.revealedBioIndices = new LinkedHashSet();
    }
}

package com.discord.widgets.guilds.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetChangeGuildIdentityViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00044567B%\u0012\n\u0010!\u001a\u00060\u001fj\u0002` \u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b2\u00103J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010!\u001a\u00060\u001fj\u0002` 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u0010/\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+¨\u00068"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", "nickname", "updateNickname", "(Ljava/lang/String;)V", "dataUrl", "updateAvatar", "clearStatus", "()V", "Landroid/content/Context;", "context", "saveMemberChanges", "(Landroid/content/Context;)V", "sourceSection", "Ljava/lang/String;", "getSourceSection", "()Ljava/lang/String;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "getGuildId", "()J", "", "trackedModalOpen", "Z", "getTrackedModalOpen", "()Z", "setTrackedModalOpen", "(Z)V", "Lrx/subjects/PublishSubject;", "eventSubject", "Lrx/subjects/PublishSubject;", "trackedUpsell", "getTrackedUpsell", "setTrackedUpsell", "<init>", "(JLjava/lang/String;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final String sourceSection;
    private boolean trackedModalOpen;
    private boolean trackedUpsell;

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$1, reason: invalid class name */
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
            WidgetChangeGuildIdentityViewModel.access$handleStoreState(WidgetChangeGuildIdentityViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreUser;", "storeUser", "Lrx/Observable;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds storeGuilds, StoreUser storeUser) {
            Observable<StoreState> observableH = Observable.h(GuildChannelsInfo.INSTANCE.get(guildId), storeGuilds.observeGuild(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null).Y(new WidgetChangeGuildIdentityViewModel2(guildId)), WidgetChangeGuildIdentityViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…uildChannelsInfo)\n      }");
            return observableH;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            if ((i & 4) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(j, storeGuilds, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event;", "", "<init>", "()V", "MemberUpdateFailed", "MemberUpdateSucceeded", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event$MemberUpdateSucceeded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event;", "", "component1", "()Ljava/lang/String;", "errorMessage", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getErrorMessage", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class MemberUpdateFailed extends Event {
            private final String errorMessage;

            public MemberUpdateFailed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public static /* synthetic */ MemberUpdateFailed copy$default(MemberUpdateFailed memberUpdateFailed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = memberUpdateFailed.errorMessage;
                }
                return memberUpdateFailed.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final MemberUpdateFailed copy(String errorMessage) {
                return new MemberUpdateFailed(errorMessage);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof MemberUpdateFailed) && Intrinsics3.areEqual(this.errorMessage, ((MemberUpdateFailed) other).errorMessage);
                }
                return true;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public int hashCode() {
                String str = this.errorMessage;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("MemberUpdateFailed(errorMessage="), this.errorMessage, ")");
            }
        }

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event$MemberUpdateSucceeded;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class MemberUpdateSucceeded extends Event {
            public static final MemberUpdateSucceeded INSTANCE = new MemberUpdateSucceeded();

            private MemberUpdateSucceeded() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ<\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\rR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/user/MeUser;", "component2", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "component4", "()Lcom/discord/utilities/channel/GuildChannelsInfo;", "guild", "meUser", "member", "guildChannelsInfo", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Lcom/discord/utilities/channel/GuildChannelsInfo;)Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "getGuildChannelsInfo", "Lcom/discord/models/member/GuildMember;", "getMember", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Lcom/discord/utilities/channel/GuildChannelsInfo;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final MeUser meUser;
        private final GuildMember member;

        public StoreState(Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            this.guild = guild;
            this.meUser = meUser;
            this.member = guildMember;
            this.guildChannelsInfo = guildChannelsInfo;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                meUser = storeState.meUser;
            }
            if ((i & 4) != 0) {
                guildMember = storeState.member;
            }
            if ((i & 8) != 0) {
                guildChannelsInfo = storeState.guildChannelsInfo;
            }
            return storeState.copy(guild, meUser, guildMember, guildChannelsInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildMember getMember() {
            return this.member;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreState copy(Guild guild, MeUser meUser, GuildMember member, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            return new StoreState(guild, meUser, member, guildChannelsInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.member, storeState.member) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final GuildMember getMember() {
            return this.member;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            MeUser meUser = this.meUser;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            GuildMember guildMember = this.member;
            int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            return iHashCode3 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(", member=");
            sbU.append(this.member);
            sbU.append(", guildChannelsInfo=");
            sbU.append(this.guildChannelsInfo);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Loading", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loading;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ`\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010&\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010\rR\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\rR\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b)\u0010\rR\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0010R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b-\u0010\u0010R\u0019\u0010.\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010\rR!\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u0010\u0013R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00102\u001a\u0004\b3\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00104\u001a\u0004\b5\u0010\u0004R\u0019\u00106\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b7\u0010\rR\u0019\u00108\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010'\u001a\u0004\b9\u0010\rR\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010:\u001a\u0004\b;\u0010\n¨\u0006>"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/user/MeUser;", "component2", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "", "component4", "()Z", "", "component5", "()Ljava/lang/String;", "Lcom/discord/nullserializable/NullSerializable;", "component6", "()Lcom/discord/nullserializable/NullSerializable;", "component7", "guild", "meUser", "member", "canChangeNickname", "currentNickname", "currentAvatar", "dimmed", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;ZLjava/lang/String;Lcom/discord/nullserializable/NullSerializable;Z)Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "isDirty", "Z", "getCanChangeNickname", "getDimmed", "displayedAvatarURL", "Ljava/lang/String;", "getDisplayedAvatarURL", "getCurrentNickname", "displayingGuildAvatar", "getDisplayingGuildAvatar", "Lcom/discord/nullserializable/NullSerializable;", "getCurrentAvatar", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/models/guild/Guild;", "getGuild", "showSaveFab", "getShowSaveFab", "shouldUpsell", "getShouldUpsell", "Lcom/discord/models/member/GuildMember;", "getMember", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;ZLjava/lang/String;Lcom/discord/nullserializable/NullSerializable;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canChangeNickname;
            private final NullSerializable<String> currentAvatar;
            private final String currentNickname;
            private final boolean dimmed;
            private final String displayedAvatarURL;
            private final boolean displayingGuildAvatar;
            private final Guild guild;
            private final boolean isDirty;
            private final MeUser meUser;
            private final GuildMember member;
            private final boolean shouldUpsell;
            private final boolean showSaveFab;

            public /* synthetic */ Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(guild, meUser, guildMember, z2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? false : z3);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = loaded.guild;
                }
                if ((i & 2) != 0) {
                    meUser = loaded.meUser;
                }
                MeUser meUser2 = meUser;
                if ((i & 4) != 0) {
                    guildMember = loaded.member;
                }
                GuildMember guildMember2 = guildMember;
                if ((i & 8) != 0) {
                    z2 = loaded.canChangeNickname;
                }
                boolean z4 = z2;
                if ((i & 16) != 0) {
                    str = loaded.currentNickname;
                }
                String str2 = str;
                if ((i & 32) != 0) {
                    nullSerializable = loaded.currentAvatar;
                }
                NullSerializable nullSerializable2 = nullSerializable;
                if ((i & 64) != 0) {
                    z3 = loaded.dimmed;
                }
                return loaded.copy(guild, meUser2, guildMember2, z4, str2, nullSerializable2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getMember() {
                return this.member;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getCanChangeNickname() {
                return this.canChangeNickname;
            }

            /* renamed from: component5, reason: from getter */
            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final NullSerializable<String> component6() {
                return this.currentAvatar;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getDimmed() {
                return this.dimmed;
            }

            public final Loaded copy(Guild guild, MeUser meUser, GuildMember member, boolean canChangeNickname, String currentNickname, NullSerializable<String> currentAvatar, boolean dimmed) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(member, "member");
                return new Loaded(guild, meUser, member, canChangeNickname, currentNickname, currentAvatar, dimmed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.meUser, loaded.meUser) && Intrinsics3.areEqual(this.member, loaded.member) && this.canChangeNickname == loaded.canChangeNickname && Intrinsics3.areEqual(this.currentNickname, loaded.currentNickname) && Intrinsics3.areEqual(this.currentAvatar, loaded.currentAvatar) && this.dimmed == loaded.dimmed;
            }

            public final boolean getCanChangeNickname() {
                return this.canChangeNickname;
            }

            public final NullSerializable<String> getCurrentAvatar() {
                return this.currentAvatar;
            }

            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final boolean getDimmed() {
                return this.dimmed;
            }

            public final String getDisplayedAvatarURL() {
                return this.displayedAvatarURL;
            }

            public final boolean getDisplayingGuildAvatar() {
                return this.displayingGuildAvatar;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final GuildMember getMember() {
                return this.member;
            }

            public final boolean getShouldUpsell() {
                return this.shouldUpsell;
            }

            public final boolean getShowSaveFab() {
                return this.showSaveFab;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                MeUser meUser = this.meUser;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                GuildMember guildMember = this.member;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                boolean z2 = this.canChangeNickname;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode3 + i) * 31;
                String str = this.currentNickname;
                int iHashCode4 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable = this.currentAvatar;
                int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
                boolean z3 = this.dimmed;
                return iHashCode5 + (z3 ? 1 : z3 ? 1 : 0);
            }

            /* renamed from: isDirty, reason: from getter */
            public final boolean getIsDirty() {
                return this.isDirty;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guild=");
                sbU.append(this.guild);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(", member=");
                sbU.append(this.member);
                sbU.append(", canChangeNickname=");
                sbU.append(this.canChangeNickname);
                sbU.append(", currentNickname=");
                sbU.append(this.currentNickname);
                sbU.append(", currentAvatar=");
                sbU.append(this.currentAvatar);
                sbU.append(", dimmed=");
                return outline.O(sbU, this.dimmed, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable<String> nullSerializable, boolean z3) {
                String forGuildMember$default;
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(guildMember, "member");
                this.guild = guild;
                this.meUser = meUser;
                this.member = guildMember;
                this.canChangeNickname = z2;
                this.currentNickname = str;
                this.currentAvatar = nullSerializable;
                this.dimmed = z3;
                String nick = guildMember.getNick();
                boolean z4 = (Intrinsics3.areEqual(nick == null ? "" : nick, str) ^ true) || nullSerializable != null;
                this.isDirty = z4;
                this.showSaveFab = z4;
                if (!(nullSerializable instanceof NullSerializable)) {
                    forGuildMember$default = guildMember.hasAvatar() ? IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, true, 2, null) : IconUtils.getForUser$default(meUser, true, null, 4, null);
                } else if (nullSerializable instanceof NullSerializable.b) {
                    forGuildMember$default = (String) ((NullSerializable.b) nullSerializable).a();
                } else {
                    if (!(nullSerializable instanceof NullSerializable.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    forGuildMember$default = IconUtils.getForUser$default(meUser, true, null, 4, null);
                }
                this.displayedAvatarURL = forGuildMember$default;
                this.displayingGuildAvatar = nullSerializable instanceof NullSerializable ? nullSerializable instanceof NullSerializable.b : guildMember.hasAvatar();
                this.shouldUpsell = !UserUtils.INSTANCE.isPremiumTier2(meUser);
            }
        }

        /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$saveMemberChanges$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x005f  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Error error) {
            String message;
            Intrinsics3.checkNotNullParameter(error, "it");
            Intrinsics3.checkNotNullExpressionValue(error.getResponse(), "it.response");
            if (!r0.getMessages().values().isEmpty()) {
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                Intrinsics3.checkNotNullExpressionValue(_Collections.first(response.getMessages().values()), "it.response.messages.values.first()");
                if (!((Collection) r0).isEmpty()) {
                    Error.Response response2 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response2, "it.response");
                    Object objFirst = _Collections.first(response2.getMessages().values());
                    Intrinsics3.checkNotNullExpressionValue(objFirst, "it.response.messages.values.first()");
                    message = (String) _Collections.first((List) objFirst);
                } else {
                    Error.Response response3 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response3, "it.response");
                    message = response3.getMessage();
                }
            }
            WidgetChangeGuildIdentityViewModel.access$getEventSubject$p(WidgetChangeGuildIdentityViewModel.this).k.onNext(new Event.MemberUpdateFailed(message));
            WidgetChangeGuildIdentityViewModel.access$updateViewState(WidgetChangeGuildIdentityViewModel.this, ViewState.Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
        }
    }

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildmember/GuildMember;", "it", "", "invoke", "(Lcom/discord/api/guildmember/GuildMember;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$saveMemberChanges$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(guildMember, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChangeGuildIdentityViewModel.access$getEventSubject$p(WidgetChangeGuildIdentityViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.MemberUpdateSucceeded.INSTANCE);
            WidgetChangeGuildIdentityViewModel.access$updateViewState(WidgetChangeGuildIdentityViewModel.this, ViewState.Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
        }
    }

    public /* synthetic */ WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel) {
        return widgetChangeGuildIdentityViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, StoreState storeState) {
        widgetChangeGuildIdentityViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, ViewState viewState) {
        widgetChangeGuildIdentityViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String nick;
        NullSerializable<String> currentAvatar;
        Guild guild = storeState.getGuild();
        GuildMember member = storeState.getMember();
        MeUser meUser = storeState.getMeUser();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        if (guild == null || member == null) {
            return;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (nick = loaded.getCurrentNickname()) == null) {
            nick = member.getNick();
        }
        String str = nick;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        updateViewState(new ViewState.Loaded(guild, meUser, member, guildChannelsInfo.getCanChangeNickname(), str, (loaded2 == null || (currentAvatar = loaded2.getCurrentAvatar()) == null) ? null : currentAvatar, false, 64, null));
    }

    @MainThread
    public final void clearStatus() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, "", null, false, 111, null));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getSourceSection() {
        return this.sourceSection;
    }

    public final boolean getTrackedModalOpen() {
        return this.trackedModalOpen;
    }

    public final boolean getTrackedUpsell() {
        return this.trackedUpsell;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveMemberChanges(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, null, null, true, 63, null));
            RestAPI restAPI = this.restAPI;
            long id2 = loaded.getGuild().getId();
            String currentNickname = loaded.getCurrentNickname();
            String nick = loaded.getMember().getNick();
            if (nick == null) {
                nick = "";
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.updateMeGuildMember(id2, new PatchGuildMemberBody(Intrinsics3.areEqual(currentNickname, nick) ^ true ? loaded.getCurrentNickname() : null, loaded.getCurrentAvatar(), null, null, 12)), false, 1, null), this, null, 2, null), WidgetChangeGuildIdentityViewModel.class, context, (Function1) null, new AnonymousClass1(loaded), (Function0) null, (Function0) null, new AnonymousClass2(loaded), 52, (Object) null);
        }
    }

    public final void setTrackedModalOpen(boolean z2) {
        this.trackedModalOpen = z2;
    }

    public final void setTrackedUpsell(boolean z2) {
        this.trackedUpsell = z2;
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, null, dataUrl != null ? new NullSerializable.b(dataUrl) : new NullSerializable.a(null, 1), false, 95, null));
        }
    }

    @MainThread
    public final void updateNickname(String nickname) {
        Intrinsics3.checkNotNullParameter(nickname, "nickname");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !(!Intrinsics3.areEqual(nickname, loaded.getCurrentNickname()))) {
            return;
        }
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, nickname, null, false, 111, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "sourceSection");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.sourceSection = str;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Companion.observeStoreState$default(INSTANCE, j, null, null, 6, null)), this, null, 2, null), WidgetChangeGuildIdentityViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

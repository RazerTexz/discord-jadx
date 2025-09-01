package com.discord.widgets.guilds.contextmenu;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GuildContextMenuViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !B-\u0012\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR:\u0010\u0010\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\t0\t \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\t0\t\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00060\u0015j\u0002`\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\""}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;", "observeEvents", "()Lrx/Observable;", "onMarkAsReadClicked", "()V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "storeStateObservable", "Lrx/Observable;", "getStoreStateObservable", "<init>", "(JLcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildContextMenuViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;

    /* compiled from: GuildContextMenuViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildContextMenuViewModel guildContextMenuViewModel) {
            super(1, guildContextMenuViewModel, GuildContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            GuildContextMenuViewModel.access$handleStoreState((GuildContextMenuViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreReadStates;", "readStateStore", "Lcom/discord/stores/StoreGuildSelected;", "selectedGuildStore", "Lrx/Observable;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreReadStates;Lcom/discord/stores/StoreGuildSelected;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, StoreReadStates storeReadStates, StoreGuildSelected storeGuildSelected) {
            return companion.observeStoreState(j, storeGuilds, storeUser, storeReadStates, storeGuildSelected);
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreUser userStore, StoreReadStates readStateStore, StoreGuildSelected selectedGuildStore) {
            Observable<StoreState> observableH = Observable.h(guildStore.observeGuild(guildId), StoreUser.observeMe$default(userStore, false, 1, null), readStateStore.getIsUnread(guildId), selectedGuildStore.observeSelectedGuildId(), GuildContextMenuViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…      )\n        }\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;", "", "<init>", "()V", "Dismiss", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event$Dismiss;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: GuildContextMenuViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event$Dismiss;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: GuildContextMenuViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState$Invalid;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildContextMenuViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\n\u0010\u0011\u001a\u00060\u0005j\u0002`\f¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\r\u001a\u00060\u0005j\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\bJ@\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\f\b\u0002\u0010\u000f\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\f\b\u0002\u0010\u0011\u001a\u00060\u0005j\u0002`\fHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u0010\u0010\u000bR\u001d\u0010\u0011\u001a\u00060\u0005j\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\bR\u001d\u0010\u000f\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\bR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "", "component3", "()Z", "Lcom/discord/primitives/GuildId;", "component4", "guild", "myUserId", "isGuildUnread", "selectedGuildId", "copy", "(Lcom/discord/models/guild/Guild;JZJ)Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "J", "getSelectedGuildId", "getMyUserId", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;JZJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final boolean isGuildUnread;
            private final long myUserId;
            private final long selectedGuildId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, long j, boolean z2, long j2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.myUserId = j;
                this.isGuildUnread = z2;
                this.selectedGuildId = j2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, long j, boolean z2, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    j = valid.myUserId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    z2 = valid.isGuildUnread;
                }
                boolean z3 = z2;
                if ((i & 8) != 0) {
                    j2 = valid.selectedGuildId;
                }
                return valid.copy(guild, j3, z3, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsGuildUnread() {
                return this.isGuildUnread;
            }

            /* renamed from: component4, reason: from getter */
            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            public final Valid copy(Guild guild, long myUserId, boolean isGuildUnread, long selectedGuildId) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, myUserId, isGuildUnread, selectedGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.myUserId == valid.myUserId && this.isGuildUnread == valid.isGuildUnread && this.selectedGuildId == valid.selectedGuildId;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iA = (b.a(this.myUserId) + ((guild != null ? guild.hashCode() : 0) * 31)) * 31;
                boolean z2 = this.isGuildUnread;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return b.a(this.selectedGuildId) + ((iA + i) * 31);
            }

            public final boolean isGuildUnread() {
                return this.isGuildUnread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", isGuildUnread=");
                sbU.append(this.isGuildUnread);
                sbU.append(", selectedGuildId=");
                return outline.C(sbU, this.selectedGuildId, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Valid;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildContextMenuViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildContextMenuViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\r\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Valid;", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()Z", "component3", "component4", "guild", "showMarkAsRead", "showLeaveGuild", "isGuildSelected", "copy", "(Lcom/discord/models/guild/Guild;ZZZ)Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$ViewState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getShowLeaveGuild", "getShowMarkAsRead", "<init>", "(Lcom/discord/models/guild/Guild;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;
            private final boolean isGuildSelected;
            private final boolean showLeaveGuild;
            private final boolean showMarkAsRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.showMarkAsRead = z2;
                this.showLeaveGuild = z3;
                this.isGuildSelected = z4;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.showMarkAsRead;
                }
                if ((i & 4) != 0) {
                    z3 = valid.showLeaveGuild;
                }
                if ((i & 8) != 0) {
                    z4 = valid.isGuildSelected;
                }
                return valid.copy(guild, z2, z3, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getShowLeaveGuild() {
                return this.showLeaveGuild;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsGuildSelected() {
                return this.isGuildSelected;
            }

            public final Valid copy(Guild guild, boolean showMarkAsRead, boolean showLeaveGuild, boolean isGuildSelected) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, showMarkAsRead, showLeaveGuild, isGuildSelected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.showMarkAsRead == valid.showMarkAsRead && this.showLeaveGuild == valid.showLeaveGuild && this.isGuildSelected == valid.isGuildSelected;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getShowLeaveGuild() {
                return this.showLeaveGuild;
            }

            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.showMarkAsRead;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.showLeaveGuild;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isGuildSelected;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isGuildSelected() {
                return this.isGuildSelected;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", showMarkAsRead=");
                sbU.append(this.showMarkAsRead);
                sbU.append(", showLeaveGuild=");
                sbU.append(this.showLeaveGuild);
                sbU.append(", isGuildSelected=");
                return outline.O(sbU, this.isGuildSelected, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$onMarkAsReadClicked$1, reason: invalid class name */
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
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = GuildContextMenuViewModel.access$getEventSubject$p(GuildContextMenuViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, j, companion2.getGuilds(), companion2.getUsers(), companion2.getReadStates(), companion2.getGuildSelected());
        }
        this(j, restAPI, observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(GuildContextMenuViewModel guildContextMenuViewModel) {
        return guildContextMenuViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(GuildContextMenuViewModel guildContextMenuViewModel, StoreState storeState) {
        guildContextMenuViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            updateViewState(new ViewState.Valid(valid.getGuild(), valid.isGuildUnread(), valid.getGuild().getOwnerId() != valid.getMyUserId(), valid.getSelectedGuildId() == valid.getGuild().getId()));
        } else if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(this.guildId), false, 1, null), this, null, 2, null), GuildContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GuildContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

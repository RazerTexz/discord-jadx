package com.discord.widgets.guilds.leave;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
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

/* compiled from: LeaveGuildDialogViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004!\"#$B7\u0012\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00060\u0013j\u0002`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R:\u0010\u001c\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\f0\f \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\f0\f\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;", "", "onLeaveSucceeded", "()V", "onLeaveFailed", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;", "observeEvents", "()Lrx/Observable;", "leaveGuild", "Lcom/discord/stores/StoreLurking;", "lurkingStore", "Lcom/discord/stores/StoreLurking;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "storeStateObservable", "<init>", "(JLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreLurking;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final StoreLurking lurkingStore;
    private final RestAPI restAPI;

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
            super(1, leaveGuildDialogViewModel, LeaveGuildDialogViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            LeaveGuildDialogViewModel.access$handleStoreState((LeaveGuildDialogViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreLurking;", "lurkingStore", "Lrx/Observable;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreLurking;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreGuilds storeGuilds, StoreLurking storeLurking) {
            return companion.observeStoreState(j, storeGuilds, storeLurking);
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreLurking lurkingStore) {
            Observable<StoreState> observableJ = Observable.j(guildStore.observeGuild(guildId), lurkingStore.isLurkingObs(guildId), LeaveGuildDialogViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…urking)\n        }\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;", "", "<init>", "()V", "Dismiss", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event$Dismiss;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: LeaveGuildDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event$Dismiss;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: LeaveGuildDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState$Invalid;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: LeaveGuildDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState$Valid;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()Z", "guild", "isLurking", "copy", "(Lcom/discord/models/guild/Guild;Z)Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "<init>", "(Lcom/discord/models/guild/Guild;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final boolean isLurking;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.isLurking = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.isLurking;
                }
                return valid.copy(guild, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            public final Valid copy(Guild guild, boolean isLurking) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, isLurking);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.isLurking == valid.isLurking;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isLurking;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", isLurking=");
                return outline.O(sbU, this.isLurking, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState$Valid;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: LeaveGuildDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: LeaveGuildDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState$Valid;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()Z", "component3", "guild", "isLoading", "isLurking", "copy", "(Lcom/discord/models/guild/Guild;ZZ)Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;
            private final boolean isLoading;
            private final boolean isLurking;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.isLoading = z2;
                this.isLurking = z3;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.isLoading;
                }
                if ((i & 4) != 0) {
                    z3 = valid.isLurking;
                }
                return valid.copy(guild, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            public final Valid copy(Guild guild, boolean isLoading, boolean isLurking) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, isLoading, isLurking);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.isLoading == valid.isLoading && this.isLurking == valid.isLurking;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isLoading;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isLurking;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", isLoading=");
                sbU.append(this.isLoading);
                sbU.append(", isLurking=");
                return outline.O(sbU, this.isLurking, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LeaveGuildDialogViewModel.access$onLeaveSucceeded(LeaveGuildDialogViewModel.this);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LeaveGuildDialogViewModel.access$onLeaveFailed(LeaveGuildDialogViewModel.this);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            LeaveGuildDialogViewModel.access$onLeaveSucceeded(LeaveGuildDialogViewModel.this);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass4() {
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
            LeaveGuildDialogViewModel.access$onLeaveFailed(LeaveGuildDialogViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreLurking lurking = (i & 4) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking;
        this(j, api, lurking, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, j, StoreStream.INSTANCE.getGuilds(), lurking) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(LeaveGuildDialogViewModel leaveGuildDialogViewModel, StoreState storeState) {
        leaveGuildDialogViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onLeaveFailed(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        leaveGuildDialogViewModel.onLeaveFailed();
    }

    public static final /* synthetic */ void access$onLeaveSucceeded(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        leaveGuildDialogViewModel.onLeaveSucceeded();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        boolean zIsLoading = valid != null ? valid.isLoading() : false;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid2 = (StoreState.Valid) storeState;
            updateViewState(new ViewState.Valid(valid2.getGuild(), zIsLoading, valid2.isLurking()));
        } else if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    @MainThread
    private final void onLeaveFailed() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, false, false, 5, null));
        }
    }

    @MainThread
    private final void onLeaveSucceeded() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    @MainThread
    public final void leaveGuild() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, true, false, 5, null));
            if (valid.isLurking()) {
                this.lurkingStore.stopLurking(valid.getGuild().getId(), new AnonymousClass1(), new AnonymousClass2());
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), LeaveGuildDialogViewModel.class, (Context) null, (Function1) null, new AnonymousClass4(), (Function0) null, (Function0) null, new AnonymousClass3(), 54, (Object) null);
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeLurking, "lurkingStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.lurkingStore = storeLurking;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), LeaveGuildDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

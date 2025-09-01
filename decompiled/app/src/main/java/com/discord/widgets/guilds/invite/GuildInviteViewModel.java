package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildInviteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003!\"#B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "Lcom/discord/app/AppComponent;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;)V", "fetchInviteIfNotLoaded", "()V", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "inviteCode", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "getInviteCode", "()Lcom/discord/stores/StoreInviteSettings$InviteCode;", "", "inviteResolved", "Z", "getInviteResolved", "()Z", "setInviteResolved", "(Z)V", "Lrx/Observable;", "storeStateObservable", "Lrx/Observable;", "getStoreStateObservable", "()Lrx/Observable;", "Lcom/discord/stores/StoreInstantInvites;", "instantInvitesStore", "Lcom/discord/stores/StoreInstantInvites;", "<init>", "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Lcom/discord/stores/StoreInstantInvites;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildInviteViewModel extends AppViewModel<ViewState> implements AppComponent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreInstantInvites instantInvitesStore;
    private final StoreInviteSettings.InviteCode inviteCode;
    private boolean inviteResolved;
    private final Observable<StoreState> storeStateObservable;

    /* compiled from: GuildInviteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$1, reason: invalid class name */
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
            GuildInviteViewModel.access$handleStoreState(GuildInviteViewModel.this, storeState);
        }
    }

    /* compiled from: GuildInviteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$Companion;", "", "Lcom/discord/stores/StoreInstantInvites;", "instantInvitesStore", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "inviteCode", "Lrx/Observable;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreInstantInvites;Lcom/discord/stores/StoreInviteSettings$InviteCode;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreInstantInvites storeInstantInvites, StoreInviteSettings.InviteCode inviteCode) {
            return companion.observeStoreState(storeInstantInvites, inviteCode);
        }

        private final Observable<StoreState> observeStoreState(StoreInstantInvites instantInvitesStore, StoreInviteSettings.InviteCode inviteCode) {
            if (inviteCode == null) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(StoreState.Invalid.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(StoreState.Invalid)");
                return scalarSynchronousObservable;
            }
            Observable observableG = instantInvitesStore.observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId())).G(GuildInviteViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "instantInvitesStore\n    …            }\n          }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildInviteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Loaded", "Loading", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Loading;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Invalid;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Invalid;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Loaded;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "invite", "copy", "(Lcom/discord/models/domain/ModelInvite;)Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "<init>", "(Lcom/discord/models/domain/ModelInvite;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends StoreState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelInvite modelInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = loaded.invite;
                }
                return loaded.copy(modelInvite);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Loaded copy(ModelInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.invite, ((Loaded) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState$Loading;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends StoreState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildInviteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Loading", "Uninitialized", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "invite", "copy", "(Lcom/discord/models/domain/ModelInvite;)Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "<init>", "(Lcom/discord/models/domain/ModelInvite;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelInvite modelInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = loaded.invite;
                }
                return loaded.copy(modelInvite);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Loaded copy(ModelInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.invite, ((Loaded) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loading;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: GuildInviteViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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
    }

    /* compiled from: GuildInviteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$fetchInviteIfNotLoaded$1, reason: invalid class name */
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
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Failed to resolve invite[");
            sbU.append(GuildInviteViewModel.this.getInviteCode().getInviteCode());
            sbU.append("] from ");
            sbU.append(GuildInviteViewModel.this.getInviteCode().getSource());
            Logger.d$default(appLog, sbU.toString(), null, 2, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteViewModel(StoreInviteSettings.InviteCode inviteCode, StoreInstantInvites storeInstantInvites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeInstantInvites = (i & 2) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites;
        this(inviteCode, storeInstantInvites, (i & 4) != 0 ? Companion.access$observeStoreState(INSTANCE, storeInstantInvites, inviteCode) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteViewModel guildInviteViewModel, StoreState storeState) {
        guildInviteViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Loading) {
            updateViewState(ViewState.Loading.INSTANCE);
        } else if (storeState instanceof StoreState.Invalid) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else if (storeState instanceof StoreState.Loaded) {
            updateViewState(new ViewState.Loaded(((StoreState.Loaded) storeState).getInvite()));
        }
    }

    public final void fetchInviteIfNotLoaded() {
        if (this.inviteCode == null) {
            return;
        }
        StoreStream.INSTANCE.getInstantInvites().fetchInviteIfNotLoaded(this.inviteCode.getInviteCode(), this.inviteCode.getEventId(), this.inviteCode.getSource(), Boolean.valueOf(this.inviteResolved), new AnonymousClass1());
    }

    public final StoreInviteSettings.InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public final boolean getInviteResolved() {
        return this.inviteResolved;
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final void setInviteResolved(boolean z2) {
        this.inviteResolved = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel(StoreInviteSettings.InviteCode inviteCode, StoreInstantInvites storeInstantInvites, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "instantInvitesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.inviteCode = inviteCode;
        this.instantInvitesStore = storeInstantInvites;
        this.storeStateObservable = observable;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

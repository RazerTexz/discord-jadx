package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.media.AudioAttributesCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetAgeVerifyViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005*+,-.B+\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010%\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u000f0\u000f $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006/"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$ViewState;", "", "handleUserUpdateSuccess", "()V", "Lcom/discord/utilities/error/Error;", "error", "handleUserUpdateFailure", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Event;", "observeEvents", "()Lrx/Observable;", "onConfirmBackClicked", "", "backToSafety", "()Z", "", "dateOfBirth", "setDateOfBirth", "(J)V", "isNSFWChannel", "submit", "(Z)V", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreAuthentication;", "storeAuth", "Lcom/discord/stores/StoreAuthentication;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventsSubject", "Lrx/subjects/PublishSubject;", "storeObservable", "<init>", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreAuthentication;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "Views", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventsSubject;
    private final RestAPI restAPI;
    private final StoreAuthentication storeAuth;

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$1, reason: invalid class name */
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
            WidgetAgeVerifyViewModel.access$handleStoreState(WidgetAgeVerifyViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableI = Observable.i(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), companion.getChannelsSelected().observeSelectedChannel().Y(WidgetAgeVerifyViewModel2.INSTANCE), WidgetAgeVerifyViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…hed\n          )\n        }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Event;", "", "<init>", "()V", "Verified", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Event$Verified;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetAgeVerifyViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Event$Verified;", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Verified extends Event {
            public static final Verified INSTANCE = new Verified();

            private Verified() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/user/NsfwAllowance;", "component2", "()Lcom/discord/api/user/NsfwAllowance;", "", "component3", "()Z", "safeChannel", "nsfwAllowed", "authed", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/user/NsfwAllowance;Z)Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAuthed", "Lcom/discord/api/channel/Channel;", "getSafeChannel", "Lcom/discord/api/user/NsfwAllowance;", "getNsfwAllowed", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/user/NsfwAllowance;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean authed;
        private final NsfwAllowance nsfwAllowed;
        private final Channel safeChannel;

        public StoreState(Channel channel, NsfwAllowance nsfwAllowance, boolean z2) {
            Intrinsics3.checkNotNullParameter(nsfwAllowance, "nsfwAllowed");
            this.safeChannel = channel;
            this.nsfwAllowed = nsfwAllowance;
            this.authed = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, NsfwAllowance nsfwAllowance, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.safeChannel;
            }
            if ((i & 2) != 0) {
                nsfwAllowance = storeState.nsfwAllowed;
            }
            if ((i & 4) != 0) {
                z2 = storeState.authed;
            }
            return storeState.copy(channel, nsfwAllowance, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        /* renamed from: component2, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAuthed() {
            return this.authed;
        }

        public final StoreState copy(Channel safeChannel, NsfwAllowance nsfwAllowed, boolean authed) {
            Intrinsics3.checkNotNullParameter(nsfwAllowed, "nsfwAllowed");
            return new StoreState(safeChannel, nsfwAllowed, authed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.safeChannel, storeState.safeChannel) && Intrinsics3.areEqual(this.nsfwAllowed, storeState.nsfwAllowed) && this.authed == storeState.authed;
        }

        public final boolean getAuthed() {
            return this.authed;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.safeChannel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            int iHashCode2 = (iHashCode + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
            boolean z2 = this.authed;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(safeChannel=");
            sbU.append(this.safeChannel);
            sbU.append(", nsfwAllowed=");
            sbU.append(this.nsfwAllowed);
            sbU.append(", authed=");
            return outline.O(sbU, this.authed, ")");
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J^\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u000fJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\tJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b\u0014\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010)R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\tR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\f\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$ViewState;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/Integer;", "component3", "()I", "", "component4", "()Ljava/lang/Long;", "", "component5", "()Ljava/lang/String;", "Lcom/discord/api/channel/Channel;", "component6", "()Lcom/discord/api/channel/Channel;", "component7", "isSubmitting", "errorStringId", "displayedChild", "dateOfBirth", "underageMessage", "safeChannel", "shouldClose", "copy", "(ZLjava/lang/Integer;ILjava/lang/Long;Ljava/lang/String;Lcom/discord/api/channel/Channel;Z)Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$ViewState;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShouldClose", "Ljava/lang/Integer;", "getErrorStringId", "Ljava/lang/String;", "getUnderageMessage", "setUnderageMessage", "(Ljava/lang/String;)V", "I", "getDisplayedChild", "Lcom/discord/api/channel/Channel;", "getSafeChannel", "Ljava/lang/Long;", "getDateOfBirth", "setDateOfBirth", "(Ljava/lang/Long;)V", "<init>", "(ZLjava/lang/Integer;ILjava/lang/Long;Ljava/lang/String;Lcom/discord/api/channel/Channel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private Long dateOfBirth;
        private final int displayedChild;
        private final Integer errorStringId;
        private final boolean isSubmitting;
        private final Channel safeChannel;
        private final boolean shouldClose;
        private String underageMessage;

        public ViewState(boolean z2, Integer num, int i, Long l, String str, Channel channel, boolean z3) {
            this.isSubmitting = z2;
            this.errorStringId = num;
            this.displayedChild = i;
            this.dateOfBirth = l;
            this.underageMessage = str;
            this.safeChannel = channel;
            this.shouldClose = z3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Integer num, int i, Long l, String str, Channel channel, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isSubmitting;
            }
            if ((i2 & 2) != 0) {
                num = viewState.errorStringId;
            }
            Integer num2 = num;
            if ((i2 & 4) != 0) {
                i = viewState.displayedChild;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                l = viewState.dateOfBirth;
            }
            Long l2 = l;
            if ((i2 & 16) != 0) {
                str = viewState.underageMessage;
            }
            String str2 = str;
            if ((i2 & 32) != 0) {
                channel = viewState.safeChannel;
            }
            Channel channel2 = channel;
            if ((i2 & 64) != 0) {
                z3 = viewState.shouldClose;
            }
            return viewState.copy(z2, num2, i3, l2, str2, channel2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getErrorStringId() {
            return this.errorStringId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getDisplayedChild() {
            return this.displayedChild;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getDateOfBirth() {
            return this.dateOfBirth;
        }

        /* renamed from: component5, reason: from getter */
        public final String getUnderageMessage() {
            return this.underageMessage;
        }

        /* renamed from: component6, reason: from getter */
        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getShouldClose() {
            return this.shouldClose;
        }

        public final ViewState copy(boolean isSubmitting, Integer errorStringId, int displayedChild, Long dateOfBirth, String underageMessage, Channel safeChannel, boolean shouldClose) {
            return new ViewState(isSubmitting, errorStringId, displayedChild, dateOfBirth, underageMessage, safeChannel, shouldClose);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isSubmitting == viewState.isSubmitting && Intrinsics3.areEqual(this.errorStringId, viewState.errorStringId) && this.displayedChild == viewState.displayedChild && Intrinsics3.areEqual(this.dateOfBirth, viewState.dateOfBirth) && Intrinsics3.areEqual(this.underageMessage, viewState.underageMessage) && Intrinsics3.areEqual(this.safeChannel, viewState.safeChannel) && this.shouldClose == viewState.shouldClose;
        }

        public final Long getDateOfBirth() {
            return this.dateOfBirth;
        }

        public final int getDisplayedChild() {
            return this.displayedChild;
        }

        public final Integer getErrorStringId() {
            return this.errorStringId;
        }

        public final Channel getSafeChannel() {
            return this.safeChannel;
        }

        public final boolean getShouldClose() {
            return this.shouldClose;
        }

        public final String getUnderageMessage() {
            return this.underageMessage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public int hashCode() {
            boolean z2 = this.isSubmitting;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.errorStringId;
            int iHashCode = (((i + (num != null ? num.hashCode() : 0)) * 31) + this.displayedChild) * 31;
            Long l = this.dateOfBirth;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.underageMessage;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Channel channel = this.safeChannel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z3 = this.shouldClose;
            return iHashCode4 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public final void setDateOfBirth(Long l) {
            this.dateOfBirth = l;
        }

        public final void setUnderageMessage(String str) {
            this.underageMessage = str;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", errorStringId=");
            sbU.append(this.errorStringId);
            sbU.append(", displayedChild=");
            sbU.append(this.displayedChild);
            sbU.append(", dateOfBirth=");
            sbU.append(this.dateOfBirth);
            sbU.append(", underageMessage=");
            sbU.append(this.underageMessage);
            sbU.append(", safeChannel=");
            sbU.append(this.safeChannel);
            sbU.append(", shouldClose=");
            return outline.O(sbU, this.shouldClose, ")");
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$Views;", "", "", "VIEW_AGE_GATED", "I", "VIEW_AGE_CONFIRM", "VIEW_AGE_VERIFY", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Views {
        public static final Views INSTANCE = new Views();
        public static final int VIEW_AGE_CONFIRM = 1;
        public static final int VIEW_AGE_GATED = 2;
        public static final int VIEW_AGE_VERIFY = 0;

        private Views() {
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/User;", "it", "", "invoke", "(Lcom/discord/api/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$submit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "it");
            WidgetAgeVerifyViewModel.access$handleUserUpdateSuccess(WidgetAgeVerifyViewModel.this);
        }
    }

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$submit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
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
            WidgetAgeVerifyViewModel.access$handleUserUpdateFailure(WidgetAgeVerifyViewModel.this, error);
        }
    }

    public WidgetAgeVerifyViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetAgeVerifyViewModel(RestAPI restAPI, StoreAuthentication storeAuthentication, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 2) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication, (i & 4) != 0 ? INSTANCE.observeStores() : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel, StoreState storeState) {
        widgetAgeVerifyViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$handleUserUpdateFailure(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel, Error error) {
        widgetAgeVerifyViewModel.handleUserUpdateFailure(error);
    }

    public static final /* synthetic */ void access$handleUserUpdateSuccess(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel) {
        widgetAgeVerifyViewModel.handleUserUpdateSuccess();
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, null, null, storeState.getSafeChannel(), (storeState.getAuthed() && storeState.getNsfwAllowed() == NsfwAllowance.UNKNOWN) ? false : true, 31, null));
        }
    }

    @MainThread
    private final void handleUserUpdateFailure(Error error) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
            if (!messages.containsKey(BirthdayHelper.DATE_OF_BIRTH_KEY)) {
                updateViewState(ViewState.copy$default(viewState, false, Integer.valueOf(R.string.age_gate_failed_to_update_birthday), 0, null, null, null, false, 124, null));
                return;
            }
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            Map<String, List<String>> messages2 = response2.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages2, "error.response.messages");
            List<String> listEmptyList = messages2.get(BirthdayHelper.DATE_OF_BIRTH_KEY);
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            Intrinsics3.checkNotNullExpressionValue(listEmptyList, "error.response.messages\n…IRTH_KEY) { emptyList() }");
            String strJoinToString$default = _Collections.joinToString$default(listEmptyList, "\n", null, null, 0, null, null, 62, null);
            updateViewState(ViewState.copy$default(viewState, false, null, 2, null, strJoinToString$default, null, false, 106, null));
            this.storeAuth.setAgeGateError(strJoinToString$default);
        }
    }

    @MainThread
    private final void handleUserUpdateSuccess() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, null, null, null, false, 126, null));
            PublishSubject<Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(Event.Verified.INSTANCE);
        }
    }

    @MainThread
    public final boolean backToSafety() {
        ViewState viewState = getViewState();
        Channel safeChannel = viewState != null ? viewState.getSafeChannel() : null;
        if (safeChannel == null) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, 0L, null, null, 12, null);
            return true;
        }
        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), safeChannel, null, null, 6, null);
        return false;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConfirmBackClicked() {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, null, null, null, false, 123, null));
        }
    }

    @MainThread
    public final void setDateOfBirth(long dateOfBirth) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, null, 0, Long.valueOf(dateOfBirth), null, null, false, 119, null));
        }
    }

    @MainThread
    public final void submit(boolean isNSFWChannel) {
        Long dateOfBirth;
        ViewState viewState = getViewState();
        if (viewState == null || (dateOfBirth = viewState.getDateOfBirth()) == null) {
            return;
        }
        long jLongValue = dateOfBirth.longValue();
        boolean z2 = BirthdayHelper.INSTANCE.getAge(jLongValue) < 18;
        if (isNSFWChannel && z2 && viewState.getDisplayedChild() == 0) {
            updateViewState(ViewState.copy$default(viewState, false, null, 1, null, null, null, false, 123, null));
            return;
        }
        RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, null, null, null, null, null, null, null, TimeUtils.toUTCDateTime(Long.valueOf(jLongValue), TimeUtils.UTCFormat.SHORT), AudioAttributesCompat.FLAG_ALL, null);
        updateViewState(ViewState.copy$default(viewState, true, null, 0, null, null, null, false, 124, null));
        AnalyticsTracker.INSTANCE.ageGateSubmitted(jLongValue, isNSFWChannel ? "NSFW Channel" : "Public Server");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(userInfo), false, 1, null), this, null, 2, null), WidgetAgeVerifyViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerifyViewModel(RestAPI restAPI, StoreAuthentication storeAuthentication, Observable<StoreState> observable) {
        super(new ViewState(false, null, 0, null, null, null, false));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeAuthentication, "storeAuth");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.restAPI = restAPI;
        this.storeAuth = storeAuthentication;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetAgeVerifyViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

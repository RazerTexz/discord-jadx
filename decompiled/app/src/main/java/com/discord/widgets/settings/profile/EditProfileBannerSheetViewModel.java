package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.user.UserProfile;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: EditProfileBannerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB)\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;", "Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;)V", "", "colorHex", "updateColorPreview", "(Ljava/lang/String;)V", "", "upsellViewedTracked", "Z", "getUpsellViewedTracked", "()Z", "setUpsellViewedTracked", "(Z)V", "initialColorPreviewHex", "Ljava/lang/String;", "defaultBannerColorHex", "Lrx/Observable;", "storeStateObservable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String defaultBannerColorHex;
    private final String initialColorPreviewHex;
    private boolean upsellViewedTracked;

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel$1, reason: invalid class name */
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
            EditProfileBannerSheetViewModel editProfileBannerSheetViewModel = EditProfileBannerSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            EditProfileBannerSheetViewModel.access$handleStoreState(editProfileBannerSheetViewModel, storeState);
        }
    }

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$Companion;", "", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "Lrx/Observable;", "Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserProfile;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreUser storeUser, StoreUserProfile storeUserProfile) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{StoreUser.INSTANCE.getMeUpdate(), storeUserProfile}, false, null, null, new EditProfileBannerSheetViewModel2(storeUser, storeUserProfile), 14, null);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            if ((i & 2) != 0) {
                storeUserProfile = StoreStream.INSTANCE.getUserProfile();
            }
            return companion.observeStoreState(storeUser, storeUserProfile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/api/user/UserProfile;", "component2", "()Lcom/discord/api/user/UserProfile;", "user", "userProfile", "copy", "(Lcom/discord/models/user/User;Lcom/discord/api/user/UserProfile;)Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/api/user/UserProfile;", "getUserProfile", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/api/user/UserProfile;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final User user;
        private final UserProfile userProfile;

        public StoreState(User user, UserProfile userProfile) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            this.user = user;
            this.userProfile = userProfile;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, UserProfile userProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.user;
            }
            if ((i & 2) != 0) {
                userProfile = storeState.userProfile;
            }
            return storeState.copy(user, userProfile);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public final StoreState copy(User user, UserProfile userProfile) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            return new StoreState(user, userProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile);
        }

        public final User getUser() {
            return this.user;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            UserProfile userProfile = this.userProfile;
            return iHashCode + (userProfile != null ? userProfile.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "bannerColorHex", "showPremiumUpsell", "copy", "(Ljava/lang/String;Z)Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBannerColorHex", "Z", "getShowPremiumUpsell", "<init>", "(Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final String bannerColorHex;
        private final boolean showPremiumUpsell;

        public ViewState(String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "bannerColorHex");
            this.bannerColorHex = str;
            this.showPremiumUpsell = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewState.bannerColorHex;
            }
            if ((i & 2) != 0) {
                z2 = viewState.showPremiumUpsell;
            }
            return viewState.copy(str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBannerColorHex() {
            return this.bannerColorHex;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowPremiumUpsell() {
            return this.showPremiumUpsell;
        }

        public final ViewState copy(String bannerColorHex, boolean showPremiumUpsell) {
            Intrinsics3.checkNotNullParameter(bannerColorHex, "bannerColorHex");
            return new ViewState(bannerColorHex, showPremiumUpsell);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.bannerColorHex, viewState.bannerColorHex) && this.showPremiumUpsell == viewState.showPremiumUpsell;
        }

        public final String getBannerColorHex() {
            return this.bannerColorHex;
        }

        public final boolean getShowPremiumUpsell() {
            return this.showPremiumUpsell;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.bannerColorHex;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.showPremiumUpsell;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(bannerColorHex=");
            sbU.append(this.bannerColorHex);
            sbU.append(", showPremiumUpsell=");
            return outline.O(sbU, this.showPremiumUpsell, ")");
        }
    }

    public /* synthetic */ EditProfileBannerSheetViewModel(String str, String str2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, 3, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(EditProfileBannerSheetViewModel editProfileBannerSheetViewModel, StoreState storeState) {
        editProfileBannerSheetViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        String bannerColorHex = viewState != null ? viewState.getBannerColorHex() : null;
        User user = storeState.getUser();
        if (bannerColorHex == null) {
            bannerColorHex = this.initialColorPreviewHex;
        }
        if (bannerColorHex == null) {
            bannerColorHex = this.defaultBannerColorHex;
        }
        updateViewState(new ViewState(bannerColorHex, !UserUtils.INSTANCE.isPremiumTier2(user)));
    }

    public final boolean getUpsellViewedTracked() {
        return this.upsellViewedTracked;
    }

    public final void setUpsellViewedTracked(boolean z2) {
        this.upsellViewedTracked = z2;
    }

    @MainThread
    public final void updateColorPreview(String colorHex) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (colorHex == null) {
                colorHex = this.defaultBannerColorHex;
            }
            updateViewState(ViewState.copy$default(viewState, colorHex, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel(String str, String str2, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(str, "defaultBannerColorHex");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.defaultBannerColorHex = str;
        this.initialColorPreviewHex = str2;
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), EditProfileBannerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

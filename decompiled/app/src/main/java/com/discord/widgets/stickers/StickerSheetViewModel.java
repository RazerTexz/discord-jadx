package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B=\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/discord/widgets/stickers/StickerSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;", "", "fetchStickersData", "()V", "Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;)V", "handleLoadedStoreState", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Ljava/lang/String;", "", "hasFiredAnalytics", "Z", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreStickers;", "storeStickers", "Lcom/discord/stores/StoreStickers;", "Lcom/discord/api/sticker/Sticker;", "sticker", "Lcom/discord/api/sticker/Sticker;", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lcom/discord/api/sticker/Sticker;Lcom/discord/stores/StoreStickers;Lcom/discord/stores/StoreUser;Ljava/lang/String;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StickerSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasFiredAnalytics;
    private final String location;
    private final Sticker sticker;
    private final StoreStickers storeStickers;
    private final StoreUser storeUser;

    /* compiled from: StickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.StickerSheetViewModel$1, reason: invalid class name */
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
            StickerSheetViewModel.access$handleStoreState(StickerSheetViewModel.this, storeState);
        }
    }

    /* compiled from: StickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/stickers/StickerSheetViewModel$Companion;", "", "Lcom/discord/stores/StoreStickers;", "storeStickers", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/api/sticker/Sticker;", "sticker", "Lrx/Observable;", "Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreStickers;Lcom/discord/stores/StoreUser;Lcom/discord/api/sticker/Sticker;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
            return companion.observeStoreState(storeStickers, storeUser, sticker);
        }

        private final Observable<StoreState> observeStoreState(StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
            Long packId = sticker.getPackId();
            Intrinsics3.checkNotNull(packId);
            Observable<StoreState> observableJ = Observable.j(storeStickers.observeStickerPack(packId.longValue()), StoreUser.observeMe$default(storeUser, false, 1, null), StickerSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ser\n          )\n        }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "", "Lcom/discord/stores/StoreStickers$StickerPackState;", "component1", "()Lcom/discord/stores/StoreStickers$StickerPackState;", "Lcom/discord/models/user/MeUser;", "component2", "()Lcom/discord/models/user/MeUser;", "stickerPack", "meUser", "copy", "(Lcom/discord/stores/StoreStickers$StickerPackState;Lcom/discord/models/user/MeUser;)Lcom/discord/widgets/stickers/StickerSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/stores/StoreStickers$StickerPackState;", "getStickerPack", "<init>", "(Lcom/discord/stores/StoreStickers$StickerPackState;Lcom/discord/models/user/MeUser;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final MeUser meUser;
        private final StoreStickers.StickerPackState stickerPack;

        public StoreState(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            this.stickerPack = stickerPackState;
            this.meUser = meUser;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreStickers.StickerPackState stickerPackState, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                stickerPackState = storeState.stickerPack;
            }
            if ((i & 2) != 0) {
                meUser = storeState.meUser;
            }
            return storeState.copy(stickerPackState, meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        /* renamed from: component2, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreState copy(StoreStickers.StickerPackState stickerPack, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            return new StoreState(stickerPack, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.stickerPack, storeState.stickerPack) && Intrinsics3.areEqual(this.meUser, storeState.meUser);
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        public int hashCode() {
            StoreStickers.StickerPackState stickerPackState = this.stickerPack;
            int iHashCode = (stickerPackState != null ? stickerPackState.hashCode() : 0) * 31;
            MeUser meUser = this.meUser;
            return iHashCode + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\rR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b\u0011\u0010\r¨\u0006("}, d2 = {"Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;", "", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Lcom/discord/models/sticker/dto/ModelStickerPack;", "Lcom/discord/api/sticker/Sticker;", "component2", "()Lcom/discord/api/sticker/Sticker;", "Lcom/discord/api/premium/PremiumTier;", "component3", "()Lcom/discord/api/premium/PremiumTier;", "", "component4", "()Z", "stickerPack", "sticker", "meUserPremiumTier", "isStickerPackEnabled", "copy", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Lcom/discord/api/sticker/Sticker;Lcom/discord/api/premium/PremiumTier;Z)Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/premium/PremiumTier;", "getMeUserPremiumTier", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getStickerPack", "canUsePremiumStickers", "Z", "getCanUsePremiumStickers", "Lcom/discord/api/sticker/Sticker;", "getSticker", "<init>", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Lcom/discord/api/sticker/Sticker;Lcom/discord/api/premium/PremiumTier;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean canUsePremiumStickers;
        private final boolean isStickerPackEnabled;
        private final PremiumTier meUserPremiumTier;
        private final Sticker sticker;
        private final ModelStickerPack stickerPack;

        public ViewState(ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2) {
            Intrinsics3.checkNotNullParameter(modelStickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            Intrinsics3.checkNotNullParameter(premiumTier, "meUserPremiumTier");
            this.stickerPack = modelStickerPack;
            this.sticker = sticker;
            this.meUserPremiumTier = premiumTier;
            this.isStickerPackEnabled = z2;
            this.canUsePremiumStickers = PremiumUtils3.grantsAccessToPremiumStickers(premiumTier);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = viewState.stickerPack;
            }
            if ((i & 2) != 0) {
                sticker = viewState.sticker;
            }
            if ((i & 4) != 0) {
                premiumTier = viewState.meUserPremiumTier;
            }
            if ((i & 8) != 0) {
                z2 = viewState.isStickerPackEnabled;
            }
            return viewState.copy(modelStickerPack, sticker, premiumTier, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* renamed from: component2, reason: from getter */
        public final Sticker getSticker() {
            return this.sticker;
        }

        /* renamed from: component3, reason: from getter */
        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsStickerPackEnabled() {
            return this.isStickerPackEnabled;
        }

        public final ViewState copy(ModelStickerPack stickerPack, Sticker sticker, PremiumTier meUserPremiumTier, boolean isStickerPackEnabled) {
            Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            Intrinsics3.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
            return new ViewState(stickerPack, sticker, meUserPremiumTier, isStickerPackEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.stickerPack, viewState.stickerPack) && Intrinsics3.areEqual(this.sticker, viewState.sticker) && Intrinsics3.areEqual(this.meUserPremiumTier, viewState.meUserPremiumTier) && this.isStickerPackEnabled == viewState.isStickerPackEnabled;
        }

        public final boolean getCanUsePremiumStickers() {
            return this.canUsePremiumStickers;
        }

        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        public final Sticker getSticker() {
            return this.sticker;
        }

        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelStickerPack modelStickerPack = this.stickerPack;
            int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
            Sticker sticker = this.sticker;
            int iHashCode2 = (iHashCode + (sticker != null ? sticker.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.meUserPremiumTier;
            int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
            boolean z2 = this.isStickerPackEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isStickerPackEnabled() {
            return this.isStickerPackEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", sticker=");
            sbU.append(this.sticker);
            sbU.append(", meUserPremiumTier=");
            sbU.append(this.meUserPremiumTier);
            sbU.append(", isStickerPackEnabled=");
            return outline.O(sbU, this.isStickerPackEnabled, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStickers stickers = (i & 2) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(sticker, stickers, users, str, (i & 16) != 0 ? Companion.access$observeStoreState(INSTANCE, stickers, users, sticker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerSheetViewModel stickerSheetViewModel, StoreState storeState) {
        stickerSheetViewModel.handleStoreState(storeState);
    }

    private final void fetchStickersData() {
        StoreStickers storeStickers = this.storeStickers;
        Long packId = this.sticker.getPackId();
        Intrinsics3.checkNotNull(packId);
        storeStickers.fetchStickerPack(packId.longValue());
        this.storeStickers.fetchEnabledStickerDirectory();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[LOOP:0: B:14:0x0071->B:38:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleLoadedStoreState(StoreState storeState) {
        boolean z2;
        MeUser meUser = storeState.getMeUser();
        StoreStickers.StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers.StickerPackState.Loaded) stickerPack).getStickerPack();
        if (!this.hasFiredAnalytics && this.location != null) {
            StickerPurchaseLocation popoutPurchaseLocation = StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(stickerPack2.canBePurchased());
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Long packId = this.sticker.getPackId();
            Intrinsics3.checkNotNull(packId);
            analyticsTracker.stickerPopoutOpened(packId.longValue(), this.location, new Traits.Location(null, popoutPurchaseLocation.getAnalyticsValue(), null, null, null, 29, null));
            this.hasFiredAnalytics = true;
        }
        Sticker sticker = this.sticker;
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.storeStickers.getEnabledStickerPacks();
        boolean z3 = false;
        if (!(enabledStickerPacks instanceof Collection) || !enabledStickerPacks.isEmpty()) {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List<Sticker> stickers = ((ModelStickerPack) it.next()).getStickers();
                if ((stickers instanceof Collection) && stickers.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                    }
                } else {
                    Iterator<T> it2 = stickers.iterator();
                    while (it2.hasNext()) {
                        if (((Sticker) it2.next()).getId() == this.sticker.getId()) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        z3 = true;
                        break;
                    }
                }
            }
        }
        updateViewState(new ViewState(stickerPack2, sticker, premiumTier, z3));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers.StickerPackState.Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(storeStickers, "storeStickers");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.storeStickers = storeStickers;
        this.storeUser = storeUser;
        this.location = str;
        fetchStickersData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StickerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.User;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.chat.input.sticker.StickerAdapterItems3;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
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

/* compiled from: StickerPackStoreSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB5\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;", "", "trackStickerPackStoreSheetViewed", "()V", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;)V", "handleLoadedStoreState", "fetchStickersData", "Lcom/discord/stores/StoreStickers;", "stickersStore", "Lcom/discord/stores/StoreStickers;", "", "Lcom/discord/primitives/StickerPackId;", "stickerPackId", "J", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetAnalytics;", "analytics", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetAnalytics;", "Lrx/Observable;", "storeStateObservable", "<init>", "(JLcom/discord/stores/StoreStickers;Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetAnalytics;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StickerPackStoreSheetViewModel2 analytics;
    private final long stickerPackId;
    private final StoreStickers stickersStore;

    /* compiled from: StickerPackStoreSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$1, reason: invalid class name */
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
            StickerPackStoreSheetViewModel.access$handleStoreState(StickerPackStoreSheetViewModel.this, storeState);
        }
    }

    /* compiled from: StickerPackStoreSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$Companion;", "", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "stickerPack", "", "stickerAnimationSettings", "Lcom/discord/models/user/User;", "meUser", "", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "buildStoreStickerListItems", "(Lcom/discord/models/sticker/dto/ModelStickerPack;ILcom/discord/models/user/User;)Ljava/util/List;", "", "Lcom/discord/primitives/StickerPackId;", "stickerPackId", "Lcom/discord/stores/StoreStickers;", "storeStickers", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUser;", "storeUser", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreStickers;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ List access$buildStoreStickerListItems(Companion companion, ModelStickerPack modelStickerPack, int i, User user) {
            return companion.buildStoreStickerListItems(modelStickerPack, i, user);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser) {
            return companion.observeStoreState(j, storeStickers, storeUserSettings, storeUser);
        }

        private final List<MGRecyclerDataPayload> buildStoreStickerListItems(ModelStickerPack stickerPack, int stickerAnimationSettings, User meUser) {
            ArrayList arrayList = new ArrayList();
            if (stickerPack.getStickers().isEmpty()) {
                return Collections2.emptyList();
            }
            arrayList.add(new StickerAdapterItems4(stickerPack, false));
            for (Sticker sticker : stickerPack.getStickers()) {
                arrayList.add(new StickerAdapterItems3(sticker, stickerAnimationSettings, StickerAdapterItems3.Mode.STORE, StickerUtils.getStickerSendability$default(StickerUtils.INSTANCE, sticker, meUser, null, null, 12, null)));
            }
            return arrayList;
        }

        private final Observable<StoreState> observeStoreState(long stickerPackId, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser) {
            Observable<StoreState> observableI = Observable.i(storeStickers.observeStickerPack(stickerPackId), StoreUserSettings.observeStickerAnimationSettings$default(storeUserSettings, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null), StickerPackStoreSheetViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ser\n          )\n        }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StickerPackStoreSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "", "Lcom/discord/stores/StoreStickers$StickerPackState;", "component1", "()Lcom/discord/stores/StoreStickers$StickerPackState;", "", "component2", "()I", "Lcom/discord/models/user/User;", "component3", "()Lcom/discord/models/user/User;", "stickerPack", "stickerAnimationSettings", "meUser", "copy", "(Lcom/discord/stores/StoreStickers$StickerPackState;ILcom/discord/models/user/User;)Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreStickers$StickerPackState;", "getStickerPack", "I", "getStickerAnimationSettings", "Lcom/discord/models/user/User;", "getMeUser", "<init>", "(Lcom/discord/stores/StoreStickers$StickerPackState;ILcom/discord/models/user/User;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final User meUser;
        private final int stickerAnimationSettings;
        private final StoreStickers.StickerPackState stickerPack;

        public StoreState(StoreStickers.StickerPackState stickerPackState, int i, User user) {
            Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
            Intrinsics3.checkNotNullParameter(user, "meUser");
            this.stickerPack = stickerPackState;
            this.stickerAnimationSettings = i;
            this.meUser = user;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreStickers.StickerPackState stickerPackState, int i, User user, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                stickerPackState = storeState.stickerPack;
            }
            if ((i2 & 2) != 0) {
                i = storeState.stickerAnimationSettings;
            }
            if ((i2 & 4) != 0) {
                user = storeState.meUser;
            }
            return storeState.copy(stickerPackState, i, user);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        /* renamed from: component2, reason: from getter */
        public final int getStickerAnimationSettings() {
            return this.stickerAnimationSettings;
        }

        /* renamed from: component3, reason: from getter */
        public final User getMeUser() {
            return this.meUser;
        }

        public final StoreState copy(StoreStickers.StickerPackState stickerPack, int stickerAnimationSettings, User meUser) {
            Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            return new StoreState(stickerPack, stickerAnimationSettings, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.stickerPack, storeState.stickerPack) && this.stickerAnimationSettings == storeState.stickerAnimationSettings && Intrinsics3.areEqual(this.meUser, storeState.meUser);
        }

        public final User getMeUser() {
            return this.meUser;
        }

        public final int getStickerAnimationSettings() {
            return this.stickerAnimationSettings;
        }

        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        public int hashCode() {
            StoreStickers.StickerPackState stickerPackState = this.stickerPack;
            int iHashCode = (((stickerPackState != null ? stickerPackState.hashCode() : 0) * 31) + this.stickerAnimationSettings) * 31;
            User user = this.meUser;
            return iHashCode + (user != null ? user.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", stickerAnimationSettings=");
            sbU.append(this.stickerAnimationSettings);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerPackStoreSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J>\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0007R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u000e¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;", "", "", "canUserAccessToPremiumStickers", "()Z", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Lcom/discord/models/sticker/dto/ModelStickerPack;", "", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "component2", "()Ljava/util/List;", "Lcom/discord/api/premium/PremiumTier;", "component3", "()Lcom/discord/api/premium/PremiumTier;", "component4", "stickerPack", "stickerItems", "meUserPremiumTier", "isPackEnabled", "copy", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Ljava/util/List;Lcom/discord/api/premium/PremiumTier;Z)Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getStickerPack", "Ljava/util/List;", "getStickerItems", "Lcom/discord/api/premium/PremiumTier;", "getMeUserPremiumTier", "<init>", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Ljava/util/List;Lcom/discord/api/premium/PremiumTier;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isPackEnabled;
        private final PremiumTier meUserPremiumTier;
        private final List<MGRecyclerDataPayload> stickerItems;
        private final ModelStickerPack stickerPack;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(ModelStickerPack modelStickerPack, List<? extends MGRecyclerDataPayload> list, PremiumTier premiumTier, boolean z2) {
            Intrinsics3.checkNotNullParameter(modelStickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(list, "stickerItems");
            Intrinsics3.checkNotNullParameter(premiumTier, "meUserPremiumTier");
            this.stickerPack = modelStickerPack;
            this.stickerItems = list;
            this.meUserPremiumTier = premiumTier;
            this.isPackEnabled = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, ModelStickerPack modelStickerPack, List list, PremiumTier premiumTier, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = viewState.stickerPack;
            }
            if ((i & 2) != 0) {
                list = viewState.stickerItems;
            }
            if ((i & 4) != 0) {
                premiumTier = viewState.meUserPremiumTier;
            }
            if ((i & 8) != 0) {
                z2 = viewState.isPackEnabled;
            }
            return viewState.copy(modelStickerPack, list, premiumTier, z2);
        }

        public final boolean canUserAccessToPremiumStickers() {
            return PremiumUtils3.grantsAccessToPremiumStickers(this.meUserPremiumTier);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        public final List<MGRecyclerDataPayload> component2() {
            return this.stickerItems;
        }

        /* renamed from: component3, reason: from getter */
        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsPackEnabled() {
            return this.isPackEnabled;
        }

        public final ViewState copy(ModelStickerPack stickerPack, List<? extends MGRecyclerDataPayload> stickerItems, PremiumTier meUserPremiumTier, boolean isPackEnabled) {
            Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
            Intrinsics3.checkNotNullParameter(stickerItems, "stickerItems");
            Intrinsics3.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
            return new ViewState(stickerPack, stickerItems, meUserPremiumTier, isPackEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.stickerPack, viewState.stickerPack) && Intrinsics3.areEqual(this.stickerItems, viewState.stickerItems) && Intrinsics3.areEqual(this.meUserPremiumTier, viewState.meUserPremiumTier) && this.isPackEnabled == viewState.isPackEnabled;
        }

        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        public final List<MGRecyclerDataPayload> getStickerItems() {
            return this.stickerItems;
        }

        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelStickerPack modelStickerPack = this.stickerPack;
            int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
            List<MGRecyclerDataPayload> list = this.stickerItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.meUserPremiumTier;
            int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
            boolean z2 = this.isPackEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isPackEnabled() {
            return this.isPackEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", stickerItems=");
            sbU.append(this.stickerItems);
            sbU.append(", meUserPremiumTier=");
            sbU.append(this.meUserPremiumTier);
            sbU.append(", isPackEnabled=");
            return outline.O(sbU, this.isPackEnabled, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetStickerPackStoreSheet2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetStickerPackStoreSheet2.STICKER_POPOUT_VIEW_ALL.ordinal()] = 1;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeStickers = (i & 2) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, j, storeStickers, companion2.getUserSettings(), companion2.getUsers());
        }
        this(j, storeStickers, stickerPackStoreSheetViewModel2, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerPackStoreSheetViewModel stickerPackStoreSheetViewModel, StoreState storeState) {
        stickerPackStoreSheetViewModel.handleStoreState(storeState);
    }

    private final void handleLoadedStoreState(StoreState storeState) {
        int stickerAnimationSettings = storeState.getStickerAnimationSettings();
        User meUser = storeState.getMeUser();
        ArrayList arrayList = new ArrayList();
        StoreStickers.StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers.StickerPackState.Loaded) stickerPack).getStickerPack();
        arrayList.addAll(Companion.access$buildStoreStickerListItems(INSTANCE, stickerPack2, stickerAnimationSettings, storeState.getMeUser()));
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.stickersStore.getEnabledStickerPacks();
        boolean z2 = true;
        if ((enabledStickerPacks instanceof Collection) && enabledStickerPacks.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (it.hasNext()) {
                if (((ModelStickerPack) it.next()).getId() == this.stickerPackId) {
                    break;
                }
            }
            z2 = false;
        }
        updateViewState(new ViewState(stickerPack2, arrayList, premiumTier, z2));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers.StickerPackState.Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    private final void trackStickerPackStoreSheetViewed() {
        AnalyticsTracker.INSTANCE.stickerPackViewAllViewed(this.analytics.getSticker(), this.analytics.getType().ordinal() != 0 ? "Sticker Pack Detail Sheet" : "Sticker Pack Detail Sheet (Sticker Upsell Popout)", this.analytics.getLocation(), new Traits.Location(null, this.analytics.getLocation(), null, null, null, 29, null));
    }

    public final void fetchStickersData() {
        this.stickersStore.fetchStickerPack(this.stickerPackId);
        this.stickersStore.fetchEnabledStickerDirectory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeStickers, "stickersStore");
        Intrinsics3.checkNotNullParameter(stickerPackStoreSheetViewModel2, "analytics");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.stickerPackId = j;
        this.stickersStore = storeStickers;
        this.analytics = stickerPackStoreSheetViewModel2;
        fetchStickersData();
        trackStickerPackStoreSheetViewed();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StickerPackStoreSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

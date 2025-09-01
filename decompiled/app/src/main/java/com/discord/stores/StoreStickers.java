package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreStickers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 M2\u00020\u0001:\u0002MNB-\u0012\u0006\u0010>\u001a\u00020=\u0012\b\b\u0002\u0010G\u001a\u00020F\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00100\u001a\u00020/¢\u0006\u0004\bK\u0010LJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\b2\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0004\b\u0010\u0010\nJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002`\u000e0\u00110\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0019\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u0004J!\u0010$\u001a\u00020\u00022\u0010\u0010#\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0011H\u0007¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b'\u0010%J\u001d\u0010)\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b)\u0010%J\u0017\u0010*\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b*\u0010\u001fJ\u000f\u0010+\u001a\u00020\u0002H\u0017¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0007¢\u0006\u0004\b,\u0010\u0004J\u001f\u0010.\u001a\u00020\u00022\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u000e0\u0011¢\u0006\u0004\b.\u0010%R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R&\u0010:\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R&\u0010<\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00103R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00103R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u0002070B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR&\u0010E\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010;R\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/discord/stores/StoreStickers;", "Lcom/discord/stores/StoreV2;", "", "init", "()V", "", "", "Lcom/discord/primitives/StickerPackId;", "Lcom/discord/stores/StoreStickers$StickerPackState;", "getStickerPacks", "()Ljava/util/Map;", "stickerPackId", "getStickerPack", "(J)Lcom/discord/stores/StoreStickers$StickerPackState;", "Lcom/discord/primitives/StickerId;", "Lcom/discord/api/sticker/Sticker;", "getStickers", "", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getEnabledStickerPacks", "()Ljava/util/List;", "getEnabledStickers", "Lrx/Observable;", "observeStickerPack", "(J)Lrx/Observable;", "observeStickerPacks", "()Lrx/Observable;", "observeFrequentlyUsedStickerIds", "observeEnabledStickerPacks", "sticker", "onStickerUsed", "(Lcom/discord/api/sticker/Sticker;)V", "fetchStickerPack", "(J)V", "fetchEnabledStickerDirectory", "stickerPackIds", "handleNewLoadingStickerPacks", "(Ljava/util/List;)V", "newStickerPacks", "handleNewLoadedStickerPacks", "enabledPacks", "handleNewEnabledStickerDirectory", "handleFetchedSticker", "snapshotData", "handlePreLogout", "stickerIds", "handleDeletedStickers", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "enabledStickerPacks", "Ljava/util/List;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/media/MediaFrecencyTracker;", "frecency", "Lcom/discord/utilities/media/MediaFrecencyTracker;", "stickerPacksSnapshot", "Ljava/util/Map;", "stickersSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "enabledStickerPacksStickersSnapshot", "enabledStickerPacksSnapshot", "Lcom/discord/utilities/persister/Persister;", "frecencyCache", "Lcom/discord/utilities/persister/Persister;", "stickerPacks", "Lcom/discord/utilities/rest/RestAPI;", "api", "Lcom/discord/utilities/rest/RestAPI;", "lastFetchedEnabledPacks", "J", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/time/Clock;)V", "Companion", "StickerPackState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStickers extends StoreV2 {
    private static final long FETCH_ENABLED_STICKER_PACKS_DELAY = 300000;
    private static final int MAX_FREQUENTLY_USED_STICKERS = 20;
    private final RestAPI api;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private List<ModelStickerPack> enabledStickerPacks;
    private List<ModelStickerPack> enabledStickerPacksSnapshot;
    private List<Sticker> enabledStickerPacksStickersSnapshot;
    private final MediaFrecencyTracker frecency;
    private final Persister<MediaFrecencyTracker> frecencyCache;
    private long lastFetchedEnabledPacks;
    private final ObservationDeck observationDeck;
    private Map<Long, ? extends StickerPackState> stickerPacks;
    private Map<Long, ? extends StickerPackState> stickerPacksSnapshot;
    private Map<Long, Sticker> stickersSnapshot;

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState;", "", "<init>", "()V", "Loaded", "Loading", "Unknown", "Lcom/discord/stores/StoreStickers$StickerPackState$Unknown;", "Lcom/discord/stores/StoreStickers$StickerPackState$Loading;", "Lcom/discord/stores/StoreStickers$StickerPackState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StickerPackState {

        /* compiled from: StoreStickers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState$Loaded;", "Lcom/discord/stores/StoreStickers$StickerPackState;", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Lcom/discord/models/sticker/dto/ModelStickerPack;", "stickerPack", "copy", "(Lcom/discord/models/sticker/dto/ModelStickerPack;)Lcom/discord/stores/StoreStickers$StickerPackState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getStickerPack", "<init>", "(Lcom/discord/models/sticker/dto/ModelStickerPack;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends StickerPackState {
            private final ModelStickerPack stickerPack;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelStickerPack modelStickerPack) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelStickerPack, "stickerPack");
                this.stickerPack = modelStickerPack;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelStickerPack modelStickerPack, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelStickerPack = loaded.stickerPack;
                }
                return loaded.copy(modelStickerPack);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelStickerPack getStickerPack() {
                return this.stickerPack;
            }

            public final Loaded copy(ModelStickerPack stickerPack) {
                Intrinsics3.checkNotNullParameter(stickerPack, "stickerPack");
                return new Loaded(stickerPack);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.stickerPack, ((Loaded) other).stickerPack);
                }
                return true;
            }

            public final ModelStickerPack getStickerPack() {
                return this.stickerPack;
            }

            public int hashCode() {
                ModelStickerPack modelStickerPack = this.stickerPack;
                if (modelStickerPack != null) {
                    return modelStickerPack.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(stickerPack=");
                sbU.append(this.stickerPack);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreStickers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState$Loading;", "Lcom/discord/stores/StoreStickers$StickerPackState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends StickerPackState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreStickers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState$Unknown;", "Lcom/discord/stores/StoreStickers$StickerPackState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unknown extends StickerPackState {
            public static final Unknown INSTANCE = new Unknown();

            private Unknown() {
                super(null);
            }
        }

        private StickerPackState() {
        }

        public /* synthetic */ StickerPackState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/sticker/dto/ModelStickerStoreDirectory;", "directory", "", "invoke", "(Lcom/discord/models/sticker/dto/ModelStickerStoreDirectory;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelStickerStoreDirectory, Unit> {

        /* compiled from: StoreStickers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01741 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelStickerStoreDirectory $directory;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01741(ModelStickerStoreDirectory modelStickerStoreDirectory) {
                super(0);
                this.$directory = modelStickerStoreDirectory;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStickers storeStickers = StoreStickers.this;
                StoreStickers.access$setLastFetchedEnabledPacks$p(storeStickers, StoreStickers.access$getClock$p(storeStickers).currentTimeMillis());
                StoreStickers.this.handleNewEnabledStickerDirectory(this.$directory.getStickerPacks());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            invoke2(modelStickerStoreDirectory);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            Intrinsics3.checkNotNullParameter(modelStickerStoreDirectory, "directory");
            StoreStickers.access$getDispatcher$p(StoreStickers.this).schedule(new C01741(modelStickerStoreDirectory));
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* compiled from: StoreStickers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/sticker/dto/ModelStickerPack;", "newPack", "", "invoke", "(Lcom/discord/models/sticker/dto/ModelStickerPack;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01751 extends Lambda implements Function1<ModelStickerPack, Unit> {

            /* compiled from: StoreStickers.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01761 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelStickerPack $newPack;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01761(ModelStickerPack modelStickerPack) {
                    super(0);
                    this.$newPack = modelStickerPack;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStickers.this.handleNewLoadedStickerPacks(CollectionsJVM.listOf(this.$newPack));
                }
            }

            public C01751() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelStickerPack modelStickerPack) {
                invoke2(modelStickerPack);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelStickerPack modelStickerPack) {
                Intrinsics3.checkNotNullParameter(modelStickerPack, "newPack");
                StoreStickers.access$getDispatcher$p(StoreStickers.this).schedule(new C01761(modelStickerPack));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStickers.this.handleNewLoadingStickerPacks(CollectionsJVM.listOf(Long.valueOf(this.$stickerPackId)));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreStickers.access$getApi$p(StoreStickers.this).getStickerPack(this.$stickerPackId), false, 1, null), StoreStickers.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C01751(), 62, (Object) null);
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$handleDeletedStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $stickerIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$stickerIds = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Iterator it = this.$stickerIds.iterator();
            while (it.hasNext()) {
                StoreStickers.access$getFrecency$p(StoreStickers.this).removeEntry(String.valueOf(((Number) it.next()).longValue()));
            }
            StoreStickers.access$getFrecencyCache$p(StoreStickers.this).set(StoreStickers.access$getFrecency$p(StoreStickers.this), true);
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$observeEnabledStickerPacks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ModelStickerPack>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelStickerPack> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelStickerPack> invoke2() {
            return StoreStickers.access$getEnabledStickerPacksSnapshot$p(StoreStickers.this);
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0001*\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/utilities/media/MediaFrecencyTracker;", "kotlin.jvm.PlatformType", "it", "", "", "Lcom/discord/primitives/StickerId;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/media/MediaFrecencyTracker;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$observeFrequentlyUsedStickerIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<MediaFrecencyTracker, List<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Long> call(MediaFrecencyTracker mediaFrecencyTracker) {
            return call2(mediaFrecencyTracker);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(MediaFrecencyTracker mediaFrecencyTracker) {
            Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(mediaFrecencyTracker, 0L, 1, null);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedKeys$default, 10));
            Iterator<T> it = sortedKeys$default.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
            }
            return arrayList;
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$observeStickerPack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreStickers.access$getStickerPacks$p(StoreStickers.this).containsKey(Long.valueOf(this.$stickerPackId))) {
                return;
            }
            StoreStickers.this.fetchStickerPack(this.$stickerPackId);
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreStickers$StickerPackState;", "invoke", "()Lcom/discord/stores/StoreStickers$StickerPackState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$observeStickerPack$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<StickerPackState> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StickerPackState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StickerPackState invoke() {
            StickerPackState stickerPackState = (StickerPackState) StoreStickers.access$getStickerPacks$p(StoreStickers.this).get(Long.valueOf(this.$stickerPackId));
            return stickerPackState != null ? stickerPackState : StickerPackState.Unknown.INSTANCE;
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/stores/StoreStickers$StickerPackState;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$observeStickerPacks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends StickerPackState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends StickerPackState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends StickerPackState> invoke2() {
            return _Collections.toList(StoreStickers.access$getStickerPacks$p(StoreStickers.this).values());
        }
    }

    /* compiled from: StoreStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStickers$onStickerUsed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Sticker sticker) {
            super(0);
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FrecencyTracker.track$default(StoreStickers.access$getFrecency$p(StoreStickers.this), String.valueOf(this.$sticker.getId()), 0L, 2, null);
            StoreStickers.access$getFrecencyCache$p(StoreStickers.this).set(StoreStickers.access$getFrecency$p(StoreStickers.this), true);
        }
    }

    public /* synthetic */ StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ RestAPI access$getApi$p(StoreStickers storeStickers) {
        return storeStickers.api;
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreStickers storeStickers) {
        return storeStickers.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreStickers storeStickers) {
        return storeStickers.dispatcher;
    }

    public static final /* synthetic */ List access$getEnabledStickerPacksSnapshot$p(StoreStickers storeStickers) {
        return storeStickers.enabledStickerPacksSnapshot;
    }

    public static final /* synthetic */ MediaFrecencyTracker access$getFrecency$p(StoreStickers storeStickers) {
        return storeStickers.frecency;
    }

    public static final /* synthetic */ Persister access$getFrecencyCache$p(StoreStickers storeStickers) {
        return storeStickers.frecencyCache;
    }

    public static final /* synthetic */ long access$getLastFetchedEnabledPacks$p(StoreStickers storeStickers) {
        return storeStickers.lastFetchedEnabledPacks;
    }

    public static final /* synthetic */ Map access$getStickerPacks$p(StoreStickers storeStickers) {
        return storeStickers.stickerPacks;
    }

    public static final /* synthetic */ void access$setEnabledStickerPacksSnapshot$p(StoreStickers storeStickers, List list) {
        storeStickers.enabledStickerPacksSnapshot = list;
    }

    public static final /* synthetic */ void access$setLastFetchedEnabledPacks$p(StoreStickers storeStickers, long j) {
        storeStickers.lastFetchedEnabledPacks = j;
    }

    public static final /* synthetic */ void access$setStickerPacks$p(StoreStickers storeStickers, Map map) {
        storeStickers.stickerPacks = map;
    }

    public final void fetchEnabledStickerDirectory() {
        if (this.lastFetchedEnabledPacks + 300000 >= this.clock.currentTimeMillis()) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.api.getStickerPacks(), false, 1, null), StoreStickers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void fetchStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new AnonymousClass1(stickerPackId));
    }

    public final List<ModelStickerPack> getEnabledStickerPacks() {
        return this.enabledStickerPacksSnapshot;
    }

    public final List<Sticker> getEnabledStickers() {
        return this.enabledStickerPacksStickersSnapshot;
    }

    public final StickerPackState getStickerPack(long stickerPackId) {
        return this.stickerPacksSnapshot.get(Long.valueOf(stickerPackId));
    }

    public final Map<Long, StickerPackState> getStickerPacks() {
        return this.stickerPacksSnapshot;
    }

    public final Map<Long, Sticker> getStickers() {
        return this.stickersSnapshot;
    }

    public final void handleDeletedStickers(List<Long> stickerIds) {
        Intrinsics3.checkNotNullParameter(stickerIds, "stickerIds");
        this.dispatcher.schedule(new AnonymousClass1(stickerIds));
    }

    public final void handleFetchedSticker(Sticker sticker) {
        if (sticker == null || sticker.getType() != StickerType.STANDARD) {
            return;
        }
        Long packId = sticker.getPackId();
        Intrinsics3.checkNotNull(packId);
        fetchStickerPack(packId.longValue());
    }

    @Store3
    public final void handleNewEnabledStickerDirectory(List<ModelStickerPack> enabledPacks) {
        Intrinsics3.checkNotNullParameter(enabledPacks, "enabledPacks");
        handleNewLoadedStickerPacks(enabledPacks);
        this.enabledStickerPacks = enabledPacks;
        markChanged();
    }

    @Store3
    public final void handleNewLoadedStickerPacks(List<ModelStickerPack> newStickerPacks) {
        Intrinsics3.checkNotNullParameter(newStickerPacks, "newStickerPacks");
        Map<Long, ? extends StickerPackState> mutableMap = Maps6.toMutableMap(this.stickerPacks);
        for (ModelStickerPack modelStickerPack : newStickerPacks) {
            StickerPackState stickerPackState = this.stickerPacks.get(Long.valueOf(modelStickerPack.getId()));
            if (stickerPackState == null || !(stickerPackState instanceof StickerPackState.Loaded) || ((StickerPackState.Loaded) stickerPackState).getStickerPack().getStoreListing() == null) {
                mutableMap.put(Long.valueOf(modelStickerPack.getId()), new StickerPackState.Loaded(modelStickerPack));
            }
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @Store3
    public final void handleNewLoadingStickerPacks(List<Long> stickerPackIds) {
        Intrinsics3.checkNotNullParameter(stickerPackIds, "stickerPackIds");
        Map<Long, ? extends StickerPackState> mutableMap = Maps6.toMutableMap(this.stickerPacks);
        Iterator<T> it = stickerPackIds.iterator();
        while (it.hasNext()) {
            mutableMap.put(Long.valueOf(((Number) it.next()).longValue()), StickerPackState.Loading.INSTANCE);
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void init() {
        fetchEnabledStickerDirectory();
    }

    public final Observable<List<ModelStickerPack>> observeEnabledStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<List<Long>> observeFrequentlyUsedStickerIds() {
        Observable observableG = this.frecencyCache.getObservable().G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "frecencyCache.getObserva…ckerId.toLong() }\n      }");
        return observableG;
    }

    public final Observable<StickerPackState> observeStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new AnonymousClass1(stickerPackId));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(stickerPackId), 14, null);
    }

    public final Observable<List<StickerPackState>> observeStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void onStickerUsed(Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        this.dispatcher.schedule(new AnonymousClass1(sticker));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        HashMap map = new HashMap(this.stickerPacks);
        this.stickerPacksSnapshot = map;
        Collection collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof StickerPackState.Loaded) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StickerPackState.Loaded) it.next()).getStickerPack().getStickers());
        }
        List listFlatten = Iterables2.flatten(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listFlatten, 10)), 16));
        for (Object obj2 : listFlatten) {
            linkedHashMap.put(Long.valueOf(((Sticker) obj2).getId()), obj2);
        }
        this.stickersSnapshot = linkedHashMap;
        this.enabledStickerPacksSnapshot = new ArrayList(this.enabledStickerPacks);
        List<ModelStickerPack> list = this.enabledStickerPacks;
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ModelStickerPack) it2.next()).getStickers());
        }
        this.enabledStickerPacksStickersSnapshot = new ArrayList(Iterables2.flatten(arrayList3));
    }

    public StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "api");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.dispatcher = dispatcher;
        this.api = restAPI;
        this.observationDeck = observationDeck;
        this.clock = clock;
        this.stickerPacks = Maps6.emptyMap();
        this.stickerPacksSnapshot = Maps6.emptyMap();
        this.stickersSnapshot = Maps6.emptyMap();
        Persister<MediaFrecencyTracker> persister = new Persister<>("STICKER_HISTORY_V1", new MediaFrecencyTracker(20, 1));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.enabledStickerPacks = Collections2.emptyList();
        this.enabledStickerPacksSnapshot = Collections2.emptyList();
        this.enabledStickerPacksStickersSnapshot = Collections2.emptyList();
    }
}

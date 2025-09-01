package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreV2DispatchHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/stores/StoreV2DispatchHandler;", "Lcom/discord/stores/DispatchHandler;", "", "onDispatchEnded", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "Lcom/discord/stores/StoreV2;", "storesV2", "Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreV2DispatchHandler implements Store2 {
    private final ObservationDeck observationDeck;
    private final List<StoreV2> storesV2;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreV2DispatchHandler(List<? extends StoreV2> list, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(list, "storesV2");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storesV2 = list;
        this.observationDeck = observationDeck;
    }

    @Override // com.discord.stores.Store2
    @Store3
    public void onDispatchEnded() {
        HashSet hashSet = new HashSet();
        for (StoreV2 storeV2 : this.storesV2) {
            Set<ObservationDeck.UpdateSource> updateSources = storeV2.getUpdateSources();
            if (!updateSources.isEmpty()) {
                hashSet.addAll(updateSources);
                storeV2.snapshotData();
                storeV2.onDispatchEnded();
            }
        }
        if (!hashSet.isEmpty()) {
            this.observationDeck.notify(hashSet);
        }
    }

    public /* synthetic */ StoreV2DispatchHandler(List list, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}

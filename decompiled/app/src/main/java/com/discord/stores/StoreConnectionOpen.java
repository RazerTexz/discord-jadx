package com.discord.stores;

import com.discord.stores.StoreV2;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: StoreConnectionOpen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\tJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fR+\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/stores/StoreConnectionOpen;", "Lcom/discord/stores/StoreV2;", "", "delayForUI", "Lrx/Observable;", "observeConnectionOpen", "(Z)Lrx/Observable;", "", "handleConnectionOpen", "()V", "connected", "handleConnected", "(Z)V", "<set-?>", "isConnectionOpen$delegate", "Lcom/discord/stores/StoreV2$MarkChangedDelegate;", "isConnectionOpen", "()Z", "setConnectionOpen", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreConnectionOpen extends StoreV2 {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(StoreConnectionOpen.class, "isConnectionOpen", "isConnectionOpen()Z", 0))};

    /* renamed from: isConnectionOpen$delegate, reason: from kotlin metadata */
    private final StoreV2.MarkChangedDelegate isConnectionOpen = new StoreV2.MarkChangedDelegate(Boolean.FALSE, null, 2, null);

    /* compiled from: StoreConnectionOpen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreConnectionOpen$observeConnectionOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreConnectionOpen.access$isConnectionOpen$p(StoreConnectionOpen.this);
        }
    }

    public static final /* synthetic */ boolean access$isConnectionOpen$p(StoreConnectionOpen storeConnectionOpen) {
        return storeConnectionOpen.isConnectionOpen();
    }

    public static final /* synthetic */ void access$setConnectionOpen$p(StoreConnectionOpen storeConnectionOpen, boolean z2) {
        storeConnectionOpen.setConnectionOpen(z2);
    }

    private final boolean isConnectionOpen() {
        return ((Boolean) this.isConnectionOpen.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public static /* synthetic */ Observable observeConnectionOpen$default(StoreConnectionOpen storeConnectionOpen, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeConnectionOpen.observeConnectionOpen(z2);
    }

    private final void setConnectionOpen(boolean z2) {
        this.isConnectionOpen.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z2));
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        setConnectionOpen(false);
    }

    @Store3
    public final void handleConnectionOpen() {
        setConnectionOpen(true);
    }

    public final Observable<Boolean> observeConnectionOpen(boolean delayForUI) {
        Observable<Boolean> observableConnectRx$default = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
        if (delayForUI) {
            observableConnectRx$default = observableConnectRx$default.q(100L, TimeUnit.MILLISECONDS);
        }
        Intrinsics3.checkNotNullExpressionValue(observableConnectRx$default, "ObservationDeckProvider\n…            }\n          }");
        return observableConnectRx$default;
    }
}

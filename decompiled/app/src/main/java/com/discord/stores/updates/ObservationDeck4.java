package com.discord.stores.updates;

import d0.LazyJVM;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: ObservationDeck.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\b\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/stores/updates/ObservationDeckProvider;", "", "Lcom/discord/stores/updates/ObservationDeck;", "get", "()Lcom/discord/stores/updates/ObservationDeck;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.updates.ObservationDeckProvider, reason: use source file name */
/* loaded from: classes2.dex */
public final class ObservationDeck4 {
    public static final ObservationDeck4 INSTANCE = new ObservationDeck4();

    /* renamed from: INSTANCE$delegate, reason: from kotlin metadata */
    private static final Lazy INSTANCE = LazyJVM.lazy(ObservationDeck5.INSTANCE);

    private ObservationDeck4() {
    }

    public static final ObservationDeck get() {
        return INSTANCE.getINSTANCE();
    }

    private final ObservationDeck getINSTANCE() {
        return (ObservationDeck) INSTANCE.getValue();
    }
}

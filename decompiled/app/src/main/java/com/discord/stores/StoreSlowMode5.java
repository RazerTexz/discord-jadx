package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSlowMode;
import kotlin.Metadata;
import rx.functions.Action0;

/* compiled from: StoreSlowMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$4, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSlowMode5 implements Action0 {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode.Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    public StoreSlowMode5(StoreSlowMode storeSlowMode, long j, StoreSlowMode.Type type) {
        this.this$0 = storeSlowMode;
        this.$channelId = j;
        this.$type = type;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreSlowMode.access$removeChannelCooldownObservable(this.this$0, this.$channelId, this.$type);
    }
}

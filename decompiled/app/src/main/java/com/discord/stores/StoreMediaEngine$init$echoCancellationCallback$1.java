package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StoreMediaEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/stores/StoreMediaEngine$init$echoCancellationCallback$1", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$b;", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$EchoCancellationInfo;", "info", "", "onEchoCancellationUpdated", "(Lcom/discord/rtcconnection/mediaengine/MediaEngine$EchoCancellationInfo;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMediaEngine$init$echoCancellationCallback$1 implements MediaEngine.b {
    public final /* synthetic */ StoreMediaEngine this$0;

    public StoreMediaEngine$init$echoCancellationCallback$1(StoreMediaEngine storeMediaEngine) {
        this.this$0 = storeMediaEngine;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine.b
    public void onEchoCancellationUpdated(MediaEngine.EchoCancellationInfo info) {
        Intrinsics3.checkNotNullParameter(info, "info");
        StoreMediaEngine.access$getDispatcher$p(this.this$0).schedule(new StoreMediaEngine$init$echoCancellationCallback$1$onEchoCancellationUpdated$1(info));
    }
}

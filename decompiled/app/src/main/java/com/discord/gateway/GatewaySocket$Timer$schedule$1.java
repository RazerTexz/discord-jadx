package com.discord.gateway;

import androidx.core.app.NotificationCompat;
import com.discord.gateway.GatewaySocket;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.functions.Action1;

/* compiled from: GatewaySocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GatewaySocket$Timer$schedule$1<T> implements Action1<Long> {
    public final /* synthetic */ Function0 $action;
    public final /* synthetic */ GatewaySocket.Timer this$0;

    public GatewaySocket$Timer$schedule$1(GatewaySocket.Timer timer, Function0 function0) {
        this.this$0 = timer;
        this.$action = function0;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Long l) {
        call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Long l) {
        try {
            this.$action.invoke();
        } finally {
            GatewaySocket.Timer.access$setSubscription$p(this.this$0, null);
        }
    }
}

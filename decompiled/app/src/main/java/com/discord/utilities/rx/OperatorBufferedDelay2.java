package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rx.OperatorBufferedDelay;
import kotlin.Metadata;
import rx.functions.Action0;

/* compiled from: OperatorBufferedDelay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", NotificationCompat.CATEGORY_CALL, "()V", "com/discord/utilities/rx/OperatorBufferedDelay$ExactSubscriber$onNext$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class OperatorBufferedDelay2 implements Action0 {
    public final /* synthetic */ Object $t$inlined;
    public final /* synthetic */ OperatorBufferedDelay.ExactSubscriber this$0;

    public OperatorBufferedDelay2(OperatorBufferedDelay.ExactSubscriber exactSubscriber, Object obj) {
        this.this$0 = exactSubscriber;
        this.$t$inlined = obj;
    }

    @Override // rx.functions.Action0
    public final void call() {
        OperatorBufferedDelay.ExactSubscriber.tryEmit$default(this.this$0, null, 1, null);
    }
}

package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OnDelayedEmissionHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler3 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ OnDelayedEmissionHandler2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDelayedEmissionHandler3(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
        super(1);
        this.this$0 = onDelayedEmissionHandler2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        if (OnDelayedEmissionHandler.access$getHasFinished$p(this.this$0.this$0).getAndSet(true)) {
            return;
        }
        OnDelayedEmissionHandler.access$getOnDelayCallback$p(this.this$0.this$0).invoke(Boolean.FALSE);
    }
}

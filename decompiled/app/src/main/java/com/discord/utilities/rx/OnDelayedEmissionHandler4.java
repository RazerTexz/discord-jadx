package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OnDelayedEmissionHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ OnDelayedEmissionHandler2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDelayedEmissionHandler4(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
        super(1);
        this.this$0 = onDelayedEmissionHandler2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = this.this$0;
        Throwable throwable = error.getThrowable();
        Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
        onDelayedEmissionHandler2.onError(throwable);
    }
}

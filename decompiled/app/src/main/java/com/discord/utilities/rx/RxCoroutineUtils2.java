package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* compiled from: RxCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Subscription $subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineUtils2(Subscription subscription) {
        super(1);
        this.$subscription = subscription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$subscription.unsubscribe();
    }
}

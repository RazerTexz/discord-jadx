package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.Result2;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import rx.functions.Action1;

/* compiled from: RxCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils3<T> implements Action1<T> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtils3(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // rx.functions.Action1
    public final void call(T t) {
        CancellableContinuation cancellableContinuation = this.$cont;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(t));
    }
}

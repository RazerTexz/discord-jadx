package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import rx.functions.Action1;

/* compiled from: RxCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils4<T> implements Action1<Throwable> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtils4(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        this.$cont.k(th);
    }
}

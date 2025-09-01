package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.functions.Action0;

/* compiled from: ObservableExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ObservableExtensionsKt$appSubscribe$subscription$2 implements Action0 {
    public final /* synthetic */ Function0 $onCompleted;
    public final /* synthetic */ Function0 $onTerminated;

    public ObservableExtensionsKt$appSubscribe$subscription$2(Function0 function0, Function0 function02) {
        this.$onCompleted = function0;
        this.$onTerminated = function02;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.$onCompleted.invoke();
        this.$onTerminated.invoke();
    }
}

package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import rx.functions.FuncN;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042,\u0010\u0003\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "bytesWrittenPerUpload", "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3<R> implements FuncN<Long> {
    public static final WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3 INSTANCE = new WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3();

    @Override // rx.functions.FuncN
    public /* bridge */ /* synthetic */ Long call(Object[] objArr) {
        return call(objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.FuncN
    public final Long call(Object[] objArr) {
        Intrinsics3.checkNotNullExpressionValue(objArr, "bytesWrittenPerUpload");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
            arrayList.add(Long.valueOf(((Long) obj).longValue()));
        }
        return Long.valueOf(_Collections.sumOfLong(arrayList));
    }
}

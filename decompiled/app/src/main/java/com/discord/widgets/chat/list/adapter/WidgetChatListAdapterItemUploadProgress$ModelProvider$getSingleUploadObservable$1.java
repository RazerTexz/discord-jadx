package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "bytesWritten", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1<T, R> implements Func1<Long, Integer> {
    public final /* synthetic */ SendUtils.FileUpload $upload;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1(SendUtils.FileUpload fileUpload) {
        this.$upload = fileUpload;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        WidgetChatListAdapterItemUploadProgress.ModelProvider modelProvider = WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "bytesWritten");
        return Integer.valueOf(WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getPercentage(modelProvider, l.longValue(), this.$upload.getContentLength()));
    }
}

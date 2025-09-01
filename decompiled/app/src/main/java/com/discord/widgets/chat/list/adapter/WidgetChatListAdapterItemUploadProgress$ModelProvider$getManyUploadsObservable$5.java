package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "overallProgressPercent", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Many;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Many;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5<T, R> implements Func1<Integer, WidgetChatListAdapterItemUploadProgress.Model.Many> {
    public final /* synthetic */ Ref$LongRef $totalContentLength;
    public final /* synthetic */ List $uploads;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5(List list, Ref$LongRef ref$LongRef) {
        this.$uploads = list;
        this.$totalContentLength = ref$LongRef;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress.Model.Many call(Integer num) {
        return call2(num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemUploadProgress.Model.Many call2(Integer num) {
        int size = this.$uploads.size();
        long j = this.$totalContentLength.element;
        Intrinsics3.checkNotNullExpressionValue(num, "overallProgressPercent");
        return new WidgetChatListAdapterItemUploadProgress.Model.Many(size, j, num.intValue());
    }
}

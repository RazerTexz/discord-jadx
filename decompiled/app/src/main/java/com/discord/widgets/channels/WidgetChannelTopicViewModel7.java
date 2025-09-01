package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChannelTopicViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "isOpen", "isOnHomeTab", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$Companion$NavState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel7<T1, T2, R> implements Func2<Boolean, Boolean, WidgetChannelTopicViewModel.Companion.NavState> {
    public static final WidgetChannelTopicViewModel7 INSTANCE = new WidgetChannelTopicViewModel7();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel.Companion.NavState call2(Boolean bool, Boolean bool2) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isOpen");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool2, "isOnHomeTab");
        return new WidgetChannelTopicViewModel.Companion.NavState(zBooleanValue, bool2.booleanValue());
    }
}

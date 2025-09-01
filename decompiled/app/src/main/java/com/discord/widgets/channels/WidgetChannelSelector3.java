package com.discord.widgets.channels;

import android.os.Bundle;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChannelSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "resultRequestKey", "Landroid/os/Bundle;", "bundle", "", "invoke", "(Ljava/lang/String;Landroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelSelector$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSelector3 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ boolean $allowNullChannel;
    public final /* synthetic */ Function2 $onChannelSelected;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector3(String str, boolean z2, Function2 function2) {
        super(2);
        this.$requestKey = str;
        this.$allowNullChannel = z2;
        this.$onChannelSelected = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "resultRequestKey");
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics3.areEqual(this.$requestKey, str)) {
            long j = bundle.getLong("INTENT_EXTRA_CHANNEL_ID", -1L);
            String string = bundle.getString("INTENT_EXTRA_CHANNEL_NAME", "");
            if (this.$allowNullChannel || j > 0) {
                Function2 function2 = this.$onChannelSelected;
                Long lValueOf = Long.valueOf(j);
                Intrinsics3.checkNotNullExpressionValue(string, "channelName");
                function2.invoke(lValueOf, string);
            }
        }
    }
}

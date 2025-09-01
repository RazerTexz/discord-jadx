package com.discord.widgets.channels;

import android.os.Bundle;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetChannelPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "resultRequestKey", "Landroid/os/Bundle;", "bundle", "", "invoke", "(Ljava/lang/String;Landroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet2 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function3 $onChannelSelected;
    public final /* synthetic */ Function0 $onCreateChannelSelected;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet2(String str, Function0 function0, Function3 function3) {
        super(2);
        this.$requestKey = str;
        this.$onCreateChannelSelected = function0;
        this.$onChannelSelected = function3;
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
            long j = bundle.getLong("RESULT_EXTRA_CHANNEL_ID", -1L);
            String string = bundle.getString("RESULT_EXTRA_CHANNEL_NAME", "");
            int i = bundle.getInt("RESULT_EXTRA_CHANNEL_ICON_RES_ID", -1);
            int iOrdinal = WidgetChannelPickerBottomSheet.SelectionType.INSTANCE.fromInt(bundle.getInt("RESULT_EXTRA_SELECTION_TYPE", WidgetChannelPickerBottomSheet.SelectionType.UNKNOWN.ordinal())).ordinal();
            if (iOrdinal == 1) {
                this.$onCreateChannelSelected.invoke();
                return;
            }
            if (iOrdinal == 2 && j > 0) {
                Function3 function3 = this.$onChannelSelected;
                Long lValueOf = Long.valueOf(j);
                Intrinsics3.checkNotNullExpressionValue(string, "channelName");
                function3.invoke(lValueOf, string, Integer.valueOf(i));
            }
        }
    }
}

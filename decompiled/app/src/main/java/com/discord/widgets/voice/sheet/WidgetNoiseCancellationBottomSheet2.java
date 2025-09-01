package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoiseCancellationBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetNoiseCancellationBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceNoiseCancellationBottomSheetBinding> {
    public static final WidgetNoiseCancellationBottomSheet2 INSTANCE = new WidgetNoiseCancellationBottomSheet2();

    public WidgetNoiseCancellationBottomSheet2() {
        super(1, WidgetVoiceNoiseCancellationBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetVoiceNoiseCancellationBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceNoiseCancellationBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.noise_cancellation_enable_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.noise_cancellation_enable_button);
        if (materialButton != null) {
            i = R.id.noise_cancellation_learn_more;
            TextView textView = (TextView) view.findViewById(R.id.noise_cancellation_learn_more);
            if (textView != null) {
                return new WidgetVoiceNoiseCancellationBottomSheetBinding((LinearLayout) view, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

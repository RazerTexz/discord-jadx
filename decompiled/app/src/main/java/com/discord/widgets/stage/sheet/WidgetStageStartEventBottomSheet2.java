package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageStartEventBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageStartEventBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageStartEventBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStageStartEventBottomSheetBinding> {
    public static final WidgetStageStartEventBottomSheet2 INSTANCE = new WidgetStageStartEventBottomSheet2();

    public WidgetStageStartEventBottomSheet2() {
        super(1, WidgetStageStartEventBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageStartEventBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageStartEventBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sparkle;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.sparkle);
        if (appCompatImageView != null) {
            i = R.id.speaker_hint;
            TextView textView = (TextView) view.findViewById(R.id.speaker_hint);
            if (textView != null) {
                i = R.id.start_stage_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.start_stage_button);
                if (materialButton != null) {
                    i = R.id.subtitle;
                    TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                    if (textView2 != null) {
                        i = R.id.title;
                        TextView textView3 = (TextView) view.findViewById(R.id.title);
                        if (textView3 != null) {
                            i = R.id.topic_input;
                            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.topic_input);
                            if (textInputEditText != null) {
                                i = R.id.topic_label;
                                TextView textView4 = (TextView) view.findViewById(R.id.topic_label);
                                if (textView4 != null) {
                                    i = R.id.topic_layout;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.topic_layout);
                                    if (textInputLayout != null) {
                                        return new WidgetStageStartEventBottomSheetBinding((CoordinatorLayout) view, appCompatImageView, textView, materialButton, textView2, textView3, textInputEditText, textView4, textInputLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

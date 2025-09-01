package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageModeratorJoinBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageModeratorJoinBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStageModeratorJoinBottomSheetBinding> {
    public static final WidgetStageModeratorJoinBottomSheet2 INSTANCE = new WidgetStageModeratorJoinBottomSheet2();

    public WidgetStageModeratorJoinBottomSheet2() {
        super(1, WidgetStageModeratorJoinBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageModeratorJoinBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageModeratorJoinBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.join_audience;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.join_audience);
        if (materialButton != null) {
            i = R.id.join_speaker;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.join_speaker);
            if (materialButton2 != null) {
                i = R.id.sparkle;
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.sparkle);
                if (appCompatImageView != null) {
                    i = R.id.subtitle;
                    TextView textView = (TextView) view.findViewById(R.id.subtitle);
                    if (textView != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) view.findViewById(R.id.title);
                        if (textView2 != null) {
                            return new WidgetStageModeratorJoinBottomSheetBinding((CoordinatorLayout) view, materialButton, materialButton2, appCompatImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

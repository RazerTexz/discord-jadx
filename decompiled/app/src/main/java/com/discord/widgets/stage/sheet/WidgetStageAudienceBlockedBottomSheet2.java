package com.discord.widgets.stage.sheet;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageAudienceBlockedBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStageAudienceBlockedBottomSheetBinding> {
    public static final WidgetStageAudienceBlockedBottomSheet2 INSTANCE = new WidgetStageAudienceBlockedBottomSheet2();

    public WidgetStageAudienceBlockedBottomSheet2() {
        super(1, WidgetStageAudienceBlockedBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageAudienceBlockedBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageAudienceBlockedBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.accept_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.accept_button);
        if (materialButton != null) {
            i = R.id.blocked_users;
            MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.blocked_users);
            if (maxHeightRecyclerView != null) {
                i = R.id.cancel_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.cancel_button);
                if (materialButton2 != null) {
                    return new WidgetStageAudienceBlockedBottomSheetBinding((ConstraintLayout) view, materialButton, maxHeightRecyclerView, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.feedback;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetFeedbackSheetBinding;
import com.discord.widgets.voice.feedback.FeedbackView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFeedbackSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetFeedbackSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetFeedbackSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFeedbackSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetFeedbackSheetBinding> {
    public static final WidgetFeedbackSheet2 INSTANCE = new WidgetFeedbackSheet2();

    public WidgetFeedbackSheet2() {
        super(1, WidgetFeedbackSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFeedbackSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFeedbackSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFeedbackSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.feedback_sheet_close_button;
        ImageView imageView = (ImageView) view.findViewById(R.id.feedback_sheet_close_button);
        if (imageView != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            i = R.id.feedback_sheet_feedback_view;
            FeedbackView feedbackView = (FeedbackView) view.findViewById(R.id.feedback_sheet_feedback_view);
            if (feedbackView != null) {
                i = R.id.feedback_sheet_title;
                TextView textView = (TextView) view.findViewById(R.id.feedback_sheet_title);
                if (textView != null) {
                    return new WidgetFeedbackSheetBinding(nestedScrollView, imageView, nestedScrollView, feedbackView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.forums;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumGuidelinesBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumGuidelinesBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetForumGuidelinesBottomSheetBinding> {
    public static final WidgetForumGuidelinesBottomSheet3 INSTANCE = new WidgetForumGuidelinesBottomSheet3();

    public WidgetForumGuidelinesBottomSheet3() {
        super(1, WidgetForumGuidelinesBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumGuidelinesBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumGuidelinesBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_topic;
        TextView textView = (TextView) view.findViewById(R.id.channel_topic);
        if (textView != null) {
            i = R.id.channel_topic_card;
            CardView cardView = (CardView) view.findViewById(R.id.channel_topic_card);
            if (cardView != null) {
                i = R.id.content;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.content);
                if (constraintLayout != null) {
                    i = R.id.got_it;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.got_it);
                    if (materialButton != null) {
                        i = R.id.sparkle;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.sparkle);
                        if (appCompatImageView != null) {
                            i = R.id.subtitle;
                            TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                            if (textView2 != null) {
                                i = R.id.title;
                                TextView textView3 = (TextView) view.findViewById(R.id.title);
                                if (textView3 != null) {
                                    return new WidgetForumGuidelinesBottomSheetBinding((NestedScrollView) view, textView, cardView, constraintLayout, materialButton, appCompatImageView, textView2, textView3);
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

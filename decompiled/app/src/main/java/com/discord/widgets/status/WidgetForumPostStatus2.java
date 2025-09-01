package com.discord.widgets.status;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetForumPostStatusBinding;
import com.discord.views.ReactionView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumPostStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetForumPostStatusBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetForumPostStatusBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetForumPostStatus$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumPostStatus2 extends FunctionReferenceImpl implements Function1<View, WidgetForumPostStatusBinding> {
    public static final WidgetForumPostStatus2 INSTANCE = new WidgetForumPostStatus2();

    public WidgetForumPostStatus2() {
        super(1, WidgetForumPostStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumPostStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumPostStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumPostStatusBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.follow_loading_indicator;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.follow_loading_indicator);
        if (progressBar != null) {
            i = R.id.following;
            TextView textView = (TextView) view.findViewById(R.id.following);
            if (textView != null) {
                i = R.id.following_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.following_container);
                if (linearLayout != null) {
                    i = R.id.message_count;
                    TextView textView2 = (TextView) view.findViewById(R.id.message_count);
                    if (textView2 != null) {
                        i = R.id.message_count_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.message_count_container);
                        if (linearLayout2 != null) {
                            i = R.id.reaction;
                            ReactionView reactionView = (ReactionView) view.findViewById(R.id.reaction);
                            if (reactionView != null) {
                                i = R.id.separator_one;
                                View viewFindViewById = view.findViewById(R.id.separator_one);
                                if (viewFindViewById != null) {
                                    i = R.id.separator_two;
                                    View viewFindViewById2 = view.findViewById(R.id.separator_two);
                                    if (viewFindViewById2 != null) {
                                        return new WidgetForumPostStatusBinding((ConstraintLayout) view, progressBar, textView, linearLayout, textView2, linearLayout2, reactionView, viewFindViewById, viewFindViewById2);
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

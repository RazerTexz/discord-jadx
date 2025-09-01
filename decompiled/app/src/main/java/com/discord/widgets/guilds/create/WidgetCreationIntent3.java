package com.discord.widgets.guilds.create;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCreationIntent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetCreationIntentBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetCreationIntentBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreationIntent3 extends FunctionReferenceImpl implements Function1<View, WidgetCreationIntentBinding> {
    public static final WidgetCreationIntent3 INSTANCE = new WidgetCreationIntent3();

    public WidgetCreationIntent3() {
        super(1, WidgetCreationIntentBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreationIntentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCreationIntentBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCreationIntentBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.creation_intent_first_option;
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.creation_intent_first_option);
        if (materialCardView != null) {
            i = R.id.creation_intent_first_option_text;
            TextView textView = (TextView) view.findViewById(R.id.creation_intent_first_option_text);
            if (textView != null) {
                i = R.id.creation_intent_second_option;
                MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(R.id.creation_intent_second_option);
                if (materialCardView2 != null) {
                    i = R.id.creation_intent_second_option_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.creation_intent_second_option_text);
                    if (textView2 != null) {
                        i = R.id.creation_intent_skip_text;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.creation_intent_skip_text);
                        if (linkifiedTextView != null) {
                            return new WidgetCreationIntentBinding((CoordinatorLayout) view, materialCardView, textView, materialCardView2, textView2, linkifiedTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

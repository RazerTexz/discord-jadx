package com.discord.widgets.botuikit;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ViewInteractionModalBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ModalComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/ViewInteractionModalBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/ViewInteractionModalBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.ModalComponent$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ModalComponent2 extends FunctionReferenceImpl implements Function1<View, ViewInteractionModalBinding> {
    public static final ModalComponent2 INSTANCE = new ModalComponent2();

    public ModalComponent2() {
        super(1, ViewInteractionModalBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewInteractionModalBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewInteractionModalBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewInteractionModalBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.close;
        ImageView imageView = (ImageView) view.findViewById(R.id.close);
        if (imageView != null) {
            i = R.id.components;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.components);
            if (linearLayout != null) {
                i = R.id.components_scroll;
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.components_scroll);
                if (scrollView != null) {
                    i = R.id.error;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.error);
                    if (linearLayout2 != null) {
                        i = R.id.icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.icon);
                        if (simpleDraweeView != null) {
                            i = R.id.submit;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.submit);
                            if (materialButton != null) {
                                i = R.id.title;
                                TextView textView = (TextView) view.findViewById(R.id.title);
                                if (textView != null) {
                                    i = R.id.toolbar;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.toolbar);
                                    if (constraintLayout != null) {
                                        i = R.id.warning;
                                        TextView textView2 = (TextView) view.findViewById(R.id.warning);
                                        if (textView2 != null) {
                                            return new ViewInteractionModalBinding((LinearLayout) view, imageView, linearLayout, scrollView, linearLayout2, simpleDraweeView, materialButton, textView, constraintLayout, textView2);
                                        }
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

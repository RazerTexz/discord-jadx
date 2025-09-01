package com.discord.widgets.tos;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetTosBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetTos.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetTosBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetTosBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTos$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetTos3 extends FunctionReferenceImpl implements Function1<View, WidgetTosBinding> {
    public static final WidgetTos3 INSTANCE = new WidgetTos3();

    public WidgetTos3() {
        super(1, WidgetTosBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTosBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetTosBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetTosBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.alert_tos_ack_continue;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.alert_tos_ack_continue);
        if (materialButton != null) {
            i = R.id.alert_tos_ack_wrap;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.alert_tos_ack_wrap);
            if (linearLayout != null) {
                i = R.id.alert_tos_blog_post;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.alert_tos_blog_post);
                if (linkifiedTextView != null) {
                    i = R.id.alert_tos_community_guidelines;
                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.alert_tos_community_guidelines);
                    if (linkifiedTextView2 != null) {
                        i = R.id.alert_tos_privacy_policy;
                        LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) view.findViewById(R.id.alert_tos_privacy_policy);
                        if (linkifiedTextView3 != null) {
                            i = R.id.alert_tos_terms_of_service;
                            LinkifiedTextView linkifiedTextView4 = (LinkifiedTextView) view.findViewById(R.id.alert_tos_terms_of_service);
                            if (linkifiedTextView4 != null) {
                                i = R.id.alert_tos_text_description_bottom;
                                TextView textView = (TextView) view.findViewById(R.id.alert_tos_text_description_bottom);
                                if (textView != null) {
                                    i = R.id.alert_tos_text_description_top;
                                    TextView textView2 = (TextView) view.findViewById(R.id.alert_tos_text_description_top);
                                    if (textView2 != null) {
                                        i = R.id.tos_icon;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.tos_icon);
                                        if (imageView != null) {
                                            return new WidgetTosBinding((RelativeLayout) view, materialButton, linearLayout, linkifiedTextView, linkifiedTextView2, linkifiedTextView3, linkifiedTextView4, textView, textView2, imageView);
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

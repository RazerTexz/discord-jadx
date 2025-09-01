package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetHubDescriptionBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDescriptionBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDescription$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDescription4 extends FunctionReferenceImpl implements Function1<View, WidgetHubDescriptionBinding> {
    public static final WidgetHubDescription4 INSTANCE = new WidgetHubDescription4();

    public WidgetHubDescription4() {
        super(1, WidgetHubDescriptionBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDescriptionBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDescriptionBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_server;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.add_server);
        if (loadingButton != null) {
            i = R.id.category;
            TextView textView = (TextView) view.findViewById(R.id.category);
            if (textView != null) {
                i = R.id.category_error;
                TextView textView2 = (TextView) view.findViewById(R.id.category_error);
                if (textView2 != null) {
                    i = R.id.category_layout;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.category_layout);
                    if (linearLayout != null) {
                        i = R.id.contact_sync_permissions_subtitle;
                        TextView textView3 = (TextView) view.findViewById(R.id.contact_sync_permissions_subtitle);
                        if (textView3 != null) {
                            i = R.id.description;
                            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.description);
                            if (textInputEditText != null) {
                                i = R.id.description_layout;
                                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.description_layout);
                                if (textInputLayout != null) {
                                    i = R.id.header;
                                    ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.header);
                                    if (screenTitleView != null) {
                                        return new WidgetHubDescriptionBinding((LinearLayout) view, loadingButton, textView, textView2, linearLayout, textView3, textInputEditText, textInputLayout, screenTitleView);
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

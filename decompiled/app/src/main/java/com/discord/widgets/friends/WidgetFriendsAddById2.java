package com.discord.widgets.friends;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetFriendsAddByIdBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsAddById.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAddById2 extends FunctionReferenceImpl implements Function1<View, WidgetFriendsAddByIdBinding> {
    public static final WidgetFriendsAddById2 INSTANCE = new WidgetFriendsAddById2();

    public WidgetFriendsAddById2() {
        super(1, WidgetFriendsAddByIdBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFriendsAddByIdBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFriendsAddByIdBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.friend_add_username_indicator;
        TextView textView = (TextView) view.findViewById(R.id.friend_add_username_indicator);
        if (textView != null) {
            i = R.id.friends_add_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.friends_add_container);
            if (linearLayout != null) {
                i = R.id.friends_add_send;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.friends_add_send);
                if (materialButton != null) {
                    i = R.id.friends_add_text_edit_wrap;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.friends_add_text_edit_wrap);
                    if (textInputLayout != null) {
                        return new WidgetFriendsAddByIdBinding((NestedScrollView) view, textView, linearLayout, materialButton, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

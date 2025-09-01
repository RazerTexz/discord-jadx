package com.discord.widgets.user;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import b.a.i.ViewUserStatusPresenceBinding;
import com.discord.R;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserStatusSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserStatusSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetUserStatusUpdateBinding> {
    public static final WidgetUserStatusSheet2 INSTANCE = new WidgetUserStatusSheet2();

    public WidgetUserStatusSheet2() {
        super(1, WidgetUserStatusUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserStatusUpdateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserStatusUpdateBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.user_status_update_custom;
            UserStatusPresenceCustomView userStatusPresenceCustomView = (UserStatusPresenceCustomView) view.findViewById(R.id.user_status_update_custom);
            if (userStatusPresenceCustomView != null) {
                i = R.id.user_status_update_dnd;
                View viewFindViewById = view.findViewById(R.id.user_status_update_dnd);
                if (viewFindViewById != null) {
                    ViewUserStatusPresenceBinding viewUserStatusPresenceBindingA = ViewUserStatusPresenceBinding.a(viewFindViewById);
                    i = R.id.user_status_update_idle;
                    View viewFindViewById2 = view.findViewById(R.id.user_status_update_idle);
                    if (viewFindViewById2 != null) {
                        ViewUserStatusPresenceBinding viewUserStatusPresenceBindingA2 = ViewUserStatusPresenceBinding.a(viewFindViewById2);
                        i = R.id.user_status_update_invisible;
                        View viewFindViewById3 = view.findViewById(R.id.user_status_update_invisible);
                        if (viewFindViewById3 != null) {
                            ViewUserStatusPresenceBinding viewUserStatusPresenceBindingA3 = ViewUserStatusPresenceBinding.a(viewFindViewById3);
                            i = R.id.user_status_update_online;
                            View viewFindViewById4 = view.findViewById(R.id.user_status_update_online);
                            if (viewFindViewById4 != null) {
                                return new WidgetUserStatusUpdateBinding((NestedScrollView) view, textView, userStatusPresenceCustomView, viewUserStatusPresenceBindingA, viewUserStatusPresenceBindingA2, viewUserStatusPresenceBindingA3, ViewUserStatusPresenceBinding.a(viewFindViewById4));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

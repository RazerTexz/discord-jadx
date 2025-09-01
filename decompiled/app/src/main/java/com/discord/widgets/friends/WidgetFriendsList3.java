package com.discord.widgets.friends;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetFriendsListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetFriendsListBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsListBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsList$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsList3 extends FunctionReferenceImpl implements Function1<View, WidgetFriendsListBinding> {
    public static final WidgetFriendsList3 INSTANCE = new WidgetFriendsList3();

    public WidgetFriendsList3() {
        super(1, WidgetFriendsListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFriendsListBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFriendsListBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.friends_list_empty_friends_state_view;
        EmptyFriendsStateView emptyFriendsStateView = (EmptyFriendsStateView) view.findViewById(R.id.friends_list_empty_friends_state_view);
        if (emptyFriendsStateView != null) {
            i = R.id.friends_list_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.friends_list_flipper);
            if (appViewFlipper != null) {
                i = R.id.friends_list_loading;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.friends_list_loading);
                if (recyclerView != null) {
                    i = R.id.friends_list_recycler;
                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.friends_list_recycler);
                    if (recyclerView2 != null) {
                        return new WidgetFriendsListBinding((RelativeLayout) view, emptyFriendsStateView, appViewFlipper, recyclerView, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

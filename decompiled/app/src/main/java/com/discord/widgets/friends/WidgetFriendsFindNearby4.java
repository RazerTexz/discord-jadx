package com.discord.widgets.friends;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.rlottie.RLottieImageView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsFindNearby.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetFriendsNearbyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsNearbyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsFindNearby4 extends FunctionReferenceImpl implements Function1<View, WidgetFriendsNearbyBinding> {
    public static final WidgetFriendsFindNearby4 INSTANCE = new WidgetFriendsFindNearby4();

    public WidgetFriendsFindNearby4() {
        super(1, WidgetFriendsNearbyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFriendsNearbyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFriendsNearbyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.nearby_friends_enable;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.nearby_friends_enable);
        if (materialButton != null) {
            i = R.id.nearby_friends_learn_more;
            TextView textView = (TextView) view.findViewById(R.id.nearby_friends_learn_more);
            if (textView != null) {
                i = R.id.nearby_friends_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.nearby_friends_recycler);
                if (recyclerView != null) {
                    i = R.id.nearby_friends_searching_body;
                    TextView textView2 = (TextView) view.findViewById(R.id.nearby_friends_searching_body);
                    if (textView2 != null) {
                        i = R.id.nearby_friends_searching_lottie;
                        RLottieImageView rLottieImageView = (RLottieImageView) view.findViewById(R.id.nearby_friends_searching_lottie);
                        if (rLottieImageView != null) {
                            i = R.id.nearby_friends_searching_title;
                            TextView textView3 = (TextView) view.findViewById(R.id.nearby_friends_searching_title);
                            if (textView3 != null) {
                                return new WidgetFriendsNearbyBinding((NestedScrollView) view, materialButton, textView, recyclerView, textView2, rLottieImageView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

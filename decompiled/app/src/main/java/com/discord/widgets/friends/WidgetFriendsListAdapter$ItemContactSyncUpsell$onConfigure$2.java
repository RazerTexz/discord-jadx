package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onLongClick", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2 implements View.OnLongClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter.ItemContactSyncUpsell this$0;

    public WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2(WidgetFriendsListAdapter.ItemContactSyncUpsell itemContactSyncUpsell) {
        this.this$0 = itemContactSyncUpsell;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Function1<View, Unit> onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter.ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsellLongClick();
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        onClickContactSyncUpsellLongClick.invoke(view);
        return true;
    }
}

package com.discord.widgets.friends;

import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetFriendsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FriendsListViewModel.Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemSuggestedFriend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$2(WidgetFriendsListAdapter.ItemSuggestedFriend itemSuggestedFriend, FriendsListViewModel.Item item) {
        super(0);
        this.this$0 = itemSuggestedFriend;
        this.$data = item;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetFriendsListAdapter.ItemSuggestedFriend.access$getAdapter$p(this.this$0).getOnClickApproveSuggestion().invoke(((FriendsListViewModel.Item.SuggestedFriend) this.$data).getSuggestion().getUser());
    }
}

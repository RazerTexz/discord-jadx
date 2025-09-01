package com.discord.widgets.forums;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ForumBrowserLayoutManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0004\u0010\tR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lkotlin/Function0;", "", "onLayoutCompleted", "setOnLayoutCompletedCallback", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "(Landroidx/recyclerview/widget/RecyclerView$State;)V", "onLayoutCompletedCallback", "Lkotlin/jvm/functions/Function0;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumBrowserLayoutManager extends LinearLayoutManager {
    private Function0<Unit> onLayoutCompletedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserLayoutManager(RecyclerView recyclerView) {
        super(recyclerView.getContext(), 1, false);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        Function0<Unit> function0 = this.onLayoutCompletedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setOnLayoutCompletedCallback(Function0<Unit> onLayoutCompleted) {
        Intrinsics3.checkNotNullParameter(onLayoutCompleted, "onLayoutCompleted");
        this.onLayoutCompletedCallback = onLayoutCompleted;
    }
}

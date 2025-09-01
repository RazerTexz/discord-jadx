package com.discord.widgets.forums;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ForumBrowserScrollListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\u0006J!\u0010\f\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0015R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/forums/ForumBrowserScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lkotlin/Function0;", "", "onScroll", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function0;)V", "onScrollEnd", "setOnScrollEndCallback", "Lkotlin/Function1;", "", "onScrollStateChanged", "setOnScrollStateChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "dx", "dy", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "onScrollCallback", "Lkotlin/jvm/functions/Function0;", "onScrollStateChangedCallback", "Lkotlin/jvm/functions/Function1;", "onScrollEndCallback", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumBrowserScrollListener extends RecyclerView.OnScrollListener {
    private Function0<Unit> onScrollCallback;
    private Function0<Unit> onScrollEndCallback;
    private Function1<? super Integer, Unit> onScrollStateChangedCallback;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        Function1<? super Integer, Unit> function1 = this.onScrollStateChangedCallback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(newState));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Function0<Unit> function0;
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            Function0<Unit> function02 = this.onScrollCallback;
            if (function02 != null) {
                function02.invoke();
            }
            if (linearLayoutManager.findLastVisibleItemPosition() < linearLayoutManager.getItemCount() - 5 || (function0 = this.onScrollEndCallback) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public final void setOnScrollCallback(Function0<Unit> onScroll) {
        Intrinsics3.checkNotNullParameter(onScroll, "onScroll");
        this.onScrollCallback = onScroll;
    }

    public final void setOnScrollEndCallback(Function0<Unit> onScrollEnd) {
        Intrinsics3.checkNotNullParameter(onScrollEnd, "onScrollEnd");
        this.onScrollEndCallback = onScrollEnd;
    }

    public final void setOnScrollStateChangedCallback(Function1<? super Integer, Unit> onScrollStateChanged) {
        Intrinsics3.checkNotNullParameter(onScrollStateChanged, "onScrollStateChanged");
        this.onScrollStateChangedCallback = onScrollStateChanged;
    }
}

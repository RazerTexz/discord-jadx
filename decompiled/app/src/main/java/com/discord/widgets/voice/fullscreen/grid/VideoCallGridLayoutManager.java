package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: VideoCallGridLayoutManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R,\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridLayoutManager;", "Lcom/discord/widgets/voice/fullscreen/grid/ResizingGridLayoutManager;", "", "getSpanCount", "()I", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "extraLayoutSpace", "", "calculateExtraLayoutSpace", "(Landroidx/recyclerview/widget/RecyclerView$State;[I)V", "onLayoutCompleted", "(Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lkotlin/Function0;", "recyclerviewSizeProvider", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function2;", "onLayoutCompletedEvent", "Lkotlin/jvm/functions/Function2;", "spanCount", "I", "orientation", "Landroid/content/Context;", "context", "<init>", "(Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function2;ILandroid/content/Context;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class VideoCallGridLayoutManager extends ResizingGridLayoutManager {
    private final Function2<VideoCallGridLayoutManager, RecyclerView.State, Unit> onLayoutCompletedEvent;
    private final Function0<Integer> recyclerviewSizeProvider;
    private final int spanCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoCallGridLayoutManager(Function0<Integer> function0, int i, Function2<? super VideoCallGridLayoutManager, ? super RecyclerView.State, Unit> function2, int i2, Context context) {
        super(context, i, i2);
        Intrinsics3.checkNotNullParameter(function0, "recyclerviewSizeProvider");
        Intrinsics3.checkNotNullParameter(context, "context");
        this.recyclerviewSizeProvider = function0;
        this.spanCount = i;
        this.onLayoutCompletedEvent = function2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        Intrinsics3.checkNotNullParameter(state, "state");
        Intrinsics3.checkNotNullParameter(extraLayoutSpace, "extraLayoutSpace");
        int iIntValue = this.recyclerviewSizeProvider.invoke().intValue();
        if (iIntValue <= 0) {
            super.calculateExtraLayoutSpace(state, extraLayoutSpace);
            return;
        }
        int i = iIntValue * 3;
        extraLayoutSpace[0] = i;
        extraLayoutSpace[1] = i;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager
    public int getSpanCount() {
        return this.spanCount;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        Function2<VideoCallGridLayoutManager, RecyclerView.State, Unit> function2 = this.onLayoutCompletedEvent;
        if (function2 != null) {
            function2.invoke(this, state);
        }
    }
}

package com.discord.utilities.recycler;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SelfHealingLinearLayoutManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\r\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bR\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/recycler/SelfHealingLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "exception", "", "resetAdapter", "(Ljava/lang/Throwable;)V", "logWarning", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "orientation", "", "reverseLayout", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$Adapter;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SelfHealingLinearLayoutManager extends LinearLayoutManager {
    private final RecyclerView.Adapter<?> adapter;
    private final RecyclerView recyclerView;

    /* compiled from: SelfHealingLinearLayoutManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.recycler.SelfHealingLinearLayoutManager$resetAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SelfHealingLinearLayoutManager.access$getAdapter$p(SelfHealingLinearLayoutManager.this).notifyDataSetChanged();
            SelfHealingLinearLayoutManager.access$getRecyclerView$p(SelfHealingLinearLayoutManager.this).invalidate();
        }
    }

    public /* synthetic */ SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView.Adapter adapter, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, adapter, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? false : z2);
    }

    public static final /* synthetic */ RecyclerView.Adapter access$getAdapter$p(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        return selfHealingLinearLayoutManager.adapter;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(SelfHealingLinearLayoutManager selfHealingLinearLayoutManager) {
        return selfHealingLinearLayoutManager.recyclerView;
    }

    private final void logWarning(Throwable exception) {
        StringBuilder sbU = outline.U("Triggered in adapter: ");
        sbU.append(this.adapter.getClass());
        AppLog.g.w("Invalid adapter configuration.", new Exception(sbU.toString(), exception));
    }

    private final void resetAdapter(Throwable exception) {
        this.recyclerView.post(new AnonymousClass1());
        logWarning(exception);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        String message;
        Intrinsics3.checkNotNullParameter(recycler, "recycler");
        Intrinsics3.checkNotNullParameter(state, "state");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IllegalArgumentException e) {
            resetAdapter(e);
        } catch (IndexOutOfBoundsException e2) {
            resetAdapter(e2);
        } catch (RuntimeException e3) {
            String message2 = e3.getMessage();
            if ((message2 == null || !Strings4.contains$default((CharSequence) message2, (CharSequence) "trying to unhide", false, 2, (Object) null)) && ((message = e3.getMessage()) == null || !Strings4.contains$default((CharSequence) message, (CharSequence) "trying to hide", false, 2, (Object) null))) {
                throw e3;
            }
            resetAdapter(e3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelfHealingLinearLayoutManager(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter, int i, boolean z2) {
        super(recyclerView.getContext(), i, z2);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        this.recyclerView = recyclerView;
        this.adapter = adapter;
    }
}

package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subscriptions.CompositeSubscription;

/* compiled from: MGRecyclerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00030\u0002:\u0001$B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b#\u0010\"J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ)\u0010\f\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0005¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001b\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "D", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItem", "(I)Ljava/lang/Object;", "", "dispose", "()V", "holder", "onBindViewHolder", "(Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;I)V", "viewType", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "invalidViewTypeException", "(I)Ljava/lang/IllegalArgumentException;", "Lrx/subscriptions/CompositeSubscription;", "cellSubscriptions", "Lrx/subscriptions/CompositeSubscription;", "getCellSubscriptions", "()Lrx/subscriptions/CompositeSubscription;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class MGRecyclerAdapter<D> extends RecyclerView.Adapter<MGRecyclerViewHolder<?, D>> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CompositeSubscription cellSubscriptions;
    private RecyclerView recycler;

    /* compiled from: MGRecyclerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0006\u001a\u00028\u0002\"\u0004\b\u0001\u0010\u0002\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter$Companion;", "", "D", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "adapter", "configure", "(Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;)Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final <D, T extends MGRecyclerAdapter<D>> T configure(T adapter) {
            Intrinsics3.checkNotNullParameter(adapter, "adapter");
            try {
                RecyclerView recycler = adapter.getRecycler();
                RecyclerView.LayoutManager layoutManager = adapter.getRecycler().getLayoutManager();
                RecyclerView.ItemAnimator itemAnimator = null;
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                SelfHealingLinearLayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(adapter.getRecycler(), adapter, linearLayoutManager != null ? linearLayoutManager.getOrientation() : 1, false);
                selfHealingLinearLayoutManager.setSmoothScrollbarEnabled(true);
                recycler.setLayoutManager(selfHealingLinearLayoutManager);
                recycler.setAdapter(adapter);
                recycler.setHasFixedSize(true);
                RecyclerView.ItemAnimator itemAnimator2 = recycler.getItemAnimator();
                if (itemAnimator2 instanceof SimpleItemAnimator) {
                    itemAnimator = itemAnimator2;
                }
                SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
                if (simpleItemAnimator != null) {
                    simpleItemAnimator.setSupportsChangeAnimations(false);
                }
                return adapter;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MGRecyclerAdapter(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.recycler = recyclerView;
        this.cellSubscriptions = new CompositeSubscription();
    }

    public static final <D, T extends MGRecyclerAdapter<D>> T configure(T t) {
        return (T) INSTANCE.configure(t);
    }

    public final void dispose() {
        this.cellSubscriptions.b();
    }

    public final CompositeSubscription getCellSubscriptions() {
        return this.cellSubscriptions;
    }

    public final Context getContext() {
        Context context = getRecycler().getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        return context;
    }

    public abstract D getItem(int position);

    public RecyclerView getRecycler() {
        return this.recycler;
    }

    @SuppressLint({"StringFormatMatches"})
    public final IllegalArgumentException invalidViewTypeException(int viewType) {
        Context context = getRecycler().getContext();
        return new IllegalArgumentException(String.valueOf(context != null ? FormatUtils.h(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, null, 4) : null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((MGRecyclerViewHolder) viewHolder, i);
    }

    public void setRecycler(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "<set-?>");
        this.recycler = recyclerView;
    }

    public void onBindViewHolder(MGRecyclerViewHolder<?, D> holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.onBindViewHolder(position);
    }
}

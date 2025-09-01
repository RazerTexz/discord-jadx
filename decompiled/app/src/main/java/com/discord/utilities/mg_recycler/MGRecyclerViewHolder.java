package com.discord.utilities.mg_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.Subscription;

/* compiled from: MGRecyclerViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0017J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00028\u00008\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "D", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(I)Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "data", "", "onConfigure", "(ILjava/lang/Object;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "adapter", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;)V", "layout", "(ILcom/discord/utilities/mg_recycler/MGRecyclerAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class MGRecyclerViewHolder<T extends MGRecyclerAdapter<D>, D> extends RecyclerView.ViewHolder {
    public final T adapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerViewHolder(View view, T t) {
        super(view);
        Intrinsics3.checkNotNullParameter(view, "itemView");
        Intrinsics3.checkNotNullParameter(t, "adapter");
        this.adapter = t;
    }

    public Subscription getSubscription() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T onBindViewHolder(int position) {
        T t = this.adapter;
        Subscription subscription = getSubscription();
        if (subscription != null) {
            t.getCellSubscriptions().c(subscription);
        }
        onConfigure(position, t.getItem(position));
        Subscription subscription2 = getSubscription();
        if (subscription2 != null) {
            t.getCellSubscriptions().a(subscription2);
        }
        return t;
    }

    public void onConfigure(int position, D data) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MGRecyclerViewHolder(@LayoutRes int i, T t) {
        Intrinsics3.checkNotNullParameter(t, "adapter");
        RecyclerView recycler = t.getRecycler();
        View viewInflate = LayoutInflater.from(recycler.getContext()).inflate(i, (ViewGroup) recycler, false);
        Intrinsics3.checkNotNullExpressionValue(viewInflate, "adapter.recycler.let {\n …se) // ktlint-disable\n  }");
        this(viewInflate, t);
    }
}

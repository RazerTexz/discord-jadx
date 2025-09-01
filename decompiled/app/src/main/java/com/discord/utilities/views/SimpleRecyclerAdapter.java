package com.discord.utilities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SimpleRecyclerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0002\u001d\u001eB1\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R(\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/views/SimpleRecyclerAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "data", "", "setData", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;I)V", "Ljava/util/List;", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "createViewHolder", "Lkotlin/jvm/functions/Function2;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "Companion", "ViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class SimpleRecyclerAdapter<T, VH extends ViewHolder<T>> extends RecyclerView.Adapter<VH> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function2<LayoutInflater, ViewGroup, VH> createViewHolder;
    private List<? extends T> data;

    /* compiled from: SimpleRecyclerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/utilities/views/SimpleRecyclerAdapter$Companion;", "", "Landroidx/recyclerview/widget/RecyclerView;", "", "addThemedDivider", "(Landroidx/recyclerview/widget/RecyclerView;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void addThemedDivider(RecyclerView recyclerView) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(recyclerView, "$this$addThemedDivider");
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(recyclerView, R.attr.colorPrimaryDivider, 0, 2, (Object) null);
            Resources resources = recyclerView.getResources();
            Context context = recyclerView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Drawable drawable = ResourcesCompat.getDrawable(resources, themedDrawableRes$default, context.getTheme());
            if (drawable != null) {
                Intrinsics3.checkNotNullExpressionValue(drawable, "ResourcesCompat.getDrawa… context.theme) ?: return");
                Context context2 = recyclerView.getContext();
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context2, ((LinearLayoutManager) layoutManager).getOrientation());
                dividerItemDecoration.setDrawable(drawable);
                recyclerView.addItemDecoration(dividerItemDecoration);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SimpleRecyclerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "", "bind", "(Ljava/lang/Object;)V", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics3.checkNotNullParameter(view, "itemView");
        }

        public abstract void bind(T data);
    }

    public /* synthetic */ SimpleRecyclerAdapter(List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Collections2.emptyList() : list, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((SimpleRecyclerAdapter<T, VH>) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends T> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleRecyclerAdapter(List<? extends T> list, Function2<? super LayoutInflater, ? super ViewGroup, ? extends VH> function2) {
        Intrinsics3.checkNotNullParameter(list, "data");
        Intrinsics3.checkNotNullParameter(function2, "createViewHolder");
        this.data = list;
        this.createViewHolder = function2;
    }

    public void onBindViewHolder(VH holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Function2<LayoutInflater, ViewGroup, VH> function2 = this.createViewHolder;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        Intrinsics3.checkNotNullExpressionValue(layoutInflaterFrom, "LayoutInflater.from(parent.context)");
        return function2.invoke(layoutInflaterFrom, parent);
    }
}

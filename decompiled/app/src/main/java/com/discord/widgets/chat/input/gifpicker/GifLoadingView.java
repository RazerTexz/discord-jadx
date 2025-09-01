package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.discord.R;
import com.discord.databinding.LoadingGifItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: GifLoadingView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001d\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0016B'\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "", "numColumns", "numRows", "updateView", "(II)V", "", "isStaggered", "Z", "Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifAdapter;", "loadingGifAdapter", "Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifAdapter;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LoadingGifAdapter", "LoadingGifViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifLoadingView extends RecyclerView {
    private boolean isStaggered;
    private final LoadingGifAdapter loadingGifAdapter;

    /* compiled from: GifLoadingView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifViewHolder;", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifViewHolder;I)V", "", "heightsDp", "setData", "(Ljava/util/List;)V", "Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingGifAdapter extends RecyclerView.Adapter<LoadingGifViewHolder> {
        private List<Integer> heightsDp = Collections2.emptyList();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.heightsDp.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            onBindViewHolder((LoadingGifViewHolder) viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setData(List<Integer> heightsDp) {
            Intrinsics3.checkNotNullParameter(heightsDp, "heightsDp");
            this.heightsDp = heightsDp;
            notifyDataSetChanged();
        }

        public void onBindViewHolder(LoadingGifViewHolder holder, int position) {
            Intrinsics3.checkNotNullParameter(holder, "holder");
            holder.configure(this.heightsDp.get(position).intValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public LoadingGifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_gif_item_view, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            LoadingGifItemViewBinding loadingGifItemViewBinding = new LoadingGifItemViewBinding((CardView) viewInflate);
            Intrinsics3.checkNotNullExpressionValue(loadingGifItemViewBinding, "LoadingGifItemViewBindin….context), parent, false)");
            return new LoadingGifViewHolder(loadingGifItemViewBinding);
        }
    }

    /* compiled from: GifLoadingView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifLoadingView$LoadingGifViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "heightDp", "", "configure", "(I)V", "Lcom/discord/databinding/LoadingGifItemViewBinding;", "binding", "Lcom/discord/databinding/LoadingGifItemViewBinding;", "<init>", "(Lcom/discord/databinding/LoadingGifItemViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingGifViewHolder extends RecyclerView.ViewHolder {
        private final LoadingGifItemViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingGifViewHolder(LoadingGifItemViewBinding loadingGifItemViewBinding) {
            super(loadingGifItemViewBinding.a);
            Intrinsics3.checkNotNullParameter(loadingGifItemViewBinding, "binding");
            this.binding = loadingGifItemViewBinding;
        }

        public final void configure(int heightDp) {
            CardView cardView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            CardView cardView2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.root");
            Resources resources = cardView2.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.root.resources");
            layoutParams.height = (int) (heightDp * resources.getDisplayMetrics().density);
            CardView cardView3 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.root");
            cardView3.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new LoadingGifAdapter();
    }

    private final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.GifLoadingView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.GifLoadingView, 0, 0)");
        try {
            this.isStaggered = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            setAdapter(this.loadingGifAdapter);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static /* synthetic */ void updateView$default(GifLoadingView gifLoadingView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 4;
        }
        gifLoadingView.updateView(i, i2);
    }

    public final void updateView(int numColumns, int numRows) {
        int i = 1;
        setLayoutManager(new StaggeredGridLayoutManager(numColumns, 1));
        addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), numColumns));
        int i2 = numRows * numColumns;
        ArrayList arrayList = new ArrayList();
        if (this.isStaggered) {
            arrayList.add(96);
            int i3 = i2 - 1;
            while (i < i3) {
                arrayList.add(Integer.valueOf((i % 2 != 0 || i >= numColumns) ? Opcodes.IF_ICMPNE : 96));
                i++;
            }
            arrayList.add(96);
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(96);
            }
        }
        this.loadingGifAdapter.setData(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new LoadingGifAdapter();
        initialize(attributeSet);
    }

    public /* synthetic */ GifLoadingView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.loadingGifAdapter = new LoadingGifAdapter();
        initialize(attributeSet);
    }

    public /* synthetic */ GifLoadingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

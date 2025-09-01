package com.discord.widgets.bugreports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import com.discord.databinding.WidgetBugReportFeatureListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002! B\u001b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00170\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R%\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/discord/widgets/bugreports/BugReportFeatureAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/discord/api/bugreport/Feature;", "data", "", "setData", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem;", "Ljava/util/List;", "Lkotlin/Function1;", "onClickListener", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "BugReportFeatureItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BugReportFeatureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_TYPE_FEATURE = 0;
    private static final int ITEM_TYPE_HEADER = 1;
    private List<? extends BugReportFeatureItem> data;
    private final Function1<BugReportConfig2, Unit> onClickListener;

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem;", "", "<init>", "()V", "FeatureItem", "HeaderItem", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem;", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class BugReportFeatureItem {

        /* compiled from: WidgetBugReport.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem;", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem;", "Lcom/discord/api/bugreport/Feature;", "feature", "Lcom/discord/api/bugreport/Feature;", "getFeature", "()Lcom/discord/api/bugreport/Feature;", "<init>", "(Lcom/discord/api/bugreport/Feature;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class FeatureItem extends BugReportFeatureItem {
            private final BugReportConfig2 feature;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FeatureItem(BugReportConfig2 bugReportConfig2) {
                super(null);
                Intrinsics3.checkNotNullParameter(bugReportConfig2, "feature");
                this.feature = bugReportConfig2;
            }

            public final BugReportConfig2 getFeature() {
                return this.feature;
            }
        }

        /* compiled from: WidgetBugReport.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem;", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter$BugReportFeatureItem;", "Lcom/discord/api/bugreport/Feature;", "header", "Lcom/discord/api/bugreport/Feature;", "getHeader", "()Lcom/discord/api/bugreport/Feature;", "<init>", "(Lcom/discord/api/bugreport/Feature;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class HeaderItem extends BugReportFeatureItem {
            private final BugReportConfig2 header;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HeaderItem(BugReportConfig2 bugReportConfig2) {
                super(null);
                Intrinsics3.checkNotNullParameter(bugReportConfig2, "header");
                this.header = bugReportConfig2;
            }

            public final BugReportConfig2 getHeader() {
                return this.header;
            }
        }

        private BugReportFeatureItem() {
        }

        public /* synthetic */ BugReportFeatureItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureAdapter(Function1<? super BugReportConfig2, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        this.onClickListener = function1;
        this.data = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        BugReportFeatureItem bugReportFeatureItem = this.data.get(position);
        if (bugReportFeatureItem instanceof BugReportFeatureItem.FeatureItem) {
            return 0;
        }
        if (bugReportFeatureItem instanceof BugReportFeatureItem.HeaderItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Function1<BugReportConfig2, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof BugReportFeatureViewHolder) {
            BugReportFeatureItem bugReportFeatureItem = this.data.get(position);
            Objects.requireNonNull(bugReportFeatureItem, "null cannot be cast to non-null type com.discord.widgets.bugreports.BugReportFeatureAdapter.BugReportFeatureItem.FeatureItem");
            ((BugReportFeatureViewHolder) holder).bind(((BugReportFeatureItem.FeatureItem) bugReportFeatureItem).getFeature());
        } else {
            if (!(holder instanceof BugReportFeatureHeaderViewHolder)) {
                throw new IllegalStateException("Unknown view type");
            }
            BugReportFeatureHeaderViewHolder bugReportFeatureHeaderViewHolder = (BugReportFeatureHeaderViewHolder) holder;
            boolean z2 = position == 0;
            BugReportFeatureItem bugReportFeatureItem2 = this.data.get(position);
            Objects.requireNonNull(bugReportFeatureItem2, "null cannot be cast to non-null type com.discord.widgets.bugreports.BugReportFeatureAdapter.BugReportFeatureItem.HeaderItem");
            bugReportFeatureHeaderViewHolder.bind(z2, ((BugReportFeatureItem.HeaderItem) bugReportFeatureItem2).getHeader());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_bug_report_feature_list_item, parent, false);
            int i = R.id.feature_list_item_feature;
            TextView textView = (TextView) viewInflate.findViewById(R.id.feature_list_item_feature);
            if (textView != null) {
                i = R.id.feature_list_item_squad;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.feature_list_item_squad);
                if (textView2 != null) {
                    WidgetBugReportFeatureListItemBinding widgetBugReportFeatureListItemBinding = new WidgetBugReportFeatureListItemBinding((ConstraintLayout) viewInflate, textView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(widgetBugReportFeatureListItemBinding, "WidgetBugReportFeatureLi….context), parent, false)");
                    return new BugReportFeatureViewHolder(widgetBugReportFeatureListItemBinding, this.onClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            throw new IllegalStateException("Unknown view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_bug_report_feature_header_list_item, parent, false);
        int i2 = R.id.gap;
        View viewFindViewById = viewInflate2.findViewById(R.id.gap);
        if (viewFindViewById != null) {
            i2 = R.id.header;
            TextView textView3 = (TextView) viewInflate2.findViewById(R.id.header);
            if (textView3 != null) {
                WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding = new WidgetBugReportFeatureHeaderListItemBinding((ConstraintLayout) viewInflate2, viewFindViewById, textView3);
                Intrinsics3.checkNotNullExpressionValue(widgetBugReportFeatureHeaderListItemBinding, "WidgetBugReportFeatureHe….context), parent, false)");
                return new BugReportFeatureHeaderViewHolder(widgetBugReportFeatureHeaderListItemBinding, this.onClickListener);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }

    public final void setData(List<BugReportConfig2> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        String squad = null;
        for (BugReportConfig2 bugReportConfig2 : data) {
            if (!Intrinsics3.areEqual(bugReportConfig2.getSquad(), squad)) {
                arrayList.add(new BugReportFeatureItem.HeaderItem(new BugReportConfig2(bugReportConfig2.getSquad(), bugReportConfig2.getSquad(), bugReportConfig2.getAsanaInboxId())));
                squad = bugReportConfig2.getSquad();
            }
            arrayList.add(new BugReportFeatureItem.FeatureItem(bugReportConfig2));
        }
        this.data = arrayList;
        notifyDataSetChanged();
    }
}

package com.discord.widgets.settings.developer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.y.l0.ExperimentOverrideView2;
import b.a.y.l0.ExperimentOverrideView3;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ExperimentOverridesListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.experiments.ExperimentOverrideView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ExperimentOverridesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$ExperimentViewHolder;", "", "Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$Item;", "items", "", "setData", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$ExperimentViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$ExperimentViewHolder;I)V", "getItemCount", "()I", "Ljava/util/List;", "<init>", "()V", "ExperimentViewHolder", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ExperimentOverridesAdapter extends RecyclerView.Adapter<ExperimentViewHolder> {
    private List<? extends Item> items = Collections2.emptyList();

    /* compiled from: ExperimentOverridesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$ExperimentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$Item;", "item", "", "bind", "(Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$Item;)V", "Lcom/discord/databinding/ExperimentOverridesListItemBinding;", "binding", "Lcom/discord/databinding/ExperimentOverridesListItemBinding;", "<init>", "(Lcom/discord/databinding/ExperimentOverridesListItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ExperimentViewHolder extends RecyclerView.ViewHolder {
        private final ExperimentOverridesListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExperimentViewHolder(ExperimentOverridesListItemBinding experimentOverridesListItemBinding) {
            super(experimentOverridesListItemBinding.a);
            Intrinsics3.checkNotNullParameter(experimentOverridesListItemBinding, "binding");
            this.binding = experimentOverridesListItemBinding;
        }

        public final void bind(Item item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            ExperimentOverrideView experimentOverrideView = this.binding.f2104b;
            String name = item.getName();
            String apiName = item.getApiName();
            Integer overrideBucket = item.getOverrideBucket();
            List<String> bucketDescriptions = item.getBucketDescriptions();
            Function1<Integer, Unit> onOverrideBucketSelected = item.getOnOverrideBucketSelected();
            Function0<Unit> onOverrideBucketCleared = item.getOnOverrideBucketCleared();
            Objects.requireNonNull(experimentOverrideView);
            Intrinsics3.checkNotNullParameter(name, "experimentName");
            Intrinsics3.checkNotNullParameter(apiName, "experimentApiName");
            Intrinsics3.checkNotNullParameter(bucketDescriptions, "bucketDescriptions");
            Intrinsics3.checkNotNullParameter(onOverrideBucketSelected, "onOverrideBucketSelected");
            Intrinsics3.checkNotNullParameter(onOverrideBucketCleared, "onOverrideBucketCleared");
            TextView textView = experimentOverrideView.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.experimentOverrideExperimentName");
            textView.setText(name);
            TextView textView2 = experimentOverrideView.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.experimentOverrideExperimentApiName");
            textView2.setText(apiName);
            TextView textView3 = experimentOverrideView.binding.f133b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.experimentOverrideBucketDescriptions");
            textView3.setText(_Collections.joinToString$default(bucketDescriptions, "\n", null, null, 0, null, null, 62, null));
            ArrayList arrayList = new ArrayList();
            if (overrideBucket == null) {
                arrayList.add(new ExperimentOverrideView.b(null, "Select..."));
            }
            int size = bucketDescriptions.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new ExperimentOverrideView.b(Integer.valueOf(i), outline.q("Bucket ", i)));
            }
            Spinner spinner = experimentOverrideView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(spinner, "binding.experimentOverrideBucketsSpinner");
            Context context = experimentOverrideView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            spinner.setAdapter((SpinnerAdapter) new ExperimentOverrideView.a(context, arrayList));
            if (overrideBucket != null) {
                experimentOverrideView.binding.c.setSelection(overrideBucket.intValue());
            }
            Spinner spinner2 = experimentOverrideView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(spinner2, "binding.experimentOverrideBucketsSpinner");
            spinner2.setOnItemSelectedListener(new ExperimentOverrideView2(onOverrideBucketSelected));
            experimentOverrideView.binding.d.setOnClickListener(new ExperimentOverrideView3(onOverrideBucketCleared));
            TextView textView4 = experimentOverrideView.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.experimentOverrideClear");
            textView4.setVisibility(overrideBucket != null ? 0 : 8);
        }
    }

    /* compiled from: ExperimentOverridesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter$Item;", "", "", "getApiName", "()Ljava/lang/String;", "apiName", "", "getBucketDescriptions", "()Ljava/util/List;", "bucketDescriptions", "getName", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "getOverrideBucket", "()Ljava/lang/Integer;", "overrideBucket", "Lkotlin/Function0;", "", "getOnOverrideBucketCleared", "()Lkotlin/jvm/functions/Function0;", "onOverrideBucketCleared", "Lkotlin/Function1;", "getOnOverrideBucketSelected", "()Lkotlin/jvm/functions/Function1;", "onOverrideBucketSelected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Item {
        String getApiName();

        List<String> getBucketDescriptions();

        String getName();

        Function0<Unit> getOnOverrideBucketCleared();

        Function1<Integer, Unit> getOnOverrideBucketSelected();

        Integer getOverrideBucket();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ExperimentViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends Item> items) {
        Intrinsics3.checkNotNullParameter(items, "items");
        this.items = items;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ExperimentViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ExperimentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.experiment_overrides_list_item, parent, false);
        ExperimentOverrideView experimentOverrideView = (ExperimentOverrideView) viewInflate.findViewById(R.id.experiment_overrides_list_item_experiment_override_view);
        if (experimentOverrideView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.experiment_overrides_list_item_experiment_override_view)));
        }
        ExperimentOverridesListItemBinding experimentOverridesListItemBinding = new ExperimentOverridesListItemBinding((CardView) viewInflate, experimentOverrideView);
        Intrinsics3.checkNotNullExpressionValue(experimentOverridesListItemBinding, "ExperimentOverridesListI….context), parent, false)");
        return new ExperimentViewHolder(experimentOverridesListItemBinding);
    }
}

package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportFeatureHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "isTop", "Lcom/discord/api/bugreport/Feature;", "feature", "", "bind", "(ZLcom/discord/api/bugreport/Feature;)V", "Lcom/discord/databinding/WidgetBugReportFeatureHeaderListItemBinding;", "binding", "Lcom/discord/databinding/WidgetBugReportFeatureHeaderListItemBinding;", "getBinding", "()Lcom/discord/databinding/WidgetBugReportFeatureHeaderListItemBinding;", "Lkotlin/Function1;", "onClickListener", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lcom/discord/databinding/WidgetBugReportFeatureHeaderListItemBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BugReportFeatureHeaderViewHolder extends RecyclerView.ViewHolder {
    private final WidgetBugReportFeatureHeaderListItemBinding binding;
    private final Function1<BugReportConfig2, Unit> onClickListener;

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportFeatureHeaderViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ BugReportConfig2 $feature;

        public AnonymousClass1(BugReportConfig2 bugReportConfig2) {
            this.$feature = bugReportConfig2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BugReportFeatureHeaderViewHolder.this.getOnClickListener().invoke(this.$feature);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureHeaderViewHolder(WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding, Function1<? super BugReportConfig2, Unit> function1) {
        super(widgetBugReportFeatureHeaderListItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetBugReportFeatureHeaderListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureHeaderListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(boolean isTop, BugReportConfig2 feature) {
        Intrinsics3.checkNotNullParameter(feature, "feature");
        View view = this.binding.f2243b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.gap");
        view.setVisibility(isTop ^ true ? 0 : 8);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.header");
        textView.setText(feature.getName());
        this.binding.c.setOnClickListener(new AnonymousClass1(feature));
    }

    public final WidgetBugReportFeatureHeaderListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<BugReportConfig2, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}

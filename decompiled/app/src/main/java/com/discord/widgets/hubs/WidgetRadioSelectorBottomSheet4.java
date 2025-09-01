package com.discord.widgets.hubs;

import android.view.View;
import com.discord.R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/hubs/RadioSelectorViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "data", "", "bind", "(Lcom/discord/widgets/hubs/RadioSelectorItem;)V", "Lkotlin/Function1;", "", "onSelected", "Lkotlin/jvm/functions/Function1;", "getOnSelected", "()Lkotlin/jvm/functions/Function1;", "Lcom/discord/databinding/WidgetRadioSelectorViewHolderBinding;", "binding", "Lcom/discord/databinding/WidgetRadioSelectorViewHolderBinding;", "getBinding", "()Lcom/discord/databinding/WidgetRadioSelectorViewHolderBinding;", "<init>", "(Lcom/discord/databinding/WidgetRadioSelectorViewHolderBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.RadioSelectorViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet4 extends SimpleRecyclerAdapter.ViewHolder<WidgetRadioSelectorBottomSheet2> {
    private final WidgetRadioSelectorViewHolderBinding binding;
    private final Function1<Integer, Unit> onSelected;

    /* compiled from: WidgetRadioSelectorBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.RadioSelectorViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetRadioSelectorBottomSheet2 $data;

        public AnonymousClass1(WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2) {
            this.$data = widgetRadioSelectorBottomSheet2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRadioSelectorBottomSheet4.this.getOnSelected().invoke(Integer.valueOf(this.$data.getId()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetRadioSelectorBottomSheet4(WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding, Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(widgetRadioSelectorViewHolderBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onSelected");
        IconRow iconRow = widgetRadioSelectorViewHolderBinding.a;
        Intrinsics3.checkNotNullExpressionValue(iconRow, "binding.root");
        super(iconRow);
        this.binding = widgetRadioSelectorViewHolderBinding;
        this.onSelected = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2) {
        bind2(widgetRadioSelectorBottomSheet2);
    }

    public final WidgetRadioSelectorViewHolderBinding getBinding() {
        return this.binding;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    /* renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(WidgetRadioSelectorBottomSheet2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.binding.f2518b.setText(data.getText());
        this.binding.f2518b.setImageRes(Integer.valueOf(data.getSelected() ? R.drawable.ic_check_brand_16dp : 0));
        this.binding.f2518b.setOnClickListener(new AnonymousClass1(data));
    }
}

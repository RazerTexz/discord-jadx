package com.discord.widgets.hubs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR)\u0010%\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/widgets/hubs/WidgetRadioSelectorBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "onSelected", "Lkotlin/jvm/functions/Function1;", "getOnSelected", "()Lkotlin/jvm/functions/Function1;", "setOnSelected", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/widgets/hubs/RadioSelectorItems;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/hubs/RadioSelectorItems;", "args", "Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", "binding", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "Lcom/discord/widgets/hubs/RadioSelectorViewHolder;", "adapter$delegate", "getAdapter", "()Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "adapter", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetRadioSelectorBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super Integer, Unit> onSelected;

    /* compiled from: WidgetRadioSelectorBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/hubs/WidgetRadioSelectorBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/hubs/RadioSelectorItems;", "items", "Lkotlin/Function1;", "", "", "onSelected", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/hubs/RadioSelectorItems;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, WidgetRadioSelectorBottomSheet3 items, Function1<? super Integer, Unit> onSelected) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(onSelected, "onSelected");
            WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet = new WidgetRadioSelectorBottomSheet();
            widgetRadioSelectorBottomSheet.setArguments(AnimatableValueParser.e2(items));
            widgetRadioSelectorBottomSheet.setOnSelected(onSelected);
            widgetRadioSelectorBottomSheet.show(fragmentManager, Reflection2.getOrCreateKotlinClass(WidgetRadioSelectorBottomSheet.class).toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetRadioSelectorBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetRadioSelectorBottomSheet6.INSTANCE, null, 2, null);
        this.args = LazyJVM.lazy(new WidgetRadioSelectorBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        this.adapter = LazyJVM.lazy(new WidgetRadioSelectorBottomSheet5(this));
    }

    public final SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4> getAdapter() {
        return (SimpleRecyclerAdapter) this.adapter.getValue();
    }

    public final WidgetRadioSelectorBottomSheet3 getArgs() {
        return (WidgetRadioSelectorBottomSheet3) this.args.getValue();
    }

    public final WidgetRadioSelectorBottomSheetBinding getBinding() {
        return (WidgetRadioSelectorBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_radio_selector_bottom_sheet;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(getAdapter());
        TextView textView = getBinding().f2517b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.radioSelectorBottomSheetTitle");
        textView.setText(getArgs().getTitle());
    }

    public final void setOnSelected(Function1<? super Integer, Unit> function1) {
        this.onSelected = function1;
    }
}

package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "Lcom/discord/widgets/hubs/RadioSelectorViewHolder;", "invoke", "()Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet5 extends Lambda implements Function0<SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4>> {
    public final /* synthetic */ WidgetRadioSelectorBottomSheet this$0;

    /* compiled from: WidgetRadioSelectorBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Lcom/discord/widgets/hubs/RadioSelectorViewHolder;", "invoke", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/discord/widgets/hubs/RadioSelectorViewHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetRadioSelectorBottomSheet4> {

        /* compiled from: WidgetRadioSelectorBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$adapter$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02991 extends Lambda implements Function1<Integer, Unit> {
            public C02991() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                Function1<Integer, Unit> onSelected = WidgetRadioSelectorBottomSheet5.this.this$0.getOnSelected();
                if (onSelected != null) {
                    onSelected.invoke(Integer.valueOf(i));
                }
                WidgetRadioSelectorBottomSheet5.this.this$0.dismiss();
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet4 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return invoke2(layoutInflater, viewGroup);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetRadioSelectorBottomSheet4 invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            View viewInflate = layoutInflater.inflate(R.layout.widget_radio_selector_view_holder, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            IconRow iconRow = (IconRow) viewInflate;
            WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding = new WidgetRadioSelectorViewHolderBinding(iconRow, iconRow);
            Intrinsics3.checkNotNullExpressionValue(widgetRadioSelectorViewHolderBinding, "WidgetRadioSelectorViewH…(inflater, parent, false)");
            return new WidgetRadioSelectorBottomSheet4(widgetRadioSelectorViewHolderBinding, new C02991());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet5(WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet) {
        super(0);
        this.this$0 = widgetRadioSelectorBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4> invoke() {
        return new SimpleRecyclerAdapter<>(this.this$0.getArgs().getItems(), new AnonymousClass1());
    }
}

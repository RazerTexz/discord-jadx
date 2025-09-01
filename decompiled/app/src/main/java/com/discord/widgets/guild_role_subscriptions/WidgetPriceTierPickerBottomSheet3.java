package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.billing.PremiumUtils2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "priceTier", "Lkotlin/Function1;", "", "onItemClickListener", "configureUI", "(ILkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/DialogSimpleSelectorItemBinding;", "binding", "Lcom/discord/databinding/DialogSimpleSelectorItemBinding;", "<init>", "(Lcom/discord/databinding/DialogSimpleSelectorItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet3 extends RecyclerView.ViewHolder {
    private final DialogSimpleSelectorItemBinding binding;

    /* compiled from: WidgetPriceTierPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierViewHolder$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onItemClickListener;
        public final /* synthetic */ int $priceTier;

        public AnonymousClass1(Function1 function1, int i) {
            this.$onItemClickListener = function1;
            this.$priceTier = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onItemClickListener.invoke(Integer.valueOf(this.$priceTier));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPriceTierPickerBottomSheet3(DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
        super(dialogSimpleSelectorItemBinding.a);
        Intrinsics3.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
        this.binding = dialogSimpleSelectorItemBinding;
    }

    public final void configureUI(int priceTier, Function1<? super Integer, Unit> onItemClickListener) {
        Intrinsics3.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        TextView textView = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        TextView textView2 = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.root");
        Context context = textView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        textView.setText(PremiumUtils2.getFormattedPriceUsd(priceTier, context));
        this.binding.a.setOnClickListener(new AnonymousClass1(onItemClickListener, priceTier));
    }
}

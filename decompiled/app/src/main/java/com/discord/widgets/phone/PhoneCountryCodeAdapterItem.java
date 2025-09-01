package com.discord.widgets.phone;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PhoneCountryCodeAdapterItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/phone/PhoneCountryCodeAdapterItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/models/phone/PhoneCountryCode;", "data", "", "bind", "(Lcom/discord/models/phone/PhoneCountryCode;)V", "Lcom/discord/databinding/WidgetPhoneCountryCodeListItemBinding;", "binding", "Lcom/discord/databinding/WidgetPhoneCountryCodeListItemBinding;", "Lcom/discord/widgets/phone/PhoneCountryCodeAdapter;", "adapter", "Lcom/discord/widgets/phone/PhoneCountryCodeAdapter;", "<init>", "(Lcom/discord/widgets/phone/PhoneCountryCodeAdapter;Lcom/discord/databinding/WidgetPhoneCountryCodeListItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PhoneCountryCodeAdapterItem extends RecyclerView.ViewHolder {
    private final PhoneCountryCodeAdapter adapter;
    private final WidgetPhoneCountryCodeListItemBinding binding;

    /* compiled from: PhoneCountryCodeAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.phone.PhoneCountryCodeAdapterItem$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ PhoneCountryCode $data;

        public AnonymousClass1(PhoneCountryCode phoneCountryCode) {
            this.$data = phoneCountryCode;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PhoneCountryCodeAdapter2 onCountryCodeSelectedListener = PhoneCountryCodeAdapterItem.access$getAdapter$p(PhoneCountryCodeAdapterItem.this).getOnCountryCodeSelectedListener();
            if (onCountryCodeSelectedListener != null) {
                onCountryCodeSelectedListener.onCountryCodeSelected(this.$data);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCountryCodeAdapterItem(PhoneCountryCodeAdapter phoneCountryCodeAdapter, WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding) {
        super(widgetPhoneCountryCodeListItemBinding.a);
        Intrinsics3.checkNotNullParameter(phoneCountryCodeAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(widgetPhoneCountryCodeListItemBinding, "binding");
        this.adapter = phoneCountryCodeAdapter;
        this.binding = widgetPhoneCountryCodeListItemBinding;
    }

    public static final /* synthetic */ PhoneCountryCodeAdapter access$getAdapter$p(PhoneCountryCodeAdapterItem phoneCountryCodeAdapterItem) {
        return phoneCountryCodeAdapterItem.adapter;
    }

    public final void bind(PhoneCountryCode data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.phoneCountryCodeName");
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(phoneUtils.getTranslatedStringForCountry(data, context));
        TextView textView2 = this.binding.f2510b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.phoneCountryCodeCode");
        textView2.setText(data.getPhoneCountryCode());
        this.binding.c.setOnClickListener(new AnonymousClass1(data));
    }
}

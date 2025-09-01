package com.discord.widgets.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PhoneCountryCodeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/phone/PhoneCountryCodeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/phone/PhoneCountryCodeAdapterItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/phone/PhoneCountryCodeAdapterItem;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/phone/PhoneCountryCodeAdapterItem;I)V", "getItemCount", "()I", "", "Lcom/discord/models/phone/PhoneCountryCode;", "countryCodes", "Lcom/discord/widgets/phone/OnCountryCodeSelectedListener;", "onCountryCodeSelectedListener", "configure", "(Ljava/util/List;Lcom/discord/widgets/phone/OnCountryCodeSelectedListener;)V", "<set-?>", "Lcom/discord/widgets/phone/OnCountryCodeSelectedListener;", "getOnCountryCodeSelectedListener", "()Lcom/discord/widgets/phone/OnCountryCodeSelectedListener;", "items", "Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PhoneCountryCodeAdapter extends RecyclerView.Adapter<PhoneCountryCodeAdapterItem> {
    private List<PhoneCountryCode> items = Collections2.emptyList();
    private PhoneCountryCodeAdapter2 onCountryCodeSelectedListener;

    public final void configure(List<PhoneCountryCode> countryCodes, PhoneCountryCodeAdapter2 onCountryCodeSelectedListener) {
        Intrinsics3.checkNotNullParameter(countryCodes, "countryCodes");
        Intrinsics3.checkNotNullParameter(onCountryCodeSelectedListener, "onCountryCodeSelectedListener");
        this.items = countryCodes;
        this.onCountryCodeSelectedListener = onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final PhoneCountryCodeAdapter2 getOnCountryCodeSelectedListener() {
        return this.onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((PhoneCountryCodeAdapterItem) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(PhoneCountryCodeAdapterItem holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PhoneCountryCodeAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_phone_country_code_list_item, parent, false);
        int i = R.id.phone_country_code_code;
        TextView textView = (TextView) viewInflate.findViewById(R.id.phone_country_code_code);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.phone_country_code_name);
            if (textView2 != null) {
                WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding = new WidgetPhoneCountryCodeListItemBinding(constraintLayout, textView, constraintLayout, textView2);
                Intrinsics3.checkNotNullExpressionValue(widgetPhoneCountryCodeListItemBinding, "WidgetPhoneCountryCodeLi….context), parent, false)");
                return new PhoneCountryCodeAdapterItem(this, widgetPhoneCountryCodeListItemBinding);
            }
            i = R.id.phone_country_code_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}

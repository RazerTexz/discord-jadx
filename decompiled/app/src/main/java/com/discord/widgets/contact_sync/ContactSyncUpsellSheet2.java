package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.LayoutContactSyncToggleInfoBinding;
import com.discord.R;
import com.discord.databinding.ContactSyncUpsellSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ContactSyncUpsellSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ContactSyncUpsellSheet2 extends FunctionReferenceImpl implements Function1<View, ContactSyncUpsellSheetBinding> {
    public static final ContactSyncUpsellSheet2 INSTANCE = new ContactSyncUpsellSheet2();

    public ContactSyncUpsellSheet2() {
        super(1, ContactSyncUpsellSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ContactSyncUpsellSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ContactSyncUpsellSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.contact_sync_upsell_cta;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.contact_sync_upsell_cta);
        if (linearLayout != null) {
            i = R.id.contact_sync_upsell_next_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.contact_sync_upsell_next_button);
            if (materialButton != null) {
                i = R.id.contact_sync_upsell_skip_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.contact_sync_upsell_skip_button);
                if (materialButton2 != null) {
                    i = R.id.contact_sync_upsell_subtitle;
                    TextView textView = (TextView) view.findViewById(R.id.contact_sync_upsell_subtitle);
                    if (textView != null) {
                        i = R.id.contact_sync_upsell_title;
                        TextView textView2 = (TextView) view.findViewById(R.id.contact_sync_upsell_title);
                        if (textView2 != null) {
                            i = R.id.contact_sync_upsell_toggle_info;
                            View viewFindViewById = view.findViewById(R.id.contact_sync_upsell_toggle_info);
                            if (viewFindViewById != null) {
                                return new ContactSyncUpsellSheetBinding((ConstraintLayout) view, linearLayout, materialButton, materialButton2, textView, textView2, LayoutContactSyncToggleInfoBinding.a(viewFindViewById));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

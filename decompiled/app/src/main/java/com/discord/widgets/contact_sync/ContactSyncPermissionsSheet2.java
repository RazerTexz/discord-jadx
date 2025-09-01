package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ContactSyncPermissionsSheetBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ContactSyncPermissionsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ContactSyncPermissionsSheet2 extends FunctionReferenceImpl implements Function1<View, ContactSyncPermissionsSheetBinding> {
    public static final ContactSyncPermissionsSheet2 INSTANCE = new ContactSyncPermissionsSheet2();

    public ContactSyncPermissionsSheet2() {
        super(1, ContactSyncPermissionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ContactSyncPermissionsSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ContactSyncPermissionsSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.contact_sync_permissions_discoverable_toggle;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.contact_sync_permissions_discoverable_toggle);
        if (checkedSetting != null) {
            i = R.id.contact_sync_permissions_discovery_info_1;
            TextView textView = (TextView) view.findViewById(R.id.contact_sync_permissions_discovery_info_1);
            if (textView != null) {
                i = R.id.contact_sync_permissions_discovery_info_2;
                TextView textView2 = (TextView) view.findViewById(R.id.contact_sync_permissions_discovery_info_2);
                if (textView2 != null) {
                    i = R.id.contact_sync_permissions_email_toggle;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.contact_sync_permissions_email_toggle);
                    if (checkedSetting2 != null) {
                        i = R.id.contact_sync_permissions_learn_more;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.contact_sync_permissions_learn_more);
                        if (linkifiedTextView != null) {
                            i = R.id.contact_sync_permissions_phone_toggle;
                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.contact_sync_permissions_phone_toggle);
                            if (checkedSetting3 != null) {
                                i = R.id.contact_sync_permissions_subtitle;
                                TextView textView3 = (TextView) view.findViewById(R.id.contact_sync_permissions_subtitle);
                                if (textView3 != null) {
                                    return new ContactSyncPermissionsSheetBinding((ConstraintLayout) view, checkedSetting, textView, textView2, checkedSetting2, linkifiedTextView, checkedSetting3, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

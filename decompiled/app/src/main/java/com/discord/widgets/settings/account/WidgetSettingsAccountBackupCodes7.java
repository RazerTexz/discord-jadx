package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountBackupCodes7 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountBackupCodesBinding> {
    public static final WidgetSettingsAccountBackupCodes7 INSTANCE = new WidgetSettingsAccountBackupCodes7();

    public WidgetSettingsAccountBackupCodes7() {
        super(1, WidgetSettingsAccountBackupCodesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountBackupCodesBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountBackupCodesBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.settings_backup_codes_generate;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_backup_codes_generate);
            if (materialButton != null) {
                i = R.id.settings_backup_codes_info;
                TextView textView = (TextView) view.findViewById(R.id.settings_backup_codes_info);
                if (textView != null) {
                    i = R.id.settings_backup_codes_rv;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.settings_backup_codes_rv);
                    if (recyclerView != null) {
                        return new WidgetSettingsAccountBackupCodesBinding((CoordinatorLayout) view, dimmerView, materialButton, textView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

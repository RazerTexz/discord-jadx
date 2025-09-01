package com.discord.widgets.settings.account;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes6 implements View.OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;

    public WidgetSettingsAccountBackupCodes6(MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("backup code", ((WidgetSettingsAccountBackupCodes.BackupCodeItem) this.$data).getBackupCode().getCode());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        AppToast.g(view.getContext(), R.string.copied_text, 0, null, 12);
    }
}

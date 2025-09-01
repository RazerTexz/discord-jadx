package com.discord.widgets.settings.account;

import android.content.Context;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "<anonymous parameter 0>", "", "inputText", "", "invoke", "(Landroid/content/Context;Ljava/lang/String;)V", "com/discord/widgets/settings/account/WidgetSettingsAccountBackupCodes$showVerificationKeyModal$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$showVerificationKeyModal$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes4 extends Lambda implements Function2<Context, String, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes4(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(2);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
        invoke2(context, str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str) {
        Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(str, "inputText");
        WidgetSettingsAccountBackupCodes.access$setVerificationKey$p(this.this$0, str);
        WidgetSettingsAccountBackupCodes.getBackupCodes$default(this.this$0, false, 1, null);
    }
}

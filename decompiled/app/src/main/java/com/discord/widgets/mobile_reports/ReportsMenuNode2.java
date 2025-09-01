package com.discord.widgets.mobile_reports;

import androidx.core.app.NotificationCompat;
import com.discord.api.report.ReportNodeElementData;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: ReportsMenuNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "isChecked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "com/discord/widgets/mobile_reports/ReportsMenuNode$$special$$inlined$also$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupCheckbox$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ReportsMenuNode2<T> implements Action1<Boolean> {
    public final /* synthetic */ MobileReportsViewModel.CheckboxElement $checkboxData$inlined;
    public final /* synthetic */ ReportNodeElementData $entry$inlined;
    public final /* synthetic */ ReportsMenuNode this$0;

    public ReportsMenuNode2(ReportNodeElementData reportNodeElementData, ReportsMenuNode reportsMenuNode, MobileReportsViewModel.CheckboxElement checkboxElement) {
        this.$entry$inlined = reportNodeElementData;
        this.this$0 = reportsMenuNode;
        this.$checkboxData$inlined = checkboxElement;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        if (bool.booleanValue()) {
            this.$checkboxData$inlined.getSelections().add(this.$entry$inlined);
        } else {
            this.$checkboxData$inlined.getSelections().remove(this.$entry$inlined);
        }
    }
}

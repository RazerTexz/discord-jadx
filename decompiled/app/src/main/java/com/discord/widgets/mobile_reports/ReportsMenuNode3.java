package com.discord.widgets.mobile_reports;

import android.view.View;
import com.discord.api.report.ReportNodeChild;
import kotlin.Metadata;

/* compiled from: ReportsMenuNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/mobile_reports/ReportsMenuNode$$special$$inlined$also$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupChildren$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ReportsMenuNode3 implements View.OnClickListener {
    public final /* synthetic */ ReportNodeChild $child$inlined;
    public final /* synthetic */ ReportsMenuNode this$0;

    public ReportsMenuNode3(ReportNodeChild reportNodeChild, ReportsMenuNode reportsMenuNode) {
        this.$child$inlined = reportNodeChild;
        this.this$0 = reportsMenuNode;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ReportsMenuNode.access$childClickListener(this.this$0, this.$child$inlined);
    }
}

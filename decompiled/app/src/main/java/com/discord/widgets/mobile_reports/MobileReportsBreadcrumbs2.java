package com.discord.widgets.mobile_reports;

import com.discord.api.report.ReportNodeElementData;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: MobileReportsBreadcrumbs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/report/ReportNodeElementData;", "data", "", "invoke", "(Lcom/discord/api/report/ReportNodeElementData;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.mobile_reports.MobileReportsBreadcrumbs$setup$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MobileReportsBreadcrumbs2 extends Lambda implements Function1<ReportNodeElementData, CharSequence> {
    public static final MobileReportsBreadcrumbs2 INSTANCE = new MobileReportsBreadcrumbs2();

    public MobileReportsBreadcrumbs2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ReportNodeElementData reportNodeElementData) {
        return invoke2(reportNodeElementData);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ReportNodeElementData reportNodeElementData) {
        Intrinsics3.checkNotNullParameter(reportNodeElementData, "data");
        return reportNodeElementData.getElementValue();
    }
}

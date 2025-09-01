package com.discord.widgets.settings.connections;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsUserConnections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_ID, "", "invoke", "(Ljava/lang/String;)V", "com/discord/widgets/settings/connections/WidgetSettingsUserConnections$onViewBound$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSettingsUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        super(1);
        this.this$0 = widgetSettingsUserConnections;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        WidgetSettingsUserConnections.access$getViewModel$p(this.this$0).joinConnectionIntegrationGuild(str);
    }
}

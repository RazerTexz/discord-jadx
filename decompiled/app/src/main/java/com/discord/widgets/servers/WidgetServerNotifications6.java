package com.discord.widgets.servers;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$onMute$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications6(WidgetServerNotifications widgetServerNotifications, long j) {
        super(0);
        this.this$0 = widgetServerNotifications;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
        long j = this.$guildId;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(j, parentFragmentManager);
    }
}

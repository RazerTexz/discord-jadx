package com.discord.widgets.servers.settings.members;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsMembersAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00040\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/UserId;", "<anonymous parameter 0>", "", "Lcom/discord/primitives/RoleId;", "<anonymous parameter 1>", "", "invoke", "(JLjava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersAdapter$memberSelectedListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter3 extends Lambda implements Function2<Long, List<? extends Long>, Unit> {
    public static final WidgetServerSettingsMembersAdapter3 INSTANCE = new WidgetServerSettingsMembersAdapter3();

    public WidgetServerSettingsMembersAdapter3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 1>");
    }
}

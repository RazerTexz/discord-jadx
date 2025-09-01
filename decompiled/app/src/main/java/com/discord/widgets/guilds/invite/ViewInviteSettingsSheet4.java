package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ViewInviteSettingsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite$Settings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelInvite$Settings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$updateSettings$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet4 extends Lambda implements Function1<ModelInvite.Settings, Unit> {
    public static final ViewInviteSettingsSheet4 INSTANCE = new ViewInviteSettingsSheet4();

    public ViewInviteSettingsSheet4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite.Settings settings) {
        invoke2(settings);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite.Settings settings) {
        Intrinsics3.checkNotNullParameter(settings, "it");
    }
}

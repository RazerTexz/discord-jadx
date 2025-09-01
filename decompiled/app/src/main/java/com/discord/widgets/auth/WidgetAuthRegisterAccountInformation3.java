package com.discord.widgets.auth;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthRegisterAccountInformation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "birthdayValue", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$birthdayLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation3(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(1);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "success", null, 4, null);
        companion.getINSTANCE().setBirthday(Long.valueOf(j));
        AnalyticsTracker.INSTANCE.ageGateSubmitted(j, "Register");
        WidgetAuthRegisterAccountInformation.register$default(this.this$0, null, 1, null);
    }
}

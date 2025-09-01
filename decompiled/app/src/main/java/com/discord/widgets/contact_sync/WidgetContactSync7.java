package com.discord.widgets.contact_sync;

import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.contact_sync.WidgetContactSync;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetContactSync.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel;", "invoke", "()Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetContactSync7 extends Lambda implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* compiled from: WidgetContactSync.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$viewModel$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
                WidgetContactSync.access$launchCaptchaFlow(WidgetContactSync7.this.this$0, error);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync7(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        WidgetContactSync.Companion companion = WidgetContactSync.INSTANCE;
        return new WidgetContactSyncViewModel(companion.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), companion.getPhoneDiscoverableFromIntent(this.this$0.requireAppActivity()), companion.getEmailDiscoverableFromIntent(this.this$0.requireAppActivity()), null, null, null, false, new AnonymousClass1(), 120, null);
    }
}

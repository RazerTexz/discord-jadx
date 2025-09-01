package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: WidgetSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/settings/WidgetSettings$onViewBound$1$23", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsBinding $this_with;
    public final /* synthetic */ WidgetSettings this$0;

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "isEnabled", "", "invoke", "(Z)V", "com/discord/widgets/settings/WidgetSettings$onViewBound$1$23$1", "updateUploadDebugLogsUI"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        public static /* synthetic */ void invoke$default(AnonymousClass1 anonymousClass1, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            anonymousClass1.invoke(z2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetSettings widgetSettings;
            int i;
            TextView textView = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.$this_with.J;
            Intrinsics3.checkNotNullExpressionValue(textView, "uploadDebugLogs");
            textView.setEnabled(z2);
            TextView textView2 = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.$this_with.J;
            Intrinsics3.checkNotNullExpressionValue(textView2, "uploadDebugLogs");
            if (z2) {
                widgetSettings = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0;
                i = R.string.upload_debug_logs;
            } else {
                widgetSettings = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0;
                i = R.string.working;
            }
            textView2.setText(widgetSettings.getString(i));
        }
    }

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "com/discord/widgets/settings/WidgetSettings$onViewBound$1$23$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$updateUploadDebugLogsUI$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0, R.string.upload_debug_log_success, 0, 4);
            AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "com/discord/widgets/settings/WidgetSettings$onViewBound$1$23$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$updateUploadDebugLogsUI$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    /* compiled from: WidgetSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/widgets/settings/WidgetSettings$onViewBound$1$23$4", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnonymousClass1 anonymousClass1) {
            super(0);
            this.$updateUploadDebugLogsUI$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    public WidgetSettings$onViewBound$$inlined$with$lambda$6(WidgetSettingsBinding widgetSettingsBinding, WidgetSettings widgetSettings) {
        this.$this_with = widgetSettingsBinding;
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.invoke(false);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.uploadSystemLog(), this.this$0, null, 2, null);
        Context context = this.this$0.getContext();
        String name = this.$this_with.getClass().getName();
        Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, context, name, (Function1) null, new AnonymousClass2(anonymousClass1), new AnonymousClass3(anonymousClass1), new AnonymousClass4(anonymousClass1), (Function0) null, 68, (Object) null);
    }
}

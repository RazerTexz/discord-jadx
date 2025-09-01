package com.discord.widgets.accessibility;

import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.WidgetAccessibilityDetectionDialog;
import com.discord.app.AppComponent;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityMonitor4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: AccessibilityDetectionNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/accessibility/AccessibilityDetectionNavigator;", "", "Lcom/discord/utilities/accessibility/AccessibilityState;", "accessibilityState", "", "showAccessibilityDetectionDialog", "(Lcom/discord/utilities/accessibility/AccessibilityState;)V", "Lcom/discord/app/AppComponent;", "appComponent", "enqueueNoticeWhenEnabled", "(Lcom/discord/app/AppComponent;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AccessibilityDetectionNavigator {
    public static final AccessibilityDetectionNavigator INSTANCE = new AccessibilityDetectionNavigator();

    /* compiled from: AccessibilityDetectionNavigator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityState;", "p1", "", "invoke", "(Lcom/discord/utilities/accessibility/AccessibilityState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<AccessibilityMonitor4, Unit> {
        public AnonymousClass1(AccessibilityDetectionNavigator accessibilityDetectionNavigator) {
            super(1, accessibilityDetectionNavigator, AccessibilityDetectionNavigator.class, "showAccessibilityDetectionDialog", "showAccessibilityDetectionDialog(Lcom/discord/utilities/accessibility/AccessibilityState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityMonitor4 accessibilityMonitor4) {
            invoke2(accessibilityMonitor4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityMonitor4 accessibilityMonitor4) {
            Intrinsics3.checkNotNullParameter(accessibilityMonitor4, "p1");
            AccessibilityDetectionNavigator.access$showAccessibilityDetectionDialog((AccessibilityDetectionNavigator) this.receiver, accessibilityMonitor4);
        }
    }

    /* compiled from: AccessibilityDetectionNavigator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetAccessibilityDetectionDialog.Companion bVar = WidgetAccessibilityDetectionDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(bVar);
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new WidgetAccessibilityDetectionDialog().show(supportFragmentManager, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG");
            return true;
        }
    }

    private AccessibilityDetectionNavigator() {
    }

    public static final /* synthetic */ void access$showAccessibilityDetectionDialog(AccessibilityDetectionNavigator accessibilityDetectionNavigator, AccessibilityMonitor4 accessibilityMonitor4) {
        accessibilityDetectionNavigator.showAccessibilityDetectionDialog(accessibilityMonitor4);
    }

    private final void showAccessibilityDetectionDialog(AccessibilityMonitor4 accessibilityState) {
        if (accessibilityState.getFeatures().contains(AccessibilityFeatureFlags.SCREENREADER)) {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("ALLOW_ACCESSIBILITY_DETECTION_DIALOG", null, 0L, 0, true, null, 0L, false, 0L, AnonymousClass1.INSTANCE, 486, null));
        }
    }

    public final void enqueueNoticeWhenEnabled(AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(AccessibilityMonitor.INSTANCE.getINSTANCE().observeAccessibilityState(), appComponent, null, 2, null), AccessibilityDetectionNavigator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

package com.discord.utilities.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: AccessibilityMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b(\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R2\u0010&\u001a\u001e\u0012\f\u0012\n %*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n %*\u0004\u0018\u00010\u00110\u00110$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityMonitor;", "", "Landroid/content/Context;", "context", "", "handleInitialState", "(Landroid/content/Context;)V", "", "enabled", "handleScreenreaderEnabledUpdate", "(Z)V", "handleReduceMotionUpdated", "()V", "", "uiMode", "handleUIModeUpdate", "(I)V", "Lcom/discord/utilities/accessibility/AccessibilityState;", "newState", "updateAccessibilityState", "(Lcom/discord/utilities/accessibility/AccessibilityState;)V", "bindContext", "Lrx/Observable;", "observeAccessibilityState", "()Lrx/Observable;", "Landroid/view/accessibility/AccessibilityManager;", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "Landroid/database/ContentObserver;", "animationScaleObserver", "Landroid/database/ContentObserver;", "accessibilityState", "Lcom/discord/utilities/accessibility/AccessibilityState;", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/ContentResolver;", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "accessibilityStateSubject", "Lrx/subjects/SerializedSubject;", "<init>", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AccessibilityMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(AccessibilityMonitor2.INSTANCE);
    private AccessibilityManager accessibilityManager;
    private AccessibilityMonitor4 accessibilityState;
    private final SerializedSubject<AccessibilityMonitor4, AccessibilityMonitor4> accessibilityStateSubject;
    private final ContentObserver animationScaleObserver = new AccessibilityMonitor3(this, new Handler(Looper.getMainLooper()));
    private ContentResolver contentResolver;

    /* compiled from: AccessibilityMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityMonitor$Companion;", "", "Landroid/app/Application;", "application", "", "initialize", "(Landroid/app/Application;)V", "Lcom/discord/utilities/accessibility/AccessibilityMonitor;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/utilities/accessibility/AccessibilityMonitor;", "INSTANCE", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final AccessibilityMonitor getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = AccessibilityMonitor.access$getINSTANCE$cp();
            Companion companion = AccessibilityMonitor.INSTANCE;
            return (AccessibilityMonitor) lazyAccess$getINSTANCE$cp.getValue();
        }

        public final void initialize(Application application) {
            Intrinsics3.checkNotNullParameter(application, "application");
            getINSTANCE().bindContext(application);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AccessibilityMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "enabled", "", "onAccessibilityStateChanged", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.accessibility.AccessibilityMonitor$handleInitialState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AccessibilityManager.AccessibilityStateChangeListener {

        /* compiled from: AccessibilityMonitor.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.accessibility.AccessibilityMonitor$handleInitialState$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02061<T> implements Action1<Unit> {
            public final /* synthetic */ boolean $enabled;

            public C02061(boolean z2) {
                this.$enabled = z2;
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Unit unit) {
                call2(unit);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Unit unit) {
                AccessibilityMonitor.access$handleScreenreaderEnabledUpdate(AccessibilityMonitor.this, this.$enabled);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean z2) {
            new ScalarSynchronousObservable(Unit.a).q(200L, TimeUnit.MILLISECONDS).V(new C02061(z2));
        }
    }

    public AccessibilityMonitor() {
        AccessibilityMonitor4 accessibilityMonitor4 = new AccessibilityMonitor4(null, 1, null);
        this.accessibilityState = accessibilityMonitor4;
        this.accessibilityStateSubject = new SerializedSubject<>(BehaviorSubject.l0(accessibilityMonitor4));
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ void access$handleReduceMotionUpdated(AccessibilityMonitor accessibilityMonitor) {
        accessibilityMonitor.handleReduceMotionUpdated();
    }

    public static final /* synthetic */ void access$handleScreenreaderEnabledUpdate(AccessibilityMonitor accessibilityMonitor, boolean z2) {
        accessibilityMonitor.handleScreenreaderEnabledUpdate(z2);
    }

    private final synchronized void handleInitialState(Context context) {
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            this.accessibilityManager = accessibilityManager;
            if (accessibilityManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            accessibilityManager.addAccessibilityStateChangeListener(new AnonymousClass1());
            AccessibilityManager accessibilityManager2 = this.accessibilityManager;
            if (accessibilityManager2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            handleScreenreaderEnabledUpdate(accessibilityManager2.isEnabled());
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            this.contentResolver = contentResolver;
            Uri uriFor = Settings.Global.getUriFor("transition_animation_scale");
            ContentResolver contentResolver2 = this.contentResolver;
            if (contentResolver2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("contentResolver");
            }
            contentResolver2.registerContentObserver(uriFor, false, this.animationScaleObserver);
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            handleUIModeUpdate(resources.getConfiguration().uiMode);
        }
    }

    private final void handleReduceMotionUpdated() {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("contentResolver");
        }
        String string = Settings.Global.getString(contentResolver, "transition_animation_scale");
        if (Intrinsics3.areEqual(string, "0.0") || Intrinsics3.areEqual(string, "0")) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION);
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleScreenreaderEnabledUpdate(boolean enabled) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabled) {
            Intrinsics3.checkNotNullExpressionValue(enabledAccessibilityServiceList, "services");
            if (!enabledAccessibilityServiceList.isEmpty()) {
                enumSetCopyOf.add(AccessibilityFeatureFlags.SCREENREADER);
            } else {
                enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
            }
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    private final void handleUIModeUpdate(int uiMode) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        int i = uiMode & 48;
        if (i == 16) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
        } else if (i != 32) {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
        } else {
            enumSetCopyOf.add(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    private final void updateAccessibilityState(AccessibilityMonitor4 newState) {
        this.accessibilityState = newState;
        this.accessibilityStateSubject.k.onNext(newState);
    }

    public final void bindContext(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        handleInitialState(context);
    }

    public final Observable<AccessibilityMonitor4> observeAccessibilityState() {
        Observable<AccessibilityMonitor4> observableR = this.accessibilityStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "accessibilityStateSubject.distinctUntilChanged()");
        return observableR;
    }
}

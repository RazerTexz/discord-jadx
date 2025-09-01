package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityMonitor4;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreAccessibility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u00105\u001a\u000204\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u0015J\u0019\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\u0004\b\u001f\u0010\u001eJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0004H\u0017¢\u0006\u0004\b!\u0010\"R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010)R:\u00100\u001a&\u0012\f\u0012\n /*\u0004\u0018\u00010\b0\b /*\u0012\u0012\f\u0012\n /*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010$R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010)¨\u0006:"}, d2 = {"Lcom/discord/stores/StoreAccessibility;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/utilities/accessibility/AccessibilityState;", "state", "", "updateMonitoredAccessibilityState", "(Lcom/discord/utilities/accessibility/AccessibilityState;)V", "Ljava/util/EnumSet;", "Lcom/discord/utilities/accessibility/AccessibilityFeatureFlags;", "getAccessibilityFeatures", "()Ljava/util/EnumSet;", "", "isScreenreaderEnabled", "()Z", "isReducedMotionEnabled", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "allowed", "updateDetectionAllowed", "(Z)V", "", "scale", "updateFontScale", "(I)V", "enabled", "setReducedMotionEnabled", "Lrx/Observable;", "observeAccessibilityFeatures", "()Lrx/Observable;", "observeScreenreaderEnabled", "observeReducedMotionEnabled", "snapshotData", "()V", "accessibilityFeaturesSnapshot", "Ljava/util/EnumSet;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "reducedMotionEnabled", "Z", "Lcom/discord/utilities/accessibility/AccessibilityMonitor;", "accessibilityMonitor", "Lcom/discord/utilities/accessibility/AccessibilityMonitor;", "isDetectionAllowed", "fontScaledUp", "kotlin.jvm.PlatformType", "accessibilityFeatures", "Lcom/discord/utilities/persister/Persister;", "reducedMotionCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "fontScaledDown", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/accessibility/AccessibilityMonitor;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreAccessibility extends StoreV2 {
    private EnumSet<AccessibilityFeatureFlags> accessibilityFeatures;
    private EnumSet<AccessibilityFeatureFlags> accessibilityFeaturesSnapshot;
    private final AccessibilityMonitor accessibilityMonitor;
    private final Dispatcher dispatcher;
    private boolean fontScaledDown;
    private boolean fontScaledUp;
    private boolean isDetectionAllowed;
    private final ObservationDeck observationDeck;
    private final Persister<Boolean> reducedMotionCache;
    private boolean reducedMotionEnabled;

    /* compiled from: StoreAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityState;", "it", "", "invoke", "(Lcom/discord/utilities/accessibility/AccessibilityState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAccessibility$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<AccessibilityMonitor4, Unit> {

        /* compiled from: StoreAccessibility.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAccessibility$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00731 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ AccessibilityMonitor4 $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00731(AccessibilityMonitor4 accessibilityMonitor4) {
                super(0);
                this.$it = accessibilityMonitor4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreAccessibility.access$updateMonitoredAccessibilityState(StoreAccessibility.this, this.$it);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityMonitor4 accessibilityMonitor4) {
            invoke2(accessibilityMonitor4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityMonitor4 accessibilityMonitor4) {
            Intrinsics3.checkNotNullParameter(accessibilityMonitor4, "it");
            StoreAccessibility.access$getDispatcher$p(StoreAccessibility.this).schedule(new C00731(accessibilityMonitor4));
        }
    }

    /* compiled from: StoreAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/EnumSet;", "Lcom/discord/utilities/accessibility/AccessibilityFeatureFlags;", "invoke", "()Ljava/util/EnumSet;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAccessibility$observeAccessibilityFeatures$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<EnumSet<AccessibilityFeatureFlags>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ EnumSet<AccessibilityFeatureFlags> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final EnumSet<AccessibilityFeatureFlags> invoke2() {
            return StoreAccessibility.this.getAccessibilityFeatures();
        }
    }

    /* compiled from: StoreAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAccessibility$observeReducedMotionEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreAccessibility.access$getReducedMotionEnabled$p(StoreAccessibility.this);
        }
    }

    /* compiled from: StoreAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAccessibility$observeScreenreaderEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreAccessibility.this.isScreenreaderEnabled();
        }
    }

    /* compiled from: StoreAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAccessibility$setReducedMotionEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$enabled = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAccessibility.access$setReducedMotionEnabled$p(StoreAccessibility.this, this.$enabled);
            StoreAccessibility.this.markChanged();
        }
    }

    public /* synthetic */ StoreAccessibility(Dispatcher dispatcher, ObservationDeck observationDeck, AccessibilityMonitor accessibilityMonitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? AccessibilityMonitor.INSTANCE.getINSTANCE() : accessibilityMonitor);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreAccessibility storeAccessibility) {
        return storeAccessibility.dispatcher;
    }

    public static final /* synthetic */ boolean access$getReducedMotionEnabled$p(StoreAccessibility storeAccessibility) {
        return storeAccessibility.reducedMotionEnabled;
    }

    public static final /* synthetic */ void access$setReducedMotionEnabled$p(StoreAccessibility storeAccessibility, boolean z2) {
        storeAccessibility.reducedMotionEnabled = z2;
    }

    public static final /* synthetic */ void access$updateMonitoredAccessibilityState(StoreAccessibility storeAccessibility, AccessibilityMonitor4 accessibilityMonitor4) {
        storeAccessibility.updateMonitoredAccessibilityState(accessibilityMonitor4);
    }

    @Store3
    private final void updateMonitoredAccessibilityState(AccessibilityMonitor4 state) {
        this.accessibilityFeatures = EnumSet.copyOf((EnumSet) state.getFeatures());
        markChanged();
    }

    public final EnumSet<AccessibilityFeatureFlags> getAccessibilityFeatures() {
        return this.accessibilityFeaturesSnapshot;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.reducedMotionEnabled = this.reducedMotionCache.get().booleanValue();
        ObservableExtensionsKt.appSubscribe$default(this.accessibilityMonitor.observeAccessibilityState(), StoreAccessibility.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    /* renamed from: isReducedMotionEnabled, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final boolean isScreenreaderEnabled() {
        return getAccessibilityFeatures().contains(AccessibilityFeatureFlags.SCREENREADER);
    }

    public final Observable<EnumSet<AccessibilityFeatureFlags>> observeAccessibilityFeatures() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeReducedMotionEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeScreenreaderEnabled() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void setReducedMotionEnabled(boolean enabled) {
        this.dispatcher.schedule(new AnonymousClass1(enabled));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityFeatures);
        if (!this.isDetectionAllowed) {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
        }
        if (this.reducedMotionEnabled) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION_FROM_USER_SETTINGS);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION_FROM_USER_SETTINGS);
        }
        if (this.fontScaledUp) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.CHAT_FONT_SCALE_INCREASED);
        }
        if (this.fontScaledDown) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.CHAT_FONT_SCALE_DECREASED);
        }
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        this.accessibilityFeaturesSnapshot = enumSetCopyOf;
        AnalyticSuperProperties.INSTANCE.setAccessibilityProperties(isScreenreaderEnabled(), getAccessibilityFeatures());
        this.reducedMotionCache.set(Boolean.valueOf(this.reducedMotionEnabled), true);
    }

    @Store3
    public final void updateDetectionAllowed(boolean allowed) {
        this.isDetectionAllowed = allowed;
        markChanged();
    }

    @Store3
    public final void updateFontScale(int scale) {
        if (scale == 100 || scale == -1) {
            this.fontScaledUp = false;
            this.fontScaledDown = false;
        } else if (scale > 100) {
            this.fontScaledUp = true;
            this.fontScaledDown = false;
        } else if (scale < 100) {
            this.fontScaledUp = false;
            this.fontScaledDown = true;
        }
        markChanged();
    }

    public StoreAccessibility(Dispatcher dispatcher, ObservationDeck observationDeck, AccessibilityMonitor accessibilityMonitor) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(accessibilityMonitor, "accessibilityMonitor");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.accessibilityMonitor = accessibilityMonitor;
        AccessibilityFeatureFlags accessibilityFeatureFlags = AccessibilityFeatureFlags.NONE;
        this.accessibilityFeatures = EnumSet.of(accessibilityFeatureFlags);
        this.reducedMotionCache = new Persister<>("CACHE_KEY_ACCESSIBILITY_REDUCED_MOTION_ENABLED", Boolean.FALSE);
        EnumSet<AccessibilityFeatureFlags> enumSetOf = EnumSet.of(accessibilityFeatureFlags);
        Intrinsics3.checkNotNullExpressionValue(enumSetOf, "EnumSet.of(AccessibilityFeatureFlags.NONE)");
        this.accessibilityFeaturesSnapshot = enumSetOf;
    }
}

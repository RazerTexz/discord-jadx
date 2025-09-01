package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccessibilityBinding;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetSettingsAccessibility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAccessibility;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", "", "currentStickerAnimationSettings", "Lcom/discord/views/CheckedSetting;", "radio", "stickerAnimationSetting", "configureStickerAnimationRadio", "(ILcom/discord/views/CheckedSetting;I)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/views/RadioManager;", "stickersAnimationRadioManager", "Lcom/discord/views/RadioManager;", "Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", "binding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsAccessibility extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccessibility.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccessibilityBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager stickersAnimationRadioManager;

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAccessibility.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0082\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\tJ\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", "", "", "component1", "()Z", "component2", "component3", "", "component4", "()I", "reducedMotionEnabled", "allowAnimatedEmoji", "autoPlayGifs", "currentStickerAnimationSettings", "copy", "(ZZZI)Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getCurrentStickerAnimationSettings", "Z", "getAllowAnimatedEmoji", "getAutoPlayGifs", "getReducedMotionEnabled", "<init>", "(ZZZI)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean allowAnimatedEmoji;
        private final boolean autoPlayGifs;
        private final int currentStickerAnimationSettings;
        private final boolean reducedMotionEnabled;

        /* compiled from: WidgetSettingsAccessibility.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableH = Observable.h(companion.getAccessibility().observeReducedMotionEnabled(), companion.getUserSettings().observeIsAnimatedEmojisEnabled(false), companion.getUserSettings().observeIsAutoPlayGifsEnabled(false), companion.getUserSettings().observeStickerAnimationSettings(false), WidgetSettingsAccessibility2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ngs\n          )\n        }");
                return observableH;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(boolean z2, boolean z3, boolean z4, int i) {
            this.reducedMotionEnabled = z2;
            this.allowAnimatedEmoji = z3;
            this.autoPlayGifs = z4;
            this.currentStickerAnimationSettings = i;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, boolean z3, boolean z4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = model.reducedMotionEnabled;
            }
            if ((i2 & 2) != 0) {
                z3 = model.allowAnimatedEmoji;
            }
            if ((i2 & 4) != 0) {
                z4 = model.autoPlayGifs;
            }
            if ((i2 & 8) != 0) {
                i = model.currentStickerAnimationSettings;
            }
            return model.copy(z2, z3, z4, i);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAllowAnimatedEmoji() {
            return this.allowAnimatedEmoji;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        /* renamed from: component4, reason: from getter */
        public final int getCurrentStickerAnimationSettings() {
            return this.currentStickerAnimationSettings;
        }

        public final Model copy(boolean reducedMotionEnabled, boolean allowAnimatedEmoji, boolean autoPlayGifs, int currentStickerAnimationSettings) {
            return new Model(reducedMotionEnabled, allowAnimatedEmoji, autoPlayGifs, currentStickerAnimationSettings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.reducedMotionEnabled == model.reducedMotionEnabled && this.allowAnimatedEmoji == model.allowAnimatedEmoji && this.autoPlayGifs == model.autoPlayGifs && this.currentStickerAnimationSettings == model.currentStickerAnimationSettings;
        }

        public final boolean getAllowAnimatedEmoji() {
            return this.allowAnimatedEmoji;
        }

        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final int getCurrentStickerAnimationSettings() {
            return this.currentStickerAnimationSettings;
        }

        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.reducedMotionEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.allowAnimatedEmoji;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.autoPlayGifs;
            return ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.currentStickerAnimationSettings;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(reducedMotionEnabled=");
            sbU.append(this.reducedMotionEnabled);
            sbU.append(", allowAnimatedEmoji=");
            sbU.append(this.allowAnimatedEmoji);
            sbU.append(", autoPlayGifs=");
            sbU.append(this.autoPlayGifs);
            sbU.append(", currentStickerAnimationSettings=");
            return outline.B(sbU, this.currentStickerAnimationSettings, ")");
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$configureStickerAnimationRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ int $stickerAnimationSetting;

        public AnonymousClass1(int i) {
            this.$stickerAnimationSetting = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettings().setStickerAnimationSettings(WidgetSettingsAccessibility.this.getAppActivity(), this.$stickerAnimationSetting);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).f2589b;
            Intrinsics3.checkNotNullExpressionValue(WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).f2589b, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting.g(!r0.isChecked(), true);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).c;
            Intrinsics3.checkNotNullExpressionValue(WidgetSettingsAccessibility.access$getBinding$p(WidgetSettingsAccessibility.this).c, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting.g(!r0.isChecked(), true);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSettingsAccessibility widgetSettingsAccessibility) {
            super(1, widgetSettingsAccessibility, WidgetSettingsAccessibility.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetSettingsAccessibility.access$configureUI((WidgetSettingsAccessibility) this.receiver, model);
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreAccessibility accessibility = StoreStream.INSTANCE.getAccessibility();
            Intrinsics3.checkNotNullExpressionValue(bool, "it");
            accessibility.setReducedMotionEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "checked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
            AppActivity appActivity = WidgetSettingsAccessibility.this.getAppActivity();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            userSettings.setIsAnimatedEmojisEnabled(appActivity, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsAccessibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "checked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAccessibility$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Boolean> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            userSettings.setIsAutoPlayGifsEnabled(bool.booleanValue());
        }
    }

    public WidgetSettingsAccessibility() {
        super(R.layout.widget_settings_accessibility);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccessibility3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccessibility widgetSettingsAccessibility, Model model) {
        widgetSettingsAccessibility.configureUI(model);
    }

    public static final /* synthetic */ WidgetSettingsAccessibilityBinding access$getBinding$p(WidgetSettingsAccessibility widgetSettingsAccessibility) {
        return widgetSettingsAccessibility.getBinding();
    }

    private final void configureStickerAnimationRadio(int currentStickerAnimationSettings, CheckedSetting radio, int stickerAnimationSetting) {
        radio.e(new AnonymousClass1(stickerAnimationSetting));
        RadioManager radioManager = this.stickersAnimationRadioManager;
        if (radioManager == null || currentStickerAnimationSettings != stickerAnimationSetting || radioManager == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccessibilityReducedMotionSwitch");
        checkedSetting.setChecked(model.getReducedMotionEnabled());
        if (!model.getReducedMotionEnabled()) {
            CheckedSetting checkedSetting2 = getBinding().f2589b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
            checkedSetting2.setChecked(model.getAllowAnimatedEmoji());
            int currentStickerAnimationSettings = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.stickersAlwaysAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings, checkedSetting3, 0);
            int currentStickerAnimationSettings2 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting4 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.stickersAnimateOnInteraction");
            configureStickerAnimationRadio(currentStickerAnimationSettings2, checkedSetting4, 1);
            int currentStickerAnimationSettings3 = model.getCurrentStickerAnimationSettings();
            CheckedSetting checkedSetting5 = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.stickersNeverAnimate");
            configureStickerAnimationRadio(currentStickerAnimationSettings3, checkedSetting5, 2);
            CheckedSetting checkedSetting6 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
            checkedSetting6.setChecked(model.getAutoPlayGifs());
            getBinding().f2589b.e(new AnonymousClass1());
            getBinding().c.e(new AnonymousClass2());
            return;
        }
        getBinding().f2589b.b(R.string.accessibility_reduced_motion_settings_override);
        CheckedSetting checkedSetting7 = getBinding().f2589b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsAccessib…tyAllowAnimateEmojiSwitch");
        checkedSetting7.setChecked(false);
        Iterator it = Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}).iterator();
        while (it.hasNext()) {
            ((CheckedSetting) it.next()).b(R.string.stickers_auto_play_help_disabled);
        }
        if (model.getCurrentStickerAnimationSettings() != 2) {
            RadioManager radioManager = this.stickersAnimationRadioManager;
            if (radioManager != null) {
                CheckedSetting checkedSetting8 = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.stickersAnimateOnInteraction");
                radioManager.a(checkedSetting8);
            }
        } else {
            RadioManager radioManager2 = this.stickersAnimationRadioManager;
            if (radioManager2 != null) {
                CheckedSetting checkedSetting9 = getBinding().k;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.stickersNeverAnimate");
                radioManager2.a(checkedSetting9);
            }
        }
        CheckedSetting checkedSetting10 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.settingsAccessib…ityAllowAutoplayGifSwitch");
        checkedSetting10.setChecked(false);
        getBinding().c.b(R.string.accessibility_reduced_motion_settings_override);
    }

    private final WidgetSettingsAccessibilityBinding getBinding() {
        return (WidgetSettingsAccessibilityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetSettingsAccessibility.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        setActionBarTitle(R.string.accessibility);
        setActionBarSubtitle(R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().g.setOnCheckedListener(AnonymousClass2.INSTANCE);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccessib…yReducedMotionDescription");
        FormatUtils.n(linkifiedTextView, R.string.accessibility_prefers_reduced_motion_description, new Object[]{AppHelpDesk.a.a(360040613412L, null)}, null, 4);
        getBinding().f2589b.setOnCheckedListener(new AnonymousClass3());
        getBinding().c.setOnCheckedListener(AnonymousClass4.INSTANCE);
        this.stickersAnimationRadioManager = new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().i, getBinding().j, getBinding().k}));
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f, getBinding().d, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}

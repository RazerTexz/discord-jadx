package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsLanguageBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetSettingsLanguage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguage;", "Lcom/discord/app/AppFragment;", "", "locale", "", "configureUI", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetSettingsLanguageBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsLanguageBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsLanguage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsLanguage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsLanguage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguage$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "", "locale", "getAsStringInLocale", "(Ljava/lang/String;)Ljava/lang/String;", "", "getLocaleResId", "(Ljava/lang/String;)I", "getLocaleFlagResId", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        public final String getAsStringInLocale(String locale) {
            if (locale == null) {
                return "English, USA";
            }
            switch (locale.hashCode()) {
                case 3141:
                    if (locale.equals("bg")) {
                    }
                    break;
                case 3184:
                    if (locale.equals("cs")) {
                    }
                    break;
                case 3197:
                    if (locale.equals("da")) {
                    }
                    break;
                case 3201:
                    if (locale.equals("de")) {
                    }
                    break;
                case 3239:
                    if (locale.equals("el")) {
                    }
                    break;
                case 3267:
                    if (locale.equals("fi")) {
                    }
                    break;
                case 3276:
                    if (locale.equals("fr")) {
                    }
                    break;
                case 3329:
                    if (locale.equals("hi")) {
                    }
                    break;
                case 3338:
                    if (locale.equals("hr")) {
                    }
                    break;
                case 3341:
                    if (locale.equals("hu")) {
                    }
                    break;
                case 3371:
                    if (locale.equals("it")) {
                    }
                    break;
                case 3383:
                    if (locale.equals("ja")) {
                    }
                    break;
                case 3428:
                    if (locale.equals("ko")) {
                    }
                    break;
                case 3464:
                    if (locale.equals("lt")) {
                    }
                    break;
                case 3518:
                    if (locale.equals("nl")) {
                    }
                    break;
                case 3521:
                    if (locale.equals("no")) {
                    }
                    break;
                case 3580:
                    if (locale.equals("pl")) {
                    }
                    break;
                case 3645:
                    if (locale.equals("ro")) {
                    }
                    break;
                case 3651:
                    if (locale.equals("ru")) {
                    }
                    break;
                case 3700:
                    if (locale.equals("th")) {
                    }
                    break;
                case 3710:
                    if (locale.equals("tr")) {
                    }
                    break;
                case 3734:
                    if (locale.equals("uk")) {
                    }
                    break;
                case 3763:
                    if (locale.equals("vi")) {
                    }
                    break;
                case 96598143:
                    if (locale.equals("en-GB")) {
                    }
                    break;
                case 96598594:
                    locale.equals("en-US");
                    break;
                case 96747053:
                    if (locale.equals("es-ES")) {
                    }
                    break;
                case 106935481:
                    if (locale.equals("pt-BR")) {
                    }
                    break;
                case 109766140:
                    if (locale.equals("sv-SE")) {
                    }
                    break;
                case 115813226:
                    if (locale.equals("zh-CN")) {
                    }
                    break;
                case 115813762:
                    if (locale.equals("zh-TW")) {
                    }
                    break;
            }
            return "English, USA";
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        @DrawableRes
        public final int getLocaleFlagResId(String locale) {
            if (locale == null) {
                return R.drawable.icon_flag_en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    if (locale.equals("bg")) {
                    }
                    break;
                case 3184:
                    if (locale.equals("cs")) {
                    }
                    break;
                case 3197:
                    if (locale.equals("da")) {
                    }
                    break;
                case 3201:
                    if (locale.equals("de")) {
                    }
                    break;
                case 3239:
                    if (locale.equals("el")) {
                    }
                    break;
                case 3267:
                    if (locale.equals("fi")) {
                    }
                    break;
                case 3276:
                    if (locale.equals("fr")) {
                    }
                    break;
                case 3329:
                    if (locale.equals("hi")) {
                    }
                    break;
                case 3338:
                    if (locale.equals("hr")) {
                    }
                    break;
                case 3341:
                    if (locale.equals("hu")) {
                    }
                    break;
                case 3371:
                    if (locale.equals("it")) {
                    }
                    break;
                case 3383:
                    if (locale.equals("ja")) {
                    }
                    break;
                case 3428:
                    if (locale.equals("ko")) {
                    }
                    break;
                case 3464:
                    if (locale.equals("lt")) {
                    }
                    break;
                case 3518:
                    if (locale.equals("nl")) {
                    }
                    break;
                case 3521:
                    if (locale.equals("no")) {
                    }
                    break;
                case 3580:
                    if (locale.equals("pl")) {
                    }
                    break;
                case 3645:
                    if (locale.equals("ro")) {
                    }
                    break;
                case 3651:
                    if (locale.equals("ru")) {
                    }
                    break;
                case 3700:
                    if (locale.equals("th")) {
                    }
                    break;
                case 3710:
                    if (locale.equals("tr")) {
                    }
                    break;
                case 3734:
                    if (locale.equals("uk")) {
                    }
                    break;
                case 3763:
                    if (locale.equals("vi")) {
                    }
                    break;
                case 96598143:
                    if (locale.equals("en-GB")) {
                    }
                    break;
                case 96598594:
                    locale.equals("en-US");
                    break;
                case 96747053:
                    if (locale.equals("es-ES")) {
                    }
                    break;
                case 106935481:
                    if (locale.equals("pt-BR")) {
                    }
                    break;
                case 109766140:
                    if (locale.equals("sv-SE")) {
                    }
                    break;
                case 115813226:
                    if (locale.equals("zh-CN")) {
                    }
                    break;
                case 115813762:
                    if (locale.equals("zh-TW")) {
                    }
                    break;
            }
            return R.drawable.icon_flag_en_us;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        @StringRes
        public final int getLocaleResId(String locale) {
            if (locale == null) {
                return R.string.en_us;
            }
            switch (locale.hashCode()) {
                case 3141:
                    if (locale.equals("bg")) {
                    }
                    break;
                case 3184:
                    if (locale.equals("cs")) {
                    }
                    break;
                case 3197:
                    if (locale.equals("da")) {
                    }
                    break;
                case 3201:
                    if (locale.equals("de")) {
                    }
                    break;
                case 3239:
                    if (locale.equals("el")) {
                    }
                    break;
                case 3267:
                    if (locale.equals("fi")) {
                    }
                    break;
                case 3276:
                    if (locale.equals("fr")) {
                    }
                    break;
                case 3329:
                    if (locale.equals("hi")) {
                    }
                    break;
                case 3338:
                    if (locale.equals("hr")) {
                    }
                    break;
                case 3341:
                    if (locale.equals("hu")) {
                    }
                    break;
                case 3371:
                    if (locale.equals("it")) {
                    }
                    break;
                case 3383:
                    if (locale.equals("ja")) {
                    }
                    break;
                case 3428:
                    if (locale.equals("ko")) {
                    }
                    break;
                case 3464:
                    if (locale.equals("lt")) {
                    }
                    break;
                case 3518:
                    if (locale.equals("nl")) {
                    }
                    break;
                case 3521:
                    if (locale.equals("no")) {
                    }
                    break;
                case 3580:
                    if (locale.equals("pl")) {
                    }
                    break;
                case 3645:
                    if (locale.equals("ro")) {
                    }
                    break;
                case 3651:
                    if (locale.equals("ru")) {
                    }
                    break;
                case 3700:
                    if (locale.equals("th")) {
                    }
                    break;
                case 3710:
                    if (locale.equals("tr")) {
                    }
                    break;
                case 3734:
                    if (locale.equals("uk")) {
                    }
                    break;
                case 3763:
                    if (locale.equals("vi")) {
                    }
                    break;
                case 96598143:
                    if (locale.equals("en-GB")) {
                    }
                    break;
                case 96598594:
                    locale.equals("en-US");
                    break;
                case 96747053:
                    if (locale.equals("es-ES")) {
                    }
                    break;
                case 106935481:
                    if (locale.equals("pt-BR")) {
                    }
                    break;
                case 109766140:
                    if (locale.equals("sv-SE")) {
                    }
                    break;
                case 115813226:
                    if (locale.equals("zh-CN")) {
                    }
                    break;
                case 115813762:
                    if (locale.equals("zh-TW")) {
                    }
                    break;
            }
            return R.string.en_us;
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsLanguage.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsLanguage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "locale", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {

        /* compiled from: WidgetSettingsLanguage.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03251 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $locale;

            /* compiled from: WidgetSettingsLanguage.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBound$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03261 extends Lambda implements Function1<ModelUserSettings, Unit> {
                public C03261() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
                    invoke2(modelUserSettings);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ModelUserSettings modelUserSettings) {
                    Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
                    AppToast.g(WidgetSettingsLanguage.this.requireContext(), R.string.language_updated, 0, null, 12);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03251(String str) {
                super(0);
                this.$locale = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithLocale(this.$locale)), false, 1, null), WidgetSettingsLanguage.this, null, 2, null), StoreUserSettings.class, WidgetSettingsLanguage.this.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C03261(), 60, (Object) null);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "locale");
            StoreStream.INSTANCE.getUserSettingsSystem().setLocale(str, true, new C03251(str));
            AppActivity appActivity = WidgetSettingsLanguage.this.getAppActivity();
            if (appActivity != null) {
                appActivity.recreate();
            }
        }
    }

    /* compiled from: WidgetSettingsLanguage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "settings", "", "invoke", "(Lcom/discord/stores/StoreUserSettingsSystem$Settings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreUserSettingsSystem.Settings, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserSettingsSystem.Settings settings) {
            invoke2(settings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserSettingsSystem.Settings settings) {
            Intrinsics3.checkNotNullParameter(settings, "settings");
            WidgetSettingsLanguage.access$configureUI(WidgetSettingsLanguage.this, settings.getLocale());
        }
    }

    /* compiled from: WidgetSettingsLanguage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "checked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            userSettingsSystem.setIsLocaleSyncEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsLanguage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsLanguage$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsLanguageSelect.INSTANCE.show(WidgetSettingsLanguage.this);
        }
    }

    public WidgetSettingsLanguage() {
        super(R.layout.widget_settings_language);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsLanguage2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsLanguage widgetSettingsLanguage, String str) {
        widgetSettingsLanguage.configureUI(str);
    }

    private final void configureUI(String locale) {
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsLanguageCurrentText");
        Companion companion = INSTANCE;
        textView.setText(getString(companion.getLocaleResId(locale)));
        getBinding().c.setImageResource(companion.getLocaleFlagResId(locale));
    }

    private final WidgetSettingsLanguageBinding getBinding() {
        return (WidgetSettingsLanguageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.language);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.getUserSettingsSystem().observeSettings(false), this, null, 2, null), WidgetSettingsLanguage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsLanguageSyncCheck");
        checkedSetting.setChecked(companion.getUserSettingsSystem().getIsLocaleSyncEnabled());
        getBinding().f.setOnCheckedListener(AnonymousClass2.INSTANCE);
        getBinding().f2627b.setOnClickListener(new AnonymousClass3());
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().e, getBinding().g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}

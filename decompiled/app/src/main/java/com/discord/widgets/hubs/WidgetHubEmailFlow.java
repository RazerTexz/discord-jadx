package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.WidgetDiscordHubEmailInputBinding;
import b.a.i.WidgetHubEmailFlowConfirmationBinding;
import b.a.i.WidgetHubEmailFlowWaitlistBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification3;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubEmailFlowBinding;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import d0.LazyJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetHubEmailFlow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b4\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010$\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010#R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001c\u00100\u001a\u00020/8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubEmailFlow;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/hubs/HubEmailState;", "state", "", "updateView", "(Lcom/discord/widgets/hubs/HubEmailState;)V", "verifyEmail", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/hubs/WidgetHubEmailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/hubs/WidgetHubEmailViewModel;", "viewModel", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "activityResultHandler", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/widgets/hubs/HubEmailArgs;", "args$delegate", "getArgs", "()Lcom/discord/widgets/hubs/HubEmailArgs;", "args", "Lcom/discord/databinding/WidgetHubEmailFlowBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetHubEmailFlowBinding;", "binding", "", "getEmail", "()Ljava/lang/String;", NotificationCompat.CATEGORY_EMAIL, "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubEmailFlow.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEmailFlowBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NAME = WidgetHubEmailFlow.class.getName();
    private final ActivityResultLauncher<Intent> activityResultHandler;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR!\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubEmailFlow$Companion;", "", "", "kotlin.jvm.PlatformType", "NAME", "Ljava/lang/String;", "getNAME", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final String getNAME() {
            return WidgetHubEmailFlow.access$getNAME$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetHubEmailViewModel3.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            WidgetHubEmailViewModel3 widgetHubEmailViewModel3 = WidgetHubEmailViewModel3.Invite;
            iArr[widgetHubEmailViewModel3.ordinal()] = 1;
            WidgetHubEmailViewModel3 widgetHubEmailViewModel32 = WidgetHubEmailViewModel3.Onboarding;
            iArr[widgetHubEmailViewModel32.ordinal()] = 2;
            WidgetHubEmailViewModel3.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[widgetHubEmailViewModel3.ordinal()] = 1;
            iArr2[widgetHubEmailViewModel32.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/hubs/HubEmailState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/hubs/HubEmailState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubEmailViewModel4, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
            invoke2(widgetHubEmailViewModel4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
            WidgetHubEmailFlow widgetHubEmailFlow = WidgetHubEmailFlow.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHubEmailViewModel4, "viewState");
            WidgetHubEmailFlow.access$updateView(widgetHubEmailFlow, widgetHubEmailViewModel4);
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$verifyEmail(WidgetHubEmailFlow.this);
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetHubEmailFlow.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                return invoke2(nuxState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
                Intrinsics3.checkNotNullParameter(nuxState, "it");
                return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubEmailFlow.this.getActivity();
            if (activity != null) {
                Intrinsics3.checkNotNullExpressionValue(activity, "activity ?: return@setOnClickListener");
                if (WidgetHubEmailFlow.access$getArgs$p(WidgetHubEmailFlow.this).getEntryPoint() == WidgetHubEmailViewModel3.Onboarding) {
                    StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
                    WidgetGuildTemplates.INSTANCE.launch(activity, CreateGuildTrigger.NUF, true);
                }
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubEmailFlow.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$verifyEmail(WidgetHubEmailFlow.this);
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/Success;", "Lcom/discord/api/hubs/EmailVerification;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<RestCallState6<? extends EmailVerification>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $email;
        public final /* synthetic */ WidgetHubEmailViewModel4 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(WidgetHubEmailViewModel4 widgetHubEmailViewModel4, Context context, String str) {
            super(1);
            this.$state = widgetHubEmailViewModel4;
            this.$context = context;
            this.$email = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification> restCallState6) {
            invoke2((RestCallState6<EmailVerification>) restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            StoreStream.INSTANCE.getDirectories().markDiscordHubClicked();
            if (!this.$state.getHasMultipleDomains()) {
                EmailVerification emailVerificationInvoke = this.$state.getVerifyEmailAsync().invoke();
                if (emailVerificationInvoke == null || emailVerificationInvoke.getHasMatchingGuild() || !GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled()) {
                    return;
                }
                AppScreen2.g.f(this.$context, WidgetHubEmailFlow.access$getActivityResultHandler$p(WidgetHubEmailFlow.this), WidgetHubWaitlist.class, new WidgetHubWaitlistViewModel2(this.$email));
                WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
                return;
            }
            AppScreen2 appScreen2 = AppScreen2.g;
            Context context = this.$context;
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getActivityResultHandler$p = WidgetHubEmailFlow.access$getActivityResultHandler$p(WidgetHubEmailFlow.this);
            String str = this.$email;
            List<EmailVerification3> listA = restCallState6.invoke().a();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(WidgetHubDomains2.INSTANCE.from((EmailVerification3) it.next()));
            }
            appScreen2.f(context, activityResultLauncherAccess$getActivityResultHandler$p, WidgetHubDomains.class, new WidgetHubDomains3(str, arrayList));
            WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
        }
    }

    public WidgetHubEmailFlow() {
        super(R.layout.widget_hub_email_flow);
        this.args = LazyJVM.lazy(new WidgetHubEmailFlow$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubEmailFlow3.INSTANCE, null, 2, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetHubEmailFlow2(this));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…  }\n            }\n      }");
        this.activityResultHandler = activityResultLauncherRegisterForActivityResult;
        WidgetHubEmailFlow7 widgetHubEmailFlow7 = WidgetHubEmailFlow7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubEmailViewModel.class), new WidgetHubEmailFlow$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubEmailFlow7));
        this.validationManager = LazyJVM.lazy(new WidgetHubEmailFlow6(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubEmailFlow4(this), 3);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResultHandler$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.activityResultHandler;
    }

    public static final /* synthetic */ WidgetHubEmailViewModel2 access$getArgs$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getArgs();
    }

    public static final /* synthetic */ WidgetHubEmailFlowBinding access$getBinding$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getBinding();
    }

    public static final /* synthetic */ String access$getNAME$cp() {
        return NAME;
    }

    public static final /* synthetic */ WidgetHubEmailViewModel access$getViewModel$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getViewModel();
    }

    public static final /* synthetic */ void access$updateView(WidgetHubEmailFlow widgetHubEmailFlow, WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
        widgetHubEmailFlow.updateView(widgetHubEmailViewModel4);
    }

    public static final /* synthetic */ void access$verifyEmail(WidgetHubEmailFlow widgetHubEmailFlow) {
        widgetHubEmailFlow.verifyEmail();
    }

    private final WidgetHubEmailViewModel2 getArgs() {
        return (WidgetHubEmailViewModel2) this.args.getValue();
    }

    private final WidgetHubEmailFlowBinding getBinding() {
        return (WidgetHubEmailFlowBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getEmail() {
        TextInputEditText textInputEditText = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
        return String.valueOf(textInputEditText.getText());
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final WidgetHubEmailViewModel getViewModel() {
        return (WidgetHubEmailViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetHubEmailViewModel4 state) {
        String school;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            EmailVerification emailVerificationInvoke = state.getVerifyEmailAsync().invoke();
            boolean z2 = emailVerificationInvoke != null && emailVerificationInvoke.getHasMatchingGuild();
            boolean z3 = !(state.getVerifyEmailAsync() instanceof RestCallState6) && state.getWaitlistResult() == null;
            EmailVerification emailVerificationInvoke2 = state.getVerifyEmailAsync().invoke();
            boolean z4 = ((emailVerificationInvoke2 == null || emailVerificationInvoke2.getHasMatchingGuild()) && state.getWaitlistResult() == null) ? false : true;
            TextInputEditText textInputEditText = getBinding().c.c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
            String strValueOf = String.valueOf(textInputEditText.getText());
            WidgetDiscordHubEmailInputBinding widgetDiscordHubEmailInputBinding = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(widgetDiscordHubEmailInputBinding, "binding.discordHubEmailInput");
            NestedScrollView nestedScrollView = widgetDiscordHubEmailInputBinding.a;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.discordHubEmailInput.root");
            nestedScrollView.setVisibility(z3 ? 0 : 8);
            MaterialButton materialButton = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.discordHubEmailNo");
            materialButton.setVisibility(z3 ? 0 : 8);
            WidgetHubEmailFlowConfirmationBinding widgetHubEmailFlowConfirmationBinding = getBinding().f2473b;
            Intrinsics3.checkNotNullExpressionValue(widgetHubEmailFlowConfirmationBinding, "binding.discordHubEmailConfirmation");
            NestedScrollView nestedScrollView2 = widgetHubEmailFlowConfirmationBinding.a;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView2, "binding.discordHubEmailConfirmation.root");
            nestedScrollView2.setVisibility(z2 ? 0 : 8);
            TextView textView = getBinding().f2473b.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubEmailC…ilConfirmationHeaderTitle");
            textView.setText(FormatUtils.k(this, R.string.member_verification_email_confirmation_title, new Object[]{strValueOf}, null, 4));
            WidgetHubEmailFlowWaitlistBinding widgetHubEmailFlowWaitlistBinding = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(widgetHubEmailFlowWaitlistBinding, "binding.discordHubWaitlist");
            NestedScrollView nestedScrollView3 = widgetHubEmailFlowWaitlistBinding.a;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView3, "binding.discordHubWaitlist.root");
            nestedScrollView3.setVisibility(z4 ? 0 : 8);
            WidgetHubWaitlist2 waitlistResult = state.getWaitlistResult();
            if (waitlistResult != null && (school = waitlistResult.getSchool()) != null) {
                TextView textView2 = getBinding().f.f182b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.discordHubWaitlist.hubWaitlistDescription");
                textView2.setText(FormatUtils.k(this, R.string.hub_waitlist_modal_joined_description, new Object[]{school}, null, 4));
            }
            getBinding().e.setOnClickListener(z4 ? new AnonymousClass2() : new AnonymousClass3());
            LoadingButton loadingButton = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.discordHubEmailYes");
            loadingButton.setVisibility(z2 ^ true ? 0 : 8);
            getBinding().e.setText(z4 ? getString(R.string.hub_add_server_confirmation_button) : getString(R.string.hub_email_connection_content_button));
            getBinding().e.setIsLoading(state.getVerifyEmailAsync() instanceof RestCallState4);
            RestCallState5.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new AnonymousClass4(state, context, strValueOf), 6, null);
        }
    }

    private final void verifyEmail() {
        boolean zValidate$default = ValidationManager.validate$default(getValidationManager(), false, 1, null);
        TextView textView = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubEmailInput.discordHubEmailLabel");
        textView.setVisibility(zValidate$default ? 0 : 8);
        if (zValidate$default) {
            getViewModel().submitEmail(getEmail());
            hideKeyboard(getView());
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetHubEmailViewModel4> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubEmailFlow.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f2473b.d.setOnClickListener(new AnonymousClass1());
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().f2473b.f176b.setOnClickListener(new AnonymousClass3());
        TextView textView = getBinding().c.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubEmailI…iscordHubEmailHeaderTitle");
        int iOrdinal = getArgs().getEntryPoint().ordinal();
        if (iOrdinal == 0) {
            string = getString(R.string.hub_email_connection_nux_header);
        } else if (iOrdinal != 1) {
            string = getString(R.string.hub_waitlist_modal_join_header);
        } else {
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            string = FormatUtils.k(this, R.string.hub_email_connection_invite_header, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.hub_email_connection_invite_header_count, getArgs().getGuildMemberCount(), Integer.valueOf(getArgs().getGuildMemberCount())), getArgs().getGuildName()}, null, 4);
        }
        textView.setText(string);
        int iOrdinal2 = getArgs().getEntryPoint().ordinal();
        String string2 = getString(iOrdinal2 != 0 ? iOrdinal2 != 1 ? R.string.hub_waitlist_modal_join_subheader : R.string.hub_email_connection_content_description : R.string.hub_email_connection_nux_content_description);
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(\n        when …subheader\n        }\n    )");
        CharSequence charSequenceE = FormatUtils.e(this, R.string.learn_more_link, new Object[0], new WidgetHubEmailFlow5(this));
        LinkifiedTextView linkifiedTextView = getBinding().c.f107b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.discordHubEmailI…HubEmailHeaderDescription");
        linkifiedTextView.setText(new SpannableStringBuilder(string2).append((CharSequence) " ").append(charSequenceE));
    }
}

package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDisableGuildCommunicationBinding;
import com.discord.models.user.User;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetDisableGuildCommunication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001d\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/WidgetDisableGuildCommunication;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;)V", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Valid;", "Lcom/discord/views/CheckedSetting;", "setting", "Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;", "settingValue", "configureDurationOption", "(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Valid;Lcom/discord/views/CheckedSetting;Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;)V", "onResume", "()V", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel;", "viewModel", "", "userId$delegate", "getUserId", "()J", "userId", "guildId$delegate", "getGuildId", "guildId", "Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDisableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_USER_ID = "INTENT_EXTRA_USER_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: userId$delegate, reason: from kotlin metadata */
    private final Lazy userId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetDisableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/WidgetDisableGuildCommunication$Companion;", "", "", "userId", "guildId", "Landroid/content/Context;", "context", "", "launch", "(JJLandroid/content/Context;)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", WidgetDisableGuildCommunication.INTENT_EXTRA_USER_ID, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long userId, long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetDisableGuildCommunication.INTENT_EXTRA_USER_ID, userId);
            AppScreen2.d(context, WidgetDisableGuildCommunication.class, intent);
            AnalyticsTracker.INSTANCE.viewedDisableCommunicationModal(guildId, userId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDisableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureDurationOption$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildCommunicationDisabledDateUtils2 $settingValue;

        public AnonymousClass1(GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2) {
            this.$settingValue = guildCommunicationDisabledDateUtils2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetDisableGuildCommunication.access$getBinding$p(WidgetDisableGuildCommunication.this).d.clearFocus();
            AppFragment.hideKeyboard$default(WidgetDisableGuildCommunication.this, null, 1, null);
            WidgetDisableGuildCommunication.access$getViewModel$p(WidgetDisableGuildCommunication.this).onDurationLengthSelected(this.$settingValue);
        }
    }

    /* compiled from: WidgetDisableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetDisableGuildCommunication.access$getBinding$p(WidgetDisableGuildCommunication.this).c, "binding.disableGuildCommunicationBody", "binding.disableGuildCommunicationBody.context"), AppHelpDesk.a.a(4413305239191L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetDisableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ DisableGuildCommunicationViewModel.ViewState $viewState;

        /* compiled from: WidgetDisableGuildCommunication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CharSequence charSequenceH;
                Context context = WidgetDisableGuildCommunication.this.getContext();
                Context context2 = WidgetDisableGuildCommunication.this.getContext();
                if (context2 != null) {
                    Object[] objArr = new Object[2];
                    User user = ((DisableGuildCommunicationViewModel.ViewState.Valid) AnonymousClass2.this.$viewState).getUser();
                    objArr[0] = user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null;
                    objArr[1] = GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(WidgetDisableGuildCommunication.this.getContext(), ((DisableGuildCommunicationViewModel.ViewState.Valid) AnonymousClass2.this.$viewState).getSelectedDurationOption());
                    charSequenceH = FormatUtils.h(context2, R.string.disable_guild_communication_confirmed, objArr, null, 4);
                } else {
                    charSequenceH = null;
                }
                AppToast.h(context, charSequenceH, 0, null, 12);
                AppActivity appActivity = WidgetDisableGuildCommunication.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
        }

        public AnonymousClass2(DisableGuildCommunicationViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WeakReference<Context> weakReference = new WeakReference<>(WidgetDisableGuildCommunication.this.requireContext());
            DisableGuildCommunicationViewModel disableGuildCommunicationViewModelAccess$getViewModel$p = WidgetDisableGuildCommunication.access$getViewModel$p(WidgetDisableGuildCommunication.this);
            TextInputLayout textInputLayout = WidgetDisableGuildCommunication.access$getBinding$p(WidgetDisableGuildCommunication.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
            disableGuildCommunicationViewModelAccess$getViewModel$p.onDisableCommunicationConfirm(weakReference, ViewExtensions.getTextOrEmpty(textInputLayout), new AnonymousClass1());
        }
    }

    /* compiled from: WidgetDisableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<DisableGuildCommunicationViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
            super(1, widgetDisableGuildCommunication, WidgetDisableGuildCommunication.class, "configureUI", "configureUI(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisableGuildCommunicationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisableGuildCommunicationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetDisableGuildCommunication.access$configureUI((WidgetDisableGuildCommunication) this.receiver, viewState);
        }
    }

    public WidgetDisableGuildCommunication() {
        super(R.layout.widget_disable_guild_communication);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDisableGuildCommunication3.INSTANCE, null, 2, null);
        this.userId = LazyJVM.lazy(new WidgetDisableGuildCommunication5(this));
        this.guildId = LazyJVM.lazy(new WidgetDisableGuildCommunication4(this));
        WidgetDisableGuildCommunication6 widgetDisableGuildCommunication6 = new WidgetDisableGuildCommunication6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(DisableGuildCommunicationViewModel.class), new WidgetDisableGuildCommunication$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetDisableGuildCommunication6));
    }

    public static final /* synthetic */ void access$configureUI(WidgetDisableGuildCommunication widgetDisableGuildCommunication, DisableGuildCommunicationViewModel.ViewState viewState) {
        widgetDisableGuildCommunication.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetDisableGuildCommunicationBinding access$getBinding$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getGuildId();
    }

    public static final /* synthetic */ long access$getUserId$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getUserId();
    }

    public static final /* synthetic */ DisableGuildCommunicationViewModel access$getViewModel$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getViewModel();
    }

    private final void configureDurationOption(DisableGuildCommunicationViewModel.ViewState.Valid viewState, CheckedSetting setting, GuildCommunicationDisabledDateUtils2 settingValue) {
        setting.setChecked(viewState.getSelectedDurationOption() == settingValue);
        setting.setText(GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(getContext(), settingValue));
        setting.e(new AnonymousClass1(settingValue));
    }

    private final void configureUI(DisableGuildCommunicationViewModel.ViewState viewState) {
        if (viewState instanceof DisableGuildCommunicationViewModel.ViewState.Valid) {
            DisableGuildCommunicationViewModel.ViewState.Valid valid = (DisableGuildCommunicationViewModel.ViewState.Valid) viewState;
            CheckedSetting checkedSetting = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.timeUnit60Seconds");
            configureDurationOption(valid, checkedSetting, GuildCommunicationDisabledDateUtils2.SECONDS_60);
            CheckedSetting checkedSetting2 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.timeUnit5Minutes");
            configureDurationOption(valid, checkedSetting2, GuildCommunicationDisabledDateUtils2.MINUTES_5);
            CheckedSetting checkedSetting3 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.timeUnit10Minutes");
            configureDurationOption(valid, checkedSetting3, GuildCommunicationDisabledDateUtils2.MINUTES_10);
            CheckedSetting checkedSetting4 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.timeUnit1Hour");
            configureDurationOption(valid, checkedSetting4, GuildCommunicationDisabledDateUtils2.HOUR_1);
            CheckedSetting checkedSetting5 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.timeUnit1Day");
            configureDurationOption(valid, checkedSetting5, GuildCommunicationDisabledDateUtils2.DAY_1);
            CheckedSetting checkedSetting6 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.timeUnit1Week");
            configureDurationOption(valid, checkedSetting6, GuildCommunicationDisabledDateUtils2.WEEK_1);
            Context context = getContext();
            CharSequence charSequenceH = context != null ? FormatUtils.h(context, R.string.disable_guild_communication_body_header, new Object[]{AppHelpDesk.a.a(4413305239191L, null)}, null, 4) : null;
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.disableGuildCommunicationBody");
            textView.setText(charSequenceH);
            getBinding().c.setOnClickListener(new AnonymousClass1());
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.disableGuildCommunicationSubtitle");
            User user = valid.getUser();
            FormatUtils.o(textView2, user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null, new Object[0], null, 4);
            getBinding().f2367b.setOnClickListener(new AnonymousClass2(viewState));
            TextInputLayout textInputLayout = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setOnFocusChangeListener(new WidgetDisableGuildCommunication2(this));
            }
        }
    }

    private final WidgetDisableGuildCommunicationBinding getBinding() {
        return (WidgetDisableGuildCommunicationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getUserId() {
        return ((Number) this.userId.getValue()).longValue();
    }

    private final DisableGuildCommunicationViewModel getViewModel() {
        return (DisableGuildCommunicationViewModel) this.viewModel.getValue();
    }

    public static final void launch(long j, long j2, Context context) {
        INSTANCE.launch(j, j2, context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetDisableGuildCommunication.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

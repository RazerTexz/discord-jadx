package com.discord.widgets.guild_automod;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetReportIssueWithAutoMod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001d\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/widgets/guild_automod/WidgetReportIssueWithAutoMod;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Valid;", "viewState", "Lcom/discord/views/CheckedSetting;", "setting", "Lcom/discord/widgets/guild_automod/FeedbackType;", "settingValue", "", "configureOption", "(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Valid;Lcom/discord/views/CheckedSetting;Lcom/discord/widgets/guild_automod/FeedbackType;)V", "onResume", "()V", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;", "configureUI", "(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;)V", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel;", "viewModel", "", "channelId$delegate", "getChannelId", "()J", "channelId", "messageId$delegate", "getMessageId", "messageId", "Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetReportIssueWithAutoMod.class, "binding", "getBinding()Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: messageId$delegate, reason: from kotlin metadata */
    private final Lazy messageId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guild_automod/WidgetReportIssueWithAutoMod$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "", "launch", "(Landroid/content/Context;JJ)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId, long messageId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            AppScreen2.d(context, WidgetReportIssueWithAutoMod.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureOption$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ReportIssueWithAutoModViewModel2 $settingValue;

        public AnonymousClass1(ReportIssueWithAutoModViewModel2 reportIssueWithAutoModViewModel2) {
            this.$settingValue = reportIssueWithAutoModViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetReportIssueWithAutoMod.access$getViewModel$p(WidgetReportIssueWithAutoMod.this).onFeedbackTypeSelected(this.$settingValue);
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetReportIssueWithAutoMod.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetReportIssueWithAutoMod.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$2$1, reason: invalid class name */
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
                FragmentActivity activity = WidgetReportIssueWithAutoMod.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetReportIssueWithAutoMod.access$getViewModel$p(WidgetReportIssueWithAutoMod.this).onSubmit(new AnonymousClass1());
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ReportIssueWithAutoModViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportIssueWithAutoModViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportIssueWithAutoModViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetReportIssueWithAutoMod.this.configureUI(viewState);
        }
    }

    public WidgetReportIssueWithAutoMod() {
        super(R.layout.widget_report_issue_with_automod);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetReportIssueWithAutoMod2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetReportIssueWithAutoMod3(this));
        this.messageId = LazyJVM.lazy(new WidgetReportIssueWithAutoMod4(this));
        WidgetReportIssueWithAutoMod5 widgetReportIssueWithAutoMod5 = new WidgetReportIssueWithAutoMod5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ReportIssueWithAutoModViewModel.class), new WidgetReportIssueWithAutoMod$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetReportIssueWithAutoMod5));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getChannelId();
    }

    public static final /* synthetic */ long access$getMessageId$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getMessageId();
    }

    public static final /* synthetic */ ReportIssueWithAutoModViewModel access$getViewModel$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getViewModel();
    }

    private final void configureOption(ReportIssueWithAutoModViewModel.ViewState.Valid viewState, CheckedSetting setting, ReportIssueWithAutoModViewModel2 settingValue) {
        setting.setChecked(Intrinsics3.areEqual(viewState.getSelectedOption(), settingValue.getValue()));
        setting.e(new AnonymousClass1(settingValue));
    }

    private final WidgetReportIssueWithAutomodBinding getBinding() {
        return (WidgetReportIssueWithAutomodBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getMessageId() {
        return ((Number) this.messageId.getValue()).longValue();
    }

    private final ReportIssueWithAutoModViewModel getViewModel() {
        return (ReportIssueWithAutoModViewModel) this.viewModel.getValue();
    }

    public final void configureUI(ReportIssueWithAutoModViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        getBinding().f2520b.setOnClickListener(new AnonymousClass1());
        getBinding().e.setOnClickListener(new AnonymousClass2());
        if (viewState instanceof ReportIssueWithAutoModViewModel.ViewState.Valid) {
            ReportIssueWithAutoModViewModel.ViewState.Valid valid = (ReportIssueWithAutoModViewModel.ViewState.Valid) viewState;
            CheckedSetting checkedSetting = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.option1");
            configureOption(valid, checkedSetting, ReportIssueWithAutoModViewModel2.ALLOWED);
            CheckedSetting checkedSetting2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.option2");
            configureOption(valid, checkedSetting2, ReportIssueWithAutoModViewModel2.BUG);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetReportIssueWithAutoMod.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

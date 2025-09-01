package com.discord.widgets.tos;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.report.ReportReason;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.tos.WidgetTosReportViolationViewModel;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetTosReportViolation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bR\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolation;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", "handleLoading", "()V", "", "Lcom/discord/api/report/ReportReason;", "reasons", "handleLoaded", "(Ljava/util/List;)V", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "handleReportSubmitting", "(I)V", "handleReportSubmitted", "handleReportSubmissionError", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion$Arguments;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion$Arguments;", "args", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel;", "viewModel", "Lcom/discord/databinding/WidgetTosReportViolationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetTosReportViolationBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetTosReportViolation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTosReportViolation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CHANNEL_ID = "EXTRA_CHANNEL_ID";
    private static final String EXTRA_MESSAGE_ID = "EXTRA_MESSAGE_ID";
    private static final String EXTRA_TARGET = "EXTRA_TARGET";

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetTosReportViolation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion;", "", "Landroid/content/Context;", "context", "", "target", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", WidgetTosReportViolation.EXTRA_CHANNEL_ID, "Ljava/lang/String;", WidgetTosReportViolation.EXTRA_MESSAGE_ID, WidgetTosReportViolation.EXTRA_TARGET, "<init>", "()V", "Arguments", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetTosReportViolation.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\u0010\f\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\r\u001a\u00060\u0005j\u0002`\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ6\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\f\b\u0002\u0010\f\u001a\u00060\u0005j\u0002`\u00062\f\b\u0002\u0010\r\u001a\u00060\u0005j\u0002`\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\r\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001d\u0010\f\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion$Arguments;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()J", "Lcom/discord/primitives/MessageId;", "component3", "target", "channelId", "messageId", "copy", "(Ljava/lang/String;JJ)Lcom/discord/widgets/tos/WidgetTosReportViolation$Companion$Arguments;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMessageId", "Ljava/lang/String;", "getTarget", "getChannelId", "<init>", "(Ljava/lang/String;JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Arguments {
            private final long channelId;
            private final long messageId;
            private final String target;

            public Arguments(String str, long j, long j2) {
                Intrinsics3.checkNotNullParameter(str, "target");
                this.target = str;
                this.channelId = j;
                this.messageId = j2;
            }

            public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = arguments.target;
                }
                if ((i & 2) != 0) {
                    j = arguments.channelId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = arguments.messageId;
                }
                return arguments.copy(str, j3, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getTarget() {
                return this.target;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            public final Arguments copy(String target, long channelId, long messageId) {
                Intrinsics3.checkNotNullParameter(target, "target");
                return new Arguments(target, channelId, messageId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Arguments)) {
                    return false;
                }
                Arguments arguments = (Arguments) other;
                return Intrinsics3.areEqual(this.target, arguments.target) && this.channelId == arguments.channelId && this.messageId == arguments.messageId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final String getTarget() {
                return this.target;
            }

            public int hashCode() {
                String str = this.target;
                return b.a(this.messageId) + ((b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Arguments(target=");
                sbU.append(this.target);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                return outline.C(sbU, this.messageId, ")");
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, Long l, Long l2, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            if ((i & 8) != 0) {
                l2 = null;
            }
            companion.show(context, str, l, l2);
        }

        public final void show(Context context, String target, Long channelId, Long messageId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(target, "target");
            Intent intent = new Intent();
            intent.putExtra(WidgetTosReportViolation.EXTRA_CHANNEL_ID, channelId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_TARGET, target);
            AppScreen2.d(context, WidgetTosReportViolation.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTosReportViolation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation.this).sendReport();
        }
    }

    /* compiled from: WidgetTosReportViolation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleReportSubmissionError$1, reason: invalid class name */
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
            WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation.this).handleDismissError();
        }
    }

    /* compiled from: WidgetTosReportViolation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetTosReportViolationViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetTosReportViolation widgetTosReportViolation) {
            super(1, widgetTosReportViolation, WidgetTosReportViolation.class, "configureUI", "configureUI(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetTosReportViolationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetTosReportViolationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetTosReportViolation.access$configureUI((WidgetTosReportViolation) this.receiver, viewState);
        }
    }

    public WidgetTosReportViolation() {
        super(R.layout.widget_tos_report_violation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTosReportViolation4.INSTANCE, null, 2, null);
        WidgetTosReportViolation5 widgetTosReportViolation5 = new WidgetTosReportViolation5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetTosReportViolationViewModel.class), new WidgetTosReportViolation$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetTosReportViolation5));
        this.args = LazyJVM.lazy(new WidgetTosReportViolation3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetTosReportViolation widgetTosReportViolation, WidgetTosReportViolationViewModel.ViewState viewState) {
        widgetTosReportViolation.configureUI(viewState);
    }

    public static final /* synthetic */ Companion.Arguments access$getArgs$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getArgs();
    }

    public static final /* synthetic */ WidgetTosReportViolationBinding access$getBinding$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getBinding();
    }

    public static final /* synthetic */ WidgetTosReportViolationViewModel access$getViewModel$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getViewModel();
    }

    private final void configureUI(WidgetTosReportViolationViewModel.ViewState viewState) {
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Loading) {
            handleLoading();
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Loaded) {
            handleLoaded(((WidgetTosReportViolationViewModel.ViewState.Loaded) viewState).getReasons());
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Submitting) {
            handleReportSubmitting(((WidgetTosReportViolationViewModel.ViewState.Submitting) viewState).getReason());
        } else if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Submitted) {
            handleReportSubmitted();
        } else {
            if (!(viewState instanceof WidgetTosReportViolationViewModel.ViewState.SubmissionError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleReportSubmissionError();
        }
    }

    private final Companion.Arguments getArgs() {
        return (Companion.Arguments) this.args.getValue();
    }

    private final WidgetTosReportViolationBinding getBinding() {
        return (WidgetTosReportViolationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetTosReportViolationViewModel getViewModel() {
        return (WidgetTosReportViolationViewModel) this.viewModel.getValue();
    }

    private final void handleLoaded(List<ReportReason> reasons) {
        ProgressBar progressBar = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(8);
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(getViewModel().getReasonSelected() != null);
        getBinding().f2675b.setIsLoading(false);
        getBinding().f2675b.setOnClickListener(new AnonymousClass1());
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportReasonsHeader");
        textView.setVisibility(0);
        getBinding().d.removeAllViews();
        for (ReportReason reportReason : reasons) {
            WidgetTosReportViolationReasonView widgetTosReportViolationReasonView = new WidgetTosReportViolationReasonView(requireContext(), null, 0, 6, null);
            if (!ViewCompat.isLaidOut(widgetTosReportViolationReasonView) || widgetTosReportViolationReasonView.isLayoutRequested()) {
                widgetTosReportViolationReasonView.addOnLayoutChangeListener(new WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2(widgetTosReportViolationReasonView, reportReason, this));
            } else {
                widgetTosReportViolationReasonView.setReason(reportReason);
                widgetTosReportViolationReasonView.setChecked(Intrinsics3.areEqual(reportReason, access$getViewModel$p(this).getReasonSelected()));
                widgetTosReportViolationReasonView.setOnClickListener(new WidgetTosReportViolation2(widgetTosReportViolationReasonView, reportReason, this));
            }
            getBinding().d.addView(widgetTosReportViolationReasonView);
        }
    }

    private final void handleLoading() {
        ProgressBar progressBar = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(0);
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().d.removeAllViews();
    }

    private final void handleReportSubmissionError() {
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f2675b.setIsLoading(false);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.k(this, R.string.notice_dispatch_error, new Object[0], null, 4), FormatUtils.k(this, R.string.report_modal_error, new Object[]{"https://dis.gd/request"}, null, 4), FormatUtils.k(this, R.string.okay, new Object[0], null, 4), null, null, null, null, null, null, null, null, 0, new AnonymousClass1(), 8176, null);
    }

    private final void handleReportSubmitted() {
        AppToast.i(this, R.string.report_modal_submitted, 0, 4);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final void handleReportSubmitting(int reason) {
        LinearLayout linearLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
        Iterator<View> it = ViewGroup.getChildren(linearLayout).iterator();
        while (it.hasNext()) {
            it.next().setEnabled(false);
        }
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f2675b.setIsLoading(true);
        getViewModel().sendReportAPICall(reason, getArgs().getChannelId(), getArgs().getMessageId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(R.string.report);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportHeader");
        FormatUtils.n(textView, R.string.report_message, new Object[]{getArgs().getTarget()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.reportTooltip");
        FormatUtils.n(linkifiedTextView, R.string.form_report_help_text, new Object[]{"https://discord.com/guidelines"}, null, 4);
        getBinding().f2675b.setIsLoading(false);
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetTosReportViolation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

package com.discord.widgets.status;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
import d0.z.d.FunctionReferenceImpl;
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

/* compiled from: WidgetThreadStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatus;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;", "viewState", "", "updateView", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;)V", "Lcom/discord/widgets/status/WidgetThreadStatus$Event;", "event", "handleEvent", "(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetThreadStatusBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetThreadStatusBinding;", "binding", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/status/WidgetThreadStatusViewModel;", "viewModel", "<init>", "Event", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadStatusBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatus$Event;", "", "<init>", "()V", "Error", "Lcom/discord/widgets/status/WidgetThreadStatus$Event$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetThreadStatus.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatus$Event$Error;", "Lcom/discord/widgets/status/WidgetThreadStatus$Event;", "", "component1", "()I", ModelAuditLogEntry.CHANGE_KEY_CODE, "copy", "(I)Lcom/discord/widgets/status/WidgetThreadStatus$Event$Error;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Error extends Event {
            private final int code;

            public Error(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.code;
                }
                return error.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Error copy(int code) {
                return new Error(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && this.code == ((Error) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.B(outline.U("Error(code="), this.code, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadStatusViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadStatusViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadStatus.access$updateView(WidgetThreadStatus.this, viewState);
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatus$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Event, Unit> {
        public AnonymousClass2(WidgetThreadStatus widgetThreadStatus) {
            super(1, widgetThreadStatus, WidgetThreadStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetThreadStatus.access$handleEvent((WidgetThreadStatus) this.receiver, event);
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadStatus.access$getViewModel$p(WidgetThreadStatus.this).onUnarchiveTapped();
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$updateView$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadStatus.access$getViewModel$p(WidgetThreadStatus.this).onJoinTapped();
        }
    }

    public WidgetThreadStatus() {
        super(R.layout.widget_thread_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadStatus2.INSTANCE, null, 2, null);
        WidgetThreadStatus3 widgetThreadStatus3 = WidgetThreadStatus3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadStatusViewModel.class), new WidgetThreadStatus$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadStatus3));
    }

    public static final /* synthetic */ WidgetThreadStatusViewModel access$getViewModel$p(WidgetThreadStatus widgetThreadStatus) {
        return widgetThreadStatus.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetThreadStatus widgetThreadStatus, Event event) {
        widgetThreadStatus.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadStatus widgetThreadStatus, WidgetThreadStatusViewModel.ViewState viewState) {
        widgetThreadStatus.updateView(viewState);
    }

    private final WidgetThreadStatusBinding getBinding() {
        return (WidgetThreadStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadStatusViewModel getViewModel() {
        return (WidgetThreadStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(Event event) {
        if (event instanceof Event.Error) {
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(((Event.Error) event).getCode());
            AppToast.i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, 4);
        }
    }

    @MainThread
    private final void updateView(WidgetThreadStatusViewModel.ViewState viewState) {
        getBinding().c.setIsLoading(viewState.isLoading());
        WidgetThreadStatusViewModel.Status threadStatus = viewState.getThreadStatus();
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Hide) {
            ConstraintLayout constraintLayout = getBinding().f2673b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadStatus");
            constraintLayout.setVisibility(8);
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Archived) {
            ConstraintLayout constraintLayout2 = getBinding().f2673b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.threadStatus");
            constraintLayout2.setVisibility(0);
            LoadingButton loadingButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.threadStatusButton");
            WidgetThreadStatusViewModel.Status.Archived archived = (WidgetThreadStatusViewModel.Status.Archived) threadStatus;
            loadingButton.setVisibility(archived.getCanArchive() ? 0 : 8);
            LinkifiedTextView linkifiedTextView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.threadStatusText");
            linkifiedTextView.setText(archived.isLocked() ? getResources().getString(R.string.thread_header_notice_locked) : getResources().getString(R.string.thread_header_notice_archived));
            getBinding().c.setText(getResources().getString(R.string.unarchive));
            LoadingButton loadingButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.threadStatusButton");
            loadingButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundAccent)));
            getBinding().c.setOnClickListener(new AnonymousClass1());
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Unjoined) {
            ConstraintLayout constraintLayout3 = getBinding().f2673b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.threadStatus");
            constraintLayout3.setVisibility(0);
            LoadingButton loadingButton3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton3, "binding.threadStatusButton");
            loadingButton3.setVisibility(0);
            LinkifiedTextView linkifiedTextView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.threadStatusText");
            linkifiedTextView2.setText(getResources().getString(R.string.thread_header_notice_join));
            getBinding().c.setText(getResources().getString(R.string.join));
            LoadingButton loadingButton4 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton4, "binding.threadStatusButton");
            loadingButton4.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.color_brand_500)));
            getBinding().c.setOnClickListener(new AnonymousClass2());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}

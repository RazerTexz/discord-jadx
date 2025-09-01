package com.discord.widgets.feedback;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetFeedbackSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.FeedbackView;
import com.discord.widgets.voice.feedback.WidgetIssueDetailsForm;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetFeedbackSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b<\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001d\u00102\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0002038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010!\u001a\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/discord/widgets/feedback/WidgetFeedbackSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "viewState", "", "updateView", "(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;)V", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;)V", "", "getContentViewResId", "()I", "onResume", "()V", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function0;", "onDismissed", "Lkotlin/jvm/functions/Function0;", "getOnDismissed", "()Lkotlin/jvm/functions/Function0;", "setOnDismissed", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel;", "viewModelCallFeedbackSheet$delegate", "Lkotlin/Lazy;", "getViewModelCallFeedbackSheet", "()Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel;", "viewModelCallFeedbackSheet", "Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel;", "viewModelStreamFeedbackSheet$delegate", "getViewModelStreamFeedbackSheet", "()Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel;", "viewModelStreamFeedbackSheet", "", "isShowingFeedbackIssues", "Z", "Lcom/discord/databinding/WidgetFeedbackSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetFeedbackSheetBinding;", "binding", "Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSheetViewModel;", "viewModelGuildDeleteFeedbackSheet$delegate", "getViewModelGuildDeleteFeedbackSheet", "()Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSheetViewModel;", "viewModelGuildDeleteFeedbackSheet", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel;", "getViewModel", "()Lcom/discord/widgets/feedback/FeedbackSheetViewModel;", "viewModel", "<init>", "Companion", "FeedbackType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFeedbackSheet extends AppBottomSheet {
    public static final String ARG_CALL_FEEDBACK_CONFIG = "ARG_CONFIG";
    public static final String ARG_FEEDBACK_TYPE = "ARG_FEEDBACK_TYPE";
    public static final String ARG_GUILD_DELETE_FEEDBACK_GUILD_ID = "ARG_GUILD_DELETE_FEEDBACK_GUILD_ID";
    public static final String ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID = "ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID";
    public static final String ARG_STREAM_FEEDBACK_STREAM_KEY = "ARG_STREAM_FEEDBACK_STREAM_KEY ";
    private static final long SHEET_DISMISS_DELAY_MS = 600;
    private static final long SHEET_EXPAND_DELAY_MS = 100;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean isShowingFeedbackIssues;
    private Function0<Unit> onDismissed;

    /* renamed from: viewModelCallFeedbackSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelCallFeedbackSheet;

    /* renamed from: viewModelGuildDeleteFeedbackSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelGuildDeleteFeedbackSheet;

    /* renamed from: viewModelStreamFeedbackSheet$delegate, reason: from kotlin metadata */
    private final Lazy viewModelStreamFeedbackSheet;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFeedbackSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFeedbackSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/feedback/WidgetFeedbackSheet$Companion;", "", "Lcom/discord/widgets/feedback/WidgetFeedbackSheet$FeedbackType;", "feedbackType", "Lcom/discord/widgets/feedback/WidgetFeedbackSheet;", "newInstance", "(Lcom/discord/widgets/feedback/WidgetFeedbackSheet$FeedbackType;)Lcom/discord/widgets/feedback/WidgetFeedbackSheet;", "", "ARG_CALL_FEEDBACK_CONFIG", "Ljava/lang/String;", WidgetFeedbackSheet.ARG_FEEDBACK_TYPE, WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID, WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID, "ARG_STREAM_FEEDBACK_STREAM_KEY", "", "SHEET_DISMISS_DELAY_MS", "J", "SHEET_EXPAND_DELAY_MS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final WidgetFeedbackSheet newInstance(FeedbackType feedbackType) {
            Intrinsics3.checkNotNullParameter(feedbackType, "feedbackType");
            WidgetFeedbackSheet widgetFeedbackSheet = new WidgetFeedbackSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetFeedbackSheet.ARG_FEEDBACK_TYPE, feedbackType);
            widgetFeedbackSheet.setArguments(bundle);
            return widgetFeedbackSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/feedback/WidgetFeedbackSheet$FeedbackType;", "", "<init>", "(Ljava/lang/String;I)V", "CALL", "STREAM", "GUILD_DELETE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum FeedbackType {
        CALL,
        STREAM,
        GUILD_DELETE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeedbackType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackType.CALL.ordinal()] = 1;
            iArr[FeedbackType.STREAM.ordinal()] = 2;
            iArr[FeedbackType.GUILD_DELETE.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$bindSubscriptions$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FeedbackSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFeedbackSheet widgetFeedbackSheet) {
            super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "updateView", "updateView(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetFeedbackSheet.access$updateView((WidgetFeedbackSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$bindSubscriptions$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FeedbackSheetViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFeedbackSheet widgetFeedbackSheet) {
            super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetFeedbackSheet.access$handleEvent((WidgetFeedbackSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            AppToast.i(WidgetFeedbackSheet.this, R.string.call_feedback_confirmation, 0, 4);
            WidgetFeedbackSheet.this.requireDialog().cancel();
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFeedbackSheet.access$getViewModel$p(WidgetFeedbackSheet.this).submitForm();
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.access$getViewModel$p(WidgetFeedbackSheet.this).selectRating(FeedbackRating.BAD);
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.access$getViewModel$p(WidgetFeedbackSheet.this).selectRating(FeedbackRating.NEUTRAL);
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFeedbackSheet.access$getViewModel$p(WidgetFeedbackSheet.this).selectRating(FeedbackRating.GOOD);
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "issue", "", "invoke", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<FeedbackIssue, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
            invoke2(feedbackIssue);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FeedbackIssue feedbackIssue) {
            Intrinsics3.checkNotNullParameter(feedbackIssue, "issue");
            WidgetFeedbackSheet.access$getViewModel$p(WidgetFeedbackSheet.this).selectIssue(feedbackIssue, WidgetFeedbackSheet.this.getString(feedbackIssue.getReasonStringRes()));
        }
    }

    /* compiled from: WidgetFeedbackSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$updateView$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetFeedbackSheet.access$setShowingFeedbackIssues$p(WidgetFeedbackSheet.this, true);
            WidgetFeedbackSheet.this.setBottomSheetState(3);
        }
    }

    public WidgetFeedbackSheet() {
        super(false, 1, null);
        this.onDismissed = WidgetFeedbackSheet3.INSTANCE;
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFeedbackSheet2.INSTANCE, null, 2, null);
        WidgetFeedbackSheet4 widgetFeedbackSheet4 = new WidgetFeedbackSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModelCallFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(CallFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFeedbackSheet4));
        WidgetFeedbackSheet6 widgetFeedbackSheet6 = new WidgetFeedbackSheet6(this);
        AppViewModelDelegates3 appViewModelDelegates32 = new AppViewModelDelegates3(this);
        this.viewModelStreamFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StreamFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$2(appViewModelDelegates32), new AppViewModelDelegates5(widgetFeedbackSheet6));
        WidgetFeedbackSheet5 widgetFeedbackSheet5 = new WidgetFeedbackSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates33 = new AppViewModelDelegates3(this);
        this.viewModelGuildDeleteFeedbackSheet = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildDeleteFeedbackSheetViewModel.class), new WidgetFeedbackSheet$appViewModels$$inlined$viewModels$3(appViewModelDelegates33), new AppViewModelDelegates5(widgetFeedbackSheet5));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetFeedbackSheet widgetFeedbackSheet) {
        return widgetFeedbackSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ FeedbackSheetViewModel access$getViewModel$p(WidgetFeedbackSheet widgetFeedbackSheet) {
        return widgetFeedbackSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFeedbackSheet widgetFeedbackSheet, FeedbackSheetViewModel.Event event) {
        widgetFeedbackSheet.handleEvent(event);
    }

    public static final /* synthetic */ boolean access$isShowingFeedbackIssues$p(WidgetFeedbackSheet widgetFeedbackSheet) {
        return widgetFeedbackSheet.isShowingFeedbackIssues;
    }

    public static final /* synthetic */ void access$setShowingFeedbackIssues$p(WidgetFeedbackSheet widgetFeedbackSheet, boolean z2) {
        widgetFeedbackSheet.isShowingFeedbackIssues = z2;
    }

    public static final /* synthetic */ void access$updateView(WidgetFeedbackSheet widgetFeedbackSheet, FeedbackSheetViewModel.ViewState viewState) {
        widgetFeedbackSheet.updateView(viewState);
    }

    private final WidgetFeedbackSheetBinding getBinding() {
        return (WidgetFeedbackSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FeedbackSheetViewModel getViewModel() {
        Serializable serializable = requireArguments().getSerializable(ARG_FEEDBACK_TYPE);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.feedback.WidgetFeedbackSheet.FeedbackType");
        int iOrdinal = ((FeedbackType) serializable).ordinal();
        if (iOrdinal == 0) {
            return getViewModelCallFeedbackSheet();
        }
        if (iOrdinal == 1) {
            return getViewModelStreamFeedbackSheet();
        }
        if (iOrdinal == 2) {
            return getViewModelGuildDeleteFeedbackSheet();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final CallFeedbackSheetViewModel getViewModelCallFeedbackSheet() {
        return (CallFeedbackSheetViewModel) this.viewModelCallFeedbackSheet.getValue();
    }

    private final GuildDeleteFeedbackSheetViewModel getViewModelGuildDeleteFeedbackSheet() {
        return (GuildDeleteFeedbackSheetViewModel) this.viewModelGuildDeleteFeedbackSheet.getValue();
    }

    private final StreamFeedbackSheetViewModel getViewModelStreamFeedbackSheet() {
        return (StreamFeedbackSheetViewModel) this.viewModelStreamFeedbackSheet.getValue();
    }

    private final void handleEvent(FeedbackSheetViewModel.Event event) {
        if (event instanceof FeedbackSheetViewModel.Event.Submitted) {
            if (!((FeedbackSheetViewModel.Event.Submitted) event).getShowConfirmation()) {
                requireDialog().cancel();
                return;
            }
            Observable<Long> observableD0 = Observable.d0(SHEET_DISMISS_DELAY_MS, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n             …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
            return;
        }
        if (event instanceof FeedbackSheetViewModel.Event.NavigateToIssueDetails) {
            WidgetIssueDetailsForm.Companion companion = WidgetIssueDetailsForm.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FeedbackSheetViewModel.Event.NavigateToIssueDetails navigateToIssueDetails = (FeedbackSheetViewModel.Event.NavigateToIssueDetails) event;
            companion.launch(contextRequireContext, navigateToIssueDetails.getPendingFeedback(), navigateToIssueDetails.getShowCxLinkForIssueDetails());
            requireDialog().cancel();
        }
    }

    private final void updateView(FeedbackSheetViewModel.ViewState viewState) {
        boolean z2 = !this.isShowingFeedbackIssues && (viewState.getFeedbackIssues().isEmpty() ^ true);
        if (z2) {
            if (viewState.getShowFaceRatings()) {
                NestedScrollView nestedScrollView = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.feedbackSheetContainer");
                updatePeekHeightPx(nestedScrollView.getMeasuredHeight());
            }
            setBottomSheetState(4);
        }
        getBinding().e.setText(viewState.getTitleTextResId());
        FeedbackView feedbackView = getBinding().d;
        Integer promptTextResId = viewState.getPromptTextResId();
        String string = promptTextResId != null ? getString(promptTextResId.intValue()) : null;
        FeedbackRating selectedFeedbackRating = viewState.getSelectedFeedbackRating();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        String string2 = getString(viewState.getIssuesHeaderTextResId());
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(viewState.issuesHeaderTextResId)");
        feedbackView.updateView(string, selectedFeedbackRating, anonymousClass2, anonymousClass3, anonymousClass4, string2, viewState.getFeedbackIssues(), new AnonymousClass5());
        if (z2) {
            Observable<Long> observableD0 = Observable.d0(100L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(), 62, (Object) null);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFeedbackSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_feedback_sheet;
    }

    public final Function0<Unit> getOnDismissed() {
        return this.onDismissed;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        this.onDismissed.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f2385b.setOnClickListener(new AnonymousClass1());
    }

    public final void setOnDismissed(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onDismissed = function0;
    }
}

package com.discord.widgets.chat.list;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.PublishMessageDialogBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.list.PublishActionDialogViewModel;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
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

/* compiled from: PublishActionDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialog;", "Lcom/discord/app/AppDialog;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "viewState", "", "updateView", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", "renderLoading", "()V", "renderNoFollowers", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedHasFollowers;", "renderHasFollowers", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedHasFollowers;)V", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/databinding/PublishMessageDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/PublishMessageDialogBinding;", "binding", "Lkotlin/Function0;", "onSuccess", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/chat/list/PublishActionDialogViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PublishActionDialog extends AppDialog {
    private static final String ARG_THEME_ID = "theme_id";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onSuccess;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(PublishActionDialog.class, "binding", "getBinding()Lcom/discord/databinding/PublishMessageDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: PublishActionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JK\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lkotlin/Function0;", "", "onSuccess", "", "dialogTheme", "show", "(Landroidx/fragment/app/FragmentManager;JJLkotlin/jvm/functions/Function0;Ljava/lang/Integer;)V", "", "ARG_THEME_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, long j2, Function0 function0, Integer num, int i, Object obj) {
            companion.show(fragmentManager, j, j2, function0, (i & 16) != 0 ? null : num);
        }

        public final void show(FragmentManager fragmentManager, long messageId, long channelId, Function0<Unit> onSuccess, Integer dialogTheme) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            PublishActionDialog publishActionDialog = new PublishActionDialog();
            if (onSuccess != null) {
                PublishActionDialog.access$setOnSuccess$p(publishActionDialog, onSuccess);
            }
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (dialogTheme != null) {
                bundleT.putInt(PublishActionDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            publishActionDialog.setArguments(bundleT);
            publishActionDialog.show(fragmentManager, PublishActionDialog.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$1, reason: invalid class name */
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
            PublishActionDialog.this.dismiss();
        }
    }

    /* compiled from: PublishActionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PublishActionDialog.access$getViewModel$p(PublishActionDialog.this).publishMessage();
            Function0 function0Access$getOnSuccess$p = PublishActionDialog.access$getOnSuccess$p(PublishActionDialog.this);
            if (function0Access$getOnSuccess$p != null) {
                function0Access$getOnSuccess$p.invoke();
            }
        }
    }

    /* compiled from: PublishActionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PublishActionDialog.this.dismiss();
        }
    }

    /* compiled from: PublishActionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.ViewState, Unit> {
        public AnonymousClass1(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "updateView", "updateView(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            PublishActionDialog.access$updateView((PublishActionDialog) this.receiver, viewState);
        }
    }

    /* compiled from: PublishActionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.Event, Unit> {
        public AnonymousClass2(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            PublishActionDialog.access$handleEvent((PublishActionDialog) this.receiver, event);
        }
    }

    public PublishActionDialog() {
        super(R.layout.publish_message_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, PublishActionDialog2.INSTANCE, null, 2, null);
        PublishActionDialog3 publishActionDialog3 = new PublishActionDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(PublishActionDialogViewModel.class), new PublishActionDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(publishActionDialog3));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ Function0 access$getOnSuccess$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.onSuccess;
    }

    public static final /* synthetic */ PublishActionDialogViewModel access$getViewModel$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(PublishActionDialog publishActionDialog, PublishActionDialogViewModel.Event event) {
        publishActionDialog.handleEvent(event);
    }

    public static final /* synthetic */ void access$setOnSuccess$p(PublishActionDialog publishActionDialog, Function0 function0) {
        publishActionDialog.onSuccess = function0;
    }

    public static final /* synthetic */ void access$updateView(PublishActionDialog publishActionDialog, PublishActionDialogViewModel.ViewState viewState) {
        publishActionDialog.updateView(viewState);
    }

    private final PublishMessageDialogBinding getBinding() {
        return (PublishMessageDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PublishActionDialogViewModel getViewModel() {
        return (PublishActionDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(PublishActionDialogViewModel.Event event) {
        if (event instanceof PublishActionDialogViewModel.Event.Success) {
            AppToast.i(this, R.string.message_published, 0, 4);
        } else if (event instanceof PublishActionDialogViewModel.Event.Failure) {
            AppToast.i(this, R.string.publish_followed_news_generic_body, 0, 4);
        }
        dismiss();
    }

    private final void renderHasFollowers(PublishActionDialogViewModel.ViewState.LoadedHasFollowers viewState) {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.n(textView, R.string.publish_followed_news_body_reach, new Object[]{String.valueOf(viewState.getFollowerStats().getGuildsFollowing())}, null, 4);
    }

    private final void renderLoading() {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.n(textView, R.string.loading, new Object[0], null, 4);
    }

    private final void renderNoFollowers() {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.n(textView, R.string.publish_followed_news_body, new Object[0], null, 4);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2, Function0<Unit> function0, Integer num) {
        INSTANCE.show(fragmentManager, j, j2, function0, num);
    }

    private final void updateView(PublishActionDialogViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, PublishActionDialogViewModel.ViewState.Loading.INSTANCE)) {
            renderLoading();
        } else if (Intrinsics3.areEqual(viewState, PublishActionDialogViewModel.ViewState.LoadedNoFollowers.INSTANCE)) {
            renderNoFollowers();
        } else if (viewState instanceof PublishActionDialogViewModel.ViewState.LoadedHasFollowers) {
            renderHasFollowers((PublishActionDialogViewModel.ViewState.LoadedHasFollowers) viewState);
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources.Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        FormatUtils.n(textView, R.string.news_channel_publish_bump, new Object[0], null, 4);
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility(0);
        TextView textView2 = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noticeBodyText");
        textView2.setTextAlignment(2);
        TextView textView3 = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.noticeBodyText");
        textView3.setMovementMethod(new WidgetNoticeDialog.ActionLinkMovementMethod(new AnonymousClass1()));
        MaterialButton materialButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        ViewExtensions.setTextAndVisibilityBy(materialButton, FormatUtils.k(this, R.string.news_channel_publish, new Object[0], null, 4));
        getBinding().f.setOnClickListener(new AnonymousClass2());
        MaterialButton materialButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, FormatUtils.k(this, R.string.cancel, new Object[0], null, 4));
        getBinding().c.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}

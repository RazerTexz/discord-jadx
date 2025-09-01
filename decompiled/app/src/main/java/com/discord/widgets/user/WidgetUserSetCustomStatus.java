package com.discord.widgets.user;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.RadioManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetUserSetCustomStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\fR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatus;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;", "viewState", "", "updateView", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;)V", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;)V", "openEmojiPicker", "()V", "Lcom/google/android/material/radiobutton/MaterialRadioButton;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;", "expiration", "setExpirationOnCheck", "(Lcom/google/android/material/radiobutton/MaterialRadioButton;Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$FormState$Expiration;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/views/RadioManager;", "expirationRadioManager", "Lcom/discord/views/RadioManager;", "Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", "binding", "", "currentEmojiUri", "Ljava/lang/String;", "Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserSetCustomStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserSetCustomStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentEmojiUri;
    private RadioManager expirationRadioManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatus$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetUserSetCustomStatus.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetUserSetCustomStatusViewModel.FormState.Expiration.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.NEVER.ordinal()] = 1;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_30_MINUTES.ordinal()] = 2;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_1_HOUR.ordinal()] = 3;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_4_HOURS.ordinal()] = 4;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.TOMORROW.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$openEmojiPicker(WidgetUserSetCustomStatus.this);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).clearStatusTextAndEmoji();
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).setStatusText(editable.toString());
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).saveStatus();
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetUserSetCustomStatusViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
            super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetUserSetCustomStatus.access$updateView((WidgetUserSetCustomStatus) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetUserSetCustomStatusViewModel.Event, Unit> {
        public AnonymousClass2(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
            super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSetCustomStatusViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetUserSetCustomStatus.access$handleEvent((WidgetUserSetCustomStatus) this.receiver, event);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/user/WidgetUserSetCustomStatus$openEmojiPicker$1", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "onEmojiPicked", "(Lcom/discord/models/domain/emoji/Emoji;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$openEmojiPicker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements EmojiPickerListener {
        public AnonymousClass1() {
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
        public void onEmojiPicked(Emoji emoji) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).setStatusEmoji(emoji);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$setExpirationOnCheck$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSetCustomStatusViewModel.FormState.Expiration $expiration;

        public AnonymousClass1(WidgetUserSetCustomStatusViewModel.FormState.Expiration expiration) {
            this.$expiration = expiration;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).setExpiration(this.$expiration);
        }
    }

    public WidgetUserSetCustomStatus() {
        super(R.layout.widget_user_set_custom_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserSetCustomStatus2.INSTANCE, null, 2, null);
        WidgetUserSetCustomStatus3 widgetUserSetCustomStatus3 = WidgetUserSetCustomStatus3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserSetCustomStatusViewModel.class), new WidgetUserSetCustomStatus$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserSetCustomStatus3));
    }

    public static final /* synthetic */ WidgetUserSetCustomStatusViewModel access$getViewModel$p(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        return widgetUserSetCustomStatus.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel.Event event) {
        widgetUserSetCustomStatus.handleEvent(event);
    }

    public static final /* synthetic */ void access$openEmojiPicker(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        widgetUserSetCustomStatus.openEmojiPicker();
    }

    public static final /* synthetic */ void access$updateView(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel.ViewState viewState) {
        widgetUserSetCustomStatus.updateView(viewState);
    }

    private final WidgetUserSetCustomStatusBinding getBinding() {
        return (WidgetUserSetCustomStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserSetCustomStatusViewModel getViewModel() {
        return (WidgetUserSetCustomStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetUserSetCustomStatusViewModel.Event event) {
        if (!(event instanceof WidgetUserSetCustomStatusViewModel.Event.SetStatusSuccess)) {
            if (event instanceof WidgetUserSetCustomStatusViewModel.Event.SetStatusFailure) {
                AppToast.i(this, ((WidgetUserSetCustomStatusViewModel.Event.SetStatusFailure) event).getFailureMessageStringRes(), 0, 4);
            }
        } else {
            AppToast.i(this, ((WidgetUserSetCustomStatusViewModel.Event.SetStatusSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void openEmojiPicker() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, new AnonymousClass1(), EmojiPickerContextType.Global.INSTANCE, null, 8, null);
    }

    private final void setExpirationOnCheck(MaterialRadioButton materialRadioButton, WidgetUserSetCustomStatusViewModel.FormState.Expiration expiration) {
        materialRadioButton.setOnClickListener(new AnonymousClass1(expiration));
    }

    private final void updateView(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
        MaterialRadioButton materialRadioButton;
        if (viewState instanceof WidgetUserSetCustomStatusViewModel.ViewState.Loaded) {
            WidgetUserSetCustomStatusViewModel.ViewState.Loaded loaded = (WidgetUserSetCustomStatusViewModel.ViewState.Loaded) viewState;
            WidgetUserSetCustomStatusViewModel.FormState formState = loaded.getFormState();
            if (formState.getEmoji() != null) {
                String imageUri = formState.getEmoji().getImageUri(true, IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.custom_status_emoji_preview_size)), getContext());
                if (!Intrinsics3.areEqual(imageUri, this.currentEmojiUri)) {
                    SimpleDraweeView simpleDraweeView = getBinding().f2692b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.setCustomStatusEmoji");
                    MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
                    this.currentEmojiUri = imageUri;
                }
            } else {
                getBinding().f2692b.setActualImageResource(R.drawable.ic_smiley_desaturated);
                this.currentEmojiUri = null;
            }
            TextInputLayout textInputLayout = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            if (!Intrinsics3.areEqual(formState.getText(), textOrEmpty)) {
                TextInputLayout textInputLayout2 = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.setCustomStatusText");
                ViewExtensions.setText(textInputLayout2, formState.getText());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout3 = getBinding().j;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.setCustomStatusText");
                    EditText editText = textInputLayout3.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout4 = getBinding().j;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.setCustomStatusText");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout4).length());
                }
            }
            TextInputLayout textInputLayout5 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.setCustomStatusText");
            textInputLayout5.setEndIconVisible(loaded.getShowStatusClear());
            int iOrdinal = formState.getExpiration().ordinal();
            if (iOrdinal == 0) {
                materialRadioButton = getBinding().g;
            } else if (iOrdinal == 1) {
                materialRadioButton = getBinding().e;
            } else if (iOrdinal == 2) {
                materialRadioButton = getBinding().d;
            } else if (iOrdinal == 3) {
                materialRadioButton = getBinding().f;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                materialRadioButton = getBinding().h;
            }
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "when (formState.expirati…sExpirationTomorrow\n    }");
            RadioManager radioManager = this.expirationRadioManager;
            if (radioManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("expirationRadioManager");
            }
            radioManager.a(materialRadioButton);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) throws Resources.NotFoundException {
        Window window;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.custom_status);
        this.expirationRadioManager = new RadioManager(Collections2.listOf((Object[]) new MaterialRadioButton[]{getBinding().g, getBinding().e, getBinding().d, getBinding().f, getBinding().h}));
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().j.setEndIconOnClickListener(new AnonymousClass2());
        TextInputLayout textInputLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass3());
        MaterialRadioButton materialRadioButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.setCustomStatusExpirationNever");
        setExpirationOnCheck(materialRadioButton, WidgetUserSetCustomStatusViewModel.FormState.Expiration.NEVER);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.custom_status_clear_in_minutes_minutes, 30, 30);
        MaterialRadioButton materialRadioButton2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.setCustomStatusExpiration30Minutes");
        materialRadioButton2.setText(FormatUtils.k(this, R.string.custom_status_clear_in_minutes, new Object[]{quantityString}, null, 4));
        MaterialRadioButton materialRadioButton3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.setCustomStatusExpiration30Minutes");
        setExpirationOnCheck(materialRadioButton3, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_30_MINUTES);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString2 = StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.custom_status_clear_in_hours_hours, 1, 1);
        MaterialRadioButton materialRadioButton4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.setCustomStatusExpiration1Hour");
        materialRadioButton4.setText(FormatUtils.k(this, R.string.custom_status_clear_in_hours, new Object[]{quantityString2}, null, 4));
        MaterialRadioButton materialRadioButton5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton5, "binding.setCustomStatusExpiration1Hour");
        setExpirationOnCheck(materialRadioButton5, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_1_HOUR);
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        CharSequence quantityString3 = StringResourceUtils.getQuantityString(resources3, requireContext(), R.plurals.custom_status_clear_in_hours_hours, 4, 4);
        MaterialRadioButton materialRadioButton6 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton6, "binding.setCustomStatusExpiration4Hours");
        materialRadioButton6.setText(FormatUtils.k(this, R.string.custom_status_clear_in_hours, new Object[]{quantityString3}, null, 4));
        MaterialRadioButton materialRadioButton7 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton7, "binding.setCustomStatusExpiration4Hours");
        setExpirationOnCheck(materialRadioButton7, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_4_HOURS);
        MaterialRadioButton materialRadioButton8 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton8, "binding.setCustomStatusExpirationTomorrow");
        setExpirationOnCheck(materialRadioButton8, WidgetUserSetCustomStatusViewModel.FormState.Expiration.TOMORROW);
        getBinding().i.setOnClickListener(new AnonymousClass4());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserSetCustomStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetUserSetCustomStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}

package com.discord.widgets.status;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumPostStatusBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ReactionView;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetForumPostStatusViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetForumPostStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0006R\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatus;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Valid;", "viewState", "", "configureMessageCount", "(Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState$Valid;)V", "configureReactions", "configureFollow", "onResume", "()V", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;", "handleViewState", "(Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;)V", "configureUI", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/status/WidgetForumPostStatusViewModel;", "viewModel", "Landroid/content/res/ColorStateList;", "reactionMeTextColor$delegate", "getReactionMeTextColor", "()Landroid/content/res/ColorStateList;", "reactionMeTextColor", "defaultReactionMeTextColor$delegate", "getDefaultReactionMeTextColor", "defaultReactionMeTextColor", "Lcom/discord/databinding/WidgetForumPostStatusBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetForumPostStatusBinding;", "binding", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetForumPostStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetForumPostStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumPostStatusBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: defaultReactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultReactionMeTextColor;

    /* renamed from: reactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy reactionMeTextColor;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetForumPostStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatus$configureFollow$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetForumPostStatusViewModel.ViewState.Valid $viewState;

        public AnonymousClass1(WidgetForumPostStatusViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getFollowRequestInProgress()) {
                return;
            }
            WidgetForumPostStatusViewModel widgetForumPostStatusViewModelAccess$getViewModel$p = WidgetForumPostStatus.access$getViewModel$p(WidgetForumPostStatus.this);
            Context contextRequireContext = WidgetForumPostStatus.this.requireContext();
            FragmentManager parentFragmentManager = WidgetForumPostStatus.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetForumPostStatusViewModelAccess$getViewModel$p.onFollowPress(contextRequireContext, parentFragmentManager, this.$viewState.getGuildId(), this.$viewState.getChannelId(), this.$viewState.isArchivedThread(), this.$viewState.isFollowedThread());
        }
    }

    /* compiled from: WidgetForumPostStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatus$configureReactions$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetForumPostStatusViewModel.ViewState.Valid $viewState;

        public AnonymousClass2(WidgetForumPostStatusViewModel.ViewState.Valid valid) {
            this.$viewState = valid;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetForumPostStatusViewModel widgetForumPostStatusViewModelAccess$getViewModel$p = WidgetForumPostStatus.access$getViewModel$p(WidgetForumPostStatus.this);
            Context contextRequireContext = WidgetForumPostStatus.this.requireContext();
            FragmentManager parentFragmentManager = WidgetForumPostStatus.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetForumPostStatusViewModelAccess$getViewModel$p.onReactionPress(contextRequireContext, parentFragmentManager, this.$viewState.getMyUserId(), this.$viewState.getMessageId().longValue(), this.$viewState.getGuildId(), this.$viewState.getChannelId(), this.$viewState.isArchivedThread(), this.$viewState.getReaction(), this.$viewState.getHasAddReactionPermission());
        }
    }

    /* compiled from: WidgetForumPostStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatus$configureReactions$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ WidgetForumPostStatusViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetForumPostStatusViewModel.ViewState.Valid valid) {
            super(1);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetForumPostStatusViewModel widgetForumPostStatusViewModelAccess$getViewModel$p = WidgetForumPostStatus.access$getViewModel$p(WidgetForumPostStatus.this);
            Context contextRequireContext = WidgetForumPostStatus.this.requireContext();
            FragmentManager parentFragmentManager = WidgetForumPostStatus.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetForumPostStatusViewModelAccess$getViewModel$p.onReactionLongPress(contextRequireContext, parentFragmentManager, this.$viewState.getMessageId().longValue(), this.$viewState.getGuildId(), this.$viewState.getChannelId(), this.$viewState.isArchivedThread(), this.$viewState.getReaction());
        }
    }

    /* compiled from: WidgetForumPostStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatus$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetForumPostStatusViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumPostStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumPostStatusViewModel.ViewState viewState) {
            WidgetForumPostStatus widgetForumPostStatus = WidgetForumPostStatus.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetForumPostStatus.handleViewState(viewState);
        }
    }

    public WidgetForumPostStatus() {
        super(R.layout.widget_forum_post_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetForumPostStatus2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetForumPostStatusViewModel.class), new WidgetForumPostStatus$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetForumPostStatus5(this)));
        this.defaultReactionMeTextColor = LazyJVM.lazy(new WidgetForumPostStatus3(this));
        this.reactionMeTextColor = LazyJVM.lazy(new WidgetForumPostStatus4(this));
    }

    public static final /* synthetic */ WidgetForumPostStatusViewModel access$getViewModel$p(WidgetForumPostStatus widgetForumPostStatus) {
        return widgetForumPostStatus.getViewModel();
    }

    private final void configureFollow(WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        int i = viewState.isFollowedThread() ? R.string.forum_unfollow_button : R.string.forum_follow_button;
        int color = viewState.isFollowedThread() ? ColorCompat.getColor(getContext(), R.color.brand_500) : ColorCompat.getThemedColor(getContext(), R.attr.primary_300);
        Drawable drawable = viewState.isFollowedThread() ? ContextCompat.getDrawable(requireContext(), R.drawable.ic_check_16dp) : ContextCompat.getDrawable(requireContext(), R.drawable.ic_bell_16dp);
        ProgressBar progressBar = getBinding().f2389b;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.followLoadingIndicator");
        progressBar.setVisibility(viewState.getFollowRequestInProgress() ? 0 : 8);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.following");
        textView.setVisibility(viewState.getFollowRequestInProgress() ^ true ? 0 : 8);
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.following");
        FormatUtils.n(textView2, i, new Object[0], null, 4);
        getBinding().c.setTextColor(color);
        TextView textView3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.following");
        DrawableCompat.setCompoundDrawablesCompat$default(textView3, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView4 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.following");
        ColorCompat2.setDrawableColor(textView4, color);
        getBinding().d.setOnClickListener(new AnonymousClass1(viewState));
    }

    private final void configureMessageCount(WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        String messageCountString = ForumUtils.INSTANCE.getMessageCountString(Integer.valueOf(viewState.getMessageCount()));
        if (messageCountString == null) {
            messageCountString = "0";
        }
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.messageCount");
        textView.setText(messageCountString);
    }

    private final void configureReactions(WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        ReactionView reactionView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(reactionView, "binding.reaction");
        reactionView.setVisibility(viewState.getReaction() != null ? 0 : 8);
        if (viewState.getReaction() == null || viewState.getMessageId() == null) {
            return;
        }
        ColorStateList defaultReactionMeTextColor = viewState.isDefaultReaction() ? getDefaultReactionMeTextColor() : getReactionMeTextColor();
        if (defaultReactionMeTextColor != null) {
            getBinding().f.setMeTextColor(defaultReactionMeTextColor);
        }
        getBinding().f.a(viewState.getReaction(), viewState.getMessageId().longValue(), true);
        ReactionView reactionView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(reactionView2, "binding.reaction");
        reactionView2.setBackground(viewState.getHasAddReactionPermission() ? ContextCompat.getDrawable(requireContext(), R.drawable.bg_pressed_highlight) : null);
        getBinding().f.setOnClickListener(new AnonymousClass2(viewState));
        ReactionView reactionView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(reactionView3, "binding.reaction");
        ViewExtensions.setOnLongClickListenerConsumeClick(reactionView3, new AnonymousClass3(viewState));
    }

    private final WidgetForumPostStatusBinding getBinding() {
        return (WidgetForumPostStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ColorStateList getDefaultReactionMeTextColor() {
        return (ColorStateList) this.defaultReactionMeTextColor.getValue();
    }

    private final ColorStateList getReactionMeTextColor() {
        return (ColorStateList) this.reactionMeTextColor.getValue();
    }

    private final WidgetForumPostStatusViewModel getViewModel() {
        return (WidgetForumPostStatusViewModel) this.viewModel.getValue();
    }

    public final void configureUI(WidgetForumPostStatusViewModel.ViewState.Valid viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState.getMessageId() == null) {
            WidgetForumPostStatusBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            constraintLayout.setVisibility(8);
            return;
        }
        WidgetForumPostStatusBinding binding2 = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding2, "binding");
        ConstraintLayout constraintLayout2 = binding2.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        constraintLayout2.setVisibility(0);
        View view = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.separatorTwo");
        view.setVisibility(viewState.getReaction() != null ? 0 : 8);
        configureMessageCount(viewState);
        configureReactions(viewState);
        configureFollow(viewState);
    }

    public final void handleViewState(WidgetForumPostStatusViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState instanceof WidgetForumPostStatusViewModel.ViewState.Valid) {
            configureUI((WidgetForumPostStatusViewModel.ViewState.Valid) viewState);
            return;
        }
        WidgetForumPostStatusBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<WidgetForumPostStatusViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetForumPostStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

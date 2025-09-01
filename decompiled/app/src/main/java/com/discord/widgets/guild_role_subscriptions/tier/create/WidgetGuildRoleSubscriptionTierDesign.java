package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import f0.e0.Util7;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001d\u0010-\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDesign;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "", "currentColor", "setupMemberColor", "(I)V", "launchColorPicker", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", "binding", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel", "", "hideHeader$delegate", "getHideHeader", "()Z", "hideHeader", "defaultColor$delegate", "getDefaultColor", "()I", "defaultColor", "Lrx/functions/Action1;", "memberBadgeImageSelectedResult", "Lrx/functions/Action1;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierDesign.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";
    private static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_HIDE_HEADER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: defaultColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultColor;

    /* renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final Action1<String> memberBadgeImageSelectedResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDesign$Companion;", "", "", "hideHeader", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDesign;", "newInstance", "(Z)Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDesign;", "", WidgetGuildRoleSubscriptionTierDesign.DIALOG_TAG_COLOR_PICKER, "Ljava/lang/String;", WidgetGuildRoleSubscriptionTierDesign.INTENT_EXTRA_HIDE_HEADER, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierDesign newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionTierDesign newInstance(boolean hideHeader) {
            WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign = new WidgetGuildRoleSubscriptionTierDesign();
            widgetGuildRoleSubscriptionTierDesign.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGuildRoleSubscriptionTierDesign.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionTierDesign;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$2, reason: invalid class name */
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
            WidgetGuildRoleSubscriptionTierDesign.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierDesign.access$configureUI(WidgetGuildRoleSubscriptionTierDesign.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$setupMemberColor$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ int $currentColor;

        public AnonymousClass2(int i) {
            this.$currentColor = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierDesign.access$launchColorPicker(WidgetGuildRoleSubscriptionTierDesign.this, this.$currentColor);
        }
    }

    public WidgetGuildRoleSubscriptionTierDesign() {
        super(R.layout.widget_guild_role_subscription_tier_design);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDesign3.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierDesign$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierDesign7.INSTANCE));
        this.hideHeader = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierDesign5(this));
        this.memberBadgeImageSelectedResult = new WidgetGuildRoleSubscriptionTierDesign6(this);
        this.defaultColor = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierDesign4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierDesign.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        return widgetGuildRoleSubscriptionTierDesign.getViewModel();
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, int i) {
        widgetGuildRoleSubscriptionTierDesign.launchColorPicker(i);
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
        int iIntValue = memberColor != null ? memberColor.intValue() : getDefaultColor();
        setupMemberColor(iIntValue);
        getBinding().g.updateImage(guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().i.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().h.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
    }

    private final WidgetGuildRoleSubscriptionTierDesignBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierDesignBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getDefaultColor() {
        return ((Number) this.defaultColor.getValue()).intValue();
    }

    private final boolean getHideHeader() {
        return ((Boolean) this.hideHeader.getValue()).booleanValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void launchColorPicker(@ColorInt int currentColor) {
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), R.string.guild_role_subscription_tier_design_member_color_label, currentColor);
        colorPickerDialogBuildColorPickerDialog.k = new WidgetGuildRoleSubscriptionTierDesign2(this);
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void setupMemberColor(@ColorInt int currentColor) {
        View view = getBinding().f2440b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.guildRoleSubscriptionTierAppearanceColor");
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_rectangle_4dp_radius);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(new PorterDuffColorFilter(currentColor, PorterDuff.Mode.SRC_ATOP));
        } else {
            drawable = null;
        }
        if (drawable == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        view.setBackground(drawable);
        getBinding().c.setOnClickListener(new AnonymousClass2(currentColor));
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscri…onTierAppearanceColorText");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.CHANNELS_CHAR);
        String strX = Util7.x(currentColor);
        Objects.requireNonNull(strX, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strX.substring(2);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        textView.setText(sb.toString());
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.memberBadgeImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.memberBadgeImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().g.configureUI(AnonymousClass1.INSTANCE, new AnonymousClass2());
        getViewModel().setDefaultMemberColor(getDefaultColor());
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierAppearanceTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        if (getHideHeader()) {
            getBinding().e.setPadding(0, DimenUtils.dpToPixels(16), 0, 0);
            return;
        }
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscri…ionTierAppearanceSubtitle");
        textView2.setPadding(0, 0, 0, 0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierDesign.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

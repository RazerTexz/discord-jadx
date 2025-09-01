package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.Tuples;
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
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010&\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDetails;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "onViewBoundOrOnResume", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", "binding", "", "isEditMode$delegate", "Lkotlin/Lazy;", "isEditMode", "()Z", "Lrx/functions/Action1;", "tierImageSelectedResult", "Lrx/functions/Action1;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_IS_EDIT_MODE = "INTENT_IS_EDIT_MODE";
    private static final String REQUEST_KEY_PRICE_TIER_PICKER = "REQUEST_KEY_PRICE_TIER_PICKER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: isEditMode$delegate, reason: from kotlin metadata */
    private final Lazy isEditMode;
    private final Action1<String> tierImageSelectedResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDetails$Companion;", "", "", "isEditMode", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDetails;", "newInstance", "(Z)Lcom/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDetails;", "", WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, "Ljava/lang/String;", WidgetGuildRoleSubscriptionTierDetails.REQUEST_KEY_PRICE_TIER_PICKER, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierDetails newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionTierDetails newInstance(boolean isEditMode) {
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = new WidgetGuildRoleSubscriptionTierDetails();
            widgetGuildRoleSubscriptionTierDetails.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, Boolean.valueOf(isEditMode))));
            return widgetGuildRoleSubscriptionTierDetails;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPriceTierPickerBottomSheet.INSTANCE.launch(WidgetGuildRoleSubscriptionTierDetails.this, WidgetGuildRoleSubscriptionTierDetails.REQUEST_KEY_PRICE_TIER_PICKER);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$isEditMode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            Bundle arguments = WidgetGuildRoleSubscriptionTierDetails.this.getArguments();
            if (arguments != null) {
                return arguments.getBoolean(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, false);
            }
            return false;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "priceTier", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails.this).updatePriceTier(i);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

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
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$3, reason: invalid class name */
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
            WidgetGuildRoleSubscriptionTierDetails.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails.this).updateTierName(str);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails.this).updateDescription(str);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = WidgetGuildRoleSubscriptionTierDetails.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetGuildRoleSubscriptionTierDetails.access$configureUI(widgetGuildRoleSubscriptionTierDetails, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierDetails() {
        super(R.layout.widget_guild_role_subscription_details);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDetails2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierDetails$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierDetails4.INSTANCE));
        this.tierImageSelectedResult = new WidgetGuildRoleSubscriptionTierDetails3(this);
        this.isEditMode = LazyJVM.lazy(new AnonymousClass2());
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierDetails.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        return widgetGuildRoleSubscriptionTierDetails.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createSubscriptionTierNameLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, guildRoleSubscriptionTier.getName());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.createSubscriptionTierDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout2, guildRoleSubscriptionTier.getDescription());
        getBinding().d.updateImage(guildRoleSubscriptionTier);
        if (guildRoleSubscriptionTier.getPriceTier() == null) {
            getBinding().g.setText(R.string.guild_role_subscription_tier_detail_price_placeholder);
        } else {
            TextView textView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierPrice");
            int iIntValue = guildRoleSubscriptionTier.getPriceTier().intValue();
            WidgetGuildRoleSubscriptionDetailsBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            textView.setText(PremiumUtils2.getFormattedPriceUsd(iIntValue, context));
        }
        Boolean boolIsPublished = guildRoleSubscriptionTier.isPublished();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics3.areEqual(boolIsPublished, bool)) {
            TextView textView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierPrice");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, R.drawable.ic_lock_white_a60_16dp, 0, 11, null);
        } else {
            getBinding().g.setOnClickListener(new AnonymousClass1());
        }
        TextView textView3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.createSubscriptionTierPrice");
        textView3.setSelected(guildRoleSubscriptionTier.getPriceTier() != null && (Intrinsics3.areEqual(guildRoleSubscriptionTier.isPublished(), bool) ^ true));
    }

    private final WidgetGuildRoleSubscriptionDetailsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionDetailsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final boolean isEditMode() {
        return ((Boolean) this.isEditMode.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.tierImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.tierImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetPriceTierPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_PRICE_TIER_PICKER, new AnonymousClass1());
        getBinding().d.configureUI(AnonymousClass2.INSTANCE, new AnonymousClass3());
        TextInputEditText textInputEditText = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.createSubscriptionTierName");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText, this, new AnonymousClass4());
        TextInputEditText textInputEditText2 = getBinding().f2433b;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.createSubscriptionTierDescription");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText2, this, new AnonymousClass5());
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierTitle");
        textView.setVisibility(isEditMode() ^ true ? 0 : 8);
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierSubtitle");
        textView2.setVisibility(isEditMode() ^ true ? 0 : 8);
        View view2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierDetailDivider");
        view2.setVisibility(isEditMode() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildRoleSubscriptionTierDetails.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

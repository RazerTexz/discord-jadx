package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004R\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\"R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R!\u0010/\u001a\u00060*j\u0002`+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010.R\u001f\u00104\u001a\u0004\u0018\u0001008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0016\u001a\u0004\b2\u00103R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefit;", "Lcom/discord/app/AppFragment;", "", "configureUIForChannelBenefit", "()V", "configureUIForIntangibleBenefit", "cancel", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "", "tierName$delegate", "Lkotlin/Lazy;", "getTierName", "()Ljava/lang/String;", "tierName", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "benefitType$delegate", "getBenefitType", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "benefitType", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel;", "viewModel", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", "binding", "", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "()J", "guildId", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "existingBenefit$delegate", "getExistingBenefit", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "existingBenefit", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "createChannelLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierBenefit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BENEFIT_TYPE = "INTENT_EXTRA_BENEFIT_TYPE";
    private static final String INTENT_EXTRA_EXISTING_BENEFIT = "INTENT_EXTRA_EXISTING_BENEFIT";
    private static final String INTENT_EXTRA_TIER_NAME = "INTENT_EXTRA_TIER_NAME";
    private static final int MAX_EMOJI_SIZE = 64;
    private static final String REQUEST_KEY_CHANNEL_PICKER = "REQUEST_KEY_CHANNEL_PICKER";
    private static final String RESULT_EXTRA_BENEFIT = "RESULT_EXTRA_BENEFIT";
    private static final String RESULT_EXTRA_EXISTING_BENEFIT = "RESULT_EXTRA_EXISTING_BENEFIT";

    /* renamed from: benefitType$delegate, reason: from kotlin metadata */
    private final Lazy benefitType;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> createChannelLauncher;

    /* renamed from: existingBenefit$delegate, reason: from kotlin metadata */
    private final Lazy existingBenefit;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: tierName$delegate, reason: from kotlin metadata */
    private final Lazy tierName;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$JO\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u001c\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001a¨\u0006%"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefit$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "benefitType", "", "tierName", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "benefit", "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;JLcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;Ljava/lang/String;Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function2;", "onBenefitUpdate", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function2;)Landroidx/activity/result/ActivityResultLauncher;", WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_BENEFIT_TYPE, "Ljava/lang/String;", WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_EXISTING_BENEFIT, WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_TIER_NAME, "", "MAX_EMOJI_SIZE", "I", WidgetGuildRoleSubscriptionTierBenefit.REQUEST_KEY_CHANNEL_PICKER, WidgetGuildRoleSubscriptionTierBenefit.RESULT_EXTRA_BENEFIT, WidgetGuildRoleSubscriptionTierBenefit.RESULT_EXTRA_EXISTING_BENEFIT, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, long j, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit, int i, Object obj) {
            companion.launch(context, activityResultLauncher, j, guildRoleSubscriptionBenefitType, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : benefit);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildRoleSubscriptionBenefitType benefitType, String tierName, Benefit benefit) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(benefitType, "benefitType");
            AppScreen2 appScreen2 = AppScreen2.g;
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_EXISTING_BENEFIT, benefit);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_BENEFIT_TYPE, benefitType);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_TIER_NAME, tierName);
            appScreen2.f(context, launcher, WidgetGuildRoleSubscriptionTierBenefit.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function2<? super Benefit, ? super Benefit, Unit> onBenefitUpdate) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onBenefitUpdate, "onBenefitUpdate");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetGuildRoleSubscriptionTierBenefit2(onBenefitUpdate));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionBenefitType.CHANNEL.ordinal()] = 1;
            iArr[GuildRoleSubscriptionBenefitType.INTANGIBLE.ordinal()] = 2;
            iArr[GuildRoleSubscriptionBenefitType.UNKNOWN.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel.ViewState $viewState;

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02911 extends Lambda implements Function0<Unit> {
            public C02911() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        public AnonymousClass1(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPickerBottomSheet.Companion companion = WidgetChannelPickerBottomSheet.INSTANCE;
            WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit = WidgetGuildRoleSubscriptionTierBenefit.this;
            companion.launch(widgetGuildRoleSubscriptionTierBenefit, WidgetGuildRoleSubscriptionTierBenefit.REQUEST_KEY_CHANNEL_PICKER, WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(widgetGuildRoleSubscriptionTierBenefit), this.$viewState.getChannelId(), new C02911(), true);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "channelName", "", "channelIconResId", "", "invoke", "(JLjava/lang/String;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Long, String, Integer, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
            invoke(l.longValue(), str, num.intValue());
            return Unit.a;
        }

        public final void invoke(long j, String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "channelName");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateChannel(j, str, Integer.valueOf(i));
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2, reason: invalid class name */
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
            WidgetCreateChannel.Companion.launch$default(WidgetCreateChannel.INSTANCE, WidgetGuildRoleSubscriptionTierBenefit.this.requireContext(), WidgetGuildRoleSubscriptionTierBenefit.access$getCreateChannelLauncher$p(WidgetGuildRoleSubscriptionTierBenefit.this), WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit.this), 0, null, true, true, true, true, 24, null);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForIntangibleBenefit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateName(editable.toString());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).submitResult();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionTierBenefit.access$cancel(WidgetGuildRoleSubscriptionTierBenefit.this);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "onEmojiPicked", "(Lcom/discord/models/domain/emoji/Emoji;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 implements EmojiPickerListener {
            public AnonymousClass1() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateEmoji(emoji);
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2, reason: invalid class name */
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
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentManager parentFragmentManager = WidgetGuildRoleSubscriptionTierBenefit.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new AnonymousClass1(), new EmojiPickerContextType.Guild(WidgetGuildRoleSubscriptionTierBenefit.access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit.this)), new AnonymousClass2());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit.this).updateDescription(editable.toString());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity fragmentActivityRequireActivity = WidgetGuildRoleSubscriptionTierBenefit.this.requireActivity();
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.RESULT_EXTRA_EXISTING_BENEFIT, WidgetGuildRoleSubscriptionTierBenefit.access$getExistingBenefit$p(WidgetGuildRoleSubscriptionTierBenefit.this));
            fragmentActivityRequireActivity.setResult(-1, intent);
            AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
            fragmentActivityRequireActivity.finish();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$configureUI(WidgetGuildRoleSubscriptionTierBenefit.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;", "it", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionTierBenefit.access$handleEvent(WidgetGuildRoleSubscriptionTierBenefit.this, event);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefit() {
        super(R.layout.widget_guild_role_subscription_tier_benefit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefit4.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit7(this));
        this.existingBenefit = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit6(this));
        this.benefitType = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit3(this));
        this.tierName = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit8(this));
        WidgetGuildRoleSubscriptionTierBenefit9 widgetGuildRoleSubscriptionTierBenefit9 = new WidgetGuildRoleSubscriptionTierBenefit9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitViewModel.class), new WidgetGuildRoleSubscriptionTierBenefit$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionTierBenefit9));
        this.createChannelLauncher = WidgetCreateChannel.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefit5(this));
    }

    public static final /* synthetic */ void access$cancel(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        widgetGuildRoleSubscriptionTierBenefit.cancel();
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierBenefit.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionBenefitType access$getBenefitType$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getBenefitType();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCreateChannelLauncher$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.createChannelLauncher;
    }

    public static final /* synthetic */ Benefit access$getExistingBenefit$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getExistingBenefit();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getGuildId();
    }

    public static final /* synthetic */ String access$getTierName$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getTierName();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel.Event event) {
        widgetGuildRoleSubscriptionTierBenefit.handleEvent(event);
    }

    private final void cancel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        fragmentActivityRequireActivity.finish();
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
        String string;
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitSubtitle");
        textView.setText(viewState.getTierName());
        Emoji emoji = viewState.getEmoji();
        String imageUri = emoji != null ? emoji.getImageUri(false, _Ranges.coerceAtMost(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_create_benefit_emoji_size)), 64), requireContext()) : null;
        SimpleDraweeView simpleDraweeView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierBenefitEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        if (emoji == null || (string = emoji.getFirstName()) == null) {
            string = getString(R.string.guild_role_subscription_tier_benefits_emoji_placeholder);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.guild…nefits_emoji_placeholder)");
        }
        TextView textView2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitEmojiName");
        textView2.setText(string);
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String name = viewState.getName();
        if (!(name == null || StringsJVM.isBlank(name))) {
            TextView textView3 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierBenefitName");
            textView3.setText(viewState.getName());
            TextInputLayout textInputLayout2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
            ViewExtensions.setTextIfDifferent(textInputLayout2, viewState.getName());
        }
        TextView textView4 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitName");
        Integer leadingNameIconResId = viewState.getLeadingNameIconResId();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView4, leadingNameIconResId != null ? leadingNameIconResId.intValue() : 0, 0, R.drawable.icon_carrot, 0, 10, null);
        if (getBenefitType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            getBinding().j.setOnClickListener(new AnonymousClass1(viewState));
        }
        MaterialButton materialButton = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitSave");
        materialButton.setEnabled(viewState.getCanSubmitResult());
    }

    private final void configureUIForChannelBenefit() {
        WidgetChannelPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_PICKER, new AnonymousClass1(), new AnonymousClass2());
        TextView textView = getBinding().f2438b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(0);
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView4.setText(getString(R.string.guild_role_subscription_tier_exclusive_channel_title));
        TextInputEditText textInputEditText = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(R.string.guild_role_subscription_channel_benefit_description_placeholder));
    }

    private final void configureUIForIntangibleBenefit() {
        TextView textView = getBinding().f2438b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(8);
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(8);
        TextView textView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(8);
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        textInputLayout.setVisibility(0);
        TextView textView4 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscri…ntangibleBenefitNameLabel");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass1());
        TextView textView5 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView5.setText(getString(R.string.guild_role_subscription_tier_additional_benefit_title));
        TextInputEditText textInputEditText = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(R.string.guild_role_subscription_intangible_benefit_description_placeholder));
    }

    private final GuildRoleSubscriptionBenefitType getBenefitType() {
        return (GuildRoleSubscriptionBenefitType) this.benefitType.getValue();
    }

    private final WidgetGuildRoleSubscriptionTierBenefitBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierBenefitBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Benefit getExistingBenefit() {
        return (Benefit) this.existingBenefit.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final String getTierName() {
        return (String) this.tierName.getValue();
    }

    private final GuildRoleSubscriptionTierBenefitViewModel getViewModel() {
        return (GuildRoleSubscriptionTierBenefitViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
        if (event instanceof GuildRoleSubscriptionTierBenefitViewModel.Event.SendResult) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_EXISTING_BENEFIT, getExistingBenefit());
            intent.putExtra(RESULT_EXTRA_BENEFIT, ((GuildRoleSubscriptionTierBenefitViewModel.Event.SendResult) event).getBenefit());
            fragmentActivityRequireActivity.setResult(-1, intent);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            fragmentActivityRequireActivity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int iOrdinal = getBenefitType().ordinal();
        if (iOrdinal == 0) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Unknown benefit type: ");
            sbU.append(getBenefitType());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            cancel();
        } else if (iOrdinal == 1) {
            configureUIForChannelBenefit();
        } else if (iOrdinal == 2) {
            configureUIForIntangibleBenefit();
        }
        getBinding().l.setOnClickListener(new AnonymousClass1());
        getBinding().e.setOnClickListener(new AnonymousClass2());
        getBinding().m.setOnClickListener(new AnonymousClass3());
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass4());
        getBinding().k.setOnClickListener(new AnonymousClass5());
        MaterialButton materialButton = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitRemove");
        materialButton.setVisibility(getExistingBenefit() != null ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}

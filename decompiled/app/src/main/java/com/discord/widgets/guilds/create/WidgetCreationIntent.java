package com.discord.widgets.guilds.create;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.google.android.material.card.MaterialCardView;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetCreationIntent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u0011\u0012\b\b\u0003\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\u00020\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetCreationIntent;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "container", "Landroid/widget/TextView;", "textView", "", "configureFriendsButton", "(Landroid/view/View;Landroid/widget/TextView;)V", "configureCommunityButton", "", "isCommunity", "onSelectionPressed", "(Ljava/lang/Boolean;)V", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/widgets/guilds/create/CreationIntentArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/guilds/create/CreationIntentArgs;", "args", "Lcom/discord/databinding/WidgetCreationIntentBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCreationIntentBinding;", "binding", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "", "contentResId", "<init>", "(I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreationIntent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCreationIntent.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreationIntentBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_FRIENDS_FIRST;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetCreationIntent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetCreationIntent$Companion;", "", "Lcom/discord/app/AppFragment;", "fragment", "Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "trigger", "Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "createGuildOptions", "", "show", "(Lcom/discord/app/AppFragment;Lcom/discord/widgets/guilds/create/CreateGuildTrigger;Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;)V", "", "IS_FRIENDS_FIRST", "Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(AppFragment fragment, CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(trigger, "trigger");
            Intrinsics3.checkNotNullParameter(createGuildOptions, "createGuildOptions");
            AppScreen2.g(AppScreen2.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetCreationIntent.class, 0, true, null, new WidgetCreationIntent2(trigger, createGuildOptions), 40);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreationIntent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$configureCommunityButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreationIntent.access$onSelectionPressed(WidgetCreationIntent.this, Boolean.TRUE);
        }
    }

    /* compiled from: WidgetCreationIntent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$configureFriendsButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreationIntent.access$onSelectionPressed(WidgetCreationIntent.this, Boolean.FALSE);
        }
    }

    /* compiled from: WidgetCreationIntent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetCreationIntent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02921 extends Lambda implements Function1<View, Unit> {
            public C02921() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetCreationIntent.access$onSelectionPressed(WidgetCreationIntent.this, null);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onSkip", new C02921());
        }
    }

    static {
        IS_FRIENDS_FIRST = Math.random() < 0.5d;
    }

    public WidgetCreationIntent() {
        this(0, 1, null);
    }

    public WidgetCreationIntent(@LayoutRes int i) {
        super(i);
        this.args = LazyJVM.lazy(new WidgetCreationIntent$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreationIntent3.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetCreationIntent4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$onSelectionPressed(WidgetCreationIntent widgetCreationIntent, Boolean bool) {
        widgetCreationIntent.onSelectionPressed(bool);
    }

    private final void configureCommunityButton(View container, TextView textView) {
        textView.setText(getString(R.string.creation_intent_option_community));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_guild_template_creator), (Drawable) null, ContextCompat.getDrawable(requireContext(), R.drawable.icon_carrot), (Drawable) null);
        container.setOnClickListener(new AnonymousClass1());
    }

    private final void configureFriendsButton(View container, TextView textView) {
        textView.setText(getString(R.string.creation_intent_option_friends));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_guild_template_community), (Drawable) null, ContextCompat.getDrawable(requireContext(), R.drawable.icon_carrot), (Drawable) null);
        container.setOnClickListener(new AnonymousClass1());
    }

    private final WidgetCreationIntentBinding getBinding() {
        return (WidgetCreationIntentBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onSelectionPressed(Boolean isCommunity) {
        AnalyticsTracker.INSTANCE.guildCreationIntentSelected(isCommunity);
        if (getArgs().getTrigger() == CreateGuildTrigger.NUF) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationTransition$app_productionGoogleRelease(GuildTemplateAnalytics.STEP_CREATION_INTENT, "Guild Create");
        } else {
            AnalyticsTracker.openModal$default("Create Guild Step 2", getArgs().getCreateGuildOptions().getAnalyticsLocation(), null, 4, null);
        }
        WidgetGuildCreate.INSTANCE.showFragment(this, getArgs().getCreateGuildOptions());
    }

    public final WidgetCreationIntent2 getArgs() {
        return (WidgetCreationIntent2) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (IS_FRIENDS_FIRST) {
            MaterialCardView materialCardView = getBinding().f2360b;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.creationIntentFirstOption");
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.creationIntentFirstOptionText");
            configureFriendsButton(materialCardView, textView);
            MaterialCardView materialCardView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.creationIntentSecondOption");
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.creationIntentSecondOptionText");
            configureCommunityButton(materialCardView2, textView2);
        } else {
            MaterialCardView materialCardView3 = getBinding().f2360b;
            Intrinsics3.checkNotNullExpressionValue(materialCardView3, "binding.creationIntentFirstOption");
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.creationIntentFirstOptionText");
            configureCommunityButton(materialCardView3, textView3);
            MaterialCardView materialCardView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView4, "binding.creationIntentSecondOption");
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.creationIntentSecondOptionText");
            configureFriendsButton(materialCardView4, textView4);
        }
        LinkifiedTextView linkifiedTextView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.creationIntentSkipText");
        FormatUtils.m(linkifiedTextView, R.string.creation_intent_skip, new Object[0], new AnonymousClass1());
    }

    public /* synthetic */ WidgetCreationIntent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_creation_intent : i);
    }
}

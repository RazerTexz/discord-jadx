package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerBoostStatusBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostViewModel;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetGuildBoost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\bB\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0011\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u001dR\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00105\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R!\u0010\r\u001a\u00060\u000bj\u0002`\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u00108R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u0002090)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoost;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", "", "guildName", "configureToolbar", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "premiumTier", "subscriptionCount", "configureProgressBar", "(JII)V", "configureViewpager", "(II)V", "currentSelected", "configureLevelBubbles", "(I)V", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", "fetchData", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel;", "viewModel", "", "Landroid/widget/TextView;", "levelText", "Ljava/util/List;", "", "wasPagerPageSet", "Z", "Lcom/discord/databinding/WidgetServerBoostStatusBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerBoostStatusBinding;", "binding", "guildId$delegate", "getGuildId", "()J", "Landroid/widget/ImageView;", "levelBackgrounds", "Lcom/discord/widgets/servers/guildboost/WidgetGuildBoost$PerksPagerAdapter;", "pagerAdapter", "Lcom/discord/widgets/servers/guildboost/WidgetGuildBoost$PerksPagerAdapter;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "choosePlanLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "Companion", "PerksPagerAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostStatusBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_LOADED = 2;
    private static final int VIEW_INDEX_LOADING = 0;
    private static final int VIEW_INDEX_LOAD_FAILED = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> choosePlanLauncher;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private List<? extends ImageView> levelBackgrounds;
    private List<? extends TextView> levelText;
    private PerksPagerAdapter pagerAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private boolean wasPagerPageSet;

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoost$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, "Ljava/lang/String;", "", "VIEW_INDEX_LOADED", "I", "VIEW_INDEX_LOADING", "VIEW_INDEX_LOAD_FAILED", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoost.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetGuildBoost.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e¢\u0006\u0004\b(\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u001cR&\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u001c¨\u0006)"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoost$PerksPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/ViewGroup;", "container", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Landroid/view/View;", "instantiateItem", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "view", "", "any", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "getCount", "()I", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "configureViews", "(Landroidx/viewpager/widget/ViewPager;)V", "subscriptionCount", "I", "getSubscriptionCount", "setSubscriptionCount", "(I)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "getGuildId", "()J", "setGuildId", "(J)V", "premiumTier", "getPremiumTier", "setPremiumTier", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PerksPagerAdapter extends PagerAdapter {
        private long guildId;
        private int premiumTier;
        private int subscriptionCount;

        public PerksPagerAdapter(long j) {
            this.guildId = j;
        }

        public final void configureViews(ViewPager viewPager) {
            Intrinsics3.checkNotNullParameter(viewPager, "viewPager");
            int childCount = viewPager.getChildCount();
            if (childCount <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewPager.getChildAt(i);
                Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                Object tag = childAt.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
                ((GuildBoostPerkView) childAt).configure(((Integer) tag).intValue(), this.premiumTier, this.guildId);
                if (i2 >= childCount) {
                    return;
                } else {
                    i = i2;
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object view) {
            Intrinsics3.checkNotNullParameter(container, "container");
            Intrinsics3.checkNotNullParameter(view, "view");
            container.removeView((View) view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final int getPremiumTier() {
            return this.premiumTier;
        }

        public final int getSubscriptionCount() {
            return this.subscriptionCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public /* bridge */ /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
            return instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object any) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(any, "any");
            return Intrinsics3.areEqual(view, any);
        }

        public final void setGuildId(long j) {
            this.guildId = j;
        }

        public final void setPremiumTier(int i) {
            this.premiumTier = i;
        }

        public final void setSubscriptionCount(int i) {
            this.subscriptionCount = i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup container, int position) {
            Intrinsics3.checkNotNullParameter(container, "container");
            int i = position + 1;
            Context context = container.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "container.context");
            GuildBoostPerkView guildBoostPerkView = new GuildBoostPerkView(context, null, 0, 6, null);
            guildBoostPerkView.configure(i, this.premiumTier, this.guildId);
            guildBoostPerkView.setTag(Integer.valueOf(i));
            container.addView(guildBoostPerkView);
            return guildBoostPerkView;
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).retryClicked();
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$configureUI$2, reason: invalid class name */
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
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass1() {
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
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/discord/widgets/servers/guildboost/WidgetGuildBoost$onViewBound$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "state", "", "onPageScrollStateChanged", "(I)V", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ViewPager.OnPageChangeListener {
        public AnonymousClass1() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            WidgetGuildBoost.access$configureLevelBubbles(WidgetGuildBoost.this, position + 1);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "context", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_premium_guild) {
                return;
            }
            WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        /* compiled from: WidgetGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsGuildBoost.Companion companion = WidgetSettingsGuildBoost.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.launch(context);
            }
        }

        public AnonymousClass3() {
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
            renderContext.b("learnMore", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
            }
        }

        public AnonymousClass4() {
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
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetGuildBoost.this.requireContext(), R.color.status_green_600));
            renderContext.b("onLearnMore", AnonymousClass1.INSTANCE);
            renderContext.a("protipHook", AnonymousClass2.INSTANCE);
        }

        /* compiled from: WidgetGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$4$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new StyleSpan(1));
                hook.styles.add(new ForegroundColorSpan(-65536));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).subscribeClicked(Traits.Location.Section.HEADER);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.access$getViewModel$p(WidgetGuildBoost.this).subscribeClicked(Traits.Location.Section.FOOTER);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildBoostViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.ViewState viewState) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoost.access$configureUI((WidgetGuildBoost) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GuildBoostViewModel.Event, Unit> {
        public AnonymousClass2(WidgetGuildBoost widgetGuildBoost) {
            super(1, widgetGuildBoost, WidgetGuildBoost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildBoost.access$handleEvent((WidgetGuildBoost) this.receiver, event);
        }
    }

    public WidgetGuildBoost() {
        super(R.layout.widget_server_boost_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoost2.INSTANCE, null, 2, null);
        WidgetGuildBoost5 widgetGuildBoost5 = new WidgetGuildBoost5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostViewModel.class), new WidgetGuildBoost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoost5));
        this.choosePlanLauncher = WidgetChoosePlan.INSTANCE.registerForResult(this, new WidgetGuildBoost3(this));
        this.guildId = LazyJVM.lazy(new WidgetGuildBoost4(this));
    }

    public static final /* synthetic */ void access$configureLevelBubbles(WidgetGuildBoost widgetGuildBoost, int i) {
        widgetGuildBoost.configureLevelBubbles(i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoost widgetGuildBoost, GuildBoostViewModel.ViewState viewState) throws Resources.NotFoundException {
        widgetGuildBoost.configureUI(viewState);
    }

    public static final /* synthetic */ void access$fetchData(WidgetGuildBoost widgetGuildBoost) {
        widgetGuildBoost.fetchData();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildBoost widgetGuildBoost) {
        return widgetGuildBoost.getGuildId();
    }

    public static final /* synthetic */ GuildBoostViewModel access$getViewModel$p(WidgetGuildBoost widgetGuildBoost) {
        return widgetGuildBoost.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildBoost widgetGuildBoost, GuildBoostViewModel.Event event) {
        widgetGuildBoost.handleEvent(event);
    }

    private final void configureLevelBubbles(int currentSelected) {
        int i = 0;
        while (i <= 3) {
            List<? extends ImageView> list = this.levelBackgrounds;
            if (list == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("levelBackgrounds");
            }
            ImageView imageView = list.get(i);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = DimenUtils.dpToPixels(currentSelected == i ? 32 : 20);
            layoutParams.width = DimenUtils.dpToPixels(currentSelected != i ? 20 : 32);
            imageView.setLayoutParams(layoutParams);
            List<? extends TextView> list2 = this.levelText;
            if (list2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("levelText");
            }
            TextView textView = list2.get(i);
            if (textView != null) {
                textView.setTextColor(currentSelected == i ? ColorCompat.getThemedColor(textView, R.attr.primary_000) : ColorCompat.getThemedColor(textView, R.attr.primary_400));
            }
            i++;
        }
    }

    private final void configureProgressBar(long guildId, int premiumTier, int subscriptionCount) {
        ProgressBar progressBar = getBinding().l.f222b;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.progress.boostBarProgressBar");
        progressBar.setProgress(GuildBoostUtils.calculateTotalProgress$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, subscriptionCount, null, null, 24, null));
        ProgressBar progressBar2 = getBinding().l.f222b;
        Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.progress.boostBarProgressBar");
        progressBar2.setContentDescription(getString(premiumTier != 0 ? premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : R.string.premium_guild_tier_3 : R.string.premium_guild_tier_2 : R.string.premium_guild_tier_1 : R.string.premium_guild_header_badge_no_tier));
        ImageView imageView = getBinding().l.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        imageView.setEnabled(subscriptionCount > 0);
        ImageView imageView2 = getBinding().l.d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        imageView2.setEnabled(premiumTier >= 1);
        ImageView imageView3 = getBinding().l.f;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        imageView3.setEnabled(premiumTier >= 2);
        ImageView imageView4 = getBinding().l.h;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        imageView4.setEnabled(premiumTier >= 3);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostViewModel.ViewState viewState) throws Resources.NotFoundException {
        if (viewState instanceof GuildBoostViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2535b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.boostStatusFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Failure) {
            AppViewFlipper appViewFlipper2 = getBinding().f2535b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.boostStatusFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().h.setOnClickListener(new AnonymousClass1());
            return;
        }
        if (viewState instanceof GuildBoostViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper3 = getBinding().f2535b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.boostStatusFlipper");
            appViewFlipper3.setDisplayedChild(2);
        }
        GuildBoostViewModel.ViewState.Loaded loaded = (GuildBoostViewModel.ViewState.Loaded) viewState;
        int premiumTier = loaded.getGuild().getPremiumTier();
        int premiumSubscriptionCount = loaded.getGuild().getPremiumSubscriptionCount();
        configureToolbar(loaded.getGuild().getName());
        configureProgressBar(loaded.getGuild().getId(), premiumTier, premiumSubscriptionCount);
        configureViewpager(premiumTier, premiumSubscriptionCount);
        getBinding().e.a(loaded.getMeUser().getPremiumTier(), new AnonymousClass2());
        getBinding().f.a(loaded.getMeUser().getPremiumTier(), false);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostStatusNumBoosts");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
    }

    private final void configureViewpager(int premiumTier, int subscriptionCount) throws Resources.NotFoundException {
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter.setPremiumTier(premiumTier);
        PerksPagerAdapter perksPagerAdapter2 = this.pagerAdapter;
        if (perksPagerAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        perksPagerAdapter2.setSubscriptionCount(subscriptionCount);
        PerksPagerAdapter perksPagerAdapter3 = this.pagerAdapter;
        if (perksPagerAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        SimplePager simplePager = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        perksPagerAdapter3.configureViews(simplePager);
        if (this.wasPagerPageSet) {
            return;
        }
        getBinding().k.setCurrentItem(Math.max(0, premiumTier - 1), false);
        configureLevelBubbles(Math.max(1, premiumTier));
        this.wasPagerPageSet = true;
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final void fetchData() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getGuildBoosts().fetchUserGuildBoostState();
        companion.getSubscriptions().fetchSubscriptions();
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }

    private final WidgetServerBoostStatusBinding getBinding() {
        return (WidgetServerBoostStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildBoostViewModel getViewModel() {
        return (GuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildBoostViewModel.Event event) {
        if (event instanceof GuildBoostViewModel.Event.LaunchSubscriptionConfirmation) {
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.PREMIUM_GUILD_SUBSCRIPTION_CONFIRMATION, new Traits.Location(Traits.Location.Page.BOOST_MARKETING, Traits.Location.Section.HEADER, Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null));
            GuildBoostViewModel.Event.LaunchSubscriptionConfirmation launchSubscriptionConfirmation = (GuildBoostViewModel.Event.LaunchSubscriptionConfirmation) event;
            WidgetGuildBoostConfirmation.INSTANCE.create(requireContext(), launchSubscriptionConfirmation.getGuildId(), launchSubscriptionConfirmation.getSlotId());
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.LaunchPurchaseSubscription) {
            GuildBoostViewModel.Event.LaunchPurchaseSubscription launchPurchaseSubscription = (GuildBoostViewModel.Event.LaunchPurchaseSubscription) event;
            WidgetChoosePlan.Companion.launch$default(WidgetChoosePlan.INSTANCE, requireContext(), this.choosePlanLauncher, WidgetChoosePlan.ViewType.BUY_PREMIUM_GUILD, launchPurchaseSubscription.getOldSkuName(), new Traits.Location(Traits.Location.Page.BOOST_MARKETING, launchPurchaseSubscription.getSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), null, 32, null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.ShowDesktopAlertDialog) {
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.ANDROID_CANNOT_MANAGE_SUBSCRIPTION, new Traits.Location(Traits.Location.Page.BOOST_MARKETING, Traits.Location.Section.HEADER, Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null));
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, getString(R.string.premium_guild_subscription_out_of_slots_title), FormatUtils.k(this, R.string.premium_guild_subscription_out_of_slots_purchase_on_desktop, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, null, 4), getString(R.string.premium_guild_subscription_header_subscribe_tooltip_close), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            return;
        }
        if (event instanceof GuildBoostViewModel.Event.UnacknowledgedPurchase) {
            AppToast.i(this, R.string.billing_error_purchase, 0, 4);
            GooglePlayBillingManager.INSTANCE.queryPurchases();
        } else if (event instanceof GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) {
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog = (GuildBoostViewModel.Event.ShowBlockedPlanSwitchAlertDialog) event;
            String string = getString(showBlockedPlanSwitchAlertDialog.getHeaderStringRes());
            String string2 = getString(showBlockedPlanSwitchAlertDialog.getBodyStringRes());
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(event.bodyStringRes)");
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, string, string2, getString(R.string.billing_manage_subscription), getString(R.string.cancel), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.pagerAdapter = new PerksPagerAdapter(getGuildId());
        getBinding().k.setWrapHeight(true);
        SimplePager simplePager = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.boostStatusViewpager");
        PerksPagerAdapter perksPagerAdapter = this.pagerAdapter;
        if (perksPagerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        simplePager.setAdapter(perksPagerAdapter);
        getBinding().k.addOnPageChangeListener(new AnonymousClass1());
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_premium_guild, AnonymousClass2.INSTANCE, null, 4, null);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.boostStatusLearnMore");
        FormatUtils.m(linkifiedTextView, R.string.premium_guild_perks_modal_blurb_mobile_learn_more, new Object[]{"learnMode"}, AnonymousClass3.INSTANCE);
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_perks_modal_protip_mobile_numFreeGuildSubscriptions, 2, 2);
        LinkifiedTextView linkifiedTextView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.boostStatusProtip");
        FormatUtils.m(linkifiedTextView2, R.string.premium_guild_perks_modal_protip, new Object[]{i18nPluralString}, new AnonymousClass4());
        ImageView imageView = getBinding().l.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progress.boostBarTier0Iv");
        ImageView imageView2 = getBinding().l.d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progress.boostBarTier1Iv");
        ImageView imageView3 = getBinding().l.f;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progress.boostBarTier2Iv");
        ImageView imageView4 = getBinding().l.h;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progress.boostBarTier3Iv");
        this.levelBackgrounds = Collections2.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4});
        this.levelText = Collections2.listOf((Object[]) new TextView[]{null, getBinding().l.e, getBinding().l.g, getBinding().l.i});
        getBinding().i.setOnClickListener(new AnonymousClass5());
        getBinding().j.setOnClickListener(new AnonymousClass6());
        fetchData();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        AppActivity appActivity;
        super.onViewBoundOrOnResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable<GuildBoostViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildBoost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}

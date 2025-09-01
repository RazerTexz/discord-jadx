package com.discord.widgets.home;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import b.a.d.AppHelpDesk;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppComponent;
import com.discord.databinding.WidgetHomePanelCenterNsfwBinding;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetHomePanelNsfw.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,JG\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010Je\u0010\u0017\u001a\u00020\n2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/discord/widgets/home/WidgetHomePanelNsfw;", "", "", "isChannelNsfw", "isNsfwUnconsented", "Lcom/discord/api/user/NsfwAllowance;", "nsfwAllowed", "Landroid/view/ViewStub;", "stub", "Lkotlin/Function1;", "", "onToggleNsfw", "toggleContainerVisibility", "(ZZLcom/discord/api/user/NsfwAllowance;Landroid/view/ViewStub;Lkotlin/jvm/functions/Function1;)V", "isHidden", "setContainerViewHidden", "(ZLkotlin/jvm/functions/Function1;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "viewStub", "Lkotlin/Function0;", "onDenyNsfw", "configureUI", "(JZZLcom/discord/api/user/NsfwAllowance;Landroid/view/ViewStub;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroidx/core/view/WindowInsetsCompat;", "insets", "dispatchApplyWindowInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "stubInflated", "Z", "Lcom/discord/databinding/WidgetHomePanelCenterNsfwBinding;", "binding", "Lcom/discord/databinding/WidgetHomePanelCenterNsfwBinding;", "Lcom/discord/stores/StoreGuildsNsfw;", "guildsNsfwStore", "Lcom/discord/stores/StoreGuildsNsfw;", "Lrx/Subscription;", "hidePanelSubscription", "Lrx/Subscription;", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppComponent;", "<init>", "(Lcom/discord/app/AppComponent;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHomePanelNsfw {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long HIDE_DELAY_MILLIS = 500;
    private final AppComponent appComponent;
    private WidgetHomePanelCenterNsfwBinding binding;
    private final StoreGuildsNsfw guildsNsfwStore;
    private Subscription hidePanelSubscription;
    private boolean stubInflated;

    /* compiled from: WidgetHomePanelNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/home/WidgetHomePanelNsfw$Companion;", "", "", "HIDE_DELAY_MILLIS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHomePanelNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Function0 $onDenyNsfw;

        public AnonymousClass1(long j, Function0 function0) {
            this.$guildId = j;
            this.$onDenyNsfw = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHomePanelNsfw.access$getGuildsNsfwStore$p(WidgetHomePanelNsfw.this).deny(this.$guildId);
            Function0 function0 = this.$onDenyNsfw;
            if (function0 != null) {
            }
        }
    }

    /* compiled from: WidgetHomePanelNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Function1 $onToggleNsfw;

        public AnonymousClass2(long j, Function1 function1) {
            this.$guildId = j;
            this.$onToggleNsfw = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHomePanelNsfw.access$getGuildsNsfwStore$p(WidgetHomePanelNsfw.this).allow(this.$guildId);
            WidgetHomePanelNsfw.access$setContainerViewHidden(WidgetHomePanelNsfw.this, true, this.$onToggleNsfw);
        }
    }

    /* compiled from: WidgetHomePanelNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetHomePanelNsfw.access$setHidePanelSubscription$p(WidgetHomePanelNsfw.this, subscription);
        }
    }

    /* compiled from: WidgetHomePanelNsfw.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Function1 $onToggleNsfw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1) {
            super(1);
            this.$onToggleNsfw = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetHomePanelNsfw.access$setContainerViewHidden(WidgetHomePanelNsfw.this, true, this.$onToggleNsfw);
        }
    }

    public WidgetHomePanelNsfw(AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.appComponent = appComponent;
        this.guildsNsfwStore = StoreStream.INSTANCE.getGuildsNsfw();
    }

    public static final /* synthetic */ StoreGuildsNsfw access$getGuildsNsfwStore$p(WidgetHomePanelNsfw widgetHomePanelNsfw) {
        return widgetHomePanelNsfw.guildsNsfwStore;
    }

    public static final /* synthetic */ Subscription access$getHidePanelSubscription$p(WidgetHomePanelNsfw widgetHomePanelNsfw) {
        return widgetHomePanelNsfw.hidePanelSubscription;
    }

    public static final /* synthetic */ void access$setContainerViewHidden(WidgetHomePanelNsfw widgetHomePanelNsfw, boolean z2, Function1 function1) {
        widgetHomePanelNsfw.setContainerViewHidden(z2, function1);
    }

    public static final /* synthetic */ void access$setHidePanelSubscription$p(WidgetHomePanelNsfw widgetHomePanelNsfw, Subscription subscription) {
        widgetHomePanelNsfw.hidePanelSubscription = subscription;
    }

    public static /* synthetic */ void configureUI$default(WidgetHomePanelNsfw widgetHomePanelNsfw, long j, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, ViewStub viewStub, Function1 function1, Function0 function0, int i, Object obj) {
        widgetHomePanelNsfw.configureUI(j, z2, z3, nsfwAllowance, viewStub, function1, (i & 64) != 0 ? null : function0);
    }

    private final void setContainerViewHidden(boolean isHidden, Function1<? super Boolean, Unit> onToggleNsfw) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if ((widgetHomePanelCenterNsfwBinding == null || (linearLayout4 = widgetHomePanelCenterNsfwBinding.a) == null || linearLayout4.getVisibility() != 8) && isHidden) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (linearLayout = widgetHomePanelCenterNsfwBinding2.a) != null) {
                linearLayout.setVisibility(8);
            }
            onToggleNsfw.invoke(Boolean.FALSE);
            return;
        }
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
        if ((widgetHomePanelCenterNsfwBinding3 == null || (linearLayout3 = widgetHomePanelCenterNsfwBinding3.a) == null || linearLayout3.getVisibility() != 0) && !isHidden) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (linearLayout2 = widgetHomePanelCenterNsfwBinding4.a) != null) {
                linearLayout2.setVisibility(0);
            }
            onToggleNsfw.invoke(Boolean.TRUE);
        }
    }

    private final void toggleContainerVisibility(boolean isChannelNsfw, boolean isNsfwUnconsented, NsfwAllowance nsfwAllowed, ViewStub stub, Function1<? super Boolean, Unit> onToggleNsfw) {
        LinkifiedTextView linkifiedTextView;
        LinkifiedTextView linkifiedTextView2;
        TextView textView;
        MaterialButton materialButton;
        ImageView imageView;
        MaterialButton materialButton2;
        View viewInflate;
        boolean z2 = nsfwAllowed == NsfwAllowance.DISALLOWED;
        if (!isChannelNsfw || (!isNsfwUnconsented && !z2)) {
            Observable<Long> observableD0 = Observable.d0(HIDE_DELAY_MILLIS, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(HIDE_DE…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this.appComponent, null, 2, null), WidgetHomePanelNsfw.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(onToggleNsfw), 58, (Object) null);
            return;
        }
        if (!this.stubInflated && stub != null && (viewInflate = stub.inflate()) != null) {
            this.stubInflated = true;
            int i = R.id.home_panel_center_nsfw_anchor_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.home_panel_center_nsfw_anchor_wrap);
            if (linearLayout != null) {
                i = R.id.home_panel_center_nsfw_art;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.home_panel_center_nsfw_art);
                if (imageView2 != null) {
                    i = R.id.home_panel_center_nsfw_confirm;
                    MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.home_panel_center_nsfw_confirm);
                    if (materialButton3 != null) {
                        i = R.id.home_panel_center_nsfw_deny;
                        MaterialButton materialButton4 = (MaterialButton) viewInflate.findViewById(R.id.home_panel_center_nsfw_deny);
                        if (materialButton4 != null) {
                            i = R.id.home_panel_center_nsfw_description;
                            LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewInflate.findViewById(R.id.home_panel_center_nsfw_description);
                            if (linkifiedTextView3 != null) {
                                i = R.id.home_panel_center_nsfw_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.home_panel_center_nsfw_title);
                                if (textView2 != null) {
                                    this.binding = new WidgetHomePanelCenterNsfwBinding((LinearLayout) viewInflate, linearLayout, imageView2, materialButton3, materialButton4, linkifiedTextView3, textView2);
                                    ViewCompat.setOnApplyWindowInsetsListener(viewInflate, WidgetHomePanelNsfw2.INSTANCE);
                                    viewInflate.requestApplyInsets();
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (z2) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
            if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.c) != null) {
                ViewKt.setVisible(materialButton2, false);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (imageView = widgetHomePanelCenterNsfwBinding2.f2466b) != null) {
                imageView.setImageResource(R.drawable.img_age_gate_failure);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
            if (widgetHomePanelCenterNsfwBinding3 != null && (materialButton = widgetHomePanelCenterNsfwBinding3.d) != null) {
                FormatUtils.n(materialButton, R.string.back, new Object[0], null, 4);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (textView = widgetHomePanelCenterNsfwBinding4.f) != null) {
                FormatUtils.n(textView, R.string.age_gate_nsfw_underage_header, new Object[0], null, 4);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding5 = this.binding;
            if (widgetHomePanelCenterNsfwBinding5 != null && (linkifiedTextView2 = widgetHomePanelCenterNsfwBinding5.e) != null) {
                FormatUtils.n(linkifiedTextView2, R.string.age_gate_nsfw_underage_body, new Object[]{AppHelpDesk.a.a(115000084051L, "h_5206f3f2-0ee4-4380-b50a-25319e45bc7c")}, null, 4);
            }
        } else {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding6 = this.binding;
            if (widgetHomePanelCenterNsfwBinding6 != null && (linkifiedTextView = widgetHomePanelCenterNsfwBinding6.e) != null) {
                FormatUtils.n(linkifiedTextView, R.string.age_gate_nsfw_description, new Object[0], null, 4);
            }
        }
        setContainerViewHidden(false, onToggleNsfw);
    }

    @MainThread
    public final void configureUI(long guildId, boolean isChannelNsfw, boolean isNsfwUnconsented, NsfwAllowance nsfwAllowed, ViewStub viewStub, Function1<? super Boolean, Unit> onToggleNsfw, Function0<Unit> onDenyNsfw) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        Intrinsics3.checkNotNullParameter(onToggleNsfw, "onToggleNsfw");
        Subscription subscription = this.hidePanelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        toggleContainerVisibility(isChannelNsfw, isNsfwUnconsented, nsfwAllowed, viewStub, onToggleNsfw);
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.d) != null) {
            materialButton2.setOnClickListener(new AnonymousClass1(guildId, onDenyNsfw));
        }
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
        if (widgetHomePanelCenterNsfwBinding2 == null || (materialButton = widgetHomePanelCenterNsfwBinding2.c) == null) {
            return;
        }
        materialButton.setOnClickListener(new AnonymousClass2(guildId, onToggleNsfw));
    }

    public final void dispatchApplyWindowInsets(WindowInsetsCompat insets) {
        LinearLayout linearLayout;
        Intrinsics3.checkNotNullParameter(insets, "insets");
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding == null || (linearLayout = widgetHomePanelCenterNsfwBinding.a) == null) {
            return;
        }
        ViewCompat.dispatchApplyWindowInsets(linearLayout, insets);
    }
}

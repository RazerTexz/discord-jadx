package com.discord.widgets.guilds.join;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildWelcomeSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetChannelAdapter3;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildWelcomeSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b7\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ-\u0010\u0013\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\bR\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "viewState", "", "handleViewState", "(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;)V", "showLoadingView", "()V", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loaded;", "updateView", "(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState$Loaded;)V", "configureUI", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "iconHash", "shortName", "configureGuildIcon", "(JLjava/lang/String;Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "configureGuildDetails", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "welcomeChannels", "configureWelcomeChannels", "(Ljava/util/List;J)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "dismiss", "Lcom/discord/databinding/WidgetGuildWelcomeSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildWelcomeSheetBinding;", "binding", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetChannelAdapter;", "channelsAdapter", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetChannelAdapter;", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildWelcomeSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildWelcomeSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int LOADED_VIEW_INDEX = 1;
    private static final int LOADING_VIEW_INDEX = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final WidgetGuildWelcomeSheetChannelAdapter channelsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildWelcomeSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "", "show", "(Landroidx/fragment/app/FragmentManager;JLjava/lang/Long;)V", "", "LOADED_VIEW_INDEX", "I", "LOADING_VIEW_INDEX", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.show(fragmentManager, j, l);
        }

        public final void show(FragmentManager fragmentManager, long guildId, Long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildWelcomeSheet widgetGuildWelcomeSheet = new WidgetGuildWelcomeSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (guildScheduledEventId != null) {
                bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId.longValue());
            }
            widgetGuildWelcomeSheet.setArguments(bundleT);
            widgetGuildWelcomeSheet.show(fragmentManager, WidgetGuildWelcomeSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildWelcomeSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$onViewCreated$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildWelcomeSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
            super(1, widgetGuildWelcomeSheet, WidgetGuildWelcomeSheet.class, "handleViewState", "handleViewState(Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildWelcomeSheet.access$handleViewState((WidgetGuildWelcomeSheet) this.receiver, viewState);
        }
    }

    public WidgetGuildWelcomeSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildWelcomeSheet2.INSTANCE, null, 2, null);
        this.channelsAdapter = new WidgetGuildWelcomeSheetChannelAdapter();
        WidgetGuildWelcomeSheet5 widgetGuildWelcomeSheet5 = new WidgetGuildWelcomeSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildWelcomeSheetViewModel.class), new WidgetGuildWelcomeSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildWelcomeSheet5));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        return widgetGuildWelcomeSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildWelcomeSheetViewModel access$getViewModel$p(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        return widgetGuildWelcomeSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet, WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
        widgetGuildWelcomeSheet.handleViewState(viewState);
    }

    private final void configureGuildDetails(String name, String description) {
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildWelcomeSheetName");
        FormatUtils.n(textView, R.string.welcome_screen_title, new Object[]{name}, null, 4);
        if (description != null) {
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildWelcomeSheetDescription");
            ViewExtensions.setTextAndVisibilityBy(textView2, description);
        } else {
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildWelcomeSheetDescription");
            textView3.setVisibility(8);
        }
    }

    private final void configureGuildIcon(long guildId, String iconHash, String shortName) {
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guildId), iconHash, null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.avatar_size_xxlarge))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildWelcomeSheetIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeSheetIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeSheetIcon");
        IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildWelcomeSheetIconName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildWelcomeSheetIconName");
        textView3.setText(shortName);
    }

    private final void configureUI(WidgetGuildWelcomeSheetViewModel.ViewState.Loaded viewState) {
        long guildId = viewState.getGuildId();
        String guildName = viewState.getGuildName();
        String guildShortName = viewState.getGuildShortName();
        String guildIcon = viewState.getGuildIcon();
        String guildDescription = viewState.getGuildDescription();
        List<GuildWelcomeChannel> listComponent6 = viewState.component6();
        if (listComponent6 == null) {
            return;
        }
        configureGuildIcon(guildId, guildIcon, guildShortName);
        configureGuildDetails(guildName, guildDescription);
        configureWelcomeChannels(listComponent6, guildId);
    }

    private final void configureWelcomeChannels(List<GuildWelcomeChannel> welcomeChannels, long guildId) {
        WidgetGuildWelcomeSheet3 widgetGuildWelcomeSheet3 = new WidgetGuildWelcomeSheet3(this);
        WidgetGuildWelcomeSheet4 widgetGuildWelcomeSheet4 = new WidgetGuildWelcomeSheet4(this, guildId, welcomeChannels);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(welcomeChannels, 10));
        int i = 0;
        for (Object obj : welcomeChannels) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(new WidgetGuildWelcomeSheetChannelAdapter3.ChannelData((GuildWelcomeChannel) obj, widgetGuildWelcomeSheet3, guildId, widgetGuildWelcomeSheet4, i));
            i = i2;
        }
        this.channelsAdapter.setData(arrayList);
    }

    private final WidgetGuildWelcomeSheetBinding getBinding() {
        return (WidgetGuildWelcomeSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildWelcomeSheetViewModel getViewModel() {
        return (WidgetGuildWelcomeSheetViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(WidgetGuildWelcomeSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildWelcomeSheetViewModel.ViewState.Loading) {
            showLoadingView();
        } else if (viewState instanceof WidgetGuildWelcomeSheetViewModel.ViewState.Loaded) {
            updateView((WidgetGuildWelcomeSheetViewModel.ViewState.Loaded) viewState);
        } else {
            if (!(viewState instanceof WidgetGuildWelcomeSheetViewModel.ViewState.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
        }
    }

    public static final void show(FragmentManager fragmentManager, long j, Long l) {
        INSTANCE.show(fragmentManager, j, l);
    }

    private final void showLoadingView() {
        AppViewFlipper appViewFlipper = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildWelcomeSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final void updateView(WidgetGuildWelcomeSheetViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildWelcomeSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
        configureUI(viewState);
    }

    @Override // com.discord.app.AppBottomSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", 0L);
        if (j != 0) {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(j);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_welcome_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildWelcomeSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        RecyclerView recyclerView = getBinding().f2457b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildWelcomeSheetChannels");
        recyclerView.setAdapter(this.channelsAdapter);
    }
}

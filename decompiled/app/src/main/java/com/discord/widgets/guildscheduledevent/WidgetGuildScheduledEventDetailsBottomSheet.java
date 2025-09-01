package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsBottomSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.DirectoryButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.GuildButtonConfiguration;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.VoiceUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bF\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020#8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R$\u00101\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010/0/0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00108\u001a\u0002038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010E\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010%\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventDetailsBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "segmentIndex", "", "hide", "", "configureSegmentControl", "(IZ)V", "Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;", "rsvpUsersFetchState", "configureForRsvpUsersFetchState", "(Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;)V", "Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;", "section", "configureForSection", "(Lcom/discord/widgets/guildscheduledevent/EventDetailsSection;Lcom/discord/widgets/guildscheduledevent/EventDetailsRsvpUsersFetchState;)V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "viewState", "configureUi", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Initialized;", "Lcom/discord/widgets/guildscheduledevent/buttonconfiguration/ButtonConfiguration;", "getButtonConfiguration", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState$Initialized;)Lcom/discord/widgets/guildscheduledevent/buttonconfiguration/ButtonConfiguration;", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser;", "descriptionParser$delegate", "Lkotlin/Lazy;", "getDescriptionParser", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser;", "descriptionParser", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args$delegate", "getArgs", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "previewLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", "binding", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser;", "locationParser$delegate", "getLocationParser", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventExternalLocationParser;", "locationParser", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListAdapter;", "adapter", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListAdapter;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventDetailsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GuildScheduledEventRsvpUserListAdapter adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: descriptionParser$delegate, reason: from kotlin metadata */
    private final Lazy descriptionParser;

    /* renamed from: locationParser$delegate, reason: from kotlin metadata */
    private final Lazy locationParser;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\r\u001a\u00060\u0002j\u0002`\f2\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventDetailsBottomSheet$Companion;", "", "", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "", "enqueue", "(J)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "showForGuild", "(Landroidx/fragment/app/FragmentManager;J)V", "Lcom/discord/primitives/GuildId;", "hubGuildId", "Lcom/discord/primitives/ChannelId;", "directoryChannelId", "showForDirectory", "(Landroidx/fragment/app/FragmentManager;JJJ)V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;)V", "Landroid/content/Context;", "context", "handleInvalidEvent", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(long guildScheduledEventId) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strT = outline.t("EVENTDETAILS-", guildScheduledEventId);
            notices.requestToShow(new StoreNotices.Notice(strT, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildScheduledEventDetailsBottomSheet4(guildScheduledEventId, notices, strT), 150, null));
        }

        public final void handleInvalidEvent(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppToast.g(context, R.string.inaccessible_channel_link_title, 0, null, 12);
        }

        public final void show(FragmentManager fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = new WidgetGuildScheduledEventDetailsBottomSheet();
            widgetGuildScheduledEventDetailsBottomSheet.setArguments(AnimatableValueParser.e2(args));
            widgetGuildScheduledEventDetailsBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.class.getName());
        }

        public final void showForDirectory(FragmentManager fragmentManager, long guildScheduledEventId, long hubGuildId, long directoryChannelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new WidgetGuildScheduledEventDetailsBottomSheet2(guildScheduledEventId, Long.valueOf(hubGuildId), Long.valueOf(directoryChannelId), WidgetGuildScheduledEventDetailsBottomSheet3.Directory));
        }

        public final void showForGuild(FragmentManager fragmentManager, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new WidgetGuildScheduledEventDetailsBottomSheet2(guildScheduledEventId, null, null, null, 14, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventDetailsViewModel2.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventDetailsViewModel2.LOADING.ordinal()] = 1;
            iArr[GuildScheduledEventDetailsViewModel2.EMPTY.ordinal()] = 2;
            iArr[GuildScheduledEventDetailsViewModel2.ERROR.ordinal()] = 3;
            iArr[GuildScheduledEventDetailsViewModel2.SUCCESS.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "index", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureSegmentControl$1, reason: invalid class name */
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
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).setSegmentedControlIndex(i);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ UserGuildMember $creator;

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.replacementText = AnonymousClass4.this.$creator.getNickOrUserName();
                Context context = WidgetGuildScheduledEventDetailsBottomSheet.this.getContext();
                if (context != null) {
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "ctx");
                    Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
                    if (themedFont != null) {
                        hook.styles.add(new TypefaceSpanCompat(themedFont));
                    }
                }
                hook.styles.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(AnonymousClass4.this.$creator.getGuildMember(), ColorCompat.getThemedColor(WidgetGuildScheduledEventDetailsBottomSheet.this.getContext(), R.attr.colorHeaderPrimary))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(UserGuildMember userGuildMember) {
            super(1);
            this.$creator = userGuildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("usernameHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onGuildNameClicked();
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02951 extends Lambda implements Function0<Unit> {
            public C02951() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
            }
        }

        public AnonymousClass1(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = WidgetGuildScheduledEventDetailsBottomSheet.this;
            GuildScheduledEvent guildScheduledEvent = this.$this_getButtonConfiguration.getGuildScheduledEvent();
            boolean zIsInGuild = this.$this_getButtonConfiguration.isInGuild();
            Long guildId = WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this).getGuildId();
            long jLongValue = guildId != null ? guildId.longValue() : 0L;
            Long channelId = WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this).getChannelId();
            directoryUtils.maybeJoinAndGoToGuild(widgetGuildScheduledEventDetailsBottomSheet, guildScheduledEvent, zIsInGuild, jLongValue, channelId != null ? channelId.longValue() : 0L, !this.$this_getButtonConfiguration.isRsvped() && GuildScheduledEventUtilities5.canRsvp(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new C02951());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10$1, reason: invalid class name */
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
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            }
        }

        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            guildScheduledEventDetailsViewModelAccess$getViewModel$p.endEventClicked(contextRequireContext, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        public AnonymousClass5(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, contextRequireContext, GuildScheduledEventModel2.toModel(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(this.$this_getButtonConfiguration.getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), WidgetGuildScheduledEventDetailsBottomSheet.access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet.this), false, 16, null);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        public AnonymousClass9(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            Channel channel = this.$this_getButtonConfiguration.getChannel();
            if (channel != null) {
                VoiceUtils.handleCallChannel(channel, WidgetGuildScheduledEventDetailsBottomSheet.this);
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsBottomSheet, WidgetGuildScheduledEventDetailsBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventDetailsBottomSheet.access$configureUi((WidgetGuildScheduledEventDetailsBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventDetailsBottomSheet5.INSTANCE, null, 2, null);
        this.descriptionParser = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsBottomSheet6(this));
        this.locationParser = LazyJVM.lazy(WidgetGuildScheduledEventDetailsBottomSheet7.INSTANCE);
        this.args = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsBottomSheet9 widgetGuildScheduledEventDetailsBottomSheet9 = new WidgetGuildScheduledEventDetailsBottomSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventDetailsBottomSheet9));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsBottomSheet8(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel.ViewState viewState) {
        widgetGuildScheduledEventDetailsBottomSheet.configureUi(viewState);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getArgs();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventDetailsViewModel access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getViewModel();
    }

    private final void configureForRsvpUsersFetchState(GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState) {
        ProgressBar progressBar = getBinding().f2444s;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.loadingIndicator");
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        recyclerView.setVisibility(8);
        int iOrdinal = rsvpUsersFetchState.ordinal();
        if (iOrdinal == 0) {
            ProgressBar progressBar2 = getBinding().f2444s;
            Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.loadingIndicator");
            progressBar2.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            ConstraintLayout constraintLayout2 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventEmptyOrErrorContainer");
            constraintLayout2.setVisibility(0);
            TextView textView = getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventEmptyOrErrorTitle");
            FormatUtils.n(textView, R.string.guild_event_details_user_list_fetch_error, new Object[0], null, 4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            RecyclerView recyclerView2 = getBinding().r;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildScheduledEventRsvpListRecyclerView");
            recyclerView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout3 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout3.setVisibility(0);
        TextView textView2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventEmptyOrErrorTitle");
        FormatUtils.n(textView2, R.string.guild_event_details_user_list_empty_title, new Object[0], null, 4);
    }

    private final void configureForSection(GuildScheduledEventDetailsViewModel3 section, GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState) {
        GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = GuildScheduledEventDetailsViewModel3.RSVP_LIST;
        if (section == guildScheduledEventDetailsViewModel3) {
            configureForRsvpUsersFetchState(rsvpUsersFetchState);
        }
        ConstraintLayout constraintLayout = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventInfoContainer");
        constraintLayout.setVisibility(section == GuildScheduledEventDetailsViewModel3.EVENT_INFO ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventRsvpListContainer");
        constraintLayout2.setVisibility(section == guildScheduledEventDetailsViewModel3 ? 0 : 8);
    }

    private final void configureSegmentControl(int segmentIndex, boolean hide) {
        SegmentedControlContainer segmentedControlContainer = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer, "binding.segmentedControl");
        segmentedControlContainer.setVisibility(hide ^ true ? 0 : 8);
        if (hide) {
            return;
        }
        SegmentedControlContainer.b(getBinding().t, 0, 1);
        getBinding().t.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        getBinding().t.setSelectedIndex(segmentIndex);
        CardSegment cardSegment = getBinding().u;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        cardSegment.setText(FormatUtils.h(contextRequireContext, R.string.guild_event_details_info_tab_title, new Object[0], null, 4));
        CardSegment cardSegment2 = getBinding().v;
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        cardSegment2.setText(FormatUtils.h(contextRequireContext2, R.string.indicate_rsvp, new Object[0], null, 4));
    }

    private final void configureUi(GuildScheduledEventDetailsViewModel.ViewState viewState) {
        CharSequence textFromLocation;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel.ViewState.Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized = (GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState;
        configureSegmentControl(initialized.getSegmentedControlIndex(), !initialized.isInGuild());
        configureForSection(initialized.getSection(), initialized.getRsvpUsersFetchState());
        getBinding().g.configure(initialized.getGuildScheduledEvent(), false);
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventDetailsTitleText");
        textView.setText(initialized.getGuildScheduledEvent().getName());
        SimpleDraweeView simpleDraweeView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventDetailsGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, initialized.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventDetailsGuildName");
        textView2.setText(initialized.getGuild().getName());
        GuildScheduledEventLocationInfo locationInfo = initialized.getLocationInfo();
        if (locationInfo != null) {
            getBinding().c.setImageResource(locationInfo.getLocationIcon());
        }
        ImageView imageView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildScheduledEventDetailsChannelIcon");
        imageView.setVisibility(initialized.getLocationInfo() != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsChannelName");
        GuildScheduledEventLocationInfo locationInfo2 = initialized.getLocationInfo();
        CharSequence charSequenceH = null;
        if (locationInfo2 != null) {
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textFromLocation = locationParser.getTextFromLocation(contextRequireContext, locationInfo2);
        } else {
            textFromLocation = null;
        }
        ViewExtensions.setTextAndVisibilityBy(linkifiedTextView, textFromLocation);
        ImageView imageView2 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildScheduledEventDetailsRsvpIcon");
        imageView2.setVisibility(initialized.getGuildScheduledEvent().getUserCount() != null ? 0 : 8);
        TextView textView3 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventDetailsRsvpCount");
        Integer userCount = initialized.getGuildScheduledEvent().getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            Context contextRequireContext3 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            charSequenceH = FormatUtils.h(contextRequireContext2, R.string.guild_event_interested_count, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext3, R.plurals.guild_event_interested_count_count, iIntValue, Integer.valueOf(iIntValue))}, null, 4);
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceH);
        UserGuildMember creator = initialized.getCreator();
        if (creator != null) {
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildScheduledEventDetailsCreatedBy");
            textView4.setVisibility(0);
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView2.setVisibility(0);
            TextView textView5 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildScheduledEventDetailsCreatedBy");
            FormatUtils.m(textView5, R.string.guild_event_created_by_hook, new Object[]{creator.getNickOrUserName()}, new AnonymousClass4(creator));
            SimpleDraweeView simpleDraweeView3 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventDetailsCreatorAvatar");
            SimpleDraweeViewExtensions.configureCreator(simpleDraweeView3, creator);
        } else {
            TextView textView6 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventDetailsCreatedBy");
            textView6.setVisibility(8);
            SimpleDraweeView simpleDraweeView4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView4.setVisibility(8);
        }
        getDescriptionParser().configureDescription(initialized.getGuildScheduledEvent().getDescription(), initialized.getGuildScheduledEvent().getGuildId());
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = getBinding().f2443b;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventDetailsButtonView");
        guildScheduledEventBottomButtonView.setVisibility(0);
        getBinding().f2443b.configureForDetails(getButtonConfiguration(initialized));
        getBinding().j.setOnClickListener(new AnonymousClass5());
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        guildScheduledEventRsvpUserListAdapter.setData(initialized.getRsvpUsers());
    }

    private final WidgetGuildScheduledEventDetailsBottomSheet2 getArgs() {
        return (WidgetGuildScheduledEventDetailsBottomSheet2) this.args.getValue();
    }

    private final ButtonConfiguration getButtonConfiguration(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
        if (getArgs().getSource() == WidgetGuildScheduledEventDetailsBottomSheet3.Directory) {
            return new DirectoryButtonConfiguration(initialized.getGuildScheduledEvent(), initialized.isInGuild(), initialized.isRsvped(), true, new AnonymousClass1(initialized), new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass4());
        }
        GuildScheduledEvent guildScheduledEvent = initialized.getGuildScheduledEvent();
        boolean canStartEvent = initialized.getCanStartEvent();
        boolean canConnect = initialized.getCanConnect();
        boolean zIsConnected = initialized.isConnected();
        boolean zIsInGuild = initialized.isInGuild();
        boolean zIsRsvped = initialized.isRsvped();
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(initialized);
        return new GuildButtonConfiguration(guildScheduledEvent, true, canStartEvent, zIsConnected, canConnect, zIsInGuild, zIsRsvped, true, new AnonymousClass6(), new AnonymousClass9(initialized), new AnonymousClass10(), anonymousClass5, new AnonymousClass7(), new AnonymousClass8());
    }

    private final GuildScheduledEventExternalLocationParser getLocationParser() {
        return (GuildScheduledEventExternalLocationParser) this.locationParser.getValue();
    }

    private final GuildScheduledEventDetailsViewModel getViewModel() {
        return (GuildScheduledEventDetailsViewModel) this.viewModel.getValue();
    }

    public final WidgetGuildScheduledEventDetailsBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventDetailsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_details_bottom_sheet;
    }

    public final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventDetailsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        this.adapter = new GuildScheduledEventRsvpUserListAdapter(recyclerView, new AnonymousClass1());
        RecyclerView recyclerView2 = getBinding().r;
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventRsvpUserListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
    }
}

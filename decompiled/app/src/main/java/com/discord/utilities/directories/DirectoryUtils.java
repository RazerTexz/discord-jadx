package com.discord.utilities.directories;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.SimpleConfirmationDialog;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import com.discord.R;
import com.discord.analytics.generated.events.TrackHubEventCtaClicked;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import com.discord.widgets.hubs.WidgetHubDescription;
import com.discord.widgets.hubs.WidgetHubDescriptionViewModel2;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: DirectoryUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b,\u0010-J;\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJS\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u00152\n\u0010\u0018\u001a\u00060\u0014j\u0002`\u00172\u0006\u0010\u0019\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010#\u001a\u00020\u000b2\n\u0010\u001e\u001a\u00060\u0014j\u0002`\u001d2\n\u0010\u001f\u001a\u00060\u0014j\u0002`\u00152\n\u0010 \u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010(¨\u0006/"}, d2 = {"Lcom/discord/utilities/directories/DirectoryUtils;", "", "Lcom/discord/app/AppFragment;", "fragment", "Lcom/discord/api/directory/DirectoryEntryGuild;", "directoryEntry", "", "hubName", "", "isServerOwner", "Lkotlin/Function0;", "", "removeGuildListener", "showServerOptions", "(Lcom/discord/app/AppFragment;Lcom/discord/api/directory/DirectoryEntryGuild;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "Lcom/discord/app/AppBottomSheet;", "bottomSheet", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "isInGuild", "", "Lcom/discord/primitives/GuildId;", "hubGuildId", "Lcom/discord/primitives/ChannelId;", "directoryChannelId", "shouldToggleRsvp", "toggleRsvp", "maybeJoinAndGoToGuild", "(Lcom/discord/app/AppBottomSheet;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;ZJJZLkotlin/jvm/functions/Function0;)V", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "guildScheduledEventGuildId", "guildId", "Lcom/discord/analytics/utils/hubs/HubGuildScheduledEventClickType;", "clickType", "logGuildScheduledEventClickAction", "(JJJLcom/discord/analytics/utils/hubs/HubGuildScheduledEventClickType;)V", "", "Lcom/discord/utilities/directories/DirectoryUtils$DirectoryServerMenuOptions;", "SERVER_OWNER_MENU_OPTIONS", "Ljava/util/List;", "JOIN_GUILD_SOURCE", "Ljava/lang/String;", "NON_SERVER_OWNER_MENU_OPTIONS", "<init>", "()V", "DirectoryServerMenuOptions", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DirectoryUtils {
    public static final String JOIN_GUILD_SOURCE = "Directory Channel Entry";
    public static final DirectoryUtils INSTANCE = new DirectoryUtils();
    private static final List<DirectoryServerMenuOptions> SERVER_OWNER_MENU_OPTIONS = Collections2.listOf((Object[]) new DirectoryServerMenuOptions[]{DirectoryServerMenuOptions.Edit, DirectoryServerMenuOptions.Remove});
    private static final List<DirectoryServerMenuOptions> NON_SERVER_OWNER_MENU_OPTIONS = CollectionsJVM.listOf(DirectoryServerMenuOptions.Report);

    /* compiled from: DirectoryUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/directories/DirectoryUtils$DirectoryServerMenuOptions;", "", "", "titleRes", "I", "getTitleRes", "()I", "iconRes", "getIconRes", "<init>", "(Ljava/lang/String;III)V", "Edit", "Remove", "Report", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum DirectoryServerMenuOptions {
        Edit(R.string.hub_entry_update, R.drawable.ic_edit_24dp),
        Remove(R.string.hub_entry_remove, R.drawable.ic_delete_24dp),
        Report(R.string.report, R.drawable.ic_flag_24dp);

        private final int iconRes;
        private final int titleRes;

        DirectoryServerMenuOptions(@StringRes int i, @DrawableRes int i2) {
            this.titleRes = i;
            this.iconRes = i2;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DirectoryServerMenuOptions.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DirectoryServerMenuOptions.Edit.ordinal()] = 1;
            iArr[DirectoryServerMenuOptions.Remove.ordinal()] = 2;
            iArr[DirectoryServerMenuOptions.Report.ordinal()] = 3;
        }
    }

    /* compiled from: DirectoryUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.directories.DirectoryUtils$maybeJoinAndGoToGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public final /* synthetic */ AppBottomSheet $bottomSheet;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ boolean $shouldToggleRsvp;
        public final /* synthetic */ Function0 $toggleRsvp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, Function0 function0, GuildScheduledEvent guildScheduledEvent, AppBottomSheet appBottomSheet) {
            super(1);
            this.$shouldToggleRsvp = z2;
            this.$toggleRsvp = function0;
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$bottomSheet = appBottomSheet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            if (this.$shouldToggleRsvp) {
                this.$toggleRsvp.invoke();
            }
            StoreStream.INSTANCE.getGuildSelected().set(this.$guildScheduledEvent.getGuildId());
            FragmentManager parentFragmentManager = this.$bottomSheet.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "bottomSheet.parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics3.checkNotNullExpressionValue(fragments, "bottomSheet.parentFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof AppBottomSheet) {
                    ((AppBottomSheet) fragment).dismiss();
                }
            }
        }
    }

    /* compiled from: DirectoryUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ String $hubName;
        public final /* synthetic */ List $options;
        public final /* synthetic */ Function0 $removeGuildListener;

        /* compiled from: DirectoryUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnonymousClass2.this.$removeGuildListener.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, Context context, DirectoryEntryGuild directoryEntryGuild, String str, AppFragment appFragment, Function0 function0) {
            super(1);
            this.$options = list;
            this.$context = context;
            this.$directoryEntry = directoryEntryGuild;
            this.$hubName = str;
            this.$fragment = appFragment;
            this.$removeGuildListener = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            DirectoryServerMenuOptions directoryServerMenuOptions = (DirectoryServerMenuOptions) _Collections.getOrNull(this.$options, i);
            if (directoryServerMenuOptions != null) {
                int iOrdinal = directoryServerMenuOptions.ordinal();
                if (iOrdinal == 0) {
                    AppScreen2.d(this.$context, WidgetHubDescription.class, new WidgetHubDescriptionViewModel2(this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getDirectoryChannelId(), true, this.$hubName, false, this.$directoryEntry.getDescription(), Integer.valueOf(this.$directoryEntry.getPrimaryCategoryId()), 16, null));
                    return;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetMobileReports.INSTANCE.launchDirectoryServerReport(this.$context, this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getEntityId(), this.$directoryEntry.getDirectoryChannelId());
                } else {
                    SimpleConfirmationDialog.Companion cVar = SimpleConfirmationDialog.INSTANCE;
                    FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    cVar.a(childFragmentManager, new SimpleConfirmationDialog2(this.$fragment.getString(R.string.hub_entry_remove), FormatUtils.h(this.$context, R.string.hub_entry_remove_body, new Object[]{this.$directoryEntry.getGuild().getName()}, null, 4).toString(), this.$fragment.getString(R.string.remove), this.$fragment.getString(R.string.cancel)), new AnonymousClass1());
                }
            }
        }
    }

    private DirectoryUtils() {
    }

    public final void logGuildScheduledEventClickAction(long guildScheduledEventId, long guildScheduledEventGuildId, long guildId, HubGuildScheduledEventClickType clickType) {
        Intrinsics3.checkNotNullParameter(clickType, "clickType");
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        TrackHubEventCtaClicked trackHubEventCtaClicked = new TrackHubEventCtaClicked(Long.valueOf(guildScheduledEventId), Long.valueOf(guildScheduledEventGuildId), clickType.getType());
        trackHubEventCtaClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        tracker.track(trackHubEventCtaClicked);
    }

    public final void maybeJoinAndGoToGuild(AppBottomSheet bottomSheet, GuildScheduledEvent guildScheduledEvent, boolean isInGuild, long hubGuildId, long directoryChannelId, boolean shouldToggleRsvp, Function0<Unit> toggleRsvp) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        Intrinsics3.checkNotNullParameter(toggleRsvp, "toggleRsvp");
        if (isInGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(guildScheduledEvent.getGuildId());
            bottomSheet.dismiss();
        } else {
            logGuildScheduledEventClickAction(guildScheduledEvent.getId(), guildScheduledEvent.getGuildId(), hubGuildId, HubGuildScheduledEventClickType.JoinServer);
            Context contextRequireContext = bottomSheet.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "bottomSheet.requireContext()");
            GuildJoinHelper.joinGuild$default(contextRequireContext, guildScheduledEvent.getGuildId(), false, null, Long.valueOf(directoryChannelId), RestAPI.INSTANCE.getApi().jsonObjectOf(Tuples.to("source", JOIN_GUILD_SOURCE)), DirectoryUtils.class, null, null, null, new AnonymousClass1(shouldToggleRsvp, toggleRsvp, guildScheduledEvent, bottomSheet), 896, null);
        }
    }

    public final void showServerOptions(AppFragment fragment, DirectoryEntryGuild directoryEntry, String hubName, boolean isServerOwner, Function0<Unit> removeGuildListener) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        Intrinsics3.checkNotNullParameter(removeGuildListener, "removeGuildListener");
        Context context = fragment.getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "fragment.context ?: return");
            List<DirectoryServerMenuOptions> list = isServerOwner ? SERVER_OWNER_MENU_OPTIONS : NON_SERVER_OWNER_MENU_OPTIONS;
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            String string = fragment.getString(R.string.server_settings);
            Intrinsics3.checkNotNullExpressionValue(string, "fragment.getString(R.string.server_settings)");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (DirectoryServerMenuOptions directoryServerMenuOptions : list) {
                arrayList.add(new SelectorBottomSheet2(fragment.getString(directoryServerMenuOptions.getTitleRes()), null, Integer.valueOf(directoryServerMenuOptions.getIconRes()), null, null, null, null, 122));
            }
            companion.a(childFragmentManager, string, arrayList, false, new AnonymousClass2(list, context, directoryEntry, hubName, fragment, removeGuildListener));
        }
    }
}

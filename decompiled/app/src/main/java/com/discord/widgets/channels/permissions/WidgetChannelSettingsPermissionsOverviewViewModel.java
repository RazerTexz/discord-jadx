package com.discord.widgets.channels.permissions;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;", "tab", "", "selectTab", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "", "isStageChannel", "<init>", "(JZ)V", "Tab", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModel extends AppViewModel<ViewState> {
    private final long channelId;

    /* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;", "", "<init>", "(Ljava/lang/String;I)V", "MODERATOR", "ADVANCED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Tab {
        MODERATOR,
        ADVANCED
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;", "component1", "()Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;", "", "component2", "()Ljava/util/List;", "selectedTab", "availableTabs", "copy", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;Ljava/util/List;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAvailableTabs", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;", "getSelectedTab", "<init>", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverviewViewModel$Tab;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final List<Tab> availableTabs;
        private final Tab selectedTab;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(Tab tab, List<? extends Tab> list) {
            Intrinsics3.checkNotNullParameter(tab, "selectedTab");
            Intrinsics3.checkNotNullParameter(list, "availableTabs");
            this.selectedTab = tab;
            this.availableTabs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, Tab tab, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                tab = viewState.selectedTab;
            }
            if ((i & 2) != 0) {
                list = viewState.availableTabs;
            }
            return viewState.copy(tab, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Tab getSelectedTab() {
            return this.selectedTab;
        }

        public final List<Tab> component2() {
            return this.availableTabs;
        }

        public final ViewState copy(Tab selectedTab, List<? extends Tab> availableTabs) {
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(availableTabs, "availableTabs");
            return new ViewState(selectedTab, availableTabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedTab, viewState.selectedTab) && Intrinsics3.areEqual(this.availableTabs, viewState.availableTabs);
        }

        public final List<Tab> getAvailableTabs() {
            return this.availableTabs;
        }

        public final Tab getSelectedTab() {
            return this.selectedTab;
        }

        public int hashCode() {
            Tab tab = this.selectedTab;
            int iHashCode = (tab != null ? tab.hashCode() : 0) * 31;
            List<Tab> list = this.availableTabs;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(", availableTabs=");
            return outline.L(sbU, this.availableTabs, ")");
        }
    }

    public WidgetChannelSettingsPermissionsOverviewViewModel(long j, boolean z2) {
        super(WidgetChannelSettingsPermissionsOverviewViewModel2.access$generateInitialViewState(z2));
        this.channelId = j;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final void selectTab(Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
        updateViewState(ViewState.copy$default(requireViewState(), tab, null, 2, null));
    }
}

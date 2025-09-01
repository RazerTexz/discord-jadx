package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.SelectorDialog;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGlobalSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.textfield.TextInputLayout;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.g0._Strings;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetGlobalSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0016\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\r\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00103\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00108\u001a\u00020\u0010*\u00020\n8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R:\u0010>\u001a&\u0012\f\u0012\n =*\u0004\u0018\u00010\u00060\u0006 =*\u0012\u0012\f\u0012\n =*\u0004\u0018\u00010\u00060\u0006\u0018\u00010<0<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearch;", "Lcom/discord/app/AppFragment;", "", "focusSearchBar", "()V", "showFilterPickerDialog", "", "prefix", "setSearchPrefix", "(Ljava/lang/String;)V", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "model", "configureUI", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;)V", "Landroid/view/View;", "view", "", "index", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "data", "", "isLongPress", "handleOnSelected", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;Landroid/view/View;ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;Z)V", "Lcom/discord/widgets/tabs/NavigationTab;", "destinationTab", "Lcom/discord/stores/StoreNavigation$PanelAction;", "panelAction", "onSelected", "(Lcom/discord/widgets/tabs/NavigationTab;Lcom/discord/stores/StoreNavigation$PanelAction;)V", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onDismiss", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "guildsAdapter", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "resultsAdapter", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "Lcom/discord/databinding/WidgetGlobalSearchBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGlobalSearchBinding;", "binding", "Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "dismissViewModel$delegate", "Lkotlin/Lazy;", "getDismissViewModel", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "dismissViewModel", "filterString", "Ljava/lang/String;", "getViewIndex", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;)I", "viewIndex", "Lcom/discord/stores/StoreTabsNavigation;", "storeTabsNavigation", "Lcom/discord/stores/StoreTabsNavigation;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "filterPublisher", "Lrx/subjects/BehaviorSubject;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGlobalSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGlobalSearchBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_SEARCH_TEXT = "EXTRA_SEARCH_TEXT";
    private static final int INDEX_EMPTY = 1;
    private static final int INDEX_RESULTS = 0;
    private static final int INDEX_RESULTS_NOT_FOUND = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;
    private final BehaviorSubject<String> filterPublisher;
    private String filterString;
    private WidgetGlobalSearchGuildsAdapter guildsAdapter;
    private WidgetGlobalSearchAdapter resultsAdapter;
    private final StoreTabsNavigation storeTabsNavigation;

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR(\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearch$Companion;", "", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "toWidgetGlobalSearchModelItem", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "searchText", "Lcom/discord/widgets/user/search/WidgetGlobalSearch;", "create", "(Ljava/lang/String;)Lcom/discord/widgets/user/search/WidgetGlobalSearch;", "", "Lkotlin/Pair;", "", "", "getFILTER_OPTIONS_LIST", "()[Lkotlin/Pair;", "FILTER_OPTIONS_LIST", WidgetGlobalSearch.EXTRA_SEARCH_TEXT, "Ljava/lang/String;", "INDEX_EMPTY", "I", "INDEX_RESULTS", "INDEX_RESULTS_NOT_FOUND", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Tuples2[] access$getFILTER_OPTIONS_LIST$p(Companion companion) {
            return companion.getFILTER_OPTIONS_LIST();
        }

        public static final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload access$toWidgetGlobalSearchModelItem(Companion companion, WidgetGlobalSearchGuildsModel.Item item) {
            return companion.toWidgetGlobalSearchModelItem(item);
        }

        public static /* synthetic */ WidgetGlobalSearch create$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.create(str);
        }

        private final Tuples2<Integer, Character>[] getFILTER_OPTIONS_LIST() {
            return new Tuples2[]{Tuples.to(Integer.valueOf(R.string.users), Character.valueOf(MentionUtils.MENTIONS_CHAR)), Tuples.to(Integer.valueOf(R.string.text_channels), Character.valueOf(MentionUtils.CHANNELS_CHAR)), Tuples.to(Integer.valueOf(R.string.voice_channels), '!'), Tuples.to(Integer.valueOf(R.string.servers), '*')};
        }

        private final WidgetGlobalSearchModel.ItemDataPayload toWidgetGlobalSearchModelItem(WidgetGlobalSearchGuildsModel.Item item) {
            Channel channel = item.getChannel();
            User userA = channel != null ? ChannelUtils.a(channel) : null;
            if (item.getGuild() != null) {
                return new WidgetGlobalSearchModel.ItemGuild(WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT(), item.getGuild(), channel, 0, false, 24, null);
            }
            if (userA != null) {
                return new WidgetGlobalSearchModel.ItemUser(WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT(), userA, Collections2.emptyList(), false, null, channel, 0, false, Opcodes.CHECKCAST, null);
            }
            if (channel == null || !ChannelUtils.z(channel)) {
                return null;
            }
            return new WidgetGlobalSearchModel.ItemChannel(WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT(), channel, null, null, 0, false, 48, null);
        }

        public final WidgetGlobalSearch create(String searchText) {
            WidgetGlobalSearch widgetGlobalSearch = new WidgetGlobalSearch();
            widgetGlobalSearch.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
            return widgetGlobalSearch;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "viewType", "<anonymous parameter 1>", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "data", "", "invoke", "(IILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
            invoke(num.intValue(), num2.intValue(), item);
            return Unit.a;
        }

        public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
            Intrinsics3.checkNotNullParameter(item, "data");
            if (i == 2) {
                WidgetChannelsListItemChannelActions.Companion companion = WidgetChannelsListItemChannelActions.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGlobalSearch.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, item.getId());
                return;
            }
            if (i != 3) {
                return;
            }
            WidgetGuildProfileSheet.Companion companion2 = WidgetGuildProfileSheet.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetGlobalSearch.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            Guild guild = item.getGuild();
            WidgetGuildProfileSheet.Companion.show$default(companion2, parentFragmentManager2, false, guild != null ? guild.getId() : 0L, 0L, false, 24, null);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "viewType", "index", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "selected", "", "invoke", "(IILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
        public final /* synthetic */ WidgetGlobalSearchModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            super(3);
            this.$model = widgetGlobalSearchModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
            invoke(num.intValue(), num2.intValue(), item);
            return Unit.a;
        }

        public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
            Intrinsics3.checkNotNullParameter(item, "selected");
            if (i == 2) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, item.getId(), null, null, 12, null);
            } else if (i == 3) {
                StoreStream.INSTANCE.getGuildSelected().set(item.getId());
            }
            WidgetGlobalSearchModel.ItemDataPayload itemDataPayloadAccess$toWidgetGlobalSearchModelItem = Companion.access$toWidgetGlobalSearchModelItem(WidgetGlobalSearch.INSTANCE, item);
            if (itemDataPayloadAccess$toWidgetGlobalSearchModelItem != null) {
                AnalyticsTracker.INSTANCE.quickSwitcherSelect(this.$model, itemDataPayloadAccess$toWidgetGlobalSearchModelItem, i2);
            }
            WidgetGlobalSearch.access$onSelected(WidgetGlobalSearch.this, NavigationTab.HOME, StoreNavigation.PanelAction.OPEN);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGlobalSearch.access$getFilterPublisher$p(WidgetGlobalSearch.this).onNext(editable.toString());
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGlobalSearch.access$showFilterPickerDialog(WidgetGlobalSearch.this);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGlobalSearch widgetGlobalSearch = WidgetGlobalSearch.this;
            widgetGlobalSearch.hideKeyboard(WidgetGlobalSearch.access$getBinding$p(widgetGlobalSearch).c);
            WidgetGlobalSearch.access$getDismissViewModel$p(WidgetGlobalSearch.this).dismiss();
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetGlobalSearch.access$focusSearchBar(WidgetGlobalSearch.this);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
            Context contextX = outline.x(view, "it", "it.context");
            TextInputLayout textInputLayout = WidgetGlobalSearch.access$getBinding$p(WidgetGlobalSearch.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
            companion.show(contextX, Strings4.trimStart(ViewExtensions.getTextOrEmpty(textInputLayout), MentionUtils.MENTIONS_CHAR, MentionUtils.CHANNELS_CHAR, '*'), "QuickSwitcher");
            WidgetGlobalSearch.onSelected$default(WidgetGlobalSearch.this, NavigationTab.FRIENDS, null, 2, null);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildJoin.Companion companion = WidgetGuildJoin.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            companion.show(context, "QuickSwitcher");
            WidgetGlobalSearch.access$onSelected(WidgetGlobalSearch.this, NavigationTab.HOME, StoreNavigation.PanelAction.OPEN);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "p1", "", "invoke", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGlobalSearchModel, Unit> {
        public AnonymousClass1(WidgetGlobalSearch widgetGlobalSearch) {
            super(1, widgetGlobalSearch, WidgetGlobalSearch.class, "configureUI", "configureUI(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            invoke2(widgetGlobalSearchModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchModel, "p1");
            WidgetGlobalSearch.access$configureUI((WidgetGlobalSearch) this.receiver, widgetGlobalSearchModel);
        }
    }

    /* compiled from: WidgetGlobalSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "choice", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$showFilterPickerDialog$1, reason: invalid class name */
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
            WidgetGlobalSearch.access$setSearchPrefix(WidgetGlobalSearch.this, String.valueOf(((Character) Companion.access$getFILTER_OPTIONS_LIST$p(WidgetGlobalSearch.INSTANCE)[i].component2()).charValue()));
        }
    }

    public WidgetGlobalSearch() {
        super(R.layout.widget_global_search);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetGlobalSearch$$special$$inlined$activityViewModels$1(this), new WidgetGlobalSearch$$special$$inlined$activityViewModels$2(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGlobalSearch4.INSTANCE, null, 2, null);
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.filterPublisher = BehaviorSubject.l0("");
    }

    public static final /* synthetic */ void access$configureUI(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        widgetGlobalSearch.configureUI(widgetGlobalSearchModel);
    }

    public static final /* synthetic */ void access$focusSearchBar(WidgetGlobalSearch widgetGlobalSearch) {
        widgetGlobalSearch.focusSearchBar();
    }

    public static final /* synthetic */ WidgetGlobalSearchBinding access$getBinding$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.getBinding();
    }

    public static final /* synthetic */ WidgetGlobalSearchDismissModel access$getDismissViewModel$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.getDismissViewModel();
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.filterPublisher;
    }

    public static final /* synthetic */ String access$getFilterString$p(WidgetGlobalSearch widgetGlobalSearch) {
        return widgetGlobalSearch.filterString;
    }

    public static final /* synthetic */ void access$handleOnSelected(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel, View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        widgetGlobalSearch.handleOnSelected(widgetGlobalSearchModel, view, i, itemDataPayload, z2);
    }

    public static final /* synthetic */ void access$onSelected(WidgetGlobalSearch widgetGlobalSearch, NavigationTab navigationTab, StoreNavigation.PanelAction panelAction) {
        widgetGlobalSearch.onSelected(navigationTab, panelAction);
    }

    public static final /* synthetic */ void access$setFilterString$p(WidgetGlobalSearch widgetGlobalSearch, String str) {
        widgetGlobalSearch.filterString = str;
    }

    public static final /* synthetic */ void access$setSearchPrefix(WidgetGlobalSearch widgetGlobalSearch, String str) {
        widgetGlobalSearch.setSearchPrefix(str);
    }

    public static final /* synthetic */ void access$showFilterPickerDialog(WidgetGlobalSearch widgetGlobalSearch) {
        widgetGlobalSearch.showFilterPickerDialog();
    }

    @MainThread
    private final void configureUI(WidgetGlobalSearchModel model) {
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        List<WidgetGlobalSearchGuildsModel.Item> guildsList = model.getGuildsList();
        if (guildsList == null) {
            guildsList = Collections2.emptyList();
        }
        widgetGlobalSearchGuildsAdapter.setData(guildsList);
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter2 = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        widgetGlobalSearchGuildsAdapter2.setOnLongClickListener(new AnonymousClass1());
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter3 = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        widgetGlobalSearchGuildsAdapter3.setOnClickListener(new AnonymousClass2(model));
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.globalSearchGuildList");
        List<WidgetGlobalSearchGuildsModel.Item> guildsList2 = model.getGuildsList();
        recyclerView.setVisibility(guildsList2 != null && !guildsList2.isEmpty() ? 0 : 8);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetGlobalSearchAdapter.setOnUpdated(new WidgetGlobalSearch2(this, model));
        widgetGlobalSearchAdapter.setData(model.getData());
        widgetGlobalSearchAdapter.setOnSelectedListener(new WidgetGlobalSearch3(this, model));
        AppViewFlipper appViewFlipper = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.globalSearchViewFlipper");
        appViewFlipper.setDisplayedChild(getViewIndex(model));
    }

    private final void focusSearchBar() {
        getBinding().d.requestFocus();
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(getBinding().d, 1);
        }
    }

    private final WidgetGlobalSearchBinding getBinding() {
        return (WidgetGlobalSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final int getViewIndex(WidgetGlobalSearchModel widgetGlobalSearchModel) {
        if (!widgetGlobalSearchModel.getData().isEmpty()) {
            return 0;
        }
        return StringsJVM.isBlank(widgetGlobalSearchModel.getFilter()) ^ true ? 2 : 1;
    }

    private final void handleOnSelected(WidgetGlobalSearchModel widgetGlobalSearchModel, View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser) {
            if (z2) {
                WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                long id2 = ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
            } else {
                ChannelSelector companion2 = ChannelSelector.INSTANCE.getInstance();
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion2.findAndSetDirectMessage(context, ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId());
            }
        } else if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemChannel) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(getContext(), ((WidgetGlobalSearchModel.ItemChannel) itemDataPayload).getChannel().getId());
        } else if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(((WidgetGlobalSearchModel.ItemGuild) itemDataPayload).getGuild().getId());
        }
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemHeader) || z2) {
            return;
        }
        AnalyticsTracker.INSTANCE.quickSwitcherSelect(widgetGlobalSearchModel, itemDataPayload, i);
        onSelected(NavigationTab.HOME, itemDataPayload instanceof WidgetGlobalSearchModel.ItemGuild ? StoreNavigation.PanelAction.OPEN : StoreNavigation.PanelAction.CLOSE);
    }

    private final void onSelected(NavigationTab destinationTab, StoreNavigation.PanelAction panelAction) {
        if (destinationTab == NavigationTab.HOME) {
            StoreTabsNavigation.selectHomeTab$default(this.storeTabsNavigation, panelAction, false, 2, null);
        } else {
            StoreTabsNavigation.selectTab$default(this.storeTabsNavigation, destinationTab, false, 2, null);
        }
        getDismissViewModel().dismiss();
    }

    public static /* synthetic */ void onSelected$default(WidgetGlobalSearch widgetGlobalSearch, NavigationTab navigationTab, StoreNavigation.PanelAction panelAction, int i, Object obj) {
        if ((i & 1) != 0) {
            navigationTab = NavigationTab.HOME;
        }
        if ((i & 2) != 0) {
            panelAction = StoreNavigation.PanelAction.CLOSE;
        }
        widgetGlobalSearch.onSelected(navigationTab, panelAction);
    }

    @SuppressLint({"SetTextI18n"})
    @MainThread
    private final void setSearchPrefix(String prefix) {
        CharSequence charSequenceReplace;
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ViewExtensions.getTextOrEmpty(textInputLayout));
        if (spannableStringBuilder.length() == 0) {
            charSequenceReplace = prefix + ((Object) spannableStringBuilder);
        } else {
            char cFirst = _Strings.first(spannableStringBuilder);
            if (cFirst == '!' || cFirst == '#' || cFirst == '*' || cFirst == '@') {
                charSequenceReplace = spannableStringBuilder.replace(0, 1, (CharSequence) prefix);
            } else {
                charSequenceReplace = prefix + ((Object) spannableStringBuilder);
            }
        }
        Intrinsics3.checkNotNullExpressionValue(charSequenceReplace, "newQuery");
        if (!StringsJVM.isBlank(charSequenceReplace)) {
            TextInputLayout textInputLayout2 = getBinding().c;
            ViewExtensions.setText(textInputLayout2, charSequenceReplace);
            textInputLayout2.post(new WidgetGlobalSearch5(textInputLayout2));
        }
    }

    private final void showFilterPickerDialog() {
        Tuples2[] tuples2ArrAccess$getFILTER_OPTIONS_LIST$p = Companion.access$getFILTER_OPTIONS_LIST$p(INSTANCE);
        ArrayList arrayList = new ArrayList(tuples2ArrAccess$getFILTER_OPTIONS_LIST$p.length);
        for (Tuples2 tuples2 : tuples2ArrAccess$getFILTER_OPTIONS_LIST$p) {
            arrayList.add(getString(((Number) tuples2.component1()).intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        SelectorDialog.Companion companion = SelectorDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(R.string.filter_options);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.filter_options)");
        companion.a(parentFragmentManager, string, (String[]) array, new AnonymousClass1());
    }

    public final void onDismiss() {
        hideKeyboard(getBinding().c);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        String string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.globalSearchRecycler");
        this.resultsAdapter = (WidgetGlobalSearchAdapter) companion.configure(new WidgetGlobalSearchAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.globalSearchGuildList");
        this.guildsAdapter = (WidgetGlobalSearchGuildsAdapter) companion.configure(new WidgetGlobalSearchGuildsAdapter(recyclerView2, ColorCompat.getThemedColor(view, R.attr.primary_630)));
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(EXTRA_SEARCH_TEXT)) != null) {
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.globalSearchBar");
            ViewExtensions.setText(textInputLayout2, string);
            TextInputLayout textInputLayout3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.globalSearchBar");
            ViewExtensions.setSelectionEnd(textInputLayout3);
        }
        getBinding().c.setEndIconOnClickListener(new AnonymousClass3());
        getBinding().c.setStartIconOnClickListener(new AnonymousClass4());
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(scalarSynchronousObservable, this, null, 2, null), WidgetGlobalSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
        getBinding().f2403b.setOnClickListener(new AnonymousClass6());
        getBinding().f.setOnClickListener(new AnonymousClass7());
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView3 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.globalSearchRecycler");
            recyclerView3.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable<WidgetGlobalSearchModel> forNav = companion.getForNav(behaviorSubject);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(forNav, this, widgetGlobalSearchAdapter), WidgetGlobalSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        BehaviorSubject<String> behaviorSubject2 = this.filterPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject2, "filterPublisher");
        StoreGuilds.Actions.requestMembers(this, behaviorSubject2, false);
    }
}

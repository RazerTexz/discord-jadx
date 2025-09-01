package com.discord.widgets.hubs.events;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubEventsPageBinding;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubEventsPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b2\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\u00020\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u00020\"8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsPage;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "state", "", "configUI", "(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "listener", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "getListener", "()Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "Lcom/discord/widgets/hubs/events/HubEventsArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/hubs/events/HubEventsArgs;", "args", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetHubEventsPageBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetHubEventsPageBinding;", "binding", "Lcom/discord/widgets/hubs/events/WidgetHubEventsViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/hubs/events/WidgetHubEventsViewModel;", "viewModel", "Lcom/discord/widgets/hubs/events/WidgetHubEventsPageAdapter;", "adapter$delegate", "getAdapter", "()Lcom/discord/widgets/hubs/events/WidgetHubEventsPageAdapter;", "adapter", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubEventsPage extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubEventsPage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final WidgetHubEventsPage3 listener;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubEventsPage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsPage$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "directoryChannelId", "", "show", "(Landroidx/fragment/app/FragmentManager;JJ)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long directoryChannelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetHubEventsPage widgetHubEventsPage = new WidgetHubEventsPage();
            widgetHubEventsPage.setArguments(AnimatableValueParser.e2(new WidgetHubEventsPage2(guildId, directoryChannelId)));
            widgetHubEventsPage.show(fragmentManager, WidgetHubEventsPage.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubEventsPage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/utilities/Success;", "", "Lcom/discord/api/directory/DirectoryEntryEvent;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$configUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RestCallState6<? extends List<? extends DirectoryEntryGuild2>>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends List<? extends DirectoryEntryGuild2>> restCallState6) {
            invoke2((RestCallState6<? extends List<DirectoryEntryGuild2>>) restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<? extends List<DirectoryEntryGuild2>> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            WidgetHubEventsPage.this.getBinding().f2477b.smoothScrollToPosition(0);
            WidgetHubEventsPage.this.getViewModel().reset();
        }
    }

    /* compiled from: WidgetHubEventsPage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "p1", "", "invoke", "(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubEventsViewModel3, Unit> {
        public AnonymousClass1(WidgetHubEventsPage widgetHubEventsPage) {
            super(1, widgetHubEventsPage, WidgetHubEventsPage.class, "configUI", "configUI(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            invoke2(widgetHubEventsViewModel3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel3, "p1");
            WidgetHubEventsPage.access$configUI((WidgetHubEventsPage) this.receiver, widgetHubEventsViewModel3);
        }
    }

    public WidgetHubEventsPage() {
        super(false, 1, null);
        this.args = LazyJVM.lazy(new WidgetHubEventsPage$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubEventsPage5.INSTANCE, null, 2, null);
        WidgetHubEventsPage9 widgetHubEventsPage9 = new WidgetHubEventsPage9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubEventsViewModel.class), new WidgetHubEventsPage$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubEventsPage9));
        this.listener = new WidgetHubEventsPage6(this);
        this.adapter = LazyJVM.lazy(new WidgetHubEventsPage4(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubEventsPage8(this), 3);
    }

    public static final /* synthetic */ void access$configUI(WidgetHubEventsPage widgetHubEventsPage, WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
        widgetHubEventsPage.configUI(widgetHubEventsViewModel3);
    }

    private final void configUI(WidgetHubEventsViewModel3 state) {
        if (!state.getEventsData().isEmpty() || (state.getEventsAsync() instanceof RestCallState6)) {
            WidgetHubEventsPageAdapter adapter = getAdapter();
            WidgetHubEventsPageAdapter2.Header header = WidgetHubEventsPageAdapter2.Header.INSTANCE;
            if (!state.getShowHeader()) {
                header = null;
            }
            List listListOfNotNull = Collections2.listOfNotNull(header);
            List<WidgetHubEventsViewModel2> eventsData = state.getEventsData();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(eventsData, 10));
            Iterator<T> it = eventsData.iterator();
            while (it.hasNext()) {
                arrayList.add(new WidgetHubEventsPageAdapter2.Event((WidgetHubEventsViewModel2) it.next()));
            }
            adapter.setItems(_Collections.plus((Collection<? extends WidgetHubEventsPageAdapter2.Footer>) _Collections.plus((Collection) listListOfNotNull, (Iterable) arrayList), new WidgetHubEventsPageAdapter2.Footer(state.getEventsAsync())));
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
            Context context = getContext();
            textView.setText(context != null ? StringResourceUtils.getI18nPluralString(context, R.plurals.guild_events_plural_number, state.getEventsData().size(), Integer.valueOf(state.getEventsData().size())) : null);
            RestCallState<List<DirectoryEntryGuild2>> eventsAsync = state.getEventsAsync();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            RestCallState5.handleResponse$default(eventsAsync, contextRequireContext, null, null, new AnonymousClass3(), 6, null);
        }
    }

    public final WidgetHubEventsPageAdapter getAdapter() {
        return (WidgetHubEventsPageAdapter) this.adapter.getValue();
    }

    public final WidgetHubEventsPage2 getArgs() {
        return (WidgetHubEventsPage2) this.args.getValue();
    }

    public final WidgetHubEventsPageBinding getBinding() {
        return (WidgetHubEventsPageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_hub_events_page;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubEventsViewModel getViewModel() {
        return (WidgetHubEventsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubEventsPage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f2477b;
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}

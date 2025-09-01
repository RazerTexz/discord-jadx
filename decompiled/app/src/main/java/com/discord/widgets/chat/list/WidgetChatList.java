package com.discord.widgets.chat.list;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatListBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action0;

/* compiled from: WidgetChatList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u0004*\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\rJ\r\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/widgets/chat/list/WidgetChatList;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "chatData", "", "configureUI", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModel;)V", "", "Lcom/discord/primitives/MessageId;", "messageId", "scrollTo", "(J)V", "createAdapter", "()V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "addThreadSpineItemDecoration", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "configureExistingAdapter", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onPause", "disableItemAnimations", "enableItemAnimations", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel$delegate", "Lkotlin/Lazy;", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "defaultItemAnimator", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "Lcom/discord/databinding/WidgetChatListBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChatListBinding;", "binding", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatList extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListBinding;", 0)};
    private WidgetChatListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RecyclerView.ItemAnimator defaultItemAnimator;

    /* renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;

    /* compiled from: WidgetChatList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.WidgetChatList$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetChatListModel, Unit> {
        public AnonymousClass1(WidgetChatList widgetChatList) {
            super(1, widgetChatList, WidgetChatList.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/model/WidgetChatListModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListModel widgetChatListModel) {
            invoke2(widgetChatListModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChatListModel widgetChatListModel) {
            WidgetChatList.access$configureUI((WidgetChatList) this.receiver, widgetChatListModel);
        }
    }

    /* compiled from: WidgetChatList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/MessageId;", "p1", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.WidgetChatList$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass2(WidgetChatList widgetChatList) {
            super(1, widgetChatList, WidgetChatList.class, "scrollTo", "scrollTo(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatList.access$scrollTo((WidgetChatList) this.receiver, j);
        }
    }

    public WidgetChatList() {
        super(R.layout.widget_chat_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetChatList2.INSTANCE, new WidgetChatList3(this));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatList$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetChatList4(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatList widgetChatList, WidgetChatListModel widgetChatListModel) {
        widgetChatList.configureUI(widgetChatListModel);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatList widgetChatList) {
        return widgetChatList.adapter;
    }

    public static final /* synthetic */ void access$scrollTo(WidgetChatList widgetChatList, long j) {
        widgetChatList.scrollTo(j);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetChatList widgetChatList, WidgetChatListAdapter widgetChatListAdapter) {
        widgetChatList.adapter = widgetChatListAdapter;
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f2343b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureExistingAdapter(WidgetChatListAdapter widgetChatListAdapter) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChatListAdapter.setFragmentManager(parentFragmentManager);
        RecyclerView recyclerView = getBinding().f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        widgetChatListAdapter.setRecycler(recyclerView);
        LinearLayoutManager layoutManager = ((WidgetChatListAdapter) MGRecyclerAdapter.INSTANCE.configure(widgetChatListAdapter)).getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setReverseLayout(true);
        }
    }

    private final void configureUI(WidgetChatListModel chatData) {
        RecyclerView recyclerView = getBinding().f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setVisibility(chatData != null ? 0 : 8);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter == null || chatData == null || widgetChatListAdapter == null) {
            return;
        }
        widgetChatListAdapter.setData(chatData);
    }

    private final void createAdapter() {
        RecyclerView recyclerView = getBinding().f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new WidgetChatListAdapterEventsHandler(this, getFlexInputViewModel(), null, null, null, null, null, null, null, null, null, null, 4092, null), getFlexInputViewModel(), ClockFactory.get());
        MGRecyclerAdapter.INSTANCE.configure(widgetChatListAdapter);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        LinearLayoutManager layoutManager = widgetChatListAdapter.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setReverseLayout(true);
        }
        widgetChatListAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        this.adapter = widgetChatListAdapter;
    }

    private final WidgetChatListBinding getBinding() {
        return (WidgetChatListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final void scrollTo(long messageId) {
        WidgetChatList6 widgetChatList6 = WidgetChatList6.INSTANCE;
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        Object widgetChatList5 = widgetChatList6;
        if (widgetChatListAdapter == null) {
            widgetChatList6.invoke();
        } else if (widgetChatListAdapter != null) {
            if (widgetChatList6 != null) {
                widgetChatList5 = new WidgetChatList5(widgetChatList6);
            }
            widgetChatListAdapter.scrollToMessageId(messageId, (Action0) widgetChatList5);
        }
    }

    public final void disableItemAnimations() {
        RecyclerView recyclerView = getBinding().f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setItemAnimator(null);
    }

    public final void enableItemAnimations() {
        RecyclerView recyclerView = getBinding().f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setItemAnimator(this.defaultItemAnimator);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.onPause();
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.adapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.disposeHandlers();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            configureExistingAdapter(widgetChatListAdapter);
        } else {
            createAdapter();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.adapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.onResume();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(WidgetChatListModel.INSTANCE.get()), this, this.adapter), WidgetChatList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getMessagesLoader().getScrollTo(), this, null, 2, null), WidgetChatList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        RecyclerView recyclerView = getBinding().f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        this.defaultItemAnimator = recyclerView.getItemAnimator();
    }
}

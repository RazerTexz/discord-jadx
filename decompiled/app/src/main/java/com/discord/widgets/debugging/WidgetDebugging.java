package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDebuggingAdapterItemBinding;
import com.discord.databinding.WidgetDebuggingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetDebugging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001d\u001c\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR:\u0010\u0010\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\r0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/debugging/WidgetDebugging;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/debugging/WidgetDebugging$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "filterSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/databinding/WidgetDebuggingBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetDebuggingBinding;", "binding", "Lcom/discord/widgets/debugging/WidgetDebugging$Adapter;", "logsAdapter", "Lcom/discord/widgets/debugging/WidgetDebugging$Adapter;", "<init>", "Companion", "Adapter", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDebugging extends AppFragment {
    private static final int COLLAPSED_MAX_LINES = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Boolean> filterSubject;
    private Adapter logsAdapter;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDebugging.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDebuggingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/debugging/WidgetDebugging$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/app/AppLog$LoggedItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItem", "(I)Lcom/discord/app/AppLog$LoggedItem;", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<AppLog.LoggedItem> {

        /* compiled from: WidgetDebugging.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/app/AppLog$LoggedItem;", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(Ljava/util/List;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function2<List<? extends AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>, Unit> {
            public final /* synthetic */ RecyclerView $recycler;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RecyclerView recyclerView) {
                super(2);
                this.$recycler = recyclerView;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AppLog.LoggedItem> list, List<? extends AppLog.LoggedItem> list2) {
                invoke2((List<AppLog.LoggedItem>) list, (List<AppLog.LoggedItem>) list2);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
                Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
                RecyclerView.LayoutManager layoutManager = this.$recycler.getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                    this.$recycler.scrollToPosition(0);
                }
            }
        }

        /* compiled from: WidgetDebugging.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0015¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/debugging/WidgetDebugging$Adapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/debugging/WidgetDebugging$Adapter;", "Lcom/discord/app/AppLog$LoggedItem;", "Landroid/content/Context;", "context", "", "priority", "getColor", "(Landroid/content/Context;I)I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/app/AppLog$LoggedItem;)V", "Lcom/discord/databinding/WidgetDebuggingAdapterItemBinding;", "binding", "Lcom/discord/databinding/WidgetDebuggingAdapterItemBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/debugging/WidgetDebugging$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Item extends MGRecyclerViewHolder<Adapter, AppLog.LoggedItem> {
            private final WidgetDebuggingAdapterItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.log_message);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.log_message)));
                }
                WidgetDebuggingAdapterItemBinding widgetDebuggingAdapterItemBinding = new WidgetDebuggingAdapterItemBinding((LinearLayout) view, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetDebuggingAdapterItemBinding, "WidgetDebuggingAdapterItemBinding.bind(itemView)");
                this.binding = widgetDebuggingAdapterItemBinding;
            }

            public static final /* synthetic */ WidgetDebuggingAdapterItemBinding access$getBinding$p(Item item) {
                return item.binding;
            }

            @ColorInt
            private final int getColor(Context context, int priority) {
                return priority != 2 ? priority != 3 ? priority != 5 ? priority != 6 ? ColorCompat.getThemedColor(context, R.attr.primary_100) : ColorCompat.getColor(context, R.color.status_red_500) : ColorCompat.getColor(context, R.color.status_yellow_500) : ColorCompat.getColor(context, R.color.status_green_600) : ColorCompat.getThemedColor(context, R.attr.primary_300);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, AppLog.LoggedItem loggedItem) {
                onConfigure2(i, loggedItem);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
            @SuppressLint({"SetTextI18n"})
            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onConfigure2(int position, AppLog.LoggedItem data) {
                String string;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                TextView textView = this.binding.f2361b;
                textView.setTextColor(getColor(outline.I(textView, "binding.logMessage", "binding.logMessage.context"), data.priority));
                TextView textView2 = this.binding.f2361b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.logMessage");
                StringBuilder sb = new StringBuilder();
                sb.append(data.message);
                Throwable th = data.throwable;
                if (th != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('\n');
                    sb2.append(th);
                    string = sb2.toString();
                    if (string == null) {
                        string = "";
                    }
                }
                sb.append(string);
                textView2.setText(sb.toString());
                TextView textView3 = this.binding.f2361b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.logMessage");
                textView3.setMaxLines(2);
                LinearLayout linearLayout = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(linearLayout, new WidgetDebugging2(this));
                this.itemView.setOnClickListener(new WidgetDebugging3(this));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            setOnUpdated(new AnonymousClass1(recyclerView));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public /* bridge */ /* synthetic */ MGRecyclerDataPayload getItem(int i) {
            return getItem(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, AppLog.LoggedItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new Item(R.layout.widget_debugging_adapter_item, this);
            }
            throw invalidViewTypeException(viewType);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
        public AppLog.LoggedItem getItem(int position) {
            return getInternalData().get((getInternalData().size() - 1) - position);
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/debugging/WidgetDebugging$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "", "COLLAPSED_MAX_LINES", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetDebugging.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\n\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/debugging/WidgetDebugging$Model;", "", "", "Lcom/discord/app/AppLog$LoggedItem;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "logs", "isFiltered", "copy", "(Ljava/util/List;Z)Lcom/discord/widgets/debugging/WidgetDebugging$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getLogs", "Z", "<init>", "(Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {
        private final boolean isFiltered;
        private final List<AppLog.LoggedItem> logs;

        public Model(List<AppLog.LoggedItem> list, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "logs");
            this.logs = list;
            this.isFiltered = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.logs;
            }
            if ((i & 2) != 0) {
                z2 = model.isFiltered;
            }
            return model.copy(list, z2);
        }

        public final List<AppLog.LoggedItem> component1() {
            return this.logs;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsFiltered() {
            return this.isFiltered;
        }

        public final Model copy(List<AppLog.LoggedItem> logs, boolean isFiltered) {
            Intrinsics3.checkNotNullParameter(logs, "logs");
            return new Model(logs, isFiltered);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.logs, model.logs) && this.isFiltered == model.isFiltered;
        }

        public final List<AppLog.LoggedItem> getLogs() {
            return this.logs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<AppLog.LoggedItem> list = this.logs;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.isFiltered;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isFiltered() {
            return this.isFiltered;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(logs=");
            sbU.append(this.logs);
            sbU.append(", isFiltered=");
            return outline.O(sbU, this.isFiltered, ")");
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_debugging_filter) {
                return;
            }
            boolean z2 = !menuItem.isChecked();
            menuItem.setChecked(z2);
            WidgetDebugging.access$getFilterSubject$p(WidgetDebugging.this).onNext(Boolean.valueOf(z2));
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_debugging_filter);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_debugging_filter)");
            menuItemFindItem.setChecked(this.$model.isFiltered());
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/app/AppLog$LoggedItem;", "kotlin.jvm.PlatformType", "", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<AppLog.LoggedItem>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<AppLog.LoggedItem> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<AppLog.LoggedItem> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/app/AppLog$LoggedItem;", "kotlin.jvm.PlatformType", "existingLogs", "", "newLogs", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends AppLog.LoggedItem>, List<AppLog.LoggedItem>, List<? extends AppLog.LoggedItem>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends AppLog.LoggedItem> call(List<? extends AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
            return call2((List<AppLog.LoggedItem>) list, list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<AppLog.LoggedItem> call2(List<AppLog.LoggedItem> list, List<AppLog.LoggedItem> list2) {
            Intrinsics3.checkNotNullExpressionValue(list, "existingLogs");
            Intrinsics3.checkNotNullExpressionValue(list2, "newLogs");
            return _Collections.plus((Collection) list, (Iterable) list2);
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/app/AppLog$LoggedItem;", "kotlin.jvm.PlatformType", "logs", "", "isFiltered", "Lcom/discord/widgets/debugging/WidgetDebugging$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/discord/widgets/debugging/WidgetDebugging$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, R> implements Func2<List<? extends AppLog.LoggedItem>, Boolean, Model> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Model call(List<? extends AppLog.LoggedItem> list, Boolean bool) {
            return call2((List<AppLog.LoggedItem>) list, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Model call2(List<AppLog.LoggedItem> list, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isFiltered");
            if (bool.booleanValue()) {
                ArrayList arrayListA0 = outline.a0(list, "logs");
                for (Object obj : list) {
                    if (((AppLog.LoggedItem) obj).priority > 2) {
                        arrayListA0.add(obj);
                    }
                }
                list = arrayListA0;
            }
            Intrinsics3.checkNotNullExpressionValue(list, "filteredLogs");
            return new Model(list, bool.booleanValue());
        }
    }

    /* compiled from: WidgetDebugging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/debugging/WidgetDebugging$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.debugging.WidgetDebugging$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass4(WidgetDebugging widgetDebugging) {
            super(1, widgetDebugging, WidgetDebugging.class, "configureUI", "configureUI(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetDebugging.access$configureUI((WidgetDebugging) this.receiver, model);
        }
    }

    public WidgetDebugging() {
        super(R.layout.widget_debugging);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDebugging4.INSTANCE, null, 2, null);
        this.filterSubject = BehaviorSubject.l0(Boolean.TRUE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetDebugging widgetDebugging, Model model) {
        widgetDebugging.configureUI(model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterSubject$p(WidgetDebugging widgetDebugging) {
        return widgetDebugging.filterSubject;
    }

    private final void configureUI(Model model) {
        Adapter adapter = this.logsAdapter;
        if (adapter != null) {
            adapter.setData(model.getLogs());
        }
        setActionBarOptionsMenu(R.menu.menu_debugging, new AnonymousClass1(), new AnonymousClass2(model));
    }

    private final WidgetDebuggingBinding getBinding() {
        return (WidgetDebuggingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2362b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.debuggingLogs");
        this.logsAdapter = (Adapter) companion.configure(new Adapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f2362b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.debuggingLogs");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.debug);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Objects.requireNonNull(AppLog.g);
        Observable observableR = ObservableExtensionsKt.computationBuffered(AppLog.logsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "logsSubject\n          .c…  .distinctUntilChanged()");
        Observable observableJ = Observable.j(observableR.a(200L, TimeUnit.MILLISECONDS).y(AnonymousClass1.INSTANCE).Q(new ArrayList(), AnonymousClass2.INSTANCE), this.filterSubject.r(), AnonymousClass3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…gs, isFiltered)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableJ), this, null, 2, null), WidgetDebugging.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(this), 62, (Object) null);
    }
}

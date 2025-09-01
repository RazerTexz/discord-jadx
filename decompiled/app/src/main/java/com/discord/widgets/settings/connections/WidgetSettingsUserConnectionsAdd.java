package com.discord.widgets.settings.connections;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsConnectionsAddBinding;
import com.discord.databinding.WidgetSettingsItemAddConnectedAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.playstation.PlaystationExperimentUtils;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsUserConnectionsAdd.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0003\u0019\u0018\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "()V", "Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", "binding", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Adapter;", "adapter", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Adapter;", "<init>", "Companion", "Adapter", "PlatformItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsUserConnectionsAdd.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsUserConnectionsAdd.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$PlatformItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function0;", "", "dialogDismissCallback", "Lkotlin/jvm/functions/Function0;", "getDialogDismissCallback", "()Lkotlin/jvm/functions/Function0;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;)V", "ViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<PlatformItem> {
        private final Function0<Unit> dialogDismissCallback;

        /* compiled from: WidgetSettingsUserConnectionsAdd.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Adapter;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$PlatformItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$PlatformItem;)V", "Lcom/discord/databinding/WidgetSettingsItemAddConnectedAccountBinding;", "binding", "Lcom/discord/databinding/WidgetSettingsItemAddConnectedAccountBinding;", "Lkotlin/Function0;", "dialogDismissCallback", "Lkotlin/jvm/functions/Function0;", "getDialogDismissCallback", "()Lkotlin/jvm/functions/Function0;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Adapter;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ViewHolder extends MGRecyclerViewHolder<Adapter, PlatformItem> {
            private final WidgetSettingsItemAddConnectedAccountBinding binding;
            private final Function0<Unit> dialogDismissCallback;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    Platform.values();
                    int[] iArr = new int[15];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[Platform.XBOX.ordinal()] = 1;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@LayoutRes int i, Adapter adapter, Function0<Unit> function0) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                Intrinsics3.checkNotNullParameter(function0, "dialogDismissCallback");
                this.dialogDismissCallback = function0;
                View view = this.itemView;
                int i2 = R.id.add_connected_account_image;
                ImageView imageView = (ImageView) view.findViewById(R.id.add_connected_account_image);
                if (imageView != null) {
                    i2 = R.id.add_connected_account_text;
                    TextView textView = (TextView) view.findViewById(R.id.add_connected_account_text);
                    if (textView != null) {
                        WidgetSettingsItemAddConnectedAccountBinding widgetSettingsItemAddConnectedAccountBinding = new WidgetSettingsItemAddConnectedAccountBinding((LinearLayout) view, imageView, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemAddConnectedAccountBinding, "WidgetSettingsItemAddCon…untBinding.bind(itemView)");
                        this.binding = widgetSettingsItemAddConnectedAccountBinding;
                        return;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public final Function0<Unit> getDialogDismissCallback() {
                return this.dialogDismissCallback;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, PlatformItem platformItem) {
                onConfigure2(i, platformItem);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, PlatformItem data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.addConnectedAccountText");
                textView.setText(data.getPlatform().getProperName());
                ImageView imageView = this.binding.f2622b;
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Integer themedPlatformImage = data.getPlatform().getThemedPlatformImage();
                imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(view, themedPlatformImage != null ? themedPlatformImage.intValue() : 0, 0, 2, (Object) null));
                this.itemView.setOnClickListener(new WidgetSettingsUserConnectionsAdd2(this, data));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, Function0<Unit> function0) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics3.checkNotNullParameter(function0, "dialogDismissCallback");
            this.dialogDismissCallback = function0;
        }

        public final Function0<Unit> getDialogDismissCallback() {
            return this.dialogDismissCallback;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, PlatformItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ViewHolder(R.layout.widget_settings_item_add_connected_account, this, this.dialogDismissCallback);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAdd.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "show", "(Landroidx/fragment/app/Fragment;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetSettingsUserConnectionsAdd widgetSettingsUserConnectionsAdd = new WidgetSettingsUserConnectionsAdd();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetSettingsUserConnectionsAdd.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAdd.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$PlatformItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/utilities/platform/Platform;", "component1", "()Lcom/discord/utilities/platform/Platform;", "platform", "copy", "(Lcom/discord/utilities/platform/Platform;)Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsAdd$PlatformItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/utilities/platform/Platform;", "getPlatform", "<init>", "(Lcom/discord/utilities/platform/Platform;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PlatformItem implements MGRecyclerDataPayload {
        private final String key;
        private final Platform platform;
        private final int type;

        public PlatformItem(Platform platform) {
            Intrinsics3.checkNotNullParameter(platform, "platform");
            this.platform = platform;
            this.key = platform.name();
        }

        public static /* synthetic */ PlatformItem copy$default(PlatformItem platformItem, Platform platform, int i, Object obj) {
            if ((i & 1) != 0) {
                platform = platformItem.platform;
            }
            return platformItem.copy(platform);
        }

        /* renamed from: component1, reason: from getter */
        public final Platform getPlatform() {
            return this.platform;
        }

        public final PlatformItem copy(Platform platform) {
            Intrinsics3.checkNotNullParameter(platform, "platform");
            return new PlatformItem(platform);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PlatformItem) && Intrinsics3.areEqual(this.platform, ((PlatformItem) other).platform);
            }
            return true;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Platform getPlatform() {
            return this.platform;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Platform platform = this.platform;
            if (platform != null) {
                return platform.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PlatformItem(platform=");
            sbU.append(this.platform);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAdd.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd$onViewCreated$1, reason: invalid class name */
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
            Dialog dialog = WidgetSettingsUserConnectionsAdd.this.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public WidgetSettingsUserConnectionsAdd() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsUserConnectionsAdd3.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsConnectionsAddBinding getBinding() {
        return (WidgetSettingsConnectionsAddBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_settings_connections_add;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        hideKeyboard(getView());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        boolean zCanSeePlaystationAccountIntegration = PlaystationExperimentUtils.canSeePlaystationAccountIntegration(StoreStream.INSTANCE.getExperiments());
        Platform[] platformArrValues = Platform.values();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            Platform platform = platformArrValues[i];
            if (platform.getEnabled() && (platform != Platform.PLAYSTATION || zCanSeePlaystationAccountIntegration)) {
                arrayList.add(platform);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PlatformItem((Platform) it.next()));
        }
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2613b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
        Adapter adapter = (Adapter) companion.configure(new Adapter(recyclerView, new AnonymousClass1()));
        this.adapter = adapter;
        if (adapter != null) {
            adapter.setData(arrayList2);
        }
    }
}

package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.databinding.ThreadBrowserItemHeaderBinding;
import com.discord.databinding.ThreadBrowserItemThreadBinding;
import com.discord.databinding.ThreadBrowserItemWarningBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetThreadBrowserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0018\u0019\u001a\u001b\u001c\u001dB7\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0010\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/api/channel/Channel;", "channel", "", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "onThreadLongClicked", "Lkotlin/Function1;", "onOpenThread", "Lkotlin/jvm/functions/Function1;", "onThreadSettings", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "HeaderItem", "Item", "ItemType", "LoadingItem", "ThreadItem", "WarningItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter extends MGRecyclerAdapterSimple<Item> {
    private final Function1<Channel, Unit> onOpenThread;
    private final Function1<Channel, Unit> onThreadSettings;

    /* compiled from: WidgetThreadBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$HeaderItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;)V", "Lcom/discord/databinding/ThreadBrowserItemHeaderBinding;", "binding", "Lcom/discord/databinding/ThreadBrowserItemHeaderBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        private final ThreadBrowserItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_header, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.header_name);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.header_name)));
            }
            ThreadBrowserItemHeaderBinding threadBrowserItemHeaderBinding = new ThreadBrowserItemHeaderBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(threadBrowserItemHeaderBinding, "ThreadBrowserItemHeaderBinding.bind(itemView)");
            this.binding = threadBrowserItemHeaderBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            Item.Header header = (Item.Header) data;
            TextView textView = this.binding.f2158b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.headerName");
            textView.setText(FormatUtils.h(((WidgetThreadBrowserAdapter) this.adapter).getContext(), header.getStringResId(), new Object[]{Integer.valueOf(header.getCount())}, null, 4).toString());
        }
    }

    /* compiled from: WidgetThreadBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", Traits.Location.Section.HEADER, "Loading", "Thread", "Warning", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Warning;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Thread;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Header;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Loading;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {

        /* compiled from: WidgetThreadBrowserAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Header;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "key", "stringResId", "count", "copy", "(Ljava/lang/String;II)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Header;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCount", "type", "getType", "Ljava/lang/String;", "getKey", "getStringResId", "<init>", "(Ljava/lang/String;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Header extends Item {
            private final int count;
            private final String key;
            private final int stringResId;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Header(String str, int i, int i2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "key");
                this.key = str;
                this.stringResId = i;
                this.count = i2;
                this.type = ItemType.HEADER.ordinal();
            }

            public static /* synthetic */ Header copy$default(Header header, String str, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = header.getKey();
                }
                if ((i3 & 2) != 0) {
                    i = header.stringResId;
                }
                if ((i3 & 4) != 0) {
                    i2 = header.count;
                }
                return header.copy(str, i, i2);
            }

            public final String component1() {
                return getKey();
            }

            /* renamed from: component2, reason: from getter */
            public final int getStringResId() {
                return this.stringResId;
            }

            /* renamed from: component3, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final Header copy(String key, int stringResId, int count) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Header(key, stringResId, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return Intrinsics3.areEqual(getKey(), header.getKey()) && this.stringResId == header.stringResId && this.count == header.count;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getStringResId() {
                return this.stringResId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String key = getKey();
                return ((((key != null ? key.hashCode() : 0) * 31) + this.stringResId) * 31) + this.count;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Header(key=");
                sbU.append(getKey());
                sbU.append(", stringResId=");
                sbU.append(this.stringResId);
                sbU.append(", count=");
                return outline.B(sbU, this.count, ")");
            }
        }

        /* compiled from: WidgetThreadBrowserAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Loading;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "", "component1", "()Ljava/lang/String;", "key", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Loading;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Ljava/lang/String;", "getKey", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loading extends Item {
            private final String key;
            private final int type;

            public Loading() {
                this(null, 1, null);
            }

            public /* synthetic */ Loading(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "loading" : str);
            }

            public static /* synthetic */ Loading copy$default(Loading loading, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loading.getKey();
                }
                return loading.copy(str);
            }

            public final String component1() {
                return getKey();
            }

            public final Loading copy(String key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Loading(key);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loading) && Intrinsics3.areEqual(getKey(), ((Loading) other).getKey());
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String key = getKey();
                if (key != null) {
                    return key.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loading(key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "key");
                this.key = str;
                this.type = ItemType.LOADING.ordinal();
            }
        }

        /* compiled from: WidgetThreadBrowserAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Thread;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "component1", "()Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "threadData", "copy", "(Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Thread;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "getThreadData", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "<init>", "(Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Thread extends Item {
            private final String key;
            private final ThreadBrowserThreadView.ThreadData threadData;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Thread(ThreadBrowserThreadView.ThreadData threadData) {
                super(null);
                Intrinsics3.checkNotNullParameter(threadData, "threadData");
                this.threadData = threadData;
                this.type = ItemType.THREAD.ordinal();
                this.key = String.valueOf(threadData.getChannel().getId());
            }

            public static /* synthetic */ Thread copy$default(Thread thread, ThreadBrowserThreadView.ThreadData threadData, int i, Object obj) {
                if ((i & 1) != 0) {
                    threadData = thread.threadData;
                }
                return thread.copy(threadData);
            }

            /* renamed from: component1, reason: from getter */
            public final ThreadBrowserThreadView.ThreadData getThreadData() {
                return this.threadData;
            }

            public final Thread copy(ThreadBrowserThreadView.ThreadData threadData) {
                Intrinsics3.checkNotNullParameter(threadData, "threadData");
                return new Thread(threadData);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Thread) && Intrinsics3.areEqual(this.threadData, ((Thread) other).threadData);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final ThreadBrowserThreadView.ThreadData getThreadData() {
                return this.threadData;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ThreadBrowserThreadView.ThreadData threadData = this.threadData;
                if (threadData != null) {
                    return threadData.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Thread(threadData=");
                sbU.append(this.threadData);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetThreadBrowserAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Warning;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "", "component1", "()Ljava/lang/String;", "key", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item$Warning;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKey", "type", "I", "getType", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Warning extends Item {
            private final String key;
            private final int type;

            public Warning() {
                this(null, 1, null);
            }

            public /* synthetic */ Warning(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "warning" : str);
            }

            public static /* synthetic */ Warning copy$default(Warning warning, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = warning.getKey();
                }
                return warning.copy(str);
            }

            public final String component1() {
                return getKey();
            }

            public final Warning copy(String key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Warning(key);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Warning) && Intrinsics3.areEqual(getKey(), ((Warning) other).getKey());
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String key = getKey();
                if (key != null) {
                    return key.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Warning(key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Warning(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "key");
                this.key = str;
                this.type = ItemType.WARNING.ordinal();
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$ItemType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "WARNING", "THREAD", "HEADER", "LOADING", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum ItemType {
        WARNING,
        THREAD,
        HEADER,
        LOADING;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ItemType[] cachedValues = values();

        /* compiled from: WidgetThreadBrowserAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$ItemType$Companion;", "", "", "ordinal", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$ItemType;", "fromOrdinal", "(I)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$ItemType;", "", "cachedValues", "[Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$ItemType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ItemType fromOrdinal(int ordinal) {
                return ItemType.access$getCachedValues$cp()[ordinal];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final /* synthetic */ ItemType[] access$getCachedValues$cp() {
            return cachedValues;
        }
    }

    /* compiled from: WidgetThreadBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$LoadingItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "adapter", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_loading, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
        }
    }

    /* compiled from: WidgetThreadBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$ThreadItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;)V", "Lcom/discord/databinding/ThreadBrowserItemThreadBinding;", "binding", "Lcom/discord/databinding/ThreadBrowserItemThreadBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ThreadItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        private final ThreadBrowserItemThreadBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThreadItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_thread, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            ThreadBrowserThreadView threadBrowserThreadView = (ThreadBrowserThreadView) view;
            ThreadBrowserItemThreadBinding threadBrowserItemThreadBinding = new ThreadBrowserItemThreadBinding(threadBrowserThreadView, threadBrowserThreadView);
            Intrinsics3.checkNotNullExpressionValue(threadBrowserItemThreadBinding, "ThreadBrowserItemThreadBinding.bind(itemView)");
            this.binding = threadBrowserItemThreadBinding;
        }

        public static final /* synthetic */ WidgetThreadBrowserAdapter access$getAdapter$p(ThreadItem threadItem) {
            return (WidgetThreadBrowserAdapter) threadItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            Item.Thread thread = (Item.Thread) data;
            this.binding.f2159b.setThreadData(thread.getThreadData());
            this.binding.f2159b.setOnClickListener(new WidgetThreadBrowserAdapter2(this, thread));
            this.binding.f2159b.setOnLongClickListener(new WidgetThreadBrowserAdapter3(this, thread));
        }
    }

    /* compiled from: WidgetThreadBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$WarningItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter$Item;)V", "Lcom/discord/databinding/ThreadBrowserItemWarningBinding;", "binding", "Lcom/discord/databinding/ThreadBrowserItemWarningBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class WarningItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        private final ThreadBrowserItemWarningBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WarningItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_warning, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.warning);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.warning)));
            }
            ThreadBrowserItemWarningBinding threadBrowserItemWarningBinding = new ThreadBrowserItemWarningBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(threadBrowserItemWarningBinding, "ThreadBrowserItemWarningBinding.bind(itemView)");
            this.binding = threadBrowserItemWarningBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2160b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.warning");
            textView.setText(FormatUtils.h(((WidgetThreadBrowserAdapter) this.adapter).getContext(), R.string.forum_android_warning, new Object[0], null, 4).toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[ItemType.WARNING.ordinal()] = 1;
            iArr[ItemType.THREAD.ordinal()] = 2;
            iArr[ItemType.HEADER.ordinal()] = 3;
            iArr[ItemType.LOADING.ordinal()] = 4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function12) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onOpenThread");
        Intrinsics3.checkNotNullParameter(function12, "onThreadSettings");
        this.onOpenThread = function1;
        this.onThreadSettings = function12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onThreadClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.onOpenThread.invoke(channel);
    }

    public final void onThreadLongClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.onThreadSettings.invoke(channel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        int iOrdinal = ItemType.INSTANCE.fromOrdinal(viewType).ordinal();
        if (iOrdinal == 0) {
            return new WarningItem(this);
        }
        if (iOrdinal == 1) {
            return new ThreadItem(this);
        }
        if (iOrdinal == 2) {
            return new HeaderItem(this);
        }
        if (iOrdinal == 3) {
            return new LoadingItem(this);
        }
        throw new NoWhenBranchMatchedException();
    }
}

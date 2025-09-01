package com.discord.widgets.channels.list;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.layoutparams.LayoutParamsExtensions;
import com.discord.utilities.views.ViewCoroutineScope;
import com.google.android.material.appbar.AppBarLayout;
import d0.LazyJVM;
import d0.Result3;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Progressions2;
import kotlin.ranges.Ranges2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WidgetChannelListUnreads.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 92\u00020\u0001:\u00039:;BO\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b7\u00108J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0013\u0010\r\u001a\u00020\f*\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\f*\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListUnreads;", "", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "indicator", "", "indicatorUpwards", "", "onConfigureView", "(Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;Z)V", "handleVisibleRangeUpdate", "()V", "handleClick", "", "getIcon", "(Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;)I", "getText", "", "data", "onDatasetChanged", "(Ljava/util/List;)V", "Lkotlin/Function0;", "getItemCount", "Lkotlin/jvm/functions/Function0;", "unreadsInitialized", "Z", "unreadsResId", "I", "getUnreadsResId", "()I", "setUnreadsResId", "(I)V", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "unreadsEnabled", "getUnreadsEnabled", "()Z", "setUnreadsEnabled", "(Z)V", "Ljava/util/List;", "Landroid/view/ViewStub;", "unreadsStub", "Landroid/view/ViewStub;", "mentionResId", "getMentionResId", "setMentionResId", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/discord/databinding/WidgetChannelsListUnreadsBinding;", "binding$delegate", "Lkotlin/Lazy;", "getBinding", "()Lcom/discord/databinding/WidgetChannelsListUnreadsBinding;", "binding", "<init>", "(Landroid/view/ViewStub;Landroidx/recyclerview/widget/RecyclerView;Lcom/google/android/material/appbar/AppBarLayout;Lkotlin/jvm/functions/Function0;IIZ)V", "Companion", ExifInterface.TAG_MODEL, "UnreadItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListUnreads {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long FADE_DURATION_MS = 150;

    @Deprecated
    private static final int ITEM_OVER_SCROLL_COUNT = 3;
    private final AppBarLayout appBarLayout;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;
    private List<? extends Object> data;
    private final Function0<Integer> getItemCount;
    private int mentionResId;
    private final RecyclerView recycler;
    private boolean unreadsEnabled;
    private boolean unreadsInitialized;
    private int unreadsResId;
    private final ViewStub unreadsStub;

    /* compiled from: WidgetChannelListUnreads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/widgets/channels/list/WidgetChannelListUnreads$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0 || newState == 2) {
                WidgetChannelListUnreads.access$handleVisibleRangeUpdate(WidgetChannelListUnreads.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                WidgetChannelListUnreads.access$handleVisibleRangeUpdate(WidgetChannelListUnreads.this);
            }
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Companion;", "", "", "FADE_DURATION_MS", "J", "", "ITEM_OVER_SCROLL_COUNT", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model;", "", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "component1", "()Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "component2", "topIndicator", "bottomIndicator", "copy", "(Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;)Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "getBottomIndicator", "getTopIndicator", "<init>", "(Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;)V", "Companion", "Indicator", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int INVALID_INDEX = -1;
        public static final int TYPE_MENTION = 0;
        public static final int TYPE_UNREAD = 1;
        private final Indicator bottomIndicator;
        private final Indicator topIndicator;

        /* compiled from: WidgetChannelListUnreads.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000b\u001a\u0004\u0018\u00010\n*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Companion;", "", "", "Lkotlin/ranges/IntRange;", "range", "", "hasUnread", "(Ljava/util/List;Lkotlin/ranges/IntRange;)Z", "Lkotlin/ranges/IntProgression;", "unreadsEnabled", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "findIndicator", "(Ljava/util/List;Lkotlin/ranges/IntProgression;ZZ)Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "visibleRange", "items", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model;", "get", "(Lkotlin/ranges/IntRange;Ljava/util/List;Z)Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model;", "", "INVALID_INDEX", "I", "TYPE_MENTION", "TYPE_UNREAD", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            private final Indicator findIndicator(List<? extends Object> list, Progressions2 progressions2, boolean z2, boolean z3) {
                int i;
                int first = progressions2.getFirst();
                int last = progressions2.getLast();
                int step = progressions2.getStep();
                if (step < 0 ? first >= last : first <= last) {
                    i = -1;
                    while (true) {
                        Object obj = list.get(first);
                        if (!(obj instanceof UnreadItem)) {
                            obj = null;
                        }
                        UnreadItem unreadItem = (UnreadItem) obj;
                        if (unreadItem != null) {
                            if (unreadItem.getMentionCount() > 0) {
                                return new Indicator(0, first);
                            }
                            if (z3 && !z2 && i == -1 && unreadItem.isUnread()) {
                                i = first;
                            }
                        }
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                } else {
                    i = -1;
                }
                if (i != -1) {
                    return new Indicator(1, i);
                }
                return null;
            }

            public static /* synthetic */ Model get$default(Companion companion, Ranges2 ranges2, List list, boolean z2, int i, Object obj) {
                if ((i & 4) != 0) {
                    z2 = true;
                }
                return companion.get(ranges2, list, z2);
            }

            private final boolean hasUnread(List<? extends Object> list, Ranges2 ranges2) {
                List listSlice = _Collections.slice(list, ranges2);
                if (!(listSlice instanceof Collection) || !listSlice.isEmpty()) {
                    for (Object obj : listSlice) {
                        if (!(obj instanceof UnreadItem)) {
                            obj = null;
                        }
                        UnreadItem unreadItem = (UnreadItem) obj;
                        if (unreadItem != null && unreadItem.isUnread()) {
                            return true;
                        }
                    }
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Model get(Ranges2 visibleRange, List<? extends Object> items, boolean unreadsEnabled) {
                boolean z2;
                Intrinsics3.checkNotNullParameter(visibleRange, "visibleRange");
                Intrinsics3.checkNotNullParameter(items, "items");
                if (unreadsEnabled) {
                    try {
                        z2 = hasUnread(items, visibleRange);
                    } catch (IndexOutOfBoundsException unused) {
                        return new Model(null, null, 3, null);
                    }
                }
                return new Model(findIndicator(items, _Ranges.until(0, visibleRange.getFirst()), z2, unreadsEnabled), findIndicator(items, _Ranges.downTo(Collections2.getLastIndex(items), visibleRange.getLast() + 1), z2, unreadsEnabled));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetChannelListUnreads.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "", "", "component1", "()I", "component2", "type", "index", "copy", "(II)Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$Model$Indicator;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "getType", "<init>", "(II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Indicator {
            private final int index;
            private final int type;

            public Indicator(int i, int i2) {
                this.type = i;
                this.index = i2;
            }

            public static /* synthetic */ Indicator copy$default(Indicator indicator, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = indicator.type;
                }
                if ((i3 & 2) != 0) {
                    i2 = indicator.index;
                }
                return indicator.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getType() {
                return this.type;
            }

            /* renamed from: component2, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Indicator copy(int type, int index) {
                return new Indicator(type, index);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Indicator)) {
                    return false;
                }
                Indicator indicator = (Indicator) other;
                return this.type == indicator.type && this.index == indicator.index;
            }

            public final int getIndex() {
                return this.index;
            }

            public final int getType() {
                return this.type;
            }

            public int hashCode() {
                return (this.type * 31) + this.index;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Indicator(type=");
                sbU.append(this.type);
                sbU.append(", index=");
                return outline.B(sbU, this.index, ")");
            }
        }

        public Model() {
            this(null, null, 3, null);
        }

        public Model(Indicator indicator, Indicator indicator2) {
            this.topIndicator = indicator;
            this.bottomIndicator = indicator2;
        }

        public static /* synthetic */ Model copy$default(Model model, Indicator indicator, Indicator indicator2, int i, Object obj) {
            if ((i & 1) != 0) {
                indicator = model.topIndicator;
            }
            if ((i & 2) != 0) {
                indicator2 = model.bottomIndicator;
            }
            return model.copy(indicator, indicator2);
        }

        /* renamed from: component1, reason: from getter */
        public final Indicator getTopIndicator() {
            return this.topIndicator;
        }

        /* renamed from: component2, reason: from getter */
        public final Indicator getBottomIndicator() {
            return this.bottomIndicator;
        }

        public final Model copy(Indicator topIndicator, Indicator bottomIndicator) {
            return new Model(topIndicator, bottomIndicator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.topIndicator, model.topIndicator) && Intrinsics3.areEqual(this.bottomIndicator, model.bottomIndicator);
        }

        public final Indicator getBottomIndicator() {
            return this.bottomIndicator;
        }

        public final Indicator getTopIndicator() {
            return this.topIndicator;
        }

        public int hashCode() {
            Indicator indicator = this.topIndicator;
            int iHashCode = (indicator != null ? indicator.hashCode() : 0) * 31;
            Indicator indicator2 = this.bottomIndicator;
            return iHashCode + (indicator2 != null ? indicator2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(topIndicator=");
            sbU.append(this.topIndicator);
            sbU.append(", bottomIndicator=");
            sbU.append(this.bottomIndicator);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ Model(Indicator indicator, Indicator indicator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : indicator, (i & 2) != 0 ? null : indicator2);
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "", "", "getMentionCount", "()I", "mentionCount", "", "isUnread", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface UnreadItem {
        int getMentionCount();

        boolean isUnread();
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$handleVisibleRangeUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model.Indicator $indicator;
        public final /* synthetic */ boolean $indicatorUpwards;

        public AnonymousClass1(Model.Indicator indicator, boolean z2) {
            this.$indicator = indicator;
            this.$indicatorUpwards = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelListUnreads.access$handleClick(WidgetChannelListUnreads.this, this.$indicator, this.$indicatorUpwards);
        }
    }

    /* compiled from: WidgetChannelListUnreads.kt */
    @DebugMetadata(c = "com.discord.widgets.channels.list.WidgetChannelListUnreads$onDatasetChanged$1", f = "WidgetChannelListUnreads.kt", l = {74}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$onDatasetChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return WidgetChannelListUnreads.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (f.P(50L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            WidgetChannelListUnreads.access$handleVisibleRangeUpdate(WidgetChannelListUnreads.this);
            return Unit.a;
        }
    }

    public WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0<Integer> function0, int i, int i2, boolean z2) {
        Intrinsics3.checkNotNullParameter(viewStub, "unreadsStub");
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function0, "getItemCount");
        this.unreadsStub = viewStub;
        this.recycler = recyclerView;
        this.appBarLayout = appBarLayout;
        this.getItemCount = function0;
        this.mentionResId = i;
        this.unreadsResId = i2;
        this.unreadsEnabled = z2;
        this.binding = LazyJVM.lazy(new WidgetChannelListUnreads2(this));
        this.data = Collections2.emptyList();
        recyclerView.addOnScrollListener(new AnonymousClass1());
    }

    public static final /* synthetic */ ViewStub access$getUnreadsStub$p(WidgetChannelListUnreads widgetChannelListUnreads) {
        return widgetChannelListUnreads.unreadsStub;
    }

    public static final /* synthetic */ void access$handleClick(WidgetChannelListUnreads widgetChannelListUnreads, Model.Indicator indicator, boolean z2) {
        widgetChannelListUnreads.handleClick(indicator, z2);
    }

    public static final /* synthetic */ void access$handleVisibleRangeUpdate(WidgetChannelListUnreads widgetChannelListUnreads) {
        widgetChannelListUnreads.handleVisibleRangeUpdate();
    }

    private final WidgetChannelsListUnreadsBinding getBinding() {
        return (WidgetChannelsListUnreadsBinding) this.binding.getValue();
    }

    private final int getIcon(Model.Indicator indicator) {
        return indicator.getType() != 0 ? R.drawable.drawable_button_grey : R.drawable.drawable_button_red;
    }

    private final int getText(Model.Indicator indicator) {
        return indicator.getType() != 0 ? this.unreadsResId : this.mentionResId;
    }

    private final void handleClick(Model.Indicator indicator, boolean z2) {
        AppBarLayout appBarLayout;
        int iMax = z2 ? Math.max(indicator.getIndex() - 3, 0) : Math.min(indicator.getIndex() + 3, this.getItemCount.invoke().intValue() - 1);
        if (!z2 && (appBarLayout = this.appBarLayout) != null) {
            appBarLayout.setExpanded(false);
        }
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            this.recycler.scrollToPosition(iMax);
        } else {
            this.recycler.smoothScrollToPosition(iMax);
        }
    }

    private final void handleVisibleRangeUpdate() {
        RecyclerView.LayoutManager layoutManager = this.recycler.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            Model model = Model.INSTANCE.get(new Ranges2(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()), this.data, this.unreadsEnabled);
            Model.Indicator topIndicator = model.getTopIndicator();
            if (topIndicator == null) {
                topIndicator = model.getBottomIndicator();
            }
            boolean z2 = model.getTopIndicator() != null;
            if (topIndicator == null && this.unreadsInitialized) {
                ViewExtensions.fadeOut$default(getBinding().a, 150L, null, null, 6, null);
            } else if (topIndicator != null) {
                ViewExtensions.fadeIn$default(getBinding().a, 150L, null, null, null, 14, null);
                getBinding().a.setOnClickListener(new AnonymousClass1(topIndicator, z2));
                this.unreadsInitialized = true;
                onConfigureView(topIndicator, z2);
            }
        }
    }

    private final void onConfigureView(Model.Indicator indicator, boolean indicatorUpwards) {
        getBinding().c.setBackgroundResource(getIcon(indicator));
        getBinding().f2300b.setText(getText(indicator));
        TextView textView = getBinding().f2300b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListUnreads");
        DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, 0, indicatorUpwards ? R.drawable.ic_arrow_upward_white_16dp : R.drawable.ic_arrow_downward_white_16dp, 0, 11, (Object) null);
        FrameLayout frameLayout = getBinding().a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "it");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) marginLayoutParams;
            LayoutParamsExtensions.removeRuleCompat(layoutParams2, indicatorUpwards ? 8 : 6);
            layoutParams2.addRule(indicatorUpwards ? 6 : 8, this.recycler.getId());
        } else {
            if (!(marginLayoutParams instanceof CoordinatorLayout.LayoutParams)) {
                throw new IllegalStateException("Unread Layout Params unrecognized");
            }
            CoordinatorLayout.LayoutParams layoutParams3 = (CoordinatorLayout.LayoutParams) marginLayoutParams;
            layoutParams3.anchorGravity = indicatorUpwards ? 48 : 80;
            layoutParams3.gravity = indicatorUpwards ? 80 : 48;
        }
        FrameLayout frameLayout2 = getBinding().a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.root");
        frameLayout2.setLayoutParams(marginLayoutParams);
        FrameLayout frameLayout3 = getBinding().a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.root");
        frameLayout3.setImportantForAccessibility(4);
    }

    public final int getMentionResId() {
        return this.mentionResId;
    }

    public final boolean getUnreadsEnabled() {
        return this.unreadsEnabled;
    }

    public final int getUnreadsResId() {
        return this.unreadsResId;
    }

    public final void onDatasetChanged(List<? extends Object> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.data = data;
        CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(this.recycler);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    public final void setMentionResId(int i) {
        this.mentionResId = i;
    }

    public final void setUnreadsEnabled(boolean z2) {
        this.unreadsEnabled = z2;
    }

    public final void setUnreadsResId(int i) {
        this.unreadsResId = i;
    }

    public /* synthetic */ WidgetChannelListUnreads(ViewStub viewStub, RecyclerView recyclerView, AppBarLayout appBarLayout, Function0 function0, int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub, recyclerView, (i3 & 4) != 0 ? null : appBarLayout, function0, (i3 & 16) != 0 ? R.string.new_mentions : i, (i3 & 32) != 0 ? R.string.new_unreads : i2, (i3 & 64) != 0 ? true : z2);
    }
}

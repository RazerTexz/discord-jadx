package com.discord.widgets.chat.input.expression;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.chat.input.ExpressionPickerItemDecoration;
import d0.g0.Indent;
import d0.t.Collections2;
import d0.t.SetsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.a.OnSubscribeLift;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetExpressionPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003MNOB\u001f\u0012\u0006\u0010J\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0000H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020>8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u000e¨\u0006P"}, d2 = {"Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/utilities/views/StickyHeaderItemDecoration$StickyHeaderAdapter;", "", "setupScrollObservables", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "data", "setData", "(Ljava/util/List;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "scrollToPosition", "(I)V", "adapter", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "createStickyHeaderViewHolder", "(Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;)Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "Landroid/view/View;", "getAndBindHeaderView", "(I)Landroid/view/View;", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getOnScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setOnScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "", "headerTypes", "Ljava/util/Set;", "getHeaderTypes", "()Ljava/util/Set;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeadersManager;", "stickyHeaderManager", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeadersManager;", "getStickyHeaderManager", "()Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeadersManager;", "setStickyHeaderManager", "(Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeadersManager;)V", "Lkotlin/Function1;", "onScrollPositionListener", "Lkotlin/jvm/functions/Function1;", "getOnScrollPositionListener", "()Lkotlin/jvm/functions/Function1;", "setOnScrollPositionListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/widgets/chat/input/ExpressionPickerItemDecoration;", "itemDecoration", "Lcom/discord/widgets/chat/input/ExpressionPickerItemDecoration;", "getItemDecoration", "()Lcom/discord/widgets/chat/input/ExpressionPickerItemDecoration;", "setItemDecoration", "(Lcom/discord/widgets/chat/input/ExpressionPickerItemDecoration;)V", "Landroidx/recyclerview/widget/GridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "getNumColumns", "()I", "numColumns", "headerIndices", "Ljava/util/List;", "getHeaderIndices", "()Ljava/util/List;", "setHeaderIndices", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/Set;)V", "Companion", "StickyHeaderViewHolder", "StickyHeadersManager", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class WidgetExpressionPickerAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> implements StickyHeaderItemDecoration.StickyHeaderAdapter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int ITEM_TYPE_HEADER = 0;
    public List<Integer> headerIndices;
    private final Set<Integer> headerTypes;
    private ExpressionPickerItemDecoration itemDecoration;
    private RecyclerView.OnScrollListener onScrollListener;
    private Function1<? super Integer, Unit> onScrollPositionListener;
    public StickyHeadersManager stickyHeaderManager;

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$Companion;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "itemSize", "", "defaultNumColumns", "calculateNumOfColumns", "(Landroidx/recyclerview/widget/RecyclerView;FI)I", "margin", "Landroid/content/res/Resources;", "resources", "(IFILandroid/content/res/Resources;)I", "ITEM_TYPE_HEADER", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final int calculateNumOfColumns(int margin, float itemSize, int defaultNumColumns, Resources resources) {
            Intrinsics3.checkNotNullParameter(resources, "resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i = (int) ((displayMetrics.widthPixels - margin) / itemSize);
            if (i != 0) {
                return i;
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("\n          invalid dimensions while calculating numColumns\n          displayMetrics.widthPixels: ");
            sbU.append(displayMetrics.widthPixels);
            sbU.append("\n          total margin marginStart: ");
            sbU.append(margin);
            sbU.append("\n          itemSize: ");
            sbU.append(itemSize);
            sbU.append("\n        ");
            Logger.e$default(appLog, Indent.trimIndent(sbU.toString()), null, null, 6, null);
            return defaultNumColumns;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int calculateNumOfColumns(RecyclerView recyclerView, float itemSize, int defaultNumColumns) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            int marginStart = layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0;
            ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
            int marginEnd = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams2) : 0;
            Resources resources = recyclerView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "recyclerView.resources");
            return calculateNumOfColumns(marginStart + marginEnd, itemSize, defaultNumColumns, resources);
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "data", "", "bind", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface StickyHeaderViewHolder {
        void bind(int position, MGRecyclerDataPayload data);

        View getItemView();
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeadersManager;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "layoutViews", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "stickyHeaderHolder", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "getStickyHeaderHolder", "()Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$StickyHeaderViewHolder;", "Landroid/view/View;", "currentStickyHeaderView", "Landroid/view/View;", "getCurrentStickyHeaderView", "()Landroid/view/View;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class StickyHeadersManager {
        private final View currentStickyHeaderView;
        private final StickyHeaderViewHolder stickyHeaderHolder;

        public StickyHeadersManager(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
            Intrinsics3.checkNotNullParameter(widgetExpressionPickerAdapter, "adapter");
            StickyHeaderViewHolder stickyHeaderViewHolderCreateStickyHeaderViewHolder = widgetExpressionPickerAdapter.createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
            this.stickyHeaderHolder = stickyHeaderViewHolderCreateStickyHeaderViewHolder;
            this.currentStickyHeaderView = stickyHeaderViewHolderCreateStickyHeaderViewHolder.getItemView();
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final StickyHeaderViewHolder getStickyHeaderHolder() {
            return this.stickyHeaderHolder;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            View view = this.currentStickyHeaderView;
            if (view != null) {
                StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, view);
            }
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$onAttachedToRecyclerView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ RecyclerView $recyclerView;

        public AnonymousClass1(RecyclerView recyclerView) {
            this.$recyclerView = recyclerView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            WidgetExpressionPickerAdapter.this.getStickyHeaderManager().layoutViews(this.$recyclerView);
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Emitter;", "", "emitter", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<Unit>> {

        /* compiled from: WidgetExpressionPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter$setupScrollObservables$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02591 extends RecyclerView.OnScrollListener {
            public final /* synthetic */ Emitter $emitter;

            public C02591(Emitter emitter) {
                this.$emitter = emitter;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                this.$emitter.onNext(Unit.a);
            }
        }

        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<Unit> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<Unit> emitter) {
            Intrinsics3.checkNotNullParameter(emitter, "emitter");
            WidgetExpressionPickerAdapter.this.setOnScrollListener(new C02591(emitter));
        }
    }

    /* compiled from: WidgetExpressionPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$setupScrollObservables$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetExpressionPickerAdapter.this.getOnScrollPositionListener().invoke(Integer.valueOf(WidgetExpressionPickerAdapter.this.getLayoutManager().findFirstVisibleItemPosition()));
        }
    }

    public /* synthetic */ WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? SetsJVM.setOf(0) : set);
    }

    private final void setupScrollObservables() {
        Observable observableO = Observable.o(new AnonymousClass1(), Emitter.BackpressureMode.LATEST);
        Observable observableH0 = Observable.h0(new OnSubscribeLift(observableO.j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "Observable\n        .crea…, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableH0), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            getRecycler().addOnScrollListener(onScrollListener);
        }
    }

    public abstract StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter);

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        MGRecyclerDataPayload mGRecyclerDataPayload = getInternalData().get(position);
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        stickyHeadersManager.getStickyHeaderHolder().bind(position, mGRecyclerDataPayload);
        StickyHeadersManager stickyHeadersManager2 = this.stickyHeaderManager;
        if (stickyHeadersManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return stickyHeadersManager2.getCurrentStickyHeaderView();
    }

    public final List<Integer> getHeaderIndices() {
        List<Integer> list = this.headerIndices;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("headerIndices");
        }
        return list;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("headerIndices");
        }
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
            if (itemPosition >= numPrevious.intValue()) {
                break;
            }
        }
        Integer num = numPrevious;
        if (num == null) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("failed to find header position for item in ");
            sbU.append(getClass().getName());
            Logger.w$default(appLog, sbU.toString(), null, 2, null);
        }
        return num;
    }

    public final Set<Integer> getHeaderTypes() {
        return this.headerTypes;
    }

    public final ExpressionPickerItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public abstract GridLayoutManager getLayoutManager();

    public abstract int getNumColumns();

    public final RecyclerView.OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public final Function1<Integer, Unit> getOnScrollPositionListener() {
        return this.onScrollPositionListener;
    }

    public final StickyHeadersManager getStickyHeaderManager() {
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeaderManager");
        }
        return stickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.stickyHeaderManager = new StickyHeadersManager(this);
        recyclerView.addOnLayoutChangeListener(new AnonymousClass1(recyclerView));
    }

    public final void scrollToPosition(int position) {
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            getRecycler().removeOnScrollListener(onScrollListener);
        }
        getLayoutManager().scrollToPositionWithOffset(position, 0);
        RecyclerView.OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            getRecycler().addOnScrollListener(onScrollListener2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<? extends MGRecyclerDataPayload> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.setData(data);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : data) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Integer numValueOf = this.headerTypes.contains(Integer.valueOf(((MGRecyclerDataPayload) obj).getType())) ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        this.headerIndices = arrayList;
        ExpressionPickerItemDecoration expressionPickerItemDecoration = this.itemDecoration;
        if (expressionPickerItemDecoration != null) {
            getRecycler().removeItemDecoration(expressionPickerItemDecoration);
        }
        int numColumns = getNumColumns();
        List<Integer> list = this.headerIndices;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("headerIndices");
        }
        ExpressionPickerItemDecoration expressionPickerItemDecoration2 = new ExpressionPickerItemDecoration(numColumns, list, DimenUtils.dpToPixels(8));
        getRecycler().addItemDecoration(expressionPickerItemDecoration2);
        this.itemDecoration = expressionPickerItemDecoration2;
    }

    public final void setHeaderIndices(List<Integer> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.headerIndices = list;
    }

    public final void setItemDecoration(ExpressionPickerItemDecoration expressionPickerItemDecoration) {
        this.itemDecoration = expressionPickerItemDecoration;
    }

    public final void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public final void setOnScrollPositionListener(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onScrollPositionListener = function1;
    }

    public final void setStickyHeaderManager(StickyHeadersManager stickyHeadersManager) {
        Intrinsics3.checkNotNullParameter(stickyHeadersManager, "<set-?>");
        this.stickyHeaderManager = stickyHeadersManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionPickerAdapter(RecyclerView recyclerView, Set<Integer> set) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(set, "headerTypes");
        this.headerTypes = set;
        this.onScrollPositionListener = WidgetExpressionPickerAdapter2.INSTANCE;
        setupScrollObservables();
    }
}

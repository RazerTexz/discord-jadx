package com.discord.utilities.view.grid;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utils.R;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: FrameGridLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u000698:;<=B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0017¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0007¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H\u0014¢\u0006\u0004\b%\u0010&J+\u0010(\u001a\u00020\u00022\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0007¢\u0006\u0004\b(\u0010\u000fR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R*\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010.R\u0016\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u0006>"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout;", "Landroid/widget/FrameLayout;", "", "removeStaleViews", "()V", "addNecessaryViews", "bindViews", "Lcom/discord/utilities/view/grid/FrameGridLayout$Children;", "getChildren", "()Lcom/discord/utilities/view/grid/FrameGridLayout$Children;", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "onSizeChildView", "sizeChildViews", "(Lkotlin/jvm/functions/Function2;)V", "positionSpec", "layout", "(Landroid/view/View;Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;)Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "measure", "(Landroid/view/View;Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;)V", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "", "Lcom/discord/utilities/view/grid/FrameGridLayout$Data;", "data", "setData", "(Ljava/util/List;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "onBindView", "setOnBindView", "Lcom/discord/utilities/view/grid/FrameGridLayout$SizeCalculator;", "sizeCalculator", "Lcom/discord/utilities/view/grid/FrameGridLayout$SizeCalculator;", "dataset", "Ljava/util/List;", "Lkotlin/jvm/functions/Function2;", "maxLinearViews", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Children", "Data", "DataView", "PositionSpec", "SizeCalculator", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FrameGridLayout extends FrameLayout {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final int DEFAULT_MAX_LINEAR_VIEWS = 3;
    private List<? extends Data> dataset;
    private final int maxLinearViews;
    private Function2<? super View, ? super Data, Unit> onBindView;
    private final SizeCalculator sizeCalculator;

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\f\u001a\u00020\u00002\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$Children;", "", "", "", "Landroid/view/View;", "component1", "()Ljava/util/Map;", "", "component2", "()Ljava/util/List;", "boundChildren", "unboundChildren", "copy", "(Ljava/util/Map;Ljava/util/List;)Lcom/discord/utilities/view/grid/FrameGridLayout$Children;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getBoundChildren", "Ljava/util/List;", "getUnboundChildren", "<init>", "(Ljava/util/Map;Ljava/util/List;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Children {
        private final Map<String, View> boundChildren;
        private final List<View> unboundChildren;

        /* JADX WARN: Multi-variable type inference failed */
        public Children(Map<String, ? extends View> map, List<? extends View> list) {
            Intrinsics3.checkNotNullParameter(map, "boundChildren");
            Intrinsics3.checkNotNullParameter(list, "unboundChildren");
            this.boundChildren = map;
            this.unboundChildren = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Children copy$default(Children children, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                map = children.boundChildren;
            }
            if ((i & 2) != 0) {
                list = children.unboundChildren;
            }
            return children.copy(map, list);
        }

        public final Map<String, View> component1() {
            return this.boundChildren;
        }

        public final List<View> component2() {
            return this.unboundChildren;
        }

        public final Children copy(Map<String, ? extends View> boundChildren, List<? extends View> unboundChildren) {
            Intrinsics3.checkNotNullParameter(boundChildren, "boundChildren");
            Intrinsics3.checkNotNullParameter(unboundChildren, "unboundChildren");
            return new Children(boundChildren, unboundChildren);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Children)) {
                return false;
            }
            Children children = (Children) other;
            return Intrinsics3.areEqual(this.boundChildren, children.boundChildren) && Intrinsics3.areEqual(this.unboundChildren, children.unboundChildren);
        }

        public final Map<String, View> getBoundChildren() {
            return this.boundChildren;
        }

        public final List<View> getUnboundChildren() {
            return this.unboundChildren;
        }

        public int hashCode() {
            Map<String, View> map = this.boundChildren;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            List<View> list = this.unboundChildren;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Children(boundChildren=");
            sbU.append(this.boundChildren);
            sbU.append(", unboundChildren=");
            return outline.L(sbU, this.unboundChildren, ")");
        }
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$Companion;", "", "", "DEFAULT_MAX_LINEAR_VIEWS", "I", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$Data;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "createView", "(Landroid/content/Context;)Landroid/view/View;", "", "getId", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "utils_release"}, k = 1, mv = {1, 4, 2})
    public interface Data {
        View createView(Context context);

        /* renamed from: getId */
        String getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String();
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$DataView;", "", "", "getDataId", "()Ljava/lang/String;", "Lcom/discord/utilities/view/grid/FrameGridLayout$Data;", "data", "", "onBind", "(Lcom/discord/utilities/view/grid/FrameGridLayout$Data;)V", "onRemove", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public interface DataView {

        /* compiled from: FrameGridLayout.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void onRemove(DataView dataView) {
            }
        }

        String getDataId();

        void onBind(Data data);

        void onRemove();
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "", "", "component1", "()I", "component2", "component3", "component4", "left", "top", "right", "bottom", "copy", "(IIII)Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTop", "getLeft", "getRight", "height", "getHeight", "width", "getWidth", "getBottom", "<init>", "(IIII)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PositionSpec {
        private final int bottom;
        private final int height;
        private final int left;
        private final int right;
        private final int top;
        private final int width;

        public PositionSpec(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
            this.width = i3 - i;
            this.height = i4 - i2;
        }

        public static /* synthetic */ PositionSpec copy$default(PositionSpec positionSpec, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = positionSpec.left;
            }
            if ((i5 & 2) != 0) {
                i2 = positionSpec.top;
            }
            if ((i5 & 4) != 0) {
                i3 = positionSpec.right;
            }
            if ((i5 & 8) != 0) {
                i4 = positionSpec.bottom;
            }
            return positionSpec.copy(i, i2, i3, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        public final PositionSpec copy(int left, int top, int right, int bottom) {
            return new PositionSpec(left, top, right, bottom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PositionSpec)) {
                return false;
            }
            PositionSpec positionSpec = (PositionSpec) other;
            return this.left == positionSpec.left && this.top == positionSpec.top && this.right == positionSpec.right && this.bottom == positionSpec.bottom;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PositionSpec(left=");
            sbU.append(this.left);
            sbU.append(", top=");
            sbU.append(this.top);
            sbU.append(", right=");
            sbU.append(this.right);
            sbU.append(", bottom=");
            return outline.B(sbU, this.bottom, ")");
        }
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$SizeCalculator;", "", "", "itemCount", "", "isVertical", "getRowCount", "(IZ)I", "itemIndex", "getItemRow", "(IIZ)I", "layoutWidth", "layoutHeight", "Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "getItemSize", "(IIII)Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "maxLinearViews", "I", "getMaxLinearViews", "()I", "<init>", "(I)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class SizeCalculator {
        private final int maxLinearViews;

        public SizeCalculator(int i) {
            this.maxLinearViews = i;
        }

        private final int getItemRow(int itemIndex, int itemCount, boolean isVertical) {
            if (isVertical) {
                return itemCount <= this.maxLinearViews ? itemIndex : itemIndex / 2;
            }
            if (itemCount <= this.maxLinearViews) {
                return 0;
            }
            return itemIndex % 2;
        }

        private final int getRowCount(int itemCount, boolean isVertical) {
            if (!isVertical) {
                return itemCount <= this.maxLinearViews ? 1 : 2;
            }
            if (itemCount <= this.maxLinearViews) {
                return itemCount;
            }
            return itemCount % 2 == 1 ? (itemCount / 2) + 1 : itemCount / 2;
        }

        public final PositionSpec getItemSize(int layoutWidth, int layoutHeight, int itemCount, int itemIndex) {
            boolean z2 = false;
            boolean z3 = layoutHeight >= layoutWidth;
            int itemRow = getItemRow(itemIndex, itemCount, z3);
            int itemRow2 = getItemRow(itemIndex, itemCount, !z3);
            int rowCount = getRowCount(itemCount, z3);
            int rowCount2 = getRowCount(itemCount, !z3);
            if (itemIndex == itemCount - 1 && itemCount > this.maxLinearViews && itemCount % 2 == 1) {
                z2 = true;
            }
            int i = layoutWidth / rowCount2;
            int i2 = layoutHeight / rowCount;
            int i3 = itemRow * i2;
            int i4 = itemRow2 * i;
            return new PositionSpec(i4, i3, ((z2 && z3) ? i * 2 : i) + i4, ((!z2 || z3) ? i2 : i2 * 2) + i3);
        }

        public final int getMaxLinearViews() {
            return this.maxLinearViews;
        }
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/view/grid/FrameGridLayout$Data;", "Landroid/view/View;", "view", "", "invoke", "(Lcom/discord/utilities/view/grid/FrameGridLayout$Data;Landroid/view/View;)V", "bindView"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.grid.FrameGridLayout$bindViews$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Data, View, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Data data, View view) {
            invoke2(data, view);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Data data, View view) {
            Intrinsics3.checkNotNullParameter(data, "$this$bindView");
            boolean z2 = view instanceof DataView;
            Object obj = view;
            if (!z2) {
                obj = null;
            }
            DataView dataView = (DataView) obj;
            if (dataView != 0) {
                dataView.onBind(data);
                Function2 function2Access$getOnBindView$p = FrameGridLayout.access$getOnBindView$p(FrameGridLayout.this);
                if (function2Access$getOnBindView$p != null) {
                }
            }
        }
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "childBounds", "", "invoke", "(Landroid/view/View;Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.grid.FrameGridLayout$onLayout$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<View, PositionSpec, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, PositionSpec positionSpec) {
            invoke2(view, positionSpec);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, PositionSpec positionSpec) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(positionSpec, "childBounds");
            FrameGridLayout.access$layout(FrameGridLayout.this, view, positionSpec);
        }
    }

    /* compiled from: FrameGridLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;", "childBounds", "", "invoke", "(Landroid/view/View;Lcom/discord/utilities/view/grid/FrameGridLayout$PositionSpec;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.grid.FrameGridLayout$onMeasure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<View, PositionSpec, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, PositionSpec positionSpec) {
            invoke2(view, positionSpec);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, PositionSpec positionSpec) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(positionSpec, "childBounds");
            FrameGridLayout.access$measure(FrameGridLayout.this, view, positionSpec);
        }
    }

    public FrameGridLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public FrameGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FrameGridLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ Function2 access$getOnBindView$p(FrameGridLayout frameGridLayout) {
        return frameGridLayout.onBindView;
    }

    public static final /* synthetic */ PositionSpec access$layout(FrameGridLayout frameGridLayout, View view, PositionSpec positionSpec) {
        return frameGridLayout.layout(view, positionSpec);
    }

    public static final /* synthetic */ void access$measure(FrameGridLayout frameGridLayout, View view, PositionSpec positionSpec) {
        frameGridLayout.measure(view, positionSpec);
    }

    public static final /* synthetic */ void access$setOnBindView$p(FrameGridLayout frameGridLayout, Function2 function2) {
        frameGridLayout.onBindView = function2;
    }

    private final void addNecessaryViews() {
        if (this.dataset.size() > getChildCount()) {
            Iterator<Integer> it = _Ranges.until(getChildCount(), this.dataset.size()).iterator();
            while (it.hasNext()) {
                Data data = this.dataset.get(((Iterators4) it).nextInt());
                Context context = getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                addView(data.createView(context));
            }
        }
    }

    private final void bindViews() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        Children children = getChildren();
        List<? extends Data> list = this.dataset;
        ArrayList<Data> arrayList = new ArrayList();
        for (Object obj : list) {
            if (children.getBoundChildren().keySet().contains(((Data) obj).getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String())) {
                arrayList.add(obj);
            }
        }
        for (Data data : arrayList) {
            anonymousClass1.invoke2(data, children.getBoundChildren().get(data.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String()));
        }
        List<? extends Data> list2 = this.dataset;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (!children.getBoundChildren().keySet().contains(((Data) obj2).getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String())) {
                arrayList2.add(obj2);
            }
        }
        int i = 0;
        for (Object obj3 : arrayList2) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            anonymousClass1.invoke2((Data) obj3, children.getUnboundChildren().get(i));
            i = i2;
        }
    }

    private final Children getChildren() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Ranges2 ranges2Until = _Ranges.until(0, getChildCount());
        ArrayList<KeyEvent.Callback> arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it = ranges2Until.iterator();
        while (it.hasNext()) {
            arrayList2.add(getChildAt(((Iterators4) it).nextInt()));
        }
        for (KeyEvent.Callback callback : arrayList2) {
            Objects.requireNonNull(callback, "null cannot be cast to non-null type com.discord.utilities.view.grid.FrameGridLayout.DataView");
            String dataId = ((DataView) callback).getDataId();
            if (dataId == null) {
                arrayList.add(callback);
            } else {
                map.put(dataId, callback);
            }
        }
        return new Children(map, arrayList);
    }

    private final PositionSpec layout(View view, PositionSpec positionSpec) {
        view.layout(positionSpec.getLeft(), positionSpec.getTop(), positionSpec.getRight(), positionSpec.getBottom());
        return positionSpec;
    }

    private final void measure(View view, PositionSpec positionSpec) {
        view.measure(View.MeasureSpec.makeMeasureSpec(positionSpec.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(positionSpec.getHeight(), BasicMeasure.EXACTLY));
    }

    private final void removeStaleViews() {
        List<? extends Data> list = this.dataset;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Data) it.next()).getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String());
        }
        Set set = _Collections.toSet(arrayList);
        Iterator<Integer> it2 = _Ranges.downTo(getChildCount() - 1, 0).iterator();
        while (it2.hasNext()) {
            int iNextInt = ((Iterators4) it2).nextInt();
            KeyEvent.Callback childAt = getChildAt(iNextInt);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.discord.utilities.view.grid.FrameGridLayout.DataView");
            DataView dataView = (DataView) childAt;
            if (!_Collections.contains(set, dataView.getDataId())) {
                dataView.onRemove();
                removeViewAt(iNextInt);
            }
        }
    }

    private final void sizeChildViews(Function2<? super View, ? super PositionSpec, Unit> onSizeChildView) {
        Iterator<Integer> it = _Ranges.until(0, getChildCount()).iterator();
        while (it.hasNext()) {
            KeyEvent.Callback childAt = getChildAt(((Iterators4) it).nextInt());
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.discord.utilities.view.grid.FrameGridLayout.DataView");
            String dataId = ((DataView) childAt).getDataId();
            Iterator<? extends Data> it2 = this.dataset.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics3.areEqual(it2.next().getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String(), dataId)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                onSizeChildView.invoke(childAt, this.sizeCalculator.getItemSize(getWidth(), getHeight(), getChildCount(), i));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sizeChildViews(new AnonymousClass1());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        sizeChildViews(new AnonymousClass1());
    }

    @MainThread
    public final void setData(List<? extends Data> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.dataset = data;
        removeStaleViews();
        addNecessaryViews();
        bindViews();
    }

    @MainThread
    public final void setOnBindView(Function2<? super View, ? super Data, Unit> onBindView) {
        this.onBindView = onBindView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.dataset = Collections2.emptyList();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.FrameGridLayout, 0, 0);
            Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.FrameGridLayout, 0, 0)");
            this.maxLinearViews = typedArrayObtainStyledAttributes.getInt(R.b.FrameGridLayout_fgl_max_linear_views, 3);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.maxLinearViews = 3;
        }
        this.sizeCalculator = new SizeCalculator(this.maxLinearViews);
    }
}

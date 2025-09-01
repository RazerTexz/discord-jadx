package com.discord.widgets.voice.fullscreen.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.VideoCallGridItemBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.PileView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: VideoCallGridAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002MLB\u008f\u0001\u0012\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100?\u0012\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100?\u0012\u0016\u0010G\u001a\u0012\u0012\b\u0012\u00060Ej\u0002`F\u0012\u0004\u0012\u00020\u00100?\u0012\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0004\u0012\u00020\u001003j\u0002`6\u0012\u001e\u0010H\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0004\u0012\u00020\u001003j\u0002`6\u0012\u0006\u0010I\u001a\u00020\n¢\u0006\u0004\bJ\u0010KJ+\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00101R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00102R.\u00107\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0004\u0012\u00020\u001003j\u0002`68\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0019\u0010:\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010\u001f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010>R\"\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR&\u0010G\u001a\u0012\u0012\b\u0012\u00060Ej\u0002`F\u0012\u0004\u0012\u00020\u00100?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010AR.\u0010H\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u000105\u0012\u0004\u0012\u00020\u001003j\u0002`68\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u00108R\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010D¨\u0006N"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder;", "", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "oldData", "newData", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getDiffUtilCallback", "(Ljava/util/List;Ljava/util/List;)Landroidx/recyclerview/widget/DiffUtil$Callback;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "getItemId", "(I)J", "data", "", "setData", "(Ljava/util/List;)V", "Landroidx/core/view/DisplayCutoutCompat;", "displayCutout", "", "isLandscape", "setDisplayCutout", "(Landroidx/core/view/DisplayCutoutCompat;Z)V", "top", "bottom", "left", "right", "setInsetsForAvoidingCallUiOverlap", "(IIII)V", "controlsVisible", "notifyCallControlsVisibilityChanged", "(Z)V", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder;", "getItemCount", "()I", "holder", "onBindViewHolder", "(Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridViewHolder;I)V", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "callUiInsets", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "Ljava/util/List;", "Landroidx/core/view/DisplayCutoutCompat;", "Lkotlin/Function2;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;", "Lcom/discord/views/calls/StreamQualityCallback;", "onStreamQualityIndicatorShown", "Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSizeLookup", "()Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "Z", "Lkotlin/Function1;", "onParticipantTapped", "Lkotlin/jvm/functions/Function1;", "onParticipantLongClicked", "embeddedActivityParticipantsCount", "I", "", "Lcom/discord/primitives/StreamKey;", "onWatchStreamClicked", "onStreamQualityIndicatorClick", "spanCount", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;I)V", "Companion", "CallUiInsets", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class VideoCallGridAdapter extends RecyclerView.Adapter<VideoCallGridViewHolder> {
    private static final int EMBEDDED_ACTIVITY_VIEW_TYPE = 1;
    private static final int USER_OR_STREAM_VIEW_TYPE = 0;
    private CallUiInsets callUiInsets;
    private boolean controlsVisible;
    private List<? extends CallParticipant> data;
    private DisplayCutoutCompat displayCutout;
    private int embeddedActivityParticipantsCount;
    private final Function1<CallParticipant, Unit> onParticipantLongClicked;
    private final Function1<CallParticipant, Unit> onParticipantTapped;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final int spanCount;
    private final GridLayoutManager.SpanSizeLookup spanSizeLookup;

    /* compiled from: VideoCallGridAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "", "", "component1", "()I", "component2", "component3", "component4", "top", "bottom", "left", "right", "copy", "(IIII)Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getBottom", "getLeft", "getRight", "getTop", "<init>", "(IIII)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CallUiInsets {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public CallUiInsets(int i, int i2, int i3, int i4) {
            this.top = i;
            this.bottom = i2;
            this.left = i3;
            this.right = i4;
        }

        public static /* synthetic */ CallUiInsets copy$default(CallUiInsets callUiInsets, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = callUiInsets.top;
            }
            if ((i5 & 2) != 0) {
                i2 = callUiInsets.bottom;
            }
            if ((i5 & 4) != 0) {
                i3 = callUiInsets.left;
            }
            if ((i5 & 8) != 0) {
                i4 = callUiInsets.right;
            }
            return callUiInsets.copy(i, i2, i3, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        /* renamed from: component2, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        /* renamed from: component3, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: component4, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        public final CallUiInsets copy(int top, int bottom, int left, int right) {
            return new CallUiInsets(top, bottom, left, right);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallUiInsets)) {
                return false;
            }
            CallUiInsets callUiInsets = (CallUiInsets) other;
            return this.top == callUiInsets.top && this.bottom == callUiInsets.bottom && this.left == callUiInsets.left && this.right == callUiInsets.right;
        }

        public final int getBottom() {
            return this.bottom;
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

        public int hashCode() {
            return (((((this.top * 31) + this.bottom) * 31) + this.left) * 31) + this.right;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CallUiInsets(top=");
            sbU.append(this.top);
            sbU.append(", bottom=");
            sbU.append(this.bottom);
            sbU.append(", left=");
            sbU.append(this.left);
            sbU.append(", right=");
            return outline.B(sbU, this.right, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[VideoCallParticipantView.ParticipantData.Type.DEFAULT.ordinal()] = 1;
            iArr[VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING.ordinal()] = 2;
        }
    }

    /* compiled from: VideoCallGridAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"com/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$getDiffUtilCallback$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "getOldListSize", "()I", "getNewListSize", "areContentsTheSame", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter$getDiffUtilCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends DiffUtil.Callback {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        public AnonymousClass1(List list, List list2) {
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual((CallParticipant) this.$oldData.get(oldItemPosition), (CallParticipant) this.$newData.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(((CallParticipant) this.$oldData.get(oldItemPosition)).getId(), ((CallParticipant) this.$newData.get(newItemPosition)).getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$newData.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.$oldData.size();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoCallGridAdapter(Function1<? super CallParticipant, Unit> function1, Function1<? super CallParticipant, Unit> function12, Function1<? super String, Unit> function13, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function2, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function22, int i) {
        Intrinsics3.checkNotNullParameter(function1, "onParticipantTapped");
        Intrinsics3.checkNotNullParameter(function12, "onParticipantLongClicked");
        Intrinsics3.checkNotNullParameter(function13, "onWatchStreamClicked");
        Intrinsics3.checkNotNullParameter(function2, "onStreamQualityIndicatorShown");
        Intrinsics3.checkNotNullParameter(function22, "onStreamQualityIndicatorClick");
        this.onParticipantTapped = function1;
        this.onParticipantLongClicked = function12;
        this.onWatchStreamClicked = function13;
        this.onStreamQualityIndicatorShown = function2;
        this.onStreamQualityIndicatorClick = function22;
        this.spanCount = i;
        this.data = Collections2.emptyList();
        this.callUiInsets = new CallUiInsets(0, 0, 0, 0);
        this.spanSizeLookup = new VideoCallGridAdapter2(this);
    }

    public static final /* synthetic */ List access$getData$p(VideoCallGridAdapter videoCallGridAdapter) {
        return videoCallGridAdapter.data;
    }

    public static final /* synthetic */ void access$setData$p(VideoCallGridAdapter videoCallGridAdapter, List list) {
        videoCallGridAdapter.data = list;
    }

    private final DiffUtil.Callback getDiffUtilCallback(List<? extends CallParticipant> oldData, List<? extends CallParticipant> newData) {
        return new AnonymousClass1(oldData, newData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        CallParticipant callParticipant = this.data.get(position);
        if (!(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
            if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
                return ((CallParticipant.EmbeddedActivityParticipant) callParticipant).getApplication().getId();
            }
            throw new NoWhenBranchMatchedException();
        }
        VideoCallParticipantView.ParticipantData participantData = ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData();
        int iOrdinal = participantData.type.ordinal();
        if (iOrdinal == 0) {
            return participantData.voiceParticipant.getUser().getId();
        }
        if (iOrdinal == 1) {
            return participantData.voiceParticipant.getUser().getId() + 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        CallParticipant callParticipant = this.data.get(position);
        if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
            return 0;
        }
        if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    public final void notifyCallControlsVisibilityChanged(boolean controlsVisible) {
        this.controlsVisible = controlsVisible;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((VideoCallGridViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends CallParticipant> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(getDiffUtilCallback(this.data, data), true);
        Intrinsics3.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(g…a, newData = data), true)");
        this.data = data;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
        int i = 0;
        if (!(data instanceof Collection) || !data.isEmpty()) {
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                if ((((CallParticipant) it.next()) instanceof CallParticipant.EmbeddedActivityParticipant) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        this.embeddedActivityParticipantsCount = i;
    }

    public final void setDisplayCutout(DisplayCutoutCompat displayCutout, boolean isLandscape) {
        this.displayCutout = displayCutout;
        if (isLandscape) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeChanged(0, this.spanCount);
        }
    }

    public final void setInsetsForAvoidingCallUiOverlap(int top, int bottom, int left, int right) {
        this.callUiInsets = new CallUiInsets(top, bottom, left, right);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(VideoCallGridViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof VideoCallGridViewHolder.UserOrStream)) {
            if (holder instanceof VideoCallGridViewHolder.EmbeddedActivity) {
                CallParticipant callParticipant = this.data.get(position);
                Objects.requireNonNull(callParticipant, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.EmbeddedActivityParticipant");
                ((VideoCallGridViewHolder.EmbeddedActivity) holder).configure((CallParticipant.EmbeddedActivityParticipant) callParticipant, this.onParticipantTapped);
                return;
            }
            return;
        }
        VideoCallGridViewHolder.UserOrStream userOrStream = (VideoCallGridViewHolder.UserOrStream) holder;
        CallParticipant callParticipant2 = this.data.get(position);
        Objects.requireNonNull(callParticipant2, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
        userOrStream.configure((CallParticipant.UserOrStreamParticipant) callParticipant2, this.onParticipantTapped, this.onParticipantLongClicked, this.onWatchStreamClicked, this.displayCutout, this.spanCount, this.onStreamQualityIndicatorShown, this.onStreamQualityIndicatorClick, this.callUiInsets, this.controlsVisible);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VideoCallGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.video_call_grid_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) viewInflate;
            Intrinsics3.checkNotNullExpressionValue(new VideoCallGridItemBinding(videoCallParticipantView), "VideoCallGridItemBinding…rent, false\n            )");
            Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "VideoCallGridItemBinding… false\n            ).root");
            return new VideoCallGridViewHolder.UserOrStream(videoCallParticipantView);
        }
        if (viewType != 1) {
            throw new IllegalStateException(outline.q("invalid view type: ", viewType));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.video_call_grid_item_embedded_activity, parent, false);
        int i = R.id.activity_participant_avatars;
        PileView pileView = (PileView) viewInflate2.findViewById(R.id.activity_participant_avatars);
        if (pileView != null) {
            i = R.id.activity_preview_subtitle;
            TextView textView = (TextView) viewInflate2.findViewById(R.id.activity_preview_subtitle);
            if (textView != null) {
                i = R.id.activity_preview_title;
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.activity_preview_title);
                if (textView2 != null) {
                    i = R.id.app_background_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R.id.app_background_image);
                    if (simpleDraweeView != null) {
                        i = R.id.app_background_overlay;
                        View viewFindViewById = viewInflate2.findViewById(R.id.app_background_overlay);
                        if (viewFindViewById != null) {
                            VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding = new VideoCallGridItemEmbeddedActivityBinding((FrameLayout) viewInflate2, pileView, textView, textView2, simpleDraweeView, viewFindViewById);
                            Intrinsics3.checkNotNullExpressionValue(videoCallGridItemEmbeddedActivityBinding, "VideoCallGridItemEmbedde…tInflater, parent, false)");
                            return new VideoCallGridViewHolder.EmbeddedActivity(videoCallGridItemEmbeddedActivityBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}

package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.core.graphics.ColorUtils;
import com.discord.R;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.mmin18.widget.RealtimeBlurView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PrivateCallBlurredGridView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$B\u001d\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b#\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0013\u0010\f\u001a\u00020\u0002*\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013R:\u0010\u0018\u001a&\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00040\u0014j\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0004`\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006("}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/PrivateCallBlurredGridView;", "Landroid/widget/FrameLayout;", "", "isFullWidth", "Lcom/facebook/drawee/view/SimpleDraweeView;", "createGridViewItem", "(Z)Lcom/facebook/drawee/view/SimpleDraweeView;", "", "getColumnSize", "()I", "getMaxShownParticipants", "Landroid/content/res/Resources;", "isLandscape", "(Landroid/content/res/Resources;)Z", "", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "callUsers", "", "configure", "(Ljava/util/List;)V", "Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/UserId;", "Lkotlin/collections/LinkedHashMap;", "gridViewItems", "Ljava/util/LinkedHashMap;", "Ljava/util/List;", "Lcom/github/mmin18/widget/RealtimeBlurView;", "blurView", "Lcom/github/mmin18/widget/RealtimeBlurView;", "Landroid/widget/GridLayout;", "gridView", "Landroid/widget/GridLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class PrivateCallBlurredGridView extends FrameLayout {
    private final RealtimeBlurView blurView;
    private List<StoreVoiceParticipants.VoiceUser> callUsers;
    private final GridLayout gridView;
    private final LinkedHashMap<Long, SimpleDraweeView> gridViewItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallBlurredGridView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.callUsers = Collections2.emptyList();
        RealtimeBlurView realtimeBlurView = new RealtimeBlurView(getContext(), null);
        this.blurView = realtimeBlurView;
        GridLayout gridLayout = new GridLayout(getContext());
        this.gridView = gridLayout;
        this.gridViewItems = new LinkedHashMap<>();
        gridLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        gridLayout.setColumnCount(getColumnSize());
        int alphaComponent = ColorUtils.setAlphaComponent(ColorCompat.getColor(getContext(), R.color.primary_dark_600), (int) 204.0d);
        realtimeBlurView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        realtimeBlurView.setBlurRadius(DimenUtils.dpToPixels(64));
        realtimeBlurView.setOverlayColor(alphaComponent);
        addView(gridLayout);
        addView(realtimeBlurView);
    }

    private final SimpleDraweeView createGridViewItem(boolean isFullWidth) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
        simpleDraweeView.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, isFullWidth ? getColumnSize() : 1, 1.0f)));
        return simpleDraweeView;
    }

    private final int getColumnSize() {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 3 : 2;
    }

    private final int getMaxShownParticipants() {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 4;
    }

    private final boolean isLandscape(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    public final void configure(List<StoreVoiceParticipants.VoiceUser> callUsers) {
        Intrinsics3.checkNotNullParameter(callUsers, "callUsers");
        List listTake = _Collections.take(callUsers, getMaxShownParticipants());
        boolean z2 = listTake.size() == 2;
        boolean z3 = !CollectionExtensions.equals(this.callUsers, callUsers, PrivateCallBlurredGridView2.INSTANCE);
        if (z3) {
            this.gridView.removeAllViews();
        }
        int i = 0;
        for (Object obj : listTake) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) obj;
            boolean z4 = (i == listTake.size() - 1) && (i + (-1)) % 2 != 0;
            LinkedHashMap<Long, SimpleDraweeView> linkedHashMap = this.gridViewItems;
            Long lValueOf = Long.valueOf(voiceUser.getUser().getId());
            SimpleDraweeView simpleDraweeViewCreateGridViewItem = linkedHashMap.get(lValueOf);
            if (simpleDraweeViewCreateGridViewItem == null) {
                simpleDraweeViewCreateGridViewItem = createGridViewItem(z4 || z2);
                linkedHashMap.put(lValueOf, simpleDraweeViewCreateGridViewItem);
            }
            SimpleDraweeView simpleDraweeView = simpleDraweeViewCreateGridViewItem;
            IconUtils.setIcon$default(simpleDraweeView, voiceUser.getUser(), 0, null, null, null, 60, null);
            if (z3) {
                this.gridView.addView(simpleDraweeView);
            }
            i = i2;
        }
        this.callUsers = callUsers;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallBlurredGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.callUsers = Collections2.emptyList();
        RealtimeBlurView realtimeBlurView = new RealtimeBlurView(getContext(), null);
        this.blurView = realtimeBlurView;
        GridLayout gridLayout = new GridLayout(getContext());
        this.gridView = gridLayout;
        this.gridViewItems = new LinkedHashMap<>();
        gridLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        gridLayout.setColumnCount(getColumnSize());
        int alphaComponent = ColorUtils.setAlphaComponent(ColorCompat.getColor(getContext(), R.color.primary_dark_600), (int) 204.0d);
        realtimeBlurView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        realtimeBlurView.setBlurRadius(DimenUtils.dpToPixels(64));
        realtimeBlurView.setOverlayColor(alphaComponent);
        addView(gridLayout);
        addView(realtimeBlurView);
    }

    public /* synthetic */ PrivateCallBlurredGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}

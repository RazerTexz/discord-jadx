package com.discord.widgets.voice.fullscreen.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.view.ViewGroup;
import com.discord.R;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.views.VoiceUserView;
import com.google.android.material.badge.BadgeDrawable;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PrivateCallGridView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+B\u001d\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b*\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u0004\u0018\u00010\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u0010*\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u001f\u0010 R:\u0010%\u001a&\u0012\b\u0012\u00060\"j\u0002`#\u0012\u0004\u0012\u00020\u00040!j\u0012\u0012\b\u0012\u00060\"j\u0002`#\u0012\u0004\u0012\u00020\u0004`$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010'¨\u00060"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/PrivateCallGridView;", "Landroid/widget/TableLayout;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "callUserItem", "Lcom/discord/views/VoiceUserView;", "getAndUpdateCallUserView", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)Lcom/discord/views/VoiceUserView;", "createCallUserView", "()Lcom/discord/views/VoiceUserView;", "", "removeViewsAndSubviews", "()V", "", "callUsers", "getVisibleCallUsers", "(Ljava/util/List;)Ljava/util/List;", "", "isOverflowingParticipants", "(Ljava/util/List;)Z", "", "rowIndex", "Landroid/view/View;", "getOverflowParticipantView", "(Ljava/util/List;I)Landroid/view/View;", "getOneOnOneSpacerView", "getColumnSize", "()I", "getMaxShownParticipants", "Landroid/content/res/Resources;", "isLandscape", "(Landroid/content/res/Resources;)Z", "configure", "(Ljava/util/List;)V", "Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/UserId;", "Lkotlin/collections/LinkedHashMap;", "callUserViews", "Ljava/util/LinkedHashMap;", "Ljava/util/List;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class PrivateCallGridView extends TableLayout {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final int PARTICIPANT_AVATAR_SIZE_DP = 92;

    @Deprecated
    private static final int PARTICIPANT_MARGIN = 2;

    @Deprecated
    private static final int PARTICIPANT_RING_MARGIN = 6;
    private final LinkedHashMap<Long, VoiceUserView> callUserViews;
    private List<StoreVoiceParticipants.VoiceUser> callUsers;

    /* compiled from: PrivateCallGridView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/grid/PrivateCallGridView$Companion;", "", "", "PARTICIPANT_AVATAR_SIZE_DP", "I", "PARTICIPANT_MARGIN", "PARTICIPANT_RING_MARGIN", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallGridView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.callUsers = Collections2.emptyList();
        this.callUserViews = new LinkedHashMap<>();
    }

    private final VoiceUserView createCallUserView() {
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        VoiceUserView voiceUserView = new VoiceUserView(context, null, 0, 6);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        int iDpToPixels = DimenUtils.dpToPixels(2);
        layoutParams.setMargins(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        voiceUserView.setLayoutParams(layoutParams);
        voiceUserView.setAnimateAvatarWhenRinging(true);
        voiceUserView.setFadeWhenDisconnected(true);
        voiceUserView.setAvatarSize(DimenUtils.dpToPixels(92));
        voiceUserView.setRingMargin(DimenUtils.dpToPixels(6));
        return voiceUserView;
    }

    private final VoiceUserView getAndUpdateCallUserView(StoreVoiceParticipants.VoiceUser callUserItem) {
        LinkedHashMap<Long, VoiceUserView> linkedHashMap = this.callUserViews;
        Long lValueOf = Long.valueOf(callUserItem.getUser().getId());
        VoiceUserView voiceUserViewCreateCallUserView = linkedHashMap.get(lValueOf);
        if (voiceUserViewCreateCallUserView == null) {
            voiceUserViewCreateCallUserView = createCallUserView();
            linkedHashMap.put(lValueOf, voiceUserViewCreateCallUserView);
        }
        VoiceUserView voiceUserView = voiceUserViewCreateCallUserView;
        int i = VoiceUserView.j;
        voiceUserView.a(callUserItem, R.dimen.avatar_size_unrestricted);
        voiceUserView.setSelected(false);
        return voiceUserView;
    }

    private final int getColumnSize() {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 3;
    }

    private final int getMaxShownParticipants() {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return isLandscape(resources) ? 6 : 9;
    }

    private final View getOneOnOneSpacerView(List<StoreVoiceParticipants.VoiceUser> callUsers, int rowIndex) {
        if (!(rowIndex == 0 && callUsers.size() == 2)) {
            return null;
        }
        View viewInflate = TableLayout.inflate(getContext(), R.layout.view_private_call_grid_spacer, null);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) viewInflate;
    }

    @SuppressLint({"SetTextI18n"})
    private final View getOverflowParticipantView(List<StoreVoiceParticipants.VoiceUser> callUsers, int rowIndex) {
        if (!(rowIndex == ((int) Math.ceil(((double) getMaxShownParticipants()) / ((double) getColumnSize()))) - 1) || !isOverflowingParticipants(callUsers)) {
            return null;
        }
        View viewInflate = TableLayout.inflate(getContext(), R.layout.view_private_call_grid_overflow, null);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewInflate;
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(DimenUtils.dpToPixels(92), DimenUtils.dpToPixels(92));
        int iDpToPixels = DimenUtils.dpToPixels(2) * 4;
        layoutParams.setMargins(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
        textView.setLayoutParams(layoutParams);
        textView.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + String.valueOf(callUsers.size() - getMaxShownParticipants()));
        return textView;
    }

    private final List<StoreVoiceParticipants.VoiceUser> getVisibleCallUsers(List<StoreVoiceParticipants.VoiceUser> callUsers) {
        return isOverflowingParticipants(callUsers) ? _Collections.take(callUsers, getMaxShownParticipants() - 1) : callUsers;
    }

    private final boolean isLandscape(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    private final boolean isOverflowingParticipants(List<StoreVoiceParticipants.VoiceUser> callUsers) {
        return callUsers.size() > getMaxShownParticipants();
    }

    private final void removeViewsAndSubviews() {
        for (View view : ViewGroup.getChildren(this)) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TableRow");
            ((TableRow) view).removeAllViews();
        }
        removeAllViews();
    }

    public final void configure(List<StoreVoiceParticipants.VoiceUser> callUsers) {
        Intrinsics3.checkNotNullParameter(callUsers, "callUsers");
        if (!CollectionExtensions.equals(this.callUsers, callUsers, PrivateCallGridView2.INSTANCE)) {
            removeViewsAndSubviews();
            int i = 0;
            for (Object obj : _Collections.chunked(getVisibleCallUsers(callUsers), getColumnSize())) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                TableRow tableRow = new TableRow(getContext());
                tableRow.setGravity(17);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    tableRow.addView(getAndUpdateCallUserView((StoreVoiceParticipants.VoiceUser) it.next()));
                }
                View overflowParticipantView = getOverflowParticipantView(callUsers, i);
                if (overflowParticipantView != null) {
                    tableRow.addView(overflowParticipantView);
                }
                View oneOnOneSpacerView = getOneOnOneSpacerView(callUsers, i);
                if (oneOnOneSpacerView != null) {
                    tableRow.addView(oneOnOneSpacerView, 1);
                }
                addView(tableRow);
                i = i2;
            }
        } else {
            Iterator<T> it2 = getVisibleCallUsers(callUsers).iterator();
            while (it2.hasNext()) {
                getAndUpdateCallUserView((StoreVoiceParticipants.VoiceUser) it2.next());
            }
        }
        this.callUsers = callUsers;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.callUsers = Collections2.emptyList();
        this.callUserViews = new LinkedHashMap<>();
    }

    public /* synthetic */ PrivateCallGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}

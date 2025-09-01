package com.discord.views.stages;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ViewStageCardSpeakersBinding;
import b.a.y.o0.SpeakersAdapter;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StageCardSpeakersView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/views/stages/StageCardSpeakersView;", "Landroid/widget/LinearLayout;", "Lb/a/i/v3;", "k", "Lb/a/i/v3;", "binding", "Landroidx/recyclerview/widget/GridLayoutManager;", "m", "Landroidx/recyclerview/widget/GridLayoutManager;", "speakersLayoutManager", "Lb/a/y/o0/c;", "l", "Lb/a/y/o0/c;", "speakersAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageCardSpeakersView extends LinearLayout {
    public static final RecyclerView.ItemDecoration j = new a();

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewStageCardSpeakersBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public final SpeakersAdapter speakersAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    public final GridLayoutManager speakersLayoutManager;

    /* compiled from: StageCardSpeakersView.kt */
    public static final class a extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics3.checkNotNullParameter(rect, "outRect");
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(recyclerView, "parent");
            Intrinsics3.checkNotNullParameter(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            boolean z2 = recyclerView.getChildAdapterPosition(view) >= state.getItemCount() + (-2);
            rect.left = DimenUtils.dpToPixels(4);
            rect.right = DimenUtils.dpToPixels(4);
            rect.bottom = z2 ? 0 : DimenUtils.dpToPixels(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCardSpeakersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_stage_card_speakers, this);
        SpeakersAdapter2 speakersAdapter2 = (SpeakersAdapter2) findViewById(R.id.discovery_speakers_recycler);
        if (speakersAdapter2 == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.discovery_speakers_recycler)));
        }
        ViewStageCardSpeakersBinding viewStageCardSpeakersBinding = new ViewStageCardSpeakersBinding(this, speakersAdapter2);
        Intrinsics3.checkNotNullExpressionValue(viewStageCardSpeakersBinding, "ViewStageCardSpeakersBin…ater.from(context), this)");
        this.binding = viewStageCardSpeakersBinding;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(speakersAdapter2, "binding.discoverySpeakersRecycler");
        SpeakersAdapter speakersAdapter = (SpeakersAdapter) companion.configure(new SpeakersAdapter(speakersAdapter2));
        this.speakersAdapter = speakersAdapter;
        Intrinsics3.checkNotNullExpressionValue(speakersAdapter2, "binding.discoverySpeakersRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(speakersAdapter2.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(speakersAdapter.a);
        this.speakersLayoutManager = gridLayoutManager;
        RecyclerView recycler = speakersAdapter.getRecycler();
        recycler.setLayoutManager(gridLayoutManager);
        recycler.addItemDecoration(j);
        recycler.setHasFixedSize(false);
    }
}

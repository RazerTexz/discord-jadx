package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageCallViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/stage/StageCallViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem;", "", "layout", "adapter", "<init>", "(ILcom/discord/widgets/voice/fullscreen/stage/StageCallAdapter;)V", "Lcom/discord/widgets/voice/fullscreen/stage/DetailsViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/PrestartDetailsViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/MediaViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/SpeakerViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/AudienceHeaderViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/AudienceViewHolder;", "Lcom/discord/widgets/voice/fullscreen/stage/DividerViewHolder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class StageCallViewHolder extends MGRecyclerViewHolder<StageCallAdapter, StageCallItem> {

    /* compiled from: StageCallViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallViewHolder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StageCallAdapter $adapter;

        public AnonymousClass1(StageCallAdapter stageCallAdapter) {
            this.$adapter = stageCallAdapter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (StageCallViewHolder.this.getAdapterPosition() != -1) {
                StageCallAdapter stageCallAdapter = this.$adapter;
                stageCallAdapter.onItemClick$app_productionGoogleRelease(stageCallAdapter.getItem(StageCallViewHolder.this.getAdapterPosition()));
            }
        }
    }

    public /* synthetic */ StageCallViewHolder(int i, StageCallAdapter stageCallAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, stageCallAdapter);
    }

    private StageCallViewHolder(@LayoutRes int i, StageCallAdapter stageCallAdapter) {
        super(i, stageCallAdapter);
        this.itemView.setOnClickListener(new AnonymousClass1(stageCallAdapter));
    }
}

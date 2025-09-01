package com.discord.widgets.voice.fullscreen.stage;

import androidx.recyclerview.widget.GridLayoutManager;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Metadata;

/* compiled from: StageCallAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/discord/widgets/voice/fullscreen/stage/StageCallAdapter$spanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getSpanSize", "(I)I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallAdapter$spanSizeLookup$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallAdapter3 extends GridLayoutManager.SpanSizeLookup {
    public final /* synthetic */ StageCallAdapter this$0;

    public StageCallAdapter3(StageCallAdapter stageCallAdapter) {
        this.this$0 = stageCallAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int position) {
        int type = ((StageCallItem) StageCallAdapter.access$getInternalData$p(this.this$0).get(position)).getType();
        if (type == 1) {
            int iAccess$getNumSpeakers$p = StageCallAdapter.access$getNumSpeakers$p(this.this$0);
            if (iAccess$getNumSpeakers$p != 1) {
                return iAccess$getNumSpeakers$p != 2 ? 4 : 6;
            }
        } else if (type == 3) {
            return 3;
        }
        return 12;
    }
}

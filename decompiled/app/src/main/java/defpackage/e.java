package defpackage;

import android.view.View;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;

/* compiled from: java-style lambda group */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    public e(int i, Object obj, Object obj2) {
        this.j = i;
        this.k = obj;
        this.l = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            ((AttachmentPreviewAdapter.b) this.k).r.selectionAggregator.unselectItem((Attachment) this.l);
            return;
        }
        if (i == 1) {
            AttachmentPreviewAdapter.b bVar = (AttachmentPreviewAdapter.b) this.k;
            bVar.q.invoke(bVar.r.selectionAggregator, (Attachment) this.l);
        } else {
            if (i != 2) {
                throw null;
            }
            ((AttachmentPreviewAdapter.b) this.k).r.selectionAggregator.unselectItem((Attachment) this.l);
        }
    }
}

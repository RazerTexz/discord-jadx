package b.a.a.a0;

import android.view.View;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreStream;

/* compiled from: WidgetGiftAcceptDialog.kt */
/* renamed from: b.a.a.a0.f, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGiftAcceptDialog4 implements View.OnClickListener {
    public final /* synthetic */ ModelGift j;

    public WidgetGiftAcceptDialog4(ModelGift modelGift) {
        this.j = modelGift;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreStream.INSTANCE.getGifting().acceptGift(this.j);
    }
}

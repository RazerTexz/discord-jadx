package b.a.y.j0;

import android.graphics.Bitmap;
import com.discord.utilities.colors.RepresentativeColors2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: StageCallSpeakerView.kt */
/* renamed from: b.a.y.j0.g, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageCallSpeakerView2 extends Lambda implements Function2<Bitmap, String, Unit> {
    public final /* synthetic */ String $colorId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallSpeakerView2(String str) {
        super(2);
        this.$colorId = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Bitmap bitmap, String str) {
        Bitmap bitmap2 = bitmap;
        Intrinsics3.checkNotNullParameter(bitmap2, "bitmap");
        RepresentativeColors2.getUserRepresentativeColors().handleBitmap(this.$colorId, bitmap2, str);
        return Unit.a;
    }
}
